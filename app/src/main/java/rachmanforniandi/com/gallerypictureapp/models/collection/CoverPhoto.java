package rachmanforniandi.com.gallerypictureapp.models.collection;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class CoverPhoto{

	@SerializedName("sponsored_by")
	private Object sponsoredBy;

	@SerializedName("current_user_collections")
	private List<Object> currentUserCollections;

	@SerializedName("color")
	private String color;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("description")
	private Object description;

	@SerializedName("sponsored")
	private boolean sponsored;

	@SerializedName("sponsored_impressions_id")
	private Object sponsoredImpressionsId;

	@SerializedName("liked_by_user")
	private boolean likedByUser;

	@SerializedName("urls")
	private Urls urls;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("width")
	private int width;

	@SerializedName("links")
	private Links links;

	@SerializedName("id")
	private String id;

	@SerializedName("categories")
	private List<Object> categories;

	@SerializedName("user")
	private User user;

	@SerializedName("slug")
	private String slug;

	@SerializedName("height")
	private int height;

	@SerializedName("likes")
	private int likes;

	public void setSponsoredBy(Object sponsoredBy){
		this.sponsoredBy = sponsoredBy;
	}

	public Object getSponsoredBy(){
		return sponsoredBy;
	}

	public void setCurrentUserCollections(List<Object> currentUserCollections){
		this.currentUserCollections = currentUserCollections;
	}

	public List<Object> getCurrentUserCollections(){
		return currentUserCollections;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setDescription(Object description){
		this.description = description;
	}

	public Object getDescription(){
		return description;
	}

	public void setSponsored(boolean sponsored){
		this.sponsored = sponsored;
	}

	public boolean isSponsored(){
		return sponsored;
	}

	public void setSponsoredImpressionsId(Object sponsoredImpressionsId){
		this.sponsoredImpressionsId = sponsoredImpressionsId;
	}

	public Object getSponsoredImpressionsId(){
		return sponsoredImpressionsId;
	}

	public void setLikedByUser(boolean likedByUser){
		this.likedByUser = likedByUser;
	}

	public boolean isLikedByUser(){
		return likedByUser;
	}

	public void setUrls(Urls urls){
		this.urls = urls;
	}

	public Urls getUrls(){
		return urls;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCategories(List<Object> categories){
		this.categories = categories;
	}

	public List<Object> getCategories(){
		return categories;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setSlug(String slug){
		this.slug = slug;
	}

	public String getSlug(){
		return slug;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	public void setLikes(int likes){
		this.likes = likes;
	}

	public int getLikes(){
		return likes;
	}
}