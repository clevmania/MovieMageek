package com.clevmania.moviemageek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        GlideApp.with(this).load(intent.getIntExtra("extra_url",0))
            .into(iv_detailed_movie_thumbnail)
        tv_movie_title.text = intent.getStringExtra("extra_title")
        supportActionBar?.title = intent.getStringExtra("extra_title")
        iv_movie_cover.animation = AnimationUtils.loadAnimation(this,R.anim.scale_anim)
        fab_play_detail.animation = AnimationUtils.loadAnimation(this,R.anim.scale_anim)
    }
}
