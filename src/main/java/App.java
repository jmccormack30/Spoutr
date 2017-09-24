package main.java;

import javafx.application.Platform;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.CardLayout;

public class App {

    public CardLayout cardLayout;
    public TitleScreen titleScreen;
    public static RegisterScreen registerScreen;
    public static HomeScreen homeScreen;
    public static SettingsScreen settingsScreen;
    public static SubmitReportScreen submitreportScreen;
    public static SubmitPurityReportScreen submitpurityreportScreen;
    public static WaterReportScreen waterreportScreen;
    public static ViewPurityReport purityreportScreen;
    public static HistoryScreen historyScreen;
    public static HistoryGraph historyGraph;
    public static MapView mapview;
    public static JPanel cards;
    public static JFrame frame;
    public static AppMap appmap = new AppMap();
    public static User user = new User();
    public static Model model = new Model();
    public static boolean running = true;
    public static boolean loginB = false;
    public static boolean registerB = false;
    public static boolean homeB = false;
    public static boolean settingsB = false;
    public static boolean reportB = false;
    public static boolean purityreportB = false;
    public static boolean waterreportB = false;
    public static boolean viewpreportB = false;
    public static boolean mapB = false;
    public static boolean historyB = false;
    public static boolean historyReportB = false;

    public void setUP() {
        frame = new JFrame("Spoutr");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(476, 800));
		frame.setResizable(false);

		//Sets the App Frame to be centered to the User's monitor
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        cards = new JPanel(new CardLayout());
        titleScreen = new TitleScreen();
        registerScreen = new RegisterScreen();
        homeScreen = new HomeScreen();
        settingsScreen = new SettingsScreen();
        submitreportScreen = new SubmitReportScreen();
        submitpurityreportScreen = new SubmitPurityReportScreen();
        waterreportScreen = new WaterReportScreen();
        purityreportScreen = new ViewPurityReport();
        historyScreen = new HistoryScreen();
        mapview = new MapView();
        historyGraph = new HistoryGraph();
        cards.add(titleScreen, "TitleScreen");
        cards.add(registerScreen, "RegisterScreen");
        cards.add(homeScreen, "HomeScreen");
        cards.add(settingsScreen, "SettingsScreen");
        cards.add(submitreportScreen, "SubmitReportScreen");
        cards.add(submitpurityreportScreen, "SubmitPurityReportScreen");
        cards.add(waterreportScreen, "WaterReportScreen");
        cards.add(purityreportScreen, "ViewPurityReportScreen");
        cards.add(mapview, "MapView");
        cards.add(historyScreen, "HistoryScreen");
        cards.add(historyGraph, "HistoryGraph");

        frame.add(cards);
        frame.pack();
		frame.setVisible(true);
        cardLayout = (CardLayout) cards.getLayout();
    }

    public void titleScreen() {
        loginB = false;
        cardLayout.show(cards, "TitleScreen");
		while (running) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.getMessage();
			}
		}
		running = true;
		if (registerB) {
            registerScreen.refreshScreen();
            registerScreen();
        } else if (homeB) {
            homeScreen();
        }
    }

    private void registerScreen() {
        registerB = false;
        cardLayout.show(cards, "RegisterScreen");
        while (running) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.getMessage();
			}
		}
        running = true;
        if (loginB) {
            titleScreen.refreshScreen();
            titleScreen();
        } else if (homeB) {
            homeScreen();
        }
    }

    private void homeScreen() {
        homeB = false;
        HomeScreen.user = user;
        homeScreen.refreshScreen();
        cardLayout.show(cards, "HomeScreen");
        while (running) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.getMessage();
			}
		}
        running = true;
        if (loginB) {
            titleScreen.refreshScreen();
            titleScreen();
        } else if (settingsB) {
            settingsScreen();
        } else if (reportB) {
            submitreportScreen();
        } else if (purityreportB) {
            submitpurityreportScreen();
        } else if (waterreportB) {
            waterreportsScreen();
        } else if (viewpreportB) {
            viewPurityReportScreen();
        } else if (mapB) {
            mapScreen();
        } else if (historyB) {
            historyScreen();
        }
    }

    private void settingsScreen() {
        settingsB = false;
        SettingsScreen.user = HomeScreen.user;
        settingsScreen.refreshScreen();
        cardLayout.show(cards, "SettingsScreen");
        while (running) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.getMessage();
			}
		}
        running = true;
        if (homeB) {
            homeScreen();
        }
    }

    private void submitreportScreen() {
        reportB = false;
        cardLayout.show(cards, "SubmitReportScreen");
        while (running) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.getMessage();
			}
		}
        running = true;
        if (homeB) {
            homeScreen();
        }
    }

    private void submitpurityreportScreen() {
        purityreportB = false;
        cardLayout.show(cards, "SubmitPurityReportScreen");
        while (running) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.getMessage();
			}
		}
        running = true;
        if (homeB) {
            homeScreen();
        }
    }

    private void waterreportsScreen() {
        waterreportB = false;
        waterreportScreen.fillData();
        cardLayout.show(cards, "WaterReportScreen");
        while (running) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.getMessage();
			}
		}
        running = true;
        if (homeB) {
            homeScreen();
        }
    }

    private void viewPurityReportScreen() {
        viewpreportB = false;
        purityreportScreen.fillData();
        cardLayout.show(cards, "ViewPurityReportScreen");
        while (running) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        running = true;
        if (homeB) {
            homeScreen();
        }
    }

    private void mapScreen() {
        mapB = false;
        Platform.runLater(() -> {
            MapView.appmap.refreshMapPins();
        });
        cardLayout.show(cards, "MapView");
        while (running) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        running = true;
        if (homeB) {
            homeScreen();
        }
    }

    private void historyScreen() {
        historyB = false;
        cardLayout.show(cards, "HistoryScreen");
        while (running) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        running = true;
        if (homeB) {
            homeScreen();
        } else if (historyReportB) {
            historyGraph();
        }
    }

    private void historyGraph() {
        historyReportB = false;
        historyGraph.refreshGraph();
        cardLayout.show(cards, "HistoryGraph");
        while (running) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.getMessage();
            }
        }
        running = true;
        if (historyReportB) {
            historyScreen();
        }
    }
}