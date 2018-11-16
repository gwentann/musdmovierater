package com.example.gwen.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var movieDetails = MovieEntity(
            "Venom",
            "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego Venom to save his life.",
            "English",
            "03-10-2018",
            "Yes");

        movieTitle.text = movieDetails.MovieTitle;
        movieOverview.text = movieDetails.MovieDescription;
        movieLanguage.text = movieDetails.MovieLanguage;
        movieReleaseDate.text = movieDetails.MovieDate;
        movieSuitability.text = movieDetails.MovieSuit;
    }
}
