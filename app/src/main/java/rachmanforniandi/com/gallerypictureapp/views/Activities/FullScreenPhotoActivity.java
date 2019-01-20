package rachmanforniandi.com.gallerypictureapp.views.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import rachmanforniandi.com.gallerypictureapp.R;
import rachmanforniandi.com.gallerypictureapp.Utils.Functions;
import rachmanforniandi.com.gallerypictureapp.Utils.GlideApp;
import rachmanforniandi.com.gallerypictureapp.WebServiceUtils.APIInterface;
import rachmanforniandi.com.gallerypictureapp.WebServiceUtils.APIProcessing;
import rachmanforniandi.com.gallerypictureapp.models.photo.Photo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FullScreenPhotoActivity extends AppCompatActivity {

    @BindView(R.id.img_fullscreen_photo)
    ImageView imgFullScreen;

    @BindView(R.id.img_user_avatar_fullscreen)
    CircleImageView imgUserAvatar;

    @BindView(R.id.fab_menu_full_screen_photo)
    FloatingActionMenu fabMenu;

    @BindView(R.id.fab_favorite_fullscreen)
    FloatingActionButton fabFavorite;

    @BindView(R.id.fab_wallpaper_fullscreen)
    FloatingActionButton fabWallpaper;

    @BindView(R.id.username_fullscreen)
    TextView txtUsername;

    private Unbinder unbinder;
    private Bitmap bitmapPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_photo);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        unbinder = ButterKnife.bind(this);
        Intent intent = getIntent();
        String photoId = intent.getStringExtra("photoId");
        getPhoto(photoId);
    }

    private void getPhoto(String id) {
        APIInterface apiInterface = APIProcessing.createService(APIInterface.class);
        Call<Photo> call = apiInterface.getPhoto(id);
        call.enqueue(new Callback<Photo>() {
            @Override
            public void onResponse(Call<Photo> call, Response<Photo> response) {
                if (response.isSuccessful()){
                    Photo photo = response.body();
                    updateUI(photo);
                }
            }

            @Override
            public void onFailure(Call<Photo> call, Throwable t) {

            }
        });
    }

    private void updateUI(Photo photo) {
        try {
            txtUsername.setText(photo.getUser().getUsername());
            GlideApp
                    .with(FullScreenPhotoActivity.this)
                    .load(photo.getUser().getProfileImage().getSmall())
                    .into(imgUserAvatar);

            GlideApp
                    .with(FullScreenPhotoActivity.this)
                    .asBitmap()
                    .fitCenter()
                    .load(photo.getUrls().getRegular())
                    .centerCrop()
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                            imgFullScreen.setImageBitmap(resource);
                            bitmapPhoto = resource;
                        }
                    });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @OnClick(R.id.fab_favorite_fullscreen)
    public void setFabFavorite(){
        fabMenu.close(true);
    }

    @OnClick(R.id.fab_wallpaper_fullscreen)
    public void setFabWallpaper(){
        if (bitmapPhoto != null){
            if (Functions.setImageWallpaper(FullScreenPhotoActivity.this,bitmapPhoto)){
                Toast.makeText(FullScreenPhotoActivity.this,"Set wallpaper successfully",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(FullScreenPhotoActivity.this,"Set wallpaper failed",Toast.LENGTH_LONG).show();
            }
        }
        fabMenu.close(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
