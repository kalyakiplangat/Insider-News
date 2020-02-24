package com.example.insidernews.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.insidernews.views.HomeFragment
import com.example.insidernews.views.SourceFragment

/**
 * Created by Enock on 2/24/20.
 */
class ViewPagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager) {

    private val mFragmentList=ArrayList<Fragment>()
    private val mFragmentTitleList=ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            2 -> SourceFragment()
            else -> 
        }
    }


    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return super.getPageTitle(position)
    }
}