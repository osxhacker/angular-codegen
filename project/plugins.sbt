// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository 
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.2.0")

// This plugin enables SBT to produce a dependency graph for the jars used
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")

// For Play resource auto-refresh support in Chrome
addSbtPlugin("com.jamesward" %% "play-auto-refresh" % "0.0.6")

