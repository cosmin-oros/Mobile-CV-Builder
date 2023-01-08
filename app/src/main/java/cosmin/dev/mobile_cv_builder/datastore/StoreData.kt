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
        val UNIVERSITY = stringPreferencesKey("university")
        val FIELDOFSTUDY = stringPreferencesKey("field_of_study")
        val SPECIALIZATION = stringPreferencesKey("specialization")
        val GRADUATION = stringPreferencesKey("graduation")

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

    val getUniversity: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[UNIVERSITY] ?: ""
        }

    suspend fun saveUniversity(name: String) {
        context.dataStore.edit { preferences ->
            preferences[UNIVERSITY] = name
        }
    }

    val getFieldOfStudy: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[FIELDOFSTUDY] ?: ""
        }

    suspend fun saveFieldOfStudy(name: String) {
        context.dataStore.edit { preferences ->
            preferences[FIELDOFSTUDY] = name
        }
    }

    val getSpecialization: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[SPECIALIZATION] ?: ""
        }

    suspend fun saveSpecialization(name: String) {
        context.dataStore.edit { preferences ->
            preferences[SPECIALIZATION] = name
        }
    }

    val getGraduation: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[GRADUATION] ?: ""
        }

    suspend fun saveGraduation(name: String) {
        context.dataStore.edit { preferences ->
            preferences[GRADUATION] = name
        }
    }
}