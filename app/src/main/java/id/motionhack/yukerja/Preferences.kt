package id.motionhack.yukerja

import android.content.Context
import android.content.SharedPreferences

class Preferences {

    var APP_NAME = "Approval System"

    private var log_status = "log_status"
    private var token_type = "token_type"
    private var expires = "expires"
    private var nik = "nik"
    private var token = "token"
    private var saveData = "save_data"
    private var password = "password"
    private var noHp = "no_hp"
    private var user_role = "user_role"
    private var fingerprint = "fingerprint"

    var sp: SharedPreferences? = null
    var spEditor: SharedPreferences.Editor? = null

    fun setPreferences(context: Context) {
        sp = context.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)
        spEditor = sp?.edit()
    }

    fun preferencesLogout() {
        spEditor!!.clear()
        spEditor!!.commit()
    }

    fun saveSaveData(value: Boolean) {
        spEditor!!.putBoolean(saveData, value)
        spEditor!!.commit()
    }

    fun saveUserRole(value: String) {
        spEditor!!.putString(user_role, value)
        spEditor!!.commit()
    }

    fun saveNoHp(value: String?) {
        spEditor!!.putString(noHp, value)
        spEditor!!.commit()
    }

    fun savePassword(value: String?) {
        spEditor!!.putString(password, value)
        spEditor!!.commit()
    }

    fun saveLogStatus(value: Boolean) {
        spEditor!!.putBoolean(log_status, value)
        spEditor!!.commit()
    }

    fun saveToken(value: String?) {
        spEditor!!.putString(token, value)
        spEditor!!.commit()
    }

    fun saveTokenType(value: String?) {
        spEditor!!.putString(token_type, value)
        spEditor!!.commit()
    }

    fun saveExpires(value: String?) {
        spEditor!!.putString(expires, value)
        spEditor!!.commit()
    }

    fun saveFingerprintState(value: Boolean) {
        spEditor!!.putBoolean(fingerprint, value)
        spEditor!!.commit()
    }

    fun saveNIK(value: String?) {
        spEditor!!.putString(nik, value)
        spEditor!!.commit()
    }

    fun getLogStatus(): Boolean {
        return sp!!.getBoolean(log_status, false)
    }

    fun getNIK(): String? {
        return sp!!.getString(nik, "N/A")
    }

    fun getUserRole(): String? {
        return sp!!.getString(user_role, "N/A")
    }

    fun getSaveData(): Boolean {
        return sp!!.getBoolean(saveData, false)
    }

    fun getNoHp(): String? {
        return sp!!.getString(noHp, "N/A")
    }

    fun getPassword(): String? {
        return sp!!.getString(password, "N/A")
    }

    fun getFingerprintState(): Boolean {
        return sp!!.getBoolean(fingerprint, false)
    }

    fun getExpires(): String? {
        return sp!!.getString(expires, "N/A")
    }

    fun getTokenType(): String? {
        return sp!!.getString(token_type, "N/A")
    }

    fun getToken(): String? {
        return sp!!.getString(token, "N/A")
    }
}