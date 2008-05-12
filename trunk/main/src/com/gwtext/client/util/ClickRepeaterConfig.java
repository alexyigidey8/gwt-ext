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
 
package com.gwtext.client.util;

import com.google.gwt.user.client.Element;
import com.gwtext.client.core.BaseConfig;

/**
 * ClickRepeater configuration class.
 *
 * @author Sanjiv Jivan
 */
public class ClickRepeaterConfig extends BaseConfig {

    /**
     * True if autorepeating should start slowly and accelerate.
     * "interval" and "delay" are ignored. "immediate" is honored.
     *
     * @param accelerate true to start slowly and accelerate
     */
    public void setAccelerate(boolean accelerate) {
        JavaScriptObjectHelper.setAttribute(jsObj, "accelerate", accelerate);
    }

    /**
     * The initial delay before the repeating event begins firing. Similar to an autorepeat key delay.
     *
     * @param delay delay in milliseconds. Default is 250
     */
    public void setDelay(int delay) {
        JavaScriptObjectHelper.setAttribute(jsObj, "delay", delay);
    }

    /**
     * The element to act as a button.
     *
     * @param element the element
     */
    public void setElement(Element element) {
        JavaScriptObjectHelper.setAttribute(jsObj, "el", element);
    }

    /**
     * The element to act as a button.
     *
     * @param elementID the element ID
     */
    public void setElement(String elementID) {
        JavaScriptObjectHelper.setAttribute(jsObj, "el", elementID);
    }

    /**
     * The interval between firings of the "click" event. Default is 10 milliseconds.
     *
     * @param interval the firing interval
     */
    public void setInterval(int interval) {
        JavaScriptObjectHelper.setAttribute(jsObj, "interval", interval);
    }

    /**
     * A CSS class name to be applied to the element while pressed.
     *
     * @param pressClass the press CSS class
     */
    public void setPressClass(String pressClass) {
        JavaScriptObjectHelper.setAttribute(jsObj, "pressClass", pressClass);
    }

    /**
     * True to prevent the default click event. Default is true.
     *
     * @param preventDefault true to prevent default click
     */
    public void setPreventDefault(boolean preventDefault) {
        JavaScriptObjectHelper.setAttribute(jsObj, "preventDefault", preventDefault);
    }

    /**
     * True to stop the default click event. Default is false.
     *
     * @param stopDefault true to stop default click event
     */
    public void setStopDefault(boolean stopDefault) {
        JavaScriptObjectHelper.setAttribute(jsObj, "stopDefault", stopDefault);
    }
}
