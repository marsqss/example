package example

import org.scalatest.{FlatSpec, Matchers}

import scala.annotation.tailrec

class Get5thElementFromTheEndSpec extends FlatSpec with Matchers with Get5thElementFromTheEnd {
  import Get5thElementFromTheEnd._

  @tailrec
  private def generateLinkedList(size: Int, previousNode: LinkedListNode[Int]): LinkedListNode[Int] = {
    if(size > 0) {
      val newNode = LinkedListNode(size, Some(previousNode))
      generateLinkedList(size - 1, newNode)
    } else previousNode
  }
  val longList = generateLinkedList(7, LinkedListNode(8, None))
  val shortList = generateLinkedList(3, LinkedListNode(4, None))
  val fiveElementsList = generateLinkedList(4, LinkedListNode(5, None))


  "Get5thElementFromTheEnd" should "return node with value 4" in {
    process(longList).contains(4) shouldBe true
  }

  "Get5thElementFromTheEnd" should "return None for a list with less than 5 elements" in {
    process(shortList).isEmpty shouldBe true
  }

  "Get5thElementFromTheEnd" should "return 1 for a list with exactly 5 elements" in {
    process(fiveElementsList).contains(1) shouldBe true
  }
}
