package rachmanforniandi.com.gallerypictureapp.models.photo;


import com.google.gson.annotations.SerializedName;


public class Urls{

	@SerializedName("regular")
	private String regular;

	@SerializedName("full")
	private String full;

	public void setRegular(String regular){
		this.regular = regular;
	}

	public String getRegular(){
		return regular;
	}

	public void setFull(String full){
		this.full = full;
	}

	public String getFull(){
		return full;
	}
}