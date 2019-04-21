package com.clevmania.moviemageek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clevmania.moviemageek.adapter.SliderAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSlidePager()
    }

    private fun setupSlidePager() {
        val movieSlides : ArrayList<SlideModel> = arrayListOf()
        movieSlides.add(SlideModel(R.drawable.ic_launcher_background,"Launcher"))
        v_slide_pager.adapter = SliderAdapter(this, movieSlides)
    }
}
