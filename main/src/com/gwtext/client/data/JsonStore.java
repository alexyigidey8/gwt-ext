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

package com.gwtext.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.core.BaseConfig;


public class JsonStore extends Store {
    public JsonStore(String url, String root, String[] fields) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "url", url);
        JavaScriptObjectHelper.setAttribute(config, "root", root);
        JavaScriptObjectHelper.setAttributeAsStringArray(config, "fields", fields);
        jsObj = create(config);
    }

    public JsonStore(String url, String root, RecordDef recordDef) {
        JavaScriptObject config = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(config, "url", url);
        JavaScriptObjectHelper.setAttribute(config, "root", root);
        JavaScriptObjectHelper.setAttribute(config, "recordType", recordDef.getJsObj());
        jsObj = create(config);
    }

    private static native JavaScriptObject create(JavaScriptObject config) /*-{
        debugger;
        return new $wnd.Ext.data.JsonStore(config);
    }-*/;

    private static class JsonStoreConfig extends BaseConfig {

        public void setUrl(String url) {
            JavaScriptObjectHelper.setAttribute(jsObj, "url", url);
        }

        public void setRoot(String root) {
            JavaScriptObjectHelper.setAttribute(jsObj, "root", root);
        }


        public void setFields(String[] fields) {
            JavaScriptObjectHelper.setAttribute(jsObj, "fields", JavaScriptObjectHelper.convertToJavaScriptArray(fields));
        }

        public void setFields(Field[] fields) {
            JavaScriptObjectHelper.setAttribute(jsObj, "fields", JavaScriptObjectHelper.convertToJavaScriptArray(fields));
        }


    }
}