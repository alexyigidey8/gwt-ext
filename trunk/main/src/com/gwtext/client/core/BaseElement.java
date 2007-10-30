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
import com.google.gwt.user.client.Element;
import com.gwtext.client.animation.Easing;
import com.gwtext.client.util.KeyMap;
import com.gwtext.client.util.KeyMapConfig;
import com.gwtext.client.widgets.event.KeyListener;

/**
 * Represents a base Element in the DOM.
 */
public class BaseElement extends JsObject implements Fx {

    protected BaseElement() {
    }

    public BaseElement(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Adds a CSS class to the element. Duplicate classes are automatically filtered out.
     *
     * @param className The CSS class to add
     * @return this
     */
    public native BaseElement addClass(String className)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.addClass(className);
        return this;
    }-*/;

    /**
     *  Adds CSS classes to the element. Duplicate classes are automatically filtered out.
     *
     * @param classNames an array of CSS classes
     * @return this
     */
    public native BaseElement addClass(String[] classNames)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.addClass(@com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([Ljava/lang/Object;)(classNames));
        return this;
    }-*/;

    /**
     * Sets up event handlers to add and remove a css class when the mouse is down and then up on this element (a click effect).
     *
     * @param className The CSS class to add
     * @return this
     */
    public native BaseElement addClassOnClick(String className)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.addClassOnClick(className);
        return this;
    }-*/;

    /**
     * Sets up event handlers to add and remove a css class when this element has the focus
     *
     * @param className The CSS class to add
     * @return this
     */
    public native BaseElement addClassOnFocus(String className)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.addClassOnFocus(className);
        return this;
    }-*/;

    public native BaseElement addClassOnOver(String className)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.addClassOnOver(className);
        return this;
    }-*/;

    /**
     * Sets up event handlers to add and remove a css class when the mouse is over this element.
     * 
     * @param className The CSS class to add
     * @param preventFlicker if set to true, it prevents flickering by filtering mouseout events for children elements
     * @return this
     */
    public native BaseElement addClassOnOver(String className, boolean preventFlicker)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.addClassOnOver(className, preventFlicker);
        return this;
    }-*/;

    /**
     * Convenience method for constructing a KeyMap.
     * 
     * @param keyCode the numeric key code
     * @param listener the key listener
     * @return the KeyMap created
     */
    public native KeyMap addKeyListener(int keyCode, KeyListener listener)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var km = elem.addKeyListener(keyCode, function(key, event) {
                var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                listener.@com.gwtext.client.widgets.event.KeyListener::onKey(ILcom/gwtext/client/core/EventObject;)(key, e);
            });
        return @com.gwtext.client.util.KeyMap::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(km);
    }-*/;

    /**
     * Convenience method for constructing a KeyMap.
     *
     * @param keyCodes array of key codes
     * @param listener  the key listener
     * @return the KeyMap created
     */
    public native KeyMap addKeyListener(int[] keyCodes, KeyListener listener)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var keyCodesJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(keyCodes);
        var km = elem.addKeyListener(keyCodesJS, function(key, event) {
                var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                listener.@com.gwtext.client.widgets.event.KeyListener::onKey(ILcom/gwtext/client/core/EventObject;)(key, e);
            });
        return @com.gwtext.client.util.KeyMap::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(km);
    }-*/;

    /**
     * Convenience method for constructing a KeyMap.
     *
     * @param keys a string with the keys to listen for
     * @param listener the key listener
     * @return the KeyMap created
     */
    public native KeyMap addKeyListener(String keys, KeyListener listener)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var km = elem.addKeyListener(keys, function(key, event) {
                var e = @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                listener.@com.gwtext.client.widgets.event.KeyListener::onKey(ILcom/gwtext/client/core/EventObject;)(key, e);
            });
        return @com.gwtext.client.util.KeyMap::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(km);
    }-*/;

    /**
     * Convenience method for constructing a KeyMap.
     *
     * @param config the key map config
     * @return the KeyMap created
     */
    public native KeyMap addKeyMap(KeyMapConfig config)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        var km = elem.addKeyMap(configJS);
        return @com.gwtext.client.util.KeyMap::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(km);
    }-*/;

    /**
     * Appends an event handler.
     *
     * @param eventName The type of event to append
     * @param cb the event callback
     */
    public native void addListener(String eventName, EventCallback cb) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.addListener(eventName, function(event) {
                var e = (event === undefined || event == null) ? null : @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(e);
            }
        );
    }-*/;

    /**
     * Appends an event handler.
     *
     * @param eventName The type of event to append
     * @param cb the event callback
     * @param config the listener config
     */
    public native void addListener(String eventName, EventCallback cb, ListenerConfig config) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.addListener(eventName, function(event) {
                var e = (event === undefined || event == null) ? null : @com.gwtext.client.core.EventObject::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
                cb.@com.gwtext.client.core.EventCallback::execute(Lcom/gwtext/client/core/EventObject;)(e);
            },
            null,
            config.@com.gwtext.client.core.JsObject::jsObj
        );
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor points. If the other element is the document it aligns it to the viewport.
     * 
     * @param id The element to align to
     * @param elementAnchor the element's anchor point
     * @param targetAnchor the target's anchor point
     * @return this
     */
    public native BaseElement alignTo(String id, AnchorPosition elementAnchor, AnchorPosition targetAnchor)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var position1JS = elementAnchor.@com.gwtext.client.core.AnchorPosition::getPosition()();
        var position2JS = targetAnchor.@com.gwtext.client.core.AnchorPosition::getPosition()();
        var positionJS = position1JS = '-' + position2JS;
        elem.alignTo(id, positionJS);
        return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor points. If the other element is the document it aligns it to the viewport.
     *
     * @param id The element to align to
     * @param elementAnchor the element's anchor point
     * @param targetAnchor the target's anchor point
     * @param offsetXY offset the positioning by [x, y]
     * @param animate true for the default animation
     * @return this
     */
    public native BaseElement alignTo(String id, AnchorPosition elementAnchor, AnchorPosition targetAnchor, int[] offsetXY, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var offsetJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(offsetXY);
        var position1JS = elementAnchor.@com.gwtext.client.core.AnchorPosition::getPosition()();
        var position2JS = targetAnchor.@com.gwtext.client.core.AnchorPosition::getPosition()();
        var positionJS = position1JS = '-' + position2JS;
        elem.alignTo(id, positionJS, offsetJS, animate);
        return this;
    }-*/;

    /**
     * Aligns this element with another element relative to the specified anchor points. If the other element is the document it aligns it to the viewport.
     *
     * @param id The element to align to
     * @param elementAnchor the element's anchor point
     * @param targetAnchor the target's anchor point
     * @return this
     */
    public native BaseElement anchorTo(String id, AnchorPosition elementAnchor, AnchorPosition targetAnchor)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var position1JS = elementAnchor.@com.gwtext.client.core.AnchorPosition::getPosition()();
        var position2JS = targetAnchor.@com.gwtext.client.core.AnchorPosition::getPosition()();
        var positionJS = position1JS = '-' + position2JS;
        elem.anchorTo(id, positionJS);
        return this;
    }-*/;

    //todo fix ext inconsistency
    /**
     * Aligns this element with another element relative to the specified anchor points. If the other element is the document it aligns it to the viewport.
     *
     * @param id The element to align to
          * @param elementAnchor the element's anchor point
     * @param targetAnchor the target's anchor point
     * @param offsetXY offset the positioning by [x, y]
     * @param animate true for the default animation
     * @param bufferDelay buffer delay
     * @return this
     */
    public native BaseElement anchorTo(String id, AnchorPosition elementAnchor, AnchorPosition targetAnchor, int[] offsetXY, boolean animate, int bufferDelay)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var offsetJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([I)(offsetXY);
        elem.anchorTo(id, position, offsetJS, animate, bufferDelay);
        return this;
    }-*/;

    /**
     * Perform animation on this element. For example :
     * <code><pre>
     * GenericConfig animArgs = new GenericConfig();
     * GenericConfig widthArgs = new GenericConfig();
     * widthArgs.setProperty("from", 600);
     * widthArgs.setProperty("to", 0);
     * animArgs.setProperty("width", widthArgs);
     * el.animate(animArgs);
     * </pre></code>
     *
     * @param args animation control args
     * @return this
     */
    public native BaseElement animate(GenericConfig args)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var argsJS = args == null ? null : args.@com.gwtext.client.core.JsObject::jsObj;
        elem.animate(argsJS);
        return this;
    }-*/;

    /**
     * Perform animation on this element.
     *
     * @param args animation control args
     * @param duration how long the animation lasts in seconds (defaults to .35)
     * @param onComplete function to call when animation completes
     * @param easing  easeOut See http://developer.yahoo.com/yui/docs/YAHOO.util.Easing.html
     * @param animType 'run' is the default. Can also be 'color', 'motion', or 'scroll'
     * @return this
     */
    public native BaseElement animate(GenericConfig args, float duration, Function onComplete, String easing, String animType)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var argsJS = args == null ? null : args.@com.gwtext.client.core.JsObject::jsObj;
        elem.animate(argsJS, duration, onComplete == null ? null : function() {
            onComplete.@com.gwtext.client.core.Function::execute()();
        }, easing, animType);
        return this;
    }-*/;

    /**
     * More flexible version of {@link #setStyle} for setting style properties.
     * 
     * @param style a style specification string, e.g. "width:100px"
     * @return this
     */
    public native BaseElement applyStyles(String style) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.applyStyles(style);
        return this;
    }-*/;

    /**
     * Measures the element's content height and updates height to match. Note: this function uses setTimeout so the new height may not be available immediately.
     *
     * @return this
     */
    public native BaseElement autoHeight() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.autoHeight();
        return this;
    }-*/;

    //todo fix ext inconsisteny
    /**
     * Measures the element's content height and updates height to match. Note: this function uses setTimeout so the new height may not be available immediately.
     *
     * @param animate animate the transition (defaults to false)
     * @param duration length of the animation in seconds (defaults to .35)
     * @param onComplete Function to call when animation completes
     * @param easing
     * @return
     */
    public native BaseElement autoHeight(boolean animate, float duration, Function onComplete, Easing easing)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var easingJS = easing.@com.gwtext.client.animation.Easing::getMethod();
        elem.autoHeight(animate, duration, function() {
            onComplete.@com.gwtext.client.core.Function::execute()();
        }, easingJS);
        return this;
    }-*/;

    /**
     * Removes worthless text nodes.
     */
    public native void clean() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.clean();
    }-*/;

    /**
     * Removes worthless text nodes.
     *
     * @param forceClean by default the element keeps track if it has been cleaned already so you can call this over and over. However, if you update the element and need to force a reclean, you can pass true.
     */
    public native void clean(boolean forceClean) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.clean(forceClean);
    }-*/;

    /**
     *  Clears any opacity settings from this element. Required in some cases for IE.
     *
     * @return this
     */
    public native BaseElement clearOpacity() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.clearOpacity();
        return this;
    }-*/;

    /**
     * Store the current overflow setting and clip overflow on the element - use unclip to remove.
     *
     * @return this
     */
    public native BaseElement clip() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.clip();
        return this;
    }-*/;

    /**
     * Creates an iframe shim for this element to keep selects and other windowed objects from showing through.
     *
     * @return The new shim element
     */
    public native ExtElement createShim() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var el = elem.shim();
        return @com.gwtext.client.core.ExtElement::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(el);
    }-*/;

    /**
     * Convenience method for setVisibilityMode(Element.DISPLAY)
     *
     * @return this
     */
    public native BaseElement enableDisplayMode() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.enableDisplayMode();
        return this;
    }-*/;

    /**
     * Convenience method for setVisibilityMode(Element.DISPLAY)
     *
     * @param display what to set display to when visible
     * @return this
     */
    public native BaseElement enableDisplayMode(String display) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.enableDisplayMode(display);
        return this;
    }-*/;

    /**
     * Sizes this element to its parent element's dimensions performing neccessary box adjustments.
     *
     * @return this
     */
    public native BaseElement fitToParent() /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.fitToParent();
        return this;
    }-*/;

    /**
     * Sizes this element to its parent element's dimensions performing neccessary box adjustments.
     *
     * @param monitorResize if true maintains the fit when the browser window is resized
     * @param targetParent he target parent, default to the parentNode.
     * @return this
     */
    public native BaseElement fitToParent(boolean monitorResize, Element targetParent) /*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.fitToParent(monitorResize, targetParent);
        return this;
    }-*/;

    /**
     * Hide this element - Uses display mode to determine whether to use "display" or "visibility". See {@link #setVisible}.
     *
     * @return this
     */
    public native BaseElement hide()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.hide();
        return this;
    }-*/;

    /**
     * Hide this element - Uses display mode to determine whether to use "display" or "visibility". See {@link #setVisible}.
     *
     * @param animate true for the default animation
     * @return this
     */
    public native BaseElement hide(boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.hide(animate);
        return this;
    }-*/;

    /**
     * Hide this element - Uses display mode to determine whether to use "display" or "visibility". See {@link #setVisible}.
     * 
     * @param animateConfig the animation config
     * @return this
     */
    public native BaseElement hide(AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.hide(animateConfigJS);
        return this;
    }-*/;

    /**
     * Move this element relative to its current position.
     *
     * @param direction the direction
     * @param distance how far to move the element in pixels
     * @return this
     */
    public native BaseElement move(Direction direction, int distance)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var directionJS = direction.@com.gwtext.client.core.Direction::getDirection()();
        elem.move(directionJS, distance);
        return this;
    }-*/;

    /**
     * Move this element relative to its current position.
     * 
     * @param direction the direction
     * @param distance how far to move the element in pixels
     * @param animate true for the default animation
     * @return this
     */
    public native BaseElement move(Direction direction, int distance, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var directionJS = direction.@com.gwtext.client.core.Direction::getDirection()();
        elem.move(directionJS, distance, animate);
        return this;
    }-*/;

    /**
     * Move this element relative to its current position.
     *
     * @param direction the direction
     * @param distance how far to move the element in pixels
     * @param animateConfig the animation config
     * @return this
     */
    public native BaseElement move(Direction direction, int distance, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        var directionJS = direction.@com.gwtext.client.core.Direction::getDirection()();
        elem.move(directionJS, distance, animateConfigJS);
        return this;
    }-*/;

    /**
     * Sets the position of the element in page coordinates, regardless of how the element is positioned. The element must be part of the DOM tree to have page coordinates (display:none or elements not appended return false).
     *
     * @param x X value for new position (coordinates are page-based)
     * @param y Y value for new position (coordinates are page-based)
     * @return this
     */
    public native BaseElement moveTo(int x, int y)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.moveTo(x, y);
        return this;
    }-*/;

    /**
     * Sets the position of the element in page coordinates, regardless of how the element is positioned. The element must be part of the DOM tree to have page coordinates (display:none or elements not appended return false).
     *
     * @param x X value for new position (coordinates are page-based)
     * @param y Y value for new position (coordinates are page-based)
     * @param animate true to animate
     * @return this
     */
    public native BaseElement moveTo(int x, int y, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.moveTo(x, y, animate);
        return this;
    }-*/;

    /**
     * Sets the position of the element in page coordinates, regardless of how the element is positioned. The element must be part of the DOM tree to have page coordinates (display:none or elements not appended return false).
     *
     * @param x X value for new position (coordinates are page-based)
     * @param y Y value for new position (coordinates are page-based)
     * @param animateConfig the animcation config
     * @return this
     */
    public native BaseElement moveTo(int x, int y, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.moveTo(x, y, animateConfigJS);
        return this;
    }-*/;

    /**
     * Adds a CSS class to this element and removes the same class(es) from all siblings.
     * 
     * @param className The CSS class to add
     * @return this
     */
    public native BaseElement radioClass(String className)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.radioClass(className);
        return this;
    }-*/;

  /**
     * Adds one or more CSS classes to this element and removes the same class(es) from all siblings.
     *
     * @param classNames The CSS classes to add
     * @return this
     */
    public native BaseElement radioClass(String[] classNames)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var classNamesJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([Ljava/lang/Object;)(classNames);
        elem.radioClass(classNamesJS);
        return this;
    }-*/;

    /**
     * Removes this element from the DOM and deletes it from the cache.
     */
    public native void remove()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.remove();
    }-*/;

    /**
     * Removes all previous added listeners from this element.
     */
    public native void removeAllListeners()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.removeAllListeners();
    }-*/;

    /**
     * Removes the CSS classes from the element.
     * 
     * @param className The CSS class to remove
     * @return this
     */
    public native BaseElement removeClass(String className)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.removeClass(className);
        return this;
    }-*/;

    /**
     * Removes the CSS classes from the element.
     *
     * @param classNames The CSS classes to remove
     * @return this
     */
    public native BaseElement removeClass(String[] classNames)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var classNamesJS = @com.gwtext.client.util.JavaScriptObjectHelper::convertToJavaScriptArray([Ljava/lang/Object;)(classNames);
        elem.removeClass(classNamesJS);
        return this;
    }-*/;

    /**
     * Forces the browser to repaint this element.
     *
     * @return this
     */
    public native BaseElement repaint()/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.repaint();
        return this;
    }-*/;

    /**
     * Replaces a CSS class on the element with another. If the old name does not exist, the new name will simply be added.
     * 
     * @param oldClassName The CSS class to replace
     * @param newClassName The replacement CSS class
     * @return this
     */
    public native BaseElement replaceClass(String oldClassName, String newClassName)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.replaceClass(oldClassName, newClassName);
        return this;
    }-*/;

    /**
     * Scrolls this element the specified direction. Does bounds checking to make sure the scroll is within this element's scrollable range.
     *
     * @param direction the direction
     * @param distance how far to scroll the element in pixels
     * @param animate true to animate
     * @return this
     */
    public native boolean scroll(Direction direction, int distance, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var directionJS = direction.@com.gwtext.client.core.Direction::getDirection()();
        return elem.scroll(directionJS, distance, animate);
    }-*/;

    /**
     * Scrolls this element the specified direction. Does bounds checking to make sure the scroll is within this element's scrollable range.
     *
     * @param direction the direction
     * @param distance how far to scroll the element in pixels
     * @param animateConfig the animation config
     * @return this
     */
    public native boolean scroll(Direction direction, int distance, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        var directionJS = direction.@com.gwtext.client.core.Direction::getDirection()();
        return elem.scroll(directionJS, distance, animateConfigJS);
    }-*/;

    public native BaseElement scrollTo(String side, int value, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.scrollTo(side, value, animate);
        return this;
    }-*/;

    public native BaseElement scrollTo(String side, int value, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.scrollTo(side, value, animateConfigJS);
        return this;
    }-*/;

    public native BaseElement set(GenericConfig attributes)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var attributesJS = attributesJS.@com.gwtext.client.core.JsObject::jsObj;
        elem.set(attributesJS);
        return this;
    }-*/;

    public native BaseElement set(GenericConfig attributes, boolean useSet)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var attributesJS = attributesJS.@com.gwtext.client.core.JsObject::jsObj;
        elem.set(attributesJS);
        return this;
    }-*/;

    public native BaseElement setBottom(String bottom)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setBottom(bottom);
        return this;
    }-*/;

    public native BaseElement setBounds(int x, int y, int width, int height)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setBounds(x, y, width, height);
        return this;
    }-*/;

    public native BaseElement setBounds(int x, int y, int width, int height, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setBounds(x, y, width, height, animate);
        return this;
    }-*/;

    public native BaseElement setBounds(int x, int y, int width, int height, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.setBounds(x, y, width, height, animateConfigJS);
        return this;
    }-*/;

    public native BaseElement setBox(Box box)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var boxJS = box.@com.gwtext.client.core.JsObject::jsObj;
        elem.setBox(boxJS);
        return this;
    }-*/;

    public native BaseElement setBox(Box box, boolean adjust, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var boxJS = box.@com.gwtext.client.core.JsObject::jsObj;
        elem.setBox(boxJS, adjust, animate);
        return this;
    }-*/;

    public native BaseElement setBox(Box box, boolean adjust, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var boxJS = box.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.setBox(boxJS, adjust, animateConfigJS);
        return this;
    }-*/;

    public native BaseElement setDisplayed(boolean value)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setDisplayed(value);
        return this;
    }-*/;

    public native BaseElement setHeight(int height, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setHeight(height, animate);
        return this;
    }-*/;

    public native BaseElement setHeight(int height, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.setHeight(height, animateConfigJS);
        return this;
    }-*/;

    public native BaseElement setLeft(String left)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setLeft(left);
        return this;
    }-*/;

    public native BaseElement setLeftTop(String left, String top)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setLeft(left);
        return this;
    }-*/;

    public native BaseElement setLocation(int x, int y, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setLocation(x, y, animate);
        return this;
    }-*/;

    public native BaseElement setLocation(int x, int y, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.setLocation(x, y, animateConfigJS);
        return this;
    }-*/;

    public native BaseElement setOpacity(float opacity, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setOpacity(opacity, animate);
        return this;
    }-*/;

    public native BaseElement setOpacity(float opacity, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.setOpacity(opacity, animateConfigJS);
        return this;
    }-*/;

    public native BaseElement setPositioning(PositioningConfig posCfg)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var posCfgJS = posCfg.@com.gwtext.client.core.JsObject::jsObj;
        elem.setPositioning(posCfgJS);
        return this;
    }-*/;

    public native BaseElement setRegion(Region region, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var regionJS = region.@com.gwtext.client.core.JsObject::jsObj;
        elem.setRegion(regionJS, animate);
        return this;
    }-*/;

    public native BaseElement setRegion(Region region, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var regionJS = region.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.setRegion(regionJS, animateConfigJS);
        return this;
    }-*/;

    public native BaseElement setRight(String right)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setRight(right);
        return this;
    }-*/;

    public native BaseElement setSize(int width, int height, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setSize(width, height, animate);
        return this;
    }-*/;

    public native BaseElement setSize(int width, int height, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.setSize(width, height, animateConfigJS);
        return this;
    }-*/;

    public native BaseElement setStyle(String style, String value)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setStyle(style, value);
        return this;
    }-*/;

    public native BaseElement setStyles(GenericConfig styles)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var stylesJS = styles.@com.gwtext.client.core.JsObject::jsObj;
        elem.setStyle(stylesJS);
        return this;
    }-*/;

    public native BaseElement setTop(String top)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setTop(top);
        return this;
    }-*/;

    public native BaseElement setVisibilityMode(boolean useVisibleProperty)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setVisibilityMode(useVisibleProperty ? $wnd.Ext.Element.VISIBILITY: $wnd.Ext.Element.DISPLAY);
        return this;
    }-*/;

    public BaseElement setVisible(boolean visible) {
        setVisible(visible, false);
        return this;
    }

    public native BaseElement setVisible(boolean visible, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setVisible(visible, animate);
        return this;
    }-*/;

    public native BaseElement setVisible(boolean visible, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.setVisible(visible, animateConfigJS);
        return this;
    }-*/;

    public native BaseElement setWidth(int width, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setWidth(width, animate);
        return this;
    }-*/;

    public native BaseElement setWidth(int width, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.setWidth(width, animateConfigJS);
        return this;
    }-*/;

    public native BaseElement setX(int x, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setX(x, animate);
        return this;
    }-*/;

    public native BaseElement setX(int x, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.setX(x, animateConfigJS);
        return this;
    }-*/;

    public native BaseElement setXY(int x, int y, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setXY([x, y], animate);
        return this;
    }-*/;

    public native BaseElement setXY(int x, int y, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.setXY([x, y], animateConfigJS);
        return this;
    }-*/;

    public native BaseElement setY(int y, boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.setY(y, animate);
        return this;
    }-*/;

    public native BaseElement setY(int y, AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.setY(y, animateConfigJS);
        return this;
    }-*/;

    public native BaseElement show(boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.show(animate);
        return this;
    }-*/;

    public native BaseElement show(AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.show(animateConfigJS);
        return this;
    }-*/;

    public native BaseElement swallowEvent(String eventName)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.swallowEvent(eventName);
        return this;
    }-*/;

    public native BaseElement swallowEvent(String eventName, boolean preventDefault)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.swallowEvent(eventName, preventDefault);
        return this;
    }-*/;

    public native BaseElement toggle(boolean animate)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.toggle(animate);
        return this;
    }-*/;

    public native BaseElement toggle(AnimationConfig animateConfig)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        var animateConfigJS = animateConfig.@com.gwtext.client.core.JsObject::jsObj;
        elem.toggle(animateConfigJS);
        return this;
    }-*/;

    public native BaseElement toggleClass(String className)/*-{
        var elem = this.@com.gwtext.client.core.JsObject::jsObj;
        elem.toggleClass(className);
        return this;
    }-*/;

    public native void unselectable() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.unselectable();
    }-*/;

    public void update(String html) {
        update(html, false);
    }

    public native void update(String html, boolean loadScripts) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.update(html, loadScripts);
    }-*/;

    public native Element wrap(DomConfig config) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.DomConfig::getJsObject()();
        return el.wrap(configJS, true);
    }-*/;

    //Ext Fx API's
    public native Fx fadeIn() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.fadeIn();
        return this;
    }-*/;

    public native Fx fadeIn(FxConfig config) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        el.fadeIn(configJS);
        return this;
    }-*/;

    public native Fx fadeOut() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.fadeOut();
        return this;
    }-*/;

    public native Fx fadeOut(FxConfig config) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        el.fadeOut(configJS);
    return this;
    }-*/;

    public native Fx frame() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.frame();
        return this;
    }-*/;

    public native Fx frame(String color, int count, FxConfig config) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        el.frame(color, count, configJS);
        return this;
    }-*/;

    public native Fx ghost() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.ghost();
        return this;
    }-*/;

    public native Fx ghost(String anchor, FxConfig config) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        el.ghost(anchor, configJS);
        return this;
    }-*/;

    public native boolean hasActiveFx() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        return el.hasActiveFx();
    }-*/;

    public native boolean hasFxBlock() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        return el.hasFxBlock();
    }-*/;

    public native Fx highlight() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.highlight();
        return this;
    }-*/;

    public native Fx highlight(String color, FxConfig config) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        el.highlight(color, configJS);
        return this;
    }-*/;

    public native Fx highlight(String color, String attr, String endColor, FxConfig config) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        config['attr'] = attr;
        config['endColor'] = endColor;
        el.highlight(color, configJS);
        return this;
    }-*/;

    public native Fx pause(int seconds) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.pause(seconds);
        return this;
    }-*/;

    public native Fx puff() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.puff();
        return this;
    }-*/;

    public native Fx puff(FxConfig config) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        el.puff(configJS);
        return this;
    }-*/;

    public native Fx scale(int width, int height) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.scale(width <=0 ? null : width, height <= 0 ? null : height);
        return this;
    }-*/;

    public native Fx scale(int width, int height, FxConfig config) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        el.scale(width <=0 ? null : width, height <= 0 ? null : height, configJS);
        return this;
    }-*/;

    public native Fx sequenceFx() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.sequenceFx();
        return this;
    }-*/;

    public native Fx shift(int x, int y, int width, int height, FxConfig config) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        if(x > 0) configJS['x'] = x;
        if(y > 0) configJS['y'] = y;
        if(width > 0) configJS['width'] = width;
        if(height > 0) configJS['height'] = height;
        el.shift(configJS);
        return this;
    }-*/;

    public native Fx slideIn() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.slideIn();
        return this;
    }-*/;

    public native Fx slideIn(String anchor, FxConfig config) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        el.slideIn(anchor, configJS);
        return this;
    }-*/;

    public native Fx slideOut() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.slideOut();
        return this;
    }-*/;

    public native Fx slideOut(String anchor, FxConfig config) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        el.slideOut(anchor, configJS);
        return this;
    }-*/;

    public native Fx stopFx() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.stopFx();
        return this;
    }-*/;

    public native Fx switchOff() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.switchOff();
        return this;
    }-*/;

    public native Fx switchOff(FxConfig config) /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        var configJS = config.@com.gwtext.client.core.JsObject::jsObj;
        el.switchOff(configJS);
        return this;
    }-*/;

    public native Fx syncFx() /*-{
        var el = this.@com.gwtext.client.core.JsObject::jsObj;
        el.syncFx();
        return this;
    }-*/;
}
