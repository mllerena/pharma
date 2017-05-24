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
@Table(name = "c_bp_customer_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBpCustomerAcct.findAll", query = "SELECT c FROM CBpCustomerAcct c"),
    @NamedQuery(name = "CBpCustomerAcct.findByIsactive", query = "SELECT c FROM CBpCustomerAcct c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBpCustomerAcct.findByCreated", query = "SELECT c FROM CBpCustomerAcct c WHERE c.created = :created"),
    @NamedQuery(name = "CBpCustomerAcct.findByCreatedby", query = "SELECT c FROM CBpCustomerAcct c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBpCustomerAcct.findByUpdated", query = "SELECT c FROM CBpCustomerAcct c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBpCustomerAcct.findByUpdatedby", query = "SELECT c FROM CBpCustomerAcct c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBpCustomerAcct.findByCBpCustomerAcctId", query = "SELECT c FROM CBpCustomerAcct c WHERE c.cBpCustomerAcctId = :cBpCustomerAcctId"),
    @NamedQuery(name = "CBpCustomerAcct.findByStatus", query = "SELECT c FROM CBpCustomerAcct c WHERE c.status = :status")})
public class CBpCustomerAcct implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_bp_customer_acct_id")
    private String cBpCustomerAcctId;
    @Size(max = 60)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_receivable_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination cReceivableAcct;
    @JoinColumn(name = "c_prepayment_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination cPrepaymentAcct;

    public CBpCustomerAcct() {
    }

    public CBpCustomerAcct(String cBpCustomerAcctId) {
        this.cBpCustomerAcctId = cBpCustomerAcctId;
    }

    public CBpCustomerAcct(String cBpCustomerAcctId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cBpCustomerAcctId = cBpCustomerAcctId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
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

    public String getCBpCustomerAcctId() {
        return cBpCustomerAcctId;
    }

    public void setCBpCustomerAcctId(String cBpCustomerAcctId) {
        this.cBpCustomerAcctId = cBpCustomerAcctId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CValidcombination getCReceivableAcct() {
        return cReceivableAcct;
    }

    public void setCReceivableAcct(CValidcombination cReceivableAcct) {
        this.cReceivableAcct = cReceivableAcct;
    }

    public CValidcombination getCPrepaymentAcct() {
        return cPrepaymentAcct;
    }

    public void setCPrepaymentAcct(CValidcombination cPrepaymentAcct) {
        this.cPrepaymentAcct = cPrepaymentAcct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBpCustomerAcctId != null ? cBpCustomerAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBpCustomerAcct)) {
            return false;
        }
        CBpCustomerAcct other = (CBpCustomerAcct) object;
        if ((this.cBpCustomerAcctId == null && other.cBpCustomerAcctId != null) || (this.cBpCustomerAcctId != null && !this.cBpCustomerAcctId.equals(other.cBpCustomerAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBpCustomerAcct[ cBpCustomerAcctId=" + cBpCustomerAcctId + " ]";
    }
    
}
