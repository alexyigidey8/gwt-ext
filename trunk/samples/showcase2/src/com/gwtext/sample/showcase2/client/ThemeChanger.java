/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client;

import com.gwtext.client.data.Record;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.util.CSS;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;

/**
 * A simple dynamic Theme Changer ComboBox. You must have the Ext theme stylesheet declared in your host html page
 * using the id "theme".
 *
 * For example
 *
 * &lt;link id="theme" rel="stylesheet" type="text/css" href="js/ext/resources/css/xtheme-gray.css"/&gt;
 * or
 * &lt;link id="theme" rel="stylesheet" type="text/css" href="xtheme-default.css"/&gt;
 *
 */
public class ThemeChanger extends ComboBox {

    public ThemeChanger() {

        final Store store = new SimpleStore(new String[]{"theme", "label"}, new Object[][]{
                new Object[]{"js/ext/resources/css/xtheme-gray.css", "Gray"},
                new Object[]{"xtheme-default.css", "Aero Glass"}
        });
        store.load();

        setFieldLabel("Select Theme");
        setEditable(false);
        setStore(store);
        setDisplayField("label");
        setForceSelection(true);
        setTriggerAction(ComboBox.ALL);
        setValue("Gray");
        setFieldLabel("Switch theme");
        addListener(new ComboBoxListenerAdapter() {
            public void onSelect(ComboBox comboBox, Record record, int index) {
                String theme = record.getAsString("theme");
                CSS.swapStyleSheet("theme", theme);
            }
        });
        setWidth(100);
    }
}

