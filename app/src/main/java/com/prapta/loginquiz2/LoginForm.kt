@file:OptIn(ExperimentalMaterial3Api::class)

package com.prapta.loginquiz2
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.FileOpen
import androidx.compose.material.icons.outlined.NightShelter
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.prapta.loginquiz2.ui.theme.LoginQuiz2Theme
import com.prapta.loginquiz2.ui.theme.Purple80

@Composable
fun LoginForm() {
    Surface{
        var credentials by remember { mutableStateOf(Credentials()) }
        val context = LocalContext.current
        Column{
            Row(Modifier.weight(0.75f)) {
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(R.drawable.hsi),
                        contentDescription = null,
                    )
                }
            }
            Row(Modifier.weight(2f)) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    Text(
                        text = stringResource(R.string.nip),
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .align(alignment = Alignment.Start)
                    )
                    LoginField(
                        value = credentials.login,
                        onChange = {data -> credentials = credentials.copy(login = data)},
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(R.string.password),
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .align(alignment = Alignment.Start)
                    )
                    PasswordField(
                        value = credentials.pwd,
                        onChange = { data -> credentials = credentials.copy(pwd = data)},
                        submit = {
                            if (!checkCredentials(credentials, context)) credentials = Credentials()
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {
                            if (!checkCredentials(credentials, context)) credentials = Credentials()
                        },
//                enabled = credentials.isNotEmpty(),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth(),
//
                        colors =  ButtonDefaults.buttonColors(
                            containerColor = Color.Blue
                        )
                    ) {
                        Text("Login")
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    Text(
                        text = stringResource(R.string.bisaakses),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 25.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                    Text(
                        text = stringResource(R.string.cs_ikhwan),
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue,
                        modifier = Modifier
                            .padding(bottom = 25.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                            .clickable(
                                onClick = {
                                    Toast
                                        .makeText(
                                            context,
                                            "Menghubungi CS Ikhwan...",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                }
                            )
                    )

                    Text(
                        text = stringResource(R.string.cs_Akhwat),
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue,
                        modifier = Modifier
                            .padding(bottom = 25.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                            .clickable(
                                onClick = {
                                    Toast
                                        .makeText(
                                            context,
                                            "Menghubungi CS Akhwat...",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                }
                            )
                    )

            }
        }
            Row(Modifier.weight(0.3f)) {
                Column(
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Button(
                        onClick = {
                                Toast.makeText(context, "Menuju Halaman FAQ...", Toast.LENGTH_SHORT)
                                    .show()
                        },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp)
                            .border(
                                BorderStroke(width = 1.dp, color = Color.Black),
                                shape = RoundedCornerShape(50)
                            ),
                        colors =  ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Row {
                            Text(
                                "Lihat FAQ",
                                color = Color.Blue
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Icon(
                                Icons.Outlined.FileOpen,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }
    }
}

fun checkCredentials(creds: Credentials, context: Context): Boolean {
    if (creds.isNotEmpty()) {
        Toast.makeText(context, "Menuju Halaman Beranda...", Toast.LENGTH_SHORT).show()
        return true
    } else if (creds.login.isEmpty() && creds.pwd.isEmpty()){
        Toast.makeText(context, "NIP dan Password Harus diisi...", Toast.LENGTH_SHORT).show()
        return false
    } else if (creds.login.isEmpty() && creds.pwd.isNotEmpty()){
        Toast.makeText(context, "NIP Harus diisi...", Toast.LENGTH_SHORT).show()
        return false
    } else {
        Toast.makeText(context, "Password Harus diisi...", Toast.LENGTH_SHORT).show()
        return false
    }
}

data class Credentials(
    var login: String = "",
    var pwd: String = "",
    var remember: Boolean = false
) {
    fun isNotEmpty(): Boolean {
        return login.isNotEmpty() && pwd.isNotEmpty()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginField(
    value: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Masukan NIP",
    placeholder: String = "(Contoh :ARN123-1234)"
) {

    val focusManager = LocalFocusManager.current
    val leadingIcon = @Composable {
        Icon(
            Icons.Default.Person,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.primary
        )
    }

    TextField(
        value = value,
        onValueChange = onChange,
        modifier = modifier
            .border(
            BorderStroke(width = 1.dp, Color.Gray ),
            shape = RoundedCornerShape(25)
        ),
        leadingIcon = leadingIcon,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        placeholder = { Text(placeholder) },
        label = { Text(label) },
        visualTransformation = VisualTransformation.None
    )
}

@Composable
fun PasswordField(
    value: String,
    onChange: (String) -> Unit,
    submit: () -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Password",
    placeholder: String = "Masukan Password"
) {

    var isPasswordVisible by remember { mutableStateOf(false) }

    val leadingIcon = @Composable {
        Icon(
            Icons.Default.Key,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.primary
        )
    }
    val trailingIcon = @Composable {
        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
            Icon(
                if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }

    TextField(
        value = value,
        onValueChange = onChange,
        modifier = modifier
            .border(
                BorderStroke(width = 1.dp, Color.Gray ),
                shape = RoundedCornerShape(25)
            ),
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(
            onDone = { submit() }
        ),
        placeholder = { Text(placeholder) },
        label = { Text(label) },
        singleLine = true,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp", showSystemUi = true)
@Composable
fun LoginFormPreview() {
    LoginQuiz2Theme {
        LoginForm()
    }
}

