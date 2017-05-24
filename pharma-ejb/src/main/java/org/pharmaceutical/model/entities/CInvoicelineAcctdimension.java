/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "c_invoiceline_acctdimension")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CInvoicelineAcctdimension.findAll", query = "SELECT c FROM CInvoicelineAcctdimension c"),
    @NamedQuery(name = "CInvoicelineAcctdimension.findByCInvoicelineAcctdimensionId", query = "SELECT c FROM CInvoicelineAcctdimension c WHERE c.cInvoicelineAcctdimensionId = :cInvoicelineAcctdimensionId"),
    @NamedQuery(name = "CInvoicelineAcctdimension.findByIsactive", query = "SELECT c FROM CInvoicelineAcctdimension c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CInvoicelineAcctdimension.findByCreated", query = "SELECT c FROM CInvoicelineAcctdimension c WHERE c.created = :created"),
    @NamedQuery(name = "CInvoicelineAcctdimension.findByCreatedby", query = "SELECT c FROM CInvoicelineAcctdimension c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CInvoicelineAcctdimension.findByUpdated", query = "SELECT c FROM CInvoicelineAcctdimension c WHERE c.updated = :updated"),
    @NamedQuery(name = "CInvoicelineAcctdimension.findByUpdatedby", query = "SELECT c FROM CInvoicelineAcctdimension c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CInvoicelineAcctdimension.findByAmt", query = "SELECT c FROM CInvoicelineAcctdimension c WHERE c.amt = :amt"),
    @NamedQuery(name = "CInvoicelineAcctdimension.findByUser1Id", query = "SELECT c FROM CInvoicelineAcctdimension c WHERE c.user1Id = :user1Id"),
    @NamedQuery(name = "CInvoicelineAcctdimension.findByUser2Id", query = "SELECT c FROM CInvoicelineAcctdimension c WHERE c.user2Id = :user2Id")})
public class CInvoicelineAcctdimension implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_invoiceline_acctdimension_id")
    private String cInvoicelineAcctdimensionId;
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
    @Column(name = "amt")
    private BigInteger amt;
    @Size(max = 32)
    @Column(name = "user1_id")
    private String user1Id;
    @Size(max = 32)
    @Column(name = "user2_id")
    private String user2Id;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_invoiceline_id", referencedColumnName = "c_invoiceline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CInvoiceline cInvoicelineId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;

    public CInvoicelineAcctdimension() {
    }

    public CInvoicelineAcctdimension(String cInvoicelineAcctdimensionId) {
        this.cInvoicelineAcctdimensionId = cInvoicelineAcctdimensionId;
    }

    public CInvoicelineAcctdimension(String cInvoicelineAcctdimensionId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cInvoicelineAcctdimensionId = cInvoicelineAcctdimensionId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCInvoicelineAcctdimensionId() {
        return cInvoicelineAcctdimensionId;
    }

    public void setCInvoicelineAcctdimensionId(String cInvoicelineAcctdimensionId) {
        this.cInvoicelineAcctdimensionId = cInvoicelineAcctdimensionId;
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

    public BigInteger getAmt() {
        return amt;
    }

    public void setAmt(BigInteger amt) {
        this.amt = amt;
    }

    public String getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(String user1Id) {
        this.user1Id = user1Id;
    }

    public String getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(String user2Id) {
        this.user2Id = user2Id;
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

    public CCampaign getCCampaignId() {
        return cCampaignId;
    }

    public void setCCampaignId(CCampaign cCampaignId) {
        this.cCampaignId = cCampaignId;
    }

    public CInvoiceline getCInvoicelineId() {
        return cInvoicelineId;
    }

    public void setCInvoicelineId(CInvoiceline cInvoicelineId) {
        this.cInvoicelineId = cInvoicelineId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cInvoicelineAcctdimensionId != null ? cInvoicelineAcctdimensionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CInvoicelineAcctdimension)) {
            return false;
        }
        CInvoicelineAcctdimension other = (CInvoicelineAcctdimension) object;
        if ((this.cInvoicelineAcctdimensionId == null && other.cInvoicelineAcctdimensionId != null) || (this.cInvoicelineAcctdimensionId != null && !this.cInvoicelineAcctdimensionId.equals(other.cInvoicelineAcctdimensionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CInvoicelineAcctdimension[ cInvoicelineAcctdimensionId=" + cInvoicelineAcctdimensionId + " ]";
    }
    
}
