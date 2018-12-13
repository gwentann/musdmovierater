package com.example.gwen.movierater

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {

    val TESTING101 = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lang_eng.isChecked = true



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu1, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.addMovieBtn)
        {
            var movielanguage = ""
            var movieNotSuit = ""
            lang_eng.isChecked = true
            if (checkBoxNotSuit.isChecked == false)
            {
                movieNotSuit = "Yes"
            }
            if (checkboxLanguage.isChecked == true)
            {
                movieNotSuit = "No (Language)"
            }
            if (checkBoxViolence.isChecked == true)
            {
                movieNotSuit = "No (Violence)"
            }
            if (lang_eng.isChecked == true) {
                movielanguage = "English"
            }
            else if (lang_chi.isChecked == true) {
                movielanguage = "Chinese"
            }
            else if (lang_malay.isChecked == true) {
                movielanguage = "Malay"
            }
            else if (lang_tamil.isChecked == true) {
                movielanguage = "Tamil"
            }
            var myIntent = Intent(this, Main2Activity::class.java )
            myIntent.putExtra("name", movie_name.text.toString())
            myIntent.putExtra("description", movie_desc.text.toString())
            myIntent.putExtra("date", movie_date.text.toString())
            myIntent.putExtra("language", movielanguage.toString())
            myIntent.putExtra("suit", movieNotSuit.toString())
            startActivityForResult(myIntent, TESTING101)
        }
        if (item?.itemId == R.id.clearEntriesBtn)
        {
            movie_name.text.clear()
            movie_desc.text.clear()
            movie_date.text.clear()
            checkBoxNotSuit.isChecked = false
            checkBoxViolence.isChecked = false
            checkboxLanguage.isChecked = false
            lang_eng.isChecked = true
            lang_chi.isChecked = false
            lang_malay.isChecked = false
            lang_tamil.isChecked = false
            checkBoxViolence.visibility = View.INVISIBLE
            checkboxLanguage.visibility = View.INVISIBLE

        }


        return super.onOptionsItemSelected(item)
    }

    fun notSuitableForAll(v: View) {
        if (checkBoxNotSuit.isChecked == true) {
            checkboxLanguage.visibility = View.VISIBLE
            checkBoxViolence.visibility = View.VISIBLE
        }
        else {
            checkboxLanguage.visibility = View.INVISIBLE
            checkBoxViolence.visibility = View.INVISIBLE
        }
    }

    fun raterValidator(v: View) {

    }
    fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

}
