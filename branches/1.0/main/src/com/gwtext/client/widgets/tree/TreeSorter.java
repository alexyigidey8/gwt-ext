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
import com.gwtext.client.core.JsObject;

/**
 * Helper class to enable tree node sorting functionality.
 */
public class TreeSorter extends JsObject {

    /**
     * Construct a new TreeSorter.
     *
     * @param treePanel the tree panel to sort
     * @param config the TreeSorter config
     */
    public TreeSorter(TreePanel treePanel, TreeSorterConfig config) {
       jsObj = create(treePanel.getJsObj(), config == null ? null : config.getJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject treePanel, JavaScriptObject config) /*-{
        return new $wnd.Ext.tree.TreeSorter(treePanel, config);
    }-*/;

    //http://extjs.com/forum/showthread.php?t=6795
    /**
     * Sort the TreePanel starting from the specified node.
     *
     * @param startNode the start node
     */
    public native void sort(TreeNode startNode) /*-{
        var sorter = this.@com.gwtext.client.core.JsObject::jsObj;
        var startNodeJ = startNode.@com.gwtext.client.core.JsObject::jsObj;
        sorter.doSort(startNodeJ);
    }-*/;
}
