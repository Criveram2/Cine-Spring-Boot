/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/30
 * @since 0.0.1 2020/03/30
 */

package co.com.crivera.dto.rest;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * "Clase que contiene los datos de un banner a crear 
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/30
 * @since 0.0.1 2020/03/30
 */
@ApiModel(description = "Clase que contiene los datos de un banner a crear ")
@Data
@Getter
@Setter
public class CreateBannerRequestRest
{
    /** Titulo del elemento en el banner*/
    @ApiModelProperty(notes = " Titulo del elemento en el banner")
    @NotEmpty
    private String titulo;
    /** fecha de publicacion del banner*/
    @ApiModelProperty(notes = "fecfecha de publicacion del bannerha")
    @NotNull
    private Long fecha; 
    /** nombre de la imagen relacionada al banner*/
    @ApiModelProperty(notes = "nombre de la imagen relacionada al banner")
    @NotEmpty
    private String archivo; 
    /** estado del banner*/
    @ApiModelProperty(notes = "estatus")
    @NotEmpty
    private String estatus;
}
