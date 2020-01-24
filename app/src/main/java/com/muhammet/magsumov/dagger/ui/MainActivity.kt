package com.muhammet.magsumov.dagger.ui
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.dagger.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.muhammet.magsumov.dagger.ui.feed.FeedFragment
import com.muhammet.magsumov.dagger.ui.map.MapFragment
import com.muhammet.magsumov.dagger.ui.schedule.ScheduleFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_schedule -> {
                replaceFragment(ScheduleFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_feed -> {
                replaceFragment(FeedFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_map -> {
                replaceFragment(MapFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Add product list fragment if this is first creation
        if (savedInstanceState == null) {
            val fragment = ScheduleFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment, ScheduleFragment.TAG).commit()
        }

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


    }
}
