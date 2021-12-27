package com.gaosi.kotlinplay.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.gaosi.kotlinplay.fragment.FirstFragment
import com.gaosi.kotlinplay.fragment.SecondFragment
import com.gaosi.kotlinplay.fragment.ThirdFragment
import java.util.ArrayList

class MainViewAdapter(fragment: FragmentManager) :
    FragmentPagerAdapter(fragment, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabs: ArrayList<String> = ArrayList()

    override fun getCount(): Int = tabs.size

    override fun getItem(position: Int): Fragment {
        if (position == 0) {
            return FirstFragment.newInstance()
        } else if (position == 2) {
            return ThirdFragment.newInstance()
        }
        return SecondFragment.newInstance("", "")
    }

    override fun getPageTitle(position: Int): CharSequence {
        return tabs[position]
    }

    fun setTabs(tabs: ArrayList<String>) {
        this.tabs.addAll(tabs)
    }

}