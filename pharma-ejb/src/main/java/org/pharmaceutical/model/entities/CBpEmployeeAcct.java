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
@Table(name = "c_bp_employee_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBpEmployeeAcct.findAll", query = "SELECT c FROM CBpEmployeeAcct c"),
    @NamedQuery(name = "CBpEmployeeAcct.findByCBpEmployeeAcctId", query = "SELECT c FROM CBpEmployeeAcct c WHERE c.cBpEmployeeAcctId = :cBpEmployeeAcctId"),
    @NamedQuery(name = "CBpEmployeeAcct.findByIsactive", query = "SELECT c FROM CBpEmployeeAcct c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBpEmployeeAcct.findByCreated", query = "SELECT c FROM CBpEmployeeAcct c WHERE c.created = :created"),
    @NamedQuery(name = "CBpEmployeeAcct.findByCreatedby", query = "SELECT c FROM CBpEmployeeAcct c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBpEmployeeAcct.findByUpdated", query = "SELECT c FROM CBpEmployeeAcct c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBpEmployeeAcct.findByUpdatedby", query = "SELECT c FROM CBpEmployeeAcct c WHERE c.updatedby = :updatedby")})
public class CBpEmployeeAcct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_bp_employee_acct_id")
    private String cBpEmployeeAcctId;
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
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "e_prepayment_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination ePrepaymentAcct;
    @JoinColumn(name = "e_expense_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination eExpenseAcct;

    public CBpEmployeeAcct() {
    }

    public CBpEmployeeAcct(String cBpEmployeeAcctId) {
        this.cBpEmployeeAcctId = cBpEmployeeAcctId;
    }

    public CBpEmployeeAcct(String cBpEmployeeAcctId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cBpEmployeeAcctId = cBpEmployeeAcctId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCBpEmployeeAcctId() {
        return cBpEmployeeAcctId;
    }

    public void setCBpEmployeeAcctId(String cBpEmployeeAcctId) {
        this.cBpEmployeeAcctId = cBpEmployeeAcctId;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CValidcombination getEPrepaymentAcct() {
        return ePrepaymentAcct;
    }

    public void setEPrepaymentAcct(CValidcombination ePrepaymentAcct) {
        this.ePrepaymentAcct = ePrepaymentAcct;
    }

    public CValidcombination getEExpenseAcct() {
        return eExpenseAcct;
    }

    public void setEExpenseAcct(CValidcombination eExpenseAcct) {
        this.eExpenseAcct = eExpenseAcct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBpEmployeeAcctId != null ? cBpEmployeeAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBpEmployeeAcct)) {
            return false;
        }
        CBpEmployeeAcct other = (CBpEmployeeAcct) object;
        if ((this.cBpEmployeeAcctId == null && other.cBpEmployeeAcctId != null) || (this.cBpEmployeeAcctId != null && !this.cBpEmployeeAcctId.equals(other.cBpEmployeeAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBpEmployeeAcct[ cBpEmployeeAcctId=" + cBpEmployeeAcctId + " ]";
    }
    
}
