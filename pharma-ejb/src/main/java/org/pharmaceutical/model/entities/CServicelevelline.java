/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "c_servicelevelline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CServicelevelline.findAll", query = "SELECT c FROM CServicelevelline c"),
    @NamedQuery(name = "CServicelevelline.findByCServicelevellineId", query = "SELECT c FROM CServicelevelline c WHERE c.cServicelevellineId = :cServicelevellineId"),
    @NamedQuery(name = "CServicelevelline.findByIsactive", query = "SELECT c FROM CServicelevelline c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CServicelevelline.findByCreated", query = "SELECT c FROM CServicelevelline c WHERE c.created = :created"),
    @NamedQuery(name = "CServicelevelline.findByCreatedby", query = "SELECT c FROM CServicelevelline c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CServicelevelline.findByUpdated", query = "SELECT c FROM CServicelevelline c WHERE c.updated = :updated"),
    @NamedQuery(name = "CServicelevelline.findByUpdatedby", query = "SELECT c FROM CServicelevelline c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CServicelevelline.findByDescription", query = "SELECT c FROM CServicelevelline c WHERE c.description = :description"),
    @NamedQuery(name = "CServicelevelline.findByServicelevelprovided", query = "SELECT c FROM CServicelevelline c WHERE c.servicelevelprovided = :servicelevelprovided"),
    @NamedQuery(name = "CServicelevelline.findByServicedate", query = "SELECT c FROM CServicelevelline c WHERE c.servicedate = :servicedate"),
    @NamedQuery(name = "CServicelevelline.findByProcessed", query = "SELECT c FROM CServicelevelline c WHERE c.processed = :processed")})
public class CServicelevelline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_servicelevelline_id")
    private String cServicelevellineId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "servicelevelprovided")
    private BigInteger servicelevelprovided;
    @Basic(optional = false)
    @NotNull
    @Column(name = "servicedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date servicedate;
    @Column(name = "processed")
    private Character processed;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_servicelevel_id", referencedColumnName = "c_servicelevel_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CServicelevel cServicelevelId;

    public CServicelevelline() {
    }

    public CServicelevelline(String cServicelevellineId) {
        this.cServicelevellineId = cServicelevellineId;
    }

    public CServicelevelline(String cServicelevellineId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger servicelevelprovided, Date servicedate) {
        this.cServicelevellineId = cServicelevellineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.servicelevelprovided = servicelevelprovided;
        this.servicedate = servicedate;
    }

    public String getCServicelevellineId() {
        return cServicelevellineId;
    }

    public void setCServicelevellineId(String cServicelevellineId) {
        this.cServicelevellineId = cServicelevellineId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getServicelevelprovided() {
        return servicelevelprovided;
    }

    public void setServicelevelprovided(BigInteger servicelevelprovided) {
        this.servicelevelprovided = servicelevelprovided;
    }

    public Date getServicedate() {
        return servicedate;
    }

    public void setServicedate(Date servicedate) {
        this.servicedate = servicedate;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
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

    public CServicelevel getCServicelevelId() {
        return cServicelevelId;
    }

    public void setCServicelevelId(CServicelevel cServicelevelId) {
        this.cServicelevelId = cServicelevelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cServicelevellineId != null ? cServicelevellineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CServicelevelline)) {
            return false;
        }
        CServicelevelline other = (CServicelevelline) object;
        if ((this.cServicelevellineId == null && other.cServicelevellineId != null) || (this.cServicelevellineId != null && !this.cServicelevellineId.equals(other.cServicelevellineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CServicelevelline[ cServicelevellineId=" + cServicelevellineId + " ]";
    }
    
}
