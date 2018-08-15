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
import com.nhn.android.mapviewer.overlay.NMapOverlayManager
import dxmnd.com.rightnow.R
import dxmnd.com.rightnow.util.NAVER_CLIENT_KEY
import dxmnd.com.rightnow.util.log
import dxmnd.com.rightnow.util.nmap.NMapFragment
import dxmnd.com.rightnow.util.nmap.NMapViewerResourceProvider
import com.patloew.rxlocation.RxLocation




class MapViewFragment : NMapFragment(), NMapView.OnMapViewTouchEventListener, NMapView.OnMapStateChangeListener {

    private var lat = 37.4979462
    private var lng = 127.0254323

    private var mapController : NMapController?=null
    private var mapViewResourceProvider : NMapViewerResourceProvider? = null
    private var mapOverlayManager: NMapOverlayManager? = null

    private var n_map_view : NMapView? = null

    fun setLocation(lat: Double , lng :Double) {
        this.lat = lat
        this.lng = lng
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        n_map_view?.let {
            it.setOnMapStateChangeListener(this)
            it.setBuiltInZoomControls(true, null)
            mapController = it.mapController
        }
        mapViewResourceProvider = NMapViewerResourceProvider(activity)
        mapOverlayManager = NMapOverlayManager(activity, n_map_view, mapViewResourceProvider)
        moveMapCenter()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val v  = inflater?.inflate(R.layout.fragment_map_view, container, false)!!

        log(NAVER_CLIENT_KEY)
        n_map_view = v.findViewById(R.id.n_map_view)
        n_map_view?.apply {
            this.setClientId(dxmnd.com.rightnow.util.NAVER_CLIENT_KEY)
            this.isClickable = true
        }

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onLongPressCanceled(p0: NMapView?) {
    }

    override fun onTouchDown(p0: NMapView?, p1: MotionEvent?) {
    }

    override fun onSingleTapUp(p0: NMapView?, p1: MotionEvent?) {
    }

    override fun onTouchUp(p0: NMapView?, p1: MotionEvent?) {
    }

    override fun onScroll(p0: NMapView?, p1: MotionEvent?, p2: MotionEvent?) {
    }

    override fun onLongPress(p0: NMapView?, p1: MotionEvent?) {
    }

    override fun onMapCenterChangeFine(p0: NMapView?) {
    }

    override fun onAnimationStateChange(p0: NMapView?, p1: Int, p2: Int) {
    }

    override fun onMapInitHandler(nMapView: NMapView?, nMapError: NMapError?) {
        if(nMapError == null) {
            moveMapCenter()
        } else{
            log(nMapError)
        }
    }

    override fun onZoomLevelChange(p0: NMapView?, p1: Int) {
    }

    override fun onMapCenterChange(p0: NMapView?, p1: NGeoPoint?) {
    }

    private fun moveMapCenter() {
        var currentPoint = NGeoPoint(lng, lat)
        mapController?.mapCenter = currentPoint
    }
}