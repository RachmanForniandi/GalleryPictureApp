package rachmanforniandi.com.gallerypictureapp.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Photo{


	@SerializedName("description")
	private String description;

	@SerializedName("urls")
	private Urls urls;

	@SerializedName("id")
	private String id;

	@SerializedName("user")
	private User user;

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setUrls(Urls urls){
		this.urls = urls;
	}

	public Urls getUrls(){
		return urls;
	}


	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}
}