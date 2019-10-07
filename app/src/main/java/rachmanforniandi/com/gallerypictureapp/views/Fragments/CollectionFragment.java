package rachmanforniandi.com.gallerypictureapp.views.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import rachmanforniandi.com.gallerypictureapp.Adapters.PhotosAdapter;
import rachmanforniandi.com.gallerypictureapp.R;
import rachmanforniandi.com.gallerypictureapp.Utils.GlideApp;
import rachmanforniandi.com.gallerypictureapp.Utils.TemplateSquareImage;
import rachmanforniandi.com.gallerypictureapp.WebServiceUtils.APIInterface;
import rachmanforniandi.com.gallerypictureapp.WebServiceUtils.APIProcessing;
import rachmanforniandi.com.gallerypictureapp.models.collection.Collection;
import rachmanforniandi.com.gallerypictureapp.models.photo.Photo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionFragment extends Fragment {
    private final String TAG = CollectionFragment.class.getSimpleName();

    @BindView(R.id.username_fragment_collection)
    TextView username;

    @BindView(R.id.description_fragment_collection)
    TextView description;

    @BindView(R.id.avatar_fragment_collection)
    CircleImageView userAvatar;

    @BindView(R.id.title_fragment_collection)
    TextView title;

    @BindView(R.id.progress_collection)
    ProgressBar progressBar;

    @BindView(R.id.recyclerView_collection)
    RecyclerView recyclerView;

    private Unbinder unbinder;

    private List<Photo> photos = new ArrayList<>();
    private PhotosAdapter photosAdapter;

    public CollectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_collection, container, false);
        unbinder = ButterKnife.bind(this,view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        photosAdapter = new PhotosAdapter(getActivity(),photos);
        recyclerView.setAdapter(photosAdapter);

        Bundle bundle = getArguments();
        int collectionId = bundle.getInt("collectionId");
        ShowProgressbar(true);

        getInformationOfCollection(collectionId);
        getPhotosOfCollection(collectionId);
        return view;
    }




    private void getInformationOfCollection(final int collectionId) {
        APIInterface apiInterface = APIProcessing.createService(APIInterface.class);
        Call<Collection> call =apiInterface.getDetailOfCollection(collectionId);
        call.enqueue(new Callback<Collection>() {
            @Override
            public void onResponse(Call<Collection> call, Response<Collection> response) {
                if (response.isSuccessful()){
                    Collection collection = response.body();
                    title.setText(collection.getTitle());
                    description.setText(collection.getDescription());
                    username.setText(collection.getUser().getUsername());
                    GlideApp
                            .with(getActivity())
                            .load(collection.getUser().getProfileImage().getSmall())
                            .into(userAvatar);

                }else {
                    Log.e(TAG,"Fail"+response.message());
                }
            }

            @Override
            public void onFailure(Call<Collection> call, Throwable t) {
                Log.e(TAG,"Fail"+ t.getMessage());
            }
        });

    }

    private void getPhotosOfCollection(int collectionId) {
        APIInterface apiInterface = APIProcessing.createService(APIInterface.class);
        Call<List<Photo>> call =apiInterface.getPhotosOfCollections(collectionId);
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.isSuccessful()){
                    photos.addAll(response.body());

                    photosAdapter.notifyDataSetChanged();
                }else {
                    Log.e(TAG,"Fail"+response.message());
                }
                ShowProgressbar(false);
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.e(TAG,"Fail"+t.getMessage());
                ShowProgressbar(false);
            }
        });
    }


    private void ShowProgressbar(boolean isShow) {
        if (isShow){
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }else{
            progressBar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
