import java.lang.reflect.Array;
import java.util.ArrayList;

public class MemberCollection {

    private static final int max_amount = 64;

    private Member[] members;
    private int membersAmount; 

    private Movie[] borrowedMovies;
    private int borrowedAmount;

    public MemberCollection(){
        this.members = new Member[max_amount];
        this.membersAmount = 0;
        this.borrowedAmount = 0;
    }

    public boolean addMember(Member newMember){
        if (membersAmount < max_amount){
            members[membersAmount] = newMember;
            membersAmount++;
            return true;
        }
        return false;
    }

    public Member getMember(String username){
        for (int i = 0; i < membersAmount; i++){
            if (username.equals(members[i].getUsername())){
                return members[i];
            }
        }
        return null;
    }



}
