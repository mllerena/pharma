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
@Table(name = "c_invoiceline_offer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CInvoicelineOffer.findAll", query = "SELECT c FROM CInvoicelineOffer c"),
    @NamedQuery(name = "CInvoicelineOffer.findByCInvoicelineOfferId", query = "SELECT c FROM CInvoicelineOffer c WHERE c.cInvoicelineOfferId = :cInvoicelineOfferId"),
    @NamedQuery(name = "CInvoicelineOffer.findByIsactive", query = "SELECT c FROM CInvoicelineOffer c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CInvoicelineOffer.findByCreated", query = "SELECT c FROM CInvoicelineOffer c WHERE c.created = :created"),
    @NamedQuery(name = "CInvoicelineOffer.findByCreatedby", query = "SELECT c FROM CInvoicelineOffer c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CInvoicelineOffer.findByUpdated", query = "SELECT c FROM CInvoicelineOffer c WHERE c.updated = :updated"),
    @NamedQuery(name = "CInvoicelineOffer.findByUpdatedby", query = "SELECT c FROM CInvoicelineOffer c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CInvoicelineOffer.findByLine", query = "SELECT c FROM CInvoicelineOffer c WHERE c.line = :line"),
    @NamedQuery(name = "CInvoicelineOffer.findByPriceoffer", query = "SELECT c FROM CInvoicelineOffer c WHERE c.priceoffer = :priceoffer"),
    @NamedQuery(name = "CInvoicelineOffer.findByAmtoffer", query = "SELECT c FROM CInvoicelineOffer c WHERE c.amtoffer = :amtoffer")})
public class CInvoicelineOffer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_invoiceline_offer_id")
    private String cInvoicelineOfferId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "priceoffer")
    private BigInteger priceoffer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amtoffer")
    private BigInteger amtoffer;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_invoiceline_id", referencedColumnName = "c_invoiceline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CInvoiceline cInvoicelineId;
    @JoinColumn(name = "m_offer_id", referencedColumnName = "m_offer_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MOffer mOfferId;

    public CInvoicelineOffer() {
    }

    public CInvoicelineOffer(String cInvoicelineOfferId) {
        this.cInvoicelineOfferId = cInvoicelineOfferId;
    }

    public CInvoicelineOffer(String cInvoicelineOfferId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, BigInteger priceoffer, BigInteger amtoffer) {
        this.cInvoicelineOfferId = cInvoicelineOfferId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.priceoffer = priceoffer;
        this.amtoffer = amtoffer;
    }

    public String getCInvoicelineOfferId() {
        return cInvoicelineOfferId;
    }

    public void setCInvoicelineOfferId(String cInvoicelineOfferId) {
        this.cInvoicelineOfferId = cInvoicelineOfferId;
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

    public BigInteger getPriceoffer() {
        return priceoffer;
    }

    public void setPriceoffer(BigInteger priceoffer) {
        this.priceoffer = priceoffer;
    }

    public BigInteger getAmtoffer() {
        return amtoffer;
    }

    public void setAmtoffer(BigInteger amtoffer) {
        this.amtoffer = amtoffer;
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

    public CInvoiceline getCInvoicelineId() {
        return cInvoicelineId;
    }

    public void setCInvoicelineId(CInvoiceline cInvoicelineId) {
        this.cInvoicelineId = cInvoicelineId;
    }

    public MOffer getMOfferId() {
        return mOfferId;
    }

    public void setMOfferId(MOffer mOfferId) {
        this.mOfferId = mOfferId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cInvoicelineOfferId != null ? cInvoicelineOfferId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CInvoicelineOffer)) {
            return false;
        }
        CInvoicelineOffer other = (CInvoicelineOffer) object;
        if ((this.cInvoicelineOfferId == null && other.cInvoicelineOfferId != null) || (this.cInvoicelineOfferId != null && !this.cInvoicelineOfferId.equals(other.cInvoicelineOfferId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CInvoicelineOffer[ cInvoicelineOfferId=" + cInvoicelineOfferId + " ]";
    }
    
}
