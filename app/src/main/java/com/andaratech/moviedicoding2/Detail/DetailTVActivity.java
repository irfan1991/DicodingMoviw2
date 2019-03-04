package com.andaratech.moviedicoding2.Detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.andaratech.moviedicoding2.Movie.Movie;
import com.andaratech.moviedicoding2.R;
import com.andaratech.moviedicoding2.TV.TV;

public class DetailTVActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private TextView txtNama, txtRilis, txtDeskripsi;
    private ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);

        txtNama = findViewById(R.id.txt_name_detail);
        txtRilis = findViewById(R.id.txt_rilis_detail);
        txtDeskripsi = findViewById(R.id.txt_detail);
        imgPhoto = findViewById(R.id.img_photo_detail);

        TV tv = getIntent().getParcelableExtra(EXTRA_MOVIE);
        txtNama.setText(tv.getName());
        txtRilis.setText(tv.getRelease());
        txtDeskripsi.setText(tv.getDescription());
        imgPhoto.setImageResource(tv.getPhoto());
    }
}
