package com.clevmania.moviemageek.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.clevmania.moviemageek.R
import com.clevmania.moviemageek.SlideModel

class SliderAdapter(private val context: Context, private val slidesList: List<SlideModel>): PagerAdapter() {
    private lateinit var slideMovieThumbnail: ImageView
    private lateinit var slideMovieTitle: TextView

    override fun getCount(): Int {
        return slidesList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_slider, container, false)

        slideMovieThumbnail = view.findViewById(R.id.iv_slide_movie_thumbnail)
        slideMovieTitle = view.findViewById(R.id.tv_slide_movie_title)

        slideMovieThumbnail.setBackgroundResource(slidesList[position].image)
        slideMovieTitle.text = slidesList[position].title

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}