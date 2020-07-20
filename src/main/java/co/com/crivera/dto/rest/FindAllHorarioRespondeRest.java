/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/05
 * @since 0.0.1 2020/04/05
 */

package co.com.crivera.dto.rest;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase que contiene la respuesta de consultar la lista de horarios
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/05
 * @since 0.0.1 2020/04/05
 */
@Data
@Getter
@Setter
@ApiModel(description = "Clase que contiene la respuesta de consultar la lista de horarios")
public class FindAllHorarioRespondeRest
{
    /** lista de noticias**/
    @ApiModelProperty(notes = " Lista de horarios")
    private List<HorarioRest> horarios;
}
