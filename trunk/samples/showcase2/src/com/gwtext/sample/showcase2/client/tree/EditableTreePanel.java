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

import com.google.gwt.user.client.Timer;
import com.gwtext.client.core.Connection;
import com.gwtext.client.core.Function;
import com.gwtext.client.core.Template;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Tool;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.tree.AsyncTreeNode;
import com.gwtext.client.widgets.tree.TreeEditor;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.XMLTreeLoader;
import com.gwtext.sample.showcase2.client.SampleData;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

public class EditableTreePanel extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/tree/EditableTreePanel.java.html";
    }

    public String getXmlDataUrl() {
        return "source/tree/EditableTreePanel.xml.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            final Store store = new SimpleStore(new String[]{"abbr", "country"}, SampleData.getCountries());
            store.load();
            
            final Template template = new Template("<div class=\"x-combo-list-item\"><img src=\"images/flags/{abbr}.gif\"> " +
                    "{country}<div class=\"x-clear\"></div></div>");

            ComboBox cb = new ComboBox();
            cb.setMinChars(1);
            cb.setFieldLabel("Countries");
            cb.setStore(store);
            cb.setDisplayField("country");
            cb.setMode(ComboBox.LOCAL);
            cb.setTriggerAction(ComboBox.ALL);
            cb.setEmptyText("Select Country");
            cb.setTypeAhead(true);
            cb.setSelectOnFocus(true);
            cb.setWidth(60);
            cb.setResizable(true);
            cb.setTpl(template);
            cb.setTitle("Countries");
            cb.setAllowBlank(false);

            final TreePanel treePanel = new TreePanel();
            treePanel.setWidth(240);
            treePanel.setHeight(400);
            treePanel.setTitle("Editable Tree");
            treePanel.setAnimate(true);
            treePanel.setEnableDD(true);
            treePanel.setContainerScroll(true);
            treePanel.setRootVisible(true);


            final XMLTreeLoader loader = new XMLTreeLoader();
            loader.setDataUrl("data/countries.xml");
            loader.setMethod(Connection.GET);
            loader.setRootTag("countries");
            loader.setFolderTitleMapping("@title");
            loader.setFolderTag("team");
            loader.setLeafTitleMapping("@title");
            loader.setLeafTag("country");
            loader.setQtipMapping("@qtip");
            loader.setDisabledMapping("@disabled");
            loader.setCheckedMapping("@checked");
            loader.setIconMapping("@icon");
            loader.setAttributeMappings(new String[]{"@rank"});

            final AsyncTreeNode root = new AsyncTreeNode("Countries", loader);
            treePanel.setRootNode(root);

            root.expand();
            treePanel.expandAll();

            treePanel.addTool(new Tool(Tool.REFRESH, new Function() {
                public void execute() {
                    treePanel.getEl().mask("Loading", "x-mask-loading");
                    root.reload();
                    root.collapse(true, false);
                    Timer timer = new Timer() {
                        public void run() {
                            treePanel.getEl().unmask();
                            root.expand(true, true);
                        }
                    };
                    timer.schedule(1000);
                }
            }, "Refresh"));

            TreeEditor treeEditor = new TreeEditor(treePanel, cb);

            panel = new Panel();
            panel.setBorder(false);
            panel.add(treePanel);
        }
        return panel;
    }

    public String getIntro() {
        return "<p>This example demonstrates an Editable Tree loaded from XML data. Double clicking on a node allows you to edit it. " +
				"In this example a ComboBox editor is specified as the Editor.</p>";
    }
}