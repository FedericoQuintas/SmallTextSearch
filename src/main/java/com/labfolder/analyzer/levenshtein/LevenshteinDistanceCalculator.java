package com.labfolder.analyzer.levenshtein;

import org.apache.commons.lang3.StringUtils;

public class LevenshteinDistanceCalculator {

	public Boolean areSimilarWords(String word, String wordToCompare) {
		int levenshteinDistance = StringUtils.getLevenshteinDistance(word,
				wordToCompare);
		return levenshteinDistance == 1;
	}

}
