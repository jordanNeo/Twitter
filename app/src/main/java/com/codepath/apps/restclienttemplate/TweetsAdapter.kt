package com.codepath.apps.restclienttemplate

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.codepath.apps.restclienttemplate.models.Tweet

private const val TAG = "Tweets Adapter"
const val CLICKED = "CLICKED"

class TweetsAdapter(val context: Context,val tweets: ArrayList<Tweet>) : RecyclerView.Adapter<TweetsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)

        val view = inflater.inflate(R.layout.item_tweet, parent, false)

        return ViewHolder(context,view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tweet: Tweet = tweets.get(position)

        holder.tvUserName.text = tweet.user?.name
        holder.tvTweetBody.text = tweet.body

        Glide.with(holder.itemView).load(tweet.user?.publicImageUrl).transform(
            CenterInside(), RoundedCorners(16)
        ).into(holder.ivProfileImage)

    }

    fun clear() {
        tweets.clear()
        notifyDataSetChanged()
    }

    // Add a list of items -- change to type used
    fun addAll(tweetList: List<Tweet>) {
        tweets.addAll(tweetList)
        notifyDataSetChanged()
    }



    inner class ViewHolder(context: Context,itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val ivProfileImage = itemView.findViewById<ImageView>(R.id.ivProfileImage)
        val tvUserName = itemView.findViewById<TextView>(R.id.tvUsername)
        val tvTweetBody = itemView.findViewById<TextView>(R.id.tvTweetBody)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val tweet = tweets[adapterPosition]
            Toast.makeText(context, tweet.user?.name, Toast.LENGTH_SHORT)
            Log.i(TAG, tweet.user?.name)

            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(CLICKED, tweet)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return tweets.size
    }
}