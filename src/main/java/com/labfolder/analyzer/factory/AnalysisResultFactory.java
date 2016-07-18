package com.labfolder.analyzer.factory;

import java.util.List;

import com.labfolder.analyzer.AnalysisResult;

public class AnalysisResultFactory {

	public AnalysisResult create(int count, List<String> similarities) {
		return new AnalysisResult(count, similarities);
	}

}
