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
@Table(name = "c_commissionline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCommissionline.findAll", query = "SELECT c FROM CCommissionline c"),
    @NamedQuery(name = "CCommissionline.findByCCommissionlineId", query = "SELECT c FROM CCommissionline c WHERE c.cCommissionlineId = :cCommissionlineId"),
    @NamedQuery(name = "CCommissionline.findByIsactive", query = "SELECT c FROM CCommissionline c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCommissionline.findByCreated", query = "SELECT c FROM CCommissionline c WHERE c.created = :created"),
    @NamedQuery(name = "CCommissionline.findByCreatedby", query = "SELECT c FROM CCommissionline c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCommissionline.findByUpdated", query = "SELECT c FROM CCommissionline c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCommissionline.findByUpdatedby", query = "SELECT c FROM CCommissionline c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCommissionline.findByLine", query = "SELECT c FROM CCommissionline c WHERE c.line = :line"),
    @NamedQuery(name = "CCommissionline.findByDescription", query = "SELECT c FROM CCommissionline c WHERE c.description = :description"),
    @NamedQuery(name = "CCommissionline.findByAmtsubtract", query = "SELECT c FROM CCommissionline c WHERE c.amtsubtract = :amtsubtract"),
    @NamedQuery(name = "CCommissionline.findByAmtmultiplier", query = "SELECT c FROM CCommissionline c WHERE c.amtmultiplier = :amtmultiplier"),
    @NamedQuery(name = "CCommissionline.findByQtysubtract", query = "SELECT c FROM CCommissionline c WHERE c.qtysubtract = :qtysubtract"),
    @NamedQuery(name = "CCommissionline.findByQtymultiplier", query = "SELECT c FROM CCommissionline c WHERE c.qtymultiplier = :qtymultiplier"),
    @NamedQuery(name = "CCommissionline.findByIspositiveonly", query = "SELECT c FROM CCommissionline c WHERE c.ispositiveonly = :ispositiveonly"),
    @NamedQuery(name = "CCommissionline.findByCommissionorders", query = "SELECT c FROM CCommissionline c WHERE c.commissionorders = :commissionorders")})
public class CCommissionline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_commissionline_id")
    private String cCommissionlineId;
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
    @Column(name = "line")
    private long line;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amtsubtract")
    private BigInteger amtsubtract;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amtmultiplier")
    private BigInteger amtmultiplier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtysubtract")
    private BigInteger qtysubtract;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtymultiplier")
    private BigInteger qtymultiplier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ispositiveonly")
    private Character ispositiveonly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "commissionorders")
    private Character commissionorders;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCommissionlineId")
    private List<CCommissionamt> cCommissionamtList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg orgId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bp_group_id", referencedColumnName = "c_bp_group_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpGroup cBpGroupId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_commission_id", referencedColumnName = "c_commission_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCommission cCommissionId;
    @JoinColumn(name = "c_salesregion_id", referencedColumnName = "c_salesregion_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CSalesregion cSalesregionId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_category_id", referencedColumnName = "m_product_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductCategory mProductCategoryId;

    public CCommissionline() {
    }

    public CCommissionline(String cCommissionlineId) {
        this.cCommissionlineId = cCommissionlineId;
    }

    public CCommissionline(String cCommissionlineId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, BigInteger amtsubtract, BigInteger amtmultiplier, BigInteger qtysubtract, BigInteger qtymultiplier, Character ispositiveonly, Character commissionorders) {
        this.cCommissionlineId = cCommissionlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.amtsubtract = amtsubtract;
        this.amtmultiplier = amtmultiplier;
        this.qtysubtract = qtysubtract;
        this.qtymultiplier = qtymultiplier;
        this.ispositiveonly = ispositiveonly;
        this.commissionorders = commissionorders;
    }

    public String getCCommissionlineId() {
        return cCommissionlineId;
    }

    public void setCCommissionlineId(String cCommissionlineId) {
        this.cCommissionlineId = cCommissionlineId;
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

    public long getLine() {
        return line;
    }

    public void setLine(long line) {
        this.line = line;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getAmtsubtract() {
        return amtsubtract;
    }

    public void setAmtsubtract(BigInteger amtsubtract) {
        this.amtsubtract = amtsubtract;
    }

    public BigInteger getAmtmultiplier() {
        return amtmultiplier;
    }

    public void setAmtmultiplier(BigInteger amtmultiplier) {
        this.amtmultiplier = amtmultiplier;
    }

    public BigInteger getQtysubtract() {
        return qtysubtract;
    }

    public void setQtysubtract(BigInteger qtysubtract) {
        this.qtysubtract = qtysubtract;
    }

    public BigInteger getQtymultiplier() {
        return qtymultiplier;
    }

    public void setQtymultiplier(BigInteger qtymultiplier) {
        this.qtymultiplier = qtymultiplier;
    }

    public Character getIspositiveonly() {
        return ispositiveonly;
    }

    public void setIspositiveonly(Character ispositiveonly) {
        this.ispositiveonly = ispositiveonly;
    }

    public Character getCommissionorders() {
        return commissionorders;
    }

    public void setCommissionorders(Character commissionorders) {
        this.commissionorders = commissionorders;
    }

    @XmlTransient
    public List<CCommissionamt> getCCommissionamtList() {
        return cCommissionamtList;
    }

    public void setCCommissionamtList(List<CCommissionamt> cCommissionamtList) {
        this.cCommissionamtList = cCommissionamtList;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdOrg getOrgId() {
        return orgId;
    }

    public void setOrgId(AdOrg orgId) {
        this.orgId = orgId;
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

    public CCommission getCCommissionId() {
        return cCommissionId;
    }

    public void setCCommissionId(CCommission cCommissionId) {
        this.cCommissionId = cCommissionId;
    }

    public CSalesregion getCSalesregionId() {
        return cSalesregionId;
    }

    public void setCSalesregionId(CSalesregion cSalesregionId) {
        this.cSalesregionId = cSalesregionId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCommissionlineId != null ? cCommissionlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCommissionline)) {
            return false;
        }
        CCommissionline other = (CCommissionline) object;
        if ((this.cCommissionlineId == null && other.cCommissionlineId != null) || (this.cCommissionlineId != null && !this.cCommissionlineId.equals(other.cCommissionlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCommissionline[ cCommissionlineId=" + cCommissionlineId + " ]";
    }
    
}
