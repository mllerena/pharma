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
@Table(name = "c_bankaccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBankaccount.findAll", query = "SELECT c FROM CBankaccount c"),
    @NamedQuery(name = "CBankaccount.findByCBankaccountId", query = "SELECT c FROM CBankaccount c WHERE c.cBankaccountId = :cBankaccountId"),
    @NamedQuery(name = "CBankaccount.findByIsactive", query = "SELECT c FROM CBankaccount c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBankaccount.findByCreated", query = "SELECT c FROM CBankaccount c WHERE c.created = :created"),
    @NamedQuery(name = "CBankaccount.findByCreatedby", query = "SELECT c FROM CBankaccount c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBankaccount.findByUpdated", query = "SELECT c FROM CBankaccount c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBankaccount.findByUpdatedby", query = "SELECT c FROM CBankaccount c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBankaccount.findByBankaccounttype", query = "SELECT c FROM CBankaccount c WHERE c.bankaccounttype = :bankaccounttype"),
    @NamedQuery(name = "CBankaccount.findByAccountno", query = "SELECT c FROM CBankaccount c WHERE c.accountno = :accountno"),
    @NamedQuery(name = "CBankaccount.findByCurrentbalance", query = "SELECT c FROM CBankaccount c WHERE c.currentbalance = :currentbalance"),
    @NamedQuery(name = "CBankaccount.findByCreditlimit", query = "SELECT c FROM CBankaccount c WHERE c.creditlimit = :creditlimit"),
    @NamedQuery(name = "CBankaccount.findByIsdefault", query = "SELECT c FROM CBankaccount c WHERE c.isdefault = :isdefault"),
    @NamedQuery(name = "CBankaccount.findByCodeaccount", query = "SELECT c FROM CBankaccount c WHERE c.codeaccount = :codeaccount"),
    @NamedQuery(name = "CBankaccount.findByDigitcontrol", query = "SELECT c FROM CBankaccount c WHERE c.digitcontrol = :digitcontrol"),
    @NamedQuery(name = "CBankaccount.findByIban", query = "SELECT c FROM CBankaccount c WHERE c.iban = :iban"),
    @NamedQuery(name = "CBankaccount.findByGenericaccount", query = "SELECT c FROM CBankaccount c WHERE c.genericaccount = :genericaccount"),
    @NamedQuery(name = "CBankaccount.findByShowgeneric", query = "SELECT c FROM CBankaccount c WHERE c.showgeneric = :showgeneric"),
    @NamedQuery(name = "CBankaccount.findByShowspanish", query = "SELECT c FROM CBankaccount c WHERE c.showspanish = :showspanish"),
    @NamedQuery(name = "CBankaccount.findByShowiban", query = "SELECT c FROM CBankaccount c WHERE c.showiban = :showiban"),
    @NamedQuery(name = "CBankaccount.findByDisplayedaccount", query = "SELECT c FROM CBankaccount c WHERE c.displayedaccount = :displayedaccount")})
public class CBankaccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_bankaccount_id")
    private String cBankaccountId;
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
    @Column(name = "bankaccounttype")
    private String bankaccounttype;
    @Size(max = 20)
    @Column(name = "accountno")
    private String accountno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currentbalance")
    private BigInteger currentbalance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creditlimit")
    private BigInteger creditlimit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdefault")
    private Character isdefault;
    @Size(max = 10)
    @Column(name = "codeaccount")
    private String codeaccount;
    @Size(max = 1)
    @Column(name = "digitcontrol")
    private String digitcontrol;
    @Size(max = 34)
    @Column(name = "iban")
    private String iban;
    @Size(max = 50)
    @Column(name = "genericaccount")
    private String genericaccount;
    @Column(name = "showgeneric")
    private Character showgeneric;
    @Column(name = "showspanish")
    private Character showspanish;
    @Column(name = "showiban")
    private Character showiban;
    @Size(max = 50)
    @Column(name = "displayedaccount")
    private String displayedaccount;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBankaccountId")
    private List<CElementvalue> cElementvalueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBankaccountId")
    private List<IBankstatement> iBankstatementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "soBankaccountId")
    private List<CBpartner> cBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "poBankaccountId")
    private List<CBpartner> cBpartnerList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBankaccountId")
    private List<CRemittance> cRemittanceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBankaccountId")
    private List<CBankstatement> cBankstatementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBankaccountId")
    private List<CPromissoryformat> cPromissoryformatList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBankaccountId")
    private List<CDebtPayment> cDebtPaymentList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bank_id", referencedColumnName = "c_bank_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBank cBankId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBankaccountId")
    private List<CBankaccountAcct> cBankaccountAcctList;

    public CBankaccount() {
    }

    public CBankaccount(String cBankaccountId) {
        this.cBankaccountId = cBankaccountId;
    }

    public CBankaccount(String cBankaccountId, Character isactive, Date created, String createdby, Date updated, String updatedby, String bankaccounttype, BigInteger currentbalance, BigInteger creditlimit, Character isdefault) {
        this.cBankaccountId = cBankaccountId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.bankaccounttype = bankaccounttype;
        this.currentbalance = currentbalance;
        this.creditlimit = creditlimit;
        this.isdefault = isdefault;
    }

    public String getCBankaccountId() {
        return cBankaccountId;
    }

    public void setCBankaccountId(String cBankaccountId) {
        this.cBankaccountId = cBankaccountId;
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

    public String getBankaccounttype() {
        return bankaccounttype;
    }

    public void setBankaccounttype(String bankaccounttype) {
        this.bankaccounttype = bankaccounttype;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public BigInteger getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(BigInteger currentbalance) {
        this.currentbalance = currentbalance;
    }

    public BigInteger getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(BigInteger creditlimit) {
        this.creditlimit = creditlimit;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    public String getCodeaccount() {
        return codeaccount;
    }

    public void setCodeaccount(String codeaccount) {
        this.codeaccount = codeaccount;
    }

    public String getDigitcontrol() {
        return digitcontrol;
    }

    public void setDigitcontrol(String digitcontrol) {
        this.digitcontrol = digitcontrol;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getGenericaccount() {
        return genericaccount;
    }

    public void setGenericaccount(String genericaccount) {
        this.genericaccount = genericaccount;
    }

    public Character getShowgeneric() {
        return showgeneric;
    }

    public void setShowgeneric(Character showgeneric) {
        this.showgeneric = showgeneric;
    }

    public Character getShowspanish() {
        return showspanish;
    }

    public void setShowspanish(Character showspanish) {
        this.showspanish = showspanish;
    }

    public Character getShowiban() {
        return showiban;
    }

    public void setShowiban(Character showiban) {
        this.showiban = showiban;
    }

    public String getDisplayedaccount() {
        return displayedaccount;
    }

    public void setDisplayedaccount(String displayedaccount) {
        this.displayedaccount = displayedaccount;
    }

    @XmlTransient
    public List<CElementvalue> getCElementvalueList() {
        return cElementvalueList;
    }

    public void setCElementvalueList(List<CElementvalue> cElementvalueList) {
        this.cElementvalueList = cElementvalueList;
    }

    @XmlTransient
    public List<IBankstatement> getIBankstatementList() {
        return iBankstatementList;
    }

    public void setIBankstatementList(List<IBankstatement> iBankstatementList) {
        this.iBankstatementList = iBankstatementList;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList() {
        return cBpartnerList;
    }

    public void setCBpartnerList(List<CBpartner> cBpartnerList) {
        this.cBpartnerList = cBpartnerList;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList1() {
        return cBpartnerList1;
    }

    public void setCBpartnerList1(List<CBpartner> cBpartnerList1) {
        this.cBpartnerList1 = cBpartnerList1;
    }

    @XmlTransient
    public List<CRemittance> getCRemittanceList() {
        return cRemittanceList;
    }

    public void setCRemittanceList(List<CRemittance> cRemittanceList) {
        this.cRemittanceList = cRemittanceList;
    }

    @XmlTransient
    public List<CBankstatement> getCBankstatementList() {
        return cBankstatementList;
    }

    public void setCBankstatementList(List<CBankstatement> cBankstatementList) {
        this.cBankstatementList = cBankstatementList;
    }

    @XmlTransient
    public List<CPromissoryformat> getCPromissoryformatList() {
        return cPromissoryformatList;
    }

    public void setCPromissoryformatList(List<CPromissoryformat> cPromissoryformatList) {
        this.cPromissoryformatList = cPromissoryformatList;
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

    public CBank getCBankId() {
        return cBankId;
    }

    public void setCBankId(CBank cBankId) {
        this.cBankId = cBankId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    @XmlTransient
    public List<CBankaccountAcct> getCBankaccountAcctList() {
        return cBankaccountAcctList;
    }

    public void setCBankaccountAcctList(List<CBankaccountAcct> cBankaccountAcctList) {
        this.cBankaccountAcctList = cBankaccountAcctList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBankaccountId != null ? cBankaccountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBankaccount)) {
            return false;
        }
        CBankaccount other = (CBankaccount) object;
        if ((this.cBankaccountId == null && other.cBankaccountId != null) || (this.cBankaccountId != null && !this.cBankaccountId.equals(other.cBankaccountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBankaccount[ cBankaccountId=" + cBankaccountId + " ]";
    }
    
}
