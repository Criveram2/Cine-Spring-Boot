/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/04
 * @since 0.0.1 2020/04/04
 */

package co.com.crivera.service;

import javax.validation.Valid;

import co.com.crivera.dto.rest.CreateDetalleRestService;
import co.com.crivera.exception.ServiceException;

/**
 * Interface con la logica para manejo de detalle
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/04
 * @since 0.0.1 2020/04/04
 */
public interface DetalleService
{
    /**
     * Inserta un detalle
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     * @param createDetalleRestService dto con los datos necesarios para crear detalle
     */
    void insert(@Valid CreateDetalleRestService createDetalleRestService) throws ServiceException;
    
    /**
     * Elimina un detalle
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     * @param idDetalle
     */
    void delete(int idDetalle) throws ServiceException;
}
