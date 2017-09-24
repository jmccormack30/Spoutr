package main.java;

import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.InfoWindow;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;

class Marker extends com.lynden.gmapsfx.javascript.object.Marker {
    private InfoWindow window;
    private boolean windowVisible;
    private GoogleMap map;
    private final WaterReport report;

    public Marker(MarkerOptions mo, GoogleMap map, WaterReport report) {
        super(mo);
        windowVisible = false;
        this.report = report;
    }

    public InfoWindow getWindow() {
        return window;
    }

    public void setWindow(InfoWindow window) {
        this.window = window;
    }

    public void toggleWindowVisibility() {
        if (windowVisible) {
            window.close();
        } else {
            window.open(map, this);
        }
        this.windowVisible = !this.windowVisible;
    }

    public WaterReport getReport() {
        return report;
    }
}
