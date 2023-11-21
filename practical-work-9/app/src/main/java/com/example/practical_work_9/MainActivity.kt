package com.example.practical_work_9

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practical_work_9.ui.theme.Practicalwork9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practicalwork9Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Page()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Page() {
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        var inputVal by rememberSaveable {
            mutableStateOf("")
        }
        var sixteen by rememberSaveable {
            mutableStateOf("")
        }
        var eight by rememberSaveable {
            mutableStateOf("")
        }
        var two by rememberSaveable {
            mutableStateOf("")
        }

        TextField(value = inputVal, onValueChange = { inputVal = it }, modifier = Modifier.fillMaxWidth(fraction = 0.9f), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = sixteen)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = eight)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = two)
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            val value = inputVal.toIntOrNull()
            if (value != null && value.toString(16).isNotEmpty()) {
                sixteen = value.toString(16)
                eight = value.toString(8)
                two = value.toString(2)
            } else {
                Toast.makeText(context, R.string.invalidInput, Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = stringResource(R.string.convert))
        }
    }
}