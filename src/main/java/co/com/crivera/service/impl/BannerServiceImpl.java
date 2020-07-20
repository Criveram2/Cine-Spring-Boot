/**
 * ESTE COMPONENTE FUE REALIZADO BAJO LA METODOLOGIA DE DESARROLLO DE
 * CAMILO RIVERA Y SE ENCUENTRA PROTEGIDO POR LAS LEYES DE DERECHOS DE AUTOR.
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/30
 * @since 0.0.1 2020/03/30
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

import co.com.crivera.dto.model.Banner;
import co.com.crivera.dto.rest.BannerRest;
import co.com.crivera.dto.rest.CreateBannerRequestRest;
import co.com.crivera.dto.rest.UpdateBannerRequestRest;
import co.com.crivera.exception.NoContentServiceException;
import co.com.crivera.exception.ServiceException;
import co.com.crivera.repository.BannerRepository;
import co.com.crivera.service.BannerService;
import lombok.Getter;

/**
 * Implementacion de BannerService
 * @author Camilo Rivera
 * @version 0.0.1 2020/03/30
 * @since 0.0.1 2020/03/30
 */
@Service
@Validated
public class BannerServiceImpl implements BannerService
{
    
    /** repositorio de banners */
    @Autowired
    private @Getter BannerRepository bannerRepository;
    
    /* (non-Javadoc)
     * @see co.com.crivera.service.BannerService#findAll()
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/30
     * @since 0.0.1 2020/03/30
     */
    @Override
    public List<BannerRest> findAll() throws NoContentServiceException
    {
        List<Banner> banners = getBannerRepository().findAll();
        if (banners.isEmpty())
        {
            throw new NoContentServiceException("no hay noticias registradas en base de datos");
        }
        else
        {
            List<BannerRest> bannersRest = new ArrayList<>();
            banners.stream().forEach(banner->
            {
                bannersRest.add(convertBannerToBannerRest(banner));
            });
            return bannersRest;
        }
    }
    
    /* (non-Javadoc)
     * @see co.com.crivera.service.BannerService#findById(int)
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/30
     * @since 0.0.1 2020/03/30
     */
    @Override
    public BannerRest findById(int id) throws ServiceException
    {
        Optional<Banner> bannerOptional = getBannerRepository().findById(id);
        if (bannerOptional.isPresent())
        {
            Banner banner = bannerOptional.get();
            BannerRest bannerRest = convertBannerToBannerRest(banner);
            return bannerRest;
        }
        else
        {
            throw new NoContentServiceException("no hay noticias registradas en base de datos con id" + id);
        }
    }

    /* (non-Javadoc)
     * @see co.com.crivera.service.BannerService#save(co.com.crivera.dto.rest.CreateBannerRequestRest)
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/30
     * @since 0.0.1 2020/03/30
     */
    @Override
    public Integer save(@Valid CreateBannerRequestRest createBannerRequestRest) throws ServiceException
    {
        Banner banner= new Banner();
        banner.setArchivo(createBannerRequestRest.getArchivo());
        banner.setEstatus(createBannerRequestRest.getEstatus());
        banner.setFecha(new Date(createBannerRequestRest.getFecha()));
        banner.setTitulo(createBannerRequestRest.getTitulo());
        Banner bannerAlmacenada = getBannerRepository().save(banner);
        return bannerAlmacenada.getId();
    }

    /* (non-Javadoc)
     * @see co.com.crivera.service.BannerService#update(co.com.crivera.dto.rest.UpdateBannerRequestRest, int)
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/30
     * @since 0.0.1 2020/03/30
     */
    @Override
    public Integer update(@Valid UpdateBannerRequestRest updateBannerRequestRest, int id) throws ServiceException
    {
        Optional<Banner> optional = getBannerRepository().findById(id);
        if (optional.isPresent())
        {
            Banner banner = optional.get();
            banner.setArchivo(Optional.ofNullable(updateBannerRequestRest.getArchivo()).orElse(banner.getArchivo()));
            banner.setEstatus(Optional.ofNullable(updateBannerRequestRest.getEstatus()).orElse(banner.getEstatus()));
            banner.setTitulo(Optional.ofNullable(updateBannerRequestRest.getTitulo()).orElse(banner.getTitulo()));
            if (updateBannerRequestRest.getFecha() != null)
            {
                banner.setFecha(new Date(updateBannerRequestRest.getFecha()));
            }
            Banner bannerModificada = getBannerRepository().save(banner);
            return bannerModificada.getId();
        }
        else
        {
            return id;
        }
    }

    /* (non-Javadoc)
     * @see co.com.crivera.service.BannerService#delete(int)
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/30
     * @since 0.0.1 2020/03/30
     */
    @Override
    public void delete(int id) throws ServiceException
    {
        getBannerRepository().deleteById(id);
        
    }
    
    /**
     * Convierte un Banner a BannerRest
     * @author Camilo Rivera
     * @version 0.0.1 2020/03/30
     * @since 0.0.1 2020/03/30
     * @param banner
     * @return
     */
    private BannerRest convertBannerToBannerRest(Banner banner)
    {
        BannerRest bannerRest = new BannerRest();
        bannerRest.setArchivo(banner.getArchivo());
        bannerRest.setEstatus(banner.getEstatus());
        bannerRest.setFecha(banner.getFecha());
        bannerRest.setId(banner.getId());
        bannerRest.setTitulo(banner.getTitulo());
        return bannerRest;
    }

}
