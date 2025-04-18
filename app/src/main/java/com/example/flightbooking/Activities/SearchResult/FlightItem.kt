package com.example.flightbooking.Activities.SearchResult

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import com.example.flightbooking.Activities.SeatSelect.SeatSelectActivity
import com.example.flightbooking.Domain.FlightModel
import com.example.flightbooking.R

@Composable
fun FlightItem(item: FlightModel, index: Int) {
    val context = LocalContext.current

    ConstraintLayout(
        modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .clickable{
            val intent= Intent(context, SeatSelectActivity::class.java).apply {
                putExtra("flight",item)
            }
            startActivity(context,intent,null)
        }
        .background(
            color = colorResource(R.color.LightPurple),
            shape = RoundedCornerShape(15.dp)
        )
    ) {
        val (logo,timeTxt,airplaneIcon,dashLine,priceTxt,seatIcon,classTxt,fromTxt,fromShortTxt,toTxt,toShortTxt) = createRefs()

        AsyncImage(
            model = item.AirlineLogo,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp,50.dp)
                .constrainAs(logo) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = item.ArriveTime,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = colorResource(R.color.darkPurple2),
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(timeTxt)  {
                    top.linkTo(logo.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Image(
            painter = painterResource(id = R.drawable.line_airple_blue),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(airplaneIcon) {
                    top.linkTo(timeTxt.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.dash_line),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(dashLine) {
                    top.linkTo(airplaneIcon.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = "$${String.format("%.2f", item.Price)}",
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp,
            color = colorResource(R.color.orange),
            modifier = Modifier
                .padding(8.dp)
                .constrainAs(priceTxt) {
                    top.linkTo(dashLine.bottom)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        )
        Image(
            painter = painterResource(id = R.drawable.seat_black_ic),
            contentDescription = null,
            modifier = Modifier
                .padding( 8.dp)
                .constrainAs(seatIcon) {
                    top.linkTo(dashLine.bottom)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }
        )
        Text(
            text = item.ClassSeat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            color = colorResource(R.color.darkPurple2),
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(classTxt)  {
                    top.linkTo(seatIcon.top)
                    start.linkTo(seatIcon.end)
                    bottom.linkTo(seatIcon.bottom)
                }
        )
        Text(
            text = item.From,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 16.dp)
                .constrainAs(fromTxt)  {
                    top.linkTo(timeTxt.bottom)
                    start.linkTo(parent.start)
                }
        )
        Text(
            text = item.FromShort,
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(start = 16.dp)
                .constrainAs(fromShortTxt) {
                    top.linkTo(fromTxt.bottom)
                    start.linkTo(fromTxt.start)
                    end.linkTo(fromTxt.end)
                }
        )
        Text(
            text = item.To,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(end = 16.dp)
                .constrainAs(toTxt)  {
                    top.linkTo(timeTxt.bottom)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = item.ToShort,
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .constrainAs(toShortTxt) {
                    top.linkTo(toTxt.bottom)
                    start.linkTo(toTxt.start)
                    end.linkTo(toTxt.end)
                }
        )

    }
}