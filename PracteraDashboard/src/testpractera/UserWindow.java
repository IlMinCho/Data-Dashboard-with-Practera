 /*
 * @author ilmin cho
 * @version 1.0
 * @since 12/17/2020
 */

package testpractera;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class UserWindow {
   
    private static Scene sceneDashboard;
    
    public static void display(int userID) {
      
        Stage stageDashboard = new Stage();
        stageDashboard.initModality(Modality.APPLICATION_MODAL);
        Dashboard dashboard = new Dashboard(stageDashboard,sceneDashboard,userID);
       
        sceneDashboard = dashboard.setting();

        stageDashboard.setScene(sceneDashboard);
        stageDashboard.setTitle("Practera_Data Dashboard");
        stageDashboard.show();
    }
    
}
