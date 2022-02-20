package id.motionhack.yukerja.ui.main.employer.dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.motionhack.yukerja.databinding.ActivityAddVacancyBinding
import id.motionhack.yukerja.ui.main.employer.MainActivityEmployer

class AddVacancyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddVacancyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddVacancyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.btnContinue.setOnClickListener {
            val intent= Intent(this, MainActivityEmployer::class.java)
            startActivity(intent)
        }
    }
}