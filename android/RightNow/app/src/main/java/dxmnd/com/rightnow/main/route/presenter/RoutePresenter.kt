package dxmnd.com.rightnow.main.route.presenter

import dxmnd.com.rightnow.main.route.RouteContract


class RoutePresenter(rootView: RouteContract.View) : RouteContract.Presenter {
    init {
        rootView.presenter = this
    }
}