package cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.R
import cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.viewModel.UsuariModelFactory
import cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.viewModel.UsuariViewModel
import cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.database.DatabaseUser
import cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.databinding.FragmentLoginFramgentBinding
import com.google.android.material.snackbar.Snackbar


class LoginFramgent : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLoginFramgentBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login_framgent, container, false)

        val application = requireNotNull(this.activity).application

        // Create an instance of the ViewModel Factory.
        val dataSource = DatabaseUser.getInstance(application).userDatabaseDao
        val viewModelFactory = UsuariModelFactory(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment.
        val userViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(UsuariViewModel::class.java)


        binding.bttnLogin.setOnClickListener {
            val mail = binding.edTextMaiLogin.text.toString()
            val password = binding.edTextPasswordLogin.text.toString()

            val us = userViewModel.getUser(mail)

            if (us.value?.password == password) {

                findNavController().navigate(
                    LoginFramgentDirections.actionLoginFramgentToPrincipalFragment(
                        us.value!!.username
                    )
                )

            }else{
                Snackbar.make(
                    it,
                    "La contrassenya és incorrecta",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

        binding.bttNewUser.setOnClickListener {
            findNavController().navigate(R.id.action_loginFramgent_to_registre)

        }
        return binding.root
    }
}