/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/31
 * @since 0.0.1 2020/03/31
 */

package co.com.crivera.exception;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/31
 * @since 0.0.1 2020/03/31
 */
public class ServiceException extends Exception
{
    /** Version de la clase */
    private static final long serialVersionUID = 1L;

    public ServiceException(String message) {
        super(message);
    }  
}
