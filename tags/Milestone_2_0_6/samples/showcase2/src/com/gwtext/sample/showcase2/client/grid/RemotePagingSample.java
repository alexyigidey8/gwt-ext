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
 
package com.gwtext.sample.showcase2.client.grid;

import com.gwtext.client.core.SortDir;
import com.gwtext.client.core.TextAlign;
import com.gwtext.client.data.*;
import com.gwtext.client.util.DateUtil;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.event.PanelListenerAdapter;
import com.gwtext.client.widgets.grid.*;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

import java.util.Date;

public class RemotePagingSample extends ShowcasePanel {

    private GridPanel grid;
    private boolean showPreview = true;

    private Renderer renderTopic = new Renderer() {
        public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
            return Format.format("<b><a href=\"http://extjs.com/forum/showthread.php?t={2}\" target=\"_blank\">{0}</a></b><a href=\"http://extjs.com/forum/forumdisplay.php?f={3}\" target=\"_blank\">{1} Forum</a>",
                    new String[]{(String) value,
                            record.getAsString("forumtitle"),
                            record.getId(),
                            record.getAsString("forumid"),
                    });
        }
    };

    private Renderer renderLast = new Renderer() {
        public String render(Object value, CellMetadata cellMetadata, Record record, int rowIndex, int colNum, Store store) {
            Date lastPost = record.getAsDate("lastpost");
            String lastPostStr = DateUtil.format(lastPost, "M j, Y, g:i a");
            return Format.format("{0}<br/>by {1}", new String[]{lastPostStr, record.getAsString("lastposter")});
        }
    };

   public String getSourceUrl() {
        return "source/grid/RemotePagingSample.java.html";
    }

    public Panel getViewPanel() {

        if (panel == null) {
            DataProxy dataProxy = new ScriptTagProxy("http://extjs.com/forum/topics-browse-remote.php");

            final RecordDef recordDef = new RecordDef(new FieldDef[]{
                    new StringFieldDef("title"),
                    new StringFieldDef("forumtitle"),
                    new StringFieldDef("forumid"),
                    new StringFieldDef("author"),
                    new IntegerFieldDef("replycount"),
                    new DateFieldDef("lastpost", "lastpost", "timestamp"),
                    new StringFieldDef("lastposter"),
                    new StringFieldDef("excerpt")
            });
            JsonReader reader = new JsonReader(recordDef);
            reader.setRoot("topics");
            reader.setTotalProperty("totalCount");
            reader.setId("threadid");

            final Store store = new Store(dataProxy, reader, true);
            store.setDefaultSort("lastpost", SortDir.DESC);

            ColumnConfig topicColumn = new ColumnConfig("Topic", "title", 420, false, renderTopic, "topic");
            topicColumn.setCss("white-space:normal;");

            ColumnConfig authorColumn = new ColumnConfig("Author", "author", 100);
            authorColumn.setHidden(true);

            ColumnConfig repliesColumn = new ColumnConfig("Replies", "replycount", 70);
            repliesColumn.setAlign(TextAlign.RIGHT);

            ColumnConfig lastPostColumn = new ColumnConfig("Last Post", "lastPost", 150, true, renderLast, "last");

            ColumnModel columnModel = new ColumnModel(new ColumnConfig[]{
                    topicColumn,
                    authorColumn,
                    repliesColumn,
                    lastPostColumn
            });
            columnModel.setDefaultSortable(true);

            grid = new GridPanel();
            grid.setWidth(700);
            grid.setHeight(500);
            grid.setTitle("Remote Paging Grid ");
            grid.setStore(store);
            grid.setColumnModel(columnModel);
            grid.setTrackMouseOver(false);
            grid.setLoadMask(true);
            grid.setSelectionModel(new RowSelectionModel());
            grid.setFrame(true);
            grid.setStripeRows(true);
            grid.setIconCls("grid-icon");

            GridView view = new GridView() {
                public String getRowClass(Record record, int index, RowParams rowParams, Store store) {
                    if (showPreview) {
                        rowParams.setBody(Format.format("<p>{0}</p>", record.getAsString("excerpt")));
                        return "x-grid3-row-expanded";
                    } else {
                        return "x-grid3-row-collapsed";
                    }
                }
            };
            view.setForceFit(true);
            view.setEnableRowBody(true);
            grid.setView(view);

            PagingToolbar pagingToolbar = new PagingToolbar(store);
            pagingToolbar.setPageSize(25);
            pagingToolbar.setDisplayInfo(true);
            pagingToolbar.setDisplayMsg("Displaying topics {0} - {1} of {2}");
            pagingToolbar.setEmptyMsg("No topics to display");

            pagingToolbar.addSeparator();
            ToolbarButton toolbarButton = new ToolbarButton("Show Preview");
            toolbarButton.setPressed(showPreview);
            toolbarButton.setEnableToggle(true);
            toolbarButton.setCls("x-btn-text-icon details");
            toolbarButton.addListener(new ButtonListenerAdapter() {
                public void onToggle(Button button, boolean pressed) {
                    toggleDetails(pressed);
                }
            });

            pagingToolbar.addButton(toolbarButton);
            grid.setBottomToolbar(pagingToolbar);

            grid.addListener(new PanelListenerAdapter() {
                public void onRender(Component component) {
                    store.load(0, 25);
                }
            });

            panel = new Panel();
            panel.add(grid);
        }
        return panel;
    }

    private void toggleDetails(boolean pressed) {
        showPreview = pressed;
        grid.getView().refresh();
    }

    public String getIntro() {
        return "<p>In this example, the Grid is based on a Store that is populated using a Json web service that retrieves data from the ExtJS forums." +
                "The Grid supports remote paging. It also has custom renderers to alter the display in normal and preview mode.</p>" +
                "<p>Also notice how the preview text for each record spans all the columns. This is easily configurable by a simple property.</p>";
    }
}