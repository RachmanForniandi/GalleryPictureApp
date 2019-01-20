package rachmanforniandi.com.gallerypictureapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import rachmanforniandi.com.gallerypictureapp.R;
import rachmanforniandi.com.gallerypictureapp.Utils.GlideApp;
import rachmanforniandi.com.gallerypictureapp.Utils.TemplateSquareImage;
import rachmanforniandi.com.gallerypictureapp.models.photo.Photo;
import rachmanforniandi.com.gallerypictureapp.views.Activities.FullScreenPhotoActivity;

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

        @BindView(R.id.item_photo_layout)
        FrameLayout frameLayout;

        public PhotosHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.item_photo_layout)
        public void setFrameLayout(){
            int position = getAdapterPosition();
            String photoId = photos.get(position).getId();
            Intent intent = new Intent(ctx, FullScreenPhotoActivity.class);
            intent.putExtra("photoId",photoId);
            ctx.startActivity(intent);
        }
    }
}
