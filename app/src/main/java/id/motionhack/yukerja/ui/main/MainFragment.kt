package id.motionhack.yukerja.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.motionhack.yukerja.databinding.MainFragmentBinding
import id.motionhack.yukerja.domain.model.DashboardItem
import id.motionhack.yukerja.ui.main.applicant.dashboard.DashboardAdapter

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val dataAdapter = DashboardAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
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
        val populateData = ArrayList<DashboardItem>()
        populateData.add(DashboardItem( title = "Review Apps", employer = "Motion Lab.", duration = "1",verified = true,disability = true, salary = "50.000"))
        populateData.add(DashboardItem( title = "Teaching Assistant", employer = "Computing Lab.", duration = "14",verified = false,disability = false, salary = "1.500.000"))
        populateData.add(DashboardItem( title = "Build Apps", employer = "Proclub.", duration = "1",verified = false,disability = false, salary = "2.700.000"))
        dataAdapter.initData(populateData)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}