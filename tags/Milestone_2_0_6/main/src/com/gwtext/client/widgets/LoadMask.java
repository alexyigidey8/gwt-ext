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
 
package com.gwtext.client.widgets;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * A simple utility class for generically masking elements while loading data. If the element being masked has an
 * underlying {@link com.gwtext.client.data.Store}, the masking will be automatically synchronized with the store's
 * loading process and the mask element will be cached for reuse. For all other elements, this mask will replace the
 * element's UpdateManager load indicator and will be destroyed after the initial load.
 *
 * @author Sanjiv Jivan
 */
public class LoadMask extends JsObject {

    private String message;
    private String messageCls = "x-mask-loading";
    private boolean removeMask;
    /**
     * Create a new LoadMask.
     *
     * @param element the element to mask
     * @param message the text to display in a centered loading message box
     */
    public LoadMask(Element element, String message) {
        this.message = message;
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "msg", message);
        jsObj = create(element, config);
    }

    /**
     * Create a new LoadMask.
     *
     * @param element the element to mask
     * @param message the text to display in a centered loading message box
     * @param messageCls the CSS class to apply to the loading message element (defaults to "x-mask-loading").
     * @param removeMask  true to create a single-use mask that is automatically destroyed after loading (useful for page loads),
     * false to persist the mask element reference for multiple uses (e.g., for paged data widgets).
     */
    public LoadMask(Element element, String message, String messageCls, boolean removeMask) {
        this.message = message;
        this.messageCls = messageCls;
        this.removeMask = removeMask;
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "msg", message);
        JavaScriptObjectHelper.setAttribute(config, "msgCls", messageCls);
        JavaScriptObjectHelper.setAttribute(config, "removeMask", removeMask);
        jsObj = create(element, config);
    }

    /**
     * Create a new LoadMask.
     *
     * @param element the element to mask
     * @param message the text to display in a centered loading message box
     * @param messageCls the CSS class to apply to the loading message element (defaults to "x-mask-loading").
     * @param removeMask  true to create a single-use mask that is automatically destroyed after loading (useful for page loads),
     * false to persist the mask element reference for multiple uses (e.g., for paged data widgets).
     * @param store the store to which the mask is bound. The mask is displayed when a load request is issued, and hidden on either load sucess, or load fail.
     */
    public LoadMask(Element element, String message, String messageCls, boolean removeMask, Store store) {
        this.message = message;
        this.messageCls = messageCls;
        this.removeMask = removeMask;
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "msg", message);
        JavaScriptObjectHelper.setAttribute(config, "msgCls", messageCls);
        JavaScriptObjectHelper.setAttribute(config, "removeMask", removeMask);
        JavaScriptObjectHelper.setAttribute(config, "store", store.getJsObj());
        jsObj = create(element, config);
    }

    /**
     * Create a new LoadMask.
     *
     * @param id     the element ID to mask
     * @param message the text to display in a centered loading message box
     */
    public LoadMask(String id, String message) {
        this.message = message;
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "msg", message);
        jsObj = create(id, config);
    }

    /**
     * Create a new LoadMask.
     *
     * @param id     the element ID to mask
     * @param message the text to display in a centered loading message box
     * @param messageCls the CSS class to apply to the loading message element (defaults to "x-mask-loading").
     * @param removeMask  true to create a single-use mask that is automatically destroyed after loading (useful for page loads),
     * false to persist the mask element reference for multiple uses (e.g., for paged data widgets).
     */
    public LoadMask(String id, String message, String messageCls, boolean removeMask) {
        this.message = message;
        this.messageCls = messageCls;
        this.removeMask = removeMask;
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "msg", message);
        JavaScriptObjectHelper.setAttribute(config, "msgCls", messageCls);
        JavaScriptObjectHelper.setAttribute(config, "removeMask", removeMask);
        jsObj = create(id, config);
    }

    /**
     * Create a new LoadMask.
     *
     * @param id     the element ID to mask
     * @param message the text to display in a centered loading message box
     * @param messageCls the CSS class to apply to the loading message element (defaults to "x-mask-loading").
     * @param removeMask  true to create a single-use mask that is automatically destroyed after loading (useful for page loads),
     * false to persist the mask element reference for multiple uses (e.g., for paged data widgets).
     * @param store the store to which the mask is bound. The mask is displayed when a load request is issued, and hidden on either load sucess, or load fail.
     */
    public LoadMask(String id, String message, String messageCls, boolean removeMask, Store store) {
        this.message = message;
        this.messageCls = messageCls;
        this.removeMask = removeMask;
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "msg", message);
        JavaScriptObjectHelper.setAttribute(config, "msgCls", messageCls);
        JavaScriptObjectHelper.setAttribute(config, "removeMask", removeMask);
        JavaScriptObjectHelper.setAttribute(config, "store", store.getJsObj());
        jsObj = create(id, config);
    }

    private native JavaScriptObject create(Element element, JavaScriptObject config) /*-{
        return new $wnd.Ext.LoadMask(element, config);
    }-*/;

    private native JavaScriptObject create(String id, JavaScriptObject config) /*-{
        return new $wnd.Ext.LoadMask(id, config);
    }-*/;

    /**
     * Disables the mask to prevent it from being displayed.
     */
    public native void disable() /*-{
        var lm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        lm.disable();
    }-*/;

    /**
     * Enables the mask so that it can be displayed.
     */
    public native void enable() /*-{
        var lm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        lm.enable();
    }-*/;

    /**
     * Show this LoadMask over the configured Element.
     */
    public native void show() /*-{
        var lm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        lm.show();
    }-*/;

    /**
     * Hide this LoadMask.
     */
    public native void hide() /*-{
        var lm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        lm.hide();
    }-*/;

    /**
     * True if the mask is currently disabled so that it will not be displayed (defaults to false)
     *
     * @return true if mask disabled
     */
    public native boolean isDisabled() /*-{
        var lm = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return lm.disabled;
    }-*/;

    /**
     * The text to display in a centered loading message box (defaults to 'Loading...').
     *
     * @return the messsage text
     */
    public String getMessage() {
        return message;
    }

    /**
     * The CSS class to apply to the loading message element (defaults to "x-mask-loading").
     * 
     * @return the message CSS class
     */
    public String getMessageCls() {
        return messageCls;
    }

    /**
     * True to create a single-use mask that is automatically destroyed after loading (useful for page loads), False to persist the mask element reference for multiple uses (e.g., for paged data widgets).
     * Defaults to false.
     * 
     * @return true to create a single-use mask
     */
    public boolean isRemoveMask() {
        return removeMask;
    }
}
