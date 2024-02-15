val scala2Version = "2.13.12"
val scala3Version = "3.3.1"

lazy val core = (project in file("core")) // regular scala code with @native methods
  .dependsOn(native % Runtime) // remove this if `core` is a library, leave choice to end-user
  .settings(
    name := "scala-rust-jni-example",
    version := "0.1.0",

    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test,

    // To make the default compiler and REPL use Dotty
    scalaVersion := scala3Version,

    // To cross compile with Scala 3 and Scala 2
    crossScalaVersions := Seq(scala3Version, scala2Version),

    sbtJniCoreScope := Compile
  )

lazy val native = (project in file("native")) // native code and build script
  .settings(nativeCompile / sourceDirectory := baseDirectory.value)
  .enablePlugins(JniNative) // JniNative needs to be explicitly enabled
