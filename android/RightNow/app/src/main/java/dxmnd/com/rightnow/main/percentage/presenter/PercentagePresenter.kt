package dxmnd.com.rightnow.main.percentage.presenter

import dxmnd.com.rightnow.main.percentage.PercentageContract

class PercentagePresenter(percentageView : PercentageContract.View) : PercentageContract.Presenter {
    init {
        percentageView.presenter = this
    }
}