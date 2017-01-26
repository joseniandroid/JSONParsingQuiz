package com.avidcoder.jsonparsingquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.avidcoder.jsonparsingquiz.controllers.MoviesController;
import com.avidcoder.jsonparsingquiz.models.Movie;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imgPoster = (ImageView) findViewById(R.id.imgPoster);
        final TextView tvData = (TextView) findViewById(R.id.tvData);
        final MoviesController controller = new MoviesController();
        final String json = MoviesController.getBatmanJson(this);

        findViewById(R.id.btnParse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie movie = controller.getMovieFromJson(json);
                if (movie != null) {
                    Glide.with(MainActivity.this)
                            .load(movie.getPosterUrl())
                            .crossFade()
                            .into(imgPoster);
                    tvData.setText(movie.toString());
                }
            }
        });
    }
}
