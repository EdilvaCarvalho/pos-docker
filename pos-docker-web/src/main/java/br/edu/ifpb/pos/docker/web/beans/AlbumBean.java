package br.edu.ifpb.pos.docker.web.beans;

import br.edu.ifpb.pos.docker.shared.entidades.Album;
import br.edu.ifpb.pos.docker.shared.entidades.Banda;
import br.edu.ifpb.pos.docker.shared.enuns.Estilo;
import br.edu.ifpb.pos.docker.shared.interfaces.AlbumService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Edilva
 */
@Named
@SessionScoped
public class AlbumBean implements Serializable {

    @Inject
    private AlbumService service;
    private Album album = new Album();
    private Banda banda = new Banda();
    private List<Album> albuns = new ArrayList<>();
    private List<String> integrantes = new ArrayList<>();
    private String integrante;

    private boolean editando = false;

    public AlbumBean() {
    }

    public String salvarAlbum() {
        banda.setIntegrates(integrantes);
        album.setBanda(banda);
        service.salvar(album);
        limpar();
        return null;
    }

    public void limpar() {
        album = new Album();
        banda = new Banda();
        integrantes = new ArrayList<>();
        integrante = "";
    }

    public String removerAlbum(Album albumRemover) {
        service.remover(albumRemover.getId());
        return null;
    }

    public String atualizarAlbum() {
        service.atualizar(album);
        limpar();
        editando = false;
        return null;
    }

    public String editarAlbum(Album albumAtualizar) {
        album = albumAtualizar;
        editando = true;
        return null;
    }

    public void listarAlbuns() {
        albuns = service.listar();
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

    public Estilo[] getEstilos() {
        return Estilo.values();
    }

    public List<Album> getAlbuns() {
        listarAlbuns();
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
    }

    public String getIntegrante() {
        return integrante;
    }

    public void setIntegrante(String integrante) {
        this.integrante = integrante;
    }

    public List<String> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<String> integrantes) {
        this.integrantes = integrantes;
    }

    public void addIntegrantes() {
        integrantes.add(integrante);
        integrante = "";
        System.out.println(integrantes.toString());
    }
    
    public void removeIntegrantes(String i) {
        integrantes.remove(i);
    }

}
