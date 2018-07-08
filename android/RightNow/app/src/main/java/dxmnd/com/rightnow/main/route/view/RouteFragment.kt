package dxmnd.com.rightnow.main.route.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dxmnd.com.rightnow.R
import dxmnd.com.rightnow.main.route.RouteContract

class RouteFragment : Fragment(), RouteContract.View {
    override lateinit var presenter: RouteContract.Presenter

    companion object {
        fun newInstance(): RouteFragment {
            return RouteFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_route, container, false)
}