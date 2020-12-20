package com.howar.phoneassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private var headerView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        tool_bar.inflateMenu(R.menu.toolbar_menu)
        val drawerToggle = ActionBarDrawerToggle(this, drawer_layout, tool_bar, R.string.open, R.string.close)
        drawerToggle.syncState()
        drawer_layout.addDrawerListener(drawerToggle)
    }
}