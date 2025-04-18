package com.example.flightbooking.Activities.TicketDetail

import TicketDetailHeader
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.flightbooking.Activities.Splash.GradientButton
import com.example.flightbooking.Domain.FlightModel
import com.example.flightbooking.R

@Composable
fun TicketDetailScreen(
    flight: FlightModel,
    onBackClick: () -> Unit,
    onDownloadTicketClick:()-> Unit
) {

    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.darkPurple2))
    ){
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(colorResource(R.color.darkPurple2))
        ) {
            ConstraintLayout(modifier = Modifier
                .fillMaxSize()
                .padding(top = 15.dp)
                .background(colorResource(R.color.darkPurple2))
            ) {
                val (topSection,ticketDetail) = createRefs()


                TicketDetailHeader(onBackClick = onBackClick, Modifier.constrainAs(topSection) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }

                )

                TicketDetailContent(flight=flight, Modifier.constrainAs(ticketDetail){
                    top.linkTo(parent.top, margin = 110.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                } )
            }

            Spacer(modifier = Modifier.padding(50.dp))

            GradientButton(onClick = {}, text = "Download Your Ticket")
        }
    }
}
