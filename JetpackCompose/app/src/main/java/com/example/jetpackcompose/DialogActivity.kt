package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class DialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var show by rememberSaveable {
                        mutableStateOf(false)
                    }

                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Button(onClick = { show = true }) {
                            Text(text = "Dialogo")
                        }
                    }

                    MyDialog(show, onConfirm = { show = false }, onDismiss = { show = false })
                }
            }
        }
    }
}

@Composable
fun MyDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = {
                onDismiss()
            },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirm Button")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Dismiss Button")
                }
            },
            title = {
                Text(text = "Titulo del dialogo")
            },
            text = {
                Text(text = "Este es el contenido del diálogo")
            }
        )
    }
}
