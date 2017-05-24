/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
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
@Table(name = "c_bp_bankaccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBpBankaccount.findAll", query = "SELECT c FROM CBpBankaccount c"),
    @NamedQuery(name = "CBpBankaccount.findByCBpBankaccountId", query = "SELECT c FROM CBpBankaccount c WHERE c.cBpBankaccountId = :cBpBankaccountId"),
    @NamedQuery(name = "CBpBankaccount.findByCreated", query = "SELECT c FROM CBpBankaccount c WHERE c.created = :created"),
    @NamedQuery(name = "CBpBankaccount.findByUpdated", query = "SELECT c FROM CBpBankaccount c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBpBankaccount.findByIsactive", query = "SELECT c FROM CBpBankaccount c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBpBankaccount.findByCreatedby", query = "SELECT c FROM CBpBankaccount c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBpBankaccount.findByUpdatedby", query = "SELECT c FROM CBpBankaccount c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBpBankaccount.findByBankaccounttype", query = "SELECT c FROM CBpBankaccount c WHERE c.bankaccounttype = :bankaccounttype"),
    @NamedQuery(name = "CBpBankaccount.findByRoutingno", query = "SELECT c FROM CBpBankaccount c WHERE c.routingno = :routingno"),
    @NamedQuery(name = "CBpBankaccount.findByAccountno", query = "SELECT c FROM CBpBankaccount c WHERE c.accountno = :accountno"),
    @NamedQuery(name = "CBpBankaccount.findByCreditcardtype", query = "SELECT c FROM CBpBankaccount c WHERE c.creditcardtype = :creditcardtype"),
    @NamedQuery(name = "CBpBankaccount.findByCreditcardnumber", query = "SELECT c FROM CBpBankaccount c WHERE c.creditcardnumber = :creditcardnumber"),
    @NamedQuery(name = "CBpBankaccount.findByCreditcardexpmm", query = "SELECT c FROM CBpBankaccount c WHERE c.creditcardexpmm = :creditcardexpmm"),
    @NamedQuery(name = "CBpBankaccount.findByCreditcardexpyy", query = "SELECT c FROM CBpBankaccount c WHERE c.creditcardexpyy = :creditcardexpyy"),
    @NamedQuery(name = "CBpBankaccount.findByAName", query = "SELECT c FROM CBpBankaccount c WHERE c.aName = :aName"),
    @NamedQuery(name = "CBpBankaccount.findByAStreet", query = "SELECT c FROM CBpBankaccount c WHERE c.aStreet = :aStreet"),
    @NamedQuery(name = "CBpBankaccount.findByACity", query = "SELECT c FROM CBpBankaccount c WHERE c.aCity = :aCity"),
    @NamedQuery(name = "CBpBankaccount.findByAState", query = "SELECT c FROM CBpBankaccount c WHERE c.aState = :aState"),
    @NamedQuery(name = "CBpBankaccount.findByAZip", query = "SELECT c FROM CBpBankaccount c WHERE c.aZip = :aZip"),
    @NamedQuery(name = "CBpBankaccount.findByAIdentDl", query = "SELECT c FROM CBpBankaccount c WHERE c.aIdentDl = :aIdentDl"),
    @NamedQuery(name = "CBpBankaccount.findByAEmail", query = "SELECT c FROM CBpBankaccount c WHERE c.aEmail = :aEmail"),
    @NamedQuery(name = "CBpBankaccount.findByAIdentSsn", query = "SELECT c FROM CBpBankaccount c WHERE c.aIdentSsn = :aIdentSsn"),
    @NamedQuery(name = "CBpBankaccount.findByRAvszip", query = "SELECT c FROM CBpBankaccount c WHERE c.rAvszip = :rAvszip"),
    @NamedQuery(name = "CBpBankaccount.findByACountry", query = "SELECT c FROM CBpBankaccount c WHERE c.aCountry = :aCountry"),
    @NamedQuery(name = "CBpBankaccount.findByBankName", query = "SELECT c FROM CBpBankaccount c WHERE c.bankName = :bankName"),
    @NamedQuery(name = "CBpBankaccount.findByIban", query = "SELECT c FROM CBpBankaccount c WHERE c.iban = :iban"),
    @NamedQuery(name = "CBpBankaccount.findByShowaccountno", query = "SELECT c FROM CBpBankaccount c WHERE c.showaccountno = :showaccountno"),
    @NamedQuery(name = "CBpBankaccount.findByShowiban", query = "SELECT c FROM CBpBankaccount c WHERE c.showiban = :showiban"),
    @NamedQuery(name = "CBpBankaccount.findByDisplayedaccount", query = "SELECT c FROM CBpBankaccount c WHERE c.displayedaccount = :displayedaccount"),
    @NamedQuery(name = "CBpBankaccount.findBySwiftcode", query = "SELECT c FROM CBpBankaccount c WHERE c.swiftcode = :swiftcode")})
public class CBpBankaccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_bp_bankaccount_id")
    private String cBpBankaccountId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isactive")
    private Character isactive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Size(max = 60)
    @Column(name = "bankaccounttype")
    private String bankaccounttype;
    @Size(max = 20)
    @Column(name = "routingno")
    private String routingno;
    @Size(max = 20)
    @Column(name = "accountno")
    private String accountno;
    @Size(max = 60)
    @Column(name = "creditcardtype")
    private String creditcardtype;
    @Size(max = 20)
    @Column(name = "creditcardnumber")
    private String creditcardnumber;
    @Column(name = "creditcardexpmm")
    private Long creditcardexpmm;
    @Column(name = "creditcardexpyy")
    private Long creditcardexpyy;
    @Size(max = 60)
    @Column(name = "a_name")
    private String aName;
    @Size(max = 60)
    @Column(name = "a_street")
    private String aStreet;
    @Size(max = 60)
    @Column(name = "a_city")
    private String aCity;
    @Size(max = 40)
    @Column(name = "a_state")
    private String aState;
    @Size(max = 20)
    @Column(name = "a_zip")
    private String aZip;
    @Size(max = 20)
    @Column(name = "a_ident_dl")
    private String aIdentDl;
    @Size(max = 40)
    @Column(name = "a_email")
    private String aEmail;
    @Size(max = 20)
    @Column(name = "a_ident_ssn")
    private String aIdentSsn;
    @Size(max = 60)
    @Column(name = "r_avszip")
    private String rAvszip;
    @Size(max = 40)
    @Column(name = "a_country")
    private String aCountry;
    @Size(max = 50)
    @Column(name = "bank_name")
    private String bankName;
    @Size(max = 34)
    @Column(name = "iban")
    private String iban;
    @Column(name = "showaccountno")
    private Character showaccountno;
    @Column(name = "showiban")
    private Character showiban;
    @Size(max = 34)
    @Column(name = "displayedaccount")
    private String displayedaccount;
    @Size(max = 20)
    @Column(name = "swiftcode")
    private String swiftcode;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCountry cCountryId;

    public CBpBankaccount() {
    }

    public CBpBankaccount(String cBpBankaccountId) {
        this.cBpBankaccountId = cBpBankaccountId;
    }

    public CBpBankaccount(String cBpBankaccountId, Date created, Date updated, Character isactive, String createdby, String updatedby) {
        this.cBpBankaccountId = cBpBankaccountId;
        this.created = created;
        this.updated = updated;
        this.isactive = isactive;
        this.createdby = createdby;
        this.updatedby = updatedby;
    }

    public String getCBpBankaccountId() {
        return cBpBankaccountId;
    }

    public void setCBpBankaccountId(String cBpBankaccountId) {
        this.cBpBankaccountId = cBpBankaccountId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
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

    public String getRoutingno() {
        return routingno;
    }

    public void setRoutingno(String routingno) {
        this.routingno = routingno;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public String getCreditcardtype() {
        return creditcardtype;
    }

    public void setCreditcardtype(String creditcardtype) {
        this.creditcardtype = creditcardtype;
    }

    public String getCreditcardnumber() {
        return creditcardnumber;
    }

    public void setCreditcardnumber(String creditcardnumber) {
        this.creditcardnumber = creditcardnumber;
    }

    public Long getCreditcardexpmm() {
        return creditcardexpmm;
    }

    public void setCreditcardexpmm(Long creditcardexpmm) {
        this.creditcardexpmm = creditcardexpmm;
    }

    public Long getCreditcardexpyy() {
        return creditcardexpyy;
    }

    public void setCreditcardexpyy(Long creditcardexpyy) {
        this.creditcardexpyy = creditcardexpyy;
    }

    public String getAName() {
        return aName;
    }

    public void setAName(String aName) {
        this.aName = aName;
    }

    public String getAStreet() {
        return aStreet;
    }

    public void setAStreet(String aStreet) {
        this.aStreet = aStreet;
    }

    public String getACity() {
        return aCity;
    }

    public void setACity(String aCity) {
        this.aCity = aCity;
    }

    public String getAState() {
        return aState;
    }

    public void setAState(String aState) {
        this.aState = aState;
    }

    public String getAZip() {
        return aZip;
    }

    public void setAZip(String aZip) {
        this.aZip = aZip;
    }

    public String getAIdentDl() {
        return aIdentDl;
    }

    public void setAIdentDl(String aIdentDl) {
        this.aIdentDl = aIdentDl;
    }

    public String getAEmail() {
        return aEmail;
    }

    public void setAEmail(String aEmail) {
        this.aEmail = aEmail;
    }

    public String getAIdentSsn() {
        return aIdentSsn;
    }

    public void setAIdentSsn(String aIdentSsn) {
        this.aIdentSsn = aIdentSsn;
    }

    public String getRAvszip() {
        return rAvszip;
    }

    public void setRAvszip(String rAvszip) {
        this.rAvszip = rAvszip;
    }

    public String getACountry() {
        return aCountry;
    }

    public void setACountry(String aCountry) {
        this.aCountry = aCountry;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Character getShowaccountno() {
        return showaccountno;
    }

    public void setShowaccountno(Character showaccountno) {
        this.showaccountno = showaccountno;
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

    public String getSwiftcode() {
        return swiftcode;
    }

    public void setSwiftcode(String swiftcode) {
        this.swiftcode = swiftcode;
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

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CCountry getCCountryId() {
        return cCountryId;
    }

    public void setCCountryId(CCountry cCountryId) {
        this.cCountryId = cCountryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBpBankaccountId != null ? cBpBankaccountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBpBankaccount)) {
            return false;
        }
        CBpBankaccount other = (CBpBankaccount) object;
        if ((this.cBpBankaccountId == null && other.cBpBankaccountId != null) || (this.cBpBankaccountId != null && !this.cBpBankaccountId.equals(other.cBpBankaccountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBpBankaccount[ cBpBankaccountId=" + cBpBankaccountId + " ]";
    }
    
}
