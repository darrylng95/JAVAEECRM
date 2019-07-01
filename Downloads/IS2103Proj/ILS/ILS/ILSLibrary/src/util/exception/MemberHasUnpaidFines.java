
package util.exception;

/**
 * @author Darryl,Paul,WuLin,ZhiKuan
 */
public class MemberHasUnpaidFines extends Exception{
    
    public MemberHasUnpaidFines(){
        
    }
    
    public MemberHasUnpaidFines(String msg){
        super(msg);
    }
    
    
}