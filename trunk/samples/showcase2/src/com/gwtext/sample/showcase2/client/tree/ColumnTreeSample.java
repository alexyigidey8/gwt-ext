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
package com.gwtext.sample.showcase2.client.tree;

import com.gwtext.client.core.Connection;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.NameValuePair;
import com.gwtext.client.core.SortDir;
import com.gwtext.client.data.Node;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.tree.AsyncTreeNode;
import com.gwtext.client.widgets.tree.ColumnNodeUI;
import com.gwtext.client.widgets.tree.ColumnTree;
import com.gwtext.client.widgets.tree.ColumnTreeEditor;
import com.gwtext.client.widgets.tree.TreeLoader;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreeSorter;
import com.gwtext.client.widgets.tree.TreeSorterConfig;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

/**
 * Example that illustrates ColumnTree to handle a tree with columns like
 * a tree grid however it is not a grid per se.
 * @author mlim1972
 */
public class ColumnTreeSample extends ShowcasePanel {

	int counter = 0;
	static Object hours[][] = null;
	static boolean sortedAsc = true;
	
    public String getSourceUrl() {
        return "source/tree/ColumnTreeSample.java.html";
    }
    
    public String getJsonDataUrl(){
    	return "source/tree/ColumnTreeSample.json.html";
    }
    
    public String getCssUrl(){
    	return "source/tree/ColumnTreeSample.css.html";
    }
    
    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();

            final ColumnTree coltree = new ColumnTree();
            coltree.setWidth(552);
            coltree.setHeight(400);
            coltree.setAutoHeight(true);
            coltree.setRootVisible(false);
            coltree.setAutoScroll(true);
            coltree.setTitle("my Sample");
            
            ColumnTree.Column cols[] = new ColumnTree.Column[3];
            cols[0] = coltree.new Column("Task", 350, "task");
            cols[1] = coltree.new Column("Duration", 100, "duration");
            cols[2] = coltree.new Column("Assigned To", 100, "user");
            
            coltree.setColumns(cols);
            
            TreeLoader loader = new TreeLoader();
            loader.setPreloadChildren(true);
            loader.setDataUrl("data/column-data.json");
            loader.setMethod(Connection.GET);
            loader.setUiProviders(ColumnNodeUI.getUiProvider());
            
            
            AsyncTreeNode root = new AsyncTreeNode("Tasks", loader);
            coltree.setRootNode(root);
            
            final Store store = new SimpleStore(new String[]{"abbr", "duration"}, getDuration());
            store.load();

            ComboBox cb = new ComboBox();
            cb.setMinChars(1);
            cb.setFieldLabel("Duration");
            cb.setStore(store);
            cb.setDisplayField("duration");
            cb.setMode(ComboBox.LOCAL);
            cb.setTriggerAction(ComboBox.ALL);
            cb.setEmptyText("Select Duration");
            cb.setTypeAhead(true);
            cb.setSelectOnFocus(true);
            cb.setWidth(110);
            cb.setResizable(true);
            cb.setTitle("Duration");
            cb.setAllowBlank(false);
            ColumnTreeEditor treeEditorDuration = new ColumnTreeEditor(coltree, "duration", cb);
            ColumnTreeEditor treeEditorTask = new ColumnTreeEditor(coltree, "task", new TextField());
            ColumnTreeEditor treeEditorUser = new ColumnTreeEditor(coltree, "user", new TextField());

            cb.getStore().getById(cb.getValue());

            panel.add(coltree);
            
            Button addNode = new Button("Add Node");
            addNode.addListener(new ButtonListenerAdapter(){
            	public void onClick(Button button, EventObject e) {
            		Node selNode = coltree.getSelectedNode();
            		if(selNode != null){
            			NameValuePair nodeData[] = new NameValuePair[3];
            			nodeData[0] = new NameValuePair("task", "New Task " + counter);
            			nodeData[1] = new NameValuePair("duration", counter + " Day");
            			nodeData[2] = new NameValuePair("user", "TBD " + counter);
            			counter++;
            			TreeNode tnode = ColumnNodeUI.getNewTreeNode(nodeData);
            			tnode.setIconCls("task");
            			tnode.setLeaf(true);

                        if (selNode.isLeaf()) {
                        	selNode.getParentNode().insertBefore(tnode, selNode.getNextSibling());
                        } else {
                        	selNode.insertBefore(tnode, selNode.getFirstChild());
                        }
            		}
            	}
            });
            panel.add(addNode);

            
            Button sort = new Button("Toggle Sort");
            sort.addListener(new ButtonListenerAdapter(){
            	public void onClick(Button button, EventObject e) {
        			TreeSorter sorter = new TreeSorter(coltree, new TreeSorterConfig(){
        				{
        					if(sortedAsc)
        						setDir(SortDir.DESC);
        					else
        						setDir(SortDir.ASC);
        					setProperty("task");
        				}
        			});
        			sorter.sort(coltree.getRootNode());
        			sortedAsc = !sortedAsc;
            	}
            });
            panel.add(sort);
        }

        return panel;
    }
    
    public static Object[][] getDuration() {
        if (hours == null) {
        	hours = new Object[][]{
                    new Object[]{"1h", "1 Hour"},
                    new Object[]{"2h", "2 Hour"},
                    new Object[]{"3h", "3 Hour"},
                    new Object[]{"4h", "4 Hour"},
                    new Object[]{"5h", "5 Hour"},
                    new Object[]{"6h", "6 Hour"},
                    new Object[]{"7h", "7 Hour"}
            };
        }
        return hours;
    }
    
    public String getIntro() {
        return "<p>This is an example illustrating the ColumnTree widget</p>";
    }
}