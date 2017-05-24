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
@Table(name = "c_invoicetax")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CInvoicetax.findAll", query = "SELECT c FROM CInvoicetax c"),
    @NamedQuery(name = "CInvoicetax.findByIsactive", query = "SELECT c FROM CInvoicetax c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CInvoicetax.findByCreated", query = "SELECT c FROM CInvoicetax c WHERE c.created = :created"),
    @NamedQuery(name = "CInvoicetax.findByCreatedby", query = "SELECT c FROM CInvoicetax c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CInvoicetax.findByUpdated", query = "SELECT c FROM CInvoicetax c WHERE c.updated = :updated"),
    @NamedQuery(name = "CInvoicetax.findByUpdatedby", query = "SELECT c FROM CInvoicetax c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CInvoicetax.findByTaxbaseamt", query = "SELECT c FROM CInvoicetax c WHERE c.taxbaseamt = :taxbaseamt"),
    @NamedQuery(name = "CInvoicetax.findByTaxamt", query = "SELECT c FROM CInvoicetax c WHERE c.taxamt = :taxamt"),
    @NamedQuery(name = "CInvoicetax.findByLine", query = "SELECT c FROM CInvoicetax c WHERE c.line = :line"),
    @NamedQuery(name = "CInvoicetax.findByCInvoicetaxId", query = "SELECT c FROM CInvoicetax c WHERE c.cInvoicetaxId = :cInvoicetaxId"),
    @NamedQuery(name = "CInvoicetax.findByRecalculate", query = "SELECT c FROM CInvoicetax c WHERE c.recalculate = :recalculate")})
public class CInvoicetax implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_invoicetax_id")
    private String cInvoicetaxId;
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
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CTax cTaxId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cInvoicetaxId")
    private List<CTaxregisterline> cTaxregisterlineList;

    public CInvoicetax() {
    }

    public CInvoicetax(String cInvoicetaxId) {
        this.cInvoicetaxId = cInvoicetaxId;
    }

    public CInvoicetax(String cInvoicetaxId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger taxbaseamt, BigInteger taxamt, Character recalculate) {
        this.cInvoicetaxId = cInvoicetaxId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.taxbaseamt = taxbaseamt;
        this.taxamt = taxamt;
        this.recalculate = recalculate;
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

    public String getCInvoicetaxId() {
        return cInvoicetaxId;
    }

    public void setCInvoicetaxId(String cInvoicetaxId) {
        this.cInvoicetaxId = cInvoicetaxId;
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

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    @XmlTransient
    public List<CTaxregisterline> getCTaxregisterlineList() {
        return cTaxregisterlineList;
    }

    public void setCTaxregisterlineList(List<CTaxregisterline> cTaxregisterlineList) {
        this.cTaxregisterlineList = cTaxregisterlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cInvoicetaxId != null ? cInvoicetaxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CInvoicetax)) {
            return false;
        }
        CInvoicetax other = (CInvoicetax) object;
        if ((this.cInvoicetaxId == null && other.cInvoicetaxId != null) || (this.cInvoicetaxId != null && !this.cInvoicetaxId.equals(other.cInvoicetaxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CInvoicetax[ cInvoicetaxId=" + cInvoicetaxId + " ]";
    }
    
}
