package rachmanforniandi.com.gallerypictureapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import rachmanforniandi.com.gallerypictureapp.R;
import rachmanforniandi.com.gallerypictureapp.Utils.GlideApp;
import rachmanforniandi.com.gallerypictureapp.Utils.TemplateSquareImage;
import rachmanforniandi.com.gallerypictureapp.Utils.WallpaperGlideModule;
import rachmanforniandi.com.gallerypictureapp.models.Photo;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotosHolder> {
    private Context ctx;
    private List<Photo> photos;

    public PhotosAdapter(Context ctx, List<Photo> photos) {
        this.ctx = ctx;
        this.photos = photos;
    }

    @Override
    public PhotosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo,parent,false);
        return new PhotosHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotosHolder holder, int position) {
        Photo photo = photos.get(position);
        holder.txtUsername.setText(photo.getUser().getUsername());

        GlideApp
                .with(ctx)
                .load(photo.getUrls().getRegular())
                .placeholder(R.drawable.placeholder)
                .override(600,600)
                .into(holder.imgViewPhoto);

        GlideApp
                .with(ctx)
                .load(photo.getUser().getProfileImage().getSmall())
                .into(holder.imgAvatar);


    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class PhotosHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_avatar)
        CircleImageView imgAvatar;

        @BindView(R.id.txt_item_photo_username)
        TextView txtUsername;

        @BindView(R.id.imgView_photo)
        TemplateSquareImage imgViewPhoto;

        public PhotosHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
