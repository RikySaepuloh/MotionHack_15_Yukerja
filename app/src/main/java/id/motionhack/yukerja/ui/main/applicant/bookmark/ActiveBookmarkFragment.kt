package id.motionhack.yukerja.ui.main.applicant.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.motionhack.yukerja.databinding.FragmentActiveBookmarkBinding
import id.motionhack.yukerja.domain.model.BookmarkItem

class ActiveBookmarkFragment : Fragment() {
    val dataAdapter = BookmarkAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var _binding: FragmentActiveBookmarkBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentActiveBookmarkBinding.inflate(inflater, container, false)
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
        val populateData = ArrayList<BookmarkItem>()
        populateData.add(BookmarkItem( title = "Review Apps", employer = "Motion Lab.", duration = "1 day",verified = true,disability = true, salary = "50.000","On Going..."))
        dataAdapter.initData(populateData)
    }

}