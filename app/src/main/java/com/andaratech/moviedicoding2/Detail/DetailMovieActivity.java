package com.andaratech.moviedicoding2.Detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.andaratech.moviedicoding2.Movie.Movie;
import com.andaratech.moviedicoding2.R;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView txtNama, txtRilis, txtDeskripsi;
    private ImageView imgPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        txtNama = findViewById(R.id.txt_name_detail);
        txtRilis = findViewById(R.id.txt_rilis_detail);
        txtDeskripsi = findViewById(R.id.txt_detail);
        imgPhoto = findViewById(R.id.img_photo_detail);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        txtNama.setText(movie.getName());
        txtRilis.setText(movie.getRelease());
        txtDeskripsi.setText(movie.getDescription());
        imgPhoto.setImageResource(movie.getPhoto());


    }
}
