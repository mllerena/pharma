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
@Table(name = "c_acctschema_gl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CAcctschemaGl.findAll", query = "SELECT c FROM CAcctschemaGl c"),
    @NamedQuery(name = "CAcctschemaGl.findByCAcctschemaGlId", query = "SELECT c FROM CAcctschemaGl c WHERE c.cAcctschemaGlId = :cAcctschemaGlId"),
    @NamedQuery(name = "CAcctschemaGl.findByIsactive", query = "SELECT c FROM CAcctschemaGl c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CAcctschemaGl.findByCreated", query = "SELECT c FROM CAcctschemaGl c WHERE c.created = :created"),
    @NamedQuery(name = "CAcctschemaGl.findByCreatedby", query = "SELECT c FROM CAcctschemaGl c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CAcctschemaGl.findByUpdated", query = "SELECT c FROM CAcctschemaGl c WHERE c.updated = :updated"),
    @NamedQuery(name = "CAcctschemaGl.findByUpdatedby", query = "SELECT c FROM CAcctschemaGl c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CAcctschemaGl.findByUsesuspensebalancing", query = "SELECT c FROM CAcctschemaGl c WHERE c.usesuspensebalancing = :usesuspensebalancing"),
    @NamedQuery(name = "CAcctschemaGl.findByUsesuspenseerror", query = "SELECT c FROM CAcctschemaGl c WHERE c.usesuspenseerror = :usesuspenseerror"),
    @NamedQuery(name = "CAcctschemaGl.findByUsecurrencybalancing", query = "SELECT c FROM CAcctschemaGl c WHERE c.usecurrencybalancing = :usecurrencybalancing")})
public class CAcctschemaGl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_acctschema_gl_id")
    private String cAcctschemaGlId;
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
    @Column(name = "usesuspensebalancing")
    private Character usesuspensebalancing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usesuspenseerror")
    private Character usesuspenseerror;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usecurrencybalancing")
    private Character usecurrencybalancing;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "retainedearning_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination retainedearningAcct;
    @JoinColumn(name = "ppvoffset_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination ppvoffsetAcct;
    @JoinColumn(name = "intercompanyduefrom_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination intercompanyduefromAcct;
    @JoinColumn(name = "cfs_order_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination cfsOrderAcct;
    @JoinColumn(name = "incomesummary_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination incomesummaryAcct;
    @JoinColumn(name = "suspensebalancing_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination suspensebalancingAcct;
    @JoinColumn(name = "currencybalancing_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination currencybalancingAcct;
    @JoinColumn(name = "intercompanydueto_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination intercompanyduetoAcct;
    @JoinColumn(name = "suspenseerror_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination suspenseerrorAcct;

    public CAcctschemaGl() {
    }

    public CAcctschemaGl(String cAcctschemaGlId) {
        this.cAcctschemaGlId = cAcctschemaGlId;
    }

    public CAcctschemaGl(String cAcctschemaGlId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character usesuspensebalancing, Character usesuspenseerror, Character usecurrencybalancing) {
        this.cAcctschemaGlId = cAcctschemaGlId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.usesuspensebalancing = usesuspensebalancing;
        this.usesuspenseerror = usesuspenseerror;
        this.usecurrencybalancing = usecurrencybalancing;
    }

    public String getCAcctschemaGlId() {
        return cAcctschemaGlId;
    }

    public void setCAcctschemaGlId(String cAcctschemaGlId) {
        this.cAcctschemaGlId = cAcctschemaGlId;
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

    public Character getUsesuspensebalancing() {
        return usesuspensebalancing;
    }

    public void setUsesuspensebalancing(Character usesuspensebalancing) {
        this.usesuspensebalancing = usesuspensebalancing;
    }

    public Character getUsesuspenseerror() {
        return usesuspenseerror;
    }

    public void setUsesuspenseerror(Character usesuspenseerror) {
        this.usesuspenseerror = usesuspenseerror;
    }

    public Character getUsecurrencybalancing() {
        return usecurrencybalancing;
    }

    public void setUsecurrencybalancing(Character usecurrencybalancing) {
        this.usecurrencybalancing = usecurrencybalancing;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public CAcctschema getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(CAcctschema cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
    }

    public CValidcombination getRetainedearningAcct() {
        return retainedearningAcct;
    }

    public void setRetainedearningAcct(CValidcombination retainedearningAcct) {
        this.retainedearningAcct = retainedearningAcct;
    }

    public CValidcombination getPpvoffsetAcct() {
        return ppvoffsetAcct;
    }

    public void setPpvoffsetAcct(CValidcombination ppvoffsetAcct) {
        this.ppvoffsetAcct = ppvoffsetAcct;
    }

    public CValidcombination getIntercompanyduefromAcct() {
        return intercompanyduefromAcct;
    }

    public void setIntercompanyduefromAcct(CValidcombination intercompanyduefromAcct) {
        this.intercompanyduefromAcct = intercompanyduefromAcct;
    }

    public CValidcombination getCfsOrderAcct() {
        return cfsOrderAcct;
    }

    public void setCfsOrderAcct(CValidcombination cfsOrderAcct) {
        this.cfsOrderAcct = cfsOrderAcct;
    }

    public CValidcombination getIncomesummaryAcct() {
        return incomesummaryAcct;
    }

    public void setIncomesummaryAcct(CValidcombination incomesummaryAcct) {
        this.incomesummaryAcct = incomesummaryAcct;
    }

    public CValidcombination getSuspensebalancingAcct() {
        return suspensebalancingAcct;
    }

    public void setSuspensebalancingAcct(CValidcombination suspensebalancingAcct) {
        this.suspensebalancingAcct = suspensebalancingAcct;
    }

    public CValidcombination getCurrencybalancingAcct() {
        return currencybalancingAcct;
    }

    public void setCurrencybalancingAcct(CValidcombination currencybalancingAcct) {
        this.currencybalancingAcct = currencybalancingAcct;
    }

    public CValidcombination getIntercompanyduetoAcct() {
        return intercompanyduetoAcct;
    }

    public void setIntercompanyduetoAcct(CValidcombination intercompanyduetoAcct) {
        this.intercompanyduetoAcct = intercompanyduetoAcct;
    }

    public CValidcombination getSuspenseerrorAcct() {
        return suspenseerrorAcct;
    }

    public void setSuspenseerrorAcct(CValidcombination suspenseerrorAcct) {
        this.suspenseerrorAcct = suspenseerrorAcct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cAcctschemaGlId != null ? cAcctschemaGlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CAcctschemaGl)) {
            return false;
        }
        CAcctschemaGl other = (CAcctschemaGl) object;
        if ((this.cAcctschemaGlId == null && other.cAcctschemaGlId != null) || (this.cAcctschemaGlId != null && !this.cAcctschemaGlId.equals(other.cAcctschemaGlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CAcctschemaGl[ cAcctschemaGlId=" + cAcctschemaGlId + " ]";
    }
    
}
