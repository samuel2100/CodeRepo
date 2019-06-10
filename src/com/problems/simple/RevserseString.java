package com.problems.simple;
import static org.junit.Assert.assertEquals;
/**
 * Given a string, that contains special character together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’), 
 * reverse the string in a way that special characters are not affected.
 * 
 * Input:   str = "a,b$c"
 * Output:  str = "c,b$a"
 * Note that $ and , are not moved anywhere.  
 * Only subsequence "abc" is reversed
 * 
 * @author samuel
 *
 */
public class RevserseString {

	public static void main(String[] args){
		System.out.println("reverse = "+ new RevserseString().solution("a,b$c"));
		assertEquals(new RevserseString().solution("a,b$c"), "c,b$a");
		assertEquals(new RevserseString().solution("Ab,c,de!$"), "ed,c,bA!$");
	}
	
	public String solution(String input){
		if (input == null || input.isEmpty()) return input;
		
		int fwdIndex = 0;
		int bkIndex = input.length()-1;
		char[] charArr = input.toCharArray();
		while (fwdIndex < bkIndex){
			char fwdChar = charArr[fwdIndex];
			char bkChar = charArr[bkIndex];
				if (!isValidChar(fwdChar)) {
					fwdIndex++;
					continue;
				}else if (!isValidChar(bkChar)) {
					bkIndex--;
					continue;
				}else{
					charArr[bkIndex--] = fwdChar;
					charArr[fwdIndex++] = bkChar;
				}
				
		}
		return String.valueOf(charArr);
	}
	
	private boolean isValidChar(char ch){
		if ((ch - 'a' < 27 && ch - 'a' >= 0)|| (ch - 'A' < 27 && ch - 'A' >= 0)) return true;
		return false;
	}
}
