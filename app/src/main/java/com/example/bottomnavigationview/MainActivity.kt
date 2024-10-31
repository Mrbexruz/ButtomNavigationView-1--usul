package com.example.bottomnavigationview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bottomnavigationview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
         private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fm = supportFragmentManager
        val homeFragment=HomeFragment()
        val likesFragment=LikesFragment()
        val settingsFragment=SettingsFragment()

        fm.beginTransaction()
            .add(R.id.my_container, homeFragment)
            .commit()
        binding.myBottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_home-> {
                    fm.beginTransaction().replace(R.id.my_container, homeFragment)
                        .commit()
                }
                R.id.menu_likes->{
                    fm.beginTransaction().replace(R.id.my_container, likesFragment)
                        .commit()

                }
                R.id.menu_settings->{
                    fm.beginTransaction().replace(R.id.my_container, settingsFragment)
                        .commit()
                }
            }

            true
        }
    }
}