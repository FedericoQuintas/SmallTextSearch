package com.labfolder.analyzer;

import java.util.List;

public class AnalysisResult {

	private int count;
	private List<String> similarities;

	public AnalysisResult(int count, List<String> similarities) {
		this.count = count;
		this.similarities = similarities;
	}

	public int getCount() {
		return this.count;
	}

	public List<String> getSimilarities() {
		return this.similarities;
	}

}
