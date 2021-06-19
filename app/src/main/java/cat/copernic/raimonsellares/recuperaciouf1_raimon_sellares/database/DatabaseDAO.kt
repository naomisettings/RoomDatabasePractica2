package cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DatabaseDAO {

    @Insert
    suspend fun insert(musica: Usuari)

    @Query("SELECT * from usuari WHERE mail = :mail LIMIT 1")
    suspend fun get(mail: String): Usuari?


}
