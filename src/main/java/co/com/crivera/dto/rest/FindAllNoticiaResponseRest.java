/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/29
 * @since 0.0.1 2020/03/29
 */

package co.com.crivera.dto.rest;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto con datos de respuesta de consultar la lista de noticias
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/29
 * @since 0.0.1 2020/03/29
 */
@Data
@Getter
@Setter
@ApiModel(description = "Clase que contiene la respuesta de consultar la lista de noticias")
public class FindAllNoticiaResponseRest
{
    /** lista de noticias**/
    @ApiModelProperty(notes = "Lista de noticias")
    private List<NoticiaRest> noticias;
}
