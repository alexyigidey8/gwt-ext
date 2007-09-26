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

package com.gwtext.client.widgets.form;

import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.ComponentConfig;

public class LayoutConfig extends ComponentConfig {

    public void setAutoCreate(String autoCreate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "autoCreate", autoCreate);
    }

    public void setClear(boolean clear) {
        JavaScriptObjectHelper.setAttribute(jsObj, "clear", clear);
    }

    public void setHideLabels(boolean hideLabels) {
        JavaScriptObjectHelper.setAttribute(jsObj, "hideLabels", hideLabels);
    }

    public void setLabelAlign(String labelAlign) {
        JavaScriptObjectHelper.setAttribute(jsObj, "labelAlign", labelAlign);
    }

    //todo make field config ? http://extjs.com/forum/showthread.php?t=5270
    public void setLabelSeparator(String labelSeparator) {
        JavaScriptObjectHelper.setAttribute(jsObj, "labelSeparator", labelSeparator);
    }

    public void setLabelWidth(int labelWidth) {
        JavaScriptObjectHelper.setAttribute(jsObj, "labelWidth", labelWidth);
    }

    public void setStyle(String style) {
        JavaScriptObjectHelper.setAttribute(jsObj, "style", style);
    }
}