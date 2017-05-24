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
@Table(name = "c_glitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CGlitem.findAll", query = "SELECT c FROM CGlitem c"),
    @NamedQuery(name = "CGlitem.findByCGlitemId", query = "SELECT c FROM CGlitem c WHERE c.cGlitemId = :cGlitemId"),
    @NamedQuery(name = "CGlitem.findByIsactive", query = "SELECT c FROM CGlitem c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CGlitem.findByCreated", query = "SELECT c FROM CGlitem c WHERE c.created = :created"),
    @NamedQuery(name = "CGlitem.findByCreatedby", query = "SELECT c FROM CGlitem c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CGlitem.findByUpdated", query = "SELECT c FROM CGlitem c WHERE c.updated = :updated"),
    @NamedQuery(name = "CGlitem.findByUpdatedby", query = "SELECT c FROM CGlitem c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CGlitem.findByName", query = "SELECT c FROM CGlitem c WHERE c.name = :name"),
    @NamedQuery(name = "CGlitem.findByDescription", query = "SELECT c FROM CGlitem c WHERE c.description = :description"),
    @NamedQuery(name = "CGlitem.findByEnableincash", query = "SELECT c FROM CGlitem c WHERE c.enableincash = :enableincash"),
    @NamedQuery(name = "CGlitem.findByEnableinfininvoices", query = "SELECT c FROM CGlitem c WHERE c.enableinfininvoices = :enableinfininvoices")})
public class CGlitem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_glitem_id")
    private String cGlitemId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enableincash")
    private Character enableincash;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enableinfininvoices")
    private Character enableinfininvoices;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cGlitemId")
    private List<CBankstatementline> cBankstatementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cGlitemId")
    private List<CCashline> cCashlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cGlitemId")
    private List<CDebtPaymentBalReplace> cDebtPaymentBalReplaceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cGlitemId")
    private List<CDebtPaymentBalancing> cDebtPaymentBalancingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cGlitemId")
    private List<CGlitemAcct> cGlitemAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "accountId")
    private List<CInvoiceline> cInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cGlitemId")
    private List<FinFinaccTransaction> finFinaccTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cGlitemId")
    private List<CTaxregisterType> cTaxregisterTypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cGlitemId")
    private List<FinPaymentPropDetail> finPaymentPropDetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cGlitemId")
    private List<FinPaymentDetail> finPaymentDetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cGlitemId")
    private List<CDebtPayment> cDebtPaymentList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax cTaxId;
    @JoinColumn(name = "c_taxcategory_id", referencedColumnName = "c_taxcategory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTaxcategory cTaxcategoryId;
    @JoinColumn(name = "c_withholding_id", referencedColumnName = "c_withholding_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CWithholding cWithholdingId;

    public CGlitem() {
    }

    public CGlitem(String cGlitemId) {
        this.cGlitemId = cGlitemId;
    }

    public CGlitem(String cGlitemId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character enableincash, Character enableinfininvoices) {
        this.cGlitemId = cGlitemId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.enableincash = enableincash;
        this.enableinfininvoices = enableinfininvoices;
    }

    public String getCGlitemId() {
        return cGlitemId;
    }

    public void setCGlitemId(String cGlitemId) {
        this.cGlitemId = cGlitemId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getEnableincash() {
        return enableincash;
    }

    public void setEnableincash(Character enableincash) {
        this.enableincash = enableincash;
    }

    public Character getEnableinfininvoices() {
        return enableinfininvoices;
    }

    public void setEnableinfininvoices(Character enableinfininvoices) {
        this.enableinfininvoices = enableinfininvoices;
    }

    @XmlTransient
    public List<CBankstatementline> getCBankstatementlineList() {
        return cBankstatementlineList;
    }

    public void setCBankstatementlineList(List<CBankstatementline> cBankstatementlineList) {
        this.cBankstatementlineList = cBankstatementlineList;
    }

    @XmlTransient
    public List<CCashline> getCCashlineList() {
        return cCashlineList;
    }

    public void setCCashlineList(List<CCashline> cCashlineList) {
        this.cCashlineList = cCashlineList;
    }

    @XmlTransient
    public List<CDebtPaymentBalReplace> getCDebtPaymentBalReplaceList() {
        return cDebtPaymentBalReplaceList;
    }

    public void setCDebtPaymentBalReplaceList(List<CDebtPaymentBalReplace> cDebtPaymentBalReplaceList) {
        this.cDebtPaymentBalReplaceList = cDebtPaymentBalReplaceList;
    }

    @XmlTransient
    public List<CDebtPaymentBalancing> getCDebtPaymentBalancingList() {
        return cDebtPaymentBalancingList;
    }

    public void setCDebtPaymentBalancingList(List<CDebtPaymentBalancing> cDebtPaymentBalancingList) {
        this.cDebtPaymentBalancingList = cDebtPaymentBalancingList;
    }

    @XmlTransient
    public List<CGlitemAcct> getCGlitemAcctList() {
        return cGlitemAcctList;
    }

    public void setCGlitemAcctList(List<CGlitemAcct> cGlitemAcctList) {
        this.cGlitemAcctList = cGlitemAcctList;
    }

    @XmlTransient
    public List<CInvoiceline> getCInvoicelineList() {
        return cInvoicelineList;
    }

    public void setCInvoicelineList(List<CInvoiceline> cInvoicelineList) {
        this.cInvoicelineList = cInvoicelineList;
    }

    @XmlTransient
    public List<FinFinaccTransaction> getFinFinaccTransactionList() {
        return finFinaccTransactionList;
    }

    public void setFinFinaccTransactionList(List<FinFinaccTransaction> finFinaccTransactionList) {
        this.finFinaccTransactionList = finFinaccTransactionList;
    }

    @XmlTransient
    public List<CTaxregisterType> getCTaxregisterTypeList() {
        return cTaxregisterTypeList;
    }

    public void setCTaxregisterTypeList(List<CTaxregisterType> cTaxregisterTypeList) {
        this.cTaxregisterTypeList = cTaxregisterTypeList;
    }

    @XmlTransient
    public List<FinPaymentPropDetail> getFinPaymentPropDetailList() {
        return finPaymentPropDetailList;
    }

    public void setFinPaymentPropDetailList(List<FinPaymentPropDetail> finPaymentPropDetailList) {
        this.finPaymentPropDetailList = finPaymentPropDetailList;
    }

    @XmlTransient
    public List<FinPaymentDetail> getFinPaymentDetailList() {
        return finPaymentDetailList;
    }

    public void setFinPaymentDetailList(List<FinPaymentDetail> finPaymentDetailList) {
        this.finPaymentDetailList = finPaymentDetailList;
    }

    @XmlTransient
    public List<CDebtPayment> getCDebtPaymentList() {
        return cDebtPaymentList;
    }

    public void setCDebtPaymentList(List<CDebtPayment> cDebtPaymentList) {
        this.cDebtPaymentList = cDebtPaymentList;
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

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    public CTaxcategory getCTaxcategoryId() {
        return cTaxcategoryId;
    }

    public void setCTaxcategoryId(CTaxcategory cTaxcategoryId) {
        this.cTaxcategoryId = cTaxcategoryId;
    }

    public CWithholding getCWithholdingId() {
        return cWithholdingId;
    }

    public void setCWithholdingId(CWithholding cWithholdingId) {
        this.cWithholdingId = cWithholdingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cGlitemId != null ? cGlitemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CGlitem)) {
            return false;
        }
        CGlitem other = (CGlitem) object;
        if ((this.cGlitemId == null && other.cGlitemId != null) || (this.cGlitemId != null && !this.cGlitemId.equals(other.cGlitemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CGlitem[ cGlitemId=" + cGlitemId + " ]";
    }
    
}
