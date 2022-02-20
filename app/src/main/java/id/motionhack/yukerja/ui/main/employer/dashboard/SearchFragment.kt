package id.motionhack.yukerja.ui.main.employer.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import id.motionhack.yukerja.Preferences
import id.motionhack.yukerja.databinding.SearchFragmentBinding

private const val NUM_PAGES = 2

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private var _binding: SearchFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val preferences = Preferences()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SearchFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences.setPreferences(requireContext())
        if (preferences.getUserRole()!="Applicant"){
            binding.searchview.queryHint = "Recent Vacancy"
        }
        binding.fabAdd.visibility= View.VISIBLE
        binding.fabAdd.setOnClickListener {
            val intent=Intent(context,AddVacancyActivity::class.java)
            startActivity(intent)
        }
        initTabLayoutViewpager()
    }

    fun initTabLayoutViewpager(){
        val tabLayout = binding.tabLayout
        binding.viewpager.offscreenPageLimit=4
        val pagerAdapter = activity?.let { ScreenSlidePagerAdapter(it) }
        binding.viewpager.adapter = pagerAdapter
        TabLayoutMediator(tabLayout, binding.viewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Online"
                }
                1 -> {
                    tab.text = "Offline"
                }
            }
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewpager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> {
                    OnlineSearchEmployerFragment()
                }
                1 -> {
                    OfflineSearchEmployerFragment()
                }
                else -> {
                    OnlineSearchEmployerFragment()
                }
            }
        }

    }
}