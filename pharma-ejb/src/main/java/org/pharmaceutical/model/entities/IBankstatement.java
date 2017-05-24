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
@Table(name = "i_bankstatement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IBankstatement.findAll", query = "SELECT i FROM IBankstatement i"),
    @NamedQuery(name = "IBankstatement.findByIBankstatementId", query = "SELECT i FROM IBankstatement i WHERE i.iBankstatementId = :iBankstatementId"),
    @NamedQuery(name = "IBankstatement.findByIsactive", query = "SELECT i FROM IBankstatement i WHERE i.isactive = :isactive"),
    @NamedQuery(name = "IBankstatement.findByCreated", query = "SELECT i FROM IBankstatement i WHERE i.created = :created"),
    @NamedQuery(name = "IBankstatement.findByCreatedby", query = "SELECT i FROM IBankstatement i WHERE i.createdby = :createdby"),
    @NamedQuery(name = "IBankstatement.findByUpdated", query = "SELECT i FROM IBankstatement i WHERE i.updated = :updated"),
    @NamedQuery(name = "IBankstatement.findByUpdatedby", query = "SELECT i FROM IBankstatement i WHERE i.updatedby = :updatedby"),
    @NamedQuery(name = "IBankstatement.findByIIsimported", query = "SELECT i FROM IBankstatement i WHERE i.iIsimported = :iIsimported"),
    @NamedQuery(name = "IBankstatement.findByIErrormsg", query = "SELECT i FROM IBankstatement i WHERE i.iErrormsg = :iErrormsg"),
    @NamedQuery(name = "IBankstatement.findByProcessed", query = "SELECT i FROM IBankstatement i WHERE i.processed = :processed"),
    @NamedQuery(name = "IBankstatement.findByStatementdate", query = "SELECT i FROM IBankstatement i WHERE i.statementdate = :statementdate"),
    @NamedQuery(name = "IBankstatement.findByDescription", query = "SELECT i FROM IBankstatement i WHERE i.description = :description"),
    @NamedQuery(name = "IBankstatement.findByRoutingno", query = "SELECT i FROM IBankstatement i WHERE i.routingno = :routingno"),
    @NamedQuery(name = "IBankstatement.findByBankaccountno", query = "SELECT i FROM IBankstatement i WHERE i.bankaccountno = :bankaccountno"),
    @NamedQuery(name = "IBankstatement.findByDocumentno", query = "SELECT i FROM IBankstatement i WHERE i.documentno = :documentno"),
    @NamedQuery(name = "IBankstatement.findByName", query = "SELECT i FROM IBankstatement i WHERE i.name = :name"),
    @NamedQuery(name = "IBankstatement.findByBpartnervalue", query = "SELECT i FROM IBankstatement i WHERE i.bpartnervalue = :bpartnervalue"),
    @NamedQuery(name = "IBankstatement.findByInvoicedocumentno", query = "SELECT i FROM IBankstatement i WHERE i.invoicedocumentno = :invoicedocumentno"),
    @NamedQuery(name = "IBankstatement.findByChargename", query = "SELECT i FROM IBankstatement i WHERE i.chargename = :chargename"),
    @NamedQuery(name = "IBankstatement.findByChargeamt", query = "SELECT i FROM IBankstatement i WHERE i.chargeamt = :chargeamt"),
    @NamedQuery(name = "IBankstatement.findByLine", query = "SELECT i FROM IBankstatement i WHERE i.line = :line"),
    @NamedQuery(name = "IBankstatement.findByDateacct", query = "SELECT i FROM IBankstatement i WHERE i.dateacct = :dateacct"),
    @NamedQuery(name = "IBankstatement.findByTrxtype", query = "SELECT i FROM IBankstatement i WHERE i.trxtype = :trxtype"),
    @NamedQuery(name = "IBankstatement.findByReferenceno", query = "SELECT i FROM IBankstatement i WHERE i.referenceno = :referenceno"),
    @NamedQuery(name = "IBankstatement.findByMemo", query = "SELECT i FROM IBankstatement i WHERE i.memo = :memo"),
    @NamedQuery(name = "IBankstatement.findByValutadate", query = "SELECT i FROM IBankstatement i WHERE i.valutadate = :valutadate"),
    @NamedQuery(name = "IBankstatement.findByIsreversal", query = "SELECT i FROM IBankstatement i WHERE i.isreversal = :isreversal"),
    @NamedQuery(name = "IBankstatement.findByInterestamt", query = "SELECT i FROM IBankstatement i WHERE i.interestamt = :interestamt"),
    @NamedQuery(name = "IBankstatement.findByTrxamt", query = "SELECT i FROM IBankstatement i WHERE i.trxamt = :trxamt"),
    @NamedQuery(name = "IBankstatement.findByLinedescription", query = "SELECT i FROM IBankstatement i WHERE i.linedescription = :linedescription"),
    @NamedQuery(name = "IBankstatement.findByStmtamt", query = "SELECT i FROM IBankstatement i WHERE i.stmtamt = :stmtamt")})
public class IBankstatement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "i_bankstatement_id")
    private String iBankstatementId;
    @Column(name = "isactive")
    private Character isactive;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Size(max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Column(name = "i_isimported")
    private Character iIsimported;
    @Size(max = 2000)
    @Column(name = "i_errormsg")
    private String iErrormsg;
    @Column(name = "processed")
    private Character processed;
    @Column(name = "statementdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statementdate;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 20)
    @Column(name = "routingno")
    private String routingno;
    @Size(max = 20)
    @Column(name = "bankaccountno")
    private String bankaccountno;
    @Size(max = 30)
    @Column(name = "documentno")
    private String documentno;
    @Size(max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 40)
    @Column(name = "bpartnervalue")
    private String bpartnervalue;
    @Size(max = 30)
    @Column(name = "invoicedocumentno")
    private String invoicedocumentno;
    @Size(max = 60)
    @Column(name = "chargename")
    private String chargename;
    @Column(name = "chargeamt")
    private BigInteger chargeamt;
    @Column(name = "line")
    private Long line;
    @Column(name = "dateacct")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateacct;
    @Size(max = 60)
    @Column(name = "trxtype")
    private String trxtype;
    @Size(max = 40)
    @Column(name = "referenceno")
    private String referenceno;
    @Size(max = 255)
    @Column(name = "memo")
    private String memo;
    @Column(name = "valutadate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date valutadate;
    @Column(name = "isreversal")
    private Character isreversal;
    @Column(name = "interestamt")
    private BigInteger interestamt;
    @Column(name = "trxamt")
    private BigInteger trxamt;
    @Size(max = 255)
    @Column(name = "linedescription")
    private String linedescription;
    @Column(name = "stmtamt")
    private BigInteger stmtamt;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bankaccount_id", referencedColumnName = "c_bankaccount_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBankaccount cBankaccountId;
    @JoinColumn(name = "c_bankstatement_id", referencedColumnName = "c_bankstatement_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBankstatement cBankstatementId;
    @JoinColumn(name = "c_bankstatementline_id", referencedColumnName = "c_bankstatementline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBankstatementline cBankstatementlineId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_charge_id", referencedColumnName = "c_charge_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCharge cChargeId;
    @JoinColumn(name = "c_debt_payment_id", referencedColumnName = "c_debt_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDebtPayment cDebtPaymentId;
    @JoinColumn(name = "c_invoice_id", referencedColumnName = "c_invoice_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoice cInvoiceId;

    public IBankstatement() {
    }

    public IBankstatement(String iBankstatementId) {
        this.iBankstatementId = iBankstatementId;
    }

    public String getIBankstatementId() {
        return iBankstatementId;
    }

    public void setIBankstatementId(String iBankstatementId) {
        this.iBankstatementId = iBankstatementId;
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

    public Character getIIsimported() {
        return iIsimported;
    }

    public void setIIsimported(Character iIsimported) {
        this.iIsimported = iIsimported;
    }

    public String getIErrormsg() {
        return iErrormsg;
    }

    public void setIErrormsg(String iErrormsg) {
        this.iErrormsg = iErrormsg;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public Date getStatementdate() {
        return statementdate;
    }

    public void setStatementdate(Date statementdate) {
        this.statementdate = statementdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoutingno() {
        return routingno;
    }

    public void setRoutingno(String routingno) {
        this.routingno = routingno;
    }

    public String getBankaccountno() {
        return bankaccountno;
    }

    public void setBankaccountno(String bankaccountno) {
        this.bankaccountno = bankaccountno;
    }

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBpartnervalue() {
        return bpartnervalue;
    }

    public void setBpartnervalue(String bpartnervalue) {
        this.bpartnervalue = bpartnervalue;
    }

    public String getInvoicedocumentno() {
        return invoicedocumentno;
    }

    public void setInvoicedocumentno(String invoicedocumentno) {
        this.invoicedocumentno = invoicedocumentno;
    }

    public String getChargename() {
        return chargename;
    }

    public void setChargename(String chargename) {
        this.chargename = chargename;
    }

    public BigInteger getChargeamt() {
        return chargeamt;
    }

    public void setChargeamt(BigInteger chargeamt) {
        this.chargeamt = chargeamt;
    }

    public Long getLine() {
        return line;
    }

    public void setLine(Long line) {
        this.line = line;
    }

    public Date getDateacct() {
        return dateacct;
    }

    public void setDateacct(Date dateacct) {
        this.dateacct = dateacct;
    }

    public String getTrxtype() {
        return trxtype;
    }

    public void setTrxtype(String trxtype) {
        this.trxtype = trxtype;
    }

    public String getReferenceno() {
        return referenceno;
    }

    public void setReferenceno(String referenceno) {
        this.referenceno = referenceno;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getValutadate() {
        return valutadate;
    }

    public void setValutadate(Date valutadate) {
        this.valutadate = valutadate;
    }

    public Character getIsreversal() {
        return isreversal;
    }

    public void setIsreversal(Character isreversal) {
        this.isreversal = isreversal;
    }

    public BigInteger getInterestamt() {
        return interestamt;
    }

    public void setInterestamt(BigInteger interestamt) {
        this.interestamt = interestamt;
    }

    public BigInteger getTrxamt() {
        return trxamt;
    }

    public void setTrxamt(BigInteger trxamt) {
        this.trxamt = trxamt;
    }

    public String getLinedescription() {
        return linedescription;
    }

    public void setLinedescription(String linedescription) {
        this.linedescription = linedescription;
    }

    public BigInteger getStmtamt() {
        return stmtamt;
    }

    public void setStmtamt(BigInteger stmtamt) {
        this.stmtamt = stmtamt;
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

    public CBankaccount getCBankaccountId() {
        return cBankaccountId;
    }

    public void setCBankaccountId(CBankaccount cBankaccountId) {
        this.cBankaccountId = cBankaccountId;
    }

    public CBankstatement getCBankstatementId() {
        return cBankstatementId;
    }

    public void setCBankstatementId(CBankstatement cBankstatementId) {
        this.cBankstatementId = cBankstatementId;
    }

    public CBankstatementline getCBankstatementlineId() {
        return cBankstatementlineId;
    }

    public void setCBankstatementlineId(CBankstatementline cBankstatementlineId) {
        this.cBankstatementlineId = cBankstatementlineId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CCharge getCChargeId() {
        return cChargeId;
    }

    public void setCChargeId(CCharge cChargeId) {
        this.cChargeId = cChargeId;
    }

    public CDebtPayment getCDebtPaymentId() {
        return cDebtPaymentId;
    }

    public void setCDebtPaymentId(CDebtPayment cDebtPaymentId) {
        this.cDebtPaymentId = cDebtPaymentId;
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
        hash += (iBankstatementId != null ? iBankstatementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IBankstatement)) {
            return false;
        }
        IBankstatement other = (IBankstatement) object;
        if ((this.iBankstatementId == null && other.iBankstatementId != null) || (this.iBankstatementId != null && !this.iBankstatementId.equals(other.iBankstatementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.IBankstatement[ iBankstatementId=" + iBankstatementId + " ]";
    }
    
}
