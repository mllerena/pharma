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
@Table(name = "mrp_salesforecastline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MrpSalesforecastline.findAll", query = "SELECT m FROM MrpSalesforecastline m"),
    @NamedQuery(name = "MrpSalesforecastline.findByMrpSalesforecastlineId", query = "SELECT m FROM MrpSalesforecastline m WHERE m.mrpSalesforecastlineId = :mrpSalesforecastlineId"),
    @NamedQuery(name = "MrpSalesforecastline.findByIsactive", query = "SELECT m FROM MrpSalesforecastline m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MrpSalesforecastline.findByCreated", query = "SELECT m FROM MrpSalesforecastline m WHERE m.created = :created"),
    @NamedQuery(name = "MrpSalesforecastline.findByCreatedby", query = "SELECT m FROM MrpSalesforecastline m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MrpSalesforecastline.findByUpdated", query = "SELECT m FROM MrpSalesforecastline m WHERE m.updated = :updated"),
    @NamedQuery(name = "MrpSalesforecastline.findByUpdatedby", query = "SELECT m FROM MrpSalesforecastline m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MrpSalesforecastline.findByQty", query = "SELECT m FROM MrpSalesforecastline m WHERE m.qty = :qty"),
    @NamedQuery(name = "MrpSalesforecastline.findByDateplanned", query = "SELECT m FROM MrpSalesforecastline m WHERE m.dateplanned = :dateplanned")})
public class MrpSalesforecastline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "mrp_salesforecastline_id")
    private String mrpSalesforecastlineId;
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
    @Column(name = "qty")
    private BigInteger qty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateplanned")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateplanned;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mrpSalesforecastlineId")
    private List<MrpRunPurchaseline> mrpRunPurchaselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mrpSalesforecastlineId")
    private List<MrpRunProductionline> mrpRunProductionlineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "mrp_salesforecast_id", referencedColumnName = "mrp_salesforecast_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MrpSalesforecast mrpSalesforecastId;

    public MrpSalesforecastline() {
    }

    public MrpSalesforecastline(String mrpSalesforecastlineId) {
        this.mrpSalesforecastlineId = mrpSalesforecastlineId;
    }

    public MrpSalesforecastline(String mrpSalesforecastlineId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger qty, Date dateplanned) {
        this.mrpSalesforecastlineId = mrpSalesforecastlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.qty = qty;
        this.dateplanned = dateplanned;
    }

    public String getMrpSalesforecastlineId() {
        return mrpSalesforecastlineId;
    }

    public void setMrpSalesforecastlineId(String mrpSalesforecastlineId) {
        this.mrpSalesforecastlineId = mrpSalesforecastlineId;
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

    public BigInteger getQty() {
        return qty;
    }

    public void setQty(BigInteger qty) {
        this.qty = qty;
    }

    public Date getDateplanned() {
        return dateplanned;
    }

    public void setDateplanned(Date dateplanned) {
        this.dateplanned = dateplanned;
    }

    @XmlTransient
    public List<MrpRunPurchaseline> getMrpRunPurchaselineList() {
        return mrpRunPurchaselineList;
    }

    public void setMrpRunPurchaselineList(List<MrpRunPurchaseline> mrpRunPurchaselineList) {
        this.mrpRunPurchaselineList = mrpRunPurchaselineList;
    }

    @XmlTransient
    public List<MrpRunProductionline> getMrpRunProductionlineList() {
        return mrpRunProductionlineList;
    }

    public void setMrpRunProductionlineList(List<MrpRunProductionline> mrpRunProductionlineList) {
        this.mrpRunProductionlineList = mrpRunProductionlineList;
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

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public MrpSalesforecast getMrpSalesforecastId() {
        return mrpSalesforecastId;
    }

    public void setMrpSalesforecastId(MrpSalesforecast mrpSalesforecastId) {
        this.mrpSalesforecastId = mrpSalesforecastId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mrpSalesforecastlineId != null ? mrpSalesforecastlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MrpSalesforecastline)) {
            return false;
        }
        MrpSalesforecastline other = (MrpSalesforecastline) object;
        if ((this.mrpSalesforecastlineId == null && other.mrpSalesforecastlineId != null) || (this.mrpSalesforecastlineId != null && !this.mrpSalesforecastlineId.equals(other.mrpSalesforecastlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MrpSalesforecastline[ mrpSalesforecastlineId=" + mrpSalesforecastlineId + " ]";
    }
    
}
