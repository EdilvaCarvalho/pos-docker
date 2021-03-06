package br.edu.ifpb.pos.docker.shared.entidades;

import br.edu.ifpb.pos.docker.shared.enuns.Estilo;
import br.edu.ifpb.pos.docker.shared.util.ConvertLocalDate;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Edilva
 */
@Entity
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Estilo estilo;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Banda banda;
    @Convert(converter = ConvertLocalDate.class)
    private LocalDate anoDeLancamento;

    public Album() {
    }

    public Album(Estilo estilo, Banda banda, LocalDate anoDeLancamento) {
        this.estilo = estilo;
        this.banda = banda;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Album(long id, Estilo estilo, Banda banda, LocalDate anoDeLancamento) {
        this.id = id;
        this.estilo = estilo;
        this.banda = banda;
        this.anoDeLancamento = anoDeLancamento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public LocalDate getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(LocalDate anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 13 * hash + Objects.hashCode(this.estilo);
        hash = 13 * hash + Objects.hashCode(this.banda);
        hash = 13 * hash + Objects.hashCode(this.anoDeLancamento);
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
        final Album other = (Album) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.estilo != other.estilo) {
            return false;
        }
        if (!Objects.equals(this.banda, other.banda)) {
            return false;
        }
        if (!Objects.equals(this.anoDeLancamento, other.anoDeLancamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Album{" + "id=" + id + ", estilo=" + estilo + ", banda=" + banda + ", anoDeLancamento=" + anoDeLancamento + '}';
    }

}
