/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/25
 * @since 0.0.1 2020/03/25
 */

package co.com.crivera.dto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto con el detalle de una pelicula
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/25
 * @since 0.0.1 2020/03/25
 */
@Entity()
@Table(name = "Detalles")
@Data
@Getter
@Setter
public class Detalle
{
    /** Identificador */
    @Id
    @Column(name="id_detalle")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "detalles_id_seq", name = "detalles_id_seq")
    /** Identificador */
    private int    id;
    /** nombre del director de la pelicula*/
    @Column(name="director")
    private String director;
   /**  actores de la pelicula*/
    @Column(name="actores")
    private String actores;
    /** descripcion de la sinpsis*/
    @Column(name="sinopsis")
    private String sinopsis;
    /**enlace a trailer*/
    @Column(name="trailer")
    private String trailer;
  
}
