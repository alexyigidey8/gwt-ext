/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 

package com.gwtext.client.dd;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.widgets.Component;

public class DragSource extends DDProxy {

    public DragSource(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public DragSource(String id,  DragSourceConfig config) {
        super(id, null, config);
    }

    public DragSource(Component component, DragSourceConfig config) {
        super(component, null, config);
    }

    protected native JavaScriptObject create(String id, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DragSource(id, config);
    }-*/;

    protected native JavaScriptObject create(Element element, String sGroup, JavaScriptObject config)/*-{
        return new $wnd.Ext.dd.DragSource(element, config);
    }-*/;

    private static DragSource instance(JavaScriptObject jsObj) {
        return new DragSource(jsObj);
    }

    public native StatusProxy getProxy() /*-{
        var ds = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var proxy = ds.getProxy();
        return @com.gwtext.client.dd.StatusProxy::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(proxy);
    }-*/;
    
}
