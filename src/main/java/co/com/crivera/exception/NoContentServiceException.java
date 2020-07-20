package co.com.crivera.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * NocContent ServiceException
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/31
 * @since 0.0.1 2020/03/31
 */
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class NoContentServiceException  extends ServiceException
{
    /** Version de la clase */
    private static final long serialVersionUID = 1L;

    public NoContentServiceException(String message) {
        super(message);
    }
}
