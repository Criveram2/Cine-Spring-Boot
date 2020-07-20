/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/05
 * @since 0.0.1 2020/04/05
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.crivera.dto.rest.FindAllHorarioRespondeRest;
import co.com.crivera.dto.rest.HorarioCreateRest;
import co.com.crivera.dto.rest.HorarioRest;
import co.com.crivera.exception.ServiceException;
import co.com.crivera.service.HorarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;

/**
 * Clase con los servicios rest relacionados a horarios
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/05
 * @since 0.0.1 2020/04/05
 */
@Controller
@RequestMapping("/horario")
@Api(value = "Clase con los servicios rest relacionados a horarios")
public class HorarioController
{
    /** Servicio para manejo de logica de negocio relacionada con banner */
    @Autowired
    private @Getter HorarioService horarioService;
    
    /**
     * Consulta lista de horarios por pelicula y fecha
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/05
     * @since 0.0.1 2020/04/05
     * @param size cantidad de registros por pagina
     * @param page pagina
     * @return lista de horarios
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Consulta lista de horarios por pelicula y fecha", notes = "El servicio regresa una lista")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Si retorna Informacion"),
            @ApiResponse(code = 204, message = "En caso de no encontrar informacion"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @GetMapping(value = "/{idPelicula}/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FindAllHorarioRespondeRest> findAll(@PathVariable("idPelicula") int idPelicula,
            @PathVariable("date") long date) throws ServiceException
    {      
        FindAllHorarioRespondeRest respuesta = new FindAllHorarioRespondeRest();
        respuesta.setHorarios(getHorarioService().FindByIdPeliculaAndDate(idPelicula, date));
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    
    /**
     * Consulta lista de horarios paginado
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/05
     * @since 0.0.1 2020/04/05
     * @param size cantidad de registros por pagina
     * @param page pagina
     * @return lista de horarios
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Consulta lista de horarios", notes = "El servicio regresa una lista")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Si retorna Informacion"),
            @ApiResponse(code = 204, message = "En caso de no encontrar informacion"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @GetMapping(value = "/{page}/{size}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FindAllHorarioRespondeRest> findAll(@PathVariable("size") int size, @PathVariable("page") int page) throws ServiceException
    {      
        FindAllHorarioRespondeRest respuesta = new FindAllHorarioRespondeRest();
        respuesta.setHorarios(getHorarioService().findAll(page, size));
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    
    /**
     * Consulta lista de horarios
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/05
     * @since 0.0.1 2020/04/05
     * @return lista de horarios
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Consulta lista de horarios", notes = "El servicio regresa una lista")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Si retorna Informacion"),
            @ApiResponse(code = 204, message = "En caso de no encontrar informacion"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FindAllHorarioRespondeRest> findAll() throws ServiceException
    {      
        FindAllHorarioRespondeRest respuesta = new FindAllHorarioRespondeRest();
        respuesta.setHorarios(getHorarioService().findAll());
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    
    /**
     * Consulta  horario por id
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/05
     * @since 0.0.1 2020/04/05
     * @param Identificador 
     * @return datos del horario
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Consulta  horarios por id", notes = "El servicio regresa datos de horario")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Si retorna Informacion"),
            @ApiResponse(code = 204, message = "En caso de no encontrar informacion"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HorarioRest> findAll(@PathVariable("id") int id) throws ServiceException
    {      
        return new ResponseEntity<>(getHorarioService().findById(id), HttpStatus.OK);
    }
    
    /**
     * eliminar  horario por id
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/05
     * @since 0.0.1 2020/04/05
     * @param Identificador peliculas
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Eliminar horarios por id", notes = "El serviciono regresa informacion")
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Si retorna Informacion"),
            @ApiResponse(code = 204, message = "En caso de no encontrar informacion"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws ServiceException
    {      
        getHorarioService().delete(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    
    /**
     * Guardar horario
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/05
     * @since 0.0.1 2020/04/05
     * @param horarioCreateRest datos de horario a salvar
     * @return datos de la noticia noticas
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Guardar Horario", notes = "El servicio no regresa informacion")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Si el elemento fue almacenado con exito"),
            @ApiResponse(code = 409, message = "En caso de que el registro ya exista"),
            @ApiResponse(code = 400, message = "Datos de peticion invalidos"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @PostMapping(value="" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> save(  @RequestBody HorarioCreateRest horarioCreateRest)throws ServiceException {
        getHorarioService().insert(horarioCreateRest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
