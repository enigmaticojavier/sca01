package gob.pe.minam.sca.framework.exception;

public class DAOException extends BaseException
{
    public DAOException(String message, Exception exception)
    {
        super(message, exception);
    }

    public DAOException(String message, String params[], Exception exception)
    {
        super(message, exception);
        this.codigoMensajeUsuario = message;
        this.params = params;
    }

    public DAOException(Class source, String propertiesFileName, Throwable cause)
    {
        super(source, propertiesFileName, cause);
    }

    public DAOException(String message)
    {
        super(message);
    }
    
    public DAOException(String message, String codigoMensajeUsuario){
        super(message, null, codigoMensajeUsuario);
    }
    
    public DAOException(Exception exception){
        super(exception);
    }
       
    
}