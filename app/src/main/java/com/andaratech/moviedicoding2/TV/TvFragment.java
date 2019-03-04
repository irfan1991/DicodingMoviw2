package com.andaratech.moviedicoding2.TV;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.andaratech.moviedicoding2.Detail.DetailTVActivity;
import com.andaratech.moviedicoding2.ItemClickSupport;
import com.andaratech.moviedicoding2.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment {
    private RecyclerView rcTVCategory;
    private String dataName[];
    private String dataRealese[];
    private String dataDescription[];
    private TypedArray imgPhoto;

    private ArrayList<TV> list = new ArrayList<>();


    public TvFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListTVAdapter adapter;
        View view = inflater.inflate(R.layout.fragment_tv, container, false);
        rcTVCategory = view.findViewById(R.id.rv_tv);
        rcTVCategory.setHasFixedSize(true);

        setArr();
        list.addAll(this.getListData());
        rcTVCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListTVAdapter listTVAdapter = new ListTVAdapter(getActivity());
        listTVAdapter.setTvs(list);
        rcTVCategory.setAdapter(listTVAdapter);

        ItemClickSupport.addTo(rcTVCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedTV(list.get(position));
                TV tv = new TV();
                tv.setName(dataName[position]);
                tv.setRelease(dataRealese[position]);
                tv.setDescription(dataDescription[position]);
                tv.setPhoto(imgPhoto.getResourceId(position,-1));

                Intent moveWithObjectIntent = new Intent(getActivity(), DetailTVActivity.class);
                moveWithObjectIntent.putExtra(DetailTVActivity.EXTRA_MOVIE,tv);
                startActivity(moveWithObjectIntent);
            }
        });

        return view ;
    }


    private void showSelectedTV(TV tv){

        Toast.makeText(TvFragment.this.getContext(), "Kamu memilih "+tv.getName(), Toast.LENGTH_SHORT).show();
    }

    public  ArrayList<TV> getListData(){


        ArrayList<TV> tvs = new ArrayList<>();
        for (int i = 0 ; i < dataName.length; i++){
            TV t = new TV();
            t.setPhoto(imgPhoto.getResourceId(i,-1));
            t.setName(dataName[i]);
            t.setRelease(dataRealese[i]);
            t.setDescription(dataDescription[i]);
            tvs.add(t);
        }

        Log.e("arr", String.valueOf(tvs.toArray()));
        return tvs;
    }

    private void setArr(){
        dataName= getActivity().getResources().getStringArray(R.array.data_name_tv);
        dataRealese =  getActivity().getResources().getStringArray(R.array.data_release_tv);
        dataDescription =  getActivity().getResources().getStringArray(R.array.data_description_tv);
        imgPhoto =  getActivity().getResources().obtainTypedArray(R.array.data_photo_tv);
    }



}
