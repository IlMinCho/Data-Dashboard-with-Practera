 /*
 * @author ilmin cho
 * @version 1.0
 * @since 12/17/2020
 */

package testpractera;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class AveageAllProgress {
    private GridPane grid = new GridPane();
    private double avgAllMyProgress = 0;
    private double avgAllTeamProgress = 0;
    
    public AveageAllProgress() {}
    public AveageAllProgress(GridPane gp) {
        this.grid = gp;
        grid.setPadding(new Insets(20,20,20,0));
        settingList();
    }
    
    public void settingList() {
        Data data = new Data();
        avgAllMyProgress = data.getAvgAllMyProgess();
        avgAllTeamProgress = data.getAvgAllTeamProgess();
        
       Text textMyProgress = new Text("\n* Average My progress of all user \n\tin class\t\t\n  \t\t== "+avgAllMyProgress);
       textMyProgress.setFont(Font.font("Abadi", FontWeight.BOLD, FontPosture.ITALIC, 20));
       textMyProgress.setFill(Color.rgb(31, 78, 121));
       Text textTeamProgress = new Text("\n* Average Team progress of all teams \n\tin class\t\t\n  \t\t== "+avgAllTeamProgress);
       textTeamProgress.setFont(Font.font("Abadi", FontWeight.BOLD, FontPosture.ITALIC, 20));
       textTeamProgress.setFill(Color.rgb(31, 78, 121));
       Text textRecommend = new Text("\n-----------------------------------------------------------\n\n "
               + "( If your progress is higher than average, \n\tit would be better if you could help\n\t your team members or classmates. )\n\n"
               + "( If your progress is lower than average, \n\tyou can get good results if you try\n\t a little more in this class. )\n\n"
               + "-----------------------------------------------------------\n");
       textRecommend.setFont(Font.font("Abadi", FontWeight.BOLD, FontPosture.ITALIC, 20));
       textRecommend.setFill(Color.LIGHTSLATEGREY);
      
        VBox vbox = new VBox(25);
        vbox.setMinWidth(100);
        BackgroundFill left_fill = new BackgroundFill(Color.rgb(255, 255, 255, 0.5), CornerRadii.EMPTY, Insets.EMPTY); 
        Background backLeft = new Background(left_fill); 
        vbox.setBackground(backLeft);
        vbox.getChildren().addAll(textMyProgress,textTeamProgress,textRecommend);
        
         grid.add(vbox,1,1);
    }
    
    public GridPane getGrid() {return grid;}
}
