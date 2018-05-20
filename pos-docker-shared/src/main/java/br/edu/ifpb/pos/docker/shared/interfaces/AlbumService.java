package br.edu.ifpb.pos.docker.shared.interfaces;

import br.edu.ifpb.pos.docker.shared.entidades.Album;
import java.util.List;

/**
 *
 * @author Edilva
 */
public interface AlbumService {

    void salvar(Album album);

    void atualizar(Album album);

    void remover(long id);

    Album getAlbum(long id);

    List<Album> listar();
}
