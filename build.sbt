val commonSettings = Seq(
  organization := "com.github.gslowikowski.sbt-multimodule-circleci-test",
  version := "1.0.0-SNAPSHOT",
  scalaVersion := "2.12.0",
  crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.0")
)

val moduleSettings = Seq(
  libraryDependencies ++= Seq(
    "com.novocode" % "junit-interface" % "0.11" % "test",
    "org.hamcrest" % "hamcrest-core" % "1.3" % "test"
  )
)


lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "root",
    publishArtifact := false,
    coverageEnabled := false
  )
  .aggregate(module1, module2, module3)

lazy val module1 = (project in file("module1"))
  .settings(commonSettings: _*)
  .settings(moduleSettings: _*)
  .settings(
    name := "module1"
  )

lazy val module2 = (project in file("module2"))
  .settings(commonSettings: _*)
  .settings(moduleSettings: _*)
  .settings(
    name := "module2"
  )

lazy val module3 = (project in file("module3"))
  .settings(commonSettings: _*)
  .settings(moduleSettings: _*)
  .settings(
    name := "module3"
  )
