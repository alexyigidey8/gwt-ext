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
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.Ext;
import com.gwtext.client.core.ExtElement;
import com.gwtext.client.core.Function;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.LayoutRegionConfig;

public class LayoutDialog extends BaseExtWidget {

    public LayoutDialog(LayoutDialogConfig config, LayoutRegionConfig north, LayoutRegionConfig south, LayoutRegionConfig west, LayoutRegionConfig east, LayoutRegionConfig center) {
        JavaScriptObject configJS = config.getJsObj();
        if (north != null) JavaScriptObjectHelper.setAttribute(configJS, "north", north.getJsObj());
        if (south != null) JavaScriptObjectHelper.setAttribute(configJS, "south", south.getJsObj());
        if (west != null) JavaScriptObjectHelper.setAttribute(configJS, "west", west.getJsObj());
        if (east != null) JavaScriptObjectHelper.setAttribute(configJS, "east", east.getJsObj());
        if (center != null) JavaScriptObjectHelper.setAttribute(configJS, "center", center.getJsObj());
        jsObj = create(Ext.generateId(), configJS);
    }

    public LayoutDialog(JavaScriptObject jsObj) {
        super(jsObj);
    }

    public static LayoutDialog instance(JavaScriptObject jsObj) {
        return new LayoutDialog(jsObj);
    }

    private native JavaScriptObject create(String id, JavaScriptObject configJS) /*-{
        return new $wnd.Ext.LayoutDialog(id, configJS);
    }-*/;

    public native void addButton(Button button) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var buttonJ = button.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.addButton(buttonJ);
    }-*/;

    public native void alignTo(String id, String position, int[] offsetXY)/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var offsetJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(offsetXY);
        dialog.alignTo(id, position, offsetJS);
    }-*/;

    public native void anchorTo(String id, String position, int[] offsetXY, int bufferDelay)/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var offsetJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(offsetXY);
        dialog.anchorTo(id, position, offsetJS, bufferDelay);
    }-*/;

    public native void center() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.show();
    }-*/;

    public native void collapse() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.collapse();
    }-*/;

    public native void destroy() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.destroy();
    }-*/;

    public native void destroy(boolean removeEL) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.destroy(removeEL);
    }-*/;

    public native void expand() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.expand();
    }-*/;

    public native void focus() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.focus();
    }-*/;

    public BorderLayout getLayout() {
        return new BorderLayout(getLayout(jsObj));
    }

    private native JavaScriptObject getLayout(JavaScriptObject layoutDialog) /*-{
        return layoutDialog.getLayout();
    }-*/;

    public native TabPanel getTabs()/*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var tabs = dialog.getTabs();
        return tabs == null ? null : @com.gwtext.client.widgets.TabPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tabs);
    }-*/;


    public native void hide() /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            dialog.hide();
    }-*/;

    public native void hide(Function cb) /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            dialog.hide(function() {
                cb.@com.gwtext.client.core.Function::execute()();
            });
    }-*/;

    public native TabPanel initTabs() /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            var tabs = dialog.initTabs();
            return tabs == null ? null : @com.gwtext.client.widgets.TabPanel::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(tabs);
    }-*/;

    public native void resizeTo(int width, int height) /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            dialog.resizeTo(width, height);
    }-*/;

    public native void restoreState() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.restoreState();
    }-*/;

    public native void setContentSize(int width, int height) /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            dialog.setContentSize(width, height);
    }-*/;

    public native void setDefaultButton(Button btn) /*-{
            var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            var btnJS = btn.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
            dialog.setDefaultButton(btnJS);
    }-*/;

    public native void setTitle(String title) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.setTitle(title);
    }-*/;

    public native void show() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.show();
    }-*/;

    public native void show(String animateTargetId) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.show(animateTargetId);
    }-*/;

    public native void show(Element target) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.show(target);
    }-*/;

    public native void show(ExtElement target) /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var targetJS = target.@com.gwtext.client.core.JsObject::jsObj;
        dialog.show(targetJS);
    }-*/;

    public native void toBack() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.toBack();
    }-*/;

    public native void toFront() /*-{
        var dialog = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        dialog.toFront();
    }-*/;



    
}
