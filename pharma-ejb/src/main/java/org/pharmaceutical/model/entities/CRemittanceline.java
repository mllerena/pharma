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
@Table(name = "c_remittanceline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CRemittanceline.findAll", query = "SELECT c FROM CRemittanceline c"),
    @NamedQuery(name = "CRemittanceline.findByCRemittancelineId", query = "SELECT c FROM CRemittanceline c WHERE c.cRemittancelineId = :cRemittancelineId"),
    @NamedQuery(name = "CRemittanceline.findByIsactive", query = "SELECT c FROM CRemittanceline c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CRemittanceline.findByCreated", query = "SELECT c FROM CRemittanceline c WHERE c.created = :created"),
    @NamedQuery(name = "CRemittanceline.findByCreatedby", query = "SELECT c FROM CRemittanceline c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CRemittanceline.findByUpdated", query = "SELECT c FROM CRemittanceline c WHERE c.updated = :updated"),
    @NamedQuery(name = "CRemittanceline.findByUpdatedby", query = "SELECT c FROM CRemittanceline c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CRemittanceline.findByLine", query = "SELECT c FROM CRemittanceline c WHERE c.line = :line"),
    @NamedQuery(name = "CRemittanceline.findByReturned", query = "SELECT c FROM CRemittanceline c WHERE c.returned = :returned")})
public class CRemittanceline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_remittanceline_id")
    private String cRemittancelineId;
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
    @Column(name = "line")
    private Long line;
    @Column(name = "returned")
    private Character returned;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_debt_payment_id", referencedColumnName = "c_debt_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDebtPayment cDebtPaymentId;
    @JoinColumn(name = "c_debt_payment_cancelled", referencedColumnName = "c_debt_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDebtPayment cDebtPaymentCancelled;
    @JoinColumn(name = "c_remittance_id", referencedColumnName = "c_remittance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CRemittance cRemittanceId;

    public CRemittanceline() {
    }

    public CRemittanceline(String cRemittancelineId) {
        this.cRemittancelineId = cRemittancelineId;
    }

    public CRemittanceline(String cRemittancelineId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cRemittancelineId = cRemittancelineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCRemittancelineId() {
        return cRemittancelineId;
    }

    public void setCRemittancelineId(String cRemittancelineId) {
        this.cRemittancelineId = cRemittancelineId;
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

    public Long getLine() {
        return line;
    }

    public void setLine(Long line) {
        this.line = line;
    }

    public Character getReturned() {
        return returned;
    }

    public void setReturned(Character returned) {
        this.returned = returned;
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

    public CDebtPayment getCDebtPaymentId() {
        return cDebtPaymentId;
    }

    public void setCDebtPaymentId(CDebtPayment cDebtPaymentId) {
        this.cDebtPaymentId = cDebtPaymentId;
    }

    public CDebtPayment getCDebtPaymentCancelled() {
        return cDebtPaymentCancelled;
    }

    public void setCDebtPaymentCancelled(CDebtPayment cDebtPaymentCancelled) {
        this.cDebtPaymentCancelled = cDebtPaymentCancelled;
    }

    public CRemittance getCRemittanceId() {
        return cRemittanceId;
    }

    public void setCRemittanceId(CRemittance cRemittanceId) {
        this.cRemittanceId = cRemittanceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cRemittancelineId != null ? cRemittancelineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRemittanceline)) {
            return false;
        }
        CRemittanceline other = (CRemittanceline) object;
        if ((this.cRemittancelineId == null && other.cRemittancelineId != null) || (this.cRemittancelineId != null && !this.cRemittancelineId.equals(other.cRemittancelineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CRemittanceline[ cRemittancelineId=" + cRemittancelineId + " ]";
    }
    
}
