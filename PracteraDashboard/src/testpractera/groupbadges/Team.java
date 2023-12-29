package testpractera.groupbadges;

import java.util.ArrayList;

public class Team {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;

    public ArrayList<Member> members = new ArrayList<>();

    public void add_member(Member member) {
        members.add(member);
    }
}
