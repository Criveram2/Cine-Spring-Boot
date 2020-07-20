/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/04
 * @since 0.0.1 2020/04/04
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

import co.com.crivera.dto.model.Horario;
import co.com.crivera.dto.model.Pelicula;
import co.com.crivera.dto.rest.HorarioCreateRest;
import co.com.crivera.dto.rest.HorarioRest;
import co.com.crivera.exception.NoContentServiceException;
import co.com.crivera.exception.ServiceException;
import co.com.crivera.repository.HorarioRepository;
import co.com.crivera.service.HorarioService;
import lombok.Getter;

/**
 * @author Camilo Rivera
 * @version 0.0.1 2020/04/04
 * @since 0.0.1 2020/04/04
 */
@Service
@Validated
public class HorarioServiceImpl implements HorarioService
{
    /** repositorio para horaros*/
    @Autowired
    private @Getter HorarioRepository horarioRepository;
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.HorarioService#FindByIdPeliculaAndDate(int, java.lang.Long)
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     */
    @Override
    public List<HorarioRest> FindByIdPeliculaAndDate(int idPelicula, Long date) throws ServiceException
    {
        Date fecha = new Date(date);
        List<Horario> listaHorarios = getHorarioRepository().findByPelicula_IdAndFechaOrderByHora(idPelicula, fecha);
        if (listaHorarios.isEmpty())
        {
            throw new NoContentServiceException("no se tienen horarios para la pelicula " + idPelicula + "para la fecha indicada");
        }
        else
        {
            List<HorarioRest>  listaHorariosRest = new ArrayList<>();
            listaHorarios.forEach(horario->{
                listaHorariosRest.add(convertHorarioToHorarioRest(horario));
            });
            return listaHorariosRest;
        }
    }    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.HorarioService#insert(co.com.crivera.dto.model.Horario)
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     */
    @Override
    public void insert(@Valid HorarioCreateRest horarioCreateRest) throws ServiceException
    {
        Horario horario = new Horario();
        horario.setFecha(new Date(horarioCreateRest.getFecha()));
        horario.setHora(horarioCreateRest.getHora());
        Pelicula pelicula = new Pelicula ();
        pelicula.setId(horarioCreateRest.getIdPelicula());
        horario.setPelicula(pelicula);
        horario.setPrecio(horarioCreateRest.getPrecio());
        horario.setSala(horarioCreateRest.getSala());
        getHorarioRepository().save(horario);       
    }
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.HorarioService#findAll()
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     */
    @Override
    public List<HorarioRest> findAll() throws ServiceException
    {
        List<Horario> listaHorarios = getHorarioRepository().findAll();
        if (listaHorarios.isEmpty())
        {
            throw new NoContentServiceException("no se tienen horarios registrados");
        }
        else
        {
            List<HorarioRest>  listaHorariosRest = new ArrayList<>();
            listaHorarios.forEach(horario->{
                listaHorariosRest.add(convertHorarioToHorarioRest(horario));
            });
            return listaHorariosRest;
        }
    }
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.HorarioService#findAll(int, int)
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     */
    @Override
    public List<HorarioRest> findAll(int page, int size) throws ServiceException
    {
        Page<Horario> listaHorarios=getHorarioRepository().findAll(PageRequest.of(page, size, Sort.by("sala")));
        if (listaHorarios.isEmpty())
        {
            throw new NoContentServiceException("no se tienen horarios registrados");
        }
        else
        {
            List<HorarioRest>  listaHorariosRest = new ArrayList<>();
            listaHorarios.forEach(horario->{
                listaHorariosRest.add(convertHorarioToHorarioRest(horario));
            });
            return listaHorariosRest;
        }
    }
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.HorarioService#delete(int)
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     */
    @Override
    public void delete(int idHorario) throws ServiceException
    {
        getHorarioRepository().deleteById(idHorario);
    }
    
    /*
     * (non-Javadoc)
     * @see co.com.crivera.service.HorarioService#findById(int)
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/04
     * @since 0.0.1 2020/04/04
     */
    @Override
    public HorarioRest findById(int idHorario) throws ServiceException
    {
        Optional<Horario> horario = getHorarioRepository().findById(idHorario);
        if (horario.isPresent())
        {
            return convertHorarioToHorarioRest(horario.get());
        }
        else
        {
            throw new NoContentServiceException("no se tienen horarios por id " + idHorario);
        }
    }
   
    /**
     * convert Horario To HorarioRest
     * @author Camilo Rivera
     * @version 0.0.1 2020/04/05
     * @since 0.0.1 2020/04/05
     * @param horario
     * @return
     */
    private HorarioRest convertHorarioToHorarioRest(Horario horario)
    {
        HorarioRest horarioRest= new HorarioRest();
        horarioRest.setFecha(horario.getFecha().getTime());
        horarioRest.setHora(horario.getHora());
        horarioRest.setId(horario.getId());
        horarioRest.setIdPelicula(horario.getPelicula().getId());
        horarioRest.setPrecio(horario.getPrecio());
        horarioRest.setSala(horario.getSala());
        return horarioRest;
    }
    
}
