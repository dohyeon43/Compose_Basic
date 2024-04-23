package com.dohyeon.kakaotalk.ui.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.dohyeon.kakaotalk.ui.component.KakaoTopAppBar

@Composable
fun MainScreen(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ){
        Column {
            KakaoTopAppBar(title = "친구") {

            }
            LazyColumn(){

            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    MainScreen()
}