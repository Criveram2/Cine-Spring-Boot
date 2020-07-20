/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/29
 * @since 0.0.1 2020/03/29
 */

package co.com.crivera.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import co.com.crivera.dto.model.Noticia;
import co.com.crivera.dto.rest.CreateNoticiaRequestRest;
import co.com.crivera.dto.rest.FindAllNoticiaResponseRest;
import co.com.crivera.dto.rest.NoticiaRest;
import co.com.crivera.dto.rest.UpdateNoticiaRequestRest;
import co.com.crivera.exception.NoContentServiceException;
import co.com.crivera.exception.ServiceException;
import co.com.crivera.repository.NoticiaRepository;
import co.com.crivera.service.NoticiaService;
import lombok.Getter;

/**
 * Implementacion de la interface NoticiaService
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/29
 * @since 0.0.1 2020/03/29
 */
@Service
@Validated
public class NoticiaServiceImpl implements NoticiaService
{
    @Autowired
    /** repostorio de noticias */
    private @Getter NoticiaRepository noticiaRepository;
    
    /* (non-Javadoc)
     * @see co.com.crivera.service.NoticiaService#findAll(int, int)
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/30
     * @since 0.0.1 2020/03/30
     */
    @Override
    public FindAllNoticiaResponseRest findAll(int page, int size) throws ServiceException
    {
        Page<Noticia> noticias=getNoticiaRepository().findAll(PageRequest.of(page, size, Sort.by("titulo")));  
        if (noticias.isEmpty())
        {
            throw new NoContentServiceException("no hay noticias registradas en base de datos");
        }
        else
        {
            List<NoticiaRest> noticiasRest = new ArrayList<>();
            noticias.stream().forEach(noticia ->noticiasRest.add(convertNoticioToNoticiaRest(noticia)));
            FindAllNoticiaResponseRest respuesta= new FindAllNoticiaResponseRest();
            respuesta.setNoticias(noticiasRest);
            return respuesta;
        }
    }
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.NoticiaService#findById(int)
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     */
    @Override
    public NoticiaRest findById(int id) throws ServiceException
    {
        Optional<Noticia> noticiaOptional = getNoticiaRepository().findById(id);
        if (noticiaOptional.isPresent())
        {
            Noticia noticia = noticiaOptional.get();
            NoticiaRest noticiaRest = convertNoticioToNoticiaRest(noticia);
            return noticiaRest;
        }
        else
        {
            throw new NoContentServiceException("no hay noticias registradas en base de datos con id" + id);
        }
    }
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.NoticiaService#save(co.com.crivera.dto.rest.CreateNoticiaRest)
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     */
    @Override
    public Integer save(@Valid CreateNoticiaRequestRest createNoticiaRest) throws ServiceException
    {
        
        Noticia noticia = new Noticia();
        noticia.setDetalle(createNoticiaRest.getDetalle());
        noticia.setEstatus(createNoticiaRest.getEstatus());
        noticia.setFechaPublicacion(new Date(createNoticiaRest.getFechaPublicacion()));
        noticia.setTitulo(createNoticiaRest.getTitulo());
        Noticia noticiaAlmacenada = getNoticiaRepository().save(noticia);
        return noticiaAlmacenada.getId();
    }
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.NoticiaService#update(co.com.crivera.dto.rest.CreateNoticiaRest, int)
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     */
    @Override
    public Integer update(@Valid UpdateNoticiaRequestRest updateNoticiaRequestRest, int id) throws ServiceException
    {
        Optional<Noticia> optional = getNoticiaRepository().findById(id);
        if (optional.isPresent())
        {
            Noticia noticia = optional.get();
            noticia.setDetalle(Optional.ofNullable(updateNoticiaRequestRest.getDetalle()).orElse(noticia.getDetalle()));
            noticia.setEstatus(Optional.ofNullable(updateNoticiaRequestRest.getEstatus()).orElse(noticia.getEstatus()));
            noticia.setTitulo(Optional.ofNullable(updateNoticiaRequestRest.getTitulo()).orElse(noticia.getTitulo()));
            if (updateNoticiaRequestRest.getFechaPublicacion() != null)
            {
                noticia.setFechaPublicacion(new Date(updateNoticiaRequestRest.getFechaPublicacion()));
            }
            Noticia noticiaModificada = getNoticiaRepository().save(noticia);
            return noticiaModificada.getId();
        }
        else
        {
            return id;
        }
    }
    
    /* (non-Javadoc)
     * @see co.com.crivera.service.NoticiaService#delete(int)
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     */
    @Override
    public void delete(int id) throws ServiceException
    {
        getNoticiaRepository().deleteById(id);
    }
    
    /**
     * convierte un objeto de tipo Noticia a NoticiaRest
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/29
     * @since 0.0.1 2020/03/29
     * @param noticia objeto con datos de noticia en base de datos
     * @return NoticiaRest datos de noticia para capa rest
     */
    private NoticiaRest convertNoticioToNoticiaRest(Noticia noticia)
    {
        
        NoticiaRest noticiaRest = new NoticiaRest();
        noticiaRest.setDetalle(noticia.getDetalle());
        noticiaRest.setEstatus(noticia.getEstatus());
        noticiaRest.setFechaPublicacion(noticia.getFechaPublicacion());
        noticiaRest.setTitulo(noticia.getTitulo());
        noticiaRest.setId(noticia.getId());
        return noticiaRest;
    }

    /* (non-Javadoc)
     * @see co.com.crivera.service.NoticiaService#findByEstatus(java.lang.String)
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/31
     * @since 0.0.1 2020/03/31
     */
    @Override
    public List<NoticiaRest> findByEstatus(String estatus) throws ServiceException
    {
        List<Noticia> noticias=getNoticiaRepository().findByEstatus(estatus); 
        if (noticias.isEmpty())
        {
            throw new NoContentServiceException("no hay noticias registradas en base de datos");
        }
        else
        {
            List<NoticiaRest> noticiasRest = new ArrayList<>();
            noticias.stream().forEach(noticia ->noticiasRest.add(convertNoticioToNoticiaRest(noticia)));
            return noticiasRest;
        }
    }
}
