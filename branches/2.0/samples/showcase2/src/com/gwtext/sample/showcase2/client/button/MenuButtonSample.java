/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.showcase2.client.button;


import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.Checkbox;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.event.CheckboxListenerAdapter;
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.menu.Item;
import com.gwtext.client.widgets.menu.Menu;
import com.gwtext.client.widgets.menu.MenuItem;
import com.gwtext.sample.showcase2.client.ShowcasePanel;

/**
 * Menu Button sample.
 */
public class MenuButtonSample extends ShowcasePanel {

    public String getSourceUrl() {
        return "source/button/MenuButtonSample.java.html";
    }

    public String getCssUrl() {
        return "source/button/MenuButtonSample.css.html";
    }

    public Panel getViewPanel() {
        if (panel == null) {
            panel = new Panel();
            //add some extra space on to for the menu to be displayed
            panel.setPaddings(100, 0, 0, 0);

            //create the button
            final Button button = new Button();
            button.setText("Start");
            button.setIconCls("office-icon");

            //create the menu we want to assign to the button
            Menu menu = new Menu();

            Item wordItem = new Item("Word");
            wordItem.setIconCls("word-icon");
            menu.addItem(wordItem);

            Item excelItem = new Item("Excel");
            excelItem.setIconCls("excel-icon");
            menu.addItem(excelItem);

            //create a sub menu
            Menu subMenu = new Menu();
            Item cItem = new Item("C");
            cItem.setIconCls("c-icon");

            Item cppItem = new Item("C++");
            cppItem.setIconCls("cpp-icon");

            Item csharpItem = new Item("CSharp");
            csharpItem.setIconCls("csharp-icon");

            subMenu.addItem(cItem);
            subMenu.addItem(cppItem);
            subMenu.addItem(csharpItem);

            //add menu item that has sub menu
            MenuItem vsItem = new MenuItem("Visual Studio", subMenu);
            vsItem.setIconCls("visualstudio-icon");
            menu.addItem(vsItem);

            Item powerPointItem = new Item("PowerPoint");
            powerPointItem.setIconCls("powerpoint-icon");
            menu.addItem(powerPointItem);

            //assign the menu to to the button
            button.setMenu(menu);

            FormPanel form = new FormPanel();
            form.setBorder(false);
            Checkbox cb = new Checkbox("Menu on top?");

            //dynamically change the poistion of the menu in relation to the button
            cb.addListener(new CheckboxListenerAdapter() {
                public void onCheck(Checkbox field, boolean checked) {
                    log(EVENT, "Checkbox " + (checked ? " checked." : " unchecked."));
                    if (checked) {
                        //set position to top
                        button.setMenuAlign("bl-tl");
                    } else {
                        //set position to bottom
                        button.setMenuAlign("tl-bl?");
                    }
                }
            });
            form.add(cb);

            Panel horizontalPanel = new Panel();
            horizontalPanel.setLayout(new HorizontalLayout(15));

            horizontalPanel.add(button);
            horizontalPanel.add(form);

            panel.add(horizontalPanel);
        }
        return panel;
    }

    protected boolean showEvents() {
        return true;
    }

    public String getIntro() {
        return "<p>This example demonstrates a Menu associated with a Button. When the Button is clicked," +
                " the Button's Menu is displayed. You can attach event listeners for various actions.</p>" +
                "<p>The position on the Menu (and SubMenu's) is configurable. Try toggling the checkbox " +
                " and then click the Button for an example of this.</p>";
    }
}