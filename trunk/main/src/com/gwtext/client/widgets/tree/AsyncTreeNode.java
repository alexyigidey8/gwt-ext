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

package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.widgets.tree.event.AsyncTreeNodeListener;

public class AsyncTreeNode extends TreeNode {

    public AsyncTreeNode(AsyncTreeNodeConfig config) {
        super(config);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.tree.AsyncTreeNode(config);
    }-*/;

    public native boolean isLoaded() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.isLoaded();
    }-*/;

    public native boolean isLoading() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        return node.isLoading();
    }-*/;

    public native TreeLoader getLoader()/*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        var loader = node.loader;
        return @com.gwtext.client.widgets.tree.TreeLoader::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(loader);
    }-*/;

    //todo add callback
    public native void reload() /*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        node.reload();
    }-*/;

    public native void addAsyncTreeNodeListener(AsyncTreeNodeListener listener)/*-{
        var node = this.@com.gwtext.client.core.JsObject::jsObj;
        var nodeJ = this;

         node.addListener('beforeload',
                 function(source) {
                    return listener.@com.gwtext.client.widgets.tree.event.AsyncTreeNodeListener::doBeforeLoad(Lcom/gwtext/client/widgets/tree/AsyncTreeNode;)(nodeJ);
			    }
          );

         node.addListener('load',
                 function(source) {
                    listener.@com.gwtext.client.widgets.tree.event.AsyncTreeNodeListener::onLoad(Lcom/gwtext/client/widgets/tree/AsyncTreeNode;)(nodeJ);
			    }
          );
    }-*/;
}
