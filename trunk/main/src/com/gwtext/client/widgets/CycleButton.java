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
import com.gwtext.client.widgets.event.CycleButtonListener;
import com.gwtext.client.widgets.menu.CheckItem;

/**
 * A specialized SplitButton that contains a menu of {@link CheckItem} elements. The button automatically cycles through
 * each menu item on click, raising the button's change event (or calling the button's changeHandler function, if supplied)
 * for the active menu item. Clicking on the arrow section of the button displays the dropdown menu just like a normal SplitButton.
 * <p/>
 * <pre>
 * <code>
 * <p/>
 * CycleButtonConfig config = new CycleButtonConfig();
 * config.setShowText(true);
 * config.setPrependText("View as ");
 * config.addItem(new CheckItem("text only", true));
 * config.addItem(new CheckItem("HTML", false));
 *
 * config.setChangeHandler(new CycleButtonHandler() {
 *     public void execute(CycleButton self, CheckItem item) {
 *         MessageBox.alert("Change View", item.getText());
 *     }
 * });
 * <p/>
 * CycleButton button = new CycleButton(config);
 *  </code>
 * </pre>
 *
 * @author Sanjiv Jivan
 */
public class CycleButton extends SplitButton {

/*	private static JavaScriptObject configPrototype;

    static {
        init();
    }

    private static native void init() *//*-{
        var c = new $wnd.Ext.CycleButton();
        @com.gwtext.client.widgets.CycleButton::configPrototype = c.initialConfig;
    }-*//*;


    protected JavaScriptObject getConfigPrototype() {
		return configPrototype;
	}*/

    public String getXType() {
        return "cycle";
    }

    /**
     * Create a new CycleButton.
     */
    public CycleButton() {
    }

    /**
     * Create a new CycleButton.
     *
     * @param listener the button listener
     */
    public CycleButton(CycleButtonListener listener) {
        addListener(listener);
    }

    /**
     * Create a new CycleButton.
     *
     * @param listener the button listener
     * @param icon icon image path
     */
    public CycleButton(CycleButtonListener listener, String icon) {
        setIcon(icon);
        addListener(listener);
    }

    public CycleButton(JavaScriptObject jsObj) {
        super(jsObj);
    }

    private static CycleButton instance(JavaScriptObject jsObj) {
        return new CycleButton(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.CycleButton(config);
    }-*/;

    /**
     * Gets the currently active menu item.
     *
     * @return the active menu item
     */
    public native CheckItem getActiveItem() /*-{
        var button = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var item = button.getActiveItem();
        var itemJ = @com.gwtext.client.widgets.menu.CheckItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
        return itemJ;
    }-*/;

    /**
     * Sets the button's active menu item.
     *
     * @param item the item to activate
     */
    public native void setActiveItem(CheckItem item) /*-{
        var button = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var itemJS = item.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        button.setActiveItem(itemJS);
    }-*/;

    /**
     * Sets the button's active menu item.
     *
     * @param item         the item to activate
     * @param supressEvent true to prevent the button's change event from firing (defaults to false)
     */
    public native void setActiveItem(CheckItem item, boolean supressEvent) /*-{
        var button = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        var itemJS = item.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        button.setActiveItem(itemJS, supressEvent);
    }-*/;

    /**
     * This is normally called internally on button click, but can be called externally to advance the button's active
     * item programmatically to the next one in the menu. If the current item is the last one in the menu the active item
     * will be set to the first item in the menu.
     */
    public native void toggleSelected() /*-{
        var button = this.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
        button.toggleSelected();
    }-*/;

    /**
     * Add a CycleButton Listener.
     *
     * @param listener the listener
     */
    public native void addListener(CycleButtonListener listener)/*-{

        this.@com.gwtext.client.widgets.SplitButton::addListener(Lcom/gwtext/client/widgets/event/SplitButtonListener;)(listener);
        var buttonJ = this;

        this.@com.gwtext.client.widgets.Component::addListener(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)('change',
                function(source, item) {
					var itemJ = @com.gwtext.client.widgets.menu.CheckItem::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
                    listener.@com.gwtext.client.widgets.event.CycleButtonListener::onChange(Lcom/gwtext/client/widgets/CycleButton;Lcom/gwtext/client/widgets/menu/CheckItem;)(buttonJ, itemJ);
                }
        );
    }-*/;

    //--- config properties  ---

    /**
     * Add a CheckItem config object to be used when creating the button's menu items. Note that when initially creating the CycleButton,
     * one CheckItem must be checked ie new CheckItem(s, true).
     *
     * @param item check item config
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void addItem(CheckItem item) throws IllegalStateException {
        if(isRendered()) {
            throw new IllegalStateException("Items can be added to the CycleButton only prior to render.");
        }
        addItemPreRender(item);
    }

    private native void addItemPreRender(CheckItem item) throws IllegalStateException/*-{
		var config = this.@com.gwtext.client.widgets.Component::config;
        var itemJS = item.@com.gwtext.client.widgets.Component::config;
        if(!config.items) {
            config.items = @com.gwtext.client.util.JavaScriptObjectHelper::createJavaScriptArray()();
        }
        config.items.push(itemJS);
    }-*/;

    /**
     * A css class which sets an image to be used as the static icon for this button. This icon will always be displayed
     * regardless of which item is selected in the dropdown list. This overrides the default behavior of changing the
     * button's icon to match the selected item's icon on change.
     *
     * @param forceIcon the forceIcon
     * @throws IllegalStateException this property cannot be changed after the Component has been rendered
     */
    public void setForceIcon(String forceIcon) {
        setAttribute("forceIcon", forceIcon, true);
    }

    /**
     * A css class which sets an image to be used as the static icon for this button. This icon will always be displayed
     * regardless of which item is selected in the dropdown list. This overrides the default behavior of changing the
     * button's icon to match the selected item's icon on change.
     *
     * @return the forceIcon
     */
    public String getForceIcon() {
        return getAttribute("forceIcon");
    }

    
    /**
     * A static string to prepend before the active item's text when displayed as the button's text
     * (only applies when showText = true, defaults to '').
     *
     * @param prependText the prepend text
     */
    public void setPrependText(String prependText) {
        setAttribute("prependText", prependText, true, true);
    }

    /**
     * @return the prepend text
     */
    public String getPrependText() {
        return getAttribute("prependText");
    }

    /**
     * True to display the active item's text as the button text (defaults to false).
     *
     * @param showText true to display item's text
     */
    public void setShowText(boolean showText) {
        setAttribute("showText", showText, true, true);
    }

    /**
     * @return the show text
     */
    public String getShowText() {
        return getAttribute("showText");
    }
}
