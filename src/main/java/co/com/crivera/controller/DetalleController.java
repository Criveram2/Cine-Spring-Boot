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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import co.com.crivera.dto.rest.CreateDetalleRestService;
import co.com.crivera.exception.ServiceException;
import co.com.crivera.service.DetalleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/05
 * @since 0.0.1 2020/04/05
 */
@Controller
@RequestMapping("/detalle")
@Api(value = "Clase con los servicios rest relacionados con detalle de peliculas")
public class DetalleController
{
    /** Servicio para manejo de logica de negocio relacionada con detalle peliculas*/
    @Autowired
    private  @Getter DetalleService detalleService;  
    /**
     * Guardar banner
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/30
     * @since 0.0.1 2020/03/30
     * @param createBannerRequestRest datos del banner por salvar
     * @return id del registro creado
     * @throws ServiceException
     */
    @ApiOperation(value = "Guardar detalle pelicula", notes = "El servicio no regresa informacion")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Si el elemento fue almacenado con exito"), @ApiResponse(code = 409, message = "En caso de que el registro ya exista"),
            @ApiResponse(code = 400, message = "Datos de peticion invalidos"), @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> save(@RequestBody CreateDetalleRestService createDetalleRestService) throws ServiceException
    {
        getDetalleService().insert(createDetalleRestService);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
    
    /**
     * Eliminar detalle pelicula
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/05
     * @since 0.0.1 2020/04/05
     * @param id Identificador del detalle de  la pelicula
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Eliminar Detalle pelicula", notes = "El serviciono regresa informacion")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Si el elemento fue modificado con exito"),
            @ApiResponse(code = 409, message = "En caso de que el registro ya exista"),
            @ApiResponse(code = 400, message = "Datos de peticion invalidos"), 
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws ServiceException
    {
        getDetalleService().delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
