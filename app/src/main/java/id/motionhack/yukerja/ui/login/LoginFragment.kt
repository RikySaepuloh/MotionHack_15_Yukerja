package id.motionhack.yukerja.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import id.motionhack.yukerja.Preferences
import id.motionhack.yukerja.R
import id.motionhack.yukerja.databinding.LoginFragmentBinding
import id.motionhack.yukerja.ui.main.applicant.MainActivity
import id.motionhack.yukerja.ui.main.employer.MainActivityEmployer


class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginFragmentViewModel
    lateinit var mGoogleSignInClient : GoogleSignInClient
    private var _binding: LoginFragmentBinding? = null
    var RC_SIGN_IN = 1001
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var preferences  = Preferences()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(LoginFragmentViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences.setPreferences(requireContext())
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        mGoogleSignInClient = activity?.let { it1 -> GoogleSignIn.getClient(it1, gso) }!!
        binding.btnLogin.setOnClickListener {
            if (binding.etEmail.text.toString()!=""){
                val intent= Intent(context, MainActivityEmployer::class.java)
                startActivity(intent)
                requireActivity().finish()
            }else{
                val intent= Intent(context, MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }

        }
        binding.tvCreateNew.setOnClickListener {
            this.findNavController().navigate(R.id.action_login_to_sign_up)
        }
        binding.btnLoginGoogle.setOnClickListener {
            signIn()
        }
    }

    private fun signIn() {
        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }else{
            Toast.makeText(context,"asas",Toast.LENGTH_LONG).show()
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        val intent=Intent(context,MainActivity::class.java)
        startActivity(intent)
        activity?.finish()

//        try {
//            val account = completedTask.getResult(ApiException::class.java)
////            val intent=Intent(context,MainActivity::class.java)
////            startActivity(intent)
////            account.email
//            // Signed in successfully, show authenticated UI.
////            updateUI(account)
//        } catch (e: ApiException) {
//            // The ApiException status code indicates the detailed failure reason.
//            // Please refer to the GoogleSignInStatusCodes class reference for more information.
////            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
////            updateUI(null)
//        }
    }
}