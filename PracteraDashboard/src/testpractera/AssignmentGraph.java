 /*
 * @author Ally
 * @version 1.0
 * @since 12/17/2020
 */

package testpractera;

import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

public class AssignmentGraph {
    
    final static String user14194 = "94", user14144 = "44", user14146 = "46",
    user14154 = "54", user14148 = "48", user14158 = "58",user14145 = "45",
    user14142 = "42", user14153 = "53", user14156 = "56", user14150 = "50",
    user14147 = "47", user14155 = "55", user14149 = "49", user14143 = "43",
    user14159 = "59",user14160 = "60", user14152 = "52",user14151 = "51";
    
     //category axis because it is every student
    final CategoryAxis yAxis = new CategoryAxis();
    //number axis. Every activity is a number
    final NumberAxis xAxis = new NumberAxis();
    
    public StackedBarChart<String, Number> barchart =
            new StackedBarChart<>(yAxis, xAxis);
    public XYChart.Series<String, Number> series1 =
            new XYChart.Series<>();
    public XYChart.Series<String, Number> series2 =
            new XYChart.Series<>();
   public XYChart.Series<String, Number> series3 =
            new XYChart.Series<>();
   public XYChart.Series<String, Number> series4 =
            new XYChart.Series<>();
 
   public AssignmentGraph(StackedBarChart barchart,XYChart.Series series1,
           XYChart.Series series2,XYChart.Series series3, XYChart.Series series4) {
       this.barchart = barchart;
       this.series1 = series1;
       this.series2 = series2;
       this.series3 = series3;
       this.series4 = series4;
   }
   
    public StackedBarChart graph() {
         
        //set barchart title
        barchart.setTitle("Activities");
        //set y Axis title
        yAxis.setLabel("User ID");
        //adding the array of users to categories Axis
        yAxis.setCategories(FXCollections.<String>observableArrayList(
                Arrays.asList(user14194,user14144,user14146,user14154,user14148,
                 user14158, user14145,user14142, user14153, user14156,user14150,
                 user14147, user14155,user14149,user14143,user14159, user14160,
                user14152,user14151)));
        //set x axis title
        xAxis.setLabel("Activity");
        
        //first series "Done activities"
        series1.setName("Done");
        series1.getData().add(new XYChart.Data<>(user14194,2));
        series1.getData().add(new XYChart.Data<>(user14144,2));
        series1.getData().add(new XYChart.Data<>(user14146,2));
        series1.getData().add(new XYChart.Data<>(user14154,1));
        series1.getData().add(new XYChart.Data<>(user14148,1));
        series1.getData().add(new XYChart.Data<>(user14158,2));
        series1.getData().add(new XYChart.Data<>(user14145,2));
        series1.getData().add(new XYChart.Data<>(user14142,2));
        series1.getData().add(new XYChart.Data<>(user14153,2));
        series1.getData().add(new XYChart.Data<>(user14156,2));
        series1.getData().add(new XYChart.Data<>(user14150,2));
        series1.getData().add(new XYChart.Data<>(user14147,2));
        series1.getData().add(new XYChart.Data<>(user14155,2));
        series1.getData().add(new XYChart.Data<>(user14149,2));
        series1.getData().add(new XYChart.Data<>(user14143,2));
        series1.getData().add(new XYChart.Data<>(user14159,2));
        series1.getData().add(new XYChart.Data<>(user14160,2));
        series1.getData().add(new XYChart.Data<>(user14152,2));
        
        //Second series activities that are only published
        series2.setName("Published");
        series2.getData().add(new XYChart.Data<>(user14145,1));
        
        //Third Series activities that are still being worked on
        series3.setName("In Progress");
        series3.getData().add(new XYChart.Data<>(user14154,1));
        series3.getData().add(new XYChart.Data<>(user14158,1));
        series3.getData().add(new XYChart.Data<>(user14151,1));
        
        //Fourth series activities that are done BUT pending review
        series4.setName("Pending review");
        series4.getData().add(new XYChart.Data<>(user14144,1));
        series4.getData().add(new XYChart.Data<>(user14146,1));
                      
        return barchart;
    }
}
