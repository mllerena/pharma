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
@Table(name = "c_invoice_discount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CInvoiceDiscount.findAll", query = "SELECT c FROM CInvoiceDiscount c"),
    @NamedQuery(name = "CInvoiceDiscount.findByCInvoiceDiscountId", query = "SELECT c FROM CInvoiceDiscount c WHERE c.cInvoiceDiscountId = :cInvoiceDiscountId"),
    @NamedQuery(name = "CInvoiceDiscount.findByIsactive", query = "SELECT c FROM CInvoiceDiscount c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CInvoiceDiscount.findByCreated", query = "SELECT c FROM CInvoiceDiscount c WHERE c.created = :created"),
    @NamedQuery(name = "CInvoiceDiscount.findByCreatedby", query = "SELECT c FROM CInvoiceDiscount c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CInvoiceDiscount.findByUpdated", query = "SELECT c FROM CInvoiceDiscount c WHERE c.updated = :updated"),
    @NamedQuery(name = "CInvoiceDiscount.findByUpdatedby", query = "SELECT c FROM CInvoiceDiscount c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CInvoiceDiscount.findByLine", query = "SELECT c FROM CInvoiceDiscount c WHERE c.line = :line"),
    @NamedQuery(name = "CInvoiceDiscount.findByCascade", query = "SELECT c FROM CInvoiceDiscount c WHERE c.cascade = :cascade")})
public class CInvoiceDiscount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_invoice_discount_id")
    private String cInvoiceDiscountId;
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
    @Column(name = "cascade")
    private Character cascade;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_discount_id", referencedColumnName = "c_discount_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDiscount cDiscountId;
    @JoinColumn(name = "c_invoice_id", referencedColumnName = "c_invoice_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CInvoice cInvoiceId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoiceDiscountId")
    private List<CInvoiceline> cInvoicelineList;

    public CInvoiceDiscount() {
    }

    public CInvoiceDiscount(String cInvoiceDiscountId) {
        this.cInvoiceDiscountId = cInvoiceDiscountId;
    }

    public CInvoiceDiscount(String cInvoiceDiscountId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, Character cascade) {
        this.cInvoiceDiscountId = cInvoiceDiscountId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.cascade = cascade;
    }

    public String getCInvoiceDiscountId() {
        return cInvoiceDiscountId;
    }

    public void setCInvoiceDiscountId(String cInvoiceDiscountId) {
        this.cInvoiceDiscountId = cInvoiceDiscountId;
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

    public Character getCascade() {
        return cascade;
    }

    public void setCascade(Character cascade) {
        this.cascade = cascade;
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

    public CDiscount getCDiscountId() {
        return cDiscountId;
    }

    public void setCDiscountId(CDiscount cDiscountId) {
        this.cDiscountId = cDiscountId;
    }

    public CInvoice getCInvoiceId() {
        return cInvoiceId;
    }

    public void setCInvoiceId(CInvoice cInvoiceId) {
        this.cInvoiceId = cInvoiceId;
    }

    @XmlTransient
    public List<CInvoiceline> getCInvoicelineList() {
        return cInvoicelineList;
    }

    public void setCInvoicelineList(List<CInvoiceline> cInvoicelineList) {
        this.cInvoicelineList = cInvoicelineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cInvoiceDiscountId != null ? cInvoiceDiscountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CInvoiceDiscount)) {
            return false;
        }
        CInvoiceDiscount other = (CInvoiceDiscount) object;
        if ((this.cInvoiceDiscountId == null && other.cInvoiceDiscountId != null) || (this.cInvoiceDiscountId != null && !this.cInvoiceDiscountId.equals(other.cInvoiceDiscountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CInvoiceDiscount[ cInvoiceDiscountId=" + cInvoiceDiscountId + " ]";
    }
    
}
