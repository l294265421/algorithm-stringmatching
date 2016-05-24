package com.liyuncong.algorithm.algorithm_stringmatching;

import java.util.LinkedList;
import java.util.List;

/**
 * 朴素的字符串匹配算法
 * @author yuncong
 *
 */
public class NaiveStringMatcher implements StringMatcher {

	public List<Integer> match(String text, String pattern) {
		List<Integer> result = new LinkedList<Integer>();
		
		if (text == null || pattern == null) {
			return result;
		}
		
		int textLen = text.length();
		if (text.length() == 0) {
			return result;
		}
		
		int patternLen = pattern.length();
		if (patternLen == 0) {
			return result;
		}
		
		int maxShift = textLen - patternLen;
		if(maxShift < 0) {
			return result;
		}
		
		for(int shift = 0; shift < maxShift; shift++) {
			boolean validShift = true;
			for(int i = 0; i < patternLen; i++) {
				if (text.charAt(i) != pattern.charAt(i)) {
					validShift = false;
					break;
				}
			}
			if (validShift) {
				result.add(shift);
			}
		}
		return result;
	}

}
