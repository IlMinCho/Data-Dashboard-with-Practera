 /*
 * @author Jose
 * @version 1.0
 * @since 12/17/2020
 */

package testpractera;

import testpractera.groupbadges.FileHandling;
import testpractera.groupbadges.Member;
import testpractera.groupbadges.Team;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import java.util.ArrayList;

public class TeamBadges {
    
    public GridPane gridPane;

    private final int col = 6;
    private final int rows = 5;

    private ArrayList<Team> teams = new ArrayList<>();

    private final String file_path = "src/testpractera/groupbadges/dataFile/"; 
    private final String file_name = "team.txt";

    Image platinum = new Image("file:src/testpractera/groupbadges/images/platinum.jpg");
    Image gold = new Image("file:src/testpractera/groupbadges/images/gold.jpg");
    Image silver = new Image("file:src/testpractera/groupbadges/images/silver.jpg");
    Image bronze = new Image("file:src/testpractera/groupbadges/images/bronze.jpg");
    Image iron = new Image("file:src/testpractera/groupbadges/images/iron.jpg");
    
    
    public TeamBadges(GridPane gp) {
        gridPane = gp;
    } 
    
    public GridPane badges() {
        read_data();
        
        gridPane = new GridPane();
        gridPane.setGridLinesVisible(false);
        gridPane.setPrefWidth(500);
        gridPane.setPrefHeight(680);
        gridPane.setStyle("-fx-background-color: white;");

        for(int i = 0; i< col; i++){
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(100.0 / col);
            gridPane.getColumnConstraints().add(columnConstraints);
        }

        for(int i = 0; i < teams.size(); i++){
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(100.0/ rows);
            gridPane.getRowConstraints().add(rowConstraints);
        }
//        System.out.println("team size "+teams.size());
        for(int index = 0; index < teams.size(); index++) {
            Label label = new Label(teams.get(index).getId());
            label.setFont(Font.font("Bell MT", 20));
            label.setPrefWidth(50);
            label.setPrefHeight(90);
            label.setAlignment(Pos.CENTER);
//            System.out.println("index: "+index+ "\t"+label.getText());

            ArrayList<Node> nodes = new ArrayList<>();

            nodes.add(label);

            teams.get(index).members.forEach(member -> {
                ImageView imageView = new ImageView();
                imageView.setFitWidth(60);
                imageView.setFitHeight(80);

                if(member.getScore() >= .9)
                    imageView.setImage(platinum);
                else if(member.getScore() >= .8)
                    imageView.setImage(gold);
                else if(member.getScore() >= .7)
                    imageView.setImage(silver);
                else if(member.getScore() >= .6)
                    imageView.setImage(bronze);
                else if (member.getScore()>= 0.0)
                    imageView.setImage(iron);

                nodes.add(imageView);
            });


            gridPane.addRow(index,nodes.toArray(new Node[0]));
        }

        // each cell 16.6.. width and 20 height

        /*for(int i = 0; i< col; i++){
            for(int j = 0; j< rows; j++){

                if(i == 0) {
                    Label label = new Label(teams[i][j]);
                    label.setFont(Font.font("Bell MT", 24));
                    label.setPrefWidth(134);
                    label.setPrefHeight(83);
                    label.setAlignment(Pos.CENTER);

                    gridPane.add(label, i, j, 1, 1);
                }else {

                    ImageView imageView = new ImageView();
                    imageView.setImage(new Image(teams[i][j]));
                    imageView.setFitWidth(101);
                    imageView.setFitHeight(80);

                    gridPane.add(imageView, i, j, 1, 1);
                }
            }
        }*/
        
        return gridPane;
    }
    
    public void read_data(){
        FileHandling fileHandling = new FileHandling(file_path,file_name);
        if(fileHandling.load()){
            fileHandling.reader.nextLine();
            while(fileHandling.reader.hasNext()){
                String[] team = fileHandling.reader.nextLine().split(",");
       //         System.out.println("this row of values: "+team[0]+"\t"+team[1]+"\t"+team[2]);

                boolean match = false;

                for(Team t : teams){
         //           System.out.println(teams.size()+"\t"+t.getId()+" equals to "+team[0] +t.getId().equals(team[0]));
                    if(t.getId().equals(team[0])){
         //               System.out.println("In "+t.getId().equals(team[0]));
                        t.add_member(new Member(team[1], Double.parseDouble(team[2])));
                        match = true;
                    }
                }
                if(!match){
                    Team tm = new Team();
                    
                    tm.setId(team[0]);
                    tm.add_member(new Member(team[1], Double.parseDouble(team[2])));
                    teams.add(tm);
                }
            }
        }
    }

    
}
    

