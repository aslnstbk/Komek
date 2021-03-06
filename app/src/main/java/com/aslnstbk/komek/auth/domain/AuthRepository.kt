package com.aslnstbk.komek.auth.domain

import android.content.Intent

interface AuthRepository {

    fun signIn(
        data: Intent?,
        onSuccess: () -> Unit,
        onFail: () -> Unit
    )
}