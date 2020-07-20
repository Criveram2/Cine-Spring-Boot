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
 * Clase con datos de pelicula para capa rest 
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/02
 * @since 0.0.1 2020/04/02
 */
@Data
@Getter
@Setter
@ApiModel(description = "Clase con datos de una pelicula ")
public class PeliculaRest
{

    /** Identificador */
    @ApiModelProperty(notes = "Identificador de la pelicula")
    private int    id;
    /** Titulo de la pelicula */
    @ApiModelProperty(notes = " Titulo de la pelicula")
    private String titulo;
    /** Tiempo de duracion en minutos */
    @ApiModelProperty(notes = " Tiempo de duracion en minutos ")
    private int    duracion;
    /** Clasificacion de la pelicula */
    @ApiModelProperty(notes = " Clasificacion de la pelicula")
    private String clasificacion;
    /** Genero correspondiente */
    @ApiModelProperty(notes = " Genero correspondiente")
    private String genero;
    /** Imagen Logo */
    @ApiModelProperty(notes = "Imagen Logo")
    private String imagen; 
    /**Fecha de estreno*/
    @ApiModelProperty(notes = "Fecha de estreno en formato unix time")
    private Long fechaEstreno;
    /** Estado */
    @ApiModelProperty(notes = "Estado")
    private String estatus;
    /** detalle */
    @ApiModelProperty(notes = "Detalle")
    private DetalleRest detalle; 
}
