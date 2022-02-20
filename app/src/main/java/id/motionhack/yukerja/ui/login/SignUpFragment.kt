package id.motionhack.yukerja.ui.login

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import id.motionhack.yukerja.R
import id.motionhack.yukerja.databinding.SignUpFragmentBinding
import id.motionhack.yukerja.ui.main.applicant.MainActivity

class SignUpFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: SignUpViewModel

    private var _binding: SignUpFragmentBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SignUpFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvCreateNew.setOnClickListener {
            this.findNavController().navigate(R.id.action_sign_up_to_login)
        }

        binding.btnContinue.setOnClickListener {
            val intent= Intent(context,MainActivity::class.java)
            startActivity(intent)
            requireActivity().finishAffinity()
        }

        binding.spinner.setItems(listOf("I'm an Applicant","I'm an Employer"))

//        binding.btnEmployer.setOnClickListener {
//            this.findNavController().navigate(R.id.action_sign_up_to_sign_up_employer)
//        }
    }
}