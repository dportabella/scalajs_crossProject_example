name := "Bar root project"

// shadow sbt-scalajs' crossProject and CrossType from Scala.js 0.6.x
import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

val sharedSettings = Seq(scalaVersion := "2.11.12")

lazy val app =
  // select supported platforms
  crossProject(JSPlatform, JVMPlatform, NativePlatform)
    .crossType(CrossType.Pure) // [Pure, Full, Dummy], default: CrossType.Full
    .settings(sharedSettings)
    .jsSettings(   // defined in sbt-scalajs-crossproject
      libraryDependencies ++= Seq(
        "com.lihaoyi" %%% "scalatags" % "0.6.2",
        "com.lihaoyi" %%% "upickle" % "0.4.4",
        "org.scala-js" %%% "scalajs-dom" % "0.9.1"
      )
    )
    .jvmSettings(
      libraryDependencies ++= Seq(
        "com.lihaoyi" %%% "scalatags" % "0.6.2",
        "com.lihaoyi" %%% "upickle" % "0.4.4",
        "com.typesafe.akka" %% "akka-http-experimental" % "2.4.11",
        "com.typesafe.akka" %% "akka-actor" % "2.4.12",
        "org.webjars" % "bootstrap" % "3.2.0"
      )
    )
    // configure Scala-Native settings
    .nativeSettings() // defined in sbt-scala-native

// Optional in sbt 1.x (mandatory in sbt 0.13.x)
lazy val appJS     = app.js
lazy val appJVM    = app.jvm
lazy val appNative = app.native
