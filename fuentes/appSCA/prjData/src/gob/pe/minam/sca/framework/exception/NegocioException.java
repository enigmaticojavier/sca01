package gob.pe.minam.sca.framework.exception;

public class NegocioException extends BaseException {
  public NegocioException (){
  }
  public NegocioException(String message, Exception exception)
  {
    super(message, exception);
  }
  
  public NegocioException(String message, String params[], Exception exception, String codigoMensajeUsuario)
  {
    super(message, exception, params, codigoMensajeUsuario);
  }
  
  public NegocioException(String message, String params[], String codigoMensajeUsuario)
  {
    super(message, params, codigoMensajeUsuario);
  }
  
  public NegocioException(Exception exception)
  {
    super(exception);
  }
  
  public NegocioException(String message)
  {
    super(message);
  }
  public NegocioException(String message, String codigoMensajeUsuario){
    super(message, null, codigoMensajeUsuario);
  }
  
}