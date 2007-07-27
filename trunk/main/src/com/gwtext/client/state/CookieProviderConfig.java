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

package com.gwtext.client.state;

import com.gwtext.client.core.BaseConfig;
import com.gwtext.client.util.JavaScriptObjectHelper;

import java.util.Date;

public class CookieProviderConfig extends BaseConfig {

    public void setPath(String path) {
        JavaScriptObjectHelper.setAttribute(jsObj, "path", path);
    }

    public void setExpires(int days) {
        Date now = new Date();
        long millis = now.getTime() + (1000 * 60 * 60 * 24 * days);
        JavaScriptObjectHelper.setAttribute(jsObj, "expires", millis);
    }

    public void setDomain(String domain) {
        JavaScriptObjectHelper.setAttribute(jsObj, "domain", domain);
    }

    public void setSecure(boolean secure) {
        JavaScriptObjectHelper.setAttribute(jsObj, "secure", secure);
    }
}
