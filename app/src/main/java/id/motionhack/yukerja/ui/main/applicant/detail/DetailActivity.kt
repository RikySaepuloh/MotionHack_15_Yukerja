package id.motionhack.yukerja.ui.main.applicant.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.motionhack.yukerja.databinding.ActivityDetailBinding
import id.motionhack.yukerja.ui.main.employer.detail.JobTakenActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnTake.setOnClickListener {
            val intent= Intent(this, JobTakenActivity::class.java)
            startActivity(intent)
        }
    }
}