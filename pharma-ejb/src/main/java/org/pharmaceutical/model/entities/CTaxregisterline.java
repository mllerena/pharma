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
@Table(name = "c_taxregisterline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTaxregisterline.findAll", query = "SELECT c FROM CTaxregisterline c"),
    @NamedQuery(name = "CTaxregisterline.findByIsactive", query = "SELECT c FROM CTaxregisterline c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CTaxregisterline.findByCreated", query = "SELECT c FROM CTaxregisterline c WHERE c.created = :created"),
    @NamedQuery(name = "CTaxregisterline.findByCreatedby", query = "SELECT c FROM CTaxregisterline c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CTaxregisterline.findByUpdated", query = "SELECT c FROM CTaxregisterline c WHERE c.updated = :updated"),
    @NamedQuery(name = "CTaxregisterline.findByUpdatedby", query = "SELECT c FROM CTaxregisterline c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CTaxregisterline.findByCTaxregisterlineId", query = "SELECT c FROM CTaxregisterline c WHERE c.cTaxregisterlineId = :cTaxregisterlineId"),
    @NamedQuery(name = "CTaxregisterline.findByDocumentno", query = "SELECT c FROM CTaxregisterline c WHERE c.documentno = :documentno"),
    @NamedQuery(name = "CTaxregisterline.findByTaxbaseamt", query = "SELECT c FROM CTaxregisterline c WHERE c.taxbaseamt = :taxbaseamt"),
    @NamedQuery(name = "CTaxregisterline.findByTaxamt", query = "SELECT c FROM CTaxregisterline c WHERE c.taxamt = :taxamt"),
    @NamedQuery(name = "CTaxregisterline.findByTotalamt", query = "SELECT c FROM CTaxregisterline c WHERE c.totalamt = :totalamt"),
    @NamedQuery(name = "CTaxregisterline.findByTaxundamt", query = "SELECT c FROM CTaxregisterline c WHERE c.taxundamt = :taxundamt"),
    @NamedQuery(name = "CTaxregisterline.findByInvoicedate", query = "SELECT c FROM CTaxregisterline c WHERE c.invoicedate = :invoicedate"),
    @NamedQuery(name = "CTaxregisterline.findByExemptamt", query = "SELECT c FROM CTaxregisterline c WHERE c.exemptamt = :exemptamt"),
    @NamedQuery(name = "CTaxregisterline.findByNovatamt", query = "SELECT c FROM CTaxregisterline c WHERE c.novatamt = :novatamt"),
    @NamedQuery(name = "CTaxregisterline.findByName", query = "SELECT c FROM CTaxregisterline c WHERE c.name = :name")})
public class CTaxregisterline implements Serializable {
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
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_taxregisterline_id")
    private String cTaxregisterlineId;
    @Size(max = 30)
    @Column(name = "documentno")
    private String documentno;
    @Column(name = "taxbaseamt")
    private BigInteger taxbaseamt;
    @Column(name = "taxamt")
    private BigInteger taxamt;
    @Column(name = "totalamt")
    private BigInteger totalamt;
    @Column(name = "taxundamt")
    private BigInteger taxundamt;
    @Column(name = "invoicedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoicedate;
    @Column(name = "exemptamt")
    private BigInteger exemptamt;
    @Column(name = "novatamt")
    private BigInteger novatamt;
    @Size(max = 60)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_invoicetax_id", referencedColumnName = "c_invoicetax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoicetax cInvoicetaxId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax cTaxId;
    @JoinColumn(name = "c_taxregister_id", referencedColumnName = "c_taxregister_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTaxregister cTaxregisterId;

    public CTaxregisterline() {
    }

    public CTaxregisterline(String cTaxregisterlineId) {
        this.cTaxregisterlineId = cTaxregisterlineId;
    }

    public CTaxregisterline(String cTaxregisterlineId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cTaxregisterlineId = cTaxregisterlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
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

    public String getCTaxregisterlineId() {
        return cTaxregisterlineId;
    }

    public void setCTaxregisterlineId(String cTaxregisterlineId) {
        this.cTaxregisterlineId = cTaxregisterlineId;
    }

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
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

    public BigInteger getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(BigInteger totalamt) {
        this.totalamt = totalamt;
    }

    public BigInteger getTaxundamt() {
        return taxundamt;
    }

    public void setTaxundamt(BigInteger taxundamt) {
        this.taxundamt = taxundamt;
    }

    public Date getInvoicedate() {
        return invoicedate;
    }

    public void setInvoicedate(Date invoicedate) {
        this.invoicedate = invoicedate;
    }

    public BigInteger getExemptamt() {
        return exemptamt;
    }

    public void setExemptamt(BigInteger exemptamt) {
        this.exemptamt = exemptamt;
    }

    public BigInteger getNovatamt() {
        return novatamt;
    }

    public void setNovatamt(BigInteger novatamt) {
        this.novatamt = novatamt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public CInvoicetax getCInvoicetaxId() {
        return cInvoicetaxId;
    }

    public void setCInvoicetaxId(CInvoicetax cInvoicetaxId) {
        this.cInvoicetaxId = cInvoicetaxId;
    }

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    public CTaxregister getCTaxregisterId() {
        return cTaxregisterId;
    }

    public void setCTaxregisterId(CTaxregister cTaxregisterId) {
        this.cTaxregisterId = cTaxregisterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTaxregisterlineId != null ? cTaxregisterlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTaxregisterline)) {
            return false;
        }
        CTaxregisterline other = (CTaxregisterline) object;
        if ((this.cTaxregisterlineId == null && other.cTaxregisterlineId != null) || (this.cTaxregisterlineId != null && !this.cTaxregisterlineId.equals(other.cTaxregisterlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CTaxregisterline[ cTaxregisterlineId=" + cTaxregisterlineId + " ]";
    }
    
}
