package com.clevmania.moviemageek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.clevmania.moviemageek.adapter.SliderAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val timerDelay: Long = 500//delay in milliseconds before task is to be executed
    private val duration: Long = 3000

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
        tl_slide_indicator.setupWithViewPager(v_slide_pager, true)


        val handler = Handler()
        val update = Runnable {
            if (v_slide_pager.currentItem < movieSlides.size - 1) {
                v_slide_pager.currentItem = v_slide_pager.currentItem + 1
            }else
                v_slide_pager.currentItem = 0
        }

        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }, timerDelay, duration)
    }
}
