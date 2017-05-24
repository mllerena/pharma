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
@Table(name = "ad_test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdTest.findAll", query = "SELECT a FROM AdTest a"),
    @NamedQuery(name = "AdTest.findByAdTestId", query = "SELECT a FROM AdTest a WHERE a.adTestId = :adTestId"),
    @NamedQuery(name = "AdTest.findByIsactive", query = "SELECT a FROM AdTest a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdTest.findByCreated", query = "SELECT a FROM AdTest a WHERE a.created = :created"),
    @NamedQuery(name = "AdTest.findByCreatedby", query = "SELECT a FROM AdTest a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdTest.findByUpdated", query = "SELECT a FROM AdTest a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdTest.findByUpdatedby", query = "SELECT a FROM AdTest a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdTest.findByName", query = "SELECT a FROM AdTest a WHERE a.name = :name"),
    @NamedQuery(name = "AdTest.findByDescription", query = "SELECT a FROM AdTest a WHERE a.description = :description"),
    @NamedQuery(name = "AdTest.findByHelp", query = "SELECT a FROM AdTest a WHERE a.help = :help"),
    @NamedQuery(name = "AdTest.findByTInteger", query = "SELECT a FROM AdTest a WHERE a.tInteger = :tInteger"),
    @NamedQuery(name = "AdTest.findByTNumber", query = "SELECT a FROM AdTest a WHERE a.tNumber = :tNumber"),
    @NamedQuery(name = "AdTest.findByTDate", query = "SELECT a FROM AdTest a WHERE a.tDate = :tDate"),
    @NamedQuery(name = "AdTest.findByTDatetime", query = "SELECT a FROM AdTest a WHERE a.tDatetime = :tDatetime"),
    @NamedQuery(name = "AdTest.findByTQty", query = "SELECT a FROM AdTest a WHERE a.tQty = :tQty"),
    @NamedQuery(name = "AdTest.findByTAmount", query = "SELECT a FROM AdTest a WHERE a.tAmount = :tAmount"),
    @NamedQuery(name = "AdTest.findByProcessing", query = "SELECT a FROM AdTest a WHERE a.processing = :processing"),
    @NamedQuery(name = "AdTest.findByProcessed", query = "SELECT a FROM AdTest a WHERE a.processed = :processed")})
public class AdTest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_test_id")
    private String adTestId;
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
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Column(name = "t_integer")
    private Long tInteger;
    @Column(name = "t_number")
    private BigInteger tNumber;
    @Column(name = "t_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tDate;
    @Column(name = "t_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tDatetime;
    @Column(name = "t_qty")
    private BigInteger tQty;
    @Column(name = "t_amount")
    private BigInteger tAmount;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "processed")
    private Character processed;
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
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_debt_payment_id", referencedColumnName = "c_debt_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDebtPayment cDebtPaymentId;
    @JoinColumn(name = "c_location_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLocationId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomId;
    @JoinColumn(name = "account_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination accountAcct;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MLocator mLocatorId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;

    public AdTest() {
    }

    public AdTest(String adTestId) {
        this.adTestId = adTestId;
    }

    public AdTest(String adTestId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.adTestId = adTestId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getAdTestId() {
        return adTestId;
    }

    public void setAdTestId(String adTestId) {
        this.adTestId = adTestId;
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

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public Long getTInteger() {
        return tInteger;
    }

    public void setTInteger(Long tInteger) {
        this.tInteger = tInteger;
    }

    public BigInteger getTNumber() {
        return tNumber;
    }

    public void setTNumber(BigInteger tNumber) {
        this.tNumber = tNumber;
    }

    public Date getTDate() {
        return tDate;
    }

    public void setTDate(Date tDate) {
        this.tDate = tDate;
    }

    public Date getTDatetime() {
        return tDatetime;
    }

    public void setTDatetime(Date tDatetime) {
        this.tDatetime = tDatetime;
    }

    public BigInteger getTQty() {
        return tQty;
    }

    public void setTQty(BigInteger tQty) {
        this.tQty = tQty;
    }

    public BigInteger getTAmount() {
        return tAmount;
    }

    public void setTAmount(BigInteger tAmount) {
        this.tAmount = tAmount;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
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

    public CDebtPayment getCDebtPaymentId() {
        return cDebtPaymentId;
    }

    public void setCDebtPaymentId(CDebtPayment cDebtPaymentId) {
        this.cDebtPaymentId = cDebtPaymentId;
    }

    public CLocation getCLocationId() {
        return cLocationId;
    }

    public void setCLocationId(CLocation cLocationId) {
        this.cLocationId = cLocationId;
    }

    public CUom getCUomId() {
        return cUomId;
    }

    public void setCUomId(CUom cUomId) {
        this.cUomId = cUomId;
    }

    public CValidcombination getAccountAcct() {
        return accountAcct;
    }

    public void setAccountAcct(CValidcombination accountAcct) {
        this.accountAcct = accountAcct;
    }

    public MLocator getMLocatorId() {
        return mLocatorId;
    }

    public void setMLocatorId(MLocator mLocatorId) {
        this.mLocatorId = mLocatorId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adTestId != null ? adTestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdTest)) {
            return false;
        }
        AdTest other = (AdTest) object;
        if ((this.adTestId == null && other.adTestId != null) || (this.adTestId != null && !this.adTestId.equals(other.adTestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdTest[ adTestId=" + adTestId + " ]";
    }
    
}
