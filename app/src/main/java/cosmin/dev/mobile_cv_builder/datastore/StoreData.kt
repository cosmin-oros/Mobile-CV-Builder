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
        val EMAIL = stringPreferencesKey("email")
        val NAME = stringPreferencesKey("name")
        val PHONE = stringPreferencesKey("phone")

        // preferences for each field, store multiple universities etc

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

    val getEmail: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[EMAIL] ?: ""
        }

    suspend fun saveEmail(name: String) {
        context.dataStore.edit { preferences ->
            preferences[EMAIL] = name
        }
    }

    val getPhone: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[PHONE] ?: ""
        }

    suspend fun savePhone(name: String) {
        context.dataStore.edit { preferences ->
            preferences[PHONE] = name
        }
    }
}