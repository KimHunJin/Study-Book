package com.dxmnd.mos.mvvm.service

data class ServiceModel(
        val busRouteId: String,
        val busRouteNm: String,
        val firstBusTm: String,
        val lastBusTm: String,
        val routeType: String,
        val term: String
)