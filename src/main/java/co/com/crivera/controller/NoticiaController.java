/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/29
 * @since 0.0.1 2020/03/29
 */

package co.com.crivera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.crivera.dto.rest.CreateNoticiaRequestRest;
import co.com.crivera.dto.rest.CreateNoticiaResponseRest;
import co.com.crivera.dto.rest.FindAllNoticiaResponseRest;
import co.com.crivera.dto.rest.FindNoticiaByEstatusResponseRest;
import co.com.crivera.dto.rest.NoticiaRest;
import co.com.crivera.dto.rest.UpdateNoticiaRequestRest;
import co.com.crivera.exception.ServiceException;
import co.com.crivera.service.NoticiaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;

/**
 * Clase con los servicios rest relacionados con noticias
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/29
 * @since 0.0.1 2020/03/29
 */
@Controller
@RequestMapping("/noticia")
@Api(value = "Servicios Relacionados a la entidad noticia")
public class NoticiaController
{
    /** Servicio para manejo de logica de negocio relacionada con noticias*/
    @Autowired
    private  @Getter NoticiaService noticiaService;
    
    /**
     * Consulta lista de noticas paginado
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @param size cantidad de registros por pagina
     * @param page pagina 
     * @return lista de noticas
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Consulta lista de noticas", notes = "El servicio regresa una lista")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Si retorna Informacion"),
            @ApiResponse(code = 204, message = "En caso de no encontrar informacion"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @GetMapping(value="/{page}/{size}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FindAllNoticiaResponseRest> findAll(
            @PathVariable("size") int size,
            @PathVariable("page") int page
            ) throws ServiceException {
       
        new FindAllNoticiaResponseRest();

        FindAllNoticiaResponseRest respuesta= getNoticiaService().findAll(page,size);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    
    /**
     * Consulta lista de noticas
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @param id identificador de la noticia
     * @return datos de la noticia noticas
     * @throws ServiceException si se presenta un error en el proceso 
     */
    @ApiOperation(value = "Consulta notica por su id", notes = "El servicio regresa datos de la noticia")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Si retorna Informacion"),
            @ApiResponse(code = 204, message = "En caso de no encontrar informacion"),
            @ApiResponse(code = 400, message = "Datos de peticion invalidos"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NoticiaRest> findById( @PathVariable("id") int id )throws ServiceException {
       
        return new ResponseEntity<>(getNoticiaService().findById(id), HttpStatus.OK);
    }
    
    /**
     * Guardar noticia
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @param createNoticiaRest datos de la noticia por salvar
     * @return datos de la noticia noticas
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Guardar Noticia", notes = "El servicio regresa datos de la noticia")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Si el elemento fue almacenado con exito"),
            @ApiResponse(code = 409, message = "En caso de que el registro ya exista"),
            @ApiResponse(code = 400, message = "Datos de peticion invalidos"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @PostMapping(value="" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateNoticiaResponseRest> save(  @RequestBody CreateNoticiaRequestRest createNoticiaRest)throws ServiceException {
        CreateNoticiaResponseRest respuesta = new CreateNoticiaResponseRest();
        respuesta.setId(getNoticiaService().save(createNoticiaRest));
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }
    
    /**
     * Modificar noticia
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @param updateNoticiaRequestRest datos de la noticia por modificar
     * @param id Identificador de la noticia a modificar
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Guardar Noticia", notes = "El servicio no regresa informacion")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Si el elemento fue modificado con exito"),
            @ApiResponse(code = 409, message = "En caso de que el registro ya exista"),
            @ApiResponse(code = 400, message = "Datos de peticion invalidos"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update( 
            @PathVariable("id") int id ,
            @RequestBody UpdateNoticiaRequestRest updateNoticiaRequestRest) throws ServiceException {
        getNoticiaService().update(updateNoticiaRequestRest, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
    /**
     * Eliminar noticia por id
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @param id Identificador de la noticia a modificar
     * @return datos de la noticia noticas
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Eliminar Noticia", notes = "El servicio no regresa datos")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Si el elemento fue eliminado con exito"),
            @ApiResponse(code = 409, message = "En caso de que el registro ya exista"),
            @ApiResponse(code = 400, message = "Datos de peticion invalidos"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(  @PathVariable("id") int id ) throws ServiceException  {
        getNoticiaService().delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
    /**
     * Consulta lista de noticas por estatus
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/31
     * @since 0.0.1 2020/03/31
     * @param estatus estatus de las noticias
     * @return lista de noticas
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Consulta lista de noticas por estatus", notes = "El servicio regresa una lista")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Si retorna Informacion"),
            @ApiResponse(code = 204, message = "En caso de no encontrar informacion"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @GetMapping(value="estatus/{estatus}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FindNoticiaByEstatusResponseRest> findAll(
            @PathVariable("estatus") String estatus
            ) throws ServiceException {
       
        FindNoticiaByEstatusResponseRest respuesta=  new FindNoticiaByEstatusResponseRest();
        List<NoticiaRest> listaNoticias= getNoticiaService().findByEstatus(estatus);
        respuesta.setNoticias(listaNoticias);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
