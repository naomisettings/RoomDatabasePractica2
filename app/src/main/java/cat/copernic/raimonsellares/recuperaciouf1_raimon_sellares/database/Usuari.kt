package cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "usuari")
data class Usuari(

    @PrimaryKey (autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "mail")
    var mail: String = "",

    @ColumnInfo(name = "username")
    var username: String = "",

    @ColumnInfo(name = "password")
    var password: String = "",

    ): Parcelable