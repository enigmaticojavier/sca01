package gob.pe.minam.sca.framework.exception;

public class BaseException
  extends Exception
{

    /**
     * Parametros que seran reemplazados en cada Marcador de posicion dentro del 
     * mensaje al usuario correspondinte al key
     * @see com.sun.faces.util.MessageFactory
     */
    protected String params[];
    /**
     * Valor clave (key) del mensaje al usuario correspondiente a la excepcion generada
     * @see com.sun.faces.util.MessageFactory
     */
    protected String codigoMensajeUsuario;

    public BaseException()
    {
        super();
    }

    public BaseException(String message)
    {
        super(message);
    }

    public BaseException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public BaseException(Throwable cause)
    {
        super(cause);
    }

    /**
     * 
     * @deprecated es mantenido solo por compatibilidad con el codigo existente
     */
    public BaseException(Class source, String message, Throwable cause)
    {
        super(message, cause);
    }

    public BaseException(String message, String params[], String codigoMensajeUsuario)
    {
        super(message);
        this.params = params;
        this.codigoMensajeUsuario = codigoMensajeUsuario;
    }

    public BaseException(String message, Throwable cause, String params[], String codigoMensajeUsuario)
    {
        super(message, cause);
        this.params = params;
        this.codigoMensajeUsuario = codigoMensajeUsuario;
    }

    public BaseException(Throwable cause, String params[], String codigoMensajeUsuario)
    {
        super(cause);
        this.params = params;
        this.codigoMensajeUsuario = codigoMensajeUsuario;
    }

    public String[] getParams()
    {
		return params;
    }

    public String getCodigoMensajeUsuario()
    {
        return codigoMensajeUsuario;
    }

}