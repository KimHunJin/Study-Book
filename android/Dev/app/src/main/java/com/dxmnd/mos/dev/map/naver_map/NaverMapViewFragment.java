package com.dxmnd.mos.dev.map.naver_map;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.dxmnd.mos.dev.R;
import com.dxmnd.mos.dev.map.naver_map.n_map_util.NMapFragment;
import com.dxmnd.mos.dev.map.naver_map.n_map_util.NMapViewerResourceProvider;
import com.dxmnd.mos.dev.utils.Keys;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapOverlay;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;

public class NaverMapViewFragment extends NMapFragment implements NMapView.OnMapStateChangeListener, NMapView.OnMapViewTouchEventListener{

    private double lat = 37.4979462;
    private double lng = 127.0254323;

    private NMapController mapController = null;
    private NMapViewerResourceProvider mapViewerResourceProvider = null;
    private NMapOverlayManager overlayManager = null;

    private NMapView mapView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_n_map,container, false);
        mapView = v.findViewById(R.id.n_map_view);
        mapView.setClientId(Keys.N_MAP_KEY);
        mapView.setClickable(true);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.setOnMapStateChangeListener(this);
        mapView.setOnMapViewTouchEventListener(this);
        mapController = mapView.getMapController();
        mapViewerResourceProvider = new NMapViewerResourceProvider(getActivity());
        overlayManager = new NMapOverlayManager(getActivity(), mapView, mapViewerResourceProvider);
        moveMapCenter();
    }

    private void moveMapCenter() {
        NGeoPoint currentLocation = new NGeoPoint(lng, lat);
        mapController.setMapCenter(currentLocation);
    }

    @Override
    public void onMapInitHandler(NMapView nMapView, NMapError nMapError) {
        if(nMapError == null) {
            moveMapCenter();
        } else {
            // log
        }
    }

    @Override
    public void onMapCenterChange(NMapView nMapView, NGeoPoint nGeoPoint) {

    }

    @Override
    public void onMapCenterChangeFine(NMapView nMapView) {

    }

    @Override
    public void onZoomLevelChange(NMapView nMapView, int i) {

    }

    @Override
    public void onAnimationStateChange(NMapView nMapView, int i, int i1) {

    }

    @Override
    public void onLongPress(NMapView nMapView, MotionEvent motionEvent) {

    }

    @Override
    public void onLongPressCanceled(NMapView nMapView) {

    }

    @Override
    public void onTouchDown(NMapView nMapView, MotionEvent motionEvent) {

    }

    @Override
    public void onTouchUp(NMapView nMapView, MotionEvent motionEvent) {

    }

    @Override
    public void onScroll(NMapView nMapView, MotionEvent motionEvent, MotionEvent motionEvent1) {

    }

    @Override
    public void onSingleTapUp(NMapView nMapView, MotionEvent motionEvent) {

    }
}
