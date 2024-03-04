package com.dohyeon.compose_basic.ui.basic

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ListExampleScreen(){
    var itemCount by rememberSaveable {
        mutableStateOf(10)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(text = itemCount.toString())
            Row {
                Text(
                    text = "추가", 
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .clickable { itemCount += 1 }
                        .background(Color.Green)
                )
                Text(
                    text = "삭제",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .clickable { itemCount -= 1 }
                        .background(Color.Red)
                )
                Text(
                    text = "초기화",
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .clickable { itemCount = 10 }
                        .background(Color.Cyan)
                )
            }
            LazyColumn( modifier =  Modifier.padding(4.dp) ) {
                items(itemCount){ item ->
                    Text(text = item.toString(), modifier =  Modifier.padding(top = 4.dp))
                }
            }
        }
    }
}