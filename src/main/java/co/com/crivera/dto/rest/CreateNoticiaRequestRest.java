/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/29
 * @since 0.0.1 2020/03/29
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
 * Dto con datos necesarios para crear una noticia
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/29
 * @since 0.0.1 2020/03/29
 */
@ApiModel(description = "Clase que contiene los datos de una noticia a crear ")
@Data
@Getter
@Setter
public class CreateNoticiaRequestRest
{
    /** Titulo de la noticia */
    @ApiModelProperty(notes = " Titulo de la noticia")
    @NotEmpty
    private String titulo;
    /** Fecha de publicacion */
    @ApiModelProperty(notes = "Fecha de publicacion, en formato unix time")
    @NotNull
    private Long fechaPublicacion;
    /** detalle de la noticia*/
    @ApiModelProperty(notes = " Detalle de la noticia")
    @NotEmpty
    private String detalle;
    /** estatus de la noticia*/
    @ApiModelProperty(notes = " Estado de la noticia, posibles valores Activa e Inactiva")
    @NotEmpty
    private String estatus;
      
}
