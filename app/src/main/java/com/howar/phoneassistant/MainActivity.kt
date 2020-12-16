package com.howar.phoneassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private var headerView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawer_layout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerStateChanged(newState: Int) {
                Log.d(TAG, "onDrawerStateChanged")
            }

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                Log.d(TAG, "onDrawerSlide")
            }

            override fun onDrawerClosed(drawerView: View) {
                Log.d(TAG, "onDrawerClosed")
            }

            override fun onDrawerOpened(drawerView: View) {
                Log.d(TAG, "onDrawerOpened")
            }

        })

        headerView = navigation_view.getHeaderView(0)
        headerView?.setOnClickListener {
            Toast.makeText(this, "headerView clicked", Toast.LENGTH_SHORT).show()
        }
        navigation_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_app_update -> {
                    Toast.makeText(this, "点击了应用更新", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_message -> {
                    Toast.makeText(this, "点击了消息", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}