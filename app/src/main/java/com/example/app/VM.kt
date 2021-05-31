package com.example.app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VM : ViewModel(){
    var userAccount = MutableLiveData<Account>()
    var isRegistered = MutableLiveData(false)


    fun addAcc (account: Account) {
        userAccount.value = account
    }

    fun registerUser() {
        isRegistered.value = true
    }

    fun isReg(): Boolean? {

        return isRegistered.value
    }

}