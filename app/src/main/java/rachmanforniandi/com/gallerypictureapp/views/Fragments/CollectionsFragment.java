package rachmanforniandi.com.gallerypictureapp.views.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.Unbinder;
import rachmanforniandi.com.gallerypictureapp.Adapters.CollectionsAdapter;
import rachmanforniandi.com.gallerypictureapp.R;
import rachmanforniandi.com.gallerypictureapp.Utils.Functions;
import rachmanforniandi.com.gallerypictureapp.WebServiceUtils.APIInterface;
import rachmanforniandi.com.gallerypictureapp.WebServiceUtils.APIProcessing;
import rachmanforniandi.com.gallerypictureapp.models.collection.Collection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionsFragment extends Fragment {
    private final String TAG = CollectionsFragment.class.getSimpleName();
    @BindView(R.id.progress_circular_collections)
    ProgressBar progressCircularCollections;

    @BindView(R.id.list_grid_collections)
    GridView listGridCollections;

    CollectionsAdapter collectionsAdapter;
    private List<Collection> collections = new ArrayList<>();
    private Unbinder unbinder;


    public CollectionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_collections, container, false);
        unbinder = ButterKnife.bind(this,view);


        collectionsAdapter = new CollectionsAdapter(getActivity(),collections);
        listGridCollections.setAdapter(collectionsAdapter);

        showProgressbarCollection(true);
        getCollections();

        return view;
    }

    @OnItemClick(R.id.list_grid_collections)
    public void setGridView(int position){
        Collection collection = collections.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("collectionId",collection.getId());

        CollectionFragment collectionFragment = new CollectionFragment();
        collectionFragment.setArguments(bundle);
        Functions.switchMainFragmentWithBack(getActivity(),collectionFragment);
    }

    private void getCollections() {
        APIInterface apiInterface = APIProcessing.createService(APIInterface.class);
        Call<List<Collection>> call = apiInterface.getCollections();
        call.enqueue(new Callback<List<Collection>>() {
            @Override
            public void onResponse(Call<List<Collection>> call, Response<List<Collection>> response) {
                if (response.isSuccessful()){
                    collections.addAll(response.body());

                    collectionsAdapter.notifyDataSetChanged();
                }else {
                    Log.e(TAG,"Fail"+response.message());
                }
                showProgressbarCollection(false);
            }

            @Override
            public void onFailure(Call<List<Collection>> call, Throwable t) {
                Log.e(TAG,"Fail"+t.getMessage());
                showProgressbarCollection(false);
            }
        });
    }

    private void showProgressbarCollection(boolean isShow) {
        if (isShow){
            progressCircularCollections.setVisibility(View.VISIBLE);
            listGridCollections.setVisibility(View.GONE);
        }else{
            progressCircularCollections.setVisibility(View.GONE);
            listGridCollections.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
