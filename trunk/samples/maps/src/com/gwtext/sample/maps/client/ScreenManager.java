/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.sample.maps.client;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.History;
import com.gwtext.client.core.EventCallback;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Function;
import com.gwtext.client.data.*;
import com.gwtext.client.util.DelayedTask;
import com.gwtext.client.util.Format;
import com.gwtext.client.widgets.*;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.event.TextFieldListenerAdapter;
import com.gwtext.client.widgets.layout.AccordionLayout;
import com.gwtext.client.widgets.layout.FitLayout;
import com.gwtext.client.widgets.tree.TreeFilter;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.gwtext.client.widgets.tree.TreeTraversalCallback;
import com.gwtext.client.widgets.tree.event.TreeNodeListenerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ScreenManager {

	private static Store store;
	private TabPanel appTabPanel;
	private TextField searchField;
	private TreeFilter treeFilter;
	private TreePanel treePanel;
	private DelayedTask delayedTask = new DelayedTask();

	public ScreenManager(TabPanel tabPanel) {
		this.appTabPanel = tabPanel;
	}

	public Panel getAccordionNav() {
		Panel accordion = new Panel();
		accordion.setTitle("Accordion");
		accordion.setLayout(new AccordionLayout(true));

		Store store = getStore();

		Record[] records = store.getRecords();
		for (int i = 0; i < records.length; i++) {
			Record record = records[i];

			String id = record.getAsString("id");
			final String category = record.getAsString("category");
			String title = record.getAsString("title");
			final String iconCls = record.getAsString("iconCls");

			String thumbnail = record.getAsString("thumbnail");
			String qtip = record.getAsString("qtip");

			final ShowcasePanel panel = (ShowcasePanel) record.getAsObject("screen");

			if (category == null) {
				Panel categoryPanel = new Panel();
				categoryPanel.setAutoScroll(true);
				categoryPanel.setLayout(new FitLayout());
				categoryPanel.setId(id + "-acc");
				categoryPanel.setTitle(title);
				categoryPanel.setIconCls(iconCls);
				accordion.add(categoryPanel);
			} else {
				Panel categoryPanel = (Panel) accordion.findByID(category + "-acc");
				TreePanel treePanel = (TreePanel) categoryPanel.findByID(category + "-acc-tree");
				TreeNode root = null;
				if (treePanel == null) {
					treePanel = new TreePanel();
					treePanel.setAutoScroll(true);
					treePanel.setId(category + "-acc-tree");
					treePanel.setRootVisible(false);
					root = new TreeNode();
					treePanel.setRootNode(root);
					categoryPanel.add(treePanel);
				} else {
					root = treePanel.getRootNode();
				}

				TreeNode node = new TreeNode();
				node.setText(title);
				node.setId(id);
				if (iconCls != null) node.setIconCls(iconCls);
				if (qtip != null) node.setTooltip(qtip);
				root.appendChild(node);

				addNodeClickListener(node, panel, iconCls);
			}
		}

		return accordion;
	}

	private void addNodeClickListener(TreeNode node, final Panel panel, final String iconCls) {
		if (panel != null) {
			node.addListener(new TreeNodeListenerAdapter() {
				public void onClick(Node node, EventObject e) {
					String panelID = panel.getId();
					if (appTabPanel.hasItem(panelID)) {
						showScreen(panel, null, null, node.getId());
					} else {
						TreeNode treeNode = (TreeNode) node;
						panel.setTitle(treeNode.getText());
						String nodeIconCls = iconCls;
						if (iconCls == null) {
							nodeIconCls = ((TreeNode) treeNode.getParentNode()).getIconCls();
						}
						showScreen(panel, treeNode.getText(), nodeIconCls, node.getId());
					}
				}
			});
		}
	}

	public void showScreen(String historyToken) {
		if (historyToken == null || historyToken.equals("")) {
			appTabPanel.activate(0);
		} else {
			Record record = store.getById(historyToken);
			if (record != null) {
				ShowcasePanel panel = (ShowcasePanel) record.getAsObject("screen");
				String title = record.getAsString("title");
				String iconCls = record.getAsString("iconCls");
				showScreen(panel, title, iconCls, historyToken);
			}
		}
	}

	public void showScreen(Panel panel, String title, String iconCls, String screenName) {
		String panelID = panel.getId();
		if (appTabPanel.hasItem(panelID)) {
			appTabPanel.scrollToTab(panel, true);
			appTabPanel.activate(panelID);
		} else {
			if (!panel.isRendered()) {
				panel.setTitle(title);
				if (iconCls == null) {
					iconCls = "plugins-nav-icon";
				}
				panel.setIconCls(iconCls);
			}
			appTabPanel.add(panel);
			appTabPanel.activate(panel.getId());
		}
		History.newItem(screenName);
	}

	public TreePanel getTreeNav() {
		treePanel = new TreePanel();
		treePanel.setTitle("Tree View");
		treePanel.setId("nav-tree");
		treePanel.setWidth(180);
		treePanel.setCollapsible(true);
		treePanel.setAnimate(true);
		treePanel.setEnableDD(false);
		treePanel.setAutoScroll(true);
		treePanel.setContainerScroll(true);
		treePanel.setRootVisible(false);
		treePanel.setBorder(false);
		treePanel.setTopToolbar(getFilterToolbar());

		TreeNode root = new TreeNode("Showcase Explorer");
		treePanel.setRootNode(root);

		Store store = getStore();

		Record[] records = store.getRecords();
		for (int i = 0; i < records.length; i++) {
			Record record = records[i];

			String id = record.getAsString("id");
			final String category = record.getAsString("category");
			String title = record.getAsString("title");
			final String iconCls = record.getAsString("iconCls");

			String thumbnail = record.getAsString("thumbnail");
			String qtip = record.getAsString("qtip");

			final ShowcasePanel panel = (ShowcasePanel) record.getAsObject("screen");

			TreeNode node = new TreeNode(title);
			node.setId(id);
			if (iconCls != null) node.setIconCls(iconCls);
			if (qtip != null) node.setTooltip(qtip);
			if (category == null || category.equals("")) {
				root.appendChild(node);
			} else {
				Node categoryNode = root.findChildBy(new NodeTraversalCallback() {
					public boolean execute(Node node) {
						return node.getId().equals(category);
					}
				});

				if (categoryNode != null) {
					categoryNode.appendChild(node);
				}
			}
			addNodeClickListener(node, panel, iconCls);
		}
		treeFilter = new TreeFilter(treePanel);
		return treePanel;
	}

	private void onSearchChange(final boolean filteredOnly) {
		final String filter = searchField.getText();
		if (filter == null || filter.equals("")) {
			treeFilter.clear();
			treeFilter.filterBy(new TreeTraversalCallback() {
				public boolean execute(TreeNode node) {
					node.setText(Format.stripTags(node.getText()));
					return true;
				}
			});
		} else {
			treeFilter.filterBy(new TreeTraversalCallback() {
				public boolean execute(TreeNode node) {
					String text = Format.stripTags(node.getText());
					node.setText(text);
					if (text.toLowerCase().indexOf(filter.toLowerCase()) != -1) {
						node.setText("<b>" + text + "</b>");
						((TreeNode) node.getParentNode()).expand();
						return true;
					} else {
						final List childMatches = new ArrayList();
						node.cascade(new NodeTraversalCallback() {
							public boolean execute(Node node) {
								String childText = ((TreeNode) node).getText();
								if (childText.toLowerCase().indexOf(filter.toLowerCase()) != -1) {
									childMatches.add(new Object());
								}
								return true;
							}
						});
						return !filteredOnly || childMatches.size() != 0;
					}
				}
			});
		}
	}

	private Toolbar getFilterToolbar() {
		final Toolbar filterToolbar = new Toolbar();
		ToolbarButton funnelButton = new ToolbarButton();

		funnelButton.setTooltip("Tree filtering is currently OFF<br>Click to turn Tree filtering <b>ON</b>");
		funnelButton.setCls("x-btn-icon filter-btn");
		funnelButton.setEnableToggle(true);
		funnelButton.addListener(new ButtonListenerAdapter() {
			public void onToggle(Button button, boolean pressed) {
				if (pressed) {
					DOM.setStyleAttribute(button.getButtonElement(), "backgroundImage", "url(images/funnel_X.gif)");
					button.setTooltip("Tree filtering is currently ON<br>Click to turn Tree filtering <b>OFF</b>");
					onSearchChange(true);
				} else {
					DOM.setStyleAttribute(button.getButtonElement(), "backgroundImage", "url(images/funnel_plus.gif)");
					button.setTooltip("Tree filtering is currently OFF<br>Click to turn Tree filtering <b>ON</b>");
					treeFilter.clear();
					onSearchChange(false);
				}
			}
		});
		filterToolbar.addButton(funnelButton);

		searchField = new TextField();
		searchField.setWidth(120);
		searchField.setMaxLength(40);
		searchField.setGrow(false);
		searchField.setSelectOnFocus(true);

		searchField.addListener(new TextFieldListenerAdapter() {
			public void onRender(Component component) {
				searchField.getEl().addListener("keyup", new EventCallback() {
					public void execute(EventObject e) {
						delayedTask.delay(500, new Function() {
							public void execute() {
								onSearchChange(false);
							}
						});
					}
				});
			}
		});

		filterToolbar.addField(searchField);
		filterToolbar.addFill();

		ToolbarButton expandButton = new ToolbarButton();
		expandButton.setCls("x-btn-icon expand-all-btn");
		expandButton.setTooltip("Expand All");
		expandButton.addListener(new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {
				treePanel.expandAll();
			}
		});
		filterToolbar.addButton(expandButton);

		ToolbarButton collapseButton = new ToolbarButton();
		collapseButton.setCls("x-btn-icon collapse-all-btn");
		collapseButton.setTooltip("Collapse All");
		collapseButton.addListener(new ButtonListenerAdapter() {
			public void onClick(Button button, EventObject e) {
				treePanel.collapseAll();
			}
		});

		filterToolbar.addButton(collapseButton);
		return filterToolbar;
	}

	public static Store getStore() {
		if (store == null) {
			MemoryProxy proxy = new MemoryProxy(getData());

			RecordDef recordDef = new RecordDef(new FieldDef[]{
					new StringFieldDef("id"),
					new StringFieldDef("category"),
					new StringFieldDef("title"),
					new StringFieldDef("iconCls"),
					new StringFieldDef("thumbnail"),
					new StringFieldDef("qtip"),
					new ObjectFieldDef("screen")
			});

			ArrayReader reader = new ArrayReader(0, recordDef);
			store = new Store(proxy, reader);
			store.load();
		}
		return store;
	}

	private static Object[][] getData() {
		return new Object[][]{

				new Object[]{"maps-category", null, "Maps", "maps-category-icon", null, null, null},
				new Object[]{"multipleMaps", "maps-category", "Multiple Maps", null, null, null, new MultiMapsSample()},
				new Object[]{"geoRSS", "maps-category", "Geo RSS Sample", null, null, null, new GeoRSSSample()},
				new Object[]{"imageOverLay", "maps-category", "Image Overlay", null, null, null, new ImageOverlaySample()},
				new Object[]{"markerFilters", "maps-category", "Marker Filter", null, null, null, new MarkerFiltersSample()},
				new Object[]{"polylneMap", "maps-category", "Polylines", null, null, null, new PolylineSample()}
		};
	}
}