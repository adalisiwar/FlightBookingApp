package com.example.flightbooking.Activities.Splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightbooking.R
import com.google.android.material.internal.ViewUtils.RelativePadding

@Composable
@Preview
fun GradientButton(
    onClick:()->Unit={},
    text:String="Get Started",
    padding: Int=0
){
    Button(onClick=onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
    ){
        Box(
            modifier = Modifier
                .background(brush = Brush.linearGradient(
                    colors = listOf(
                        colorResource(R.color.purple),
                        colorResource(R.color.pink)
                    )
                ),
                    shape = RoundedCornerShape(50.dp)
                )
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.Center

        ){
            Text(text = text,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }


}