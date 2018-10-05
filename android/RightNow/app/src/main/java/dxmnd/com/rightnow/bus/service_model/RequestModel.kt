package dxmnd.com.rightnow.bus.service_model

import com.google.gson.annotations.SerializedName


class RequestModel(number: String) {

    @SerializedName("number")
    private var number: String = number

    fun getNumber() :String {
        return number
    }

}