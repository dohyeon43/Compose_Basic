package com.dohyeon.kakaotalk.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TagSmall(text:String){
    Text(text = text, fontSize = 8.sp)
}

@Composable
fun TagMedium(text: String){
    Text(text = text, fontSize = 9.sp)
}

@Composable
fun TagLarge(text:String){
    Text(text = text, fontSize = 10.sp)
}
@Composable
fun BodySmall(text:String){
    Text(text = text, fontSize = 14.sp)
}

@Composable
fun BodyMedium(text: String){
    Text(text = text, fontSize = 16.sp)
}

@Composable
fun BodyLarge(text:String){
    Text(text = text, fontSize = 18.sp)
}

@Composable
fun TitleSmall(text: String){
    Text(text = text, fontSize = 20.sp)   
}

@Composable
fun TitleMedium(text: String){
    Text(text = text, fontSize = 22.sp)
}

@Composable
fun TitleLarge(text : String){
    Text(text = text, fontSize = 24.sp)
}

@Preview
@Composable
fun TextPreview(){
    val text = "예시 문자열"
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        TagSmall(text = text)
        TagMedium(text = text)
        TagLarge(text = text)

        BodySmall(text = text)
        BodyMedium(text = text)
        BodyLarge(text = text)

        TitleSmall(text = text)
        TitleMedium(text = text)
        TitleLarge(text = text)
    }
}