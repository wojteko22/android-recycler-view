package pl.edu.pwr.wojciech.okonski.lab2.lab2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    private val movieList = ArrayList<Movie>()
    private var adapter: MoviesAdapter by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        adapter = MoviesAdapter(movieList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.addOnItemTouchListener(RecyclerTouchListener(applicationContext, recyclerView, object : ClickListener {
            override fun onClick(view: View, position: Int) {
                val movie = movieList[position]
                Toast.makeText(applicationContext, movie.title + " is selected!", Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(view: View, position: Int) {}
        }))
        prepareMovieData()
    }

    private fun prepareMovieData() {
        movieList += arrayOf(
                Movie("Mad Max: Fury Road", "Action & Adventure", "2015"),
                Movie("Inside Out", "Animation, Kids & Family", "2015"),
                Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015"),
                Movie("Shaun the Sheep", "Animation", "2015"),
                Movie("The Martian", "Science Fiction & Fantasy", "2015"),
                Movie("Mission: Impossible Rogue Nation", "Action", "2015"),
                Movie("Up", "Animation", "2009"),
                Movie("Star Trek", "Science Fiction", "2009"),
                Movie("The LEGO Movie", "Animation", "2014"),
                Movie("Iron Man", "Action & Adventure", "2008"),
                Movie("Aliens", "Science Fiction", "1986"),
                Movie("Chicken Run", "Animation", "2000"),
                Movie("Back to the Future", "Science Fiction", "1985"),
                Movie("Raiders of the Lost Ark", "Action & Adventure", "1981"),
                Movie("Goldfinger", "Action & Adventure", "1965"),
                Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014")
        )
        adapter.notifyDataSetChanged()
    }
}
