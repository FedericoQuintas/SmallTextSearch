package com.labfolder.analyzer;

import java.util.ArrayList;
import java.util.List;

import com.labfolder.analyzer.factory.AnalysisResultFactory;
import com.labfolder.analyzer.levenshtein.LevenshteinDistanceCalculator;

public class WordsAnalyzer {

	private static final String INVALID_INPUT = "Invalid input";
	private AnalysisResultFactory analysisResultFactory;
	private LevenshteinDistanceCalculator levenshteinDistanceCalculator;

	public WordsAnalyzer(AnalysisResultFactory analysisResultFactory,
			LevenshteinDistanceCalculator levenshteinDistanceCalculator) {
		this.analysisResultFactory = analysisResultFactory;
		this.levenshteinDistanceCalculator = levenshteinDistanceCalculator;
	}

	public AnalysisResult analyze(List<String> words) {

		validateInput(words);

		String wordToCompare = words.get(0);

		int count = 0;

		List<String> similarities = new ArrayList<String>();

		for (String word : words) {
			count = analyzeWord(wordToCompare, count, similarities, word);
		}

		return analysisResultFactory.create(count, similarities);

	}

	private int analyzeWord(String wordToCompare, int count,
			List<String> similarities, String word) {
		if (wordToCompare.equals(word)) {
			count++;
		} else {
			areSimilarWords(similarities, word, wordToCompare);
		}
		return count;
	}

	private void areSimilarWords(List<String> similarities, String word,
			String wordToCompare) {
		if (levenshteinDistanceCalculator.areSimilarWords(word, wordToCompare)) {
			similarities.add(word);
		}
	}

	private void validateInput(List<String> words) {
		if (words == null || words.isEmpty()) {
			throw new IllegalArgumentException(INVALID_INPUT);
		}
	}
}
