package com.problems.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertTrue;
/**
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * @author samuel
 *
 */
public class LetterCombinations {

	private Map<Character, List<Character>> letterMap = new HashMap<Character, List<Character>>();

	private void initializeMap() {
		letterMap.put('2', Arrays.asList('a', 'b', 'c'));
		letterMap.put('3', Arrays.asList('d', 'e', 'f'));
		letterMap.put('4', Arrays.asList('g', 'h', 'i'));
		letterMap.put('5', Arrays.asList('j', 'k', 'l'));
		letterMap.put('6', Arrays.asList('m', 'n', 'o'));
		letterMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
		letterMap.put('8', Arrays.asList('t', 'u', 'v'));
		letterMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
	}

	public List<String> letterCombinationsWithRecursion(String digits) {
		List<String> allCombinations = new ArrayList<String>();
		if (digits.length() == 0) {
			allCombinations.add(digits);
			return allCombinations;
		}
		char firstChar = digits.charAt(0);
		String restOfStr = digits.substring(1);
		List<String> restOfCominations = letterCombinations(restOfStr);
		for (char code : letterMap.get(firstChar)) {
			for (String eachCombination : restOfCominations) {
				allCombinations.add(code + eachCombination);
			}
		}

		return allCombinations;
	}

	public List<String> letterCombinations(String digits) {
		List<String> letterCombinations = new ArrayList<String>();
		char[] arrOfDigits = digits.toCharArray();
		letterCombinations.add("");
		for (char digit : arrOfDigits) {
			letterCombinations = getCombinations(letterCombinations, letterMap.get(digit));
		}
		return letterCombinations;
	}

	private List<String> getCombinations(List<String> letterCombinations, List<Character> charList) {
		List<String> newCombinations = new ArrayList<String>();
		for (String eachCombination : letterCombinations) {
			for (char ch : charList)
				newCombinations.add(eachCombination + ch);
		}
		return newCombinations;
	}

	private boolean isValidInput(String inputValue) {
		if (inputValue.isEmpty())
			return true;
		for (char inputChar : inputValue.toCharArray()) {
			if (!letterMap.containsKey(inputChar))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String inputValue = "23";
		LetterCombinations lc = new LetterCombinations();
		lc.initializeMap();
		if (lc.isValidInput(inputValue)){
			System.out.println(lc.letterCombinations(inputValue));
			System.out.println(lc.letterCombinations(inputValue));
			assertTrue(lc.letterCombinations(inputValue).equals(lc.letterCombinationsWithRecursion(inputValue)));
			assertTrue(lc.letterCombinations("234").equals(lc.letterCombinationsWithRecursion("234")));
		}
		else
			System.out.println("Invalid Input");
	}

}