package com.example.android.counter

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement


import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.counter.ui.theme.CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Counter()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Counter(modifier: Modifier = Modifier) {

    var textFieldState by remember {
        mutableStateOf("0")
    }

    var numberInputed = textFieldState.toInt()

        Row (modifier = modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            Button(modifier = Modifier
                .weight(0.1F)
                .height(48.dp),
                onClick = {
                    numberInputed -= 1
                }) {
                Text(text = "-")
            }

            TextField(value = textFieldState,
                onValueChange = {
                    textFieldState = it
                }, modifier = Modifier
                    .weight(0.1F)
                    .padding(horizontal = 24.dp)


            )


            Button(modifier = Modifier
                .weight(0.1F)
                .height(48.dp),
                onClick = {
                numberInputed += 1
            }) {
                Text(text = "+")
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    CounterTheme {
        Counter()
    }
}