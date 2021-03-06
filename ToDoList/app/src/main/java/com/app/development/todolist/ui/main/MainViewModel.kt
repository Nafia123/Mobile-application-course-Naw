package com.app.development.todolist.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.app.development.todolist.repository.TokenAuthenticationRepository
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

public class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var tokenAuthenticationService = TokenAuthenticationRepository(application)

    public fun getAuthToken(account: GoogleSignInAccount) {
        tokenAuthenticationService.getAuthToken(account)
    }

}