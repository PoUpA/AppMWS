package com.example.cryptograph

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class PriceGraphViewModel (savedStateHandle: SavedStateHandle) : ViewModel() {
    val priceGraphId : String = savedStateHandle["priceGraphId"] ?:
    throw IllegalArgumentException("missing priceGraphId")
    val priceGraph : LiveData<PriceGraph> = TODO()

}