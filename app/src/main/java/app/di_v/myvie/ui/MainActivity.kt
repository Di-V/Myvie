package app.di_v.myvie.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.di_v.myvie.R
import app.di_v.myvie.ui.main.MainFragment
import app.di_v.myvie.ui.movie_details.MovieDetailsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                //.replace(R.id.container, MovieDetailsFragment.newInstance())
                .add(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}
