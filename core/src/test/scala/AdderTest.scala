import munit.FunSuite

class AdderTest extends FunSuite {
  test("well, it adds") {
    assertEquals(new Adder(1).plus(2), 3)
  }

}
