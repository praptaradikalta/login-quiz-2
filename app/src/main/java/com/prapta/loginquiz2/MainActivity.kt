package com.prapta.loginquiz2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.prapta.loginquiz2.ui.theme.LoginQuiz2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginQuiz2Theme {
                // A surface container using the 'background' color from the theme
                LoginForm()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {


        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginQuiz2Theme {
        LoginForm()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewDark() {
    LoginQuiz2Theme(darkTheme = true) {
        LoginForm()
    }
}
