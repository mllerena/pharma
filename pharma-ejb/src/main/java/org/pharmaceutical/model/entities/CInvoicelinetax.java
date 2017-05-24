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
@Table(name = "c_invoicelinetax")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CInvoicelinetax.findAll", query = "SELECT c FROM CInvoicelinetax c"),
    @NamedQuery(name = "CInvoicelinetax.findByCInvoicelinetaxId", query = "SELECT c FROM CInvoicelinetax c WHERE c.cInvoicelinetaxId = :cInvoicelinetaxId"),
    @NamedQuery(name = "CInvoicelinetax.findByIsactive", query = "SELECT c FROM CInvoicelinetax c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CInvoicelinetax.findByCreated", query = "SELECT c FROM CInvoicelinetax c WHERE c.created = :created"),
    @NamedQuery(name = "CInvoicelinetax.findByCreatedby", query = "SELECT c FROM CInvoicelinetax c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CInvoicelinetax.findByUpdated", query = "SELECT c FROM CInvoicelinetax c WHERE c.updated = :updated"),
    @NamedQuery(name = "CInvoicelinetax.findByUpdatedby", query = "SELECT c FROM CInvoicelinetax c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CInvoicelinetax.findByTaxbaseamt", query = "SELECT c FROM CInvoicelinetax c WHERE c.taxbaseamt = :taxbaseamt"),
    @NamedQuery(name = "CInvoicelinetax.findByTaxamt", query = "SELECT c FROM CInvoicelinetax c WHERE c.taxamt = :taxamt"),
    @NamedQuery(name = "CInvoicelinetax.findByLine", query = "SELECT c FROM CInvoicelinetax c WHERE c.line = :line"),
    @NamedQuery(name = "CInvoicelinetax.findByRecalculate", query = "SELECT c FROM CInvoicelinetax c WHERE c.recalculate = :recalculate")})
public class CInvoicelinetax implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_invoicelinetax_id")
    private String cInvoicelinetaxId;
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
    @Column(name = "taxbaseamt")
    private BigInteger taxbaseamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxamt")
    private BigInteger taxamt;
    @Column(name = "line")
    private BigInteger line;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recalculate")
    private Character recalculate;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_invoice_id", referencedColumnName = "c_invoice_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CInvoice cInvoiceId;
    @JoinColumn(name = "c_invoiceline_id", referencedColumnName = "c_invoiceline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CInvoiceline cInvoicelineId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CTax cTaxId;

    public CInvoicelinetax() {
    }

    public CInvoicelinetax(String cInvoicelinetaxId) {
        this.cInvoicelinetaxId = cInvoicelinetaxId;
    }

    public CInvoicelinetax(String cInvoicelinetaxId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger taxbaseamt, BigInteger taxamt, Character recalculate) {
        this.cInvoicelinetaxId = cInvoicelinetaxId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.taxbaseamt = taxbaseamt;
        this.taxamt = taxamt;
        this.recalculate = recalculate;
    }

    public String getCInvoicelinetaxId() {
        return cInvoicelinetaxId;
    }

    public void setCInvoicelinetaxId(String cInvoicelinetaxId) {
        this.cInvoicelinetaxId = cInvoicelinetaxId;
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

    public BigInteger getTaxbaseamt() {
        return taxbaseamt;
    }

    public void setTaxbaseamt(BigInteger taxbaseamt) {
        this.taxbaseamt = taxbaseamt;
    }

    public BigInteger getTaxamt() {
        return taxamt;
    }

    public void setTaxamt(BigInteger taxamt) {
        this.taxamt = taxamt;
    }

    public BigInteger getLine() {
        return line;
    }

    public void setLine(BigInteger line) {
        this.line = line;
    }

    public Character getRecalculate() {
        return recalculate;
    }

    public void setRecalculate(Character recalculate) {
        this.recalculate = recalculate;
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

    public CInvoice getCInvoiceId() {
        return cInvoiceId;
    }

    public void setCInvoiceId(CInvoice cInvoiceId) {
        this.cInvoiceId = cInvoiceId;
    }

    public CInvoiceline getCInvoicelineId() {
        return cInvoicelineId;
    }

    public void setCInvoicelineId(CInvoiceline cInvoicelineId) {
        this.cInvoicelineId = cInvoicelineId;
    }

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cInvoicelinetaxId != null ? cInvoicelinetaxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CInvoicelinetax)) {
            return false;
        }
        CInvoicelinetax other = (CInvoicelinetax) object;
        if ((this.cInvoicelinetaxId == null && other.cInvoicelinetaxId != null) || (this.cInvoicelinetaxId != null && !this.cInvoicelinetaxId.equals(other.cInvoicelinetaxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CInvoicelinetax[ cInvoicelinetaxId=" + cInvoicelinetaxId + " ]";
    }
    
}
