 /*
 * @author Mario
 * @version 1.0
 * @since 12/17/2020
 */

package testpractera;

import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class GoalsGraph {
    
    final String avg1 = "Week 1 Avg";
    final String avg2 = "Week 2 Avg";
    final String avg3 = "Week 3 Avg";
    final String avg4 = "Week 4 Avg";
    final String avg5 = "Week 5 Avg";
    final String avg6 = "Week 6 Avg";
    final String per1 = "Week 1 Per";
    final String per2 = "Week 2 Per";
    final String per3 = "Week 3 Per";
    final String per4 = "Week 4 Per";
    final String per5 = "Week 5 Per"; 
    final String per6 = "Week 6 Per";
    
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    public BarChart<String, Number> barChart =
            new BarChart<>(xAxis, yAxis);
    public XYChart.Series<String, Number> average = new XYChart.Series();
    public XYChart.Series<String, Number> personal = new XYChart.Series();
    
    public GoalsGraph(BarChart barChart, XYChart.Series average, XYChart.Series personal) {
        this.barChart = barChart;
        this.average = average;
        this.personal = personal;
    }
    
    public BarChart graph() {
           barChart.setTitle("Goals Met Per Week");
        xAxis.setLabel("Weeks");
        xAxis.setCategories(FXCollections.<String>observableArrayList(
                Arrays.asList(avg1, per1, avg2, per2, avg3, per3, avg4, per4, 
                        avg5, per5, avg6, per6)));
        yAxis.setLabel("Goals");
        
        //Average Scores
        average.setName("Average");
        average.getData().add(new XYChart.Data<>(avg1, 2));
        average.getData().add(new XYChart.Data<>(avg2, 2));
        average.getData().add(new XYChart.Data<>(avg3, 3));
        average.getData().add(new XYChart.Data<>(avg4, 4));
        average.getData().add(new XYChart.Data<>(avg5, 4));
        average.getData().add(new XYChart.Data<>(avg6, 5));
        
        //Personal scores
        personal.setName("Personal");
        personal.getData().add(new XYChart.Data<>(per1, 1));
        personal.getData().add(new XYChart.Data<>(per2, 3));
        personal.getData().add(new XYChart.Data<>(per3, 3));
        personal.getData().add(new XYChart.Data<>(per4, 4));
        personal.getData().add(new XYChart.Data<>(per5, 5));
        personal.getData().add(new XYChart.Data<>(per6, 5));
        
        return barChart;
    }
    
}
