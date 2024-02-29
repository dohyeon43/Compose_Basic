package com.dohyeon.compose_basic.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dohyeon.compose_basic.ui.basic.BasicHoisting
import com.dohyeon.compose_basic.ui.basic.BasicSaveable
import com.dohyeon.compose_basic.ui.basic.BasicState
import com.dohyeon.compose_basic.ui.basic.BasicsThemeExample
import com.dohyeon.compose_basic.ui.theme.Compose_BasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_BasicTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    BasicsThemeExample()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_BasicTheme {
        MyApp()
    }
}