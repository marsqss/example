package example

object ListContained {
  implicit class ListContained[A](list1: List[A]) {
    def isContainedIn(list2: List[A]): Boolean = {
      list1.forall(l1e => list2.contains(l1e))
    }
  }
}

object ListsContained {
  implicit class ListsContained[A](list1: List[A]) {
    def oneIsContainedIn(list2: List[A]): Boolean = {
      list1.forall(l1e => list2.contains(l1e))

      var equalsList1 = Map[A, Boolean]()
      var equalsList2 = Map[A, Boolean]()

      for {
        l1e <- list1 if !equalsList1.contains(l1e) // Fast access to a map
        l2e <- list2 if !equalsList2.contains(l2e)
      } {
        if(l1e == l2e) {
          equalsList1 = equalsList1 + (l1e -> true)
          equalsList2 = equalsList2 + (l2e -> true)
        }
      }
      equalsList1.size == list1.size || equalsList2.size == list2.size
    }
  }
}
