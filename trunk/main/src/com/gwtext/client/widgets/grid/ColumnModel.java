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

package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.grid.event.ColumnModelListener;

/**
 * The column model class for a {@link Grid}.
 */
public class ColumnModel extends JsObject {

    /**
     * Construct a new ColumnModel using a native object.
     *
     * @param jsObj the native object
     */
    public ColumnModel(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Construct a new ColumnModel.
     *
     * @param columns the configuration for the columns
     */
    public ColumnModel(ColumnConfig[] columns) {
        JavaScriptObject[] config = new JavaScriptObject[columns.length];
        for (int i = 0; i < columns.length; i++) {
            ColumnConfig column = columns[i];
            config[i] = column.getJsObj();
        }
        JavaScriptObject configJS = JavaScriptObjectHelper.convertToJavaScriptArray(config);
        jsObj = create(configJS);
    }

    public native JavaScriptObject create(JavaScriptObject configJS) /*-{
        return new $wnd.Ext.grid.ColumnModel(configJS);
    }-*/;


    /**
     * Default sortable of columns which have no sortable specified (defaults to false).
     * 
     * @param defaultSortable true to enable sortable for all columns
     */
    public native void setDefaultSortable(boolean defaultSortable)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.defaultSortable = defaultSortable;
    }-*/;

    /**
     * The width of columns which have no width specified (defaults to 100)
     * 
     * @param defaultWidth the default column width
     */
    public native void setDefaultWidth(int defaultWidth)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.defaultWidth = defaultWidth;
    }-*/;

    //TODO
    //http://extjs.com/forum/showthread.php?t=6025&highlight=getCellEditor
    //need to support way to allow user to plug in logic based cell editors
    //public GridEditor getCellEditor(int colIndex, int rowIndex)

    /**
     * Returns the number of columns.
     *
     * @return the number of columns
     */
    public native int getColumnCount()/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getColumnCount();
    }-*/;

    /**
     * Returns the column header.
     * @param colID column ID
     * @return header
     */
    public String getColumnHeader(String colID) {
        int colIndex = getIndexById(colID);
        return colIndex == -1 ? null : getColumnHeader(colIndex);
    }

    /**
     * Returns the header for the specified column.
     *
     * @param colIndex the column index
     * @return the column header
     */
    public native String getColumnHeader(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getColumnHeader(colIndex);
    }-*/;

    /**
     * Returns the column ID.
     * @param colIndex column index
     * @return the column id set by the user using {@link com.gwtext.client.widgets.grid.ColumnConfig#setId(String)}. If the
     *         user did not set the id for the column, then the column position is returned as a String.
     */
    public native String getColumnId(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getColumnId(colIndex).toString();
    }-*/;

    /**
     * Returns the tooltip for the specified column.
     *
     * @param colID the column ID
     * @return the column tooltip
     */
    public String getColumnTooltip(String colID) {
        int colIndex = getIndexById(colID);
        return colIndex == -1 ? null : getColumnTooltip(colIndex);
    }

    /**
     * Returns the tooltip for the specified column.
     *
     * @param colIndex the column index
     * @return the column tooltip
     */
    public native String getColumnTooltip(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getColumnTooltip(colIndex);
    }-*/;

    /**
     * Returns the width for the specified column.
     *
     * @param colID the column ID
     * @return the column width
     */
    public int getColumnWidth(String colID) {
        int colIndex = getIndexById(colID);
        return colIndex == -1 ? -1 : getColumnWidth(colIndex);
    }

    /**
     * Returns the width for the specified column.
     *
     * @param colIndex the column index
     * @return the column width
     */
    public native int getColumnWidth(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getColumnWidth(colIndex);
    }-*/;

    //TODO
    //getColumnsBy(Function fn, [Object scope]) : Array

    /**
     * Returns the dataIndex for the specified column.
     * 
     * @param colID the column ID
     * @return the data index of the Store
     */
    public String getDataIndex(String colID) {
        int colIndex = getIndexById(colID);
        return colIndex == -1 ? null : getDataIndex(colIndex);
    }

    /**
     * Returns the dataIndex for the specified column.
     *
     * @param colIndex the column idex
     * @return the data index of the Store
     */
    public native String getDataIndex(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getDataIndex(colIndex).toString();
    }-*/;

    /**
     * Returns the index for a specified column ID.
     *
     * @param id column id used in ColumnConfig when defining the ColumnModel
     * @return column index (0 based), -1 if not found
     * @see ColumnConfig#setId(String)
     */
    public native int getIndexById(String id) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getIndexById(id);
    }-*/;

    //TODO getRenderer is required??

    public native int getTotalWidth()/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getTotalWidth();
    }-*/;

    /**
     * Returns the total width of all columns.
     *
     * @param includeHidden true to include hidden column widths
     * @return total width
     */
    public native int getTotalWidth(boolean includeHidden)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.getTotalWidth(includeHidden);
    }-*/;

    /**
     * Returns true if the cell is editable.
     *
     * @param colID the column ID
     * @param rowIndex the row index
     * @return true if editable
     */
    public boolean isCellEditable(String colID, int rowIndex) {
        int colIndex = getIndexById(colID);
        return colIndex != -1 && isCellEditable(colIndex, rowIndex);
    }

    //TODO support pluggable strategy for logic of editable cells

    /**
     * Returns true if the cell is editable.
     *
     * @param colIndex the column index
     * @param rowIndex the row index
     * @return true if editable
     */
    public native boolean isCellEditable(int colIndex, int rowIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.isCellEditable(colIndex, rowIndex);
    }-*/;

    /**
     * Returns true if the column width cannot be changed.
     *
     * @param colID the column ID
     * @return true if fixed
     */
    public boolean isFixed(String colID) {
        int colIndex = getIndexById(colID);
        return colIndex != -1 && isFixed(colIndex);
    }

    /**
     * Returns true if the column width cannot be changed
     *
     * @param colIndex the column index
     * @return true if fixed
     */
    public native boolean isFixed(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.isFixed(colIndex);
    }-*/;

    /**
     * Returns true if the column is hidden.
     *
     * @param colID the column ID
     * @return true if hidden
     */
    public boolean isHidden(String colID) {
        int colIndex = getIndexById(colID);
        return colIndex != -1 && isHidden(colIndex);
    }

    /**
     * Returns true if the column is hidden.
     *
     * @param colIndex the column index
     * @return true if hidden
     */
    public native boolean isHidden(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.isHidden(colIndex);
    }-*/;


    /**
     *  Returns true if the column is locked.
     *
     * @param colID the column ID
     * @return true if locked
     */
    public boolean isLocked(String colID) {
        int colIndex = getIndexById(colID);
        return colIndex != -1 && isLocked(colIndex);
    }

    /**
     * Returns if the column is locked.
     * @param colIndex column index (0 based)
     * @return locked
     */
    public native boolean isLocked(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;

        var locked = null;
        try {
            locked = cm.isLocked(colIndex);
        } catch(e) {
            locked = false;
        }
        return locked === undefined || locked == null? false : locked;
    }-*/;

    /**
     * Returns true if the column is resizable.
     *
     * @param colID the column ID
     * @return true if resizable
     */
    public boolean isResizable(String colID) {
        int colIndex = getIndexById(colID);
        return colIndex != -1 && isResizable(colIndex);
    }

    /**
     * Returns true if the column is resizable.
     *
     * @param colIndex the column index
     * @return true if resizable
     */
    public native boolean isResizable(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.isResizable(colIndex);
    }-*/;

    /**
     * Returns true if the column is sortable.
     *
     * @param colID the column ID
     * @return true of sortable
     */
    public boolean isSortable(String colID) {
        int colIndex = getIndexById(colID);
        return colIndex != -1 && isSortable(colIndex);
    }

    /**
     * Returns true if the column is sortable.
     *
     * @param colIndex the column index
     * @return true if sortable
     */
    public native boolean isSortable(int colIndex)/*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        return cm.isSortable(colIndex);
    }-*/;

    /**
     * Sets the header for a column.
     *
     * @param colID the column ID
     * @param header the column header
     */
    public void setColumnHeader(String colID, String header) {
        int colIndex = getIndexById(colID);
        if (colIndex != -1) {
            setColumnHeader(colIndex, header);
        }
    }

    /**
     * Sets the header for a column.
     *
     * @param colIndex the column index
     * @param header the column header
     */
    public native void setColumnHeader(int colIndex, String header) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.setColumnHeader(colIndex, header);
    }-*/;

    /**
     * Sets the width for a column.
     *
     * @param colID the column ID
     * @param width the column width
     */
    public void setColumnWidth(String colID, int width) {
        int colIndex = getIndexById(colID);
        if (colIndex != -1) {
            setColumnWidth(colIndex, width);
        }
    }

    /**
     * Sets the width for a column.
     *
     * @param colIndex the column index
     * @param width the column width
     */
    public native void setColumnWidth(int colIndex, int width) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.setColumnWidth(colIndex, width);
    }-*/;

    /**
     * Sets the dataIndex for a column.
     *
     * @param colID the column ID
     * @param dataIndex the Store's data index
     */
    public void setDataIndex(String colID, int dataIndex) {
        int colIndex = getIndexById(colID);
        if (colIndex != -1) {
            setDataIndex(colIndex, dataIndex);
        }
    }

    /**
     * Sets the dataIndex for a column.
     *
     * @param colIndex the column index
     * @param dataIndex the data index
     */
    public native void setDataIndex(int colIndex, int dataIndex) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.setDataIndex(colIndex, dataIndex);
    }-*/;

    /**
     * Sets the dataIndex for a column.
     *
     * @param colID the column ID
     * @param dataIndex the Store's data index
     */
    public void setDataIndex(String colID, String dataIndex) {
        int colIndex = getIndexById(colID);
        if (colIndex != -1) {
            setDataIndex(colIndex, dataIndex);
        }
    }

    /**
     * Sets the dataIndex for a column.
     *
     * @param colIndex the column index
     * @param dataIndex the data index
     */
    public native void setDataIndex(int colIndex, String dataIndex) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.setDataIndex(colIndex, dataIndex);
    }-*/;

    /**
     * Sets if a column is editable.
     * 
     * @param colID the column ID
     * @param editable true if editable
     */
    public void setEditable(String colID, boolean editable) {
        int colIndex = getIndexById(colID);
        if (colIndex != -1) {
            setEditable(colIndex, editable);
        }
    }

    /**
     * Sets if a column is editable.
     *
     * @param colIndex the column index
     * @param editable true if editable
     */
    public native void setEditable(int colIndex, boolean editable) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.setEditable(colIndex, editable);
    }-*/;

    /**
     * Sets the editor for a column.
     *
     * @param colID the column ID
     * @param editor the editor
     */
    public void setEditor(String colID, GridEditor editor) {
        int colIndex = getIndexById(colID);
        if (colIndex != -1) {
            setEditor(colIndex, editor);
        }
    }

    /**
     * Sets the editor for a column.
     *
     * @param colIndex the column index
     * @param editor the editor
     */
    public native void setEditor(int colIndex, GridEditor editor) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.setEditor(colIndex, editor.@com.gwtext.client.core.JsObject::jsObj);
    }-*/;

    /**
     * Sets if a column is hidden.
     * 
     * @param colID the column ID
     * @param hidden true if hidden
     */
    public void setHidden(String colID, boolean hidden) {
        int colIndex = getIndexById(colID);
        if (colIndex != -1) {
            setHidden(colIndex, hidden);
        }
    }

    /**
     * Sets if a column is hidden.
     *
     * @param colIndex the column index
     * @param hidden true if hidden
     */
    public native void setHidden(int colIndex, boolean hidden) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.setHidden(colIndex, hidden);
    }-*/;

    private static CellMetadata createCellMetadata(final JavaScriptObject jsObj) {
        return new CellMetadata() {
            public void setCssClass(String cssClass) {
                JavaScriptObjectHelper.setAttribute(jsObj, "css", cssClass);
            }

            public void setHtmlAttribute(String htmlAttribute) {
                JavaScriptObjectHelper.setAttribute(jsObj, "attr", htmlAttribute);
            }
        };
    }

    /**
     * Sets the rendering (formatting) function for a column.
     * 
     * @param colID the column ID
     * @param renderer the column renderer
     */
    public void setRenderer(String colID, Renderer renderer) {
        int colIndex = getIndexById(colID);
        if (colIndex != -1) {
            setRenderer(colIndex, renderer);
        }
    }

    /**
     * Sets the rendering (formatting) function for a column.
     *
     * @param colIndex the column idex
     * @param renderer the column renderer
     */
    public native void setRenderer(int colIndex, Renderer renderer) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        cm.setRenderer(colIndex, function(val, cell, r, rowIndex, colNum, store) {
            var valJ = (val  == null || val === undefined ) ? null : $wnd.GwtExt.convertToJavaType(val);
            var recJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(r);
            var cellJ = @com.gwtext.client.widgets.grid.ColumnModel::createCellMetadata(Lcom/google/gwt/core/client/JavaScriptObject;)(cell);
            var storeJ = @com.gwtext.client.data.Store::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(store);
            return renderer.@com.gwtext.client.widgets.grid.Renderer::render(Ljava/lang/Object;Lcom/gwtext/client/widgets/grid/CellMetadata;Lcom/gwtext/client/data/Record;IILcom/gwtext/client/data/Store;)(valJ, cellJ, recJ, rowIndex, colNum, storeJ);                        
        });
    }-*/;

    /**
     * Add a ColumnModel listener.
     *
     * @param listener the listener
     */
    public native void addColumnModelListener(ColumnModelListener listener) /*-{
        var cm = this.@com.gwtext.client.core.JsObject::jsObj;
        var cmJ = this;

        cm.addListener('columnlockchange',
                function(source, colIndex, locked) {
                    listener.@com.gwtext.client.widgets.grid.event.ColumnModelListener::onColumnLockChange(Lcom/gwtext/client/widgets/grid/ColumnModel;IZ)(cmJ, colIndex, locked);
                }
        );

        cm.addListener('columnmoved',
                function(source, oldIndex, newIndex) {
                    listener.@com.gwtext.client.widgets.grid.event.ColumnModelListener::onColumnMoved(Lcom/gwtext/client/widgets/grid/ColumnModel;II)(cmJ, oldIndex, newIndex);
                }
        );

        cm.addListener('headerchange',
                function(source, colIndex, newText) {
                    listener.@com.gwtext.client.widgets.grid.event.ColumnModelListener::onHeaderChange(Lcom/gwtext/client/widgets/grid/ColumnModel;ILjava/lang/String;)(cmJ, colIndex, newText);
                }
        );

        cm.addListener('hiddenchange',
                function(source, colIndex, hidden) {
                    listener.@com.gwtext.client.widgets.grid.event.ColumnModelListener::onHiddenChange(Lcom/gwtext/client/widgets/grid/ColumnModel;IZ)(cmJ, colIndex, hidden);
                }
        );

        cm.addListener('widthchange',
                function(source, colIndex, newWidth) {
                    listener.@com.gwtext.client.widgets.grid.event.ColumnModelListener::onWidthChange(Lcom/gwtext/client/widgets/grid/ColumnModel;II)(cmJ, colIndex, newWidth);
                }
        );
    }-*/;
}
