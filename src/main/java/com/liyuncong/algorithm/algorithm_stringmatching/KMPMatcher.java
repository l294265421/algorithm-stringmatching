package com.liyuncong.algorithm.algorithm_stringmatching;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * KMP字符串匹配算法
 * @author yuncong
 *
 */
public class KMPMatcher implements StringMatcher {

	@Override
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
		
		Map<Integer, Integer> pi = computePrefixFunction(pattern);
		
		for (int shift = 0; shift < maxShift;) {
			int matchNum = 0;
			for(int j = 0; j < patternLen; j++) {
				if (text.charAt(shift + j) != pattern.charAt(j)) {
					break;
				} else {
					matchNum++;
				}
			}
			if (matchNum == patternLen) {
				result.add(shift);
			}
			int nextPossibleValidShift = shift + (matchNum - 
					pi.get(matchNum));
			shift = nextPossibleValidShift;
		}
		
		return result;
	}

	/**
	 * 计算模式的前n字符串的最大相同的前缀和后缀的长度
	 * @param pattern 模式
	 * @return
	 */
	private Map<Integer, Integer> computePrefixFunction(String pattern) {
		Map<Integer, Integer> result = new TreeMap<Integer, Integer>();
		if (pattern == null) {
			return result;
		}
		int patternLen = pattern.length();
		if (patternLen == 0) {
			return result;
		}
		result.put(1, 0);
		for(int i = 2; i <= patternLen; i++) {
			int k = 0;
			for(int j = 1; j < i- 1; j++) {
				if (pattern.substring(j).equals(pattern.substring(0, i - j))) {
					k = i -j;
					break;
				}
			}
			result.put(i, k);
		}
		return result;
	}
}
