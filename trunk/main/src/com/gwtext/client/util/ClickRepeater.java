/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.client.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.event.ClickRepeaterListener;

/**
 * A wrapper class which can be applied to any element. Fires a "click" event while the mouse is pressed.
 * The interval between firings may be specified in the config but defaults to 10 milliseconds. Optionally,
 * a CSS class may be applied to the element during the time it is pressed.
 */
public class ClickRepeater extends JsObject {

    /**
     * Create a new ClickRepeater.
     *
     * @param config ClickRepeater configuration
     */
    public ClickRepeater(ClickRepeaterConfig config) {
        jsObj = create(config.getJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.util.ClickRepeater(config);
    }-*/;

    /**
     * Add a ClickRepeater listener.
     *
     * @param listener the listener
     */
    public native void addListener(ClickRepeaterListener listener)/*-{
        var cr = this.@com.gwtext.client.core.JsObject::jsObj;
        var crJ = this;

        cr.addListener('click',
                function(source) {
                    listener.@com.gwtext.client.util.event.ClickRepeaterListener::onClick(Lcom/gwtext/client/util/ClickRepeater;)(crJ);
                }
        );

        cr.addListener('mousedown',
                function(source) {
                    listener.@com.gwtext.client.util.event.ClickRepeaterListener::onMouseDown(Lcom/gwtext/client/util/ClickRepeater;)(crJ);
                }
        );

        cr.addListener('mouseup',
                function(source) {
                    listener.@com.gwtext.client.util.event.ClickRepeaterListener::onMouseUp(Lcom/gwtext/client/util/ClickRepeater;)(crJ);
                }
        );
    }-*/;
}
