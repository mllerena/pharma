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
@Table(name = "c_cashbook_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCashbookAcct.findAll", query = "SELECT c FROM CCashbookAcct c"),
    @NamedQuery(name = "CCashbookAcct.findByCCashbookAcctId", query = "SELECT c FROM CCashbookAcct c WHERE c.cCashbookAcctId = :cCashbookAcctId"),
    @NamedQuery(name = "CCashbookAcct.findByIsactive", query = "SELECT c FROM CCashbookAcct c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCashbookAcct.findByCreated", query = "SELECT c FROM CCashbookAcct c WHERE c.created = :created"),
    @NamedQuery(name = "CCashbookAcct.findByCreatedby", query = "SELECT c FROM CCashbookAcct c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCashbookAcct.findByUpdated", query = "SELECT c FROM CCashbookAcct c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCashbookAcct.findByUpdatedby", query = "SELECT c FROM CCashbookAcct c WHERE c.updatedby = :updatedby")})
public class CCashbookAcct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_cashbook_acct_id")
    private String cCashbookAcctId;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "c_cashbook_id", referencedColumnName = "c_cashbook_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCashbook cCashbookId;
    @JoinColumn(name = "cb_receipt_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination cbReceiptAcct;
    @JoinColumn(name = "cb_asset_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination cbAssetAcct;
    @JoinColumn(name = "cb_expense_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination cbExpenseAcct;
    @JoinColumn(name = "cb_differences_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination cbDifferencesAcct;
    @JoinColumn(name = "cb_cashtransfer_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination cbCashtransferAcct;

    public CCashbookAcct() {
    }

    public CCashbookAcct(String cCashbookAcctId) {
        this.cCashbookAcctId = cCashbookAcctId;
    }

    public CCashbookAcct(String cCashbookAcctId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cCashbookAcctId = cCashbookAcctId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCCashbookAcctId() {
        return cCashbookAcctId;
    }

    public void setCCashbookAcctId(String cCashbookAcctId) {
        this.cCashbookAcctId = cCashbookAcctId;
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

    public CAcctschema getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(CAcctschema cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
    }

    public CCashbook getCCashbookId() {
        return cCashbookId;
    }

    public void setCCashbookId(CCashbook cCashbookId) {
        this.cCashbookId = cCashbookId;
    }

    public CValidcombination getCbReceiptAcct() {
        return cbReceiptAcct;
    }

    public void setCbReceiptAcct(CValidcombination cbReceiptAcct) {
        this.cbReceiptAcct = cbReceiptAcct;
    }

    public CValidcombination getCbAssetAcct() {
        return cbAssetAcct;
    }

    public void setCbAssetAcct(CValidcombination cbAssetAcct) {
        this.cbAssetAcct = cbAssetAcct;
    }

    public CValidcombination getCbExpenseAcct() {
        return cbExpenseAcct;
    }

    public void setCbExpenseAcct(CValidcombination cbExpenseAcct) {
        this.cbExpenseAcct = cbExpenseAcct;
    }

    public CValidcombination getCbDifferencesAcct() {
        return cbDifferencesAcct;
    }

    public void setCbDifferencesAcct(CValidcombination cbDifferencesAcct) {
        this.cbDifferencesAcct = cbDifferencesAcct;
    }

    public CValidcombination getCbCashtransferAcct() {
        return cbCashtransferAcct;
    }

    public void setCbCashtransferAcct(CValidcombination cbCashtransferAcct) {
        this.cbCashtransferAcct = cbCashtransferAcct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCashbookAcctId != null ? cCashbookAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCashbookAcct)) {
            return false;
        }
        CCashbookAcct other = (CCashbookAcct) object;
        if ((this.cCashbookAcctId == null && other.cCashbookAcctId != null) || (this.cCashbookAcctId != null && !this.cCashbookAcctId.equals(other.cCashbookAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCashbookAcct[ cCashbookAcctId=" + cCashbookAcctId + " ]";
    }
    
}
