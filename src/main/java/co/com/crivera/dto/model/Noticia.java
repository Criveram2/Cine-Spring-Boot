/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/17
 * @since 0.0.1 2020/03/17
 */

package co.com.crivera.dto.model;

import java.util.Date;

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
 * Dto con el modelo de una noticia
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/17
 * @since 0.0.1 2020/03/17
 */
@Entity()
@Table(name = "Noticias")
@Data
@Getter
@Setter
public class Noticia
{
    /** Identificador */
    @Id
    @Column(name="id_noticia")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "noticias_id_seq", name = "noticias_id_seq")
    private int    id;
    /** Titulo de la noticia */
    @Column(name="titulo")
    private String titulo;
    /** Fecha de publicacion */
    @Column(name="fecha")
    private Date fechaPublicacion;
    /** detalle de la noticia*/
    @Column(name="detalle")
    private String detalle;
    /** estatus de la noticia*/
    @Column(name="estatus")
    private String estatus;
    
}
