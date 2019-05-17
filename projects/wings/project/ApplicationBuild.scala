import sbt._
import Keys._

object ApplicationBuild  {


  def hardCodedLibrarySettings = libraryDependencies ++= hardCodedCommonDependencies ++ importLibDependencies

  lazy val hardCodedCommonDependencies = Seq(

           "org.fusesource.jansi" % "jansi" % "1.4",

               "org.slf4j" % "slf4j-api" % "1.7.25",
               "org.slf4j" % "jul-to-slf4j" % "1.7.25",
               "org.slf4j" % "jcl-over-slf4j" % "1.7.25",

               "ch.qos.logback" % "logback-core" % "1.2.3",
               "ch.qos.logback" % "logback-classic" % "1.2.3",

               "com.typesafe.slick" %% "slick" % "2.1.0",
               "com.typesafe.play" %% "play" % "2.6.20",
               "com.typesafe.play" %% "play-logback" % "2.6.20",

               "mysql" % "mysql-connector-java" % "6.0.4",
               "com.jolbox" % "bonecp" % "0.8.0.RELEASE",

               "org.scalikejdbc" %% "scalikejdbc" % "2.5.0",

               "com.google.inject" % "guice" % "4.1.0",

               "com.typesafe.akka" %% "akka-actor" % "2.5.19",
               "com.typesafe.akka" %% "akka-slf4j" % "2.5.19",
               "com.typesafe.akka" %% "akka-remote" % "2.5.19",
               "com.typesafe.akka" %% "akka-testkit" % "2.5.19",
               "com.github.scopt" %% "scopt" % "3.7.0",


               "com.rabbitmq" % "amqp-client" % "4.1.0",
               "org.mongodb" % "mongo-java-driver" % "3.7.1",
               "com.google.code.findbugs" % "jsr305" % "3.0.2",
               "org.scalatest" %% "scalatest" % "3.0.5",
               "org.scalacheck" %% "scalacheck" % "1.13.5",
               "junit" % "junit" % "4.10" % "test",
               "org.pegdown" % "pegdown" % "1.1.0" % "test",
               "org.apache.httpcomponents" % "httpclient" % "4.5.2"


  )

  lazy val importLibDependencies = Seq(
  )

}

trait DefaultSbtSettings {

  def commonProjectSettings: Seq[Setting[_]] = Seq()

  def WingsDataProjectSettings:Seq[Setting[_]] = Seq() 
  def WingsPlayProjectSettings:Seq[Setting[_]] = Seq() 
  def WingsReadMongoProjectSettings:Seq[Setting[_]] = Seq() 
  def WingsMongoProjectSettings:Seq[Setting[_]] = Seq() 
  def WingsStreamProjectSettings:Seq[Setting[_]] = Seq() 
  def WingsDomainProjectSettings:Seq[Setting[_]] = Seq() 
  def WingsQueryProjectSettings:Seq[Setting[_]] = Seq() 


}
