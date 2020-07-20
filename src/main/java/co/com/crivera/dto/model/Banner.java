/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/24
 * @since 0.0.1 2020/03/24
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
 * Dto con la descripcion de un baneer 
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/24
 * @since 0.0.1 2020/03/24
 */
@Entity()
@Table(name = "Banners")
@Data
@Getter
@Setter
public class Banner
{
    /** identificador del elemento banner*/
    @Id
    @Column(name="id_banner")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "banners_id_seq", name = "banners_id_seq")
    private int id;
    /** Titulo del elemnto en el banner*/
    @Column(name="titulo")
    private String titulo;
    /** fecha de publicacion del banner*/
    @Column(name="fecha")
    private Date fecha; 
    /** nombre de la imagen relacionada al banner*/
    @Column(name="archivo")
    private String archivo; 
    /** estado del banner*/
    @Column(name="estatus")
    private String estatus;
    
}
