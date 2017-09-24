package main.java;

public class PurityReport {

    private User submitter;
    private String dateSubmitted;
    private String locationString;
    private String condition;
	private int virusPPM;
	private int containmentPPM;
    private int reportNumber;
	WaterReport report;
    private static int reportCounter = 0;

    /**
     * This function is the constructor to make a new purity report
     */
    public PurityReport(User submitter, String dateSubmitted, String condition, int virusPPM, int containmentPPM, WaterReport report) {
        this.submitter = submitter;
        this.dateSubmitted = dateSubmitted;
        this.locationString = report.getLocationString();
        this.condition = condition;
        this.virusPPM = virusPPM;
        this.containmentPPM = containmentPPM;
        this.report = report;
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
    public int getReportNumber() {
        return reportNumber;
    }

	public int getVirusPPM() {
		return virusPPM;
	}

	public int getContainmentPPM() {
		return containmentPPM;
	}

	public String getLocationString() {return locationString;}

	public WaterReport getWaterReport() {
		return report;
	}

	public void setReport(WaterReport report) {
        this.report = report;
        this.locationString = report.getLocationString();
	}
}