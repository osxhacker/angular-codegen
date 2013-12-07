name := "angular-codegen"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.0.3" withSources,
  cache
)     

play.Project.playScalaSettings

com.jamesward.play.BrowserNotifierPlugin.livereload

