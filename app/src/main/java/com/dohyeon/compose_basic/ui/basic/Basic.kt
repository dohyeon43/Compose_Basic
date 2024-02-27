package com.dohyeon.compose_basic.ui.basic

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/** 1. 컴포즈 기초  */
@Composable
fun ExampleComposable(modifier: Modifier) {
    /**
     * 컴포즈는 구성 가능한 함수(Composable function)를 사용하여 UI를 구성합니다.
     * 함수의 위에 '@Composable' 어노테이션을 추가해 이 함수가 구성 가능한 함수인 것을 정의합니다.
     * 이제부터 모든 구성 가능한 함수는 '컴포저블 함수'로 명칭을 통일하겠습니다.
     * */
    Surface (
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier //Modifier.padding(4.dp)
        /**
         * 컴포저블 함수의 인자는 UI를 구성하기 위한 정보를 넣을 수 있습니다.
         * 이 중, Modifier는 수정자로 컴포저블 요소에 적용되는 변형이나 스타일을 나타냅니다.
         * 예를 들어 modifier = Modifier.padding(4.dp)와 같은 방식으로 패딩을 지정할 수 있습니다.
         * */
    ) {
        Text(
            text = "Compose Basic",
            modifier = modifier
            /**
             * 해당 방법은 상위 컴포저블 함수가 정의한
             * 파라미터 값을 하위 컴포저블이 이용하는 방식입니다.
             **/
        )
    }
}

@Composable
@Preview
fun BasicPreview(){
    /**
     * 만약 자신이 작성중인 컴포즈 UI의 변경을 확인하고 싶다면 굳이 앱을 실행시킬 필요없이
     * 미리보기 기능을 사용하여 안드로이드 스튜디오 내에서 확인이 가능합니다.
     * 사용법은 컴포저블 함수를 만들고 @Preview 어노테이션을 추가, 원하는 컴포저블 함수를 내부에 집어넣는 식으로 미리 확인할 수 있습니다.
     * **/
    ExampleComposable(modifier = Modifier)
}

/**
 * 컴포즈 UI의 가장 큰 특징이자 장점 중 하나는 'UI의 재사용성'입니다.
 * 자신이 작성한 컴포저블 함수를 호출만 한다면 어디서든 사용할 수 있습니다.
 * 이 특성으로 인해 계속 중첩되는 UI 작성을 작은 요소를 재활용하는 방식으로 깔끔하게 만들 수 있고,
 * UI 요소의 라이브러리를 쉽게 만들 수 있습니다.
 * */


@Composable
fun BasicColumn(modifier: Modifier){
    Column(modifier) {
        Text(text = "기본적인 레이아웃")
        Text(text = "컬럼은 세로로 내부 요소가 배치됩니다.")
    }
}

@Composable
fun BasicRow(modifier: Modifier){
    Row(modifier) {
        Text(text = "기본적인 레이아웃")
        Text(text = "로우는 가로로 내부 요소가 배치됩니다")
    }
}


@Composable
fun BasicBox(modifier: Modifier){
    Box(modifier) {
        Text(text = "기본적인 레이아웃")
        Text(text = "박스는 내부 요소가 겹치게 배치됩니다.")
    }
}

@Composable
@Preview
fun BasicLayoutPreview(){
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        //BasicColumn(modifier = Modifier)
        //BasicRow(modifier = Modifier)
        BasicBox(modifier = Modifier)
    }

    /** 위와 같이 기본적인 레이아웃을 유용하게 사용하여 UI를 구성할 수 있습니다.
     * 파라미터를 통해 넘겨주는 modifier 인자값을 통해 레이아웃에도 padding이나 크기를 지정할 수 있습니다.
     */
}






