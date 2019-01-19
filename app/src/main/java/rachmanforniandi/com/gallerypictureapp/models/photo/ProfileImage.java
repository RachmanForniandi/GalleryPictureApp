package rachmanforniandi.com.gallerypictureapp.models.photo;


import com.google.gson.annotations.SerializedName;

public class ProfileImage{

	@SerializedName("small")
	private String small;

	@SerializedName("medium")
	private String medium;

	public void setSmall(String small){
		this.small = small;
	}

	public String getSmall(){
		return small;
	}

	public void setMedium(String medium){
		this.medium = medium;
	}

	public String getMedium(){
		return medium;
	}
}