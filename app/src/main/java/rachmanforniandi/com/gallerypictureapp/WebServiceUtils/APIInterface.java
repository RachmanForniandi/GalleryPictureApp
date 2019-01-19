package rachmanforniandi.com.gallerypictureapp.WebServiceUtils;

import java.util.List;

import rachmanforniandi.com.gallerypictureapp.models.Photo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("photos")
    Call<List<Photo>>getPhotos();
}
