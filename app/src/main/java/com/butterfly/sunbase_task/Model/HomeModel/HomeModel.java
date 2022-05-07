package com.butterfly.sunbase_task.Model.HomeModel;

import java.util.List;

public class HomeModel{
	private TopicSubmissions topicSubmissions;
	private List<Object> currentUserCollections;
	private String color;
	private Sponsorship sponsorship;
	private String createdAt;
	private Object description;
	private boolean likedByUser;
	private Urls urls;
	private String altDescription;
	private String updatedAt;
	private int width;
	private String blurHash;
	private Links links;
	private String id;
	private List<Object> categories;
	private String promotedAt;
	private User user;
	private int height;
	private int likes;

	public TopicSubmissions getTopicSubmissions(){
		return topicSubmissions;
	}

	public List<Object> getCurrentUserCollections(){
		return currentUserCollections;
	}

	public String getColor(){
		return color;
	}

	public Sponsorship getSponsorship(){
		return sponsorship;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public Object getDescription(){
		return description;
	}

	public boolean isLikedByUser(){
		return likedByUser;
	}

	public Urls getUrls(){
		return urls;
	}

	public String getAltDescription(){
		return altDescription;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public int getWidth(){
		return width;
	}

	public String getBlurHash(){
		return blurHash;
	}

	public Links getLinks(){
		return links;
	}

	public String getId(){
		return id;
	}

	public List<Object> getCategories(){
		return categories;
	}

	public String getPromotedAt(){
		return promotedAt;
	}

	public User getUser(){
		return user;
	}

	public int getHeight(){
		return height;
	}

	public int getLikes(){
		return likes;
	}
}