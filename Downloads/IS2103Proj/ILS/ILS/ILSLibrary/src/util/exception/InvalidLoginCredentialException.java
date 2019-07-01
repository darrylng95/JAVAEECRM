
package util.exception;
/**
 * @author Darryl,Paul,WuLin,ZhiKuan
 */
public class InvalidLoginCredentialException extends Exception
{
    public InvalidLoginCredentialException()
    {
    }
    
    
    
    public InvalidLoginCredentialException(String msg)
    {
        super(msg);
    }
}
