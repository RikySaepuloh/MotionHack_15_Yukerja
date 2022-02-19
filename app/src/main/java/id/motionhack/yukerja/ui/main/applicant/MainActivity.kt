package id.motionhack.yukerja.ui.main.applicant

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


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigationView)
        val navController = findNavController(R.id.nav_host_fragment)

        bottomNavigationView.setupWithNavController(navController)
//        underlineMenuItem(binding.navigationView.menu.getItem(0)) // underline the default selected item when the activity is launched
//        binding.navigationView.setOnItemSelectedListener { item ->
////            removeItemsUnderline(binding.navigationView); // remove underline from all items
////            underlineMenuItem(item) // underline selected item
//            when(item.itemId) {
//                R.id.home -> {
//                    findNavController(R.id.nav_host_fragment).navigate(R.id.search_fragment)
//                    true
//                }
////                R.id.search -> {
////                    findNavController(R.id.nav_host_fragment).navigate(R.id.search_fragment)
////                    true
////                }
//                R.id.bookmark -> {
//                    findNavController(R.id.nav_host_fragment).navigate(R.id.bookmark_fragment)
//                    true
//                }
//                R.id.user -> {
//                    findNavController(R.id.nav_host_fragment).navigate(R.id.profile_fragment)
//                    true
//                }
//                else -> false
//            }
//        }
    }
////
//    private fun removeItemsUnderline(bottomNavigationView: BottomNavigationView) {
//        for (i in 0 until bottomNavigationView.menu.size()) {
//            val item: MenuItem = bottomNavigationView.menu.getItem(i)
//            item.title = item.title.toString()
//        }
//    }
//
//    private fun underlineMenuItem(item: MenuItem) {
//        val content = SpannableString(item.title)
//        content.setSpan(UnderlineSpan(), 0, content.length, 0)
//        item.title = content
//    }
}