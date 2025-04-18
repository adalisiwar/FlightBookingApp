package com.example.flightbooking.Activities.TicketDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.flightbooking.Domain.FlightModel
import com.example.flightbooking.R

@Composable
fun TicketDetailContent(
    flight: FlightModel,
    modifier: Modifier
){
    Column(modifier = modifier
        .padding(24.dp)
        .background(color = colorResource(R.color.LightPurple),
            shape = RoundedCornerShape(20.dp)
        )

    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            val(logo,arrivalTxt,lineImg,fromTxt,fromShortTxt,toTxt,toShortTxt)=createRefs()

            AsyncImage(
                model = flight.AirlineLogo,
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp,50.dp)
                    .constrainAs(logo) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                    },
                contentScale = androidx.compose.ui.layout.ContentScale.Fit
            )
            Text(
                text = flight.ArriveTime,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.darkPurple2),
                modifier = Modifier.constrainAs(arrivalTxt) {
                    top.linkTo(logo.bottom, margin = 8.dp)
                    start.linkTo(logo.start)
                    end.linkTo(logo.end)
                }
            )
            Image(
                painter = painterResource(R.drawable.line_airple_blue),
                contentDescription = null,
                modifier = Modifier.constrainAs(lineImg) {
                    top.linkTo(arrivalTxt.bottom, margin = 8.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            Text(
                text = "from",
                fontSize = 14.sp,
                color = colorResource(R.color.black),
                modifier = Modifier.constrainAs(fromTxt) {
                    top.linkTo(arrivalTxt.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(lineImg.start)
                }
            )
            Text(
                text = flight.FromShort,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.black),
                modifier = Modifier.constrainAs(fromShortTxt) {
                    top.linkTo(fromTxt.bottom, margin = 8.dp)
                    start.linkTo(fromTxt.start)
                    end.linkTo(fromTxt.end)
                    bottom.linkTo(lineImg.bottom)
                }
            )
            Text(
                text = "to",
                fontSize = 14.sp,
                color = colorResource(R.color.black),
                modifier = Modifier.constrainAs(toTxt) {
                    top.linkTo(arrivalTxt.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(lineImg.end)
                }
            )
            Text(
                text = flight.ToShort,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.black),
                modifier = Modifier.constrainAs(toShortTxt) {
                    top.linkTo(toTxt.bottom, margin = 8.dp)
                    start.linkTo(toTxt.start)
                    end.linkTo(toTxt.end)
                    bottom.linkTo(lineImg.bottom)
                }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.weight(0.5f)
            ) {
                Text(text="From", color = colorResource(R.color.black))
                Text(text=flight.From, color = colorResource(R.color.black), fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text="Date", color = colorResource(R.color.black))
                Text(text=flight.Date, color = colorResource(R.color.black), fontWeight = FontWeight.Bold)


            }
            Column(
                modifier = Modifier.weight(0.5f)
            ) {
                Text(text="To", color = colorResource(R.color.black))
                Text(text=flight.To, color = colorResource(R.color.black), fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text="Time", color = colorResource(R.color.black))
                Text(text=flight.Time, color = colorResource(R.color.black), fontWeight = FontWeight.Bold)


            }
        }

        Image(
            painter = painterResource(R.drawable.dash_line),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth

        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.weight(0.5f)
            ) {
                Text(text="Class", color = colorResource(R.color.black))
                Text(text=flight.ClassSeat, color = colorResource(R.color.black), fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text="Seats", color = colorResource(R.color.black))
                Text(text=flight.Passenger, color = colorResource(R.color.black), fontWeight = FontWeight.Bold)


            }
            Column(
                modifier = Modifier.weight(0.5f)
            ) {
                Text(text = "Airlines", color = colorResource(R.color.black))
                Text(
                    text = flight.AirlineName,
                    color = colorResource(R.color.black),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Price", color = colorResource(R.color.black))
                Text(
                    text = "$${String.format("%.2f", flight.Price)}",
                    color = colorResource(R.color.black),
                    fontWeight = FontWeight.Bold
                )

            }
            Image(
                painter = painterResource(R.drawable.qrcode),
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp)
            )
        }
        Image(
            painter = painterResource(R.drawable.dash_line),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Image(
            painter = painterResource(R.drawable.barcode),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
            contentScale = ContentScale.FillWidth

        )

    }
}