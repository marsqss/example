package example

import example.Get5thElementFromTheEnd.LinkedListNode

import scala.annotation.tailrec

object Get5thElementFromTheEnd {
  case class LinkedListNode[T](value: T, next: Option[LinkedListNode[T]])
}

trait Get5thElementFromTheEnd {
  /**
    * If the linked list contains more than 4 elements, then it returns the 5th element from the end
    * @param node First Node of linked list
    * @tparam T the value of the 5th element from the end of the linked list
    * @return Option with Some if list.length > 4 and None otherwise
    */
  def process[T](node: LinkedListNode[T]): Option[T] = {
    // Align to the 'initial' Nth element
    @tailrec
    def getAlignToInitialNth(currentNode: LinkedListNode[T], remainingN: Int, lastN: Option[LinkedListNode[T]]): Option[LinkedListNode[T]] = {
      if(remainingN > 1) {
        if(currentNode.next.isDefined)
          getAlignToInitialNth(currentNode.next.get, remainingN - 1, lastN)
        else
          None
      } else {
        if(currentNode.next.isDefined) {
          getAlignToInitialNth(currentNode.next.get, remainingN, lastN.map(_.next.get))
        } else
          lastN
      }
    }

    getAlignToInitialNth(node, 5, Some(node)).map(_.value)
  }
}
