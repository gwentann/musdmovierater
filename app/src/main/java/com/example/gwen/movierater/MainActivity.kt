package com.example.gwen.movierater

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var moviename = findViewById(R.id.movie_name) as EditText;
        var overview = findViewById(R.id.movie_desc) as EditText;
        var releasedate = findViewById(R.id.movie_date) as EditText;
        var suitableforAll = "";
        var movielanguage = "";
        var movieReason = "";

        addmovie_btn.setOnClickListener() {
            if (checkBoxNotSuit.isChecked == false) {
                suitableforAll = "True"
            }
            if (checkBoxNotSuit.isChecked == true) {
                suitableforAll = "False"
            }

            if (checkboxLanguage.isChecked == true) {
                movieReason = "Language"
            }
            if (checkBoxViolence.isChecked == true){
                movieReason = "Violence"
            }
            if (checkboxLanguage.isChecked == true && checkBoxViolence.isChecked == true) {
                movieReason = "Language \n  Violence"
            }

            if (lang_eng.isChecked == true) {
                movielanguage = "English"
            }
            if (lang_chi.isChecked == true) {
                movielanguage = "Chinese"
            }
            if (lang_malay.isChecked == true) {
                movielanguage = "Malay"
            }
            if (lang_tamil.isChecked == true) {
                movielanguage = "Tamil"
            }

            if (movie_name.text.toString().isEmpty() == true)
            {
                movie_name.setError("Field empty");
            }
            if (movie_desc.text.toString().isEmpty() == true)
            {
                movie_desc.setError("Field empty");
            }
            if (movie_date.text.toString().isEmpty() == true)
            {
                movie_date.setError("Field empty");
            }
            if (checkBoxNotSuit.isChecked == false) {
                Toast.makeText(
                    this@MainActivity, "Title = " + moviename.text + "\n" +
                            "Overview = " + overview.text + "\n" + "Release Date = " + releasedate.text + "\n"
                            + "Language = " + movielanguage + "\n"
                            + "Suitable for all ages = " + suitableforAll + "\n", Toast.LENGTH_SHORT).show();
            }
            if (checkBoxNotSuit.isChecked == true) {
                Toast.makeText(
                    this@MainActivity, "Title = " + moviename.text + "\n" +
                            "Overview = " + overview.text + "\n" + "Release Date = " + releasedate.text + "\n"
                            + "Language = " + movielanguage + "\n"
                            + "Suitable for all ages = " + suitableforAll + "\n"
                            + "Reason = " + movieReason ,  Toast.LENGTH_SHORT).show();
            }

        }
    }

    fun notSuitableForAll(v: View) {
        if (checkBoxNotSuit.isChecked == true) {
            checkboxLanguage.visibility = View.VISIBLE;
            checkBoxViolence.visibility = View.VISIBLE;
        }
        else {
            checkboxLanguage.visibility = View.INVISIBLE;
            checkBoxViolence.visibility = View.INVISIBLE;
        }
    }

    fun raterValidator(v: View) {

    }
    fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

}
