/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/04
 * @since 0.0.1 2020/04/04
 */

package co.com.crivera.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import co.com.crivera.dto.model.Detalle;
import co.com.crivera.dto.rest.CreateDetalleRestService;
import co.com.crivera.exception.ServiceException;
import co.com.crivera.repository.DetalleRepository;
import co.com.crivera.service.DetalleService;
import lombok.Getter;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/04
 * @since 0.0.1 2020/04/04
 */
@Service
@Validated
public class DetalleServiceImpl implements DetalleService
{
    @Autowired   
    private @Getter DetalleRepository detalleRepository;
    /* (non-Javadoc)
     * @see co.com.crivera.service.DetalleService#insertar(co.com.crivera.dto.model.Detalle)
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     */
    @Override
    public void insert(@Valid CreateDetalleRestService createDetalleRestService ) throws ServiceException
    {
        Detalle detalle = new Detalle();
        detalle.setActores(createDetalleRestService.getActores());
        detalle.setDirector(createDetalleRestService.getDirector());
        detalle.setSinopsis(createDetalleRestService.getSinopsis());
        detalle.setTrailer(createDetalleRestService.getTrailer());
        detalleRepository.save(detalle);
        
    }

    /* (non-Javadoc)
     * @see co.com.crivera.service.DetalleService#eliminar(int)
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     */
    @Override
    public void delete(int idDetalle) throws ServiceException
    {
        detalleRepository.deleteById(idDetalle);
        
    }
    
}
