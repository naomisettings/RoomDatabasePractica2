package cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.registre

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
import cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.database.Usuari
import cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.databinding.FragmentRegistreBinding
import com.google.android.material.snackbar.Snackbar

class RegistreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentRegistreBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_registre, container, false)

        val application = requireNotNull(this.activity).application

        // Create an instance of the ViewModel Factory.
        val dataSource = DatabaseUser.getInstance(application).userDatabaseDao
        val viewModelFactory = UsuariModelFactory(dataSource, application)

        // Get a reference to the ViewModel associated with this fragment.
        val newSongViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(UsuariViewModel::class.java)


        binding.save.setOnClickListener {
            val username = binding.edUserName.text.toString()
            val mail = binding.edTxtMail.text.toString()
            val password = binding.edTxtPassword.text.toString()
            val password2 = binding.edTextPasswordLogin3.text.toString()

            if (password == password2 && binding.checkBox.isChecked) {

                val userEntity = Usuari()
                userEntity.username = username
                userEntity.mail = mail
                userEntity.password = password

                newSongViewModel.startInsertUser(userEntity)

                findNavController().navigate(R.id.action_registre_to_loginFramgent)

            }else{
                    Snackbar.make(
                        it,
                        "Contrassenyes diferents o termes no acceptats",
                        Snackbar.LENGTH_LONG
                    ).show()
            }
        }
        binding.bttnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registre_to_loginFramgent)

        }
        return binding.root
    }
}