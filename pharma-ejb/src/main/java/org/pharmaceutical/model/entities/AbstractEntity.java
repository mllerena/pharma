package org.pharmaceutical.model.entities;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.SessionContext;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.pharmaceutical.model.converters.EstadoConverter;
import org.pharmaceutical.model.enums.Estado;
import org.pharmaceutical.model.listeners.AuditEntityListener;

@MappedSuperclass
@EntityListeners(value= AuditEntityListener.class)
public abstract class AbstractEntity {  
	
	public abstract Long getId();
	
	@Basic(optional = false)
    @NotNull
	@Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
	
	@Basic(optional = false)
    @NotNull
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
	@Basic(optional = false)
    @NotNull 
    @Size(max = 45)
    @Column(name = "usuario_ingreso")
    private String usuarioIngreso;
    
	@Basic(optional = false)
    @NotNull
    @Size(max = 45)
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
	
	@Basic(optional = false)
    @NotNull
	@Column(name = "estado")
	@Convert(converter=EstadoConverter.class)
	private Estado estado;
	
	@Transient
	private boolean change;
	
	public boolean isChange() {
		return change;
	}

	public void setChange(boolean change) {
		this.change = change;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioIngreso() {
		return usuarioIngreso;
	}

	public void setUsuarioIngreso(String usuarioIngreso) {
		this.usuarioIngreso = usuarioIngreso;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	@Override
	public String toString() {
		return "AbstractEntity [fechaCreacion=" + fechaCreacion
				+ ", fechaModificacion=" + fechaModificacion
				+ ", usuarioIngreso=" + usuarioIngreso
				+ ", usuarioModificacion=" + usuarioModificacion + ", estado="
				+ estado + ", change=" + change + "]";
	} 

	
	
	
	
    

}
