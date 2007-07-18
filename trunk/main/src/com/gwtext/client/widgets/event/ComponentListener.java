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

package com.gwtext.client.widgets.event;

import com.gwtext.client.widgets.Component;

public interface ComponentListener {
    boolean doBeforeDestroy(Component component);

    boolean doBeforeHide(Component component);

    boolean doBeforeRender(Component component);

    boolean doBeforeShow(Component component);

    void onDestroy(Component component);

    void onDisable(Component component);

    void onEnable(Component component);

    void onHide(Component component);

    void onRender(Component component);

    void onShow(Component component);
}
