import org.junit.Test
import org.junit.Assert._

import ninetynine._

class TestLast:
    @Test def t1(): Unit =
    assertEquals(last(List(1, 1, 2, 3, 5, 8)), 8)
    assertEquals(last(List("a", 2.2, "b")), "b")
    assertEquals(last(List(true, null, false, true)), true)
    assertEquals(last(List(List(1, 1, 2, 3, 5, 8))), List(1, 1, 2, 3, 5, 8))

class TestPenultimate:
    @Test def t2(): Unit =
    assertEquals(penultimate(List(1, 1, 2, 3, 5, 8)), 5)
    assertEquals(penultimate(List("a", 2.2, "b")), 2.2)
    assertEquals(penultimate(List(true, null, false, true)), false)
    assertEquals(penultimate(List(List(1, 1, 2, 3, 5, 8),
                                    List("a", 2.2, "b"))), List(1, 1, 2, 3, 5, 8))

class TestNth:
    @Test def t3(): Unit =
    assertEquals(nth(2, List(1, 1, 2, 3, 5, 8)), 2)
    assertEquals(nth(0, List("a", 2.2, "b")), "a")
    assertEquals(nth(1, List(true, null, false, true)), null)
    assertEquals(nth(1, List(List(1, 1, 2, 3, 5, 8),
                                    List("a", 2.2, "b"))), List("a", 2.2, "b"))



class TestLength:
    @Test def t4(): Unit =
    assertEquals(length(List(1, 1, 2, 3, 5, 8)), 6)
    assertEquals(length(List("a", 2.2, "b")), 3)
    assertEquals(length(List(true, null, false, true)), 4)
    assertEquals(length(List(List(1, 1, 2, 3, 5, 8),
                                    List("a", 2.2, "b"))), 2)
    assertEquals(length(List()), 0)

class TestRevers:
    @Test def t5(): Unit =
    assertEquals(reverse(List(1, 1, 2, 3, 5, 8)), List(8, 5, 3, 2, 1, 1))
    assertEquals(reverse(List("a", 2.2, "b")), List("b", 2.2, "a"))
    assertEquals(reverse(List(true, null, false, true)), List(true, false, null, true))
    assertEquals(reverse(List(List(1, 1, 2, 3, 5, 8),
                                    List("a", 2.2, "b"))),
                            List(List("a", 2.2, "b"),
                                List(1, 1, 2, 3, 5, 8)))
    assertEquals(reverse(List()), List())


class TestisPalindrome:
    @Test def t6(): Unit =
    assertEquals(isPalindrome(List(1, 2, 3, 2, 1)), true)
    assertEquals(isPalindrome(List("a", 2.2, "b")), false)
    assertEquals(isPalindrome(List(true, false, false, true)), true)
    assertEquals(isPalindrome(List(List(1, 1, 2, 3, 5, 8),
                                    List(8, 5, 3, 2, 1, 1))),
                            false)
    assertEquals(isPalindrome(List()), true)


class TestFlatten:
    @Test def t7(): Unit =
    assertEquals(flatten(List(List(1, 1), 2, List(3, List(5, 8)))), List(1, 1, 2, 3, 5, 8))
    assertEquals(flatten(List()), List())
    assertEquals(flatten(List("abc", "def")), List("abc", "def"))


class TestCompress:
    @Test def t8(): Unit =
    assertEquals(compress(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")),
                List("a", "b", "c", "a", "d", "e"))
    assertEquals(compress(List()), List())
    assertEquals(compress(List(1, 1, 2, 3, 5, 8)), List(1, 2, 3, 5, 8))



class TestPack:
    @Test def t9(): Unit =
    assertEquals(pack(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")),
                List(List("a", "a", "a", "a"), List("b"), List("c", "c"),
                    List("a", "a"), List("d"), List("e", "e", "e", "e")))
    assertEquals(pack(List()), List(List()))
    assertEquals(pack(List(1, 1, 2, 3, 5, 8)),
                    List(List(1, 1), List(2), List(3),
                        List(5), List(8)))

class TestEncode:
    @Test def t10(): Unit =
    assertEquals(encode(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")),
                List((4, "a"), (1, "b"), (2, "c"),
                    (2, "a"), (1, "d"), (4, "e")))
    // assertEquals(encode(List()), List(1, List()))
    assertEquals(encode(List(1, 1, 2, 3, 5, 8)),
                    List((2, 1), (1, 2), (1, 3),
                        (1, 5), (1, 8)))


