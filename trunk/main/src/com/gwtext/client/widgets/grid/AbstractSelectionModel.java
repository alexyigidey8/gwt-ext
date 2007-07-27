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

package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;

public abstract class AbstractSelectionModel extends JsObject {

    protected AbstractSelectionModel() {
    }

    public AbstractSelectionModel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public native boolean isLocked() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        return sm.isLocked();
    }-*/;

    public native void lock() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.lock();
    }-*/;

    public native void unlock() /*-{
        var sm = this.@com.gwtext.client.core.JsObject::jsObj;
        sm.unlock();
    }-*/;
}
