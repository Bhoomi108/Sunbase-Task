package com.butterfly.sunbase_task.Model.SearchModel;

import java.util.List;

public class Sponsorship{
	private Sponsor sponsor;
	private String taglineUrl;
	private String tagline;
	private List<String> impressionUrls;

	public Sponsor getSponsor(){
		return sponsor;
	}

	public String getTaglineUrl(){
		return taglineUrl;
	}

	public String getTagline(){
		return tagline;
	}

	public List<String> getImpressionUrls(){
		return impressionUrls;
	}
}