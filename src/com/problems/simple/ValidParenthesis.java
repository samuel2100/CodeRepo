package com.problems.simple;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * 
 * Input: "()"
 * Output: true
 * Example 2:
 * 
 * Input: "()[]{}"
 * Output: true
 * 
 * @author samuel
 *
 */

public class ValidParenthesis {
	public boolean isValid(String s) {
		if (s == null || s.isEmpty()) return true;
        char[] charArr= new char[s.length()];
        int index = 0;
        int arrIndex = -1 ;
        while (index < s.length()){
        	char c = s.charAt(index++);
        	switch(c){
        	case '{':
        	case '[':
        	case '(':
        		charArr[++arrIndex] = c;
        		break;
        	case '}':
        		if ( arrIndex < 0 || charArr[arrIndex] != '{')
        			return false;
        		else{
        			arrIndex--;
        			break;
        		}
        	case ']':
        		if ( arrIndex < 0 || charArr[arrIndex] != '[')
        			return false;
        		else{
        			arrIndex--;
        			break;
        		}
        	case ')':
        		if ( arrIndex < 0 || charArr[arrIndex] != '(')
        			return false;
        		else{
        			arrIndex--;
        			break;
        		}
        	default :
        		return false;
        	}
        }
        if (arrIndex != -1) return false;
        return true;
    }
	
	public static void main(String[] args) {
		assertTrue("it should be true", new ValidParenthesis().isValid(""));
		assertFalse("it should be false", new ValidParenthesis().isValid("]"));
		assertFalse("it should be false", new ValidParenthesis().isValid("{["));
		assertTrue("it should be true", new ValidParenthesis().isValid("{}[]()"));
		assertTrue("it should be true", new ValidParenthesis().isValid("{[]}[{()}]()"));
	}
}
