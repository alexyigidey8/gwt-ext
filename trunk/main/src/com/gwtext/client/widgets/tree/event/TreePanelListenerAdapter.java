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

package com.gwtext.client.widgets.tree.event;

import com.gwtext.client.core.EventObject;
import com.gwtext.client.dd.DD;
import com.gwtext.client.dd.DragData;
import com.gwtext.client.dd.DragDrop;
import com.gwtext.client.widgets.tree.DropNodeCallback;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;

public class TreePanelListenerAdapter implements TreePanelListener {

    public boolean doBeforeChildrenRendered(TreeNode node) {
        return true;
    }

    //TODO not working??
    public boolean doBeforeClick(TreeNode node, EventObject e) {
        return true;
    }

    public boolean doBeforeCollapse(TreeNode node, boolean deep, boolean anim) {
        return true;
    }

    public boolean doBeforeExpand(TreeNode node, boolean deep, boolean anim) {
        return true;
    }

    public boolean doBeforeLoad(TreeNode node) {
        return true;
    }

    /**
     * API changed to {@link #doBeforeNodeDrop(com.gwtext.client.widgets.tree.TreePanel, com.gwtext.client.widgets.tree.TreeNode, com.gwtext.client.dd.DragData, String, com.gwtext.client.dd.DragDrop, com.gwtext.client.widgets.tree.TreeNode, com.gwtext.client.widgets.tree.DropNodeCallback)}
     * @return
     */
    final public boolean doBeforeNodeDrop(TreePanel treePanel, TreeNode target, String point, DragDrop source, TreeNode dropNode, DropNodeCallback dropNodeCallback) {
        return true;
    }

    public boolean doBeforeNodeDrop(TreePanel treePanel, TreeNode target, DragData dragData, String point, DragDrop source, TreeNode dropNode, DropNodeCallback dropNodeCallback) {
        return true;
    }

    /**
     * @deprecated Use {@link #doBeforeNodeDrop(com.gwtext.client.widgets.tree.TreePanel, com.gwtext.client.widgets.tree.TreeNode, String, com.gwtext.client.dd.DragDrop, com.gwtext.client.widgets.tree.TreeNode, com.gwtext.client.widgets.tree.DropNodeCallback)} 
     */
    public final boolean doBeforeNodeDrop(TreePanel treePanel, TreeNode target, String point, DragDrop source, TreeNode dropNode) {
        return true;
    }

    public void onCheckChange(TreeNode node, boolean checked) {
    }

    public void onClick(TreeNode node, EventObject e) {
    }

    public void onCollapse(TreeNode node) {
    }

    public void onContextMenu(TreeNode node, EventObject e) {
    }

    public void onDblClick(TreeNode node, EventObject e) {
    }

    public void onDisabledChange(TreeNode node, boolean disabled) {
    }

    public void onDragDrop(TreePanel treePanel, TreeNode node, DD dd) {
    }

    public void onEndDrag(TreePanel treePanel, TreeNode node) {
    }

    public void onExpand(TreeNode node) {
    }

    public void onLoad(TreeNode node) {
    }

    /**
     * API changed to {@link #onNodeDragOver(com.gwtext.client.widgets.tree.TreePanel, com.gwtext.client.widgets.tree.TreeNode, com.gwtext.client.dd.DragData, String, com.gwtext.client.dd.DragDrop, com.gwtext.client.widgets.tree.TreeNode)}
     *
     * @deprecated API changed to {@link #onNodeDragOver(com.gwtext.client.widgets.tree.TreePanel, com.gwtext.client.widgets.tree.TreeNode, com.gwtext.client.dd.DragData, String, com.gwtext.client.dd.DragDrop, com.gwtext.client.widgets.tree.TreeNode)}
     * @return true
     */
    final public boolean onNodeDragOver(TreePanel treePanel, TreeNode target, String point, DragDrop source, TreeNode dropNode) {
        return true;
    }

    public boolean onNodeDragOver(TreePanel treePanel, TreeNode target, DragData dragData, String point, DragDrop source, TreeNode dropNode) {
        return true;
    }

    public void onNodeDrop(TreePanel treePanel, TreeNode target, String point, DragDrop source, TreeNode dropNode) {
    }

    public void onMove(TreePanel treePanel, TreeNode node, TreeNode oldParent, TreeNode newParent, int index) {
    }

    public void onStartDrag(TreePanel treePanel, TreeNode node) {
    }

    public void onTextChange(TreeNode node, String text, String oldText) {
    }
}
