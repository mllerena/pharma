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
@Table(name = "c_tax_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTaxAcct.findAll", query = "SELECT c FROM CTaxAcct c"),
    @NamedQuery(name = "CTaxAcct.findByCTaxAcctId", query = "SELECT c FROM CTaxAcct c WHERE c.cTaxAcctId = :cTaxAcctId"),
    @NamedQuery(name = "CTaxAcct.findByIsactive", query = "SELECT c FROM CTaxAcct c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CTaxAcct.findByCreated", query = "SELECT c FROM CTaxAcct c WHERE c.created = :created"),
    @NamedQuery(name = "CTaxAcct.findByCreatedby", query = "SELECT c FROM CTaxAcct c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CTaxAcct.findByUpdated", query = "SELECT c FROM CTaxAcct c WHERE c.updated = :updated"),
    @NamedQuery(name = "CTaxAcct.findByUpdatedby", query = "SELECT c FROM CTaxAcct c WHERE c.updatedby = :updatedby")})
public class CTaxAcct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_tax_acct_id")
    private String cTaxAcctId;
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
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CTax cTaxId;
    @JoinColumn(name = "t_receivables_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination tReceivablesAcct;
    @JoinColumn(name = "t_credit_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination tCreditAcct;
    @JoinColumn(name = "t_liability_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination tLiabilityAcct;
    @JoinColumn(name = "t_expense_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination tExpenseAcct;
    @JoinColumn(name = "t_due_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination tDueAcct;

    public CTaxAcct() {
    }

    public CTaxAcct(String cTaxAcctId) {
        this.cTaxAcctId = cTaxAcctId;
    }

    public CTaxAcct(String cTaxAcctId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cTaxAcctId = cTaxAcctId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCTaxAcctId() {
        return cTaxAcctId;
    }

    public void setCTaxAcctId(String cTaxAcctId) {
        this.cTaxAcctId = cTaxAcctId;
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

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    public CValidcombination getTReceivablesAcct() {
        return tReceivablesAcct;
    }

    public void setTReceivablesAcct(CValidcombination tReceivablesAcct) {
        this.tReceivablesAcct = tReceivablesAcct;
    }

    public CValidcombination getTCreditAcct() {
        return tCreditAcct;
    }

    public void setTCreditAcct(CValidcombination tCreditAcct) {
        this.tCreditAcct = tCreditAcct;
    }

    public CValidcombination getTLiabilityAcct() {
        return tLiabilityAcct;
    }

    public void setTLiabilityAcct(CValidcombination tLiabilityAcct) {
        this.tLiabilityAcct = tLiabilityAcct;
    }

    public CValidcombination getTExpenseAcct() {
        return tExpenseAcct;
    }

    public void setTExpenseAcct(CValidcombination tExpenseAcct) {
        this.tExpenseAcct = tExpenseAcct;
    }

    public CValidcombination getTDueAcct() {
        return tDueAcct;
    }

    public void setTDueAcct(CValidcombination tDueAcct) {
        this.tDueAcct = tDueAcct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTaxAcctId != null ? cTaxAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTaxAcct)) {
            return false;
        }
        CTaxAcct other = (CTaxAcct) object;
        if ((this.cTaxAcctId == null && other.cTaxAcctId != null) || (this.cTaxAcctId != null && !this.cTaxAcctId.equals(other.cTaxAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CTaxAcct[ cTaxAcctId=" + cTaxAcctId + " ]";
    }
    
}
