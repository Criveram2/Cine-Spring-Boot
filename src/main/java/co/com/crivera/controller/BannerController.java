/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/30
 * @since 0.0.1 2020/03/30
 */

package co.com.crivera.controller;

import javax.validation.Valid;

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

import co.com.crivera.dto.rest.BannerRest;
import co.com.crivera.dto.rest.CreateBannerRequestRest;
import co.com.crivera.dto.rest.CreateBannerResponseRest;
import co.com.crivera.dto.rest.FindAllBannerResponseRest;
import co.com.crivera.dto.rest.UpdateBannerRequestRest;
import co.com.crivera.exception.ServiceException;
import co.com.crivera.service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;

/**
 * Clase con los servicios rest relacionados con banner
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/30
 * @since 0.0.1 2020/03/30
 */
@Controller
@RequestMapping("/banner")
@Api(value = "Clase con los servicios rest relacionados con banner")
public class BannerController
{
    /** Servicio para manejo de logica de negocio relacionada con banner*/
    @Autowired
    private  @Getter BannerService bannerService;
    
    /**
     * Consulta lista de banners
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/30
     * @since 0.0.1 2020/03/30
     * @return lista de noticas
     * @throws ServiceException si se presenta un error en el proceso 
     */
    @ApiOperation(value = "Consulta lista de banners", notes = "El servicio regresa una lista")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Si retorna Informacion"),
            @ApiResponse(code = 204, message = "En caso de no encontrar informacion"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @GetMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FindAllBannerResponseRest> findAll() throws ServiceException {
       
        FindAllBannerResponseRest respuesta= new FindAllBannerResponseRest();
        respuesta.setBanners(getBannerService().findAll());
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    
    
    /**
     * Consulta lista de banners
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @param id identificador del banner
     * @return datos de la noticia noticas
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Consulta banner por su id", notes = "El servicio regresa datos del banner")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Si retorna Informacion"),
            @ApiResponse(code = 204, message = "En caso de no encontrar informacion"),
            @ApiResponse(code = 400, message = "Datos de peticion invalidos"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BannerRest> findById( @PathVariable("id") int id )throws ServiceException {
       
        return new ResponseEntity<>(getBannerService().findById(id), HttpStatus.OK);
    }
    
    /**
     * Guardar banner
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/30
     * @since 0.0.1 2020/03/30
     * @param createBannerRequestRest datos del banner por salvar
     * @return id del registro creado
     * @throws ServiceException 
     */
    @ApiOperation(value = "Guardar Banner", notes = "El servicio regresa id del registro creado")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Si el elemento fue almacenado con exito"),
            @ApiResponse(code = 409, message = "En caso de que el registro ya exista"),
            @ApiResponse(code = 400, message = "Datos de peticion invalidos"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @PostMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateBannerResponseRest> save(  @RequestBody CreateBannerRequestRest createBannerRequestRest)throws ServiceException {
        CreateBannerResponseRest respuesta = new CreateBannerResponseRest();
        respuesta.setId(getBannerService().save(createBannerRequestRest));
        return new ResponseEntity<>(respuesta,HttpStatus.CREATED);
    }
    
    /**
     * Modificar banner
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/30
     * @since 0.0.1 2020/03/30
     * @param updateBannerRequestRest datos del banner por modificar
     * @param id Identificador del banner a modificar
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Modificiar Banner", notes = "El serviciono regresa informacion")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Si el elemento fue modificado con exito"),
            @ApiResponse(code = 409, message = "En caso de que el registro ya exista"),
            @ApiResponse(code = 400, message = "Datos de peticion invalidos"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update( 
            @PathVariable("id") int id ,
            @RequestBody @Valid UpdateBannerRequestRest updateBannerRequestRest) throws ServiceException {
        getBannerService().update(updateBannerRequestRest, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    
    /**
     * Eliminar banner
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/05
     * @since 0.0.1 2020/04/05
     * @param updateBannerRequestRest datos del banner por modificar
     * @param id Identificador del banner a modificar
     * @throws ServiceException si se presenta un error en el proceso
     */
    @ApiOperation(value = "Modificiar Banner", notes = "El serviciono regresa informacion")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Si el elemento fue modificado con exito"),
            @ApiResponse(code = 409, message = "En caso de que el registro ya exista"),
            @ApiResponse(code = 400, message = "Datos de peticion invalidos"),
            @ApiResponse(code = 500, message = "Si se presenta un error en el proceso") })
    @DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete( 
            @PathVariable("id") int id)throws ServiceException {
        getBannerService().delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
