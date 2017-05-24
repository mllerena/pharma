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
@Table(name = "ma_weincidence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaWeincidence.findAll", query = "SELECT m FROM MaWeincidence m"),
    @NamedQuery(name = "MaWeincidence.findByMaWeincidenceId", query = "SELECT m FROM MaWeincidence m WHERE m.maWeincidenceId = :maWeincidenceId"),
    @NamedQuery(name = "MaWeincidence.findByIsactive", query = "SELECT m FROM MaWeincidence m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaWeincidence.findByCreated", query = "SELECT m FROM MaWeincidence m WHERE m.created = :created"),
    @NamedQuery(name = "MaWeincidence.findByCreatedby", query = "SELECT m FROM MaWeincidence m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaWeincidence.findByUpdated", query = "SELECT m FROM MaWeincidence m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaWeincidence.findByUpdatedby", query = "SELECT m FROM MaWeincidence m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaWeincidence.findByStarttime", query = "SELECT m FROM MaWeincidence m WHERE m.starttime = :starttime"),
    @NamedQuery(name = "MaWeincidence.findByEndtime", query = "SELECT m FROM MaWeincidence m WHERE m.endtime = :endtime"),
    @NamedQuery(name = "MaWeincidence.findByDescription", query = "SELECT m FROM MaWeincidence m WHERE m.description = :description")})
public class MaWeincidence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_weincidence_id")
    private String maWeincidenceId;
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
    @Column(name = "starttime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_production_id", referencedColumnName = "m_production_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduction mProductionId;
    @JoinColumn(name = "ma_incidence_id", referencedColumnName = "ma_incidence_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaIncidence maIncidenceId;

    public MaWeincidence() {
    }

    public MaWeincidence(String maWeincidenceId) {
        this.maWeincidenceId = maWeincidenceId;
    }

    public MaWeincidence(String maWeincidenceId, Character isactive, Date created, String createdby, Date updated, String updatedby, Date starttime, Date endtime) {
        this.maWeincidenceId = maWeincidenceId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public String getMaWeincidenceId() {
        return maWeincidenceId;
    }

    public void setMaWeincidenceId(String maWeincidenceId) {
        this.maWeincidenceId = maWeincidenceId;
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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public MProduction getMProductionId() {
        return mProductionId;
    }

    public void setMProductionId(MProduction mProductionId) {
        this.mProductionId = mProductionId;
    }

    public MaIncidence getMaIncidenceId() {
        return maIncidenceId;
    }

    public void setMaIncidenceId(MaIncidence maIncidenceId) {
        this.maIncidenceId = maIncidenceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maWeincidenceId != null ? maWeincidenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaWeincidence)) {
            return false;
        }
        MaWeincidence other = (MaWeincidence) object;
        if ((this.maWeincidenceId == null && other.maWeincidenceId != null) || (this.maWeincidenceId != null && !this.maWeincidenceId.equals(other.maWeincidenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaWeincidence[ maWeincidenceId=" + maWeincidenceId + " ]";
    }
    
}
