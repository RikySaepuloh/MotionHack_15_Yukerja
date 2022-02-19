package id.motionhack.yukerja.ui.main.employer

import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.motionhack.yukerja.R
import id.motionhack.yukerja.databinding.ActivityMainBinding
import id.motionhack.yukerja.databinding.ActivityMainEmployerBinding


class MainActivityEmployer : AppCompatActivity() {
    private lateinit var binding: ActivityMainEmployerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainEmployerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigationView)
        val navController = findNavController(R.id.nav_host_fragment)

        bottomNavigationView.setupWithNavController(navController)

    }

}