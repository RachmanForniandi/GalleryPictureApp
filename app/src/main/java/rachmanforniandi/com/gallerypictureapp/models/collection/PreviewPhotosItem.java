package rachmanforniandi.com.gallerypictureapp.models.collection;


import com.google.gson.annotations.SerializedName;

public class PreviewPhotosItem{

	@SerializedName("urls")
	private Urls urls;

	@SerializedName("id")
	private String id;

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
}