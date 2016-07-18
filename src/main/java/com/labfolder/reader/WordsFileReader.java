package com.labfolder.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordsFileReader {

	public List<String> read(String path) throws FileNotFoundException {
		Scanner s = new Scanner(new File(path));

		List<String> list = new ArrayList<String>();

		while (s.hasNext()) {
			list.add(s.next());
		}
		s.close();
		return list;
	}

}
