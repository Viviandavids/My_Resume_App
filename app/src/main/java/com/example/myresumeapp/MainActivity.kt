package com.example.myresumeapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    private lateinit var linkedin: ImageButton
    private lateinit var twitter: ImageButton
    private lateinit var github: ImageButton
    private lateinit var instagram: ImageButton
    private lateinit var changeTheme:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SocialMediaLink()

       chooseThemeDialog()
    }

    private fun SocialMediaLink(){
     // get reference to button
     linkedin = findViewById(R.id.linkedIn)
     twitter = findViewById(R.id.twitter)
     github = findViewById(R.id.github)
     instagram = findViewById(R.id.instagram)

        //set on click listener for the button
        linkedin.setOnClickListener {
            val i =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/viviandavids/"))
            startActivity(i)
        }

        twitter.setOnClickListener {
            val i =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Viviannedavids/"))
            startActivity(i)
        }

        github.setOnClickListener {
            val i =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Viviandavids"))
            startActivity(i)
        }

        instagram.setOnClickListener {
            val i =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/viviendavids?r=nametag"))
            startActivity(i)
        }
     }

    private fun chooseThemeDialog() {
        changeTheme = findViewById(R.id.changeTheme)
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.choose_theme_text))
        val styles = arrayOf("Light","Dark","System default")
        val checkedItem = 0

        builder.setSingleChoiceItems(styles, checkedItem) { dialog, which ->

            when (which) {
                0 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    delegate.applyDayNight()
                    dialog.dismiss()
                }
                1 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    delegate.applyDayNight()

                    dialog.dismiss()
                }
                2 -> {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
                    delegate.applyDayNight()
                    dialog.dismiss()
                }

            }
        }
        changeTheme.setOnClickListener { chooseThemeDialog() }

        val dialog = builder.create()
        dialog.show()
    }
}
