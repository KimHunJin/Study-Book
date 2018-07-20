package dxmnd.com.rightnow.main.info.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.nhn.android.maps.NMapController
import com.nhn.android.maps.NMapView
import com.nhn.android.maps.maplib.NGeoPoint
import com.nhn.android.maps.nmapmodel.NMapError
import dxmnd.com.rightnow.R
import dxmnd.com.rightnow.util.NAVER_CLIENT_KEY
import kotlinx.android.synthetic.main.fragment_map_view.*


class MapViewFragment : NMapFragment(), NMapView.OnMapViewTouchEventListener, NMapView.OnMapStateChangeListener {

    override fun onLongPressCanceled(p0: NMapView?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTouchDown(p0: NMapView?, p1: MotionEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSingleTapUp(p0: NMapView?, p1: MotionEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTouchUp(p0: NMapView?, p1: MotionEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onScroll(p0: NMapView?, p1: MotionEvent?, p2: MotionEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLongPress(p0: NMapView?, p1: MotionEvent?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMapCenterChangeFine(p0: NMapView?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAnimationStateChange(p0: NMapView?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMapInitHandler(p0: NMapView?, p1: NMapError?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onZoomLevelChange(p0: NMapView?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMapCenterChange(p0: NMapView?, p1: NGeoPoint?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private var mapController : NMapController?=null
    private var mapViewResourceProvider = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        n_map_view.setOnMapStateChangeListener(this)
        n_map_view.setBuiltInZoomControls(true, null)
        mapController = n_map_view.mapController

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v  = inflater?.inflate(R.layout.fragment_map_view, container, false)!!

        n_map_view.setClientId(NAVER_CLIENT_KEY)
        n_map_view.isClickable = true

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}