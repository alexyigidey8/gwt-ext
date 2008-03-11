/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * A Grid's View class.
 */
public class GridView extends JsObject {

    protected JavaScriptObject configJS = JavaScriptObjectHelper.createObject();

    public GridView(JavaScriptObject jsObj) {
        super(jsObj);
        configJS = jsObj;
    }

    /**
     * Constructs a new GridView.
     *
     */
    public GridView() {
    }

    public JavaScriptObject getJsObj() {
        if(!isCreated()) {
            jsObj = create(configJS);
        }
        return jsObj;
    }

    protected native JavaScriptObject create(JavaScriptObject config) /*-{
        var gridJ = this;
        var gridV = new $wnd.Ext.grid.GridView(config);
        gridV.getRowClass = function(record, index, rp, store) {
            var recordJ = @com.gwtext.client.data.Record::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
			var rpJ = @com.gwtext.client.widgets.grid.RowParams::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(rp);
			var storeJ = @com.gwtext.client.data.Store::instance(Lcom/google/gwt/core/client/JavaScriptObject;)(store);			
			return gridJ.@com.gwtext.client.widgets.grid.GridView::getRowClass(Lcom/gwtext/client/data/Record;ILcom/gwtext/client/widgets/grid/RowParams;Lcom/gwtext/client/data/Store;)(recordJ, index, rpJ, storeJ);
        }
        return gridV;
    }-*/;

    /**
     * Refreshes the grid.
     */
    public native void refresh() /*-{
        var view = this.@com.gwtext.client.core.JsObject::getJsObj()();
        view.refresh();
    }-*/;

    /**
     * Refreshes the grid.
     *
     * @param headersToo true to refresh the headers too
     */
    public native void refresh(boolean headersToo) /*-{
        var view = this.@com.gwtext.client.core.JsObject::getJsObj()();
        view.refresh(headersToo);
    }-*/;

    /**
     * Override this function to apply custom css classes to rows during rendering.
     *
     * @param record the record for the row
     * @param index the row index
     * @param rowParams row class passed to the method to support custom row rendering
     * @param store the grids store
     * @return the row CSS class
     */
    public String getRowClass(Record record, int index, RowParams rowParams, Store store) {
        return "";
    }

    /**
     * Refresh a row.
     *
     * @param index the row to refresh
     */
    public native void refreshRow(int index) /*-{
        var view = this.@com.gwtext.client.core.JsObject::getJsObj()();
        view.refreshRow(index);
    }-*/;

    /**
     * The record to refresh.
     *
     * @param record the record
     */
    public native void refreshRow(Record record) /*-{
        var view = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var recordJS = record.@com.gwtext.client.core.JsObject::getJsObj()();
        view.refreshRow(recordJS);
    }-*/;

    /**
     * Scrolls the grid to the top.
     */
    public native void scrollToTop() /*-{
        var view = this.@com.gwtext.client.core.JsObject::getJsObj()();
        view.scrollToTop();
    }-*/;

    /**
     * Return the header cell.
     *
     * @param index header index
     * @return the header cell
     */
    public native Element getHeaderCell(int index)/*-{
        var view = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var headerCellEl = view.getHeaderCell(index);
        return headerCellEl === undefined ? null : headerCellEl;
    }-*/;


    /**
     * Returns the row element.
     *
     * @param index row index
     * @return the row element
     */
    public native Element getRow(int index)/*-{
        var view = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var rowEl = view.getRow(index);
        return rowEl === undefined ? null : rowEl;
    }-*/;

    /**
     * Returns a cells element.
     *
     * @param rowIndex the row index
     * @param colIndex the column index
     * @return the cell element
     */
    public native Element getCell(int rowIndex, int colIndex)/*-{
        var view = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var el = view.getCell(rowIndex, colIndex);
        return el=== undefined ? null : el;
    }-*/;

    /**
     * Focusses the specified row.
     *
     * @param rowIndex the row index
     */
    public native void focusRow(int rowIndex) /*-{
        var view = this.@com.gwtext.client.core.JsObject::getJsObj()();
        view.focusRow(rowIndex);
    }-*/;

    /**
     * Focuses the specified cell.
     *
     * @param rowIndex the row index
     * @param colIndex the column index
     * @param hscroll false to disable horizontal scrolling
     */
    public native void focusCell(int rowIndex, int colIndex, boolean hscroll) /*-{
        var view = this.@com.gwtext.client.core.JsObject::getJsObj()();
        view.focusCell(rowIndex, colIndex, hscroll);
    }-*/;


    /**
     * Autofits all columns to the grid's width proportionate with their current size.
     * 
     * @param reserveScrollSpace reserve space for a scrollbar
     */
    public native void fitColumns(boolean reserveScrollSpace) /*-{
        var view = this.@com.gwtext.client.core.JsObject::getJsObj()();
        view.fitColumns(reserveScrollSpace);
    }-*/;

    /**
     * Update the headers sort state.
     */
    public native void updateHeaderSortState() /*-{
        var view = this.@com.gwtext.client.core.JsObject::getJsObj()();
        view.updateHeaderSortState();
    }-*/;

    /**
     * True to auto expand the columns to fit the grid <b>when the grid is created</b>.
     *
     * @param autoFill true to auto expand the columns to fit the grid when the grid is created.
     */
    public void setAutoFill(boolean autoFill) {
		JavaScriptObjectHelper.setAttribute(configJS, "autoFill", autoFill);
	}

    /**
     * Default text to display in the grid body when no rows are available (defaults to '').
     *
     * @param emptyText default text to display in the grid body when no rows are available (defaults to '').
     */
    public void setEmptyText(String emptyText) {
		JavaScriptObjectHelper.setAttribute(isCreated() ? getJsObj() : configJS, "emptyText", emptyText);
	}
    
    /**
     * Returns the default text to display in the grid body when no rows are available (defaults to '').
     * 
     * @return emptyText
     */
    public String getEmptyText() {
		return JavaScriptObjectHelper.getAttribute(isCreated() ? getJsObj() : configJS, "emptyText");
	}

    /**
     * True to add a second TR element per row that can be used to provide a row body that spans beneath the data row.
     * Use the getRowClass method's rowParams config to customize the row body
     *
     * @param enableRowBody true to add a second TR element per row that can be used to provide a row body that spans beneath the data row.
     */
    public void setEnableRowBody(boolean enableRowBody) {
		JavaScriptObjectHelper.setAttribute(configJS, "enableRowBody", enableRowBody);
	}

    /**
     * True to auto expand/contract the size of the columns to fit the grid width and prevent horizontal scrolling.
     *
     * @param forceFit true to force fit
     */
    public void setForceFit(boolean forceFit) {
		JavaScriptObjectHelper.setAttribute(configJS, "forceFit", forceFit);
	}

	//todo this is doced as a property and not a config but used in example as a config
    /**
     * The amount of space to reserve for the scrollbar (defaults to 19 pixels).
     *
     * @param scrollOffset the scroll offset
     */
    public void setScrollOffset(int scrollOffset) {
		JavaScriptObjectHelper.setAttribute(configJS, "scrollOffset", scrollOffset);
	}
}
