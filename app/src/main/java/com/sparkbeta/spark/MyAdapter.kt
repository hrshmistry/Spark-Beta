package com.sparkbeta.spark

import android.content.Context;
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sparkbeta.spark.LiveScoreFragment

@Suppress("DEPRECATION")
class MyAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs  
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                LiveScoreFragment()
            }
            1 -> {
                TeamAFragment()
            }2 -> {
                TeamBFragment()
            }
            else -> TeamBFragment()
        }
    }

    // this counts total number of tabs  
    override fun getCount(): Int {
        return totalTabs
    }
}
