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
 * Clase que contiene la respuesta de consultar horario rest
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/05
 * @since 0.0.1 2020/04/05
 */
@Data
@Getter
@Setter
@ApiModel(description = "Clase que contiene la respuesta de consultar horario rest")
public class HorarioRest
{
    /** identificador de base de datos*/
    @ApiModelProperty(notes = "Identificador de base de datos")
    private int id;
    /** fecha */
    @ApiModelProperty(notes = "fecha")
    private Long fecha;
    /** hora de la funcion*/
    @ApiModelProperty(notes = " hora de la funcion")
    private String hora; // HH:mm
    /** nombre de la sala*/
    @ApiModelProperty(notes = "nombre de la sala")
    private String sala; 
    /** costo de la entrada*/
    @ApiModelProperty(notes = "costo de la entrada")
    private double precio;
    /** pelicula */
    @ApiModelProperty(notes = "pelicula")
    private int idPelicula;  
}
