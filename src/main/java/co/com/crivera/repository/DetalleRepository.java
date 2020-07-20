/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/01
 * @since 0.0.1 2020/04/01
 */

package co.com.crivera.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.crivera.dto.model.Detalle;


/**
 * Repositorio de la entidad detalle
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/01
 * @since 0.0.1 2020/04/01
 */
@Repository
public interface DetalleRepository extends JpaRepository<Detalle,Integer>
{
    
}
