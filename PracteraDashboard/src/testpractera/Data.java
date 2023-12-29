 /*
 * @author ilmin cho
 * @version 1.0
 * @since 12/17/2020
 */

package testpractera;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    
    private int userID = 14146;
    
    private File file_submission = new File("Data_Submissions.txt");
    private File file_enrollment = new File("Data_Enrollment.txt");
    private ArrayList<Integer> submitter_id = new ArrayList<>();
    private ArrayList<String> status = new ArrayList<>();
    private ArrayList<Integer> assessment_id = new ArrayList<>();
    private ArrayList<Integer> team_sub = new ArrayList<>();
    private int numAssessment = 0;
    
    private ArrayList<Integer> user_id = new ArrayList<>();
    private ArrayList<Integer> team_enroll = new ArrayList<>();
    private ArrayList<String> role = new ArrayList<>();
    private int numID = 0;
    private int numTeam = 0;
    
    public Data(){ dataFromFile(); }
    public Data(int userID){ dataFromFile(); this.userID = userID; }
    
    
    // overall data from the file
    public void dataFromFile() {
        
        try (Scanner sc = new Scanner(file_submission)) {
              skipLine(sc, 1); 
              while ( sc.hasNext()) {
              submitter_id.add(sc.nextInt());
              status.add(sc.next());
              assessment_id.add(sc.nextInt());
              team_sub.add(sc.nextInt());
              }
              //checking duplicated values
              ArrayList<Integer> checkDup = new ArrayList<Integer>();
              for ( int nonDup : assessment_id) {
                  if(!checkDup.contains(nonDup)) { checkDup.add(nonDup);}
              }
              numAssessment = checkDup.size();
              
              sc.close();
              
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }  
        
        try (Scanner sc = new Scanner(file_enrollment)) {
              skipLine(sc, 1); 
              while ( sc.hasNext()) {
                  user_id.add(sc.nextInt());
                  team_enroll.add(sc.nextInt());
                  role.add(sc.next());
                  numID++; numTeam++;
              }
              //checking duplicated values
              ArrayList<Integer> checkDup = new ArrayList<Integer>();
              for ( int nonDup : team_enroll) {
                  if(!checkDup.contains(nonDup)) { checkDup.add(nonDup);
                  }
              }
              numTeam = checkDup.size();
              
              sc.close();
                   
         } catch (FileNotFoundException e) {
                e.printStackTrace();
         }  
    } 
    public void skipLine(Scanner sc,int lineNum){
           for(int i = 0; i < lineNum;i++){
               if(sc.hasNextLine())sc.nextLine();
           }
    }
    
    
    //Progress part
    public double getMyProgress(int userID) {
        int doneTask =  0;
        double myprogress = 0;
        
        for(int i=0; i<submitter_id.size(); i++) {
            if(submitter_id.get(i) == userID) {
                if(status.get(i).equals("done") || status.get(i).equals("pendingreview") || status.get(i).equals("published")){
                    doneTask++;
                }
            }
        }
     
        myprogress = ((double)doneTask/numAssessment) * 100;
        return myprogress;
    }
    public double getTeamProgress(int userID) {
        int doneTask =  0;
        int numTeamAssess = 0;
        double teamprogress = 0;
        
         for(int i=0; i<submitter_id.size(); i++) {
            if(submitter_id.get(i) == userID) { 
                if(team_sub.get(i) != 0) {
                    numTeamAssess++;
                    if(status.get(i).equals("done") || status.get(i).equals("pendingreview") || status.get(i).equals("published")){
                       doneTask++;
                    }
                }
            }
        }
        
        teamprogress = ((double)doneTask/(double)numTeamAssess) * 100;
        return teamprogress;
    }
    public double getAvgAllMyProgess() {
        int userID =0;
        double AllMyProgress = 0;
        int numAllUser = getNumID();
        for(int i=0; i<user_id.size(); i++){
            userID = user_id.get(i);
            AllMyProgress+=getMyProgress(userID);
        }  
        AllMyProgress /= numAllUser;
        return AllMyProgress;
    }
    public double getAvgAllTeamProgess() {
        double AllTeamProgress = 0;
        int numAllTeam = getNumTeam();

        AllTeamProgress+=getTeamProgress(14145); // team 1844
        AllTeamProgress+=getTeamProgress(14146); // team 1845
        AllTeamProgress+=getTeamProgress(14160); // team 1846
        AllTeamProgress+=getTeamProgress(14154); // team 1847
        AllTeamProgress+=getTeamProgress(14151); // team 1848
        AllTeamProgress /= numAllTeam;
        
        return AllTeamProgress;
    }
    
    
    //TeamMember part
    public int getUserTeamID() {
        int userTeam = 0;
         for(int i=0; i<user_id.size(); i++) {
            if(user_id.get(i) == userID) {
                userTeam = team_enroll.get(i);
            }
        }
         return userTeam;
    } 
    public int getNumTeamMember() {
        int numMember = 0;
        int teamID = getUserTeamID();
        for(int i=0; i<team_enroll.size(); i++) {
            if(team_enroll.get(i) == teamID) {
                numMember++;
            }
        }
        return numMember;
    }
    public ArrayList getTeamMemberID() {
        ArrayList<Integer> member = new ArrayList<>();
        int teamID = getUserTeamID();
         for(int i=0; i<team_enroll.size(); i++) {
            if(team_enroll.get(i) == teamID) {
                member.add(user_id.get(i));
            }
        }
        return member;
    }
 
    
    public ArrayList getSubmiiter() {return submitter_id;}
    public ArrayList getStatus() {return status;}
    public ArrayList getAssessmentID() {return assessment_id;}
    public ArrayList getTeam() {return team_sub;}
    public ArrayList getUserID() {return user_id;}
    public ArrayList getTeamID() {return team_enroll;}
    public int getNumAssessment() {return numAssessment;}
    public int getNumID() {return numID;}
    public int getNumTeam() {return numTeam;}

}
