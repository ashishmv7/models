import sbt._
import Keys._


object SbtSettings extends DefaultSbtSettings {

  override def commonProjectSettings: Seq[Setting[_]] = Seq(
    scalacOptions ++= Seq("-Xfatal-warnings", "-deprecation",  "-Xlint:-missing-interpolator", "-deprecation", "-unchecked", "-feature", "-encoding", "utf8", "-language:reflectiveCalls"),
    javacOptions in Compile ++= Seq("-encoding", "utf8", "-g")

  );



  // overrides the setting for the modules if you need to


}
