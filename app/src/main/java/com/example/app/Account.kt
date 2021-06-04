package com.example.app

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class Account(name: String?, email: String?, password: String?){
    var accountName = name
    val accountEmail = email
    var accountPassword = password
    var userRegistered = false
    val db = Firebase.firestore

    fun register() {
        val user = hashMapOf(
            "Name" to accountName,
            "Email" to accountEmail,
            "Password" to accountPassword
        )

        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error adding document", e)
            }

        userRegistered = true

    }

    fun logIn(email: String, password: String) {
       val user = db.collection("users")
           .whereEqualTo("Email", email)
           .whereEqualTo("Password", password).get()
           .addOnSuccessListener {
               userRegistered = true
           }
           .addOnFailureListener { exception ->
               Log.d(TAG, "Error getting documents: ", exception)
           }

    }
}