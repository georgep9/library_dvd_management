import java.lang.reflect.Array;
import java.util.ArrayList;

public class MemberCollection {

    // max amount of members allowed
    private static final int max_amount = 64;

    // array of member objects
    private Member[] members;
    private int membersAmount; // current amount

    /*
    Construct Member Collection array
     */
    public MemberCollection(){
        this.members = new Member[this.max_amount];
        this.membersAmount = 0;
    }

    /*
    Add member to array if within limits.
    Return status (true if success)
     */
    public boolean addMember(Member newMember){

        if (this.membersAmount < this.max_amount){
            this.members[this.membersAmount] = newMember;
            this.membersAmount++;
            return true;
        }
        return false;
    }

    /*
    Provided a member username string, loop through members array
    to return member object with matching username
     */
    public Member getMember(String username){
        for (int i = 0; i < this.membersAmount; i++){
            if (username.equals(this.members[i].getUsername())){
                return this.members[i];
            }
        }
        return null; // none found
    }



}
