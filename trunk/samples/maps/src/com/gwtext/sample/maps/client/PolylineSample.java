package com.gwtext.sample.maps.client;

import com.gwtext.client.widgets.map.LatLonPoint;
import com.gwtext.client.widgets.map.Polyline;


public class PolylineSample extends BaseMultiMapPanel {

	protected void generateMap() {

		mapPanel.setWidth(500);
		mapPanel.setHeight(500);

		Polyline myPoly = new Polyline(new LatLonPoint[]{

				new LatLonPoint(37.7945928242851, -122.395033836365),
				new LatLonPoint(37.7938467508748, -122.393960952759),
				new LatLonPoint(37.7945928242851, -122.39275932312),
				new LatLonPoint(37.789505810689, -122.387609481812),
				new LatLonPoint(37.7782792282611, -122.387351989746),
				new LatLonPoint(37.7768545853105, -122.390570640564),
				new LatLonPoint(37.7690524823224, -122.397179603577),
				new LatLonPoint(37.7668813159428, -122.394347190857),
				new LatLonPoint(37.7658635597592, -122.407650947571),
				new LatLonPoint(37.7689167862912, -122.408037185669),
				new LatLonPoint(37.7765493011063, -122.417650222778),
				new LatLonPoint(37.7945928242851, -122.395033836365)});


		mapPanel.addPolyline(myPoly);
		mapPanel.setCenterAndZoom(new LatLonPoint(37.78, -122.395033836365), 12);

	}


}