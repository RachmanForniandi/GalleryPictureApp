package rachmanforniandi.com.gallerypictureapp.WebServiceUtils;

import java.util.List;

import rachmanforniandi.com.gallerypictureapp.models.collection.Collection;
import rachmanforniandi.com.gallerypictureapp.models.photo.Photo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("photos")
    Call<List<Photo>> getPhotos();

    @GET("collections/featured")
    Call<List<Collection>> getCollections();

    @GET("collections/{id}")
    Call<Collection> getDetailOfCollection(@Path("id")int id);

    @GET("collections/{id}/photos")
    Call<List<Photo>> getPhotosOfCollections(@Path("id")int id);
}
