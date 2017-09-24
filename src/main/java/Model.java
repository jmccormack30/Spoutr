package main.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Model {

    public static List<User> allUsers;
    public static List<WaterReport> allReports;
    public static List<PurityReport> allPurityReports;

    public Model() {
        allReports = new ArrayList<>();
        allPurityReports = new ArrayList<>();
        allUsers = new ArrayList<>();
        User jack = new User("Jack McCormack", "jack@gmail.com", "jackmack8", "qweqwe", "Admin");

        WaterReport w1 = new WaterReport(jack, "1-1-2001", "Lake Allatoona", "Lake", "Treatable Muddy", 34.127253, -84.710026);
        WaterReport w2 = new WaterReport(jack, "1-1-2001", "Lake Lanier", "Lake", "Treatable Clear", 34.194967, -84.002037);
        WaterReport w3 = new WaterReport(jack, "1-1-2001", "Chattahoochee River", "River", "Treatable Clear", 33.896127, -84.443693);
        WaterReport w4 = new WaterReport(jack, "1-1-2001", "Angelos Lake", "Lake", "Waste", 33.451848, -84.849401);
        WaterReport w5 = new WaterReport(jack, "1-1-2001", "Little Haynes Creek", "Stream", "Treatable Muddy", 33.799804, -83.899795);

        allReports.add(w1);
        allReports.add(w2);
        allReports.add(w3);
        allReports.add(w4);
        allReports.add(w5);

        SubmitPurityReportScreen.waterReports.removeAllItems();
        HistoryScreen.waterReports.removeAllItems();
        for (WaterReport wp: allReports) {
            String tempString = wp.getLocationString() + " - " + wp.getType() + " - " + wp.getCondition();
            SubmitPurityReportScreen.waterReports.addItem(tempString);
            HistoryScreen.waterReports.addItem(tempString);
        }

        PurityReport p1 = new PurityReport(jack, "1-1-2001", "Safe", 17, 22, w1);
        PurityReport p6 = new PurityReport(jack, "1-1-2001", "Safe", 24, 29, w1);
        PurityReport p7 = new PurityReport(jack, "1-1-2001", "Safe", 20, 25, w1);
        PurityReport p8 = new PurityReport(jack, "1-1-2001", "Safe", 29, 35, w1);
        PurityReport p2 = new PurityReport(jack, "1-1-2001", "Treatable", 12, 27, w2);
        PurityReport p3 = new PurityReport(jack, "1-1-2001", "Treatable", 26, 37, w3);
        PurityReport p9 = new PurityReport(jack, "1-1-2001", "Treatable", 22, 30, w3);
        PurityReport p10 = new PurityReport(jack, "1-1-2001", "Treatable", 25, 34, w3);
        PurityReport p12 = new PurityReport(jack, "1-1-2001", "Treatable", 6, 12, w1);
        PurityReport p13 = new PurityReport(jack, "1-1-2001", "Treatable", 32, 25, w1);
        PurityReport p11 = new PurityReport(jack, "1-1-2001", "Treatable", 35, 45, w3);
        PurityReport p4 = new PurityReport(jack, "1-1-2001", "Unsafe", 7, 25, w4);
        PurityReport p5 = new PurityReport(jack, "1-1-2001", "Treatable", 23, 45, w5);
        allPurityReports.add(p1);
        allPurityReports.add(p9);
        allPurityReports.add(p2);
        allPurityReports.add(p6);
        allPurityReports.add(p7);
        allPurityReports.add(p10);
        allPurityReports.add(p3);
        allPurityReports.add(p4);
        allPurityReports.add(p8);
        allPurityReports.add(p5);
        allPurityReports.add(p12);
        allPurityReports.add(p11);
        allPurityReports.add(p13);
    }

    /** Checks the entered password and username against
     *  the registered Users for the app for attempted Login
     *
     * @param username the username entered on LoginScreen
     * @param password the password entered on LoginScreen
     * @return a boolean value telling whether login succeeds or fails
     */
    public boolean validateLogin(String username, String password) {
        try {
            Scanner users = new Scanner(new File("src/main/resources/users.csv"));
            while (users.hasNext()) {
                String line = users.nextLine();
                String[] stuff = line.split(",");
                User newUser = new User(stuff[0], stuff[1], stuff[2], stuff[3], stuff[4]);
                if (newUser.getUsername().equals(username) && newUser.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        return false;
    }

    /** Takes the entered information from the RegisterScreen
     *  and attempts to register the user in the system for the App
     *
     * @param name the name of the User
     * @param email the email of the User
     * @param username the username of the User
     * @param password the password of the User
     * @param accountType the account type of the User
     * @return a boolean whether the User is added or not
     */
    public boolean addUser(String name, String email, String username, String password, String accountType) {
        try {
            FileWriter file = new FileWriter("src/main/resources/users.csv", true);
            BufferedWriter out = new BufferedWriter(file);
            out.write(name + "," + email + "," + username + "," + password + "," + accountType);
            out.newLine();
            out.close();
        } catch (Exception x) {
           System.out.println(x.getMessage());
        }
        return true;
    }

    /** Takes in a username and password and searches
     *  the system for a match with one of the Users
     *
     * @param username the username to retrieve
     * @param password the password to retrieve
     * @return returns the User if it is found
     */
    public User getUser(String username, String password) {
        try {
            Scanner users = new Scanner(new File("src/main/resources/users.csv"));
            while (users.hasNext()) {
                String line = users.nextLine();
                String[] stuff = line.split(",");
                User newUser = new User(stuff[0], stuff[1], stuff[2], stuff[3], stuff[4]);
                if (newUser.getUsername().equals(username)) {
                    return newUser;
                }
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        return new User("null", "null", "null", "null", "null");
    }

    /** Updates the information for the User in the system
     *
     * @param username the current username
     * @param password the current password
     * @param newEmail the new email
     * @param newPassword the new password
     */
    public void updateUser(String username, String password, String newEmail, String newPassword) {
        try {
            Scanner users = new Scanner(new File("src/main/resources/users.csv"));
            ArrayList<String> temp = new ArrayList<>();
            while (users.hasNext()) {
                String line = users.nextLine();
                String[] stuff = line.split(",");
                if (username.equals(stuff[2]) && password.equals(stuff[3])) {
                    String newString = stuff[0] + "," + newEmail + "," + username + "," + newPassword + "," + stuff[4];
                    temp.add(newString);
                } else {
                    temp.add(line);
                }
            }
            FileWriter file = new FileWriter("src/main/resources/users.csv", false);
            BufferedWriter out = new BufferedWriter(file);
            for (String s: temp) {
                out.write(s);
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /** Submits a WaterReport into the system
     *
     * @param report the WaterReport to be added
     */
    public void submitReport(WaterReport report) {
        allReports.add(report);
        SubmitPurityReportScreen.waterReports.removeAllItems();
        HistoryScreen.waterReports.removeAllItems();
        for (WaterReport wp: allReports) {
            String tempString = wp.getLocationString() + " - " + wp.getType() + " - " + wp.getCondition();
            SubmitPurityReportScreen.waterReports.addItem(tempString);
            HistoryScreen.waterReports.addItem(tempString);
        }
    }

    /** Submits a PurityReport into the system
     *
     * @param pReport the PurityReport to be added
     */
    public void submitPurityReport(PurityReport pReport) {
        allPurityReports.add(pReport);
        for (PurityReport pr: allPurityReports) {
            String tempString = pr.getWaterReport().getLocationString() + " - " + pr.getCondition() + " - " +
                                                            pr.getVirusPPM() + " - " + pr.getContainmentPPM();

        }
    }

    /** Searches the Reports for a match with the given String
     *
     * @param wpString the String representation of a WaterReport
     * @return the WaterReport associated with the String if it is found
     */
    public WaterReport getReport(String wpString) {
        List<String> items = Arrays.asList(wpString.split("\\s*-\\s*"));
        for (WaterReport wp: allReports) {
            if (wp.getLocationString().equals(items.get(0)) && wp.getType().equals(items.get(1))
                                                    && wp.getCondition().equals(items.get(2))) {
                return wp;
            }
        }
        return null;
    }

    /** Searches through the list of PurityReports in the system
     *  and returns a double[] of all the VirusPPM for the purity
     *  reports that are associated with the given water report
     *
     * @param report the WaterReport we want
     * @return a double[] of the virusPPM data
     */
    public double[] getVirusArray(WaterReport report) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (PurityReport pr: allPurityReports) {
            if (pr.getWaterReport().getLocationString().equals(report.getLocationString())) {
                temp.add(pr.getVirusPPM());
            }
        }
        double[] array = new double[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i).doubleValue();
        }
        return array;
    }

    /** Searches through the list of PurityReports in the system
     *  and returns a double[] of all the ContainmentPPM for the purity
     *  reports that are associated with the given water report
     *
     * @param report the WaterReport we want
     * @return a double[] of the containmentPPM data
     */
    public double[] getContainmentArray(WaterReport report) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (PurityReport pr: allPurityReports) {
            if (pr.getWaterReport().getLocationString().equals(report.getLocationString())) {
                temp.add(pr.getContainmentPPM());
            }
        }
        double[] array = new double[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            array[i] = temp.get(i).doubleValue();
        }
        return array;
    }
}