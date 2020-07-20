/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/04
 * @since 0.0.1 2020/04/04
 */

package co.com.crivera.dto.rest;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que contiene la respuesta de consultar la lista de peliculas
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/04
 * @since 0.0.1 2020/04/04
 */
@Data
@Getter
@Setter
@ApiModel(description = "Clase que contiene la respuesta de consultar la lista de peliculas")
public class FindAllPeliculasResponseRest
{
    /** lista de peliculas **/
    @ApiModelProperty(notes = "Lista de peliculas")
    private List<PeliculaRest> peliculas;
}
