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

        val UNIVERSITY1 = stringPreferencesKey("university1")
        val FIELDOFSTUDY1 = stringPreferencesKey("field_of_study1")
        val SPECIALIZATION1 = stringPreferencesKey("specialization1")
        val GRADUATION1 = stringPreferencesKey("graduation1")

        val UNIVERSITY2 = stringPreferencesKey("university2")
        val FIELDOFSTUDY2 = stringPreferencesKey("field_of_study2")
        val SPECIALIZATION2 = stringPreferencesKey("specialization2")
        val GRADUATION2 = stringPreferencesKey("graduation2")

        val UNIVERSITY3 = stringPreferencesKey("university3")
        val FIELDOFSTUDY3 = stringPreferencesKey("field_of_study3")
        val SPECIALIZATION3 = stringPreferencesKey("specialization3")
        val GRADUATION3 = stringPreferencesKey("graduation3")

        val UNIVERSITY4 = stringPreferencesKey("university4")
        val FIELDOFSTUDY4 = stringPreferencesKey("field_of_study4")
        val SPECIALIZATION4 = stringPreferencesKey("specialization4")
        val GRADUATION4 = stringPreferencesKey("graduation4")

        val UNIVERSITY5 = stringPreferencesKey("university5")
        val FIELDOFSTUDY5 = stringPreferencesKey("field_of_study5")
        val SPECIALIZATION5 = stringPreferencesKey("specialization5")
        val GRADUATION5 = stringPreferencesKey("graduation5")

        val COMPANY = stringPreferencesKey("company")
        val JOBTITLE = stringPreferencesKey("job_title")
        val STARTDATE = stringPreferencesKey("start_date")
        val ENDDATE = stringPreferencesKey("end_date")

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

    val getUniversity1: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[UNIVERSITY1] ?: ""
        }

    suspend fun saveUniversity1(name: String) {
        context.dataStore.edit { preferences ->
            preferences[UNIVERSITY1] = name
        }
    }

    val getFieldOfStudy1: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[FIELDOFSTUDY1] ?: ""
        }

    suspend fun saveFieldOfStudy1(name: String) {
        context.dataStore.edit { preferences ->
            preferences[FIELDOFSTUDY1] = name
        }
    }

    val getSpecialization1: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[SPECIALIZATION1] ?: ""
        }

    suspend fun saveSpecialization1(name: String) {
        context.dataStore.edit { preferences ->
            preferences[SPECIALIZATION1] = name
        }
    }

    val getGraduation1: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[GRADUATION1] ?: ""
        }

    suspend fun saveGraduation1(name: String) {
        context.dataStore.edit { preferences ->
            preferences[GRADUATION1] = name
        }
    }

    val getUniversity2: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[UNIVERSITY2] ?: ""
        }

    suspend fun saveUniversity2(name: String) {
        context.dataStore.edit { preferences ->
            preferences[UNIVERSITY2] = name
        }
    }

    val getFieldOfStudy2: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[FIELDOFSTUDY2] ?: ""
        }

    suspend fun saveFieldOfStudy2(name: String) {
        context.dataStore.edit { preferences ->
            preferences[FIELDOFSTUDY2] = name
        }
    }

    val getSpecialization2: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[SPECIALIZATION2] ?: ""
        }

    suspend fun saveSpecialization2(name: String) {
        context.dataStore.edit { preferences ->
            preferences[SPECIALIZATION2] = name
        }
    }

    val getGraduation2: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[GRADUATION2] ?: ""
        }

    suspend fun saveGraduation2(name: String) {
        context.dataStore.edit { preferences ->
            preferences[GRADUATION2] = name
        }
    }

    val getUniversity3: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[UNIVERSITY3] ?: ""
        }

    suspend fun saveUniversity3(name: String) {
        context.dataStore.edit { preferences ->
            preferences[UNIVERSITY3] = name
        }
    }

    val getFieldOfStudy3: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[FIELDOFSTUDY3] ?: ""
        }

    suspend fun saveFieldOfStudy3(name: String) {
        context.dataStore.edit { preferences ->
            preferences[FIELDOFSTUDY3] = name
        }
    }

    val getSpecialization3: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[SPECIALIZATION3] ?: ""
        }

    suspend fun saveSpecialization3(name: String) {
        context.dataStore.edit { preferences ->
            preferences[SPECIALIZATION3] = name
        }
    }

    val getGraduation3: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[GRADUATION3] ?: ""
        }

    suspend fun saveGraduation3(name: String) {
        context.dataStore.edit { preferences ->
            preferences[GRADUATION3] = name
        }
    }

    val getUniversity4: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[UNIVERSITY4] ?: ""
        }

    suspend fun saveUniversity4(name: String) {
        context.dataStore.edit { preferences ->
            preferences[UNIVERSITY4] = name
        }
    }

    val getFieldOfStudy4: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[FIELDOFSTUDY4] ?: ""
        }

    suspend fun saveFieldOfStudy4(name: String) {
        context.dataStore.edit { preferences ->
            preferences[FIELDOFSTUDY4] = name
        }
    }

    val getSpecialization4: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[SPECIALIZATION4] ?: ""
        }

    suspend fun saveSpecialization4(name: String) {
        context.dataStore.edit { preferences ->
            preferences[SPECIALIZATION4] = name
        }
    }

    val getGraduation4: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[GRADUATION4] ?: ""
        }

    suspend fun saveGraduation4(name: String) {
        context.dataStore.edit { preferences ->
            preferences[GRADUATION4] = name
        }
    }

    val getUniversity5: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[UNIVERSITY5] ?: ""
        }

    suspend fun saveUniversity5(name: String) {
        context.dataStore.edit { preferences ->
            preferences[UNIVERSITY5] = name
        }
    }

    val getFieldOfStudy5: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[FIELDOFSTUDY5] ?: ""
        }

    suspend fun saveFieldOfStudy5(name: String) {
        context.dataStore.edit { preferences ->
            preferences[FIELDOFSTUDY5] = name
        }
    }

    val getSpecialization5: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[SPECIALIZATION5] ?: ""
        }

    suspend fun saveSpecialization5(name: String) {
        context.dataStore.edit { preferences ->
            preferences[SPECIALIZATION5] = name
        }
    }

    val getGraduation5: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[GRADUATION5] ?: ""
        }

    suspend fun saveGraduation5(name: String) {
        context.dataStore.edit { preferences ->
            preferences[GRADUATION5] = name
        }
    }

    val getCompany: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[COMPANY] ?: ""
        }

    suspend fun saveCompany(name: String) {
        context.dataStore.edit { preferences ->
            preferences[COMPANY] = name
        }
    }

    val getJob: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[JOBTITLE] ?: ""
        }

    suspend fun saveJob(name: String) {
        context.dataStore.edit { preferences ->
            preferences[JOBTITLE] = name
        }
    }

    val getStartDate: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[STARTDATE] ?: ""
        }

    suspend fun saveStartDate(name: String) {
        context.dataStore.edit { preferences ->
            preferences[STARTDATE] = name
        }
    }

    val getEndDate: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[ENDDATE] ?: ""
        }

    suspend fun saveEndDate(name: String) {
        context.dataStore.edit { preferences ->
            preferences[ENDDATE] = name
        }
    }
}