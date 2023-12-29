/**
 * Displays historical pulse check student data from
 * Practera website in the form of pie charts
 *
 * @author Justin Gallo
 * @version 1.0
 * @since 12/17/2020
 */

package testpractera;

import javafx.stage.Modality;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;                   
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PopUp {
    
    public static void display() {
        Stage popup = new Stage();
        popup .initModality(Modality.APPLICATION_MODAL);
   
        /*******************************************************************
         * PART 1 - PULSE CHECK DATA
         * The first part of this code gathers the data
         * needed to be displayed in the pie charts
         *
         * Pulse check weekly questions:
         *  Engagement - Have you engaged with your supervisor this week?
         *  OnTrack - Do you think you are on track?
         *  Stage - Do you have everything you need to complete your work?
         *******************************************************************/
        int studentCount = 0;     // total number of students
        int teamCount = 0;        // total number of teams
        int engagementCount = 0;  // counter for the number of Engagement responses
        int engagementYes = 0;    // total number of Engagement yes responses
        int engagementNo = 0;     // total number of Engagement no responses
        int onTrackCount = 0;     // counter for the number of OnTrack responses
        int onTrackYes = 0;       // total number of OnTrack yes responses
        int onTrackNo = 0;        // total number of OnTrack no responses
        int stageCount = 0;     // counter for the number of stage responses
        int stageYes = 0;         // total number of stage yes responses
        int stageNo = 0;          // total number of stage no responses

          // Array lists to store all of the data being read
        ArrayList<Integer> studentIDs = new ArrayList<>();
        ArrayList<Integer> teamIDs = new ArrayList<>();
        ArrayList<Integer> engagementResponses = new ArrayList<>();
        ArrayList<Integer> onTrackResponses = new ArrayList<>();
        ArrayList<Integer> stageResponses = new ArrayList<>();
        // The data file with a scanner object to
        // read from it and a set delimiter
        File dataFile = new File("pulse_check_data.csv");
        
        try (Scanner input = new Scanner(dataFile)) {
        input.useDelimiter(",|\\n");
        
        // While loop storing the data in local variables
        while (input.hasNext()) {
            int stat_id = input.nextInt();
            int team_id = input.nextInt();
            int user_id = input.nextInt();
            int stat_value = input.nextInt();
            String created = input.next();

            // Prints out the data as it's being stored in each
            // local variable from the while loop (for debugging)
            /* System.out.println("stat_id = " + stat_id + " team_id = " +
                    team_id + " user_id = " + user_id + " stat_value = " +
                    stat_value + " created = " + created); */

            // If the stat_id is 8, it is a response from the Engagement
            // question. Store the response value and increment the counter.
            if (stat_id == 8) {
                engagementResponses.add(stat_value);
                engagementCount++;
            }

            // If the stat_id is 9, it is a response from the OnTrack
            // question. Store the response value and increment the counter.
            if (stat_id == 9) {
                onTrackResponses.add(stat_value);
                onTrackCount++;
            }

            // If the stat_id is 7, it is a response from the Stage
            // question. Store the response value and increment the counter.
            if (stat_id == 7) {
                stageResponses.add(stat_value);
                stageCount++;
            }

            // If the user_id is not already in the studentIDs
            // array list then add it (used for debugging)
            if (!studentIDs.contains(user_id)) {
                studentIDs.add(user_id);
                studentCount++;
            }

            // If the team_id is not already in the teamIDs
            // array list then add it (used for debugging)
            if (!teamIDs.contains(team_id)) {
                teamIDs.add(team_id);
                teamCount++;
            }
        }
       
        // Close the data file
        input.close();        
       } catch (FileNotFoundException e) {
                e.printStackTrace();
       }  
       
        // Loop through the Engagement response values and increment
        // the respective yes and no totals
        for (int i = 0; i < engagementResponses.size(); i++) {
            if (engagementResponses.get(i) == 0)
                engagementNo++;
            if (engagementResponses.get(i) == 1)
                engagementYes++;
        }

        // Calculate and store the percentages for each
        // Engagement response (used only for debugging)
        /* String engagementNoPercent = String.format("%.1f", (100.0 * engagementNo) / engagementCount);
        String engagementYesPercent = String.format("%.1f", (100.0 * engagementYes) / engagementCount); */

        // Loop through the OnTrack response values and increment
        // the respective yes and no totals
        for (int i = 0; i < onTrackResponses.size(); i++) {
            if (onTrackResponses.get(i) == 0)
                onTrackNo++;
            if (onTrackResponses.get(i) == 1)
                onTrackYes++;
        }

        // Calculate and store the percentages for each
        // OnTrack response (used only for debugging)
        /* String onTrackNoPercent = String.format("%.1f", (100.0 * onTrackNo) / onTrackCount);
        String onTrackYesPercent = String.format("%.1f", (100.0 * onTrackYes) / onTrackCount); */

        // Loop through the Stage response values and increment
        // the respective yes and no totals
        for (int i = 0; i < stageResponses.size(); i++) {
            if (stageResponses.get(i) == 0)
                stageNo++;
            if (stageResponses.get(i) == 1)
                stageYes++;
        }

        
        // Calculate and store the percentages for each
        // Stage response (used only for debugging)
        /* String stageNoPercent = String.format("%.1f", (100.0 * stageNo) / stageCount);
        String stageYesPercent = String.format("%.1f", (100.0 * stageYes) / stageCount); */

        // Prints out the data stored in the array lists (used for debugging)
        /* System.out.println("");
        System.out.println("TOTAL STUDENTS WHO RESPONDED = " + studentCount);
        System.out.println("STUDENT IDs");
        for (int i = 0; i < studentIDs.size(); i++) {
            System.out.println(studentIDs.get(i));
        }
        System.out.println("");

        System.out.println("TOTAL TEAMS WHO RESPONDED = " + teamCount);
        System.out.println("TEAM IDs");
        for (int i = 0; i < teamIDs.size(); i++) {
            System.out.println(teamIDs.get(i));
        }
        System.out.println("");
        
        System.out.println("*ENGAGMENT RESPONSES*");
        System.out.println("TOTAL = " + engagementCount);
        System.out.println("NO = " + engagementNo + " - " + engagementNoPercent);
        System.out.println("YES = " + engagementYes + " - " + engagementYesPercent);
        System.out.println("");

        System.out.println("*ONTRACK RESPONSES*");
        System.out.println("TOTAL = " + onTrackCount);
        System.out.println("NO = " + onTrackNo + " - " + onTrackNoPercent);
        System.out.println("YES = " + onTrackYes + " - " + onTrackYesPercent);
        System.out.println("");

        System.out.println("*STAGE RESPONSES*");
        System.out.println("TOTAL = " + stageCount);
        System.out.println("NO = " + stageNo + " - " + stageNoPercent);
        System.out.println("YES = " + stageYes + " - " + stageYesPercent);
        System.out.println(""); */
        

        /*******************************************************************
        * PART 2 - PIE CHART DISPLAYS
        * The second part of this uses the gathered data and
        * displays it into 3 pie charts, one for each question.
        *******************************************************************/
        /**
         * Engagement Pie Chart
         * 
         * Uses an observable list to create yes/no slices
         * from the Engagement yes/no response counts. 
         * Align the legend to the bottom and modify line lengths.
         */
        ObservableList<PieChart.Data> engagementData =
                FXCollections.observableArrayList(
                new PieChart.Data("Yes", engagementYes),
                new PieChart.Data("No", engagementNo));
        final PieChart engagementChart = new PieChart(engagementData);
        engagementChart.setLabelLineLength(10);
        engagementChart.setLegendSide(Side.BOTTOM);
        
        // Label/header to use for the engagement chart
        Label engagementHeader = new Label("Have you engaged with your\n" +
                "     supervisor this week?");
        engagementHeader.setStyle("-fx-font: 16 arial; -fx-font-weight: bold;");

        // Label format for displaying counts and percentages from mouse events
        Label engagementCaption = new Label("");
        engagementCaption.setTextFill(Color.BLACK);
        engagementCaption.setStyle("-fx-font: 13 arial; -fx-font-weight: bold;");

        // Mouse event handler displaying caption for the raw number and
        // percentages of the yes/no responses when mouse is moved over each
        // pie slice. Aligns the caption to the upper left of the window.
        for (final PieChart.Data data : engagementChart.getData()) {
            final int totalResponses = engagementCount;
            String numOfResponses = (String.format("%.0f", data.getPieValue()));
            String percentOfResponses = String.format("%.1f", (100.0 *
                    data.getPieValue()) / engagementCount);
            engagementCaption.setText(totalResponses + " Total Responses");
            data.getNode().setOnMouseMoved(e -> {
                engagementCaption.setTranslateX(0);
                engagementCaption.setTranslateY(0);
                engagementCaption.setText(totalResponses + " Total Responses\n" +
                        " " + numOfResponses + " " + data.getName() +
                        " (" + percentOfResponses + "%) ");
            });
        }
        
        /**
         * OnTrack Pie Chart
         * 
         * Uses an observable list to create yes/no slices
         * from the OnTrack yes/no response counts. 
         * Align the legend to the bottom and modify line lengths.
         */
        ObservableList<PieChart.Data> onTrackData =
                FXCollections.observableArrayList(
                new PieChart.Data("Yes", onTrackYes),
                new PieChart.Data("No", onTrackNo));
        final PieChart onTrackChart = new PieChart(onTrackData);
        onTrackChart.setLabelLineLength(10);
        onTrackChart.setLegendSide(Side.BOTTOM);
        
        // Label/header to use for the stage chart
        Label onTrackHeader = new Label("Do you think you are on track?");
        onTrackHeader.setStyle("-fx-font: 16 arial; -fx-font-weight: bold;");
        
        // Label format for displaying counts and percentages from mouse events
        Label onTrackCaption = new Label("");
        onTrackCaption.setTextFill(Color.BLACK);
        onTrackCaption.setStyle("-fx-font: 13 arial; -fx-font-weight: bold;");

        // Mouse event handler displaying caption for the raw number and
        // percentages of the yes/no responses when mouse is moved over each
        // pie slice. Aligns the caption to the upper left of the window.
        for (final PieChart.Data data : onTrackChart.getData()) {
            final int totalResponses = onTrackCount;
            String numOfResponses = (String.format("%.0f", data.getPieValue()));
            String percentOfResponses = String.format("%.1f", (100.0 *
                    data.getPieValue()) / onTrackCount);
            onTrackCaption.setText(totalResponses + " Total Responses");
            data.getNode().setOnMouseMoved(e -> {
                onTrackCaption.setTranslateX(0);
                onTrackCaption.setTranslateY(0);
                onTrackCaption.setText(totalResponses + " Total Responses\n" +
                        " " + numOfResponses + " " + data.getName() +
                        " (" + percentOfResponses + "%) "); 
            });
        }
        
        /**
         * Stage Pie Chart
         * 
         * Uses an observable list to create yes/no slices
         * from the Stage yes/no response counts. 
         * Align the legend to the bottom and modify line lengths.
         */
        ObservableList<PieChart.Data> stageData =
                FXCollections.observableArrayList(
                new PieChart.Data("Yes", stageYes),
                new PieChart.Data("No", stageNo));
        final PieChart stageChart = new PieChart(stageData);
        stageChart.setLabelLineLength(10);
        stageChart.setLegendSide(Side.BOTTOM);
        
        // Label/header to use for the stage chart
        Label stageHeader = new Label("Do you have everything you\n" +
                "need to complete your work?");
        stageHeader.setStyle("-fx-font: 16 arial; -fx-font-weight: bold;");
 
        // Label format for displaying counts and percentages from mouse events
        Label stageCaption = new Label("");
        stageCaption.setTextFill(Color.BLACK);
        stageCaption.setStyle("-fx-font: 13 arial; -fx-font-weight: bold;");

        // Mouse event handler displaying caption for the raw number and
        // percentages of the yes/no responses when mouse is moved over each
        // pie slice. Aligns the caption to the upper left of the window.
        for (final PieChart.Data data : stageChart.getData()) {
            final int totalResponses = stageCount;
            String numOfResponses = (String.format("%.0f", data.getPieValue()));
            String percentOfResponses = String.format("%.1f", (100.0 *
                    data.getPieValue()) / stageCount);
            stageCaption.setText(totalResponses + " Total Responses");
            data.getNode().setOnMouseMoved(e -> {
                stageCaption.setTranslateX(0);
                stageCaption.setTranslateY(0);
                stageCaption.setText(totalResponses + " Total Responses\n" +
                        " " + numOfResponses + " " + data.getName() +
                        " (" + percentOfResponses + "%) "); 
            });
        }
        
 
        // Pane for the Engagement pie chart and mouse event caption
        Pane engagementPane = new Pane();
        engagementChart.setMaxSize(300, 300);
        engagementPane.getChildren().addAll(engagementChart, engagementCaption);
        
        // Pane for the OnTrack pie chart and mouse event caption
        Pane onTrackPane = new Pane();
        onTrackChart.setMaxSize(300, 300);
        onTrackPane.getChildren().addAll(onTrackChart, onTrackCaption);
        
        // Pane for the Stage pie chart and mouse event caption
        Pane stagePane = new Pane();
        stageChart.setMaxSize(300, 300);
        stagePane.getChildren().addAll(stageChart, stageCaption);
        
        // Grid pane to hold each pie chart pane and their header labels
        GridPane pieGrid = new GridPane();
        pieGrid.setHgap(30);
        pieGrid.setVgap(15);
        pieGrid.setPadding(new Insets(0, 10, 0, 10));
       
        // Col 1, Row 1 - Engagement header
        pieGrid.add(engagementHeader, 0, 0);
        GridPane.setHalignment(engagementHeader, HPos.CENTER);
        
        // Col 1, Row 2 - Engagement pane containing pie chart and mouse caption
        pieGrid.add(engagementPane, 0, 1);
        
        // Col 1, Row 3 - OnTrack header
        pieGrid.add(onTrackHeader, 0, 2);
        GridPane.setHalignment(onTrackHeader, HPos.CENTER);
        
        // Col 1, Row 4 - OnTrack pane containing pie chart and mouse caption
        pieGrid.add(onTrackPane, 0, 3);
        
        // Col 2, Row 1 - Stage header
        pieGrid.add(stageHeader, 1, 0);
        GridPane.setHalignment(stageHeader, HPos.CENTER);
        
        // Col 2, Row 2 - Stage pane containing pie chart and mouse caption
        pieGrid.add(stagePane, 1, 1);
        
        // Set the scene with the grid pane, dimensions, and apply CSS format
        Scene pieScene = new Scene(pieGrid);
        pieScene.getStylesheets().add("pulse_style.css");
        
       // Set the stage title and dimensions, add the scene and display it
       popup.setTitle("Pulse Check Responses");
       popup.setWidth(600);
       popup.setHeight(700);
       popup.setScene(pieScene);
       popup.show();
           
    }

}
