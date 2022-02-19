package id.motionhack.yukerja.ui.main.applicant.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import id.motionhack.yukerja.databinding.BookmarkFragmentBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

private const val NUM_PAGES = 3

class BookmarkFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var _binding: BookmarkFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BookmarkFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
                    tab.text = "Active"
                }
                1 -> {
                    tab.text = "Pending"
                }
                2 -> {
                    tab.text = "History"
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
                    ActiveBookmarkFragment()
                }
                1 -> {
                    PendingBookmarkFragment()
                }
                2 -> {
                    HistoryBookmarkFragment()
                }
                else -> {
                    ActiveBookmarkFragment()
                }
            }
        }

    }


}