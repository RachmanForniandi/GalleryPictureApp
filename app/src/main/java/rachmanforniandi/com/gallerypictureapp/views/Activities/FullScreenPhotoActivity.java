package rachmanforniandi.com.gallerypictureapp.views.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import rachmanforniandi.com.gallerypictureapp.R;

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

    private void getPhoto(String Id) {

    }

    @OnClick(R.id.fab_favorite_fullscreen)
    public void setFabFavorite(){
        fabMenu.close(true);
    }

    @OnClick(R.id.fab_wallpaper_fullscreen)
    public void setFabWallpaper(){
        fabMenu.close(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
