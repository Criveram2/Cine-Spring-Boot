/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/02
 * @since 0.0.1 2020/04/02
 */

package co.com.crivera.dto.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/02
 * @since 0.0.1 2020/04/02
 */
@Data
@Getter
@Setter
@ApiModel(description = "Clase con datos del detalle de una pelicula ")
public class DetalleRest
{
    /** Identificador */
    @ApiModelProperty(notes = "Identificador del detalle")
    /** Identificador */
    private int    id;
    /** nombre del director de la pelicula*/
    @ApiModelProperty(notes = "director")
    private String director;
   /**  actores de la pelicula*/
    @ApiModelProperty(notes = "actores")
    private String actores;
    /** descripcion de la sinpsis*/
    @ApiModelProperty(notes = "sinopsis")
    private String sinopsis;
    /**enlace a trailer*/
    @ApiModelProperty(notes = "Enlace a trailer")
    private String trailer;
}
