package main.java;

import java.awt.Dimension;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import java.net.URL;
import java.util.Set;
import java.util.HashSet;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventHandler;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import netscape.javascript.JSObject;
import java.util.*;

/**
 * Created by Jack on 4/20/2017.
 */
public class AppMap extends JFXPanel implements Initializable, MapComponentInitializedListener, UIEventHandler {

    private GoogleMapView mapComponent;
    private GoogleMap map;
    private Scene scene;
    private Set markers;
    public Model model = new Model();

    public AppMap() {
        setPreferredSize(new Dimension(476, 745));
        Platform.runLater(() -> {
            mapComponent = new GoogleMapView();
            mapComponent.addMapInializedListener(() -> {

                LatLong center = new LatLong(33.77550, -84.396285);

                MapOptions options = new MapOptions()
                        .center(center)
                        .mapMarker(true)
                        .zoom(11)
                        .overviewMapControl(false)
                        .panControl(false)
                        .rotateControl(false)
                        .scaleControl(false)
                        .streetViewControl(false)
                        .zoomControl(false)
                        .mapType(MapTypeIdEnum.TERRAIN);

                map = mapComponent.createMap(options);

                this.markers = new HashSet<Marker>();

                map.addUIEventHandler(UIEventType.click, this);
                this.createMapPins();
            });

            mapComponent.setPrefSize(600, 745);
            scene = new Scene(mapComponent);
            setScene(scene);
        });
    }


    public void refreshMapPins() {
        if (markers != null) {
            for (Object marker : markers) {
                if (marker != null) {
                    Marker marker2 = (Marker) marker;
                    map.removeMarker(marker2);
                }
            }
            markers.clear();
        }
        this.createMapPins();
    }

    /** Creates the map pins for the map */
    private void createMapPins() {
            List<WaterReport> allReports = model.allReports;
            for (WaterReport report: allReports) {
                Marker tMarker = new Marker(new MarkerOptions().position(new LatLong(
                        report.getLatitude(), report.getLongitude())).icon(report.getIconURL()), map, report);
                tMarker.setWindow(new InfoWindow(new InfoWindowOptions().content(report.toInfoWindow())));
                map.addMarker(tMarker);
                markers.add(tMarker);
                map.addUIEventHandler(tMarker, UIEventType.click, jsObject -> tMarker.toggleWindowVisibility());
            }
            // zoom map to fix bug ( better solution ?? )
            int currentZoom = map.getZoom();
            map.setZoom( currentZoom - 1 );
    }

    @Override
    public void mapInitialized() {}

    /** Called as the Controller is starting. */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mapComponent.addMapInializedListener(this);
    }

    /** Handles clicks on the map. */
    @Override
    public void handle(JSObject jsObject) {}

    /** Adds a pin to the map */
    public void addPin(WaterReport report) {
        Marker tMarker = new Marker(new MarkerOptions().position(new LatLong(
                report.getLatitude(), report.getLongitude())).icon(report.getIconURL()), map, report);
        tMarker.setWindow(new InfoWindow(new InfoWindowOptions().content(report.toInfoWindow())));
        map.addMarker(tMarker);
        markers.add(tMarker);
        map.addUIEventHandler(tMarker, UIEventType.click, jsObject -> tMarker.toggleWindowVisibility());
    }
}