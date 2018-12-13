package com.example.gwen.movierater

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)


        registerForContextMenu(addReview)

        var movienamefromactivity = intent.getStringExtra("name")
        var moviedescfromactivity = intent.getStringExtra("description")
        var moviedatefromactivity = intent.getStringExtra("date")
        var movielangfromactivity = intent.getStringExtra("language")
        var moviesuitfromactivity = intent.getStringExtra("suit")
        movieTitle.text = "$movienamefromactivity"
        movieOverview.text = "$moviedescfromactivity"
        movieReleaseDate.text = "$moviedatefromactivity"
        movieLanguage.text = "$movielangfromactivity"
        movieSuitability.text = "$moviesuitfromactivity"
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.addReview) {
            menu?.add(2, 124, 2, "Add Review")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 124) {
            var myIntent = Intent(this, Main3Activity::class.java)
            startActivityForResult(myIntent, 1)
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home)
        {
            var myIntent = Intent(this, Main4Activity::class.java)
            startActivity(myIntent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                addReview.visibility = View.GONE
                movieview.visibility = View.VISIBLE
                movierate.visibility = View.VISIBLE
                var getreviewfrommain = data!!.getStringExtra("moviereview")
                var getratefrommain = data!!.getFloatExtra("ratingstar", 0.0f)
                movieview.text = getreviewfrommain
                movierate.rating = getratefrommain
            }
        }
    }
}
