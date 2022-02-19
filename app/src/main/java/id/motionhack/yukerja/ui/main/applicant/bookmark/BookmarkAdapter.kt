package id.motionhack.yukerja.ui.main.applicant.bookmark

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import id.motionhack.yukerja.R
import id.motionhack.yukerja.databinding.ListBookmarkBinding
import id.motionhack.yukerja.domain.model.BookmarkItem
import id.motionhack.yukerja.ui.main.employer.detail.DetailVacancyActivity
import kotlin.collections.ArrayList


class BookmarkAdapter : RecyclerView.Adapter<BookmarkAdapter.DataPengajuanViewHolder>() {
    private var mFilteredList= mutableListOf<BookmarkItem>()
    private var mArrayList= mutableListOf<BookmarkItem>()
    lateinit var context:Context

    fun initData(data:ArrayList<BookmarkItem>){
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
        val binding=ListBookmarkBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataPengajuanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataPengajuanViewHolder, position: Int) {
        with(holder){
            with(mFilteredList[position]){
                binding.tvTitle.text = title
                if (verified){
                    binding.ivVerified.visibility=View.VISIBLE
                }else{
                    binding.ivVerified.visibility=View.INVISIBLE
                }
                if (disability){
                    binding.tvDisability.visibility=View.VISIBLE
                }else{
                    binding.tvDisability.visibility=View.INVISIBLE
                }
                binding.tvEmployer.text = employer
                binding.status.text = status
                if (status=="Rejected"){
                    binding.status.setTextColor(ContextCompat.getColor(context,R.color.red))
                }else{
                    binding.status.setTextColor(ContextCompat.getColor(context,R.color.green))
                }
                "Rp$salary".also { binding.tvSalary.text = it }
                "$duration".also { binding.tvDuration.text = it }
                binding.root.setOnClickListener {
                    val intent= Intent(context, DetailVacancyActivity::class.java)
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
//                    val filteredList: ArrayList<BookmarkItem> = ArrayList()
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
//                mFilteredList = (filterResults.values as ArrayList<BookmarkItem>?)!!
//                notifyDataSetChanged()
//
//            }
//        }
//    }

    inner class DataPengajuanViewHolder(val binding:ListBookmarkBinding):RecyclerView.ViewHolder(binding.root)

}