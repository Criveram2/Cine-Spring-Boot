/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/02
 * @since 0.0.1 2020/04/02
 */

package co.com.crivera.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.crivera.dto.model.Horario;

/**
 * Repositorio para Horario
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/02
 * @since 0.0.1 2020/04/02
 */
@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer>
{
    /**
     * Horarios por idPelicula (Pelicula.id = Pelicula_Id and fecha=?)
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     * @param idPelicula
     * @param fecha
     * @return
     */
    public List<Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha);
    
    /**
     * "select h from Horario h where h.fecha = :fecha and pelicula.estatus='Activa' group by h.pelicula order by pelicula.id asc"
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     * @param fecha
     * @return
     */
    @Query("select h from Horario h where h.fecha = :fecha and pelicula.estatus='Activa' group by h.pelicula order by pelicula.id asc")
    public List<Horario> findByFecha(@Param("fecha") Date fecha);
}
