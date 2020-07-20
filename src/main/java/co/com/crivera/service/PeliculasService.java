/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/02
 * @since 0.0.1 2020/04/02
 */

package co.com.crivera.service;

import java.util.List;

import javax.validation.Valid;

import co.com.crivera.dto.rest.PeliculaRest;
import co.com.crivera.exception.NoContentServiceException;
import co.com.crivera.exception.ServiceException;

/**
 * Interface para manejo de la logica depeliculas
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/02
 * @since 0.0.1 2020/04/02
 */
public interface PeliculasService
{
    /**
     * Consulta todas los banners existentes
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @return lista de peliculas
     * @throws NoContentServiceException en caso de no encontrar informacion
     * @throws ServiceException si ocurre un error en el proceso
     */
    public List<PeliculaRest> findAll() throws ServiceException;
    
    /**
     * Consulta pelicula por id
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @return lista de banners
     * @throws NoContentServiceException en caso de no encontrar informacion
     * @throws ServiceException si ocurre un error en el proceso
     */
    public PeliculaRest findById(int id) throws ServiceException;
    
    /**
     * busca lista de pelicuas por estatus
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     * @param estatus
     * @return
     * @throws NoContentServiceException en caso de no encontrar informacion
     * @throws ServiceException si ocurre un error en el proceso
     */
    public List<PeliculaRest> findByEstatus( @Valid String estatus) throws ServiceException;
    
    /***
     * buscar peliculas por fecha
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     * @param fecha
     * @return
     * @throws NoContentServiceException en caso de no encontrar informacion
     * @throws ServiceException si ocurre un error en el proceso
     */
    public List<PeliculaRest> findByFecha(Long fecha) throws ServiceException;
    
    /**
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     * @param idPelicula
     * @throws ServiceException si ocurre un error en el proceso
     */
    void delete(int idPelicula) throws ServiceException;
    
}
