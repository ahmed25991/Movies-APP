package com.etisilattask.movies.common.data.remote.localStorage

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.GsonBuilder
import javax.inject.Inject
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey


class SharedPreferencesManager @Inject constructor(application: Context) {
    private val fileName = "secret_shared_prefs_1.0.0_1"
    private val masterKey = MasterKey.Builder(application, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    var preferences: SharedPreferences = try {
        EncryptedSharedPreferences.create(
            application,
            fileName,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    } catch (e: Exception) {
        application.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    }

    fun <T> save(`object`: T, key: String) {
        val jsonString = GsonBuilder().create().toJson(`object`)
        preferences.edit().putString(key, jsonString).apply()
    }

    fun clear(key: String) {
        preferences.edit().remove(key).apply()
    }

    inline fun <reified T> retrieve(key: String): T? {
        val value = preferences.getString(key, null)
        return GsonBuilder().create().fromJson(value, T::class.java)
    }
}
