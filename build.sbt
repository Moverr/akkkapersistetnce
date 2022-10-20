ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "banger"
  )

val AkkaVersion = "2.6.20"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed"         % AkkaVersion,
  "com.typesafe.akka" %% "akka-persistence-typed"   % AkkaVersion,
  "com.typesafe.akka" %% "akka-persistence-testkit" % AkkaVersion % Test,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test
)
