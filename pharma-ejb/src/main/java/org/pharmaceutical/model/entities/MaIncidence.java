/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ma_incidence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaIncidence.findAll", query = "SELECT m FROM MaIncidence m"),
    @NamedQuery(name = "MaIncidence.findByMaIncidenceId", query = "SELECT m FROM MaIncidence m WHERE m.maIncidenceId = :maIncidenceId"),
    @NamedQuery(name = "MaIncidence.findByIsactive", query = "SELECT m FROM MaIncidence m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaIncidence.findByCreated", query = "SELECT m FROM MaIncidence m WHERE m.created = :created"),
    @NamedQuery(name = "MaIncidence.findByCreatedby", query = "SELECT m FROM MaIncidence m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaIncidence.findByUpdated", query = "SELECT m FROM MaIncidence m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaIncidence.findByUpdatedby", query = "SELECT m FROM MaIncidence m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaIncidence.findByName", query = "SELECT m FROM MaIncidence m WHERE m.name = :name"),
    @NamedQuery(name = "MaIncidence.findByDescription", query = "SELECT m FROM MaIncidence m WHERE m.description = :description"),
    @NamedQuery(name = "MaIncidence.findByStrtime", query = "SELECT m FROM MaIncidence m WHERE m.strtime = :strtime")})
public class MaIncidence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_incidence_id")
    private String maIncidenceId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 10)
    @Column(name = "strtime")
    private String strtime;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maIncidenceId")
    private List<MaWeincidence> maWeincidenceList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public MaIncidence() {
    }

    public MaIncidence(String maIncidenceId) {
        this.maIncidenceId = maIncidenceId;
    }

    public MaIncidence(String maIncidenceId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.maIncidenceId = maIncidenceId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getMaIncidenceId() {
        return maIncidenceId;
    }

    public void setMaIncidenceId(String maIncidenceId) {
        this.maIncidenceId = maIncidenceId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStrtime() {
        return strtime;
    }

    public void setStrtime(String strtime) {
        this.strtime = strtime;
    }

    @XmlTransient
    public List<MaWeincidence> getMaWeincidenceList() {
        return maWeincidenceList;
    }

    public void setMaWeincidenceList(List<MaWeincidence> maWeincidenceList) {
        this.maWeincidenceList = maWeincidenceList;
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
        hash += (maIncidenceId != null ? maIncidenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaIncidence)) {
            return false;
        }
        MaIncidence other = (MaIncidence) object;
        if ((this.maIncidenceId == null && other.maIncidenceId != null) || (this.maIncidenceId != null && !this.maIncidenceId.equals(other.maIncidenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaIncidence[ maIncidenceId=" + maIncidenceId + " ]";
    }
    
}
