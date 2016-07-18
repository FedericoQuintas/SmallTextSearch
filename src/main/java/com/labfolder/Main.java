package com.labfolder;

import java.io.FileNotFoundException;
import java.util.List;

import com.labfolder.analyzer.AnalysisResult;
import com.labfolder.analyzer.WordsAnalyzer;
import com.labfolder.analyzer.factory.AnalysisResultFactory;
import com.labfolder.analyzer.levenshtein.LevenshteinDistanceCalculator;
import com.labfolder.reader.WordsFileReader;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		String path = args[0];

		List<String> words = new WordsFileReader().read(path);
		String wordToCompare = words.get(0);

		WordsAnalyzer wordsAnalyzer = new WordsAnalyzer(
				new AnalysisResultFactory(),
				new LevenshteinDistanceCalculator());

		AnalysisResult result = wordsAnalyzer.analyze(words);

		String occurences = new StringBuilder().append(wordToCompare)
				.append(" (").append(result.getCount()).append(") ").toString();
		System.out.print(occurences);
		System.out.print(result.getSimilarities());

	}
}
