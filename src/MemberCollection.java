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

    public boolean authenticateMember(String username, String password){

        for (Member m : members){
            if (username.equals(m.getUsername()) && password.equals(m.getPassword())){
                return true;
            }
        }

        return false;

    }

}
