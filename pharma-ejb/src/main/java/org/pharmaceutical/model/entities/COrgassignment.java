/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "c_orgassignment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "COrgassignment.findAll", query = "SELECT c FROM COrgassignment c"),
    @NamedQuery(name = "COrgassignment.findByCOrgassignmentId", query = "SELECT c FROM COrgassignment c WHERE c.cOrgassignmentId = :cOrgassignmentId"),
    @NamedQuery(name = "COrgassignment.findByIsactive", query = "SELECT c FROM COrgassignment c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "COrgassignment.findByCreated", query = "SELECT c FROM COrgassignment c WHERE c.created = :created"),
    @NamedQuery(name = "COrgassignment.findByCreatedby", query = "SELECT c FROM COrgassignment c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "COrgassignment.findByUpdated", query = "SELECT c FROM COrgassignment c WHERE c.updated = :updated"),
    @NamedQuery(name = "COrgassignment.findByUpdatedby", query = "SELECT c FROM COrgassignment c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "COrgassignment.findByValidfrom", query = "SELECT c FROM COrgassignment c WHERE c.validfrom = :validfrom"),
    @NamedQuery(name = "COrgassignment.findByValidto", query = "SELECT c FROM COrgassignment c WHERE c.validto = :validto")})
public class COrgassignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_orgassignment_id")
    private String cOrgassignmentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isactive")
    private Character isactive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validfrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validfrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validto;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdUser adUserId;

    public COrgassignment() {
    }

    public COrgassignment(String cOrgassignmentId) {
        this.cOrgassignmentId = cOrgassignmentId;
    }

    public COrgassignment(String cOrgassignmentId, Character isactive, Date created, String createdby, Date updated, String updatedby, Date validfrom, Date validto) {
        this.cOrgassignmentId = cOrgassignmentId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.validfrom = validfrom;
        this.validto = validto;
    }

    public String getCOrgassignmentId() {
        return cOrgassignmentId;
    }

    public void setCOrgassignmentId(String cOrgassignmentId) {
        this.cOrgassignmentId = cOrgassignmentId;
    }

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Date getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(Date validfrom) {
        this.validfrom = validfrom;
    }

    public Date getValidto() {
        return validto;
    }

    public void setValidto(Date validto) {
        this.validto = validto;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cOrgassignmentId != null ? cOrgassignmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof COrgassignment)) {
            return false;
        }
        COrgassignment other = (COrgassignment) object;
        if ((this.cOrgassignmentId == null && other.cOrgassignmentId != null) || (this.cOrgassignmentId != null && !this.cOrgassignmentId.equals(other.cOrgassignmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.COrgassignment[ cOrgassignmentId=" + cOrgassignmentId + " ]";
    }
    
}
