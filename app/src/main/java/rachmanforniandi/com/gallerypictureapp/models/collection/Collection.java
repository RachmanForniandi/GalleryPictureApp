package rachmanforniandi.com.gallerypictureapp.models.collection;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Collection{

	@SerializedName("cover_photo")
	private CoverPhoto coverPhoto;

	@SerializedName("total_photos")
	private int totalPhotos;

	@SerializedName("description")
	private String description;

	@SerializedName("title")
	private String title;

	@SerializedName("id")
	private int id;

	@SerializedName("user")
	private User user;



	public void setCoverPhoto(CoverPhoto coverPhoto){
		this.coverPhoto = coverPhoto;
	}

	public CoverPhoto getCoverPhoto(){
		return coverPhoto;
	}

	public void setTotalPhotos(int totalPhotos){
		this.totalPhotos = totalPhotos;
	}

	public int getTotalPhotos(){
		return totalPhotos;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}
}