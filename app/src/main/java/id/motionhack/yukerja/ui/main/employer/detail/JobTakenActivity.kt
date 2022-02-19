package id.motionhack.yukerja.ui.main.employer.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.motionhack.yukerja.databinding.ActivityJobTakenBinding
import id.motionhack.yukerja.ui.main.applicant.MainActivity

class JobTakenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJobTakenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobTakenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnTapToContinue.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }

    override fun onBackPressed() {
//        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }
}