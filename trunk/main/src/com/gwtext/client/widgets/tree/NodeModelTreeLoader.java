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

package com.gwtext.client.widgets.tree;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtext.client.core.NameValuePair;
import com.gwtext.client.data.Node;
import com.gwtext.client.data.NodeModel;
import com.gwtext.client.data.NodeModelListener;
import com.gwtext.client.data.Tree;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.tree.event.TreeNodeListenerAdapter;

/**
 * This class is a TreeLoader based on a Model that can load
 * the tree via RPC instead of JSon Data.
 * @author mlim1972
 * @see com.gwtext.client.widgets.tree.TreePanel
 * @see com.gwtext.client.widgets.tree.TreeLoader
 */
public class NodeModelTreeLoader extends TreeLoader {

	private static NodeModelServiceAsync asyncCallback = null;
	private static String[] columnDataName = null;
	
    static {
        init();
    }

    /**
     * Construct a new XMLTreeLoader.
     */
    public NodeModelTreeLoader() {
    	setUiProviders(ColumnNodeUI.getUiProvider());
    }
    
    /**
     * Construct a new XMLTreeLoader.
     */
    public NodeModelTreeLoader(String columnDataName[]) {
    	setColumnDataName(columnDataName);
    	setUiProviders(ColumnNodeUI.getUiProvider());
    }
    
    /**
     * Construct a new NodeModelLoader.
     *
     * @param 
     *
     */
    public NodeModelTreeLoader(NodeModelServiceAsync callback) {
        setCallback(callback);
        setUiProviders(ColumnNodeUI.getUiProvider());
    }

    /**
     * Set the callback whenever RPC communication is required.
     * Otherwise, the system assumes that the model will
     * handle it programmatically
     * @param callback
     */
    public void setCallback(NodeModelServiceAsync callback) {
    	asyncCallback = callback;		
	}
    
    /**
     * This sets the Column names to be used.  It is necessary
     * whenever a ColumnTree is used.
     * @param coldata
     */
    public void setColumnDataName(String[] coldata){
    	columnDataName = coldata;
    }

	protected native JavaScriptObject create(JavaScriptObject configJS)/*-{
        return new $wnd.Ext.tree.NodeModelTreeLoader(configJS, this);
    }-*/;

    private static native void init() /*-{
       $wnd.Ext.tree.NodeModelTreeLoader = function(configJS, selfJ) {
         $wnd.Ext.tree.NodeModelTreeLoader.superclass.constructor.call(this, configJS);
          this.selfJ = selfJ;
       };

       $wnd.Ext.extend($wnd.Ext.tree.NodeModelTreeLoader, $wnd.Ext.tree.TreeLoader, {

               load : function(node, callback){
                       if(this.clearOnLoad){
                           while(node.firstChild){
                               node.removeChild(node.firstChild);
                           }
                       }
                       if(this.doPreload(node)){ 
                           if(typeof callback == "function"){
                               callback();
                           }
                       }else{
                           this.requestData(node, callback);
                       }
                   },

              requestData : function(node, callback){
                   if(this.fireEvent("beforeload", this, node, callback) !== false){
                       var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(node);
                       var params = this.getParams(node);
                       @com.gwtext.client.widgets.tree.NodeModelTreeLoader::requestData(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/NodeModelTreeLoader;Ljava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;)(this, nodeJ, this.selfJ, this.requestMethod, this.dataUrl||this.url, this.handleResponse, this.handleFailure, callback, params);

                   }else{
                       // if the load is cancelled, make sure we notify
                       // the node that we are done
                       if(typeof callback == "function"){
                           callback();
                       }
                   }
               },

               handleResponse : function(response){
                   this.transId = false;
                   //var a = response.argument;
                   var callback  = response.callback;
                   var node = response.node;
                   var responseData = response.responseData;
                   if(typeof callback == "function"){
                       callback(this, node);
                   }
                   this.fireEvent("load", this, node, responseData);
               },

               handleFailure : function(response){
                   this.transId = false;
                   var callback  = response.callback;
                   var node = response.node;
                   var responseData = response.responseData;
                   this.fireEvent("loadexception", this, node, responseData);
                   if(typeof callback == "function"){
                       callback(this, node);
                   }
               },
               
               createNode : function(attr){
               	   if(attr instanceof $wnd.Ext.tree.TreeNode){
               	       var nodeJ = @com.gwtext.client.widgets.tree.TreeNode::treeNodeInstance(Lcom/google/gwt/core/client/JavaScriptObject;)(attr);
               	       return @com.gwtext.client.widgets.tree.NodeModelTreeLoader::createNode(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/gwtext/client/widgets/tree/TreeNode;Lcom/gwtext/client/widgets/tree/NodeModelTreeLoader;)(this, nodeJ, this.selfJ);
               	   }else{
               	       $wnd.alert("in NodeModelTreeLoader and createNode attr is not a TreeNode");
               	   }
               	   
			   }
       });
    }-*/;


    private static void requestData(final JavaScriptObject treeLoaderJS, final TreeNode root, 
    		                        final NodeModelTreeLoader treeLoader, String method, 
    		                        String url, final JavaScriptObject success, 
    		                        final JavaScriptObject failure, 
    		                        final JavaScriptObject callback, String params) {

    	if(asyncCallback == null) return;
    	
    	NodeModel nodeModelRoot = root.getNodeModel();
    	if(nodeModelRoot == null) nodeModelRoot = new NodeModel(root);
    	
        try {
        	asyncCallback.getTreeNodeModel(nodeModelRoot, new AsyncCallback(){

				public void onFailure(Throwable caught) {
					call(failure, treeLoaderJS, root.getJsObj(), callback, caught.getMessage());
                    return;
				}

				public void onSuccess(Object result) {
					loadNode(treeLoader, root, result);
					if(result == null){
						result = "";
					}
					call(success, treeLoaderJS, root.getJsObj(), callback, result.toString());
				}
        	});
        	
        } catch (Exception e) {
            call(failure, treeLoaderJS, root.getJsObj(), callback, e.getMessage());
        }
    }

    private static native void call(JavaScriptObject func, JavaScriptObject treeLoader, JavaScriptObject node, JavaScriptObject callback, String responseData)/*-{
        var arguments =  {callback: callback, node: node, responseData : responseData};
        func.call(treeLoader, arguments);
    }-*/;
    
    private static native void beginUpdate(TreeNode currentNode)/*-{
    	var node = currentNode.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
    	node.beginUpdate();
    }-*/;

    private static native void endUpdate(TreeNode currentNode)/*-{
		var node = currentNode.@com.gwtext.client.widgets.Component::getOrCreateJsObj()();
		node.endUpdate();
	}-*/;
    
	private static void loadNode(NodeModelTreeLoader treeLoader, TreeNode currentNode, Object serverResult) {
		if(serverResult == null) return;
		List result = (List)serverResult;
		String coldata[] = treeLoader.columnDataName;
		
//		beginUpdate(currentNode);
		for (Iterator iterator = result.iterator(); iterator.hasNext();) {
			NodeModel curModel = (NodeModel) iterator.next();
			curModel.setColumnDataName(coldata);
			currentNode.appendChild(createNode(treeLoader, coldata, curModel, true));
			/* no need to add the model child to the model parent since the 
			 * treepanel listener for the model will do just that...
			 */
			//if(currentNode.getNodeModel() != null)
			//	currentNode.getNodeModel().addChild(curModel);
		}
//		endUpdate(currentNode);
	}
	
	private static JavaScriptObject createNode(final JavaScriptObject treeLoaderJS, final TreeNode root, 
            final NodeModelTreeLoader treeLoader){
		String coldata[] = treeLoader.columnDataName;
		NodeModel nodeModel = new NodeModel(root);

		return createNode(treeLoader, coldata, nodeModel, true).getJsObj();
		
	}
	
	private static TreeNode createNode(NodeModelTreeLoader treeLoader, String[] coldata,NodeModel nodeModel, boolean asyncNode){
		TreeNode tnode = null;
		
		if(coldata != null){
			NameValuePair nodeData[] = new NameValuePair[coldata.length];

			for (int i = 0; i < coldata.length; i++) {
				String value = nodeModel.getProperty(coldata[i]);
				if(value != null)
					nodeData[i] = new NameValuePair(coldata[i], value);
				else
					nodeData[i] = new NameValuePair(coldata[i], "");
			}

			if(asyncNode){
				AsyncTreeNode asyncTreeNode = ColumnNodeUI.getNewAsyncTreeNode(nodeData);
				asyncTreeNode.setLoader(treeLoader);
				tnode = asyncTreeNode;
			}else{
				tnode = ColumnNodeUI.getNewTreeNode(nodeData);
			}
		}else{
			if(asyncNode){
				tnode = new AsyncTreeNode(treeLoader);
			}else{
				tnode = new TreeNode();
			}
		}

		tnode.setNodeModel(nodeModel);
		
		//nodeModel.addListener((new NodeModelTreeLoader()).new NodeModelListenerImpl(tnode));
		nodeModel.setTreeNode(tnode);
		
		// No need to load the children recursively since
		// the extjs will call for every expanded node for the
		// direct children only.
//		if(nodeModel.getChildren().size() > 0){
//			for (int i = 0; i < nodeModel.getChildren().size(); i++) {
//				tnode.appendChild(getNode(coldata,nodeModel.getChild(i), asyncNode));
//			}
//			
//		}
		
		return tnode;
	}
//
//	private class NodeModelListenerImpl implements NodeModelListener{
//		private TreeNode treeNode = null;
//		
//		public NodeModelListenerImpl(TreeNode treeNode){
//			this.treeNode = treeNode;
//		}
//		public void onAppend(NodeModel self, NodeModel node) {
//			treeNode.appendChild(NodeModel.createTreeNode(node));
//			
//		}
//		public void onInsert(NodeModel self, NodeModel node, int index) {
//			Node child[] = treeNode.getChildNodes();
//			treeNode.insertBefore(NodeModel.createTreeNode(node), child[index]);
//			// TODO Auto-generated method stub
//			
//		}
//		public void onMove(NodeModel self, NodeModel oldParent,
//				NodeModel newParent, int index) {
//			// TODO Auto-generated method stub
//			
//		}
//		public void onRemove(NodeModel self, NodeModel node) {
//			Node child[] = treeNode.getChildNodes();
//			for (int i = 0; i < child.length; i++) {
//				if(((String)node.getProperty("id")).equals(child[i].getId()) ){
//					treeNode.removeChild(child[i]);
//					break;
//				}
//			}
//		}
//		public void onUpdate(NodeModel self, String attributeName, Object value) {
//			treeNode.setTreeNodeModelAttribute(attributeName, value);
//		}
//	}
}
