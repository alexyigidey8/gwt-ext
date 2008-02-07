/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * Field that represents boolean data.
 *
 * @author Sanjiv Jivan
 * @since 0.9
 */
public class BooleanFieldDef extends FieldDef {

    /**
     * Construct a new BooleanFieldDef.
     *
     * @param name the name of field
     */
    public BooleanFieldDef(String name) {
        this(name, null, null);
    }

    /**
     * Construct a new BooleanFieldDef
     *
     * @param name    the name of field
     * @param mapping the field mapping. Depending on the Reader used, mapping could be the array index position or an XPath expression when reading from XML
     */
    public BooleanFieldDef(String name, String mapping) {
        this(name, mapping, null);
    }

    /**
     * Construct a new BooleanFieldDef
     *
     * @param name    the field name
     * @param mapping the field mapping. Depending on the Reader used, mapping could be the array index position or an XPath expression when reading from XML
     */
    public BooleanFieldDef(String name, int mapping) {
        this(name, mapping, null);
    }

    /**
     * Construct a new BooleanFieldDef
     *
     * @param name      the field name
     * @param mapping   the field mapping. Depending on the Reader used, mapping could be the array index position or an XPath expression when readinf from XML
     * @param converter format the incoming data before processing it
     */
    public BooleanFieldDef(String name, int mapping, Converter converter) {
        this(name, String.valueOf(mapping), converter);
    }

    /**
     * Construct a new BooleanFieldDef
     *
     * @param name      the field name
     * @param mapping   the field mapping. Depending on the Reader used, mapping could be the array index position or an XPath expression when readinf from XML
     * @param converter format the incoming data before processing it
     */
    public BooleanFieldDef(String name, String mapping, Converter converter) {
        jsObj = create(name, mapping, converter);
    }

    private static JavaScriptObject create(String name, String mapping, Converter converter) {
        JavaScriptObject jsObj = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(jsObj, "name", name);
        JavaScriptObjectHelper.setAttribute(jsObj, "type", "bool");
        if (mapping != null) JavaScriptObjectHelper.setAttribute(jsObj, "mapping", mapping);
        if (converter != null) setConverter(jsObj, converter);
        return jsObj;
    }
}
