
package util.exception;

/**
 * @author Darryl,Paul,WuLin,ZhiKuan
 */
public class BookOverDueException extends Exception{
    
    public BookOverDueException(){
        
    }
    
    public BookOverDueException(String msg){
        super(msg);
    }
    
    
}