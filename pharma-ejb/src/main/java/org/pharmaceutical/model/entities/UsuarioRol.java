package org.pharmaceutical.model.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author JNK
 */
@Entity
//@Table(name = "USUARIOS_ROLES") 
@NamedQueries({
    @NamedQuery(name = "UsuarioRol.findAll", query = "SELECT u FROM UsuarioRol u"),
    @NamedQuery(name = "UsuarioRol.findById", query = "SELECT u FROM UsuarioRol u WHERE u.id = :id"),
    @NamedQuery(name = "UsuarioRol.findByUsuario", query = "SELECT a FROM UsuarioRol a WHERE a.usuario = :usuario and a.estado = :estado"),
    @NamedQuery(name = "UsuarioRol.findByUsuarioAndRol", query = "SELECT a FROM UsuarioRol a WHERE a.usuario = :usuario and a.rol = :rol and a.estado = :estado")
    })
public class UsuarioRol extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="usuarioRol_seq_gen")
    @SequenceGenerator(name="usuarioRol_seq_gen", sequenceName="usuarios_roles_id_seq")
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "rol", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Rol rol;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;

   

	public UsuarioRol() {
    }

    public UsuarioRol(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRol)) {
            return false;
        }
        UsuarioRol other = (UsuarioRol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "UsuarioRol [id=" + id + ", rol=" + rol + ", usuario=" + usuario
				+ ", toString()=" + super.toString() + "]";
	}

   
}
