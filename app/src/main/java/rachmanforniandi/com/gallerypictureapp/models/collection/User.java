package rachmanforniandi.com.gallerypictureapp.models.collection;


import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("total_photos")
	private int totalPhotos;

	@SerializedName("accepted_tos")
	private boolean acceptedTos;

	@SerializedName("twitter_username")
	private Object twitterUsername;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("bio")
	private String bio;

	@SerializedName("total_likes")
	private int totalLikes;

	@SerializedName("portfolio_url")
	private String portfolioUrl;

	@SerializedName("profile_image")
	private ProfileImage profileImage;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("name")
	private String name;

	@SerializedName("location")
	private Object location;

	@SerializedName("links")
	private Links links;

	@SerializedName("total_collections")
	private int totalCollections;

	@SerializedName("id")
	private String id;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("instagram_username")
	private Object instagramUsername;

	@SerializedName("username")
	private String username;

	public void setTotalPhotos(int totalPhotos){
		this.totalPhotos = totalPhotos;
	}

	public int getTotalPhotos(){
		return totalPhotos;
	}

	public void setAcceptedTos(boolean acceptedTos){
		this.acceptedTos = acceptedTos;
	}

	public boolean isAcceptedTos(){
		return acceptedTos;
	}

	public void setTwitterUsername(Object twitterUsername){
		this.twitterUsername = twitterUsername;
	}

	public Object getTwitterUsername(){
		return twitterUsername;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setBio(String bio){
		this.bio = bio;
	}

	public String getBio(){
		return bio;
	}

	public void setTotalLikes(int totalLikes){
		this.totalLikes = totalLikes;
	}

	public int getTotalLikes(){
		return totalLikes;
	}

	public void setPortfolioUrl(String portfolioUrl){
		this.portfolioUrl = portfolioUrl;
	}

	public String getPortfolioUrl(){
		return portfolioUrl;
	}

	public void setProfileImage(ProfileImage profileImage){
		this.profileImage = profileImage;
	}

	public ProfileImage getProfileImage(){
		return profileImage;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLocation(Object location){
		this.location = location;
	}

	public Object getLocation(){
		return location;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setTotalCollections(int totalCollections){
		this.totalCollections = totalCollections;
	}

	public int getTotalCollections(){
		return totalCollections;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setInstagramUsername(Object instagramUsername){
		this.instagramUsername = instagramUsername;
	}

	public Object getInstagramUsername(){
		return instagramUsername;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}