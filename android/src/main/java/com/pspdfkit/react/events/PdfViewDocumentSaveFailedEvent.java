package com.pspdfkit.react.events;


import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

/**
 * Event sent by the {@link com.pspdfkit.views.PdfView} when the document save failed.
 */
public class PdfViewDocumentSaveFailedEvent extends Event<PdfViewDocumentSaveFailedEvent> {

    public static final String EVENT_NAME = "pdfViewDocumentSaveFailed";

    private final String error;

    public PdfViewDocumentSaveFailedEvent(@IdRes int viewId, @NonNull String error) {
        super(viewId);
        this.error = error;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        WritableMap eventData = Arguments.createMap();
        eventData.putString("error", error);
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), eventData);
    }
}
