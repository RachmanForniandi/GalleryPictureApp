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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rachmanforniandi.com.gallerypictureapp.Adapters.PhotosAdapter;
import rachmanforniandi.com.gallerypictureapp.R;
import rachmanforniandi.com.gallerypictureapp.WebServiceUtils.APIInterface;
import rachmanforniandi.com.gallerypictureapp.WebServiceUtils.APIProcessing;
import rachmanforniandi.com.gallerypictureapp.models.Photo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotosFragment extends Fragment {
    private final String TAG = PhotosFragment.class.getSimpleName();
    @BindView(R.id.progress_circular_photos)
    ProgressBar progressBarPhotos;

    @BindView(R.id.list_photos)
    RecyclerView listPhotos;

    PhotosAdapter photosAdapter;
    private List<Photo> photos = new ArrayList<>();
    private Unbinder unbinder;


    public PhotosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_photos, container, false);
        unbinder = ButterKnife.bind(this,view);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        listPhotos.setLayoutManager(linearLayoutManager);

        photosAdapter = new PhotosAdapter(getActivity(),photos);
        listPhotos.setAdapter(photosAdapter);

        showProgressbar(true);
        getPhotos();
        return view;
    }

    private void getPhotos(){
        APIInterface apiInterface = APIProcessing.createService(APIInterface.class);
        Call<List<Photo>> call = apiInterface.getPhotos();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.isSuccessful()){
                    photos.addAll(response.body());

                    photosAdapter.notifyDataSetChanged();
                }else {
                    Log.e(TAG,"Fail"+response.message());
                }
                showProgressbar(false);
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.e(TAG,"Fail"+t.getMessage());
                showProgressbar(false);
            }
        });
    }

    private void showProgressbar(boolean isShow) {
        if (isShow){
            progressBarPhotos.setVisibility(View.VISIBLE);
            listPhotos.setVisibility(View.GONE);
        }else{
            progressBarPhotos.setVisibility(View.GONE);
            listPhotos.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
