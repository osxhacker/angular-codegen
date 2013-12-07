name := "angular-codegen"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  cache
)     

play.Project.playScalaSettings

com.jamesward.play.BrowserNotifierPlugin.livereload

