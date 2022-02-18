package id.motionhack.yukerja.ui.main.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.motionhack.yukerja.R
import id.motionhack.yukerja.databinding.BookmarkFragmentBinding
import id.motionhack.yukerja.databinding.FragmentActiveBookmarkBinding
import id.motionhack.yukerja.databinding.FragmentHistoryBookmarkBinding
import id.motionhack.yukerja.databinding.FragmentPendingBookmarkBinding

class HistoryBookmarkFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private var _binding: FragmentHistoryBookmarkBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryBookmarkBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}