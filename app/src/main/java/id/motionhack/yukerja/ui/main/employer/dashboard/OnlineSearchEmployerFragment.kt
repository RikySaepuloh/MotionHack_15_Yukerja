package id.motionhack.yukerja.ui.main.employer.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.motionhack.yukerja.databinding.*
import id.motionhack.yukerja.domain.model.VacancyItem

class OnlineSearchEmployerFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var _binding: SearchOnlineEmployerFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val dataAdapter = DashboardEmployerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SearchOnlineEmployerFragmentBinding.inflate(inflater, container, false)
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
        populateData.add(VacancyItem( title = "Review Apps", employer = "Motion Lab.", duration = "1 day", limit = "3/10",disability = true, salary = "50.000"))
        populateData.add(VacancyItem( title = "Teaching Assistant", employer = "Computing Lab.", duration = "14 day",limit = "5/8",disability = false, salary = "1.500.000"))
        populateData.add(VacancyItem( title = "Build Apps", employer = "Proclub.", duration = "30 day",limit = "8/10",disability = false, salary = "2.700.000"))
        dataAdapter.initData(populateData)
    }

}