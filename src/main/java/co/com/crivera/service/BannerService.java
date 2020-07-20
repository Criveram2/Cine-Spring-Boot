/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/30
 * @since 0.0.1 2020/03/30
 */

package co.com.crivera.service;

import java.util.List;

import javax.validation.Valid;

import co.com.crivera.dto.rest.BannerRest;
import co.com.crivera.dto.rest.CreateBannerRequestRest;
import co.com.crivera.dto.rest.UpdateBannerRequestRest;
import co.com.crivera.exception.NoContentServiceException;
import co.com.crivera.exception.ServiceException;

/**
 Interface para manejo de la logica de banners
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/30
 * @since 0.0.1 2020/03/30
 */
public interface BannerService
{
    /**
     * Consulta todas los banners existentes
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @return lista de banners
     * @throws NoContentServiceException en caso de no encontrar informacion
     */
    public List<BannerRest> findAll() throws ServiceException;
    
    /**
     * Consulta banner por id
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @return lista de noticias
     * @throws NoContentServiceException en caso de no encontrar informacion
     */
    public BannerRest findById(int id) throws ServiceException;
    
    /**
     * guarda un banner
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @param createBannerRequestRest dto con datos de banner a guardar
     * @return identificador de la notica creada
     */
    public Integer save(@Valid CreateBannerRequestRest createBannerRequestRest) throws ServiceException;
  
    /**
     * modifica un banner por su id
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @param updateBannerRequestRest dto con datosdel baner a modificar
     * @param Id identifcador del elemento a modificar
     * @return identificador de la notica creada
     */
    public Integer update(@Valid UpdateBannerRequestRest updateBannerRequestRest, int id) throws ServiceException;
    
    /**
     * elimina una noticia por id
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @param Id identifcador del elemento a eliminar
     */
    public void delete(int id) throws ServiceException;
}
