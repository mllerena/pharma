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
@Table(name = "c_charge")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCharge.findAll", query = "SELECT c FROM CCharge c"),
    @NamedQuery(name = "CCharge.findByCChargeId", query = "SELECT c FROM CCharge c WHERE c.cChargeId = :cChargeId"),
    @NamedQuery(name = "CCharge.findByIsactive", query = "SELECT c FROM CCharge c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCharge.findByCreated", query = "SELECT c FROM CCharge c WHERE c.created = :created"),
    @NamedQuery(name = "CCharge.findByCreatedby", query = "SELECT c FROM CCharge c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCharge.findByUpdated", query = "SELECT c FROM CCharge c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCharge.findByUpdatedby", query = "SELECT c FROM CCharge c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCharge.findByName", query = "SELECT c FROM CCharge c WHERE c.name = :name"),
    @NamedQuery(name = "CCharge.findByDescription", query = "SELECT c FROM CCharge c WHERE c.description = :description"),
    @NamedQuery(name = "CCharge.findByChargeamt", query = "SELECT c FROM CCharge c WHERE c.chargeamt = :chargeamt"),
    @NamedQuery(name = "CCharge.findByIssametax", query = "SELECT c FROM CCharge c WHERE c.issametax = :issametax"),
    @NamedQuery(name = "CCharge.findByIssamecurrency", query = "SELECT c FROM CCharge c WHERE c.issamecurrency = :issamecurrency"),
    @NamedQuery(name = "CCharge.findByIstaxincluded", query = "SELECT c FROM CCharge c WHERE c.istaxincluded = :istaxincluded")})
public class CCharge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_charge_id")
    private String cChargeId;
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
    @Column(name = "chargeamt")
    private BigInteger chargeamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issametax")
    private Character issametax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issamecurrency")
    private Character issamecurrency;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istaxincluded")
    private Character istaxincluded;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cChargeId")
    private List<IBankstatement> iBankstatementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cChargeId")
    private List<CInvoice> cInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cChargeId")
    private List<CChargeAcct> cChargeAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cChargeId")
    private List<CBankstatementline> cBankstatementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cChargeId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cChargeId")
    private List<CCashline> cCashlineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_taxcategory_id", referencedColumnName = "c_taxcategory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTaxcategory cTaxcategoryId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cChargeId")
    private List<CInvoiceline> cInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cChargeId")
    private List<COrderline> cOrderlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cChargeId")
    private List<MInout> mInoutList;

    public CCharge() {
    }

    public CCharge(String cChargeId) {
        this.cChargeId = cChargeId;
    }

    public CCharge(String cChargeId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, BigInteger chargeamt, Character issametax, Character issamecurrency, Character istaxincluded) {
        this.cChargeId = cChargeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.chargeamt = chargeamt;
        this.issametax = issametax;
        this.issamecurrency = issamecurrency;
        this.istaxincluded = istaxincluded;
    }

    public String getCChargeId() {
        return cChargeId;
    }

    public void setCChargeId(String cChargeId) {
        this.cChargeId = cChargeId;
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

    public BigInteger getChargeamt() {
        return chargeamt;
    }

    public void setChargeamt(BigInteger chargeamt) {
        this.chargeamt = chargeamt;
    }

    public Character getIssametax() {
        return issametax;
    }

    public void setIssametax(Character issametax) {
        this.issametax = issametax;
    }

    public Character getIssamecurrency() {
        return issamecurrency;
    }

    public void setIssamecurrency(Character issamecurrency) {
        this.issamecurrency = issamecurrency;
    }

    public Character getIstaxincluded() {
        return istaxincluded;
    }

    public void setIstaxincluded(Character istaxincluded) {
        this.istaxincluded = istaxincluded;
    }

    @XmlTransient
    public List<IBankstatement> getIBankstatementList() {
        return iBankstatementList;
    }

    public void setIBankstatementList(List<IBankstatement> iBankstatementList) {
        this.iBankstatementList = iBankstatementList;
    }

    @XmlTransient
    public List<CInvoice> getCInvoiceList() {
        return cInvoiceList;
    }

    public void setCInvoiceList(List<CInvoice> cInvoiceList) {
        this.cInvoiceList = cInvoiceList;
    }

    @XmlTransient
    public List<CChargeAcct> getCChargeAcctList() {
        return cChargeAcctList;
    }

    public void setCChargeAcctList(List<CChargeAcct> cChargeAcctList) {
        this.cChargeAcctList = cChargeAcctList;
    }

    @XmlTransient
    public List<CBankstatementline> getCBankstatementlineList() {
        return cBankstatementlineList;
    }

    public void setCBankstatementlineList(List<CBankstatementline> cBankstatementlineList) {
        this.cBankstatementlineList = cBankstatementlineList;
    }

    @XmlTransient
    public List<COrder> getCOrderList() {
        return cOrderList;
    }

    public void setCOrderList(List<COrder> cOrderList) {
        this.cOrderList = cOrderList;
    }

    @XmlTransient
    public List<CCashline> getCCashlineList() {
        return cCashlineList;
    }

    public void setCCashlineList(List<CCashline> cCashlineList) {
        this.cCashlineList = cCashlineList;
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

    public CTaxcategory getCTaxcategoryId() {
        return cTaxcategoryId;
    }

    public void setCTaxcategoryId(CTaxcategory cTaxcategoryId) {
        this.cTaxcategoryId = cTaxcategoryId;
    }

    @XmlTransient
    public List<CInvoiceline> getCInvoicelineList() {
        return cInvoicelineList;
    }

    public void setCInvoicelineList(List<CInvoiceline> cInvoicelineList) {
        this.cInvoicelineList = cInvoicelineList;
    }

    @XmlTransient
    public List<COrderline> getCOrderlineList() {
        return cOrderlineList;
    }

    public void setCOrderlineList(List<COrderline> cOrderlineList) {
        this.cOrderlineList = cOrderlineList;
    }

    @XmlTransient
    public List<MInout> getMInoutList() {
        return mInoutList;
    }

    public void setMInoutList(List<MInout> mInoutList) {
        this.mInoutList = mInoutList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cChargeId != null ? cChargeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCharge)) {
            return false;
        }
        CCharge other = (CCharge) object;
        if ((this.cChargeId == null && other.cChargeId != null) || (this.cChargeId != null && !this.cChargeId.equals(other.cChargeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCharge[ cChargeId=" + cChargeId + " ]";
    }
    
}
