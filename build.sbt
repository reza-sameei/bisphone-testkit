// in the name of ALLAH

organization := "com.bisphone"

name := "beta-testkit"

version := "0.1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.6",
  "com.typesafe.akka" %% "akka-testkit" % "2.4.4",
  "com.typesafe.akka" %% "akka-stream-testkit" % "2.4.4"
)
