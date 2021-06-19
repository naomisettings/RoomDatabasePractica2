package cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.principal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.R
import cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.databinding.FragmentPrincipalBinding
import com.google.android.material.snackbar.Snackbar

class PrincipalFragment : Fragment() {

    private lateinit var args: PrincipalFragmentArgs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: FragmentPrincipalBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_principal, container, false)

        args = PrincipalFragmentArgs.fromBundle(requireArguments())

        binding.bttnUsuari.setOnClickListener {
                Snackbar.make(
                    it,
                    "Hola Esther sóc el ${args.username}",
                    Snackbar.LENGTH_LONG
                ).show()
        }


        return binding.root
    }

}