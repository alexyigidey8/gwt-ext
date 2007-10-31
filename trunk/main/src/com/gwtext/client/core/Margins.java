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
package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Class that represents the margins of an element.
 */
public class Margins {

    private int top;
    private int left;
    private int right;
    private int bottom;

    /**
     * Create a new Margins instance.
     *
     * @param top the top margin
     * @param left the left margin
     * @param right the right margin
     * @param bottom the bottom margin
     */
    public Margins(int top, int left, int right, int bottom) {
        this.top = top;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
    }

    private static Margins instance(JavaScriptObject jsObj) {
        return new Margins(
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "top"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "left"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "right"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "bottom")
        );
    }

    /**
     * @return the top margin
     */
    public int getTop() {
        return top;
    }

    /**
     * @return the left margin
     */
    public int getLeft() {
        return left;
    }

    /**
     * @return the right margin
     */
    public int getRight() {
        return right;
    }

    /**
     * @return the bottom margin
     */
    public int getBottom() {
        return bottom;
    }
}
