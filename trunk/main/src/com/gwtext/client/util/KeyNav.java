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
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.JsObject;

public class KeyNav extends JsObject {
    public KeyNav(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public KeyNav(String id, KeyNavConfig config) {
        jsObj = create(id, config.getJsObj());
    }

    public KeyNav(Element el, KeyNavConfig config) {
        jsObj = create(el, config.getJsObj());
    }

    private static native JavaScriptObject create(Element el, JavaScriptObject config) /*-{
        return new  $wnd.Ext.KeyNav(el, config);
    }-*/;

    private static native JavaScriptObject create(String id, JavaScriptObject config) /*-{
        return new  $wnd.Ext.KeyNav(id, config);
    }-*/;

    public native void disable() /*-{
        var kn = this.@com.gwtext.client.core.JsObject::jsObj;
        kn.disable();
    }-*/;

    public native void enable() /*-{
        var kn = this.@com.gwtext.client.core.JsObject::jsObj;
        kn.enable();
    }-*/;



}