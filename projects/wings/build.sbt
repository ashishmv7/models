ThisBuild / resolvers  += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

ThisBuild / resolvers  += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

ThisBuild / maxErrors := 10

ThisBuild / shellPrompt := { s => "[" + Project.extract(s).currentProject.id + "] "}

parallelExecution in Test in Global := false

// testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-h", (target.value / "test-report").getAbsolutePath)

// smile - dont edit anything below.


import ApplicationBuild._

  val appName = "Wings"

  val prepareTaskKey = TaskKey[Unit]("prepare", "Creates the intermediate(xml) file")
  val generateTaskKey = TaskKey[Unit]("generate", "Create code files")

   def filePathMap(f: File) = (f ** "*") pair Path.relativeTo(f.getParentFile)

ThisBuild / libraryDependencies += guice

val akkaVersion = "2.5.19"

ThisBuild / dependencyOverrides ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-protobuf" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6",
  "com.google.guava" % "guava" % "22.0",
  "org.slf4j" % "slf4j-api" % "1.7.25",
  "com.google.code.findbugs" %"jsr305" % "3.0.2",
  "com.typesafe" % "config" % "1.3.3",
  "joda-time" % "joda-time" % "2.9.9",
  "commons-codec" % "commons-codec" % "1.10",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.11.1",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.8.11",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.8.11"
)

   lazy val root = com.iteration3.relax.rsbt.RootProject(appName, file("."), prepareTaskKey, generateTaskKey)
    .enablePlugins(play.sbt.PlayScala)
    .settings(libraryDependencies += filters)
    .settings(updateOptions := updateOptions.value.withCachedResolution(true))
    .settings(aggregate in update := false)
    .settings((Universal / stage) :=  {com.iteration3.relax.rsbt.Commands.createSmileStarter(); ( Universal / stage).value})
    .settings(bashScriptExtraDefines += """addJava "-Dsmile.staging=true"""")
    .settings(bashScriptConfigLocation := Some((baseDirectory.value / "conf" / "jvmopts").getAbsolutePath))
    .settings( Universal / mappings ++= { Seq() ++ filePathMap(WingsDataProject.base / "conf")++ filePathMap(WingsPlayProject.base / "conf")++ filePathMap(WingsReadMongoProject.base / "conf")++ filePathMap(WingsMongoProject.base / "conf")++ filePathMap(WingsStreamProject.base / "conf")++ filePathMap(WingsDomainProject.base / "conf")++ filePathMap(WingsQueryProject.base / "conf")
      })
    .settings(hardCodedLibrarySettings: _*)
    .settings(SbtSettings.commonProjectSettings: _*)
    .settings(update / aggregate := false)
    .settings(generateTaskKey := (generateTaskKey dependsOn (WingsDataProject / generateTaskKey)).value)
    .settings(generateTaskKey := (generateTaskKey dependsOn (WingsPlayProject / generateTaskKey)).value)
    .settings(generateTaskKey := (generateTaskKey dependsOn (WingsReadMongoProject / generateTaskKey)).value)
    .settings(generateTaskKey := (generateTaskKey dependsOn (WingsMongoProject / generateTaskKey)).value)
    .settings(generateTaskKey := (generateTaskKey dependsOn (WingsStreamProject / generateTaskKey)).value)
    .settings(generateTaskKey := (generateTaskKey dependsOn (WingsDomainProject / generateTaskKey)).value)
    .settings(generateTaskKey := (generateTaskKey dependsOn (WingsQueryProject / generateTaskKey)).value)
    .aggregate(WingsDataProject,WingsPlayProject,WingsReadMongoProject,WingsMongoProject,WingsStreamProject,WingsDomainProject,WingsQueryProject)
    .dependsOn(WingsDataProject,WingsPlayProject,WingsReadMongoProject,WingsMongoProject,WingsStreamProject,WingsDomainProject,WingsQueryProject)


        lazy val WingsPlayProject:sbt.Project = com.iteration3.relax.rsbt.PlayProject("WingsPlay", file("modules/wings/WingsPlay"), prepareTaskKey, generateTaskKey)
            .enablePlugins(play.sbt.PlayScala)
            .settings(generateTaskKey := (generateTaskKey dependsOn (WingsDataProject / generateTaskKey)).value )
            .settings(hardCodedLibrarySettings: _*)
            .settings(SbtSettings.commonProjectSettings: _*)
            .settings(SbtSettings.WingsPlayProjectSettings:_*)
            .dependsOn(WingsDataProject) 


        lazy val WingsDataProject:sbt.Project = com.iteration3.relax.rsbt.SbtProject("WingsData", file("modules/wings/WingsData"), prepareTaskKey, generateTaskKey)
            .settings(com.iteration3.relax.rsbt.DataTasks.taskList("WingsData"): _*)
            .settings(hardCodedLibrarySettings: _*)
            .settings(SbtSettings.commonProjectSettings: _*)
            .settings(SbtSettings.WingsDataProjectSettings:_*)
            .dependsOn() 
        lazy val WingsReadMongoProject:sbt.Project = com.iteration3.relax.rsbt.SbtProject("WingsReadMongo", file("modules/wings/WingsReadMongo"), prepareTaskKey, generateTaskKey)
            .settings(generateTaskKey := (generateTaskKey dependsOn (WingsDataProject / generateTaskKey)).value )
            .settings(com.iteration3.relax.rsbt.MongoTasks.taskList("WingsReadMongo"): _*)
            .settings(hardCodedLibrarySettings: _*)
            .settings(SbtSettings.commonProjectSettings: _*)
            .settings(SbtSettings.WingsReadMongoProjectSettings:_*)
            .dependsOn(WingsDataProject) 
        lazy val WingsMongoProject:sbt.Project = com.iteration3.relax.rsbt.SbtProject("WingsMongo", file("modules/wings/WingsMongo"), prepareTaskKey, generateTaskKey)
            .settings(generateTaskKey := (generateTaskKey dependsOn (WingsDataProject / generateTaskKey)).value )
            .settings(com.iteration3.relax.rsbt.MongoTasks.taskList("WingsMongo"): _*)
            .settings(hardCodedLibrarySettings: _*)
            .settings(SbtSettings.commonProjectSettings: _*)
            .settings(SbtSettings.WingsMongoProjectSettings:_*)
            .dependsOn(WingsDataProject) 
        lazy val WingsStreamProject:sbt.Project = com.iteration3.relax.rsbt.SbtProject("WingsStream", file("modules/wings/WingsStream"), prepareTaskKey, generateTaskKey)
            .settings(com.iteration3.relax.rsbt.StreamTasks.taskList("WingsStream"): _*)
            .settings(hardCodedLibrarySettings: _*)
            .settings(SbtSettings.commonProjectSettings: _*)
            .settings(SbtSettings.WingsStreamProjectSettings:_*)
            .dependsOn() 
        lazy val WingsDomainProject:sbt.Project = com.iteration3.relax.rsbt.SbtProject("WingsDomain", file("modules/wings/WingsDomain"), prepareTaskKey, generateTaskKey)
            .settings(generateTaskKey := (generateTaskKey dependsOn (WingsStreamProject / generateTaskKey)).value )
            .settings(generateTaskKey := (generateTaskKey dependsOn (WingsMongoProject / generateTaskKey)).value )
            .settings(com.iteration3.relax.rsbt.DomainTasks.taskList("WingsDomain"): _*)
            .settings(hardCodedLibrarySettings: _*)
            .settings(SbtSettings.commonProjectSettings: _*)
            .settings(SbtSettings.WingsDomainProjectSettings:_*)
            .dependsOn(WingsStreamProject,WingsMongoProject) 
        lazy val WingsQueryProject:sbt.Project = com.iteration3.relax.rsbt.SbtProject("WingsQuery", file("modules/wings/WingsQuery"), prepareTaskKey, generateTaskKey)
            .settings(generateTaskKey := (generateTaskKey dependsOn (WingsStreamProject / generateTaskKey)).value )
            .settings(generateTaskKey := (generateTaskKey dependsOn (WingsReadMongoProject / generateTaskKey)).value )
            .settings(com.iteration3.relax.rsbt.QueryTasks.taskList("WingsQuery"): _*)
            .settings(hardCodedLibrarySettings: _*)
            .settings(SbtSettings.commonProjectSettings: _*)
            .settings(SbtSettings.WingsQueryProjectSettings:_*)
            .dependsOn(WingsStreamProject,WingsReadMongoProject) 




