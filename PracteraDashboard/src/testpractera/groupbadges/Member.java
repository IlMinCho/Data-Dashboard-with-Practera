package testpractera.groupbadges;

import java.util.ArrayList;

public class Member{
    private String name;
    private double score;

    public Member(String theName, double theScore){
        setName(theName);
        setScore(theScore);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
         this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}