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
@Table(name = "c_bankstatementline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBankstatementline.findAll", query = "SELECT c FROM CBankstatementline c"),
    @NamedQuery(name = "CBankstatementline.findByCBankstatementlineId", query = "SELECT c FROM CBankstatementline c WHERE c.cBankstatementlineId = :cBankstatementlineId"),
    @NamedQuery(name = "CBankstatementline.findByIsactive", query = "SELECT c FROM CBankstatementline c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBankstatementline.findByCreated", query = "SELECT c FROM CBankstatementline c WHERE c.created = :created"),
    @NamedQuery(name = "CBankstatementline.findByCreatedby", query = "SELECT c FROM CBankstatementline c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBankstatementline.findByUpdated", query = "SELECT c FROM CBankstatementline c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBankstatementline.findByUpdatedby", query = "SELECT c FROM CBankstatementline c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBankstatementline.findByLine", query = "SELECT c FROM CBankstatementline c WHERE c.line = :line"),
    @NamedQuery(name = "CBankstatementline.findByDescription", query = "SELECT c FROM CBankstatementline c WHERE c.description = :description"),
    @NamedQuery(name = "CBankstatementline.findByValutadate", query = "SELECT c FROM CBankstatementline c WHERE c.valutadate = :valutadate"),
    @NamedQuery(name = "CBankstatementline.findByDateacct", query = "SELECT c FROM CBankstatementline c WHERE c.dateacct = :dateacct"),
    @NamedQuery(name = "CBankstatementline.findByTrxamt", query = "SELECT c FROM CBankstatementline c WHERE c.trxamt = :trxamt"),
    @NamedQuery(name = "CBankstatementline.findByStmtamt", query = "SELECT c FROM CBankstatementline c WHERE c.stmtamt = :stmtamt"),
    @NamedQuery(name = "CBankstatementline.findByChargeamt", query = "SELECT c FROM CBankstatementline c WHERE c.chargeamt = :chargeamt"),
    @NamedQuery(name = "CBankstatementline.findByMemo", query = "SELECT c FROM CBankstatementline c WHERE c.memo = :memo"),
    @NamedQuery(name = "CBankstatementline.findByReferenceno", query = "SELECT c FROM CBankstatementline c WHERE c.referenceno = :referenceno"),
    @NamedQuery(name = "CBankstatementline.findByConvertchargeamt", query = "SELECT c FROM CBankstatementline c WHERE c.convertchargeamt = :convertchargeamt"),
    @NamedQuery(name = "CBankstatementline.findByCDebtPaymentCreate", query = "SELECT c FROM CBankstatementline c WHERE c.cDebtPaymentCreate = :cDebtPaymentCreate")})
public class CBankstatementline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_bankstatementline_id")
    private String cBankstatementlineId;
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
    @Column(name = "line")
    private long line;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valutadate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date valutadate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateacct")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateacct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trxamt")
    private BigInteger trxamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stmtamt")
    private BigInteger stmtamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chargeamt")
    private BigInteger chargeamt;
    @Size(max = 255)
    @Column(name = "memo")
    private String memo;
    @Size(max = 40)
    @Column(name = "referenceno")
    private String referenceno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "convertchargeamt")
    private BigInteger convertchargeamt;
    @Column(name = "c_debt_payment_create")
    private Character cDebtPaymentCreate;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBankstatementlineId")
    private List<IBankstatement> iBankstatementList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bankstatement_id", referencedColumnName = "c_bankstatement_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBankstatement cBankstatementId;
    @JoinColumn(name = "c_charge_id", referencedColumnName = "c_charge_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCharge cChargeId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_debt_payment_id", referencedColumnName = "c_debt_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDebtPayment cDebtPaymentId;
    @JoinColumn(name = "c_dp_management_id", referencedColumnName = "c_dp_management_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDpManagement cDpManagementId;
    @JoinColumn(name = "c_glitem_id", referencedColumnName = "c_glitem_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CGlitem cGlitemId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBankstatementlineId")
    private List<CDebtPayment> cDebtPaymentList;

    public CBankstatementline() {
    }

    public CBankstatementline(String cBankstatementlineId) {
        this.cBankstatementlineId = cBankstatementlineId;
    }

    public CBankstatementline(String cBankstatementlineId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, Date valutadate, Date dateacct, BigInteger trxamt, BigInteger stmtamt, BigInteger chargeamt, BigInteger convertchargeamt) {
        this.cBankstatementlineId = cBankstatementlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.valutadate = valutadate;
        this.dateacct = dateacct;
        this.trxamt = trxamt;
        this.stmtamt = stmtamt;
        this.chargeamt = chargeamt;
        this.convertchargeamt = convertchargeamt;
    }

    public String getCBankstatementlineId() {
        return cBankstatementlineId;
    }

    public void setCBankstatementlineId(String cBankstatementlineId) {
        this.cBankstatementlineId = cBankstatementlineId;
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

    public long getLine() {
        return line;
    }

    public void setLine(long line) {
        this.line = line;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getValutadate() {
        return valutadate;
    }

    public void setValutadate(Date valutadate) {
        this.valutadate = valutadate;
    }

    public Date getDateacct() {
        return dateacct;
    }

    public void setDateacct(Date dateacct) {
        this.dateacct = dateacct;
    }

    public BigInteger getTrxamt() {
        return trxamt;
    }

    public void setTrxamt(BigInteger trxamt) {
        this.trxamt = trxamt;
    }

    public BigInteger getStmtamt() {
        return stmtamt;
    }

    public void setStmtamt(BigInteger stmtamt) {
        this.stmtamt = stmtamt;
    }

    public BigInteger getChargeamt() {
        return chargeamt;
    }

    public void setChargeamt(BigInteger chargeamt) {
        this.chargeamt = chargeamt;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getReferenceno() {
        return referenceno;
    }

    public void setReferenceno(String referenceno) {
        this.referenceno = referenceno;
    }

    public BigInteger getConvertchargeamt() {
        return convertchargeamt;
    }

    public void setConvertchargeamt(BigInteger convertchargeamt) {
        this.convertchargeamt = convertchargeamt;
    }

    public Character getCDebtPaymentCreate() {
        return cDebtPaymentCreate;
    }

    public void setCDebtPaymentCreate(Character cDebtPaymentCreate) {
        this.cDebtPaymentCreate = cDebtPaymentCreate;
    }

    @XmlTransient
    public List<IBankstatement> getIBankstatementList() {
        return iBankstatementList;
    }

    public void setIBankstatementList(List<IBankstatement> iBankstatementList) {
        this.iBankstatementList = iBankstatementList;
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

    public CBankstatement getCBankstatementId() {
        return cBankstatementId;
    }

    public void setCBankstatementId(CBankstatement cBankstatementId) {
        this.cBankstatementId = cBankstatementId;
    }

    public CCharge getCChargeId() {
        return cChargeId;
    }

    public void setCChargeId(CCharge cChargeId) {
        this.cChargeId = cChargeId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CDebtPayment getCDebtPaymentId() {
        return cDebtPaymentId;
    }

    public void setCDebtPaymentId(CDebtPayment cDebtPaymentId) {
        this.cDebtPaymentId = cDebtPaymentId;
    }

    public CDpManagement getCDpManagementId() {
        return cDpManagementId;
    }

    public void setCDpManagementId(CDpManagement cDpManagementId) {
        this.cDpManagementId = cDpManagementId;
    }

    public CGlitem getCGlitemId() {
        return cGlitemId;
    }

    public void setCGlitemId(CGlitem cGlitemId) {
        this.cGlitemId = cGlitemId;
    }

    @XmlTransient
    public List<CDebtPayment> getCDebtPaymentList() {
        return cDebtPaymentList;
    }

    public void setCDebtPaymentList(List<CDebtPayment> cDebtPaymentList) {
        this.cDebtPaymentList = cDebtPaymentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBankstatementlineId != null ? cBankstatementlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBankstatementline)) {
            return false;
        }
        CBankstatementline other = (CBankstatementline) object;
        if ((this.cBankstatementlineId == null && other.cBankstatementlineId != null) || (this.cBankstatementlineId != null && !this.cBankstatementlineId.equals(other.cBankstatementlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBankstatementline[ cBankstatementlineId=" + cBankstatementlineId + " ]";
    }
    
}
