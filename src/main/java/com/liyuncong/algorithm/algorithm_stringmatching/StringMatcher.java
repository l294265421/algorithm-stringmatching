package com.liyuncong.algorithm.algorithm_stringmatching;

import java.util.List;

public interface StringMatcher {
	/**
	 * 
	 * @param text 文本
	 * @param pattern 模式
	 * @return 所有有效位移的集合
	 */
	public List<Integer> match(String text, String pattern);
}
