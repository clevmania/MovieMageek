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
        movieSlides.add(SlideModel(R.drawable.arrow,"Arrow"))
        movieSlides.add(SlideModel(R.drawable.blind_spot,"Blind Spot"))
        movieSlides.add(SlideModel(R.drawable.got,"Game of Thrones"))
        movieSlides.add(SlideModel(R.drawable.supernatural,"Supernatural"))
        movieSlides.add(SlideModel(R.drawable.the_orville,"The Orville"))
        movieSlides.add(SlideModel(R.drawable.the_walking_dead,"The Walking Dead"))
        v_slide_pager.adapter = SliderAdapter(this, movieSlides)
    }
}
