package id.motionhack.yukerja.ui.login.employer

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import id.motionhack.yukerja.R
import id.motionhack.yukerja.databinding.SignUpFragmentBinding
import id.motionhack.yukerja.databinding.SignUpFragmentEmployerBinding

class SignUpEmployerFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpEmployerFragment()
    }

    private var _binding: SignUpFragmentEmployerBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SignUpFragmentEmployerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCreateNew.setOnClickListener {
            this.findNavController().navigate(R.id.action_sign_up_employer_to_login)
        }
        binding.btnApplicant.setOnClickListener {
            this.findNavController().navigate(R.id.action_sign_up_employer_to_sign_up_applicant)
        }
    }
}