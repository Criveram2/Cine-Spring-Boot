/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/30
 * @since 0.0.1 2020/03/30
 */

package co.com.crivera.dto.rest;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/30
 * @since 0.0.1 2020/03/30
 */
@Data
@Getter
@Setter
@ApiModel(description = "Clase que contiene la respuesta de consultar la lista de banners")
public class FindAllBannerResponseRest
{
    /** lista de noticias**/
    @ApiModelProperty(notes = " Lista de banners")
    private List<BannerRest> banners;
}
