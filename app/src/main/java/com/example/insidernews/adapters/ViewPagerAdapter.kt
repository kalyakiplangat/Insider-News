package com.example.insidernews.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.insidernews.views.home.HomeFragment

/**
 * Created by Enock on 2/24/20.
 */
class ViewPagerAdapter(manager:FragmentManager):FragmentPagerAdapter(manager) {
    private val mFragmentList=ArrayList<Fragment>()
    private val mFragmentTitleList=ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment,Title:String){
        mFragmentList.add(fragment)
        mFragmentTitleList.add(Title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }

}