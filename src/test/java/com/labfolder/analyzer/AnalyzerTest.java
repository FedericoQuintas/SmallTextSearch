package com.labfolder.analyzer;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.labfolder.analyzer.factory.AnalysisResultFactory;
import com.labfolder.analyzer.levenshtein.LevenshteinDistanceCalculator;

public class AnalyzerTest {

	private static final String INVALID_INPUT = "Invalid input";
	private WordsAnalyzer wordsAnalyzer;
	private ArrayList<String> words;

	@Before
	public void before() {
		wordsAnalyzer = new WordsAnalyzer(new AnalysisResultFactory(),
				new LevenshteinDistanceCalculator());
		words = new ArrayList<String>();
	}

	@Test
	public void whenInputIsOneWordThenCountsOneEqualsWordsAndNoSimilarities() {

		words.add("word");

		AnalysisResult result = wordsAnalyzer.analyze(words);

		Assert.assertEquals(1, result.getCount());
		Assert.assertTrue(result.getSimilarities().isEmpty());
	}

	@Test
	public void whenInputIsTwoEqualsWordsThenCountsTwoWordsAndNoSimilarities() {

		words.add("word");
		words.add("word");

		AnalysisResult result = wordsAnalyzer.analyze(words);

		Assert.assertEquals(2, result.getCount());
		Assert.assertTrue(result.getSimilarities().isEmpty());
	}

	@Test
	public void whenInputIsOneEqualWordAndTwoSimilarThenCountOneWordAndTwoSimilarities() {

		words.add("word");
		words.add("Word");
		words.add("wordo");

		AnalysisResult result = wordsAnalyzer.analyze(words);

		Assert.assertEquals(1, result.getCount());
		Assert.assertEquals(2, result.getSimilarities().size());
	}

	@Test
	public void whenInputIsTwoEqualsWordAndAASimilarOneThenCountsTwoWordsAndOneSimilarity() {

		words.add("word");
		words.add("word");
		words.add("Word");

		AnalysisResult result = wordsAnalyzer.analyze(words);

		Assert.assertEquals(2, result.getCount());
		Assert.assertEquals(1, result.getSimilarities().size());
	}

	@Test
	public void whenInputIsThreeEqualsWordsAndAFiveSimilarThenCountThreeWordsAndFiveSimilarities() {

		words.add("word");
		words.add("word");
		words.add("word");
		words.add("wordo");
		words.add("ord");
		words.add("aord");
		words.add("ward");
		words.add("wold");

		AnalysisResult result = wordsAnalyzer.analyze(words);

		Assert.assertEquals(3, result.getCount());
		Assert.assertEquals(5, result.getSimilarities().size());
	}

	@Test
	public void whenInputIsEmptyThenExceptionIsThrown() {

		try {
			wordsAnalyzer.analyze(words);
		} catch (IllegalArgumentException exception) {
			Assert.assertEquals(INVALID_INPUT, exception.getMessage());
		}
	}

	@Test
	public void whenInputIsNullThenExceptionIsThrown() {
		try {
			wordsAnalyzer.analyze(null);
		} catch (IllegalArgumentException exception) {
			Assert.assertEquals(INVALID_INPUT, exception.getMessage());
		}
	}
}
