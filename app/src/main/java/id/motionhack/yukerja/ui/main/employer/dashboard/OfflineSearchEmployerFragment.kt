package id.motionhack.yukerja.ui.main.employer.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.motionhack.yukerja.databinding.SearchOfflineFragmentBinding
import id.motionhack.yukerja.domain.model.VacancyItem

class OfflineSearchEmployerFragment : Fragment() {
    val dataAdapter = DashboardEmployerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var _binding: SearchOfflineFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SearchOfflineFragmentBinding.inflate(inflater, container, false)
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
        val populateData = ArrayList<VacancyItem>()
        populateData.add(VacancyItem( title = "Burgerman", employer = "Burger King.", duration = "4 hours",limit = "3/5",disability = false, salary = "400.000"))
        populateData.add(VacancyItem( title = "Courier Delivery", employer = "Burger King.", duration = "4 hours", limit = "6/7",disability = false, salary = "250.000"))
        dataAdapter.initData(populateData)
    }

}