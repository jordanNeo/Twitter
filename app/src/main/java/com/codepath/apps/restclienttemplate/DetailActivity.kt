package com.codepath.apps.restclienttemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.codepath.apps.restclienttemplate.R
import com.codepath.apps.restclienttemplate.models.Tweet

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tweet = intent.getParcelableExtra<Tweet>(CLICKED) as Tweet
        Log.i(TAG, "$tweet")

    }
}