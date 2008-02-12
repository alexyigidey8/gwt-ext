/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */

package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.event.ConnectionListener;

/**
 * The class encapsulates a connection to the page's originating domain, allowing requests to be made either to a configured URL, or to a URL specified at request time.
 * Requests made by this class are asynchronous, and will return immediately. No data from the server will be available to the statement immediately following the request call. To process returned data, use a callback in the request options object, or an event listener.
 * Note: If you are doing a file upload, you will not get a normal response object sent back to your callback or event handler. Since the upload is handled via in IFRAME, there is no XMLHttpRequest. The response object is created using the innerHTML of the IFRAME's document as the responseText property and, if present, the IFRAME's XML document as the responseXML property.
 * This means that a valid XML or HTML document must be returned. If JSON data is required, it is suggested that it be placed either inside a &lt;textarea&gt; in an HTML document and retrieved from the responseText using a regex, or inside a CDATA section in an XML document and retrieved from the responseXML using standard DOM methods.
 */
public class Connection extends JsObject {

    /**
     * HTTP request method constants.
     */
    public static final class Method {
        private final String name;

        private Method(String name) {
            this.name = name;
        }

        public String getMethod() {
            return name;
        }

        public String toString() {
            return name;
        }
    }

    /**
     * Specifies that the HTTP GET method should be used.
     */
    public static final Method GET = new Method("GET");

    /**
     * Specifies that the HTTP POST method should be used.
     */
    public static final Method POST = new Method("POST");

    protected Connection() {
    }

    /**
     * Constructs a Connection using a native connection object.
     *
     * @param jsObj native connection object
     */
    public Connection(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Constructs a Connection using the configuration parameters passed.
     *
     * @param config the connection config
     */
    public Connection(ConnectionConfig config) {
        jsObj = create(config.getJsObj());
    }

    private native JavaScriptObject create(JavaScriptObject config) /*-{
        return new $wnd.Ext.data.Connection(config);
    }-*/;

    /**
     * Aborts the last outstanding request.
     */
    public native void abort() /*-{
        var conn = this.@com.gwtext.client.core.JsObject::getJsObj()();
        conn.abort();
    }-*/;

    /**
     * Aborts any outstanding request.
     *
     * @param transactionId the transaction to abort
     */
    public native void abort(long transactionId) /*-{
        var conn = this.@com.gwtext.client.core.JsObject::getJsObj()();
        conn.abort(transactionId);
    }-*/;

    /**
     * Determine whether this object has a request outstanding.
     *
     * @return true if loading
     */
    public native boolean isLoading() /*-{
        var conn = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return conn.isLoading();
    }-*/;

    /**
     * Determine whether the specified transaction has a request outstanding.
     *
     * @param transactionId the transaction id
     * @return true if loading
     */
    public native boolean isLoading(long transactionId) /*-{
        var conn = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return conn.isLoading(transactionId);
    }-*/;

    /**
     * Sends an HTTP request to a remote server.
     *
     * @return the transaction id
     */
    public native long request() /*-{
        var conn = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var transId =  conn.request();
        return transId == null || transId === undefined ? -1 : (trans.tId || -1);
    }-*/;

    /**
     * Sends an HTTP request to a remote server.
     *
     * @param param the request params
     * @return the transaction id
     */
    public native long request(RequestParam param) /*-{
        var conn = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var paramJS = param.@com.gwtext.client.core.JsObject::getJsObj()();
        var transId = conn.request(paramJS);
        return transId == null || transId === undefined ? -1 : (trans.tId || -1);
    }-*/;

    /**
     * Adds a connection listener to this connection object.
     *
     * @param listener the connection listener
     */
    public native void addListener(ConnectionListener listener)/*-{
        var conn = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var connJ = this;

        conn.addListener('beforerequest',
                function(conn, options) {
                    return listener.@com.gwtext.client.core.event.ConnectionListener::doBeforeRequest(Lcom/gwtext/client/core/Connection;)(connJ);
                }
        );

        conn.addListener('requestcomplete',
                function(conn, response, options) {
                    return listener.@com.gwtext.client.core.event.ConnectionListener::onRequestComplete(Lcom/gwtext/client/core/Connection;Ljava/lang/String;)(connJ, response.responseText);
                }
        );

        conn.addListener('requestexception',
                function(conn, response, options) {
                    return listener.@com.gwtext.client.core.event.ConnectionListener::onRequestException(Lcom/gwtext/client/core/Connection;ILjava/lang/String;)(connJ, response.status, response.responseText);
                }
        );
    }-*/;
}
