package com.example.flightbooking.ViewModel

import androidx.lifecycle.LiveData
import com.example.flightbooking.Domain.FlightModel
import com.example.flightbooking.Domain.LocationModel
import com.example.flightbooking.Repository.MainRepository

class MainViewModel {
    private val repository = MainRepository()
    fun loadLocation(): LiveData<MutableList<LocationModel>> {
        return repository.loadLocation()

    }

    fun loadFiltered(from: String, to: String):
            LiveData<MutableList<FlightModel>> {
        return repository.loadFiltered(from, to)
    }
}