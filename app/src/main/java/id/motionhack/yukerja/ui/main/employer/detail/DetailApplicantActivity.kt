package id.motionhack.yukerja.ui.main.employer.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.motionhack.yukerja.databinding.ActivityDetailApplicantBinding

class DetailApplicantActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailApplicantBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailApplicantBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.btnAccept.setOnClickListener {
//            val intent= Intent(this, JobTakenActivity::class.java)
//            startActivity(intent)
        }
    }
}