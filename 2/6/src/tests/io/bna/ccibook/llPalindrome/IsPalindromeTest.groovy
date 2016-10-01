package io.bna.ccibook.llPalindrome

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/30/2016.
 */
class IsPalindromeTest extends GroovyTestCase {

    void testCharIsPalindromeStrategy(IsPalindromeStrategy<Character> strat) {
        Character[] p1Chars = "AMANAPLANACANALPANAMA".toCharArray(),
                    p2Chars = "AMANAPLANACANALPANAMASHIT".toCharArray();
        LinkedList<Character> palindrome1 = new LinkedList<>(p1Chars);
        LinkedList<Character> nonpalindrome1 = new LinkedList<>(p2Chars);
        assertTrue(strat.isPalindrome(palindrome1));
        assertFalse(strat.isPalindrome(nonpalindrome1));
    }

    void testIntIsPalindromeStrategy(IsPalindromeStrategy<Integer> strat) {
        LinkedList<Integer> palindrome2 = new LinkedList<>([1, 2, 3, 4, 5, 4, 3, 2, 1] as Integer[]);
        LinkedList<Integer> nonpalindrome2 = new LinkedList<>([1, 2, 3, 4, 5, 3, 2, 1] as Integer[]);
        assertTrue(strat.isPalindrome(palindrome2));
        assertFalse(strat.isPalindrome(nonpalindrome2));
    }

    void testStackAdderChecker() {
        StackAdderChecker<Character> charChecker = new StackAdderChecker<>();
        StackAdderChecker<Integer> intChecker = new StackAdderChecker<>();
        testCharIsPalindromeStrategy(charChecker);
        testIntIsPalindromeStrategy(intChecker);
    }

    void testCountStackAdderChecker() {
        CountStackAdderChecker<Character> charChecker = new CountStackAdderChecker<>();
        CountStackAdderChecker<Integer> intChecker = new CountStackAdderChecker<>();
        testCharIsPalindromeStrategy(charChecker);
        testIntIsPalindromeStrategy(intChecker);
    }
}
