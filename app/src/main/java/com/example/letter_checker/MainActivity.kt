package com.example.letter_checker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LetterChecker()
        }
    }
}

@Composable
fun LetterChecker() {
    var textInput by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Digite um texto para verificar a quantidade de letras 'a' ou 'A':")

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = textInput,
            onValueChange = { textInput = it },
            label = { Text("Texto") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val count = contarLetraA(textInput.text)
            result = "A letra 'a' ou 'A' aparece $count vezes no texto."
        }) {
            Text("Verificar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(result)
    }
}

fun contarLetraA(texto: String): Int {
    return texto.count { it.equals('a', ignoreCase = true) }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LetterChecker()
}
