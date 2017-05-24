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
@Table(name = "ad_session_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdSessionStatus.findAll", query = "SELECT a FROM AdSessionStatus a"),
    @NamedQuery(name = "AdSessionStatus.findByAdSessionStatusId", query = "SELECT a FROM AdSessionStatus a WHERE a.adSessionStatusId = :adSessionStatusId"),
    @NamedQuery(name = "AdSessionStatus.findByIsactive", query = "SELECT a FROM AdSessionStatus a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdSessionStatus.findByCreated", query = "SELECT a FROM AdSessionStatus a WHERE a.created = :created"),
    @NamedQuery(name = "AdSessionStatus.findByCreatedby", query = "SELECT a FROM AdSessionStatus a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdSessionStatus.findByUpdated", query = "SELECT a FROM AdSessionStatus a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdSessionStatus.findByUpdatedby", query = "SELECT a FROM AdSessionStatus a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdSessionStatus.findByIsimporting", query = "SELECT a FROM AdSessionStatus a WHERE a.isimporting = :isimporting")})
public class AdSessionStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_session_status_id")
    private String adSessionStatusId;
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
    @Column(name = "isimporting")
    private Character isimporting;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdSessionStatus() {
    }

    public AdSessionStatus(String adSessionStatusId) {
        this.adSessionStatusId = adSessionStatusId;
    }

    public AdSessionStatus(String adSessionStatusId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character isimporting) {
        this.adSessionStatusId = adSessionStatusId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isimporting = isimporting;
    }

    public String getAdSessionStatusId() {
        return adSessionStatusId;
    }

    public void setAdSessionStatusId(String adSessionStatusId) {
        this.adSessionStatusId = adSessionStatusId;
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

    public Character getIsimporting() {
        return isimporting;
    }

    public void setIsimporting(Character isimporting) {
        this.isimporting = isimporting;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adSessionStatusId != null ? adSessionStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdSessionStatus)) {
            return false;
        }
        AdSessionStatus other = (AdSessionStatus) object;
        if ((this.adSessionStatusId == null && other.adSessionStatusId != null) || (this.adSessionStatusId != null && !this.adSessionStatusId.equals(other.adSessionStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdSessionStatus[ adSessionStatusId=" + adSessionStatusId + " ]";
    }
    
}
