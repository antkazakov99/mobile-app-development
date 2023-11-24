package com.example.practical_work_11

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
import androidx.compose.runtime.collectAsState
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
import com.example.practical_work_11.ui.theme.Practicalwork11Theme

class MainActivity : ComponentActivity() {
    private val viewModel by lazy {ConverterViewModel.getInstance()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practicalwork11Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Page(viewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Page(viewModel: ConverterViewModel) {
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

        val invalidValueText = stringResource(R.string.invalidInput)

        TextField(value = inputVal, onValueChange = { inputVal = it }, modifier = Modifier
            .fillMaxWidth(fraction = 0.9f)
            .testTag(tag = "input"), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        val toHexResult = viewModel.convertToHexadecimalStateFlow.collectAsState()
        if (toHexResult.value != null) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = toHexResult.value.toString(), modifier = Modifier.testTag("hexValue"))
        }
        val toOctalResult = viewModel.convertToOctalStateFlow.collectAsState()
        if (toOctalResult.value != null) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = toOctalResult.value.toString(), modifier = Modifier.testTag("hexValue"))
        }
        val toBinaryResult = viewModel.convertToBinaryStateFlow.collectAsState()
        if (toBinaryResult.value != null) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = toBinaryResult.value.toString(), modifier = Modifier.testTag("hexValue"))
        }
        Button(modifier = Modifier.testTag("convertButton"), onClick = {
            val value = inputVal.toIntOrNull()
            if (value != null && ConverterModel().fromDecimalToBinary(value) != null) {
                viewModel.fromDecimalToBinary(value)
                viewModel.fromDecimalToOctal(value)
                viewModel.fromDecimalToHexadecimal(value)
            } else {
                Toast.makeText(context, invalidValueText, Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = stringResource(R.string.convert))
        }
    }
}