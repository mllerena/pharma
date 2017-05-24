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
@Table(name = "c_glitem_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CGlitemAcct.findAll", query = "SELECT c FROM CGlitemAcct c"),
    @NamedQuery(name = "CGlitemAcct.findByCGlitemAcctId", query = "SELECT c FROM CGlitemAcct c WHERE c.cGlitemAcctId = :cGlitemAcctId"),
    @NamedQuery(name = "CGlitemAcct.findByIsactive", query = "SELECT c FROM CGlitemAcct c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CGlitemAcct.findByCreated", query = "SELECT c FROM CGlitemAcct c WHERE c.created = :created"),
    @NamedQuery(name = "CGlitemAcct.findByCreatedby", query = "SELECT c FROM CGlitemAcct c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CGlitemAcct.findByUpdated", query = "SELECT c FROM CGlitemAcct c WHERE c.updated = :updated"),
    @NamedQuery(name = "CGlitemAcct.findByUpdatedby", query = "SELECT c FROM CGlitemAcct c WHERE c.updatedby = :updatedby")})
public class CGlitemAcct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_glitem_acct_id")
    private String cGlitemAcctId;
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
    @JoinColumn(name = "c_glitem_id", referencedColumnName = "c_glitem_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CGlitem cGlitemId;
    @JoinColumn(name = "glitem_debit_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination glitemDebitAcct;
    @JoinColumn(name = "glitem_credit_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination glitemCreditAcct;

    public CGlitemAcct() {
    }

    public CGlitemAcct(String cGlitemAcctId) {
        this.cGlitemAcctId = cGlitemAcctId;
    }

    public CGlitemAcct(String cGlitemAcctId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cGlitemAcctId = cGlitemAcctId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCGlitemAcctId() {
        return cGlitemAcctId;
    }

    public void setCGlitemAcctId(String cGlitemAcctId) {
        this.cGlitemAcctId = cGlitemAcctId;
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

    public CGlitem getCGlitemId() {
        return cGlitemId;
    }

    public void setCGlitemId(CGlitem cGlitemId) {
        this.cGlitemId = cGlitemId;
    }

    public CValidcombination getGlitemDebitAcct() {
        return glitemDebitAcct;
    }

    public void setGlitemDebitAcct(CValidcombination glitemDebitAcct) {
        this.glitemDebitAcct = glitemDebitAcct;
    }

    public CValidcombination getGlitemCreditAcct() {
        return glitemCreditAcct;
    }

    public void setGlitemCreditAcct(CValidcombination glitemCreditAcct) {
        this.glitemCreditAcct = glitemCreditAcct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cGlitemAcctId != null ? cGlitemAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CGlitemAcct)) {
            return false;
        }
        CGlitemAcct other = (CGlitemAcct) object;
        if ((this.cGlitemAcctId == null && other.cGlitemAcctId != null) || (this.cGlitemAcctId != null && !this.cGlitemAcctId.equals(other.cGlitemAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CGlitemAcct[ cGlitemAcctId=" + cGlitemAcctId + " ]";
    }
    
}
