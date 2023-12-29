 /*
 * @author ilmin cho
 * @version 1.0
 * @since 12/17/2020
 */

package testpractera;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Dashboard {
    
    private Stage dashboard;
    private Scene sceneMain, sceneAssignment, sceneTeam;
    private VBox menu1 = new VBox();
    private VBox menu2 = new VBox();
    private VBox menu3 = new VBox();
    private int userID = 14146;
    
    // Ally 
    private CategoryAxis yAxis1 = new CategoryAxis();
    private NumberAxis xAxis1 = new NumberAxis();
    private StackedBarChart<String, Number> assignBarchart =
            new StackedBarChart<>(yAxis1, xAxis1);
    private XYChart.Series<String, Number> series1 =
            new XYChart.Series<>();
    private XYChart.Series<String, Number> series2 =
            new XYChart.Series<>();
    private XYChart.Series<String, Number> series3 =
            new XYChart.Series<String, Number>();
    private XYChart.Series<String, Number> series4 =
            new XYChart.Series<>();
    
    // Mario
    private CategoryAxis xAxis2 = new CategoryAxis();
    private NumberAxis yAxis2 = new NumberAxis();
    private BarChart<String, Number> goalsBarchart =
            new BarChart<>(xAxis2, yAxis2);
    private XYChart.Series<String, Number> average = new XYChart.Series();
    private XYChart.Series<String, Number> personal = new XYChart.Series();

    
    public Dashboard(Stage dashboard, Scene main, int userID) {
       this.userID = userID;
       this.dashboard = dashboard;
       sceneMain = main;
       settingMenu();
    }
   
    public Scene setting() {
        
    // Main   
       GridPane gp1 = new GridPane();
       Progress progress = new Progress(gp1, userID);
       gp1 = progress.getGrid();
       gp1.setMaxHeight(450);
       gp1.setMaxWidth(450);
       
       GridPane gp2 = new GridPane();
       AveageAllProgress allProgress = new AveageAllProgress(gp2);
       gp2 = allProgress.getGrid();
       
       BorderPane borderPane1 = new BorderPane();
       borderPane1.setCenter(gp1);
       borderPane1.setLeft(menu1);
       borderPane1.setRight(gp2);

       BackgroundFill main_fill = new BackgroundFill(Color.rgb(228,239,255), CornerRadii.EMPTY, Insets.EMPTY); 
       Background backMain = new Background(main_fill); 
       borderPane1.setBackground(backMain);
       
       sceneMain = new Scene(borderPane1, 1000, 700);
       

       // Assignment
       AssignmentGraph assignmentGraph = new AssignmentGraph(assignBarchart,series1,series2,series3,series4);
       assignBarchart = assignmentGraph.graph();
       assignBarchart.setMaxHeight(750);
       assignBarchart.setMaxWidth(750);

       GoalsGraph goalsGraph = new GoalsGraph(goalsBarchart,average,personal);
       goalsBarchart = goalsGraph.graph();
       goalsBarchart.setMaxHeight(650);
       goalsBarchart.setMaxWidth(600);
       
       HBox chartHBox = new HBox(30);
       chartHBox.getChildren().addAll(goalsBarchart,assignBarchart);
       
       BorderPane borderPane2 = new BorderPane();
       borderPane2.setLeft(menu2);
       borderPane2.setCenter(goalsBarchart);
       borderPane2.setRight(assignBarchart);
       
       BackgroundFill main_fill2 = new BackgroundFill(Color.rgb(228,239,255), CornerRadii.EMPTY, Insets.EMPTY); 
       Background backMain2 = new Background(main_fill2); 
       borderPane2.setBackground(backMain2);
       
       sceneAssignment = new Scene(borderPane2, 1000, 700);
       sceneAssignment.getStylesheets().add("style.css");
       goalsBarchart.getData().addAll(average, personal);
       assignBarchart.getData().addAll(series1, series2,series3,series4);
       

       // Team      
       GridPane gp3 = new GridPane();
       TeamMember teamMember = new TeamMember(gp3, userID);
       gp3 = teamMember.getGrid();
       
       GridPane teamGrid = new GridPane();
       TeamBadges teamBadges = new TeamBadges(teamGrid);
       teamGrid = teamBadges.badges();
       teamGrid.setAlignment(Pos.CENTER_LEFT);
       teamGrid.setMaxSize(650,525);    

       BorderPane borderPane3 = new BorderPane();
       borderPane3.setLeft(menu3);
       borderPane3.setCenter(teamGrid);
       
       BackgroundFill main_fill3 = new BackgroundFill(Color.rgb(228,239,255), CornerRadii.EMPTY, Insets.EMPTY); 
       Background backMain3 = new Background(main_fill3); 
       borderPane3.setBackground(backMain3);
       
       sceneTeam = new Scene(borderPane3, 1000, 700);
       
        return sceneMain;
    }
    

    public void settingMenu() {
       
       //Main
       Text text1 = new Text("Main");
       text1.setFont(Font.font("Abadi", FontWeight.BOLD, FontPosture.ITALIC, 15));
       text1.setFill(Color.rgb(31, 78, 121));
       
       Image image1 = new Image("file:Profile.png");
       ImageView profile1 = new ImageView(image1);
       
       Text user1 = new Text(Integer.toString(userID));     
       user1.setFont(Font.font("Abadi", FontWeight.BOLD, FontPosture.ITALIC, 15));
       user1.setFill(Color.rgb(31, 78, 121));
       
       Image main1 = new Image("file:Main.png");
       Button buttonHome1 = new Button("",new ImageView(main1));
       buttonHome1.setOnAction(e->dashboard.setScene(sceneMain));
       
       Image assignment1 = new Image("file:Assignment.png");
       Button buttonAssignment1 = new Button("",new ImageView(assignment1));
       buttonAssignment1.setOnAction(e->dashboard.setScene(sceneAssignment));
       
       Image team1= new Image("file:Team.png");
       Button buttonTeam1 = new Button("", new ImageView(team1));
       buttonTeam1.setOnAction(e->dashboard.setScene(sceneTeam));
       
       Image popup1= new Image("file:Popup.png");
       Button buttonPopup1 = new Button("", new ImageView(popup1));                 
       buttonPopup1.setOnAction(e -> PopUp.display());
       
       BackgroundFill left_fill1 = new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY); 
       Background backLeft1 = new Background(left_fill1); 
       
       menu1 = new VBox(20);
       menu1.setBackground(backLeft1);
       menu1.getChildren().addAll(text1, profile1,user1,buttonHome1, buttonAssignment1, buttonTeam1, buttonPopup1);
    
       
       
        // Assignment
       Text text2 = new Text("Task");
       text2.setFont(Font.font("Abadi", FontWeight.BOLD, FontPosture.ITALIC, 15));
       text2.setFill(Color.rgb(31, 78, 121));
       
       Image image2 = new Image("file:Profile.png");
       ImageView profile2 = new ImageView(image1);
       
       Text user2 = new Text(Integer.toString(userID));        
       user2.setFont(Font.font("Abadi", FontWeight.BOLD, FontPosture.ITALIC, 15));
       user2.setFill(Color.rgb(31, 78, 121));
       
       Image main2 = new Image("file:Main.png");
       Button buttonHome2 = new Button("",new ImageView(main2));
       buttonHome2.setOnAction(e->dashboard.setScene(sceneMain));
       
       Image assignment2 = new Image("file:Assignment.png");
       Button buttonAssignment2 = new Button("",new ImageView(assignment2));
       buttonAssignment2.setOnAction(e->dashboard.setScene(sceneAssignment));
       
       Image team2= new Image("file:Team.png");
       Button buttonTeam2 = new Button("", new ImageView(team2));
       buttonTeam2.setOnAction(e->dashboard.setScene(sceneTeam));
       
       Image popup2= new Image("file:Popup.png");
       Button buttonPopup2 = new Button("", new ImageView(popup2));                 
       buttonPopup2.setOnAction(e -> PopUp.display());
       
       BackgroundFill left_fill2 = new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY); 
       Background backLeft2 = new Background(left_fill2); 
       
       menu2 = new VBox(20);
       menu2.setBackground(backLeft2);
       menu2.getChildren().addAll(text2, profile2,user2,buttonHome2, buttonAssignment2, buttonTeam2, buttonPopup2);
       
       
        // Team
       Text text3 = new Text("Team");
       text3.setFont(Font.font("Abadi", FontWeight.BOLD, FontPosture.ITALIC, 15));
       text3.setFill(Color.rgb(31, 78, 121));
       
       Image image3 = new Image("file:Profile.png");
       ImageView profile3 = new ImageView(image3);
       
       Text user3 = new Text(Integer.toString(userID));       
       user3.setFont(Font.font("Abadi", FontWeight.BOLD, FontPosture.ITALIC, 15));
       user3.setFill(Color.rgb(31, 78, 121));
       
       Image main3 = new Image("file:Main.png");
       Button buttonHome3 = new Button("",new ImageView(main3));
       buttonHome3.setOnAction(e->dashboard.setScene(sceneMain));
       
       Image assignment3 = new Image("file:Assignment.png");
       Button buttonAssignment3 = new Button("",new ImageView(assignment3));
       buttonAssignment3.setOnAction(e->dashboard.setScene(sceneAssignment));
       
       Image team3= new Image("file:Team.png");
       Button buttonTeam3 = new Button("", new ImageView(team3));
       buttonTeam3.setOnAction(e->dashboard.setScene(sceneTeam));
       
       Image popup3= new Image("file:Popup.png");
       Button buttonPopup3 = new Button("", new ImageView(popup3));                 
       buttonPopup3.setOnAction(e -> PopUp.display());
       
       BackgroundFill left_fill3 = new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY); 
       Background backLeft3 = new Background(left_fill3); 
       
       menu3 = new VBox(20);
       menu3.setBackground(backLeft3);
       menu3.getChildren().addAll(text3, profile3,user3,buttonHome3, buttonAssignment3, buttonTeam3, buttonPopup3);
    }
}
