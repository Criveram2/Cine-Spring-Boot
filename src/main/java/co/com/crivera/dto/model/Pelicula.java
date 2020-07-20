/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/10
 * @since 0.0.1 2020/03/10
 */

package co.com.crivera.dto.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase con la descripcion de una pelicual
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/30
 * @since 0.0.1 2020/03/30
 */
@Entity()
@Table(name = "Peliculas")
@Data
@Getter
@Setter
public class Pelicula
{
    /** Identificador */
    @Id
    @Column(name="id_Pelicula")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequenceName = "peliculas_id_seq", name = "peliculas_id_seq")
    /** Identificador */
    private int    id;
    /** Titulo de la pelicula */
    @Column(name="titulo")
    private String titulo;
    /** Tiempo de duracion en minutos */
    @Column(name="duracion")
    private int    duracion;
    /** Clasificacion de la pelicula */
    @Column(name="clasificacion")
    private String clasificacion;
    /** Genero correspondiente */
    @Column(name="genero")
    private String genero;
    /** Imagen Logo */
    @Column(name="imagen")
    private String imagen; // imagen por default
    /**Fecha de estreno*/
    @Column(name="fechaestreno")
    private Date fechaEstreno;
    /** Estado */
    @Column(name="estatus")
    private String estatus;
    /** detalle */
   //  @Transient //se usa esta anotacion cuando no se desea consultar la informacion de este atributo
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id_Detalle")
    private Detalle detalle;
    
    @OneToMany(mappedBy ="pelicula", fetch=FetchType.EAGER)
    private List<Horario> horarios;
}
