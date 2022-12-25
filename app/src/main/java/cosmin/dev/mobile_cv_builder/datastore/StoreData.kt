package cosmin.dev.mobile_cv_builder.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreData(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("datastore")
        val SURNAME = stringPreferencesKey("surname")
        val NAME = stringPreferencesKey("name")
        // for photo
        // preferences for each field, store multiple universities etc

    }

    val getSurname: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[SURNAME] ?: ""
        }

    suspend fun saveSurname(name: String) {
        context.dataStore.edit { preferences ->
            preferences[SURNAME] = name
        }
    }

    val getName: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[NAME] ?: ""
        }

    suspend fun saveName(name: String) {
        context.dataStore.edit { preferences ->
            preferences[NAME] = name
        }
    }
}