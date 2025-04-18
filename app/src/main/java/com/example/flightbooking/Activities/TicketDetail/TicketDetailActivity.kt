package com.example.flightbooking.Activities.TicketDetail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.flightbooking.Activities.Splash.StatusTopBarColor
import com.example.flightbooking.Domain.FlightModel
import com.example.flightbooking.R

class TicketDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val flight = intent.getSerializableExtra ("flight") as FlightModel

        setContent {
            StatusTopBarColor()

            TicketDetailScreen(
                flight = flight,
                onBackClick = { finish() },
                onDownloadTicketClick = {

                }
            )

        }
    }
}