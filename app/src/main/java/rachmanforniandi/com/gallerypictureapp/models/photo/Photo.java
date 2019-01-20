package rachmanforniandi.com.gallerypictureapp.models.photo;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Photo extends RealmObject {

	@SerializedName("id")
	private String id;
	@PrimaryKey
	@SerializedName("description")
	private String description;

	@SerializedName("urls")
	private Urls urls;

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