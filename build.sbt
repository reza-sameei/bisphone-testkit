// in the name of ALLAH

organization := "com.bisphone"

name := "testkit"

version := "0.4.2"

scalaVersion := "2.11.11"

crossScalaVersions := Seq("2.11.12", "2.12.6")

val akkaVersion = "2.5.6"

libraryDependencies ++= Seq(
        "org.scalatest" %% "scalatest" % "3.0.4"
    ,   "com.bisphone" %% "std" % "0.13.0"
    ,   "com.typesafe.akka" %% "akka-testkit" % akkaVersion
    ,   "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion
)
