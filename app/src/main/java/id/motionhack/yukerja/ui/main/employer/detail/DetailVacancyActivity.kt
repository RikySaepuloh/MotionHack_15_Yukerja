package id.motionhack.yukerja.ui.main.employer.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import id.motionhack.yukerja.databinding.ActivityDetailBinding
import id.motionhack.yukerja.databinding.ActivityDetailVacancyBinding
import id.motionhack.yukerja.domain.model.ApplicantItem

class DetailVacancyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailVacancyBinding
    val dataAdapter=DetailVacancyAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVacancyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = dataAdapter
        binding.btnClose.setOnClickListener {
            finish()
        }
        initData()
    }

    fun initData(){
        val data = ArrayList<ApplicantItem>()
        data.add(ApplicantItem("Riky Saepuloh","Android Developer","28","Master of Informatics"))
        data.add(ApplicantItem("David Beckham","College Student","15","Master of Informatics"))
        dataAdapter.initData(data)
    }
}