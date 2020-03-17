package app.di_v.myvie.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import app.di_v.myvie.ui.movie.MovieFragment
import app.di_v.myvie.ui.new_movie.NewMovieFragment
import app.di_v.myvie.ui.profile.ProfileFragment

class AppPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MovieFragment.newInstance()
            1 -> NewMovieFragment.newInstance()
            else -> ProfileFragment.newInstance()
        }
    }

    override fun getCount() = 3
}