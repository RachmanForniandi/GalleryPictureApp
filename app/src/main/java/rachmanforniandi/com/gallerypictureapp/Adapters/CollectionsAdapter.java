package rachmanforniandi.com.gallerypictureapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rachmanforniandi.com.gallerypictureapp.R;
import rachmanforniandi.com.gallerypictureapp.Utils.GlideApp;
import rachmanforniandi.com.gallerypictureapp.Utils.TemplateSquareImage;
import rachmanforniandi.com.gallerypictureapp.models.collection.Collection;

public class CollectionsAdapter extends BaseAdapter {

    private Context context;
    private List<Collection> collections;


    public CollectionsAdapter(Context context, List<Collection> collections) {
        this.context = context;
        this.collections = collections;
    }

    @Override
    public int getCount() {
        return collections.size();
    }

    @Override
    public Object getItem(int position) {
        return collections.get(position);
    }

    @Override
    public long getItemId(int position) {
        return collections.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        CollectionsHolder holder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_collection,parent,false);
            holder = new CollectionsHolder(view);
            view.setTag(holder);
        }else {
            holder =(CollectionsHolder)view.getTag();
        }

        ButterKnife.bind(this,view);
        Collection collection = collections.get(position);
        if (collection.getTitle()!= null){
            holder.titleItemCollection.setText(collection.getTitle());
        }
        holder.totalItemCollectionPhotos.setText(String.valueOf(collection.getTotalPhotos()) + " photos");

        GlideApp
                .with(context)
                .load(collection.getCoverPhoto().getUrls().getRegular())
                .into(holder.imgViewItemCollectionPhotos);
        return view;
    }

    static class CollectionsHolder{
        @BindView(R.id.title_item_collection)
        TextView titleItemCollection;

        @BindView(R.id.total_item_collection_photos)
        TextView totalItemCollectionPhotos;

        @BindView(R.id.imgView_item_collection_photos)
        TemplateSquareImage imgViewItemCollectionPhotos;


        public CollectionsHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
