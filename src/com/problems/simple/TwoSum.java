package com.problems.simple;

import java.util.HashMap;
import java.util.Map;
/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * @author samuel
 *
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> mapOfValues = new HashMap<>();
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (mapOfValues.containsKey(target - nums[i])) {
				result[0] = mapOfValues.get(target - nums[i]);
				result[1] = i;
				return result;
			}
			mapOfValues.put(nums[i], i);

		}
		throw new RuntimeException("invalid input, no combination of element found.");
	}

	public static void main(String[] args) {
		for (int i : new TwoSum().twoSum(new int[] { 2, 7, 11, 15 }, 18)) {
			System.out.println(i);
		}
	}
}
