package com.andaratech.moviedicoding2.Movie;


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

import com.andaratech.moviedicoding2.Detail.DetailMovieActivity;
import com.andaratech.moviedicoding2.ItemClickSupport;
import com.andaratech.moviedicoding2.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private RecyclerView rcMovieCategory;
    private String dataName[];
    private String dataRealese[];
    private String dataDescription[];
    private TypedArray imgPhoto;

    private ArrayList<Movie> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         ListMovieAdapter adapter;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        rcMovieCategory = view.findViewById(R.id.rv_movie);
        rcMovieCategory.setHasFixedSize(true);

        setArr();
        list.addAll(this.getListData());

        rcMovieCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        ListMovieAdapter listMovieAdapter = new ListMovieAdapter(getActivity());
        listMovieAdapter.setMovies(list);
        rcMovieCategory.setAdapter(listMovieAdapter);

        ItemClickSupport.addTo(rcMovieCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Movie movie = new Movie();
                movie.setName(dataName[position]);
                movie.setRelease(dataRealese[position]);
                movie.setDescription(dataDescription[position]);
                movie.setPhoto(imgPhoto.getResourceId(position,-1));

                Intent moveWithObjectIntent = new Intent(getActivity(), DetailMovieActivity.class);
                moveWithObjectIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE,movie);
                startActivity(moveWithObjectIntent);


                showSelectedMovie(list.get(position));
            }
        });

            return view ;
    }


    private void showSelectedMovie(Movie movie){

        Toast.makeText(MovieFragment.this.getContext(), "Kamu memilih "+movie.getName(), Toast.LENGTH_SHORT).show();
    }

    public  ArrayList<Movie> getListData(){

        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0 ; i < dataName.length; i++){
            Movie movie = new Movie();
            movie.setPhoto(imgPhoto.getResourceId(i,-1));
            movie.setName(dataName[i]);
            movie.setRelease(dataRealese[i]);
           movie.setDescription(dataDescription[i]);
            movies.add(movie);
        }

        Log.e("arr", String.valueOf(movies.toArray()));
        return movies;
    }

    private void setArr(){
        dataName= getActivity().getResources().getStringArray(R.array.data_name_movie);
        dataRealese =  getActivity().getResources().getStringArray(R.array.data_release_movie);
        dataDescription =  getActivity().getResources().getStringArray(R.array.data_description_movie);
        imgPhoto =  getActivity().getResources().obtainTypedArray(R.array.data_photo_movie);

    }


}


