package cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.viewModel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.database.DatabaseDAO

class UsuariModelFactory(
    private val dataSource: DatabaseDAO,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UsuariViewModel::class.java)) {
            return UsuariViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}