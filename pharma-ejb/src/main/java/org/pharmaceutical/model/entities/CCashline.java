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
import javax.persistence.OneToOne;
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
@Table(name = "c_cashline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCashline.findAll", query = "SELECT c FROM CCashline c"),
    @NamedQuery(name = "CCashline.findByCCashlineId", query = "SELECT c FROM CCashline c WHERE c.cCashlineId = :cCashlineId"),
    @NamedQuery(name = "CCashline.findByIsactive", query = "SELECT c FROM CCashline c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCashline.findByCreated", query = "SELECT c FROM CCashline c WHERE c.created = :created"),
    @NamedQuery(name = "CCashline.findByCreatedby", query = "SELECT c FROM CCashline c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCashline.findByUpdated", query = "SELECT c FROM CCashline c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCashline.findByUpdatedby", query = "SELECT c FROM CCashline c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCashline.findByLine", query = "SELECT c FROM CCashline c WHERE c.line = :line"),
    @NamedQuery(name = "CCashline.findByDescription", query = "SELECT c FROM CCashline c WHERE c.description = :description"),
    @NamedQuery(name = "CCashline.findByCashtype", query = "SELECT c FROM CCashline c WHERE c.cashtype = :cashtype"),
    @NamedQuery(name = "CCashline.findByAmount", query = "SELECT c FROM CCashline c WHERE c.amount = :amount"),
    @NamedQuery(name = "CCashline.findByDiscountamt", query = "SELECT c FROM CCashline c WHERE c.discountamt = :discountamt"),
    @NamedQuery(name = "CCashline.findByWriteoffamt", query = "SELECT c FROM CCashline c WHERE c.writeoffamt = :writeoffamt"),
    @NamedQuery(name = "CCashline.findByIsgenerated", query = "SELECT c FROM CCashline c WHERE c.isgenerated = :isgenerated"),
    @NamedQuery(name = "CCashline.findByPayinadvance", query = "SELECT c FROM CCashline c WHERE c.payinadvance = :payinadvance")})
public class CCashline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_cashline_id")
    private String cCashlineId;
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
    @Size(min = 1, max = 60)
    @Column(name = "cashtype")
    private String cashtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigInteger amount;
    @Column(name = "discountamt")
    private BigInteger discountamt;
    @Column(name = "writeoffamt")
    private BigInteger writeoffamt;
    @Column(name = "isgenerated")
    private Character isgenerated;
    @Column(name = "payinadvance")
    private Character payinadvance;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_cash_id", referencedColumnName = "c_cash_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCash cCashId;
    @JoinColumn(name = "c_charge_id", referencedColumnName = "c_charge_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCharge cChargeId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_debt_payment_id", referencedColumnName = "c_debt_payment_id")
    @OneToOne
    private CDebtPayment cDebtPaymentId;
    @JoinColumn(name = "c_glitem_id", referencedColumnName = "c_glitem_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CGlitem cGlitemId;
    @JoinColumn(name = "c_order_id", referencedColumnName = "c_order_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrder cOrderId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCashlineId")
    private List<CDebtPayment> cDebtPaymentList;

    public CCashline() {
    }

    public CCashline(String cCashlineId) {
        this.cCashlineId = cCashlineId;
    }

    public CCashline(String cCashlineId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, String cashtype, BigInteger amount) {
        this.cCashlineId = cCashlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.cashtype = cashtype;
        this.amount = amount;
    }

    public String getCCashlineId() {
        return cCashlineId;
    }

    public void setCCashlineId(String cCashlineId) {
        this.cCashlineId = cCashlineId;
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

    public String getCashtype() {
        return cashtype;
    }

    public void setCashtype(String cashtype) {
        this.cashtype = cashtype;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public BigInteger getDiscountamt() {
        return discountamt;
    }

    public void setDiscountamt(BigInteger discountamt) {
        this.discountamt = discountamt;
    }

    public BigInteger getWriteoffamt() {
        return writeoffamt;
    }

    public void setWriteoffamt(BigInteger writeoffamt) {
        this.writeoffamt = writeoffamt;
    }

    public Character getIsgenerated() {
        return isgenerated;
    }

    public void setIsgenerated(Character isgenerated) {
        this.isgenerated = isgenerated;
    }

    public Character getPayinadvance() {
        return payinadvance;
    }

    public void setPayinadvance(Character payinadvance) {
        this.payinadvance = payinadvance;
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

    public CCash getCCashId() {
        return cCashId;
    }

    public void setCCashId(CCash cCashId) {
        this.cCashId = cCashId;
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

    public CGlitem getCGlitemId() {
        return cGlitemId;
    }

    public void setCGlitemId(CGlitem cGlitemId) {
        this.cGlitemId = cGlitemId;
    }

    public COrder getCOrderId() {
        return cOrderId;
    }

    public void setCOrderId(COrder cOrderId) {
        this.cOrderId = cOrderId;
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
        hash += (cCashlineId != null ? cCashlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCashline)) {
            return false;
        }
        CCashline other = (CCashline) object;
        if ((this.cCashlineId == null && other.cCashlineId != null) || (this.cCashlineId != null && !this.cCashlineId.equals(other.cCashlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCashline[ cCashlineId=" + cCashlineId + " ]";
    }
    
}
