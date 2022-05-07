package com.butterfly.sunbase_task.Model.HomeModel;

public class User{
	private int totalPhotos;
	private boolean acceptedTos;
	private Social social;
	private Object twitterUsername;
	private String lastName;
	private String bio;
	private int totalLikes;
	private String portfolioUrl;
	private ProfileImage profileImage;
	private String updatedAt;
	private boolean forHire;
	private String name;
	private String location;
	private Links links;
	private int totalCollections;
	private String id;
	private String firstName;
	private String instagramUsername;
	private String username;

	public int getTotalPhotos(){
		return totalPhotos;
	}

	public boolean isAcceptedTos(){
		return acceptedTos;
	}

	public Social getSocial(){
		return social;
	}

	public Object getTwitterUsername(){
		return twitterUsername;
	}

	public String getLastName(){
		return lastName;
	}

	public String getBio(){
		return bio;
	}

	public int getTotalLikes(){
		return totalLikes;
	}

	public String getPortfolioUrl(){
		return portfolioUrl;
	}

	public ProfileImage getProfileImage(){
		return profileImage;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public boolean isForHire(){
		return forHire;
	}

	public String getName(){
		return name;
	}

	public String getLocation(){
		return location;
	}

	public Links getLinks(){
		return links;
	}

	public int getTotalCollections(){
		return totalCollections;
	}

	public String getId(){
		return id;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getInstagramUsername(){
		return instagramUsername;
	}

	public String getUsername(){
		return username;
	}
}
