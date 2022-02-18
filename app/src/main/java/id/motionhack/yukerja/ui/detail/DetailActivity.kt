package id.motionhack.yukerja.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.motionhack.yukerja.R
import id.motionhack.yukerja.databinding.ActivityDetailBinding
import id.motionhack.yukerja.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}