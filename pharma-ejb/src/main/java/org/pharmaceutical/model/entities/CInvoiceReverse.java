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
@Table(name = "c_invoice_reverse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CInvoiceReverse.findAll", query = "SELECT c FROM CInvoiceReverse c"),
    @NamedQuery(name = "CInvoiceReverse.findByCInvoiceReverseId", query = "SELECT c FROM CInvoiceReverse c WHERE c.cInvoiceReverseId = :cInvoiceReverseId"),
    @NamedQuery(name = "CInvoiceReverse.findByIsactive", query = "SELECT c FROM CInvoiceReverse c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CInvoiceReverse.findByCreated", query = "SELECT c FROM CInvoiceReverse c WHERE c.created = :created"),
    @NamedQuery(name = "CInvoiceReverse.findByCreatedby", query = "SELECT c FROM CInvoiceReverse c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CInvoiceReverse.findByUpdated", query = "SELECT c FROM CInvoiceReverse c WHERE c.updated = :updated"),
    @NamedQuery(name = "CInvoiceReverse.findByUpdatedby", query = "SELECT c FROM CInvoiceReverse c WHERE c.updatedby = :updatedby")})
public class CInvoiceReverse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_invoice_reverse_id")
    private String cInvoiceReverseId;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "reversed_c_invoice_id", referencedColumnName = "c_invoice_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CInvoice reversedCInvoiceId;
    @JoinColumn(name = "c_invoice_id", referencedColumnName = "c_invoice_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CInvoice cInvoiceId;

    public CInvoiceReverse() {
    }

    public CInvoiceReverse(String cInvoiceReverseId) {
        this.cInvoiceReverseId = cInvoiceReverseId;
    }

    public CInvoiceReverse(String cInvoiceReverseId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cInvoiceReverseId = cInvoiceReverseId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCInvoiceReverseId() {
        return cInvoiceReverseId;
    }

    public void setCInvoiceReverseId(String cInvoiceReverseId) {
        this.cInvoiceReverseId = cInvoiceReverseId;
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

    public CInvoice getReversedCInvoiceId() {
        return reversedCInvoiceId;
    }

    public void setReversedCInvoiceId(CInvoice reversedCInvoiceId) {
        this.reversedCInvoiceId = reversedCInvoiceId;
    }

    public CInvoice getCInvoiceId() {
        return cInvoiceId;
    }

    public void setCInvoiceId(CInvoice cInvoiceId) {
        this.cInvoiceId = cInvoiceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cInvoiceReverseId != null ? cInvoiceReverseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CInvoiceReverse)) {
            return false;
        }
        CInvoiceReverse other = (CInvoiceReverse) object;
        if ((this.cInvoiceReverseId == null && other.cInvoiceReverseId != null) || (this.cInvoiceReverseId != null && !this.cInvoiceReverseId.equals(other.cInvoiceReverseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CInvoiceReverse[ cInvoiceReverseId=" + cInvoiceReverseId + " ]";
    }
    
}
