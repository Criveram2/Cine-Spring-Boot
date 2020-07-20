/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/30
 * @since 0.0.1 2020/03/30
 */

package co.com.crivera.dto.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * "Clase que contiene los datos de un banner a modificar
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/30
 * @since 0.0.1 2020/03/30
 */
@ApiModel(description = "Clase que contiene los datos de un banner a modificar ")
@Data
@Getter
@Setter
public class UpdateBannerRequestRest
{
    /** Titulo del elemento en el banner*/
    @ApiModelProperty(notes = " Titulo del elemento en el banner")
    private String titulo;
    /** fecha de publicacion del banner*/
    @ApiModelProperty(notes = "fecfecha de publicacion del banner en formato unix time")
    private Long fecha; 
    /** nombre de la imagen relacionada al banner*/
    @ApiModelProperty(notes = "nombre de la imagen relacionada al banner")
    private String archivo; 
    /** estado del banner*/
    @ApiModelProperty(notes = "estatus")
    private String estatus;   
}
