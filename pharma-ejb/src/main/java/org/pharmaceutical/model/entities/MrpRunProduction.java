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
@Table(name = "mrp_run_production")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MrpRunProduction.findAll", query = "SELECT m FROM MrpRunProduction m"),
    @NamedQuery(name = "MrpRunProduction.findByMrpRunProductionId", query = "SELECT m FROM MrpRunProduction m WHERE m.mrpRunProductionId = :mrpRunProductionId"),
    @NamedQuery(name = "MrpRunProduction.findByIsactive", query = "SELECT m FROM MrpRunProduction m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MrpRunProduction.findByCreated", query = "SELECT m FROM MrpRunProduction m WHERE m.created = :created"),
    @NamedQuery(name = "MrpRunProduction.findByCreatedby", query = "SELECT m FROM MrpRunProduction m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MrpRunProduction.findByUpdated", query = "SELECT m FROM MrpRunProduction m WHERE m.updated = :updated"),
    @NamedQuery(name = "MrpRunProduction.findByUpdatedby", query = "SELECT m FROM MrpRunProduction m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MrpRunProduction.findByName", query = "SELECT m FROM MrpRunProduction m WHERE m.name = :name"),
    @NamedQuery(name = "MrpRunProduction.findByDescription", query = "SELECT m FROM MrpRunProduction m WHERE m.description = :description"),
    @NamedQuery(name = "MrpRunProduction.findByDatedoc", query = "SELECT m FROM MrpRunProduction m WHERE m.datedoc = :datedoc"),
    @NamedQuery(name = "MrpRunProduction.findByTimehorizon", query = "SELECT m FROM MrpRunProduction m WHERE m.timehorizon = :timehorizon"),
    @NamedQuery(name = "MrpRunProduction.findBySecuritymargin", query = "SELECT m FROM MrpRunProduction m WHERE m.securitymargin = :securitymargin"),
    @NamedQuery(name = "MrpRunProduction.findBySimulate", query = "SELECT m FROM MrpRunProduction m WHERE m.simulate = :simulate"),
    @NamedQuery(name = "MrpRunProduction.findByLaunchwr", query = "SELECT m FROM MrpRunProduction m WHERE m.launchwr = :launchwr"),
    @NamedQuery(name = "MrpRunProduction.findByLaunchmr", query = "SELECT m FROM MrpRunProduction m WHERE m.launchmr = :launchmr"),
    @NamedQuery(name = "MrpRunProduction.findByRecalculatestock", query = "SELECT m FROM MrpRunProduction m WHERE m.recalculatestock = :recalculatestock")})
public class MrpRunProduction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "mrp_run_production_id")
    private String mrpRunProductionId;
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
    @Column(name = "launchwr")
    private Character launchwr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "launchmr")
    private Character launchmr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recalculatestock")
    private Character recalculatestock;
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
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_category_id", referencedColumnName = "m_product_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductCategory mProductCategoryId;
    @JoinColumn(name = "mrp_planner_id", referencedColumnName = "mrp_planner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MrpPlanner mrpPlannerId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mrpRunProductionId")
    private List<MrpRunProductionline> mrpRunProductionlineList;

    public MrpRunProduction() {
    }

    public MrpRunProduction(String mrpRunProductionId) {
        this.mrpRunProductionId = mrpRunProductionId;
    }

    public MrpRunProduction(String mrpRunProductionId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Date datedoc, BigInteger timehorizon, BigInteger securitymargin, Character simulate, Character launchwr, Character launchmr, Character recalculatestock) {
        this.mrpRunProductionId = mrpRunProductionId;
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
        this.launchwr = launchwr;
        this.launchmr = launchmr;
        this.recalculatestock = recalculatestock;
    }

    public String getMrpRunProductionId() {
        return mrpRunProductionId;
    }

    public void setMrpRunProductionId(String mrpRunProductionId) {
        this.mrpRunProductionId = mrpRunProductionId;
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

    public Character getLaunchwr() {
        return launchwr;
    }

    public void setLaunchwr(Character launchwr) {
        this.launchwr = launchwr;
    }

    public Character getLaunchmr() {
        return launchmr;
    }

    public void setLaunchmr(Character launchmr) {
        this.launchmr = launchmr;
    }

    public Character getRecalculatestock() {
        return recalculatestock;
    }

    public void setRecalculatestock(Character recalculatestock) {
        this.recalculatestock = recalculatestock;
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
    public List<MrpRunProductionline> getMrpRunProductionlineList() {
        return mrpRunProductionlineList;
    }

    public void setMrpRunProductionlineList(List<MrpRunProductionline> mrpRunProductionlineList) {
        this.mrpRunProductionlineList = mrpRunProductionlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mrpRunProductionId != null ? mrpRunProductionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MrpRunProduction)) {
            return false;
        }
        MrpRunProduction other = (MrpRunProduction) object;
        if ((this.mrpRunProductionId == null && other.mrpRunProductionId != null) || (this.mrpRunProductionId != null && !this.mrpRunProductionId.equals(other.mrpRunProductionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MrpRunProduction[ mrpRunProductionId=" + mrpRunProductionId + " ]";
    }
    
}
