package com.example.gwen.movierater

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu3, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.saveReviewBtn)
        {
            var ratingstar: Float = movieRating.rating
            var myIntent = Intent(this, Main2Activity::class.java)
            myIntent.putExtra("ratingstar", ratingstar)
            myIntent.putExtra("moviereview", movieReview.text.toString())

            setResult(Activity.RESULT_OK, myIntent)
            finish()
        }
        else if (item?.itemId == android.R.id.home)
        {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
