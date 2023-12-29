 /*
 * @author ilmin cho
 * @version 1.0
 * @since 12/17/2020
 */

package testpractera;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Progress {
    
    private int userID = 14146;
    
    private GridPane grid = new GridPane();
    private double individualData = 0;
    private double teamData = 0; 
    
    public Progress() {};
    public Progress(GridPane gp, int userID) {
        grid = gp;
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(15,15,15,15));
        grid.getColumnConstraints().add(new ColumnConstraints(20));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getColumnConstraints().add(new ColumnConstraints(200));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(200));
        grid.getRowConstraints().add(new RowConstraints(200));
        
        this.userID = userID;
        settingProgress();
    }
    
    public void settingProgress() {
        
       Text titleMain = new Text("BHCC CSC239-01");     
       titleMain.setFont(Font.font("Abadi", FontWeight.BOLD, FontPosture.ITALIC, 25));
       titleMain.setFill(Color.rgb(31, 78, 121));
       Text textMy = new Text("\tMy Progress");    
       textMy.setFont(Font.font("Abadi", FontWeight.BOLD, 25));
       textMy.setFill(Color.rgb(31, 78, 121));
       Text textTeam = new Text("  Team Progress");    
       textTeam.setFont(Font.font("Abadi", FontWeight.BOLD, 25));
       textTeam.setFill(Color.rgb(31, 78, 121));
       
       ImageView imageView = new ImageView();
       ImageView imageView2 = new ImageView();
       
       Data data = new Data(userID);
       individualData = data.getMyProgress(userID);    
       teamData = data.getTeamProgress(userID);
       individualData = convertData(individualData);
       teamData = convertData(teamData);
       
       switch((int)individualData){
        case 5: 
            imageView = new ImageView(new Image("file:5.png"));
            break;
        case 10: 
            imageView = new ImageView(new Image("file:10.png"));
            break;
        case 15: 
            imageView = new ImageView(new Image("file:15.png"));
            break;
        case 20: 
            imageView = new ImageView(new Image("file:20.png"));
            break;
        case 25: 
            imageView = new ImageView(new Image("file:25.png"));
            break;
        case 30: 
            imageView = new ImageView(new Image("file:30.png"));
            break;
        case 35: 
            imageView = new ImageView(new Image("file:35.png"));
            break;
        case 40: 
            imageView = new ImageView(new Image("file:40.png"));
            break;
        case 45: 
            imageView = new ImageView(new Image("file:45.png"));
            break;
        case 50: 
            imageView = new ImageView(new Image("file:50.png"));
            break;
        case 55: 
            imageView = new ImageView(new Image("file:55.png"));
            break;
        case 60: 
            imageView = new ImageView(new Image("file:60.png"));
            break;
        case 65: 
            imageView = new ImageView(new Image("file:65.png"));
            break;
        case 70: 
            imageView = new ImageView(new Image("file:70.png"));
            break;
        case 75: 
            imageView = new ImageView(new Image("file:75.png"));
            break;
        case 80: 
            imageView = new ImageView(new Image("file:80.png"));
            break;
        case 85: 
            imageView = new ImageView(new Image("file:85.png"));
            break;
        case 90: 
            imageView = new ImageView(new Image("file:90.png"));
            break;
        case 95: 
            imageView = new ImageView(new Image("file:95.png"));
            break;
         case 100: 
            imageView = new ImageView(new Image("file:100.png"));
            break;
        default :
            imageView = new ImageView(new Image("file:0.png"));
            break;
    }
       
       switch((int)teamData){
        case 5: 
            imageView2 = new ImageView(new Image("file:5.png"));
            break;
        case 10: 
            imageView2 = new ImageView(new Image("file:10.png"));
            break;
        case 15: 
            imageView2 = new ImageView(new Image("file:15.png"));
            break;
        case 20: 
            imageView2 = new ImageView(new Image("file:20.png"));
            break;
        case 25: 
            imageView2 = new ImageView(new Image("file:25.png"));
            break;
        case 30: 
            imageView2 = new ImageView(new Image("file:30.png"));
            break;
        case 35: 
            imageView2 = new ImageView(new Image("file:35.png"));
            break;
        case 40: 
            imageView2 = new ImageView(new Image("file:40.png"));
            break;
        case 45: 
            imageView2 = new ImageView(new Image("file:45.png"));
            break;
        case 50: 
            imageView2 = new ImageView(new Image("file:50.png"));
            break;
        case 55: 
            imageView2 = new ImageView(new Image("file:55.png"));
            break;
        case 60: 
            imageView2 = new ImageView(new Image("file:60.png"));
            break;
        case 65: 
            imageView2 = new ImageView(new Image("file:65.png"));
            break;
        case 70: 
            imageView2 = new ImageView(new Image("file:70.png"));
            break;
        case 75: 
            imageView2 = new ImageView(new Image("file:75.png"));
            break;
        case 80: 
            imageView2 = new ImageView(new Image("file:80.png"));
            break;
        case 85: 
            imageView2 = new ImageView(new Image("file:85.png"));
            break;
        case 90: 
            imageView2 = new ImageView(new Image("file:90.png"));
            break;
        case 95: 
            imageView2 = new ImageView(new Image("file:95.png"));
            break;
         case 100: 
            imageView2 = new ImageView(new Image("file:100.png"));
            break;
        default :
            imageView2 = new ImageView(new Image("file:0.png"));
            break;
    }
       
       StackPane myContent = new StackPane();
       Text textMyContent = new Text("My Progress\n- percentage of completion\n\t among all assignments -");
       textMyContent.setFont(Font.font("Abadi", FontWeight.BOLD, FontPosture.ITALIC, 15));
       textMyContent.setFill(Color.rgb(31, 78, 121));
       
       Rectangle myBox = new Rectangle(25,25,250,100);
       myBox.setFill(Color.rgb(201, 202, 208, 0.4));
       myContent.getChildren().addAll(myBox,textMyContent);
        
       StackPane teamContent = new StackPane();
       Text textTeamContent = new Text("Team Progress\n- percentage of completion\n\t among all team assignments -");
       textTeamContent.setFont(Font.font("Abadi", FontWeight.BOLD, FontPosture.ITALIC, 15));
       textTeamContent.setFill(Color.rgb(31, 78, 121));
       
       Rectangle teamBox = new Rectangle(25,25,250,100);
       teamBox.setFill(Color.rgb(201, 202, 208,0.4));
       teamContent.getChildren().addAll(teamBox,textTeamContent);
       
       Line line = new Line(0, 0, 0, 5000);
       line.setStrokeWidth(2);
       line.setStroke(Color.rgb(31, 78, 121,0.05));
       
       imageView.setFitHeight(250);
       imageView.setFitWidth(250);
       imageView.setPreserveRatio(true);
       imageView2.setFitHeight(250);
       imageView2.setFitWidth(250);
       imageView2.setPreserveRatio(true);
            
       grid.add(titleMain, 0, 0);
       grid.add(line,5,0);
       grid.add(textMy, 0,1);
       grid.add(textTeam, 2,1);
       grid.add(imageView, 0,2);
       grid.add(imageView2, 2,2);
       grid.add(myContent, 0,3);
       grid.add(teamContent, 2,3);

    }

    public double convertData(double data) {
        if (data >=0 && data<5) { data = 0;}
        else if (data >=5 && data<10) { data = 5;}
        else if (data >=10 && data<15) { data = 10;}
        else if (data >=15 && data<20) { data = 15;}
        else if (data >=20 && data<25) { data = 20;}
        else if (data >=25 && data<30) { data = 25;}
        else if (data >=30 && data<35) { data = 30;}
        else if (data >=35 && data<40) { data = 35;}
        else if (data >=40 && data<45) { data = 40;}
        else if (data >=45 && data<50) { data = 45;}
        else if (data >=50 && data<55) { data = 50;}
        else if (data >=55 && data<60) { data = 55;}
        else if (data >=60 && data<65) { data = 60;}
        else if (data >=65 && data<70) { data = 65;}
        else if (data >=70 && data<75) { data = 70;}
        else if (data >=75 && data<80) { data = 75;}
        else if (data >=80 && data<85) { data = 80;}
        else if (data >=85 && data<90) { data = 85;}
        else if (data >=90 && data<95) { data = 90;}
        else if (data >=95 && data<100) { data = 95;}
        else if (data == 100) { data = 100;}
        
        double convertData = data;
        return convertData;
    }
    
    public GridPane getGrid() {return grid;}

}
