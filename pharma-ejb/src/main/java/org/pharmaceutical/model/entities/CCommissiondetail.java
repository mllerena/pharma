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
@Table(name = "c_commissiondetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCommissiondetail.findAll", query = "SELECT c FROM CCommissiondetail c"),
    @NamedQuery(name = "CCommissiondetail.findByCCommissiondetailId", query = "SELECT c FROM CCommissiondetail c WHERE c.cCommissiondetailId = :cCommissiondetailId"),
    @NamedQuery(name = "CCommissiondetail.findByIsactive", query = "SELECT c FROM CCommissiondetail c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCommissiondetail.findByCreated", query = "SELECT c FROM CCommissiondetail c WHERE c.created = :created"),
    @NamedQuery(name = "CCommissiondetail.findByCreatedby", query = "SELECT c FROM CCommissiondetail c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCommissiondetail.findByUpdated", query = "SELECT c FROM CCommissiondetail c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCommissiondetail.findByUpdatedby", query = "SELECT c FROM CCommissiondetail c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCommissiondetail.findByReference", query = "SELECT c FROM CCommissiondetail c WHERE c.reference = :reference"),
    @NamedQuery(name = "CCommissiondetail.findByInfo", query = "SELECT c FROM CCommissiondetail c WHERE c.info = :info"),
    @NamedQuery(name = "CCommissiondetail.findByActualamt", query = "SELECT c FROM CCommissiondetail c WHERE c.actualamt = :actualamt"),
    @NamedQuery(name = "CCommissiondetail.findByConvertedamt", query = "SELECT c FROM CCommissiondetail c WHERE c.convertedamt = :convertedamt"),
    @NamedQuery(name = "CCommissiondetail.findByActualqty", query = "SELECT c FROM CCommissiondetail c WHERE c.actualqty = :actualqty")})
public class CCommissiondetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_commissiondetail_id")
    private String cCommissiondetailId;
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
    @Size(max = 60)
    @Column(name = "reference")
    private String reference;
    @Size(max = 60)
    @Column(name = "info")
    private String info;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actualamt")
    private BigInteger actualamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "convertedamt")
    private BigInteger convertedamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actualqty")
    private BigInteger actualqty;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_commissionamt_id", referencedColumnName = "c_commissionamt_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCommissionamt cCommissionamtId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_invoiceline_id", referencedColumnName = "c_invoiceline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoiceline cInvoicelineId;
    @JoinColumn(name = "c_orderline_id", referencedColumnName = "c_orderline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrderline cOrderlineId;

    public CCommissiondetail() {
    }

    public CCommissiondetail(String cCommissiondetailId) {
        this.cCommissiondetailId = cCommissiondetailId;
    }

    public CCommissiondetail(String cCommissiondetailId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger actualamt, BigInteger convertedamt, BigInteger actualqty) {
        this.cCommissiondetailId = cCommissiondetailId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.actualamt = actualamt;
        this.convertedamt = convertedamt;
        this.actualqty = actualqty;
    }

    public String getCCommissiondetailId() {
        return cCommissiondetailId;
    }

    public void setCCommissiondetailId(String cCommissiondetailId) {
        this.cCommissiondetailId = cCommissiondetailId;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public BigInteger getActualamt() {
        return actualamt;
    }

    public void setActualamt(BigInteger actualamt) {
        this.actualamt = actualamt;
    }

    public BigInteger getConvertedamt() {
        return convertedamt;
    }

    public void setConvertedamt(BigInteger convertedamt) {
        this.convertedamt = convertedamt;
    }

    public BigInteger getActualqty() {
        return actualqty;
    }

    public void setActualqty(BigInteger actualqty) {
        this.actualqty = actualqty;
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

    public CCommissionamt getCCommissionamtId() {
        return cCommissionamtId;
    }

    public void setCCommissionamtId(CCommissionamt cCommissionamtId) {
        this.cCommissionamtId = cCommissionamtId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CInvoiceline getCInvoicelineId() {
        return cInvoicelineId;
    }

    public void setCInvoicelineId(CInvoiceline cInvoicelineId) {
        this.cInvoicelineId = cInvoicelineId;
    }

    public COrderline getCOrderlineId() {
        return cOrderlineId;
    }

    public void setCOrderlineId(COrderline cOrderlineId) {
        this.cOrderlineId = cOrderlineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCommissiondetailId != null ? cCommissiondetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCommissiondetail)) {
            return false;
        }
        CCommissiondetail other = (CCommissiondetail) object;
        if ((this.cCommissiondetailId == null && other.cCommissiondetailId != null) || (this.cCommissiondetailId != null && !this.cCommissiondetailId.equals(other.cCommissiondetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCommissiondetail[ cCommissiondetailId=" + cCommissiondetailId + " ]";
    }
    
}
