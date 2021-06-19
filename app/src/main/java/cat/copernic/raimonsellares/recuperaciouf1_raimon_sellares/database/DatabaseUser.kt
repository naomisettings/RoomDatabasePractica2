package cat.copernic.raimonsellares.recuperaciouf1_raimon_sellares.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Usuari::class], version = 1, exportSchema = false)
abstract class DatabaseUser : RoomDatabase() {

    abstract val userDatabaseDao: DatabaseDAO

    companion object {

        @Volatile
        private var INSTANCE: DatabaseUser? = null

        fun getInstance(context: Context): DatabaseUser {

            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseUser::class.java,
                        "usuari"
                    )

                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}
