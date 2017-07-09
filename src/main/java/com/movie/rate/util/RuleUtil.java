package com.movie.rate.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class RuleUtil {

	public static String[] movieSpilt(String sentence) {
		return sentence.split("::");
	}

	public static Map<Integer, Integer> sortedMap(Map<Integer, Integer> MovieMap) {
		Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
		Set<Entry<Integer, Integer>> set = MovieMap.entrySet();
		List<Entry<Integer, Integer>> list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1,
					Map.Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		for (Entry<Integer, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());

		}
		return sortedMap;

	}
}
