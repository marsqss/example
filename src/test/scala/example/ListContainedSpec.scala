package example

import org.scalatest.{FlatSpec, Matchers}

class ListIntersectSpec extends FlatSpec with Matchers {
  val list1 = List(1,2,3,4,5)
  val list2 = List(1,2,3,4,5,6)
  val list3 = List(1,8,3,8,9)

  "ListIntersect" should "return true for first list included in the 2nd list" in {
    import example.ListContained._

    list1.isContainedIn(list2) shouldBe true
  }

  "ListIntersect" should "return false for first list included in the 2nd list" in {
    import example.ListContained._

    list2.isContainedIn(list1) shouldBe false
  }

  "ListIntersect" should "return true because list1 is included in list2" in {
    import example.ListsContained._
    list2.oneIsContainedIn(list1) shouldBe true
  }

  "ListIntersect" should "return true because list2 is included in list1" in {
    import example.ListsContained._
    list1.oneIsContainedIn(list2) shouldBe true
  }

  "ListIntersect" should "return false because list1 is NOT included in list3 or viceversa" in {
    import example.ListsContained._
    list1.oneIsContainedIn(list3) shouldBe false
  }

  "ListIntersect" should "return false because list3 is NOT included in list1 or viceversa" in {
    import example.ListsContained._
    list3.oneIsContainedIn(list1) shouldBe false
  }
}
