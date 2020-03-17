package app.di_v.myvie.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import app.di_v.myvie.R
import app.di_v.myvie.adapters.AppPagerAdapter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
    }

    private fun initUI() {
        main_viewpager.adapter = AppPagerAdapter(requireActivity().supportFragmentManager)
        main_viewpager.offscreenPageLimit = 3
        main_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) = Unit
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) = Unit

            override fun onPageSelected(position: Int) {
                main_bottom_navigation.menu.getItem(position).isChecked = true
            }
        })
        main_bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_one -> main_viewpager.currentItem = 0
                R.id.action_two -> main_viewpager.currentItem = 1
                R.id.menu_profile -> main_viewpager.currentItem = 2
            }
            true
        }
    }
}
