package id.motionhack.yukerja.ui.main.employer.bookmark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.motionhack.yukerja.databinding.ActivityDetailBinding
import id.motionhack.yukerja.databinding.ActivityDetailPayBinding
import id.motionhack.yukerja.ui.main.employer.detail.JobTakenActivity

class DetailPayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailPayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.btnPay.setOnClickListener {
            val intent=Intent(this,PaymentSuccessActivity::class.java)
            startActivity(intent)
        }
    }
}