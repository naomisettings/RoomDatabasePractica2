package cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.viewModel

import android.app.Application
import androidx.lifecycle.*
import cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.database.DatabaseDAO
import cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.database.Usuari
import kotlinx.coroutines.launch


class UsuariViewModel(
    val database: DatabaseDAO,
    application: Application
) : AndroidViewModel(application) {

    var usuari = MutableLiveData<Usuari?>()

    init {
        usuari = MutableLiveData()
    }
    private suspend fun insert(usuari: Usuari) {
        database.insert(usuari)
    }

    fun startInsertUser(usua: Usuari) {
        viewModelScope.launch {

            insert(usua)
        }
    }

    private suspend fun getUserFromDatabase(mail: String): Usuari? {
        return database.get(mail)
    }

    fun getUser(mail: String): LiveData<Usuari?>{
        viewModelScope.launch {
            usuari.value = getUserFromDatabase(mail)

        }
        return usuari
    }




}