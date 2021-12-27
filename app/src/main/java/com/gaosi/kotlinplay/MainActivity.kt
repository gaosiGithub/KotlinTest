package com.gaosi.kotlinplay

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.ViewPager
import com.gaosi.kotlinplay.adapter.MainViewAdapter
import com.google.android.material.tabs.TabLayout
import android.view.WindowManager




class MainActivity : FragmentActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var mainViewAdapter: MainViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initWidget()
        initData()
    }

    private fun initWidget() {
        val window: Window = window
        window.clearFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
        )
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT


        tabLayout = findViewById(R.id.main_tabLayout)
        viewPager = findViewById(R.id.main_viewPager)
    }

    private fun initData() {
        Log.d("MainActivity","initData")
        val tabs: ArrayList<String> = ArrayList()
        for (i in 1..5) {
            tabs.add("tab$i")
            tabLayout.addTab(tabLayout.newTab().setText("tab$i"))
        }

        mainViewAdapter = MainViewAdapter(supportFragmentManager)
        mainViewAdapter.setTabs(tabs)

        viewPager.adapter = mainViewAdapter

        viewPager.setCurrentItem(2,true)

        tabLayout.setupWithViewPager(viewPager, false)

    }


}