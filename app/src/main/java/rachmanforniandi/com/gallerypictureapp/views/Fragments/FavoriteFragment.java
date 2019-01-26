package rachmanforniandi.com.gallerypictureapp.views.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rachmanforniandi.com.gallerypictureapp.Adapters.PhotosAdapter;
import rachmanforniandi.com.gallerypictureapp.R;
import rachmanforniandi.com.gallerypictureapp.Utils.RealmController;
import rachmanforniandi.com.gallerypictureapp.models.photo.Photo;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {
    @BindView(R.id.list_favorite_photo)
    RecyclerView listFavoritePhoto;

    @BindView(R.id.txt_notification_fragment_favorite)
    TextView txtNotificationFragment;

    private Unbinder unbinder;

    private List<Photo> photos = new ArrayList<>();
    private PhotosAdapter photosAdapter;


    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_favorite, container, false);
        unbinder = ButterKnife.bind(this,view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        listFavoritePhoto.setLayoutManager(linearLayoutManager);
        photosAdapter = new PhotosAdapter(getActivity(),photos);
        listFavoritePhoto.setAdapter(photosAdapter);

        getFavoritePhotos();
        return view;
    }

    private void getFavoritePhotos() {
        RealmController realmController = new RealmController();
        photos.addAll(realmController.getPhotos());

        if (photos.size()==0){
            txtNotificationFragment.setVisibility(View.VISIBLE);
            listFavoritePhoto.setVisibility(View.GONE);
        }else {
            photosAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
