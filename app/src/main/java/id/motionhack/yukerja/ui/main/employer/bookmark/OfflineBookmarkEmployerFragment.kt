package id.motionhack.yukerja.ui.main.employer.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.motionhack.yukerja.databinding.OfflineBookmarkEmployerFragmentBinding
import id.motionhack.yukerja.databinding.OnlineBookmarkEmployerFragmentBinding
import id.motionhack.yukerja.databinding.SearchOfflineFragmentBinding
import id.motionhack.yukerja.domain.model.ApplicantPayItem

class OfflineBookmarkEmployerFragment : Fragment() {
    val dataAdapter = BookmarkEmployerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var _binding: OfflineBookmarkEmployerFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = OfflineBookmarkEmployerFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.adapter = dataAdapter
        initData()
    }

    private fun initData() {
        val populateData = ArrayList<ApplicantPayItem>()
        populateData.add(ApplicantPayItem( name = "Kugisaki Adinda", jobPosition = "College Student", jobTaken = "13 jobs", education = "Master of Fine Arts", status = "The job is done."))
        populateData.add(ApplicantPayItem( name = "Fushigoro Riky", jobPosition = "College Student", jobTaken = "5 jobs", education = "Master of Science", status = "The job is done."))
        dataAdapter.initData(populateData)
    }

}