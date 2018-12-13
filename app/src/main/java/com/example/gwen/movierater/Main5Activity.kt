package com.example.gwen.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main5.*

class Main5Activity : AppCompatActivity() {

    val TESTING102 = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)



        var movieDetails = MovieEntity(
            "Avengers", "Movie about a lot of people hitting each other", "English", "2001", "Yes"
        )

        moviename.setText(movieDetails.MovieTitle)
        moviedesc.setText(movieDetails.MovieDescription)
        moviedate.setText(movieDetails.MovieDate)
        if (movieDetails.MovieLanguage == "English")
        {
            langeng.isChecked = true
        }
        if (movieDetails.MovieSuit == "Yes")
        {
            checkBox_NotSuit.isChecked = false
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu2,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.saveBtn)
        {
            var movielang = ""
            var movieNotSuitable = ""
            langeng.isChecked = true
            if (checkBox_NotSuit.isChecked == false)
            {
                movieNotSuitable = "Yes"
            }
            if (checkbox_Language.isChecked == true)
            {
                movieNotSuitable = "No (Language)"
            }
            if (checkBox_Violence.isChecked == true)
            {
                movieNotSuitable = "No (Violence)"
            }
            if (langeng.isChecked == true) {
                movielang = "English"
            }
            else if (langchi.isChecked == true) {
                movielang = "Chinese"
            }
            else if (langmalay.isChecked == true) {
                movielang = "Malay"
            }
            else if (langtamil.isChecked == true) {
                movielang = "Tamil"
            }
            var myIntent = Intent(this, Main2Activity::class.java)
            myIntent.putExtra("name", moviename.text.toString())
            myIntent.putExtra("description", moviedesc.text.toString())
            myIntent.putExtra("date", moviedate.text.toString())
            myIntent.putExtra("language", movielang)
            myIntent.putExtra("suit", movieNotSuitable)
            startActivityForResult(myIntent, 1)
        }
        if (item?.itemId == R.id.cancelBtn)
        {
            var myIntent = Intent(this, Main4Activity::class.java)
            startActivity(myIntent)
        }
        return super.onOptionsItemSelected(item)
    }
    fun notSuitableForAll(v: View) {
        if (checkBox_NotSuit.isChecked == true) {
            checkbox_Language.visibility = View.VISIBLE
            checkBox_Violence.visibility = View.VISIBLE
        }
        else {
            checkbox_Language.visibility = View.INVISIBLE
            checkBox_Violence.visibility = View.INVISIBLE
        }
    }
}
