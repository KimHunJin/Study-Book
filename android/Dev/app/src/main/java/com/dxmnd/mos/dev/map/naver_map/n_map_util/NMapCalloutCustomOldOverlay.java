package com.dxmnd.mos.dev.map.naver_map.n_map_util;

import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;

import com.nhn.android.maps.NMapOverlay;
import com.nhn.android.maps.NMapOverlayItem;
import com.nhn.android.maps.NMapView;
import com.nhn.android.mapviewer.overlay.NMapCalloutOverlay;
import com.nhn.android.mapviewer.overlay.NMapResourceProvider;

public class NMapCalloutCustomOldOverlay extends NMapCalloutOverlay {
    private static final String LOG_TAG = NMapCalloutCustomOldOverlay.class.getSimpleName();
    private static final boolean DEBUG = false;

    private static final int CALLOUT_TEXT_COLOR = 0xFFFFFFFF;
    private static final float CALLOUT_TEXT_SIZE = 16.0F;
    private static final Typeface CALLOUT_TEXT_TYPEFACE = null;//Typeface.DEFAULT_BOLD;

    private static final float CALLOUT_RIGHT_BUTTON_WIDTH = 50.67F;
    private static final float CALLOUT_RIGHT_BUTTON_HEIGHT = 34.67F;

    private static final float CALLOUT_MARGIN_X = 9.33F;
    private static final float CALLOUT_PADDING_X = 9.33F;
    private static final float CALLOUT_PADDING_OFFSET = 0.45F;
    private static final float CALLOUT_PADDING_Y = 17.33F;
    private static final float CALLOUT_MIMIMUM_WIDTH = 63.33F;
    private static final float CALLOUT_TOTAL_HEIGHT = 64.0F;
    private static final float CALLOUT_BACKGROUND_HEIGHT = CALLOUT_PADDING_Y + CALLOUT_TEXT_SIZE + CALLOUT_PADDING_Y;
    private static final float CALLOUT_ITEM_GAP_Y = 0.0F;
    private static final float CALLOUT_TAIL_GAP_X = 6.67F;
    private static final float CALLOUT_TITLE_OFFSET_Y = -2.0F;

    private final TextPaint mTextPaint = new TextPaint();
    private float mOffsetX, mOffsetY;

    private final float mMarginX;
    private final float mPaddingX, mPaddingY, mPaddingOffset;
    private final float mMinimumWidth;
    private final float mTotalHeight;
    private final float mBackgroundHeight;
    private final float mItemGapY;
    private final float mTailGapX;
    private final float mTitleOffsetY;

    private final Drawable mBackgroundDrawable;
    protected final Rect mTemp2Rect = new Rect();
    private final Rect mRightButtonRect;
    private final String mRightButtonText;
    private final int mCalloutRightButtonWidth;
    private final int mCalloutRightButtonHeight;
    private Drawable[] mDrawableRightButton;
    private final int mCalloutButtonCount = 1;

    private String mTitleTruncated;
    private int mWidthTitleTruncated;

    private final String mTailText;
    private float mTailTextWidth;

    /**
     * Resource provider should implement this interface
     */
    public static interface ResourceProvider {

        public Drawable getCalloutBackground(NMapOverlayItem item);

        public String getCalloutRightButtonText(NMapOverlayItem item);

        public Drawable[] getCalloutRightButton(NMapOverlayItem item);

        public Drawable[] getCalloutRightAccessory(NMapOverlayItem item);
    }

    public NMapCalloutCustomOldOverlay(NMapOverlay itemOverlay, NMapOverlayItem item, Rect itemBounds,
                                       NMapCalloutCustomOldOverlay.ResourceProvider resourceProvider) {

        super(itemOverlay, item, itemBounds);

        mTextPaint.setAntiAlias(true);
        // set font style
        mTextPaint.setColor(CALLOUT_TEXT_COLOR);
        // set font size
        mTextPaint.setTextSize(CALLOUT_TEXT_SIZE * NMapResourceProvider.getScaleFactor());
        // set font type
        if (CALLOUT_TEXT_TYPEFACE != null) {
            mTextPaint.setTypeface(CALLOUT_TEXT_TYPEFACE);
        }

        mMarginX = NMapResourceProvider.toPixelFromDIP(CALLOUT_MARGIN_X);
        mPaddingX = NMapResourceProvider.toPixelFromDIP(CALLOUT_PADDING_X);
        mPaddingOffset = NMapResourceProvider.toPixelFromDIP(CALLOUT_PADDING_OFFSET);
        mPaddingY = NMapResourceProvider.toPixelFromDIP(CALLOUT_PADDING_Y);
        mMinimumWidth = NMapResourceProvider.toPixelFromDIP(CALLOUT_MIMIMUM_WIDTH);
        mTotalHeight = NMapResourceProvider.toPixelFromDIP(CALLOUT_TOTAL_HEIGHT);
        mBackgroundHeight = NMapResourceProvider.toPixelFromDIP(CALLOUT_BACKGROUND_HEIGHT);
        mItemGapY = NMapResourceProvider.toPixelFromDIP(CALLOUT_ITEM_GAP_Y);

        mTailGapX = NMapResourceProvider.toPixelFromDIP(CALLOUT_TAIL_GAP_X);
        mTailText = item.getTailText();

        mTitleOffsetY = NMapResourceProvider.toPixelFromDIP(CALLOUT_TITLE_OFFSET_Y);

        if (resourceProvider == null) {
            throw new IllegalArgumentException(
                    "NMapCalloutCustomOverlay.ResourceProvider should be provided on creation of NMapCalloutCustomOverlay.");
        }

        mBackgroundDrawable = resourceProvider.getCalloutBackground(item);

        boolean hasRightAccessory = false;
        mDrawableRightButton = resourceProvider.getCalloutRightAccessory(item);
        if (mDrawableRightButton != null && mDrawableRightButton.length > 0) {
            hasRightAccessory = true;

            mRightButtonText = null;
        } else {
            mDrawableRightButton = resourceProvider.getCalloutRightButton(item);
            mRightButtonText = resourceProvider.getCalloutRightButtonText(item);
        }

        if (mDrawableRightButton != null) {
            if (hasRightAccessory) {
                mCalloutRightButtonWidth = mDrawableRightButton[0].getIntrinsicWidth();
                mCalloutRightButtonHeight = mDrawableRightButton[0].getIntrinsicHeight();
            } else {
                mCalloutRightButtonWidth = NMapResourceProvider.toPixelFromDIP(CALLOUT_RIGHT_BUTTON_WIDTH);
                mCalloutRightButtonHeight = NMapResourceProvider.toPixelFromDIP(CALLOUT_RIGHT_BUTTON_HEIGHT);
            }

            mRightButtonRect = new Rect();

            super.setItemCount(mCalloutButtonCount);
        } else {
            mCalloutRightButtonWidth = 0;
            mCalloutRightButtonHeight = 0;
            mRightButtonRect = null;
        }

        mTitleTruncated = null;
        mWidthTitleTruncated = 0;
    }

    @Override
    protected boolean hitTest(int hitX, int hitY) {

        // hit test for right button only ?
        //    	if (mRightButtonRect != null) {
        //    		return  mRightButtonRect.contains(hitX, hitY);
        //    	}

        return super.hitTest(hitX, hitY);
    }

    @Override
    protected boolean isTitleTruncated() {
        return (mTitleTruncated != mOverlayItem.getTitle());
    }

    @Override
    protected int getMarginX() {
        return (int)(mMarginX);
    }

    @Override
    protected Rect getBounds(NMapView mapView) {

        adjustTextBounds(mapView);

        mTempRect.set((int)mTempRectF.left, (int)mTempRectF.top, (int)mTempRectF.right, (int)mTempRectF.bottom);
        mTempRect.union(mTempPoint.x, mTempPoint.y);

        return mTempRect;
    }

    @Override
    protected PointF getSclaingPivot() {
        PointF pivot = new PointF();

        pivot.x = mTempRectF.centerX();
        pivot.y = mTempRectF.top + mTotalHeight;

        return pivot;
    }

    @Override
    protected void drawCallout(Canvas canvas, NMapView mapView, boolean shadow, long when) {

        adjustTextBounds(mapView);

        stepAnimations(canvas, mapView, when);

        drawBackground(canvas);

        float left, top;

        // draw title
        mOffsetX = mTempPoint.x - mTempRect.width() / 2;
        mOffsetX -= mPaddingOffset;
        mOffsetY = mTempRectF.top + mPaddingY + mTextPaint.getTextSize() + mTitleOffsetY;
        canvas.drawText(mTitleTruncated, mOffsetX, mOffsetY, mTextPaint);

        // draw right button
        if (mDrawableRightButton != null) {
            left = mTempRectF.right - mPaddingX - mCalloutRightButtonWidth;
            top = mTempRectF.top + (mBackgroundHeight - mCalloutRightButtonHeight) / 2;

            // Use background drawables depends on current state
            mRightButtonRect.left = (int)(left + 0.5F);
            mRightButtonRect.top = (int)(top + 0.5F);
            mRightButtonRect.right = (int)(left + mCalloutRightButtonWidth + 0.5F);
            mRightButtonRect.bottom = (int)(top + mCalloutRightButtonHeight + 0.5F);

            int itemState = super.getItemState(0);
            Drawable drawable = getDrawable(0, itemState);
            if (drawable != null) {
                drawable.setBounds(mRightButtonRect);
                drawable.draw(canvas);
            }

            if (mRightButtonText != null) {
                mTextPaint.getTextBounds(mRightButtonText, 0, mRightButtonText.length(), mTempRect);

                left = mRightButtonRect.left + (mCalloutRightButtonWidth - mTempRect.width()) / 2;
                top = mRightButtonRect.top + (mCalloutRightButtonHeight - mTempRect.height()) / 2 + mTempRect.height()
                        + mTitleOffsetY;
                canvas.drawText(mRightButtonText, left, top, mTextPaint);
            }
        }

        // draw tail text
        if (mTailText != null) {
            if (mRightButtonRect != null) {
                left = mRightButtonRect.left;
            } else {
                left = mTempRectF.right;
            }
            left -= mPaddingX + mTailTextWidth;
            top = mOffsetY;

            canvas.drawText(mTailText, left, top, mTextPaint);
        }
    }

    /* Internal Functions */

    private void drawBackground(Canvas canvas) {

        mTemp2Rect.left = (int)(mTempRectF.left + 0.5F);
        mTemp2Rect.top = (int)(mTempRectF.top + 0.5F);
        mTemp2Rect.right = (int)(mTempRectF.right + 0.5F);
        mTemp2Rect.bottom = (int)(mTempRectF.top + mTotalHeight + 0.5F);

        mBackgroundDrawable.setBounds(mTemp2Rect);
        mBackgroundDrawable.draw(canvas);
    }

    private void adjustTextBounds(NMapView mapView) {

        //  First determine the screen coordinates of the selected MapLocation
        mapView.getMapProjection().toPixels(mOverlayItem.getPointInUtmk(), mTempPoint);

        int mapViewWidth = mapView.getMapController().getViewFrameVisibleWidth();
        if (mTitleTruncated == null || mWidthTitleTruncated != mapViewWidth) {
            mWidthTitleTruncated = mapViewWidth;
            float maxWidth = mWidthTitleTruncated - 2 * mMarginX - 2 * mPaddingX;
            if (DEBUG) {
                Log.i(LOG_TAG, "adjustTextBounds: maxWidth=" + maxWidth + ", mMarginX=" + mMarginX + ", mPaddingX="
                        + mPaddingX);
            }

            if (mDrawableRightButton != null) {
                maxWidth -= mPaddingX + mCalloutRightButtonWidth;
            }

            if (mTailText != null) {
                mTextPaint.getTextBounds(mTailText, 0, mTailText.length(), mTempRect);
                mTailTextWidth = mTempRect.width();

                maxWidth -= mTailGapX + mTailTextWidth;
            }

            final String title = TextUtils.ellipsize(mOverlayItem.getTitle(), mTextPaint, maxWidth,
                    TextUtils.TruncateAt.END).toString();

            mTitleTruncated = title;

            if (DEBUG) {
                Log.i(LOG_TAG, "adjustTextBounds: mTitleTruncated=" + mTitleTruncated + ", length="
                        + mTitleTruncated.length());
            }
        }

        mTextPaint.getTextBounds(mTitleTruncated, 0, mTitleTruncated.length(), mTempRect);

        if (mDrawableRightButton != null) {
            mTempRect.right += mPaddingX + mCalloutRightButtonWidth;
        }

        if (mTailText != null) {
            mTempRect.right += mTailGapX + mTailTextWidth;
        }

        if (DEBUG) {
            Log.i(LOG_TAG, "adjustTextBounds: mTempRect.width=" + mTempRect.width() + ", mTempRect.height="
                    + mTempRect.height());
        }

        //  Setup the callout with the right size & location
        mTempRectF.set(mTempRect);
        final float dy = (mBackgroundHeight - mTempRect.height()) / 2;
        mTempRectF.inset(-mPaddingX, -dy);
        //mTempRectF.inset(-mPaddingX, -mPaddingY);

        // set minimum size
        if (mTempRectF.width() < mMinimumWidth) {
            final float dx = (mMinimumWidth - mTempRectF.width()) / 2;
            mTempRectF.inset(-dx, 0);
        }

        // set position
        float left = mTempPoint.x - (int)(mTempRectF.width() * mOverlayItem.getAnchorXRatio());
        float top = mTempPoint.y - (int)(mItemBounds.height() * mOverlayItem.getAnchorYRatio()) - mItemGapY
                - mTotalHeight;
        mTempRectF.set(left, top, left + mTempRectF.width(), top + mTempRectF.height());

    }

    @Override
    protected Drawable getDrawable(int rank, int itemState) {
        if (mDrawableRightButton != null && mDrawableRightButton.length >= 3) {
            int idxDrawable = 0;
            if (NMapOverlayItem.isPressedState(itemState)) {
                idxDrawable = 1;
            } else if (NMapOverlayItem.isSelectedState(itemState)) {
                idxDrawable = 2;
            } else if (NMapOverlayItem.isFocusedState(itemState)) {
                idxDrawable = 2;
            }
            Drawable drawable = mDrawableRightButton[idxDrawable];
            return drawable;
        }

        return null;
    }
}
