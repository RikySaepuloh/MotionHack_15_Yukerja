package id.motionhack.yukerja.ui.main.employer.bookmark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.motionhack.yukerja.databinding.ActivityDetailBinding
import id.motionhack.yukerja.databinding.ActivityDetailPayBinding
import id.motionhack.yukerja.databinding.ActivityPaymentSuccessBinding
import id.motionhack.yukerja.ui.main.applicant.MainActivity
import id.motionhack.yukerja.ui.main.employer.MainActivityEmployer
import id.motionhack.yukerja.ui.main.employer.detail.JobTakenActivity

class PaymentSuccessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaymentSuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentSuccessBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnTapToContinue.setOnClickListener {
            val intent = Intent(this, MainActivityEmployer::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivityEmployer::class.java)
        startActivity(intent)
        finishAffinity()
    }
}