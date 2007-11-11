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

package com.gwtext.client.widgets.menu;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.ColorPalette;

/**
 * A menu item that wraps the {@link ColorPalette} component.
 *
 */
public class ColorItem extends Item {

    /**
     * Create a new ColorItem.
     */
    public ColorItem() {
    }

    /**
     * Create a new ColorItem.
     *
     * @param config the config object
     */
    public ColorItem(ItemConfig config) {
        super(config);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.menu.ColorItem(config);    
    }-*/;

    /**
     * Return the CollorPalette associated with the menu item.
     *
     * @return the ColorPalette
     */
    public native ColorPalette getPalette() /*-{
        var ci = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return @com.gwtext.client.widgets.ColorPalette::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(ci.palette);
    }-*/;
}