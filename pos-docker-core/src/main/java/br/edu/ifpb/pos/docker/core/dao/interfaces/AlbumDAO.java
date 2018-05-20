
package br.edu.ifpb.pos.docker.core.dao.interfaces;

import br.edu.ifpb.pos.docker.shared.entidades.Album;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface AlbumDAO {
    
    void salvar(Album album);

    void atualizar(Album album);

    void remover(Album album);

    Album getAlbum(long id);

    List<Album> listar();
}
