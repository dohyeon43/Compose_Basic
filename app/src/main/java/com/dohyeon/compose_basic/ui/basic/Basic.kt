package com.dohyeon.compose_basic.ui.basic

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
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


@SuppressLint("UnrememberedMutableState")
@Composable
fun BasicState(){
    /**
     * 컴포즈에서 상태는 UI 변경이 필요한 상황에서 UI 요소가 어떤 상태인지 나타내는 값입니다.
     */

    var expanded1 = false // 나쁜 예
    val expanded2 = mutableStateOf(false) // 나쁜 예
    val expanded3 = remember { mutableStateOf(false) }

    /**
     * 위에 3개의 상태 예시 중에 1번과 2번은 틀린 예이다.
     *
     * 1번의 경우, 컴포즈에서 해당 변수를 추적하지 않기 떄문이다. 상태 값이 변경되더라도 UI 갱신이 되지 않는다는 뜻이다.
     * 여기서 리컴포지션이라는 개념이 나온다. 컴포즈에서는 UI를 새로운 데이터로 업데이트 하기 위해 컴포저블 함수를 다시 실행시키는 동작을 한다.
     * 하지만 1번과 같이 상태를 구성하면 리컴포지션을 위한 트리거가 당겨지지 않아 UI 갱신이 되지 않는 것이다.
     * 이 문제을 해결하기 위해서는 2, 3번과 같이 'mutableStateOf' 함수를 사용하면 된다.
     * State와 MutableState는 값이 변경 될 때마다 리컴포지션을 트리거하는 인터페이스이다.
     *
     * 그럼, 2번은 왜 틀린 예일까? 우리는 상태 변수가 컴포저블 함수 안에 정의되었다는 점을 기억해야 한다.
     * 리컴포지션 == 컴포저블 함수의 재실행 이라고 생각하면 리컴포지션 과정에서 상태 값이 다시 초기화된다.
     * 결과적으로 리컴포지션이 이루어졌음에도 상태 변경이 이루어지지 않은 것이다.
     * 이를 해결하기 위해 'remember'를 사용한다.
     *
     * remember에 의해 계산된 값은 초기 구성 중에 'Composition'에 저장되며,
     * 저장된 값은 리컴포지션 과정 중에 반환된다. 결과적으로 상태 변경을 기억할 수 있는 것이다.
     * remember는 가변 객체와 불변 객체를 모두 저장하는 데 사용할 수 있다.
     * */

    val extraPadding = if (expanded3.value) 48.dp else 0.dp
    // 상태에 따라 다른 패딩 값을 가지는 변수, 간단한 계산이므로 저장될 필요 없다.


    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp)
    ){
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(extraPadding)
            ) {
                Text(text = "Hello, ")
                Text(text = "State")
            }
            ElevatedButton(
                onClick = { expanded3.value = !expanded3.value }
            ) {
                Text(if (expanded3.value) "Show less" else "Show more")
            }
        }
    }
}



@Composable
fun BasicHoisting(){
    /**
     * "컴포저블 함수에서 여러 함수가 읽거나 수정하는 상태는 공통의 상위 항목에 위치해야합니다"
     * 이것을 호이스팅이라고 한다. 여러 내부요소가 공통으로 참조하거나 수정하는 상태는 상위 항목으로 끌어올려 관리하는 것이다.
     * 상태가 중복되어 발생하는 버그를 방지하고 재사용성을 올릴 수 있다. 다만, 상위 요소에서 제어할 필요가 없는 상태는 호이스팅되면 안된다.
     * */

    var btnState by remember { mutableStateOf(true) }
    //by 키워드는 Delegate 패턴을 구현해 일일히 .value를 입력할 필요없게 만들어준다.

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            /**
             * 컴포즈에선 UI를 숨길 필요없이 간단한 kotlin 조건 구문으로
             * 그저 컴포저블 함수를 실행시키지 않는 것 만으로 구성되지 않게 할 수 있더.
             * */

            if(btnState){
                // 예시 버튼에 람다로 상태 변경 구문을 넘겨주어서
                // 상태가 변경될 떄마다 버튼의 종류가 바뀌게 만드는 로직
                ExampleHoistingButton(
                    lambda = { btnState = false },
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .size(60.dp)
                )
            }else{
                ExampleHoistingButton(
                    lambda = { btnState = true },
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.secondary)
                        .size(80.dp)
                )
            }
        }

    }


}
@Composable
fun ExampleHoistingButton(
    lambda : () -> Unit,
    modifier: Modifier
){
    /**
     * 이런식으로 람다를 활용하여 상위 요소의 상태에 접근하고 수정할 수 있다.
     * */
    Button(
        onClick = { lambda() },
        modifier =  modifier
    ) {
        Text(text = "상태 전환하여 버튼 바꾸기")
    }
}



