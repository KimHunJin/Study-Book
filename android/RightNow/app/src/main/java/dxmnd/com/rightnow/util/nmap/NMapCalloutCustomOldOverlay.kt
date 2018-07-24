package dxmnd.com.rightnow.util.nmap

import android.graphics.Canvas
import android.graphics.PointF
import android.graphics.Rect
import com.nhn.android.maps.NMapOverlayItem
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.graphics.Typeface
import com.nhn.android.mapviewer.overlay.NMapResourceProvider
import com.nhn.android.maps.NMapOverlay
import com.nhn.android.maps.NMapView
import com.nhn.android.mapviewer.overlay.NMapCalloutOverlay


class NMapCalloutCustomOldOverlay(private val itemOverlay: NMapOverlay,
                                  private val item: NMapOverlayItem, itemBounds: Rect,
                                  private val resourceProvider: NMapCalloutCustomOldOverlay.ResourceProvider?)
    : NMapCalloutOverlay(itemOverlay, item, itemBounds) {


    private val LOG_TAG = "NMapCalloutCustomOverlay"
    private val DEBUG = false

    private val CALLOUT_TEXT_COLOR = -0x1
    private val CALLOUT_TEXT_SIZE = 16.0f
    private val CALLOUT_TEXT_TYPEFACE: Typeface? = null//Typeface.DEFAULT_BOLD;

    private val CALLOUT_RIGHT_BUTTON_WIDTH = 50.67f
    private val CALLOUT_RIGHT_BUTTON_HEIGHT = 34.67f

    private val CALLOUT_MARGIN_X = 9.33f
    private val CALLOUT_PADDING_X = 9.33f
    private val CALLOUT_PADDING_OFFSET = 0.45f
    private val CALLOUT_PADDING_Y = 17.33f
    private val CALLOUT_MIMIMUM_WIDTH = 63.33f
    private val CALLOUT_TOTAL_HEIGHT = 64.0f
    private val CALLOUT_BACKGROUND_HEIGHT = CALLOUT_PADDING_Y + CALLOUT_TEXT_SIZE + CALLOUT_PADDING_Y
    private val CALLOUT_ITEM_GAP_Y = 0.0f
    private val CALLOUT_TAIL_GAP_X = 6.67f
    private val CALLOUT_TITLE_OFFSET_Y = -2.0f

    private val mTextPaint = TextPaint()
    private val mOffsetX: Float = 0.toFloat()
    private val mOffsetY: Float = 0.toFloat()

    private var mMarginX: Float = 0.toFloat()
    private var mPaddingX: Float = 0.toFloat()
    private var mPaddingY: Float = 0.toFloat()
    private var mPaddingOffset: Float = 0.toFloat()
    private var mMinimumWidth: Float = 0.toFloat()
    private var mTotalHeight: Float = 0.toFloat()
    private var mBackgroundHeight: Float = 0.toFloat()
    private var mItemGapY: Float = 0.toFloat()
    private var mTailGapX: Float = 0.toFloat()
    private var mTitleOffsetY: Float = 0.toFloat()

    private var mBackgroundDrawable: Drawable? = null
    protected val mTemp2Rect = Rect()
    private var mRightButtonRect: Rect? = null
    private var mRightButtonText: String? = null
    private var mCalloutRightButtonWidth: Int = 0
    private var mCalloutRightButtonHeight: Int = 0
    private var mDrawableRightButton: Array<Drawable>? = null
    private val mCalloutButtonCount = 1

    private var mTitleTruncated: String? = null
    private var mWidthTitleTruncated: Int = 0

    private var mTailText: String? = null
    private val mTailTextWidth: Float = 0.toFloat()

    fun NMapCalloutCustomOldOverlay() {

        mTextPaint.isAntiAlias = true
        // set font style
        mTextPaint.color = CALLOUT_TEXT_COLOR
        // set font size
        mTextPaint.textSize = CALLOUT_TEXT_SIZE * NMapResourceProvider.getScaleFactor()
        // set font type
        if (CALLOUT_TEXT_TYPEFACE != null) {
            mTextPaint.typeface = CALLOUT_TEXT_TYPEFACE
        }

        mMarginX = NMapResourceProvider.toPixelFromDIP(CALLOUT_MARGIN_X).toFloat()
        mPaddingX = NMapResourceProvider.toPixelFromDIP(CALLOUT_PADDING_X).toFloat()
        mPaddingOffset = NMapResourceProvider.toPixelFromDIP(CALLOUT_PADDING_OFFSET).toFloat()
        mPaddingY = NMapResourceProvider.toPixelFromDIP(CALLOUT_PADDING_Y).toFloat()
        mMinimumWidth = NMapResourceProvider.toPixelFromDIP(CALLOUT_MIMIMUM_WIDTH).toFloat()
        mTotalHeight = NMapResourceProvider.toPixelFromDIP(CALLOUT_TOTAL_HEIGHT).toFloat()
        mBackgroundHeight = NMapResourceProvider.toPixelFromDIP(CALLOUT_BACKGROUND_HEIGHT).toFloat()
        mItemGapY = NMapResourceProvider.toPixelFromDIP(CALLOUT_ITEM_GAP_Y).toFloat()

        mTailGapX = NMapResourceProvider.toPixelFromDIP(CALLOUT_TAIL_GAP_X).toFloat()
        mTailText = item.tailText

        mTitleOffsetY = NMapResourceProvider.toPixelFromDIP(CALLOUT_TITLE_OFFSET_Y).toFloat()

        if (resourceProvider == null) {
            throw IllegalArgumentException(
                    "NMapCalloutCustomOverlay.ResourceProvider should be provided on creation of NMapCalloutCustomOverlay.")
        }

        mBackgroundDrawable = resourceProvider!!.getCalloutBackground(item)

        var hasRightAccessory = false
        mDrawableRightButton = resourceProvider!!.getCalloutRightAccessory(item)
        if (mDrawableRightButton != null && mDrawableRightButton?.size!! > 0) {
            hasRightAccessory = true

            mRightButtonText = null
        } else {
            mDrawableRightButton = resourceProvider!!.getCalloutRightButton(item)
            mRightButtonText = resourceProvider!!.getCalloutRightButtonText(item)
        }

        if (mDrawableRightButton != null) {
            if (hasRightAccessory) {
                mCalloutRightButtonWidth = mDrawableRightButton!![0].intrinsicWidth
                mCalloutRightButtonHeight = mDrawableRightButton!![0].intrinsicHeight
            } else {
                mCalloutRightButtonWidth = NMapResourceProvider.toPixelFromDIP(CALLOUT_RIGHT_BUTTON_WIDTH)
                mCalloutRightButtonHeight = NMapResourceProvider.toPixelFromDIP(CALLOUT_RIGHT_BUTTON_HEIGHT)
            }

            mRightButtonRect = Rect()

            super.setItemCount(mCalloutButtonCount)
        } else {
            mCalloutRightButtonWidth = 0
            mCalloutRightButtonHeight = 0
            mRightButtonRect = null
        }

        mTitleTruncated = null
        mWidthTitleTruncated = 0
    }

    override fun drawCallout(p0: Canvas?, p1: NMapView?, p2: Boolean, p3: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBounds(p0: NMapView?): Rect {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMarginX(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSclaingPivot(): PointF {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isTitleTruncated(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDrawable(p0: Int, p1: Int): Drawable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    /**
     * Resource provider should implement this interface
     */

    interface ResourceProvider {

        fun getCalloutBackground(item: NMapOverlayItem): Drawable

        fun getCalloutRightButtonText(item: NMapOverlayItem): String

        fun getCalloutRightButton(item: NMapOverlayItem): Array<Drawable>

        fun getCalloutRightAccessory(item: NMapOverlayItem): Array<Drawable>
    }


}