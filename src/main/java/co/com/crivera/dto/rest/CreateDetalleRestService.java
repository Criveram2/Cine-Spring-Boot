/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/05
 * @since 0.0.1 2020/04/05
 */

package co.com.crivera.dto.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que contiene la peticion de crear detalle
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/05
 * @since 0.0.1 2020/04/05
 */
@Data
@Getter
@Setter
@ApiModel(description = "Clase que contiene la peticion de crear detalle")
public class CreateDetalleRestService
{
    /** Identificador */
    @ApiModelProperty(notes = " Identificador")
    private int    id;
    /** nombre del director de la pelicula*/
    @ApiModelProperty(notes = "nombre del director de la pelicula")
    private String director;
   /**  actores de la pelicula*/
    @ApiModelProperty(notes = "actores")
    private String actores;
    /** descripcion de la sinpsis*/
    @ApiModelProperty(notes = "actores")
    private String sinopsis;
    /**enlace a trailer*/
    @ApiModelProperty(notes = "enlace a trailer")
    private String trailer;
}
