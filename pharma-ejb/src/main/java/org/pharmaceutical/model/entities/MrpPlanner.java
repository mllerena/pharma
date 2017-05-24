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
@Table(name = "mrp_planner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MrpPlanner.findAll", query = "SELECT m FROM MrpPlanner m"),
    @NamedQuery(name = "MrpPlanner.findByMrpPlannerId", query = "SELECT m FROM MrpPlanner m WHERE m.mrpPlannerId = :mrpPlannerId"),
    @NamedQuery(name = "MrpPlanner.findByIsactive", query = "SELECT m FROM MrpPlanner m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MrpPlanner.findByCreated", query = "SELECT m FROM MrpPlanner m WHERE m.created = :created"),
    @NamedQuery(name = "MrpPlanner.findByCreatedby", query = "SELECT m FROM MrpPlanner m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MrpPlanner.findByUpdated", query = "SELECT m FROM MrpPlanner m WHERE m.updated = :updated"),
    @NamedQuery(name = "MrpPlanner.findByUpdatedby", query = "SELECT m FROM MrpPlanner m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MrpPlanner.findByName", query = "SELECT m FROM MrpPlanner m WHERE m.name = :name"),
    @NamedQuery(name = "MrpPlanner.findByDescription", query = "SELECT m FROM MrpPlanner m WHERE m.description = :description"),
    @NamedQuery(name = "MrpPlanner.findByIsproduction", query = "SELECT m FROM MrpPlanner m WHERE m.isproduction = :isproduction"),
    @NamedQuery(name = "MrpPlanner.findByIspurchase", query = "SELECT m FROM MrpPlanner m WHERE m.ispurchase = :ispurchase")})
public class MrpPlanner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "mrp_planner_id")
    private String mrpPlannerId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "isproduction")
    private Character isproduction;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ispurchase")
    private Character ispurchase;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mrpPlannerId")
    private List<MProduct> mProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mrpPlannerId")
    private List<MrpRunPurchase> mrpRunPurchaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mrpPlannerId")
    private List<MProductOrg> mProductOrgList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mrpPlannerId")
    private List<MrpRunProduction> mrpRunProductionList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public MrpPlanner() {
    }

    public MrpPlanner(String mrpPlannerId) {
        this.mrpPlannerId = mrpPlannerId;
    }

    public MrpPlanner(String mrpPlannerId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character isproduction, Character ispurchase) {
        this.mrpPlannerId = mrpPlannerId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.isproduction = isproduction;
        this.ispurchase = ispurchase;
    }

    public String getMrpPlannerId() {
        return mrpPlannerId;
    }

    public void setMrpPlannerId(String mrpPlannerId) {
        this.mrpPlannerId = mrpPlannerId;
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

    public Character getIsproduction() {
        return isproduction;
    }

    public void setIsproduction(Character isproduction) {
        this.isproduction = isproduction;
    }

    public Character getIspurchase() {
        return ispurchase;
    }

    public void setIspurchase(Character ispurchase) {
        this.ispurchase = ispurchase;
    }

    @XmlTransient
    public List<MProduct> getMProductList() {
        return mProductList;
    }

    public void setMProductList(List<MProduct> mProductList) {
        this.mProductList = mProductList;
    }

    @XmlTransient
    public List<MrpRunPurchase> getMrpRunPurchaseList() {
        return mrpRunPurchaseList;
    }

    public void setMrpRunPurchaseList(List<MrpRunPurchase> mrpRunPurchaseList) {
        this.mrpRunPurchaseList = mrpRunPurchaseList;
    }

    @XmlTransient
    public List<MProductOrg> getMProductOrgList() {
        return mProductOrgList;
    }

    public void setMProductOrgList(List<MProductOrg> mProductOrgList) {
        this.mProductOrgList = mProductOrgList;
    }

    @XmlTransient
    public List<MrpRunProduction> getMrpRunProductionList() {
        return mrpRunProductionList;
    }

    public void setMrpRunProductionList(List<MrpRunProduction> mrpRunProductionList) {
        this.mrpRunProductionList = mrpRunProductionList;
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
        hash += (mrpPlannerId != null ? mrpPlannerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MrpPlanner)) {
            return false;
        }
        MrpPlanner other = (MrpPlanner) object;
        if ((this.mrpPlannerId == null && other.mrpPlannerId != null) || (this.mrpPlannerId != null && !this.mrpPlannerId.equals(other.mrpPlannerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MrpPlanner[ mrpPlannerId=" + mrpPlannerId + " ]";
    }
    
}
