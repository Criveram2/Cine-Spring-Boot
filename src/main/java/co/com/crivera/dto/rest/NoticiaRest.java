/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/29
 * @since 0.0.1 2020/03/29
 */

package co.com.crivera.dto.rest;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * dto con los datos relacionados a una noticia
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/29
 * @since 0.0.1 2020/03/29
 */
@ApiModel(description = "Clase que contiene los datos de una noticia ")
@Data
@Getter
@Setter
public class NoticiaRest
{
    /** Identificador */
    @ApiModelProperty(notes = " Identificador en base de datos")
    private int    id;
    /** Titulo de la noticia */
    @ApiModelProperty(notes = " Titulo de la noticia")
    private String titulo;
    /** Fecha de publicacion */
    @ApiModelProperty(notes = "Fecha de publicacion")
    private Date fechaPublicacion;
    /** detalle de la noticia*/
    @ApiModelProperty(notes = " Detalle de la noticia")
    private String detalle;
    /** estatus de la noticia*/
    @ApiModelProperty(notes = " Estado de la noticia, posibles valores Activa e Inactiva")
    private String estatus;
   
}
