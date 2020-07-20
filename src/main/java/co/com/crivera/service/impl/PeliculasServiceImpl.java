/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/02
 * @since 0.0.1 2020/04/02
 */

package co.com.crivera.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import co.com.crivera.dto.model.Detalle;
import co.com.crivera.dto.model.Pelicula;
import co.com.crivera.dto.rest.DetalleRest;
import co.com.crivera.dto.rest.PeliculaRest;
import co.com.crivera.exception.NoContentServiceException;
import co.com.crivera.exception.ServiceException;
import co.com.crivera.repository.PeliculaRepository;
import co.com.crivera.service.PeliculasService;

/**
 * Implementacion de PeliculasService
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/02
 * @since 0.0.1 2020/04/02
 */
@Service
@Validated
public class PeliculasServiceImpl implements PeliculasService
{
    /** Repositorio de peliculas */
    @Autowired
    private PeliculaRepository peliculaRepository;
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.PeliculasService#findAll()
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/02
     * @since 0.0.1 2020/04/02
     */
    @Override
    public List<PeliculaRest> findAll() throws ServiceException
    {
        List<Pelicula>  peliculas= getPeliculaRepository().findAll();
        if(peliculas.isEmpty()) {
            throw new NoContentServiceException("No existe peliculas");
        }
        List<PeliculaRest> peliculasRest = new ArrayList<>();
        peliculas.stream().forEach(pelicula->  peliculasRest.add(convertPeliculaToPeliculaRest(pelicula)));
        return peliculasRest;
    }

    /* (non-Javadoc)
     * @see co.com.crivera.service.PeliculasService#findBuId(int)
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     */
    @Override
    public PeliculaRest findById(int id) throws ServiceException
    {
        Optional<Pelicula> pelicula= getPeliculaRepository().findById(id);
        if ( pelicula.isPresent()) {
            return convertPeliculaToPeliculaRest(pelicula.get());
        }else
        {
            throw new NoContentServiceException("No existe pelicula con Id "+ id);
        }     
    }
    
    /* (non-Javadoc)
     * @see co.com.crivera.service.PeliculasService#findByEstatus(java.lang.String)
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     */
    @Override
    public List<PeliculaRest> findByEstatus(@Valid String estatus) throws ServiceException
    {
        List<Pelicula> peliculas =getPeliculaRepository().findByEstatus(estatus);
        if(peliculas.isEmpty()) {
            throw new NoContentServiceException("No existe peliculas");
        }
        List<PeliculaRest> peliculasRest = new ArrayList<>();
        peliculas.stream().forEach(pelicula->  peliculasRest.add(convertPeliculaToPeliculaRest(pelicula)));
        return peliculasRest;
    }

    /* (non-Javadoc)
     * @see co.com.crivera.service.PeliculasService#findByFecha(java.lang.Long)
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     */
    @Override
    public List<PeliculaRest> findByFecha(Long fecha) throws ServiceException
    {
         Date fechaestreno =   new Date(fecha);
        List<Pelicula> peliculas =getPeliculaRepository().findByFechaEstreno(fechaestreno);
        if(peliculas.isEmpty()) {
            throw new NoContentServiceException("No existe peliculas");
        }
        List<PeliculaRest> peliculasRest = new ArrayList<>();
        peliculas.stream().forEach(pelicula->  peliculasRest.add(convertPeliculaToPeliculaRest(pelicula)));
        return peliculasRest;
    }

    /* (non-Javadoc)
     * @see co.com.crivera.service.PeliculasService#delete(int)
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     */
    @Override
    public void delete(int idPelicula) throws ServiceException
    {
        getPeliculaRepository().deleteById(idPelicula);      
    } 
    
    /**
     * convertir objeto Pelicula a PeliculaRest
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/02
     * @since 0.0.1 2020/04/02
     * @param pelicula
     * @return
     */
    private PeliculaRest convertPeliculaToPeliculaRest(Pelicula pelicula)
    {
        PeliculaRest peliculaRest = new PeliculaRest();
        peliculaRest.setDetalle(convetDetalleToDetalleRest(pelicula.getDetalle()));
        peliculaRest.setClasificacion(pelicula.getClasificacion());
        peliculaRest.setDuracion(pelicula.getDuracion());
        peliculaRest.setEstatus(pelicula.getEstatus());
        peliculaRest.setFechaEstreno(pelicula.getFechaEstreno().getTime());
        peliculaRest.setGenero(pelicula.getGenero());
        peliculaRest.setId(pelicula.getId());
        peliculaRest.setImagen(pelicula.getImagen());
        peliculaRest.setTitulo(pelicula.getTitulo());
        return peliculaRest;
    }

    /**
     * convierte objeto de tipo Detalle a DetalleRest
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/02
     * @since 0.0.1 2020/04/02
     * @param detalle
     * @return
     */
    private DetalleRest convetDetalleToDetalleRest(Detalle detalle)
    {
        DetalleRest detalleRest= new DetalleRest();
        detalleRest.setActores(detalle.getActores());
        detalleRest.setDirector(detalle.getDirector());
        detalleRest.setId(detalle.getId());
        detalleRest.setSinopsis(detalle.getSinopsis());
        detalleRest.setTrailer(detalle.getTrailer());
        return detalleRest;
    }

    /**
     * @return Regresa el valor del campo peliculaRepository
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/02
     * @since 0.0.1 2020/04/02
     */
    public PeliculaRepository getPeliculaRepository()
    {
        return peliculaRepository;
    }

  
}
