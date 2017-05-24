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
@Table(name = "mrp_planningmethod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MrpPlanningmethod.findAll", query = "SELECT m FROM MrpPlanningmethod m"),
    @NamedQuery(name = "MrpPlanningmethod.findByMrpPlanningmethodId", query = "SELECT m FROM MrpPlanningmethod m WHERE m.mrpPlanningmethodId = :mrpPlanningmethodId"),
    @NamedQuery(name = "MrpPlanningmethod.findByIsactive", query = "SELECT m FROM MrpPlanningmethod m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MrpPlanningmethod.findByCreated", query = "SELECT m FROM MrpPlanningmethod m WHERE m.created = :created"),
    @NamedQuery(name = "MrpPlanningmethod.findByCreatedby", query = "SELECT m FROM MrpPlanningmethod m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MrpPlanningmethod.findByUpdated", query = "SELECT m FROM MrpPlanningmethod m WHERE m.updated = :updated"),
    @NamedQuery(name = "MrpPlanningmethod.findByUpdatedby", query = "SELECT m FROM MrpPlanningmethod m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MrpPlanningmethod.findByName", query = "SELECT m FROM MrpPlanningmethod m WHERE m.name = :name"),
    @NamedQuery(name = "MrpPlanningmethod.findByDescription", query = "SELECT m FROM MrpPlanningmethod m WHERE m.description = :description")})
public class MrpPlanningmethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "mrp_planningmethod_id")
    private String mrpPlanningmethodId;
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
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mrpPlanningmethodId")
    private List<MProduct> mProductList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mrpPlanningmethodId")
    private List<MrpPlanningmethodline> mrpPlanningmethodlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mrpPlanningmethodId")
    private List<MProductOrg> mProductOrgList;

    public MrpPlanningmethod() {
    }

    public MrpPlanningmethod(String mrpPlanningmethodId) {
        this.mrpPlanningmethodId = mrpPlanningmethodId;
    }

    public MrpPlanningmethod(String mrpPlanningmethodId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.mrpPlanningmethodId = mrpPlanningmethodId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getMrpPlanningmethodId() {
        return mrpPlanningmethodId;
    }

    public void setMrpPlanningmethodId(String mrpPlanningmethodId) {
        this.mrpPlanningmethodId = mrpPlanningmethodId;
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

    @XmlTransient
    public List<MProduct> getMProductList() {
        return mProductList;
    }

    public void setMProductList(List<MProduct> mProductList) {
        this.mProductList = mProductList;
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

    @XmlTransient
    public List<MrpPlanningmethodline> getMrpPlanningmethodlineList() {
        return mrpPlanningmethodlineList;
    }

    public void setMrpPlanningmethodlineList(List<MrpPlanningmethodline> mrpPlanningmethodlineList) {
        this.mrpPlanningmethodlineList = mrpPlanningmethodlineList;
    }

    @XmlTransient
    public List<MProductOrg> getMProductOrgList() {
        return mProductOrgList;
    }

    public void setMProductOrgList(List<MProductOrg> mProductOrgList) {
        this.mProductOrgList = mProductOrgList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mrpPlanningmethodId != null ? mrpPlanningmethodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MrpPlanningmethod)) {
            return false;
        }
        MrpPlanningmethod other = (MrpPlanningmethod) object;
        if ((this.mrpPlanningmethodId == null && other.mrpPlanningmethodId != null) || (this.mrpPlanningmethodId != null && !this.mrpPlanningmethodId.equals(other.mrpPlanningmethodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MrpPlanningmethod[ mrpPlanningmethodId=" + mrpPlanningmethodId + " ]";
    }
    
}
