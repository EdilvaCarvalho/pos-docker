package br.edu.ifpb.pos.docker.shared.enuns;

/**
 *
 * @author Edilva
 */
public enum Estilo {

    ROCK("Rock"),
    POP("POP"),
    SERTANEJO("Sertanejo"),
    SAMBA("Samba"),
    JAZZ("Jazz"),
    REGGAE("Reggae");

    private final String descricao;

    private Estilo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
