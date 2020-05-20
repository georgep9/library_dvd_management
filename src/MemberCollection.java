import java.util.ArrayList;

public class MemberCollection {

    private ArrayList<Member> members;

    public MemberCollection(){
        this.members = new ArrayList<Member>();
    }

    public void addMember(Member newMember){
        this.members.add(newMember);
    }

    public void removeMember(Member member){
        this.members.remove(member);
    }

}
