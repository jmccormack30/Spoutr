package main.java;

import java.util.*;

public class WaterReport {

    private User submitter;
    private String dateSubmitted;
    private double latitude;
    private double longitude;
    private String locationString;
    private String type;
    private String condition;
    private int reportNumber;
    private static int reportCounter = 0;
    private List<PurityReport> prList = new ArrayList<>();

    /**
     * This function is the constructor to make a new water report
     */
    public WaterReport(User submitter, String dateSubmitted, String locationString, String type, String condition, double latitude, double longitude) {
        this.submitter = submitter;
        this.dateSubmitted = dateSubmitted;
        this.locationString = locationString;
        this.type = type;
        this.condition = condition;
        this.latitude = latitude;
        this.longitude = longitude;
        this.reportNumber = reportCounter++;
    }

    /**
     * This function returns the name of the submitter
     *
     * @return the user who submitted
     */
    public User getSubmitter() {
        return submitter;
    }

    /**
     * This function returns the date that the water report was submitted
     *
     * @return the date it was submitted
     */
    public String getDateSubmitted() {
        return dateSubmitted;
    }

    /**
     * This function returns the string location of the water report
     *
     * @return the string location of water report
     */
    public String getLocationString() {
        return locationString;
    }

    /**
     * This function returns the type of the water
     *
     * @return the type of water
     */
    public String getType() {
        return type;
    }

    /**
     * This function returns the condition of the water
     *
     * @return the condition of water
     */
    public String getCondition() {
        return condition;
    }

    /**
     * This function returns the report number
     *
     * @return the report number
     */

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getReportNumber() {
        return reportNumber;
    }

    /**
     * This function returns the list of purity reports
     *
     * @return the list of purity reports
     */
    public List<PurityReport> getPrList() { return prList; }

    /**
     * This function adds a purity report to a water report
     * @param pr PurityReport of this water report
     */
    public boolean addToPRList(PurityReport pr) {
        prList.add(pr);
        return true;
    }

    public String toInfoWindow() {
        return "<h3>" + locationString + "<br /><br />" + type + "<br />" + condition + "</h3>";
    }

    public String getIconURL() {
        return "http://maps.google.com/mapfiles/ms/icons/red-dot.png";
    }

    /**
     * This function overrides the toString method to display water reports in the list view
     * @return the string of some data from the water report
     */
    @Override
    public String toString() {
        return this.getLocationString() + "-" + this.getType() + "-" + this.getCondition();
    }
}
