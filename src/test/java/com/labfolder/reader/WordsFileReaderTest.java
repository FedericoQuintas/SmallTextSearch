package com.labfolder.reader;

import java.io.FileNotFoundException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.labfolder.reader.WordsFileReader;

public class WordsFileReaderTest {

	private WordsFileReader wordsFileReader;

	@Before
	public void before() {
		wordsFileReader = new WordsFileReader();
	}

	@Test
	public void whenReadsFileWithOneWordThenRetrievesListWithOneWord()
			throws FileNotFoundException {

		String path = "src/test/resources/input-one.txt";

		List<String> words = wordsFileReader.read(path);

		int expectedSize = 1;

		Assert.assertEquals(expectedSize, words.size());

	}

	@Test
	public void whenReadsFileWithTwoWordsThenRetrievesListWithTwoWords()
			throws FileNotFoundException {

		String path = "src/test/resources/input-two.txt";

		List<String> words = wordsFileReader.read(path);

		int expectedSize = 2;

		Assert.assertEquals(expectedSize, words.size());

	}

	@Test
	public void whenReadsFileWithThreeWordsThenRetrievesListWithThreeWords()
			throws FileNotFoundException {

		String path = "src/test/resources/input-three.txt";

		List<String> words = wordsFileReader.read(path);

		int expectedSize = 3;

		Assert.assertEquals(expectedSize, words.size());

	}

	@Test(expected = FileNotFoundException.class)
	public void whenReadsFileThatNotExistsThenExceptionIsThrown()
			throws FileNotFoundException {

		String path = "";

		wordsFileReader.read(path);

	}
}
