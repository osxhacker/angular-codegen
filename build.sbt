import com.typesafe.sbt.SbtStartScript

import ScalateKeys._


name := "angular-codegen"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.3"

scalacOptions := Seq("-feature", "-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= {
  val akkaVersion = "2.3.0"
  val sprayVersion = "1.3.0"
  Seq(
    "io.spray"            %   "spray-can"     % sprayVersion withSources,
    "io.spray"            %   "spray-routing" % sprayVersion withSources,
    "io.spray"            %   "spray-testkit" % sprayVersion withSources,
	"org.fusesource.scalate" %% "scalate-core" % "1.6.1" withSources,
	"org.fusesource.scalate" %% "scalate-util" % "1.6.1" withSources,
    "com.typesafe.akka"   %%  "akka-actor"    % akkaVersion,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaVersion,
    "org.scalaz"          %%  "scalaz-core"   % "7.0.5" withSources,
    "org.scalaz"          %%  "scalaz-effect" % "7.0.5" withSources,
	"org.typelevel"       %% "scalaz-contrib-210"  % "0.1.5",
	"org.typelevel"       %% "scalaz-contrib-validation" % "0.1.5",
	"junit"               %   "junit"         % "4.11" % "test",
	"org.scalatest"       %%  "scalatest"     % "2.0" % "test"
	)     
}

seq(Revolver.settings: _*)

seq(coffeeSettings: _*)

seq(scalateSettings:_*)

seq(SbtStartScript.startScriptForClassesSettings: _*)

// CoffeeScript generation settings
(resourceManaged in (Compile, CoffeeKeys.coffee)) <<= (resourceManaged in Compile){
  _ / "WEB-INF" / "js"
  }

// Scalate Precompilation and Bindings
scalateTemplateConfig in Compile <<= (sourceDirectory in Compile) { base =>
  Seq(
    TemplateConfig(
      base / "resources" / "partials",
      Seq(
        "import com.iteamsolutions.angular.models._"
      ),
	  Seq.empty[Binding],
	  Some("com.iteamsolutions.angular.partials")
	  )
    )
  }

