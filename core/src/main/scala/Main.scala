// to make the code below work the core project should be included as a dependency via
// sbtJniCoreScope := Compile

import com.github.sbt.jni.syntax.NativeLoader

// By adding this annotation, there is no need to call
// System.load("adder0") before accessing native methods.
class Adder(val base: Int) extends NativeLoader("native") {
  @native def plus(term: Int): Int // implemented in libadder0.so
}

// The application feels like a pure Scala app.
@main def main: Unit = println(new Adder(10).plus(100))
