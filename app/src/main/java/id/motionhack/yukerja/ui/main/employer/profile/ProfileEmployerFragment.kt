package id.motionhack.yukerja.ui.main.employer.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.motionhack.yukerja.databinding.FragmentProfileBinding
import id.motionhack.yukerja.databinding.FragmentProfileEmployerBinding
import id.motionhack.yukerja.ui.login.LoginActivity

class ProfileEmployerFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private var _binding: FragmentProfileEmployerBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileEmployerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogout.setOnClickListener {
            val intent= Intent(context,LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finishAffinity()
        }
    }
}