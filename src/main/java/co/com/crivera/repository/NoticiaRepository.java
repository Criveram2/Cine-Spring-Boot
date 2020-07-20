/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/29
 * @since 0.0.1 2020/03/29
 */

package co.com.crivera.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.crivera.dto.model.Noticia;



/**
 * Repositorio de la entidad noticia
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/01
 * @since 0.0.1 2020/03/29
 */
@Repository
public interface NoticiaRepository  extends JpaRepository<Noticia,Integer>
{
    /**
     * Permite consultar la lista de notificias por estatus
     * SELECT * FROM Noticias where estatus
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/31
     * @since 0.0.1 2020/03/31
     * @param estatus
     * @return
     */
    List<Noticia> findByEstatus(String estatus);
     
    /**
     * Permite consultar la lista de notificias por estatus y fecha
     * SELECT * FROM Noticias where estatus and fecha 
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/01
     * @since 0.0.1 2020/04/01
     * @param estatus
     * @return
     */
    List<Noticia> findByEstatusAndFechaPublicacion(String estatus, Date fecha);
      
    /**
     * Permite consultar la lista de notificias por rango de fechas
     * SELECT * FROM Noticias where fecha between ? and ?
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/01
     * @since 0.0.1 2020/04/01
     * @param estatus
     * @return
     */
    List<Noticia> findByFechaPublicacionBetween(Date fechaInicial, Date fechaFinal);
}
