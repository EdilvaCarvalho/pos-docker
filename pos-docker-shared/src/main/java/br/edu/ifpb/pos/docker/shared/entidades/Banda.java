package br.edu.ifpb.pos.docker.shared.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Edilva
 */
@Entity
public class Banda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String localDeOrigem;
    private List<String> integrates;

    public Banda() {
    }

    public Banda(String nome, String localDeOrigem, List<String> integrates) {
        this.nome = nome;
        this.localDeOrigem = localDeOrigem;
        this.integrates = integrates;
    }

    public Banda(long id, String nome, String localDeOrigem, List<String> integrates) {
        this.id = id;
        this.nome = nome;
        this.localDeOrigem = localDeOrigem;
        this.integrates = integrates;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalDeOrigem() {
        return localDeOrigem;
    }

    public void setLocalDeOrigem(String localDeOrigem) {
        this.localDeOrigem = localDeOrigem;
    }

    public List<String> getIntegrates() {
        return integrates;
    }

    public void setIntegrates(List<String> integrates) {
        this.integrates = integrates;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.localDeOrigem);
        hash = 97 * hash + Objects.hashCode(this.integrates);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Banda other = (Banda) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.localDeOrigem, other.localDeOrigem)) {
            return false;
        }
        if (!Objects.equals(this.integrates, other.integrates)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Banda{" + "id=" + id + ", nome=" + nome + ", localDeOrigem=" + localDeOrigem + ", integrates=" + integrates + '}';
    }

}
