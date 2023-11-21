package com.example.practical_work_10

import android.os.Bundle
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practical_work_10.ui.theme.Practicalwork10Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practicalwork10Theme {
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
        var invalidInput by rememberSaveable {
            mutableStateOf("")
        }

        var invalidValueText = stringResource(R.string.invalidInput)

        TextField(value = inputVal, onValueChange = { inputVal = it }, modifier = Modifier
            .fillMaxWidth(fraction = 0.9f)
            .testTag(tag = "input"), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = sixteen, modifier = Modifier.testTag("hexValue"))
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = eight, modifier = Modifier.testTag("octalValue"))
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = two, modifier = Modifier.testTag("binaryValue"))
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = invalidInput, modifier = Modifier.testTag("invalidInput"))
        Button(modifier = Modifier.testTag("convertButton"), onClick = {
            val value = inputVal.toIntOrNull()
            val converter = Converter()
            if (value != null && converter.fromDecimalToHexadecimal(value) != null) {
                sixteen = converter.fromDecimalToHexadecimal(value)!!
                eight = converter.fromDecimalToOctal(value)!!
                two = converter.fromDecimalToBinary(value)!!
                invalidInput = ""
            } else {
                sixteen = ""
                eight = ""
                two = ""
                invalidInput = invalidValueText
            }
        }) {
            Text(text = stringResource(R.string.convert))
        }
    }
}