package rachmanforniandi.com.gallerypictureapp.Utils;

import java.util.List;

import io.realm.Realm;
import rachmanforniandi.com.gallerypictureapp.models.photo.Photo;

public class RealmController {

    private final Realm realm;
    public RealmController(){
        realm = Realm.getDefaultInstance();
    }

    public void savePhoto(Photo photo){
        realm.beginTransaction();
        realm.copyFromRealm(photo);
        realm.commitTransaction();

    }

    public void deletePhoto(final Photo photo){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Photo resultPhoto = realm.where(Photo.class).equalTo("id",photo.getId()).findFirst();
                resultPhoto.deleteFromRealm();
            }
        });
    }

    public boolean isPhotoExist(Photo photo){
        Photo resultPhoto = realm.where(Photo.class).equalTo("id",photo.getId()).findFirst();
        if (resultPhoto == null)
            return false;
        return true;
    }

    public List<Photo>getPhoto(){
        return realm.where(Photo.class).findAll();
    }
}
