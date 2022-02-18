package id.motionhack.yukerja.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.motionhack.yukerja.R
import id.motionhack.yukerja.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.main_fragment)
                    true
                }
                R.id.search -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.search_fragment)
                    true
                }
                R.id.bookmark -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.bookmark_fragment)
                    true
                }
                R.id.user -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.profile_fragment)
                    true
                }
                else -> false
            }
        }
    }
}