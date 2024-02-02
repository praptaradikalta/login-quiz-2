package com.prapta.loginquiz2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.prapta.loginquiz2.ui.theme.LoginQuiz2Theme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            LoginQuiz2Theme {
                LoginForm()
            }
        }
    }
}