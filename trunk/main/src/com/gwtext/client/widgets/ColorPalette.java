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

package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.event.ColorPaletteListener;

public class ColorPalette extends Component {

    public ColorPalette(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public ColorPalette(ColorPaletteConfig config) {
        jsObj = create(config.getJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject config)/*-{
        debugger;
        var cp = new $wnd.Ext.ColorPalette(config);
        return cp;
    }-*/;

    public native void select(String color) /*-{
        var cp = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        cp.select(color);
    }-*/;


    private static ColorPalette instance(JavaScriptObject jsObj) {
        return new ColorPalette(jsObj);
    }

    public String[] getColors() {
        return JavaScriptObjectHelper.getAttributeAsStringArray(jsObj, "colors");
    }

    public void setColors(String[] colors) {
        JavaScriptObjectHelper.setAttribute(jsObj, "colors", JavaScriptObjectHelper.convertToJavaScriptArray(colors));
    }

    public native void addColorPaletteListener(ColorPaletteListener listener) /*-{
        var componentJ = this;
        var component = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;

        component.addListener('select',
                function(cp, color) {
                    listener.@com.gwtext.client.widgets.event.ColorPaletteListener::onSelect(Lcom/gwtext/client/widgets/ColorPalette;Ljava/lang/String;)(componentJ, color);
                }
        );
    }-*/;
}
