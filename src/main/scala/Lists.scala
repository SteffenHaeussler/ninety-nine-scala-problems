package ninetynine

import scala.collection.mutable.ListBuffer

/** Problem 01 Get last item of a list */
def last(lst: List[Any]): Any =
    return lst.last

/** P02 (*) Find the last but one element of a list */
def penultimate(lst: List[Any]): Any =
    if lst.length < 1 then
        throw new NoSuchElementException
    else
        return lst(lst.length-2)

/** P03 (*) Find the Kth element of a list */
def nth(i: Int, lst: List[Any]): Any =
    if lst.length <= i then
        throw new NoSuchElementException
    else
        return lst(i)


/** P04 (*) Find the number of elements of a list. */
def length(lst: List[Any]): Int =
    var count = 0
    for
        i <- lst
    do
        count += 1
    return count


/** P05 (*) Reverse a list. */
def reverse(lst: List[Any]): List[Any] =
    return lst.reverse


/** P06 (*) Find out whether a list is a palindrome. */
def isPalindrome(lst: List[Any]): Boolean =
    return lst.reverse == lst


/** P07 (**) Flatten a nested list structure. */
def flatten(lst: List[Any]): List[Any] =
    lst flatMap {
        case i: List[_] => flatten(i)
        case e => List(e)
    }


/**  Eliminate consecutive duplicates of list elements. */
def compress(lst: List[Any]): List[Any] =
    lst.foldLeft(List[Any]()){
        case (_lst, i) if (_lst.isEmpty || _lst.last != i) => _lst ::: List(i)
        case (_lst, i) => _lst
    }

/**  P09 (**) Pack consecutive duplicates of list elements into sublists. */
def pack(lst: List[Any]): List[List[Any]] =
    if (lst.isEmpty) List(List())
    else {
        val (head, tail) = lst span {_ == lst.head}
        if (tail == Nil) List(head)
        else head :: pack(tail)
    }


// /**  P10 (*) Run-length encoding of a list. */
def encode(lst: List[Any]): List[(Integer, Any)] =
    pack(lst) map {i => (i.length, i.head)}
