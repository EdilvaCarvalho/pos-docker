package br.edu.ifpb.pos.docker.core.dao.impl;

import br.edu.ifpb.pos.docker.core.dao.interfaces.AlbumDAO;
import br.edu.ifpb.pos.docker.shared.entidades.Album;
import java.util.Collections;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Edilva
 */
@Stateless
@Local(AlbumDAO.class)
public class AlbumDAOImpl implements AlbumDAO {
    
    @PersistenceContext(unitName = "pos-docker-PU")
    private EntityManager manager;

    @Override
    public void salvar(Album album) {
        manager.persist(album);
    }

    @Override
    public void atualizar(Album album) {
        manager.merge(album);
    }

    @Override
    public void remover(Album album) {
        manager.remove(album);
    }

    @Override
    public Album getAlbum(long id) {
        return manager.find(Album.class, id);
    }

    @Override
    public List<Album> listar() {
        try {
            Query query = manager
                    .createQuery("SELECT a FROM Album a");

            List<Album> list = query.getResultList();

            if (list == null || list.isEmpty()) {
                return Collections.EMPTY_LIST;
            } else {
                return list;
            }

        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }

}
