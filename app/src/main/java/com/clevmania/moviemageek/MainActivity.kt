package com.clevmania.moviemageek

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.clevmania.moviemageek.adapter.MovieAdapter
import com.clevmania.moviemageek.adapter.SliderAdapter
import com.clevmania.moviemageek.data.model.MovieModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private val timerDelay: Long = 500//delay in milliseconds before task is to be executed
    private val duration: Long = 3000
    private lateinit var adapter : MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSlidePager()
        showMovies()
        setUpClickListener()
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

    private fun showMovies(){
        val listOfMovies : ArrayList<MovieModel> = arrayListOf()
        listOfMovies.add(MovieModel("Arrow",R.drawable.arrow))
        listOfMovies.add(MovieModel("Game of thrones", R.drawable.got))
        listOfMovies.add(MovieModel("Arrow",R.drawable.arrow))
        listOfMovies.add(MovieModel("Game of thrones", R.drawable.got))
        listOfMovies.add(MovieModel("Arrow",R.drawable.arrow))
        listOfMovies.add(MovieModel("Game of thrones", R.drawable.got))

        rv_movie_list.setHasFixedSize(true)
        rv_movie_list.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        adapter = MovieAdapter(listOfMovies)
        rv_movie_list.adapter = adapter
    }

    private fun setUpClickListener(){
        adapter.fireClickListener(object : MovieItemClickListener{
            override fun onMovieItemClicked(movie: MovieModel, imageThumbnail: ImageView) {
                val detailedIntent = Intent(this@MainActivity, MovieDetailActivity::class.java)
                detailedIntent.putExtra("extra_title", movie.title)
                detailedIntent.putExtra("extra_url", movie.thumbnail)
//                startActivity(detailedIntent)

                val options = ActivityOptions.makeSceneTransitionAnimation(
                    this@MainActivity,imageThumbnail,"animateView")
                startActivity(detailedIntent,options.toBundle())
            }

        })
    }
}
