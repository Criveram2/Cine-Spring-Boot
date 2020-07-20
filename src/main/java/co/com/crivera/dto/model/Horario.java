/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/26
 * @since 0.0.1 2020/03/26
 */

package co.com.crivera.dto.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto con los datos de horario de funcion de una pelicula
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/26
 * @since 0.0.1 2020/03/26
 */
@Entity()
@Table(name = "Horarios")
@Data
@Getter
@Setter
public class Horario
{
    /** identificador de base de datos*/
    @Id
    @Column(name="id_Horario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "horarios_id_seq", name = "horarios_id_seq")
    private int id;
    /** fecha */
    @Column(name="fecha")
    private Date fecha;
    /** hora de la funcion*/
    @Column(name="hora")
    private String hora; // HH:mm
    /** nombre de la sala*/
    @Column(name="sala")
    private String sala; 
    /** costo de la entrada*/
    @Column(name="precio")
    private double precio;
    /** pelicula */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idPelicula")
    private Pelicula pelicula;
}
