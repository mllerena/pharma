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
import javax.persistence.FetchType;
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
@Table(name = "ad_extension_points")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdExtensionPoints.findAll", query = "SELECT a FROM AdExtensionPoints a"),
    @NamedQuery(name = "AdExtensionPoints.findByAdExtensionPointsId", query = "SELECT a FROM AdExtensionPoints a WHERE a.adExtensionPointsId = :adExtensionPointsId"),
    @NamedQuery(name = "AdExtensionPoints.findByCreated", query = "SELECT a FROM AdExtensionPoints a WHERE a.created = :created"),
    @NamedQuery(name = "AdExtensionPoints.findByCreatedby", query = "SELECT a FROM AdExtensionPoints a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdExtensionPoints.findByUpdated", query = "SELECT a FROM AdExtensionPoints a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdExtensionPoints.findByUpdatedby", query = "SELECT a FROM AdExtensionPoints a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdExtensionPoints.findByName", query = "SELECT a FROM AdExtensionPoints a WHERE a.name = :name"),
    @NamedQuery(name = "AdExtensionPoints.findByDescription", query = "SELECT a FROM AdExtensionPoints a WHERE a.description = :description"),
    @NamedQuery(name = "AdExtensionPoints.findByIsactive", query = "SELECT a FROM AdExtensionPoints a WHERE a.isactive = :isactive")})
public class AdExtensionPoints implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_extension_points_id")
    private String adExtensionPointsId;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "isactive")
    private Character isactive;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adExtensionPointsId")
    private List<AdEpInstancePara> adEpInstanceParaList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adExtensionPointsId")
    private List<AdEpProcedures> adEpProceduresList;

    public AdExtensionPoints() {
    }

    public AdExtensionPoints(String adExtensionPointsId) {
        this.adExtensionPointsId = adExtensionPointsId;
    }

    public AdExtensionPoints(String adExtensionPointsId, Date created, String createdby, Date updated, String updatedby, String name, String description) {
        this.adExtensionPointsId = adExtensionPointsId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.description = description;
    }

    public String getAdExtensionPointsId() {
        return adExtensionPointsId;
    }

    public void setAdExtensionPointsId(String adExtensionPointsId) {
        this.adExtensionPointsId = adExtensionPointsId;
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

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    @XmlTransient
    public List<AdEpInstancePara> getAdEpInstanceParaList() {
        return adEpInstanceParaList;
    }

    public void setAdEpInstanceParaList(List<AdEpInstancePara> adEpInstanceParaList) {
        this.adEpInstanceParaList = adEpInstanceParaList;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdModule getAdModuleId() {
        return adModuleId;
    }

    public void setAdModuleId(AdModule adModuleId) {
        this.adModuleId = adModuleId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    @XmlTransient
    public List<AdEpProcedures> getAdEpProceduresList() {
        return adEpProceduresList;
    }

    public void setAdEpProceduresList(List<AdEpProcedures> adEpProceduresList) {
        this.adEpProceduresList = adEpProceduresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adExtensionPointsId != null ? adExtensionPointsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdExtensionPoints)) {
            return false;
        }
        AdExtensionPoints other = (AdExtensionPoints) object;
        if ((this.adExtensionPointsId == null && other.adExtensionPointsId != null) || (this.adExtensionPointsId != null && !this.adExtensionPointsId.equals(other.adExtensionPointsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdExtensionPoints[ adExtensionPointsId=" + adExtensionPointsId + " ]";
    }
    
}
