name := "angular-codegen"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= {
  val akkaVersion = "2.2.3"
  val sprayVersion = "1.2.0"
  Seq(
    "io.spray"            %   "spray-can"     % sprayVersion,
    "io.spray"            %   "spray-routing" % sprayVersion,
    "io.spray"            %   "spray-testkit" % sprayVersion,
    "com.typesafe.akka"   %%  "akka-actor"    % akkaVersion,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaVersion,
	"org.scalatest"       %% "scalatest"      % "2.0" % "test",
    "org.scalaz"          %% "scalaz-core"    % "7.0.5" withSources
	)     
}

seq(Revolver.settings: _*)

seq(coffeeSettings: _*)

