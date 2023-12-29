 /*
 * @author ilmin cho
 * @version 1.0
 * @since 12/17/2020
 */

package testpractera;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TeamMember {
    private int userID = 14146;
    
    private GridPane grid = new GridPane();
    private int teamID = 0;
    private int numTeamMember = 0;
    private ArrayList<Integer> teamMemberID = new ArrayList<>();
    
    public TeamMember() {};
    public TeamMember(GridPane gp, int userID) {
        grid = gp;
        grid.setHgap(30);
        grid.setVgap(50);
        grid.setPadding(new Insets(30,30,30,30));
        grid.getColumnConstraints().add(new ColumnConstraints(10));
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getColumnConstraints().add(new ColumnConstraints(150));
        grid.getRowConstraints().add(new RowConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(200));
        grid.getRowConstraints().add(new RowConstraints(100));
        grid.getRowConstraints().add(new RowConstraints(100));
        
        this.userID = userID;
        settingTeam();
    }
    
    public void settingTeam() {
        Data data = new Data(userID);
        teamID = data.getUserTeamID();
        numTeamMember = data.getNumTeamMember();
        teamMemberID = data.getTeamMemberID();
        
       Text titleMain = new Text("BHCC CSC239-01 - Team: "+teamID);     
       titleMain.setFont(Font.font("Abadi", FontWeight.BOLD, FontPosture.ITALIC, 30));
       titleMain.setFill(Color.rgb(31, 78, 121));
       grid.add(titleMain, 0, 0);    
       
       
       for ( int i=0; i <numTeamMember; i++){
           ImageView imageMember = new ImageView();
           imageMember = new ImageView(new Image("file:Member.png"));
           
           grid.add(imageMember,i+1,1);
       }
       
       VBox vboxMemberID = new VBox(25);
       vboxMemberID.setMinWidth(600);
       BackgroundFill left_fill = new BackgroundFill(Color.rgb(201, 202, 208, 0.2), CornerRadii.EMPTY, Insets.EMPTY); 
       Background backLeft = new Background(left_fill); 
       vboxMemberID.setBackground(backLeft);
       for( int i=0; i<teamMemberID.size(); i++){
            Text memberID = new Text("Team Member ID: " + teamMemberID.get(i));
            memberID .setFont(Font.font("Abadi", FontWeight.BOLD, FontPosture.ITALIC, 30));
            memberID .setFill(Color.rgb(31, 78, 121));
            vboxMemberID.getChildren().add(memberID);
       }
       grid.add(vboxMemberID,1,3);
    
    }
    
    public GridPane getGrid() {return grid;};
    
}
