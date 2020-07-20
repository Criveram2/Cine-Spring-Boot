/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/29
 * @since 0.0.1 2020/03/29
 */

package co.com.crivera.service;

import java.util.List;

import javax.validation.Valid;

import co.com.crivera.dto.rest.CreateNoticiaRequestRest;
import co.com.crivera.dto.rest.FindAllNoticiaResponseRest;
import co.com.crivera.dto.rest.NoticiaRest;
import co.com.crivera.dto.rest.UpdateNoticiaRequestRest;
import co.com.crivera.exception.NoContentServiceException;
import co.com.crivera.exception.ServiceException;

/**
 * Interface para manejo de la logica de noticias
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/29
 * @since 0.0.1 2020/03/29
 */
public interface NoticiaService
{
    /**
     * Consulta todas las noticas existentes
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @return lista de noticias
     * @throws NoContentServiceException en caso de no encontrar informacion
     * @throws ServiceException en caso de un erro no controlado
     */
    public FindAllNoticiaResponseRest findAll(int page, int size) throws ServiceException;
    
    /**
     * Consulta noticia por id
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @return lista de noticias
     * @throws NoContentServiceException en caso de no encontrar informacion
     * @throws ServiceException en caso de un erro no controlado
     */
    public NoticiaRest findById(int id) throws ServiceException;
    
    /**
     * guarda una noticia
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @param createNoticiaRest dto con datos de la noticia a salvar
     * @return identificador de la notica creada
     */
    public Integer save(@Valid CreateNoticiaRequestRest createNoticiaRest) throws ServiceException;
    
    /**
     * modifica una noticia por su id
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @param updateNoticiaRequestRest dto con datos de la noticiaa modificar
     * @param Id identifcador del elemento a modificar
     * @return identificador de la notica creada
     */
    public Integer update(@Valid UpdateNoticiaRequestRest updateNoticiaRequestRest, int id) throws ServiceException;
    
    /**
     * elimina una noticia por id
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @param Id identifcador del elemento a eliminar
     */
    public void delete(int id) throws ServiceException;
    
    /**
     * Consulta las noticias por estatus
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/31
     * @since 0.0.1 2020/03/31
     * @param estatus estado para filtrar
     * @return lista de noticias
     * @throws ServiceException
     */
    public  List<NoticiaRest> findByEstatus(String estatus) throws ServiceException; ;
}
