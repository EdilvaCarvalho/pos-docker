package br.edu.ifpb.pos.docker.core.services;

import br.edu.ifpb.pos.docker.core.dao.interfaces.AlbumDAO;
import br.edu.ifpb.pos.docker.shared.entidades.Album;
import br.edu.ifpb.pos.docker.shared.interfaces.AlbumService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Edilva
 */
@Stateless
@Remote(AlbumService.class)
public class AlbumServiceImpl implements AlbumService {
    
    @EJB
    private AlbumDAO albumDAO;

    @Override
    public void salvar(Album album) {
        albumDAO.salvar(album);
    }

    @Override
    public void atualizar(Album album) {
        albumDAO.atualizar(album);
    }

    @Override
    public void remover(long id) {
        Album album = albumDAO.getAlbum(id);
        albumDAO.remover(album);
    }

    @Override
    public Album getAlbum(long id) {
        return albumDAO.getAlbum(id);
    }

    @Override
    public List<Album> listar() {
        return albumDAO.listar();
    }

}
