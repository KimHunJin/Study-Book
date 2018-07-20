package dxmnd.com.rightnow.main.info.view

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nhn.android.maps.NMapContext
import com.nhn.android.maps.NMapView
import dxmnd.com.rightnow.util.log

open class NMapFragment : Fragment() {
    private var mapContext : NMapContext?=null

    fun findMapView(v: View) : NMapView? {
        if (v !is ViewGroup) {
            return null
        }

        val vg : ViewGroup = v
        if(vg is NMapView) {
            return vg
        }

        for(x in 0 until vg.childCount) {
            val child: View = vg.getChildAt(x) as? ViewGroup ?: continue

            val mapView = findMapView(child)
            mapView?.let {
                return it
            }

        }
        return null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapContext = NMapContext(super.getActivity())
        mapContext?.onCreate()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val mapView : NMapView? = findMapView(super.getView())
        mapView?.apply {
            mapContext?.setupMapView(this)
        }?: log(throw IllegalAccessException("map view fragment error"))
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        throw IllegalArgumentException("onCreateView should be implemented in the subclass of NMapFragment.")
    }

    override fun onStart() {
        super.onStart()
        mapContext?.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapContext?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapContext?.onPause()
    }

    override fun onStop() {
        mapContext?.onStop()
        super.onStop()
    }

    override fun onDestroy() {
        mapContext?.onDestroy()
        super.onDestroy()
    }

}