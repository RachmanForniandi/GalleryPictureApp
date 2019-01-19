package rachmanforniandi.com.gallerypictureapp.models.photo;


import com.google.gson.annotations.SerializedName;


public class User{

	@SerializedName("profile_image")
	private ProfileImage profileImage;

	@SerializedName("id")
	private String id;

	@SerializedName("username")
	private String username;

	public void setProfileImage(ProfileImage profileImage){
		this.profileImage = profileImage;
	}

	public ProfileImage getProfileImage(){
		return profileImage;
	}


	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}