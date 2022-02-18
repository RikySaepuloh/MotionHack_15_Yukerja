package id.motionhack.yukerja.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.motionhack.yukerja.R
import id.motionhack.yukerja.databinding.ActivityDetailBinding
import id.motionhack.yukerja.databinding.ActivityJobTakenBinding

class JobTakenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJobTakenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobTakenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}