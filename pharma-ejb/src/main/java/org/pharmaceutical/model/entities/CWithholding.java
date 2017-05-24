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
@Table(name = "c_withholding")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CWithholding.findAll", query = "SELECT c FROM CWithholding c"),
    @NamedQuery(name = "CWithholding.findByCWithholdingId", query = "SELECT c FROM CWithholding c WHERE c.cWithholdingId = :cWithholdingId"),
    @NamedQuery(name = "CWithholding.findByIsactive", query = "SELECT c FROM CWithholding c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CWithholding.findByCreated", query = "SELECT c FROM CWithholding c WHERE c.created = :created"),
    @NamedQuery(name = "CWithholding.findByCreatedby", query = "SELECT c FROM CWithholding c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CWithholding.findByUpdated", query = "SELECT c FROM CWithholding c WHERE c.updated = :updated"),
    @NamedQuery(name = "CWithholding.findByUpdatedby", query = "SELECT c FROM CWithholding c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CWithholding.findByName", query = "SELECT c FROM CWithholding c WHERE c.name = :name"),
    @NamedQuery(name = "CWithholding.findByDescription", query = "SELECT c FROM CWithholding c WHERE c.description = :description"),
    @NamedQuery(name = "CWithholding.findByIstaxwithholding", query = "SELECT c FROM CWithholding c WHERE c.istaxwithholding = :istaxwithholding"),
    @NamedQuery(name = "CWithholding.findByIstaxprorated", query = "SELECT c FROM CWithholding c WHERE c.istaxprorated = :istaxprorated"),
    @NamedQuery(name = "CWithholding.findByIspaidto3party", query = "SELECT c FROM CWithholding c WHERE c.ispaidto3party = :ispaidto3party"),
    @NamedQuery(name = "CWithholding.findByIspercentwithholding", query = "SELECT c FROM CWithholding c WHERE c.ispercentwithholding = :ispercentwithholding"),
    @NamedQuery(name = "CWithholding.findByPercent", query = "SELECT c FROM CWithholding c WHERE c.percent = :percent"),
    @NamedQuery(name = "CWithholding.findByFixamt", query = "SELECT c FROM CWithholding c WHERE c.fixamt = :fixamt"),
    @NamedQuery(name = "CWithholding.findByThresholdmin", query = "SELECT c FROM CWithholding c WHERE c.thresholdmin = :thresholdmin"),
    @NamedQuery(name = "CWithholding.findByThresholdmax", query = "SELECT c FROM CWithholding c WHERE c.thresholdmax = :thresholdmax"),
    @NamedQuery(name = "CWithholding.findByMinamt", query = "SELECT c FROM CWithholding c WHERE c.minamt = :minamt"),
    @NamedQuery(name = "CWithholding.findByMaxamt", query = "SELECT c FROM CWithholding c WHERE c.maxamt = :maxamt"),
    @NamedQuery(name = "CWithholding.findByRate", query = "SELECT c FROM CWithholding c WHERE c.rate = :rate")})
public class CWithholding implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_withholding_id")
    private String cWithholdingId;
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
    @Column(name = "istaxwithholding")
    private Character istaxwithholding;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istaxprorated")
    private Character istaxprorated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ispaidto3party")
    private Character ispaidto3party;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ispercentwithholding")
    private Character ispercentwithholding;
    @Column(name = "percent")
    private BigInteger percent;
    @Column(name = "fixamt")
    private BigInteger fixamt;
    @Column(name = "thresholdmin")
    private BigInteger thresholdmin;
    @Column(name = "thresholdmax")
    private BigInteger thresholdmax;
    @Column(name = "minamt")
    private BigInteger minamt;
    @Column(name = "maxamt")
    private BigInteger maxamt;
    @Column(name = "rate")
    private BigInteger rate;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cWithholdingId")
    private List<CInvoice> cInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cWithholdingId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cWithholdingId")
    private List<GlJournalline> glJournallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cWithholdingId")
    private List<CBpWithholding> cBpWithholdingList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "beneficiary", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner beneficiary;
    @JoinColumn(name = "c_paymentterm_id", referencedColumnName = "c_paymentterm_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPaymentterm cPaymenttermId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cWithholdingId")
    private List<CWithholdingAcct> cWithholdingAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cWithholdingId")
    private List<CDebtPayment> cDebtPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cWithholdingId")
    private List<CGlitem> cGlitemList;

    public CWithholding() {
    }

    public CWithholding(String cWithholdingId) {
        this.cWithholdingId = cWithholdingId;
    }

    public CWithholding(String cWithholdingId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character istaxwithholding, Character istaxprorated, Character ispaidto3party, Character ispercentwithholding) {
        this.cWithholdingId = cWithholdingId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.istaxwithholding = istaxwithholding;
        this.istaxprorated = istaxprorated;
        this.ispaidto3party = ispaidto3party;
        this.ispercentwithholding = ispercentwithholding;
    }

    public String getCWithholdingId() {
        return cWithholdingId;
    }

    public void setCWithholdingId(String cWithholdingId) {
        this.cWithholdingId = cWithholdingId;
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

    public Character getIstaxwithholding() {
        return istaxwithholding;
    }

    public void setIstaxwithholding(Character istaxwithholding) {
        this.istaxwithholding = istaxwithholding;
    }

    public Character getIstaxprorated() {
        return istaxprorated;
    }

    public void setIstaxprorated(Character istaxprorated) {
        this.istaxprorated = istaxprorated;
    }

    public Character getIspaidto3party() {
        return ispaidto3party;
    }

    public void setIspaidto3party(Character ispaidto3party) {
        this.ispaidto3party = ispaidto3party;
    }

    public Character getIspercentwithholding() {
        return ispercentwithholding;
    }

    public void setIspercentwithholding(Character ispercentwithholding) {
        this.ispercentwithholding = ispercentwithholding;
    }

    public BigInteger getPercent() {
        return percent;
    }

    public void setPercent(BigInteger percent) {
        this.percent = percent;
    }

    public BigInteger getFixamt() {
        return fixamt;
    }

    public void setFixamt(BigInteger fixamt) {
        this.fixamt = fixamt;
    }

    public BigInteger getThresholdmin() {
        return thresholdmin;
    }

    public void setThresholdmin(BigInteger thresholdmin) {
        this.thresholdmin = thresholdmin;
    }

    public BigInteger getThresholdmax() {
        return thresholdmax;
    }

    public void setThresholdmax(BigInteger thresholdmax) {
        this.thresholdmax = thresholdmax;
    }

    public BigInteger getMinamt() {
        return minamt;
    }

    public void setMinamt(BigInteger minamt) {
        this.minamt = minamt;
    }

    public BigInteger getMaxamt() {
        return maxamt;
    }

    public void setMaxamt(BigInteger maxamt) {
        this.maxamt = maxamt;
    }

    public BigInteger getRate() {
        return rate;
    }

    public void setRate(BigInteger rate) {
        this.rate = rate;
    }

    @XmlTransient
    public List<CInvoice> getCInvoiceList() {
        return cInvoiceList;
    }

    public void setCInvoiceList(List<CInvoice> cInvoiceList) {
        this.cInvoiceList = cInvoiceList;
    }

    @XmlTransient
    public List<FactAcct> getFactAcctList() {
        return factAcctList;
    }

    public void setFactAcctList(List<FactAcct> factAcctList) {
        this.factAcctList = factAcctList;
    }

    @XmlTransient
    public List<GlJournalline> getGlJournallineList() {
        return glJournallineList;
    }

    public void setGlJournallineList(List<GlJournalline> glJournallineList) {
        this.glJournallineList = glJournallineList;
    }

    @XmlTransient
    public List<CBpWithholding> getCBpWithholdingList() {
        return cBpWithholdingList;
    }

    public void setCBpWithholdingList(List<CBpWithholding> cBpWithholdingList) {
        this.cBpWithholdingList = cBpWithholdingList;
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

    public CBpartner getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(CBpartner beneficiary) {
        this.beneficiary = beneficiary;
    }

    public CPaymentterm getCPaymenttermId() {
        return cPaymenttermId;
    }

    public void setCPaymenttermId(CPaymentterm cPaymenttermId) {
        this.cPaymenttermId = cPaymenttermId;
    }

    @XmlTransient
    public List<CWithholdingAcct> getCWithholdingAcctList() {
        return cWithholdingAcctList;
    }

    public void setCWithholdingAcctList(List<CWithholdingAcct> cWithholdingAcctList) {
        this.cWithholdingAcctList = cWithholdingAcctList;
    }

    @XmlTransient
    public List<CDebtPayment> getCDebtPaymentList() {
        return cDebtPaymentList;
    }

    public void setCDebtPaymentList(List<CDebtPayment> cDebtPaymentList) {
        this.cDebtPaymentList = cDebtPaymentList;
    }

    @XmlTransient
    public List<CGlitem> getCGlitemList() {
        return cGlitemList;
    }

    public void setCGlitemList(List<CGlitem> cGlitemList) {
        this.cGlitemList = cGlitemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cWithholdingId != null ? cWithholdingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CWithholding)) {
            return false;
        }
        CWithholding other = (CWithholding) object;
        if ((this.cWithholdingId == null && other.cWithholdingId != null) || (this.cWithholdingId != null && !this.cWithholdingId.equals(other.cWithholdingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CWithholding[ cWithholdingId=" + cWithholdingId + " ]";
    }
    
}
