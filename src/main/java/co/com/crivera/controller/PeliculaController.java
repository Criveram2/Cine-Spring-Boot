/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/01
 * @since 0.0.1 2020/04/01
 */

package co.com.crivera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.crivera.dto.rest.FindAllPeliculasResponseRest;
import co.com.crivera.dto.rest.PeliculaRest;
import co.com.crivera.exception.ServiceException;
import co.com.crivera.service.PeliculasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;

/**
 * Servicios Relacionados a la entidad peliculas
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/01
 * @since 0.0.1 2020/04/01
 */
@Controller
@RequestMapping("/peliculas")
@Api(value = "Servicios Relacionados a la entidad peliculas")
public class PeliculaController
{
    @Autowired
    private @Getter PeliculasService peliculasService;
    
    /**
     * Consulta lista de peliculas
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/01
     * @since 0.0.1 2020/04/04
     * @param estatus estatus de las noticias
     * @return lista de noticas
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Consulta lista de Peliculas", notes = "El servicio regresa una lista")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Si retorna Informacion"), @ApiResponse(code = 204, message = "En caso de no encontrar informacion"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FindAllPeliculasResponseRest> findAll() throws ServiceException
    {
        FindAllPeliculasResponseRest findAllPeliculasResponseRest = new FindAllPeliculasResponseRest();
        findAllPeliculasResponseRest.setPeliculas(getPeliculasService().findAll());
        return new ResponseEntity<>(findAllPeliculasResponseRest, HttpStatus.OK);
    }
    
    /**
     * Consulta pelicula por id
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/05
     * @since 0.0.1 2020/04/05
     * @param id identificador de la pelicula
     * @return datos de la noticia noticas
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Consulta pelicula por su id", notes = "El servicio regresa datos de la pelicula")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Si retorna Informacion"), @ApiResponse(code = 204, message = "En caso de no encontrar informacion"),
            @ApiResponse(code = 400, message = "Datos de peticion invalidos"), @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PeliculaRest> findById(@PathVariable("id") int id) throws ServiceException
    {
        
        return new ResponseEntity<>(getPeliculasService().findById(id), HttpStatus.OK);
    }
    
    /**
     * Consulta lista de peliculas por estatus
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/05
     * @since 0.0.1 2020/04/05
     * @param estatus estatus de las noticias
     * @return lista de noticas
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Consulta lista de Peliculas por estatus", notes = "El servicio regresa una lista")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Si retorna Informacion"), @ApiResponse(code = 204, message = "En caso de no encontrar informacion"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @GetMapping(value = "/{estatus}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FindAllPeliculasResponseRest> findAll(@PathVariable("estatus") String estatus) throws ServiceException
    {
        FindAllPeliculasResponseRest findAllPeliculasResponseRest = new FindAllPeliculasResponseRest();
        findAllPeliculasResponseRest.setPeliculas(getPeliculasService().findByEstatus(estatus));
        return new ResponseEntity<>(findAllPeliculasResponseRest, HttpStatus.OK);
    }
    
    /**
     * Consulta lista de peliculas por fecha
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/05
     * @since 0.0.1 2020/04/05
     * @param fecha fecha de estreno
     * @return lista de noticas
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Consulta lista de Peliculas por fecha", notes = "El servicio regresa una lista")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Si retorna Informacion"), @ApiResponse(code = 204, message = "En caso de no encontrar informacion"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @GetMapping(value = "/{fecha}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FindAllPeliculasResponseRest> findAll(@PathVariable("fecha") long fecha) throws ServiceException
    {
        FindAllPeliculasResponseRest findAllPeliculasResponseRest = new FindAllPeliculasResponseRest();
        findAllPeliculasResponseRest.setPeliculas(getPeliculasService().findByFecha(fecha));
        return new ResponseEntity<>(findAllPeliculasResponseRest, HttpStatus.OK);
    }
    
    /**
     * Elimina Pelicula por id
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/05
     * @since 0.0.1 2020/04/05
     * @param id identificador de la pelicula
     * @return lista de noticas
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Eliminar Pelicula por id", notes = "El servicio no regresa informacion")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Si retorna Informacion"), @ApiResponse(code = 204, message = "En caso de no encontrar informacion"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws ServiceException
    {
        getPeliculasService().delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
