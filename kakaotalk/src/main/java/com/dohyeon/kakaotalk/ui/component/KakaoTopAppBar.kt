package com.dohyeon.kakaotalk.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dohyeon.kakaotalk.R
import com.dohyeon.kakaotalk.ui.theme.TitleLarge

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KakaoTopAppBar(title: String, actions : @Composable RowScope.() -> Unit ) {
    TopAppBar(
        title = { TitleLarge(text = title) },
        actions = { actions() }
    )
}

@Preview
@Composable
private fun Preview(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        content = {
            Column {
                KakaoTopAppBar(title = "타이틀") {
                    Image(painter = painterResource(id = R.drawable.ic_android_black), contentDescription = "")
                }
            }
        })
}