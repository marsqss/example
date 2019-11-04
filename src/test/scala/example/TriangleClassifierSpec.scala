package example

import org.scalatest._
import example.TriangleClassifier._

class TriangleClassifierSpec extends FlatSpec with Matchers with TriangleClassifier {

  lazy val triangleEquilateral = Triangle(1.2, 1.2, 1.2)
  lazy val triangleIsosceles = Triangle(1.2, 1.2, 1.3)
  lazy val triangleScalene = Triangle(1.1, 1.2, 1.3)

  "TriangleClassifier" should "return Equilateral for" in {
    classifyTriangle(triangleEquilateral) shouldEqual Equilateral
  }

  "TriangleClassifier" should "return Isosceles for" in {
    classifyTriangle(triangleIsosceles) shouldEqual Isosceles
  }

  "TriangleClassifier" should "return Scalene for" in {
    classifyTriangle(triangleScalene) shouldEqual Scalene
  }
}
