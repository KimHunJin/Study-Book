package dxmnd.com.rightnow.util.nmap

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.ListView
import com.nhn.android.maps.NMapContext
import com.nhn.android.maps.NMapOverlayItem
import com.nhn.android.maps.overlay.NMapPOIitem
import com.nhn.android.mapviewer.overlay.NMapResourceProvider

class NMapViewerResourceProvider(context: Context) : NMapResourceProvider(context), NMapCalloutCustomOldOverlay.ResourceProvider {
    override fun getOverlappedListViewId(): Int = 0

    override fun setOverlappedListViewLayout(p0: ListView?, p1: Int, p2: Int, p3: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setOverlappedItemResource(p0: NMapPOIitem?, p1: ImageView?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLocationDot(): Array<Drawable> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDrawableForMarker(p0: Int, p1: Boolean, p2: NMapOverlayItem?): Drawable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getParentLayoutIdForOverlappedListView(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListItemDividerId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCalloutBackground(p0: NMapOverlayItem?): Drawable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListItemImageViewId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCalloutRightButton(p0: NMapOverlayItem?): Array<Drawable> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCalloutTextColors(p0: NMapOverlayItem?): IntArray {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListItemTextViewId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListItemLayoutIdForOverlappedListView(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListItemTailTextViewId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findResourceIdForMarker(p0: Int, p1: Boolean): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCalloutRightButtonText(p0: NMapOverlayItem?): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutIdForOverlappedListView(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCalloutRightAccessory(p0: NMapOverlayItem?): Array<Drawable> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDirectionArrow(): Drawable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}