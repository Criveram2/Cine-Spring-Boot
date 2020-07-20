/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/25
 * @since 0.0.1 2020/03/25
 */

package co.com.crivera.dto.model;

import java.util.Arrays;
import java.util.List;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/25
 * @since 0.0.1 2020/03/25
 */
public class Contacto
{
    /** identificador*/
    private int id;
    /** nombre del contacto*/
    private String nombre;
    /**correo de contacto*/
    private String email;
    /** identificador del rango*/
    private int rating;
    /** lista de generos*/
    private String[] generos;
    /** lista de notificaciones**/
    private List<String> notificaciones;
    /** comentarios*/
    private String comentarios;
    /**
     * @return Regresa el valor del campo id
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/25
     * @since 0.0.1 2020/03/25
     */
    public int getId()
    {
        return id;
    }
    /**
     * @param id Nuevo valor para el campo id
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/25
     * @since 0.0.1 2020/03/25
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * @return Regresa el valor del campo nombre
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/25
     * @since 0.0.1 2020/03/25
     */
    public String getNombre()
    {
        return nombre;
    }
    /**
     * @param nombre Nuevo valor para el campo nombre
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/25
     * @since 0.0.1 2020/03/25
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    /**
     * @return Regresa el valor del campo email
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/25
     * @since 0.0.1 2020/03/25
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * @param email Nuevo valor para el campo email
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/25
     * @since 0.0.1 2020/03/25
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /**
     * @return Regresa el valor del campo rating
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/25
     * @since 0.0.1 2020/03/25
     */
    public int getRating()
    {
        return rating;
    }
    /**
     * @param rating Nuevo valor para el campo rating
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/25
     * @since 0.0.1 2020/03/25
     */
    public void setRating(int rating)
    {
        this.rating = rating;
    }
    /**
     * @return Regresa el valor del campo generos
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/25
     * @since 0.0.1 2020/03/25
     */
    public String[] getGeneros()
    {
        return generos;
    }
    /**
     * @param generos Nuevo valor para el campo generos
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/25
     * @since 0.0.1 2020/03/25
     */
    public void setGeneros(String[] generos)
    {
        this.generos = generos;
    }
   
    /**
     * @return Regresa el valor del campo notificaciones
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/26
     * @since 0.0.1 2020/03/26
     */
    public List<String> getNotificaciones()
    {
        return notificaciones;
    }
    /**
     * @param notificaciones Nuevo valor para el campo notificaciones
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/26
     * @since 0.0.1 2020/03/26
     */
    public void setNotificaciones(List<String> notificaciones)
    {
        this.notificaciones = notificaciones;
    }
    /**
     * @return Regresa el valor del campo comentarios
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/25
     * @since 0.0.1 2020/03/25
     */
    public String getComentarios()
    {
        return comentarios;
    }
    /**
     * @param comentarios Nuevo valor para el campo comentarios
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/25
     * @since 0.0.1 2020/03/25
     */
    public void setComentarios(String comentarios)
    {
        this.comentarios = comentarios;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/26
     * @since 0.0.1 2020/03/26
     */
    @Override
    public String toString()
    {
        return "Contacto [id=" + id + ", nombre=" + nombre + ", email=" + email + ", rating=" + rating + ", generos=" + Arrays.toString(generos) + ", notificaciones=" + notificaciones
                + ", comentarios=" + comentarios + "]";
    }     
}
