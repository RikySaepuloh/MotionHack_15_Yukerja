package id.motionhack.yukerja.ui.main.employer.detail

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.motionhack.yukerja.databinding.ListApplicantBinding
import id.motionhack.yukerja.domain.model.ApplicantItem


class DetailVacancyAdapter : RecyclerView.Adapter<DetailVacancyAdapter.DataPengajuanViewHolder>() {
    private var mFilteredList= mutableListOf<ApplicantItem>()
    private var mArrayList= mutableListOf<ApplicantItem>()
    lateinit var context:Context

    fun initData(data:ArrayList<ApplicantItem>){
        mFilteredList.clear()
        mArrayList.clear()
        mFilteredList.addAll(data)
        mArrayList.addAll(data)
        notifyDataSetChanged()
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context=recyclerView.context
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataPengajuanViewHolder {
        val binding=ListApplicantBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataPengajuanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataPengajuanViewHolder, position: Int) {
        with(holder){
            with(mFilteredList[position]){
                binding.tvName.text = name
                binding.tvPosition.text = jobPosition
                binding.tvJobTaken.text = jobTaken
                binding.tvEducation.text = education
                binding.root.setOnClickListener {
                    val intent= Intent(context, DetailApplicantActivity::class.java)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return mFilteredList.size
    }

//    fun getFilter(): Filter? {
//        return object : Filter() {
//            override fun performFiltering(charSequence: CharSequence): FilterResults? {
//                val charString = charSequence.toString().toLowerCase(Locale.ROOT)
//                mFilteredList = if (charString.isEmpty()) {
//                    mArrayList
//                } else {
//                    val filteredList: ArrayList<ApplicantItem> = ArrayList()
//                    for (dataPengajuan in mArrayList) {
//                        if (
//                            dataPengajuan.noBukti?.lowercase(Locale.ROOT)?.contains(charString)!!
//                            ||dataPengajuan.noDokumen?.lowercase(Locale.ROOT)?.contains(charString)!!
//                            ||dataPengajuan.keterangan?.lowercase(Locale.ROOT)?.contains(charString)!!
//                            ||dataPengajuan.kodePp?.lowercase(Locale.ROOT)?.contains(charString)!!
//                            ||dataPengajuan.namaPp?.lowercase(Locale.ROOT)?.contains(charString)!!
//                            ||dataPengajuan.tanggal?.lowercase(Locale.ROOT)?.contains(charString)!!
//                            ||dataPengajuan.modul?.lowercase(Locale.ROOT)?.contains(charString)!!
//                            ||dataPengajuan.nilai?.lowercase(Locale.ROOT)?.contains(charString)!!
//                            ||dataPengajuan.dueDate?.lowercase(Locale.ROOT)?.contains(charString)!!
//                        ) {
//                            filteredList.add(dataPengajuan)
//                        }
//                    }
//                    filteredList
//                }
//                val filterResults = FilterResults()
//                filterResults.values = mFilteredList
//                return filterResults
//            }
//
//            override fun publishResults(
//                charSequence: CharSequence?,
//                filterResults: FilterResults
//            ) {
//                mFilteredList = (filterResults.values as ArrayList<ApplicantItem>?)!!
//                notifyDataSetChanged()
//
//            }
//        }
//    }

    inner class DataPengajuanViewHolder(val binding:ListApplicantBinding):RecyclerView.ViewHolder(binding.root)

}