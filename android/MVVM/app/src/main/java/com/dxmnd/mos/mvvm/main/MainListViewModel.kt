package com.dxmnd.mos.mvvm.main

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import android.view.View
import com.dxmnd.mos.mvvm.R
import com.dxmnd.mos.mvvm.base.BaseViewModel
import com.dxmnd.mos.mvvm.service.ServiceAPI
import com.dxmnd.mos.mvvm.service.ServiceModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainListViewModel: BaseViewModel() {
    @Inject
    lateinit var serviceAPI : ServiceAPI

    private lateinit var subcription: Disposable

    val mainAdapter = MainAdapter()

    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadBus() }

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    init {
        loadBus()
    }


    private fun loadBus() {
        subcription = serviceAPI.getBusList("113")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe{onRetrievePostListStart()}
                .doOnTerminate{onRetrievePostListFinish()}
                .subscribe(
                        {result -> onRetrievePostListSuccess(result)},
                        {err -> onRetrievePostListError(err)}
                )
    }

    private fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(busList: List<ServiceModel>){
        mainAdapter.updateBusList(busList)
    }

    private fun onRetrievePostListError(err: Throwable) {
        Log.e("Error",err.message)
        errorMessage.value = R.string.post_error
    }

    override fun onCleared() {
        super.onCleared()
        subcription.dispose()
    }

}