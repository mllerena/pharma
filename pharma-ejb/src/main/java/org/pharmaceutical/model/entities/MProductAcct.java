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
@Table(name = "m_product_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MProductAcct.findAll", query = "SELECT m FROM MProductAcct m"),
    @NamedQuery(name = "MProductAcct.findByMProductAcctId", query = "SELECT m FROM MProductAcct m WHERE m.mProductAcctId = :mProductAcctId"),
    @NamedQuery(name = "MProductAcct.findByIsactive", query = "SELECT m FROM MProductAcct m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MProductAcct.findByCreated", query = "SELECT m FROM MProductAcct m WHERE m.created = :created"),
    @NamedQuery(name = "MProductAcct.findByCreatedby", query = "SELECT m FROM MProductAcct m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MProductAcct.findByUpdated", query = "SELECT m FROM MProductAcct m WHERE m.updated = :updated"),
    @NamedQuery(name = "MProductAcct.findByUpdatedby", query = "SELECT m FROM MProductAcct m WHERE m.updatedby = :updatedby")})
public class MProductAcct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_product_acct_id")
    private String mProductAcctId;
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
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "p_revenue_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination pRevenueAcct;
    @JoinColumn(name = "p_purchasepricevariance_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination pPurchasepricevarianceAcct;
    @JoinColumn(name = "p_invoicepricevariance_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination pInvoicepricevarianceAcct;
    @JoinColumn(name = "p_cogs_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination pCogsAcct;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "p_asset_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination pAssetAcct;
    @JoinColumn(name = "p_expense_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination pExpenseAcct;
    @JoinColumn(name = "p_tradediscountgrant_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination pTradediscountgrantAcct;
    @JoinColumn(name = "p_tradediscountrec_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination pTradediscountrecAcct;

    public MProductAcct() {
    }

    public MProductAcct(String mProductAcctId) {
        this.mProductAcctId = mProductAcctId;
    }

    public MProductAcct(String mProductAcctId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mProductAcctId = mProductAcctId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMProductAcctId() {
        return mProductAcctId;
    }

    public void setMProductAcctId(String mProductAcctId) {
        this.mProductAcctId = mProductAcctId;
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

    public CAcctschema getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(CAcctschema cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
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

    public CValidcombination getPRevenueAcct() {
        return pRevenueAcct;
    }

    public void setPRevenueAcct(CValidcombination pRevenueAcct) {
        this.pRevenueAcct = pRevenueAcct;
    }

    public CValidcombination getPPurchasepricevarianceAcct() {
        return pPurchasepricevarianceAcct;
    }

    public void setPPurchasepricevarianceAcct(CValidcombination pPurchasepricevarianceAcct) {
        this.pPurchasepricevarianceAcct = pPurchasepricevarianceAcct;
    }

    public CValidcombination getPInvoicepricevarianceAcct() {
        return pInvoicepricevarianceAcct;
    }

    public void setPInvoicepricevarianceAcct(CValidcombination pInvoicepricevarianceAcct) {
        this.pInvoicepricevarianceAcct = pInvoicepricevarianceAcct;
    }

    public CValidcombination getPCogsAcct() {
        return pCogsAcct;
    }

    public void setPCogsAcct(CValidcombination pCogsAcct) {
        this.pCogsAcct = pCogsAcct;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public CValidcombination getPAssetAcct() {
        return pAssetAcct;
    }

    public void setPAssetAcct(CValidcombination pAssetAcct) {
        this.pAssetAcct = pAssetAcct;
    }

    public CValidcombination getPExpenseAcct() {
        return pExpenseAcct;
    }

    public void setPExpenseAcct(CValidcombination pExpenseAcct) {
        this.pExpenseAcct = pExpenseAcct;
    }

    public CValidcombination getPTradediscountgrantAcct() {
        return pTradediscountgrantAcct;
    }

    public void setPTradediscountgrantAcct(CValidcombination pTradediscountgrantAcct) {
        this.pTradediscountgrantAcct = pTradediscountgrantAcct;
    }

    public CValidcombination getPTradediscountrecAcct() {
        return pTradediscountrecAcct;
    }

    public void setPTradediscountrecAcct(CValidcombination pTradediscountrecAcct) {
        this.pTradediscountrecAcct = pTradediscountrecAcct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mProductAcctId != null ? mProductAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MProductAcct)) {
            return false;
        }
        MProductAcct other = (MProductAcct) object;
        if ((this.mProductAcctId == null && other.mProductAcctId != null) || (this.mProductAcctId != null && !this.mProductAcctId.equals(other.mProductAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MProductAcct[ mProductAcctId=" + mProductAcctId + " ]";
    }
    
}
