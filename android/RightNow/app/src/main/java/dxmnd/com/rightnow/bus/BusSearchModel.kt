package dxmnd.com.rightnow.bus

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel


class BusSearchModel : ViewModel() {

    private lateinit var data: MutableLiveData<List<String>>

    fun search(number: String): LiveData<List<String>> {

        if (!::data.isInitialized) {
            data = MutableLiveData()
        }

        loadSearch(number)

        return data
    }

    private fun loadSearch(number: String) {
        // call api and add data in data

    }
}