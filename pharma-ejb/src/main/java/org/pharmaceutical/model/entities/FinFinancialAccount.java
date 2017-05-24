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
@Table(name = "fin_financial_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinFinancialAccount.findAll", query = "SELECT f FROM FinFinancialAccount f"),
    @NamedQuery(name = "FinFinancialAccount.findByFinFinancialAccountId", query = "SELECT f FROM FinFinancialAccount f WHERE f.finFinancialAccountId = :finFinancialAccountId"),
    @NamedQuery(name = "FinFinancialAccount.findByCreated", query = "SELECT f FROM FinFinancialAccount f WHERE f.created = :created"),
    @NamedQuery(name = "FinFinancialAccount.findByCreatedby", query = "SELECT f FROM FinFinancialAccount f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinFinancialAccount.findByUpdated", query = "SELECT f FROM FinFinancialAccount f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinFinancialAccount.findByUpdatedby", query = "SELECT f FROM FinFinancialAccount f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinFinancialAccount.findByIsactive", query = "SELECT f FROM FinFinancialAccount f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinFinancialAccount.findByName", query = "SELECT f FROM FinFinancialAccount f WHERE f.name = :name"),
    @NamedQuery(name = "FinFinancialAccount.findByDescription", query = "SELECT f FROM FinFinancialAccount f WHERE f.description = :description"),
    @NamedQuery(name = "FinFinancialAccount.findByType", query = "SELECT f FROM FinFinancialAccount f WHERE f.type = :type"),
    @NamedQuery(name = "FinFinancialAccount.findByRoutingno", query = "SELECT f FROM FinFinancialAccount f WHERE f.routingno = :routingno"),
    @NamedQuery(name = "FinFinancialAccount.findBySwiftcode", query = "SELECT f FROM FinFinancialAccount f WHERE f.swiftcode = :swiftcode"),
    @NamedQuery(name = "FinFinancialAccount.findByCodebank", query = "SELECT f FROM FinFinancialAccount f WHERE f.codebank = :codebank"),
    @NamedQuery(name = "FinFinancialAccount.findByCodebranch", query = "SELECT f FROM FinFinancialAccount f WHERE f.codebranch = :codebranch"),
    @NamedQuery(name = "FinFinancialAccount.findByBankDigitcontrol", query = "SELECT f FROM FinFinancialAccount f WHERE f.bankDigitcontrol = :bankDigitcontrol"),
    @NamedQuery(name = "FinFinancialAccount.findByIneNumber", query = "SELECT f FROM FinFinancialAccount f WHERE f.ineNumber = :ineNumber"),
    @NamedQuery(name = "FinFinancialAccount.findByAccountDigitcontrol", query = "SELECT f FROM FinFinancialAccount f WHERE f.accountDigitcontrol = :accountDigitcontrol"),
    @NamedQuery(name = "FinFinancialAccount.findByCodeaccount", query = "SELECT f FROM FinFinancialAccount f WHERE f.codeaccount = :codeaccount"),
    @NamedQuery(name = "FinFinancialAccount.findByAccountno", query = "SELECT f FROM FinFinancialAccount f WHERE f.accountno = :accountno"),
    @NamedQuery(name = "FinFinancialAccount.findByCurrentbalance", query = "SELECT f FROM FinFinancialAccount f WHERE f.currentbalance = :currentbalance"),
    @NamedQuery(name = "FinFinancialAccount.findByInitialbalance", query = "SELECT f FROM FinFinancialAccount f WHERE f.initialbalance = :initialbalance"),
    @NamedQuery(name = "FinFinancialAccount.findByCreditlimit", query = "SELECT f FROM FinFinancialAccount f WHERE f.creditlimit = :creditlimit"),
    @NamedQuery(name = "FinFinancialAccount.findByIban", query = "SELECT f FROM FinFinancialAccount f WHERE f.iban = :iban"),
    @NamedQuery(name = "FinFinancialAccount.findByIsdefault", query = "SELECT f FROM FinFinancialAccount f WHERE f.isdefault = :isdefault")})
public class FinFinancialAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_financial_account_id")
    private String finFinancialAccountId;
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
    @Column(name = "isactive")
    private Character isactive;
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
    @Size(min = 1, max = 60)
    @Column(name = "type")
    private String type;
    @Size(max = 20)
    @Column(name = "routingno")
    private String routingno;
    @Size(max = 20)
    @Column(name = "swiftcode")
    private String swiftcode;
    @Size(max = 4)
    @Column(name = "codebank")
    private String codebank;
    @Size(max = 4)
    @Column(name = "codebranch")
    private String codebranch;
    @Size(max = 1)
    @Column(name = "bank_digitcontrol")
    private String bankDigitcontrol;
    @Size(max = 9)
    @Column(name = "ine_number")
    private String ineNumber;
    @Size(max = 1)
    @Column(name = "account_digitcontrol")
    private String accountDigitcontrol;
    @Size(max = 10)
    @Column(name = "codeaccount")
    private String codeaccount;
    @Size(max = 20)
    @Column(name = "accountno")
    private String accountno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currentbalance")
    private BigInteger currentbalance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "initialbalance")
    private BigInteger initialbalance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creditlimit")
    private BigInteger creditlimit;
    @Size(max = 34)
    @Column(name = "iban")
    private String iban;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdefault")
    private Character isdefault;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "poFinancialAccountId")
    private List<CBpartner> cBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finFinancialAccountId")
    private List<CBpartner> cBpartnerList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finFinancialAccountId")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_location_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLocationId;
    @JoinColumn(name = "fin_matching_algorithm_id", referencedColumnName = "fin_matching_algorithm_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinMatchingAlgorithm finMatchingAlgorithmId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finFinancialAccountId")
    private List<FinFinaccPaymentmethod> finFinaccPaymentmethodList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finFinancialAccountId")
    private List<FinPayment> finPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finFinancialAccountId")
    private List<FinBankstatement> finBankstatementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finFinancialAccountId")
    private List<FinReconciliation> finReconciliationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finFinancialAccountId")
    private List<FinFinaccTransaction> finFinaccTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finFinancialAccountId")
    private List<FinPaymentProposal> finPaymentProposalList;

    public FinFinancialAccount() {
    }

    public FinFinancialAccount(String finFinancialAccountId) {
        this.finFinancialAccountId = finFinancialAccountId;
    }

    public FinFinancialAccount(String finFinancialAccountId, Date created, String createdby, Date updated, String updatedby, String name, String type, BigInteger currentbalance, BigInteger initialbalance, BigInteger creditlimit, Character isdefault) {
        this.finFinancialAccountId = finFinancialAccountId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.type = type;
        this.currentbalance = currentbalance;
        this.initialbalance = initialbalance;
        this.creditlimit = creditlimit;
        this.isdefault = isdefault;
    }

    public String getFinFinancialAccountId() {
        return finFinancialAccountId;
    }

    public void setFinFinancialAccountId(String finFinancialAccountId) {
        this.finFinancialAccountId = finFinancialAccountId;
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

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoutingno() {
        return routingno;
    }

    public void setRoutingno(String routingno) {
        this.routingno = routingno;
    }

    public String getSwiftcode() {
        return swiftcode;
    }

    public void setSwiftcode(String swiftcode) {
        this.swiftcode = swiftcode;
    }

    public String getCodebank() {
        return codebank;
    }

    public void setCodebank(String codebank) {
        this.codebank = codebank;
    }

    public String getCodebranch() {
        return codebranch;
    }

    public void setCodebranch(String codebranch) {
        this.codebranch = codebranch;
    }

    public String getBankDigitcontrol() {
        return bankDigitcontrol;
    }

    public void setBankDigitcontrol(String bankDigitcontrol) {
        this.bankDigitcontrol = bankDigitcontrol;
    }

    public String getIneNumber() {
        return ineNumber;
    }

    public void setIneNumber(String ineNumber) {
        this.ineNumber = ineNumber;
    }

    public String getAccountDigitcontrol() {
        return accountDigitcontrol;
    }

    public void setAccountDigitcontrol(String accountDigitcontrol) {
        this.accountDigitcontrol = accountDigitcontrol;
    }

    public String getCodeaccount() {
        return codeaccount;
    }

    public void setCodeaccount(String codeaccount) {
        this.codeaccount = codeaccount;
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

    public BigInteger getInitialbalance() {
        return initialbalance;
    }

    public void setInitialbalance(BigInteger initialbalance) {
        this.initialbalance = initialbalance;
    }

    public BigInteger getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(BigInteger creditlimit) {
        this.creditlimit = creditlimit;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
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
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList() {
        return finFinancialAccountAcctList;
    }

    public void setFinFinancialAccountAcctList(List<FinFinancialAccountAcct> finFinancialAccountAcctList) {
        this.finFinancialAccountAcctList = finFinancialAccountAcctList;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CLocation getCLocationId() {
        return cLocationId;
    }

    public void setCLocationId(CLocation cLocationId) {
        this.cLocationId = cLocationId;
    }

    public FinMatchingAlgorithm getFinMatchingAlgorithmId() {
        return finMatchingAlgorithmId;
    }

    public void setFinMatchingAlgorithmId(FinMatchingAlgorithm finMatchingAlgorithmId) {
        this.finMatchingAlgorithmId = finMatchingAlgorithmId;
    }

    @XmlTransient
    public List<FinFinaccPaymentmethod> getFinFinaccPaymentmethodList() {
        return finFinaccPaymentmethodList;
    }

    public void setFinFinaccPaymentmethodList(List<FinFinaccPaymentmethod> finFinaccPaymentmethodList) {
        this.finFinaccPaymentmethodList = finFinaccPaymentmethodList;
    }

    @XmlTransient
    public List<FinPayment> getFinPaymentList() {
        return finPaymentList;
    }

    public void setFinPaymentList(List<FinPayment> finPaymentList) {
        this.finPaymentList = finPaymentList;
    }

    @XmlTransient
    public List<FinBankstatement> getFinBankstatementList() {
        return finBankstatementList;
    }

    public void setFinBankstatementList(List<FinBankstatement> finBankstatementList) {
        this.finBankstatementList = finBankstatementList;
    }

    @XmlTransient
    public List<FinReconciliation> getFinReconciliationList() {
        return finReconciliationList;
    }

    public void setFinReconciliationList(List<FinReconciliation> finReconciliationList) {
        this.finReconciliationList = finReconciliationList;
    }

    @XmlTransient
    public List<FinFinaccTransaction> getFinFinaccTransactionList() {
        return finFinaccTransactionList;
    }

    public void setFinFinaccTransactionList(List<FinFinaccTransaction> finFinaccTransactionList) {
        this.finFinaccTransactionList = finFinaccTransactionList;
    }

    @XmlTransient
    public List<FinPaymentProposal> getFinPaymentProposalList() {
        return finPaymentProposalList;
    }

    public void setFinPaymentProposalList(List<FinPaymentProposal> finPaymentProposalList) {
        this.finPaymentProposalList = finPaymentProposalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finFinancialAccountId != null ? finFinancialAccountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinFinancialAccount)) {
            return false;
        }
        FinFinancialAccount other = (FinFinancialAccount) object;
        if ((this.finFinancialAccountId == null && other.finFinancialAccountId != null) || (this.finFinancialAccountId != null && !this.finFinancialAccountId.equals(other.finFinancialAccountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinFinancialAccount[ finFinancialAccountId=" + finFinancialAccountId + " ]";
    }
    
}
