/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/04
 * @since 0.0.1 2020/04/04
 */

package co.com.crivera.service;

import java.util.List;

import javax.validation.Valid;

import co.com.crivera.dto.rest.HorarioCreateRest;
import co.com.crivera.dto.rest.HorarioRest;
import co.com.crivera.exception.ServiceException;

/**
 * interface con la capa de servicio horarios
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/04
 * @since 0.0.1 2020/04/04
 */
public interface HorarioService
{
    /**
     *  Consulta peliculas por pelicula y fecha
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     * @param idPelicula identificador de la pelicula
     * @param date fecha en formato unix time
     * @return
     * @throws ServiceException
     */
    List<HorarioRest> FindByIdPeliculaAndDate(int idPelicula, Long date) throws ServiceException;
    
    /**
     * Inserta un horario
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     * @param horario
     * @throws ServiceException
     */
    void insert(@Valid HorarioCreateRest horarioCreateRest) throws ServiceException;
    
    /**
     * consulta todos los horarios
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     * @return
     * @throws ServiceException
     */
    List<HorarioRest> findAll() throws ServiceException;
    
    /**
     * consulta los horarios paginados
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     * @param page
     * @param size
     * @return
     * @throws ServiceException
     */
    List<HorarioRest> findAll(int page, int size) throws ServiceException;
    
    /**
     * Elimina horario id
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     * @param idHorario
     * @throws ServiceException
     */
    void delete(int idHorario) throws ServiceException;
    
    /**
     * encuentra horario por id
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     * @param idHorario
     * @return
     * @throws ServiceException
     */
    HorarioRest findById(int idHorario) throws ServiceException;
}
