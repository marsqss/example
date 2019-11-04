package example

object TriangleClassifier extends TriangleClassifier {
  case class Triangle(side1: Double, side2: Double, side3: Double)

  trait TriangleClassification
  case object Equilateral extends TriangleClassification
  case object Isosceles extends TriangleClassification
  case object Scalene extends TriangleClassification
}

trait TriangleClassifier {
  import TriangleClassifier._

  def classifyTriangle(triangle: Triangle): TriangleClassification = {
    if ((triangle.side1 == triangle.side2) && (triangle.side1 == triangle.side3))
      Equilateral
    else if ((triangle.side1 == triangle.side2) || (triangle.side1 == triangle.side2) || (triangle.side2 == triangle.side3))
      Isosceles
    else
      Scalene
  }
}