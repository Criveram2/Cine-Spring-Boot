/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/30
 * @since 0.0.1 2020/03/30
 */

package co.com.crivera.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.crivera.dto.model.Pelicula;


/**
 * Repositorio de la entidad pelicula
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/30
 * @since 0.0.1 2020/03/30
 */
@Repository
public interface PeliculaRepository  extends JpaRepository<Pelicula,Integer>
{
    /**
     * Permite consultar la lista de Peliculas por estatus 
     * SELECT * FROM Noticias where estatus 
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     * @param estatus
     * @return
     */
    List<Pelicula> findByEstatus(String estatus);
    
    /**
     * Permite consultar la lista de Peliculas por estatus 
     * SELECT * FROM Noticias where estatus 
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     * @param estatus
     * @return
     */
    List<Pelicula> findByFechaEstreno(Date fechaestreno);
      
}
