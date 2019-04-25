package com.problems.simple;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 *	Example 1: Input: 121  Output: true
 *  Example 2: Input: -121   Output: false (it reads -121. From right to left, it becomes 121-)
 * @author samuel
 *
 */
public class PalindromNumber {
	
	public boolean isPalindrome(int x) {
        int reverse = 0;
        int orig = x;
        if (x < 0) return false;
        if (x % 10 == x) return true; //single digit 
        while (x / 10 != 0 ){
            reverse = reverse*10 + x % 10 ;
            x = x / 10;
        }
        reverse = reverse*10 + x % 10 ; //do it for the last digit
        return orig == reverse; 
    }
	
	public static void main(String[] args) {
		assertTrue("it should be true", new PalindromNumber().isPalindrome(0));
		assertTrue("it should be true", new PalindromNumber().isPalindrome(101));
		assertFalse("it should be False", new PalindromNumber().isPalindrome(-101));
		assertFalse("it should be False", new PalindromNumber().isPalindrome(10));
	}
}
