package artronics.sdwn.server.services.exceptions;

public class ServiceBaseException extends RuntimeException
{
    public ServiceBaseException()
    {
    }

    public ServiceBaseException(String message)
    {
        super(message);
    }

    public ServiceBaseException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ServiceBaseException(Throwable cause)
    {
        super(cause);
    }

    public ServiceBaseException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
