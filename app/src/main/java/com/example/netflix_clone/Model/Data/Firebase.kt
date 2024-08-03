package com.example.netflix_clone.Model.Data

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.FirebaseAuth

object Firebase {
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun <T> Task<T>.addOnCompleteListener(onCompleteListener: OnCompleteListener<T>) {
        Tasks.await(this)
        onCompleteListener.onComplete(this)
    }
}