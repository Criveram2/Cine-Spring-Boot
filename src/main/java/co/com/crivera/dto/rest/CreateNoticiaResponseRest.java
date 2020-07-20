/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/29
 * @since 0.0.1 2020/03/29
 */

package co.com.crivera.dto.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto con datos resultantes de crear una noticia
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/29
 * @since 0.0.1 2020/03/29
 */
@ApiModel(description = "Clase con resultado de crear una noticia ")
@Data
@Getter
@Setter
public class CreateNoticiaResponseRest
{
    /** identifcador de la noticia en base de datos*/
    @ApiModelProperty(notes = "Identificador de la noticia en base de datos")
    private Integer id;
}
