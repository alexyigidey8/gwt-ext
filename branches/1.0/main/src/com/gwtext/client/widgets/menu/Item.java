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

/**
 * A base class for all menu items that require menu-related functionality (like sub-menus) and are not static display
 * items. Item extends the base functionality of {@link BaseItem} by adding menu-specific activation and click handling.
 */
public class Item extends BaseItem {

    protected Item() {
        setJsObj(create(null));
    }

    /**
     * Create a new Item.
     *
     * @param config the config object
     */
    public Item(ItemConfig config) {
        super(config);
    }

    /**
     * Create a new Item.
     * 
     * @param text the item text
     * @param config the config object
     */
    public Item(String text, ItemConfig config) {
        super(config);
        setText(text);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.menu.Item(config);
    }-*/;

    /**
     * Sets teh text of the item.
     *
     * @param text the item text
     */
    public native void setText(String text) /*-{
        var item = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        item.setText(text);
    }-*/;

    /**
     * Return the item text.
     *
     * @return the item text
     */
    public native String getText() /*-{
        var item = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        return item.text;
    }-*/;
}