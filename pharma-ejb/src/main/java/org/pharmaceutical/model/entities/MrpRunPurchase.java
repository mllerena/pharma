/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "mrp_run_purchase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MrpRunPurchase.findAll", query = "SELECT m FROM MrpRunPurchase m"),
    @NamedQuery(name = "MrpRunPurchase.findByMrpRunPurchaseId", query = "SELECT m FROM MrpRunPurchase m WHERE m.mrpRunPurchaseId = :mrpRunPurchaseId"),
    @NamedQuery(name = "MrpRunPurchase.findByIsactive", query = "SELECT m FROM MrpRunPurchase m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MrpRunPurchase.findByCreated", query = "SELECT m FROM MrpRunPurchase m WHERE m.created = :created"),
    @NamedQuery(name = "MrpRunPurchase.findByCreatedby", query = "SELECT m FROM MrpRunPurchase m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MrpRunPurchase.findByUpdated", query = "SELECT m FROM MrpRunPurchase m WHERE m.updated = :updated"),
    @NamedQuery(name = "MrpRunPurchase.findByUpdatedby", query = "SELECT m FROM MrpRunPurchase m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MrpRunPurchase.findByName", query = "SELECT m FROM MrpRunPurchase m WHERE m.name = :name"),
    @NamedQuery(name = "MrpRunPurchase.findByDescription", query = "SELECT m FROM MrpRunPurchase m WHERE m.description = :description"),
    @NamedQuery(name = "MrpRunPurchase.findByDatedoc", query = "SELECT m FROM MrpRunPurchase m WHERE m.datedoc = :datedoc"),
    @NamedQuery(name = "MrpRunPurchase.findByTimehorizon", query = "SELECT m FROM MrpRunPurchase m WHERE m.timehorizon = :timehorizon"),
    @NamedQuery(name = "MrpRunPurchase.findBySecuritymargin", query = "SELECT m FROM MrpRunPurchase m WHERE m.securitymargin = :securitymargin"),
    @NamedQuery(name = "MrpRunPurchase.findBySimulate", query = "SELECT m FROM MrpRunPurchase m WHERE m.simulate = :simulate"),
    @NamedQuery(name = "MrpRunPurchase.findByLaunchpo", query = "SELECT m FROM MrpRunPurchase m WHERE m.launchpo = :launchpo")})
public class MrpRunPurchase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "mrp_run_purchase_id")
    private String mrpRunPurchaseId;
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
    @Column(name = "datedoc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timehorizon")
    private BigInteger timehorizon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "securitymargin")
    private BigInteger securitymargin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "simulate")
    private Character simulate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "launchpo")
    private Character launchpo;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bp_group_id", referencedColumnName = "c_bp_group_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpGroup cBpGroupId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "vendor_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner vendorId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_category_id", referencedColumnName = "m_product_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductCategory mProductCategoryId;
    @JoinColumn(name = "mrp_planner_id", referencedColumnName = "mrp_planner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MrpPlanner mrpPlannerId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mrpRunPurchaseId")
    private List<MrpRunPurchaseline> mrpRunPurchaselineList;

    public MrpRunPurchase() {
    }

    public MrpRunPurchase(String mrpRunPurchaseId) {
        this.mrpRunPurchaseId = mrpRunPurchaseId;
    }

    public MrpRunPurchase(String mrpRunPurchaseId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Date datedoc, BigInteger timehorizon, BigInteger securitymargin, Character simulate, Character launchpo) {
        this.mrpRunPurchaseId = mrpRunPurchaseId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.datedoc = datedoc;
        this.timehorizon = timehorizon;
        this.securitymargin = securitymargin;
        this.simulate = simulate;
        this.launchpo = launchpo;
    }

    public String getMrpRunPurchaseId() {
        return mrpRunPurchaseId;
    }

    public void setMrpRunPurchaseId(String mrpRunPurchaseId) {
        this.mrpRunPurchaseId = mrpRunPurchaseId;
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

    public Date getDatedoc() {
        return datedoc;
    }

    public void setDatedoc(Date datedoc) {
        this.datedoc = datedoc;
    }

    public BigInteger getTimehorizon() {
        return timehorizon;
    }

    public void setTimehorizon(BigInteger timehorizon) {
        this.timehorizon = timehorizon;
    }

    public BigInteger getSecuritymargin() {
        return securitymargin;
    }

    public void setSecuritymargin(BigInteger securitymargin) {
        this.securitymargin = securitymargin;
    }

    public Character getSimulate() {
        return simulate;
    }

    public void setSimulate(Character simulate) {
        this.simulate = simulate;
    }

    public Character getLaunchpo() {
        return launchpo;
    }

    public void setLaunchpo(Character launchpo) {
        this.launchpo = launchpo;
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

    public CBpGroup getCBpGroupId() {
        return cBpGroupId;
    }

    public void setCBpGroupId(CBpGroup cBpGroupId) {
        this.cBpGroupId = cBpGroupId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CBpartner getVendorId() {
        return vendorId;
    }

    public void setVendorId(CBpartner vendorId) {
        this.vendorId = vendorId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public MProductCategory getMProductCategoryId() {
        return mProductCategoryId;
    }

    public void setMProductCategoryId(MProductCategory mProductCategoryId) {
        this.mProductCategoryId = mProductCategoryId;
    }

    public MrpPlanner getMrpPlannerId() {
        return mrpPlannerId;
    }

    public void setMrpPlannerId(MrpPlanner mrpPlannerId) {
        this.mrpPlannerId = mrpPlannerId;
    }

    @XmlTransient
    public List<MrpRunPurchaseline> getMrpRunPurchaselineList() {
        return mrpRunPurchaselineList;
    }

    public void setMrpRunPurchaselineList(List<MrpRunPurchaseline> mrpRunPurchaselineList) {
        this.mrpRunPurchaselineList = mrpRunPurchaselineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mrpRunPurchaseId != null ? mrpRunPurchaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MrpRunPurchase)) {
            return false;
        }
        MrpRunPurchase other = (MrpRunPurchase) object;
        if ((this.mrpRunPurchaseId == null && other.mrpRunPurchaseId != null) || (this.mrpRunPurchaseId != null && !this.mrpRunPurchaseId.equals(other.mrpRunPurchaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MrpRunPurchase[ mrpRunPurchaseId=" + mrpRunPurchaseId + " ]";
    }
    
}
