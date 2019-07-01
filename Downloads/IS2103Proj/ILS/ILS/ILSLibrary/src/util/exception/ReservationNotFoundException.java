package util.exception;

/**
 * @author Darryl,Paul,WuLin,ZhiKuan
 */

public class ReservationNotFoundException extends Exception
{
    public ReservationNotFoundException()
    {
    }
    
    
    
    public ReservationNotFoundException(String msg)
    {
        super(msg);
    }
}