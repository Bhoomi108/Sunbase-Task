package com.butterfly.sunbase_task.Model.SearchModel;

import java.util.List;

public class SearchModel{
	private int total;
	private int totalPages;
	private List<ResultsItem> results;

	public int getTotal(){
		return total;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	public void setResults(List<ResultsItem> results) {
		this.results = results;
	}
}