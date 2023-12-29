 /*
 * @author ilmin cho
 * @version 1.0
 * @since 12/17/2020
 */

package testpractera;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login_primaryStage extends Application {
    
    private Stage stageDashboard;
    private Scene sceneDashboard;
    
    @Override
    public void start(Stage primaryStage) {
        
        stageDashboard = primaryStage;

        Data data = new Data();
        ArrayList<Integer> userID = new ArrayList<>();
        userID = data.getUserID();
        
        VBox vbox = new VBox(30);
        
       Text text1 = new Text("\t\t Login\n\n\t - Select User ID -");
       text1.setFont(Font.font("Abadi", FontWeight.BOLD, FontPosture.ITALIC, 30));
       text1.setFill(Color.rgb(31, 78, 121));
        
        ObservableList<Integer> obList = FXCollections.observableArrayList(userID);
        ComboBox<Integer> combo = new ComboBox<Integer>(obList);
        combo.setOnAction(e -> UserWindow.display(combo.getValue()));   
        combo.setTranslateX(90);
        combo.setMinWidth(200);
        
        BackgroundFill left_fill = new BackgroundFill(Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY); 
        Background backLeft = new Background(left_fill); 
        
        vbox.setBackground(backLeft);
        vbox.getChildren().addAll(text1, combo);
       
        sceneDashboard = new Scene(vbox, 400, 200);

        stageDashboard.setScene(sceneDashboard);
        stageDashboard.setTitle("Practera Data DashBoard");
        stageDashboard.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
