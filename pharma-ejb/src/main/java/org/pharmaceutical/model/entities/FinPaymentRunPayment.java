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
@Table(name = "fin_payment_run_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinPaymentRunPayment.findAll", query = "SELECT f FROM FinPaymentRunPayment f"),
    @NamedQuery(name = "FinPaymentRunPayment.findByFinPaymentRunPaymentId", query = "SELECT f FROM FinPaymentRunPayment f WHERE f.finPaymentRunPaymentId = :finPaymentRunPaymentId"),
    @NamedQuery(name = "FinPaymentRunPayment.findByCreated", query = "SELECT f FROM FinPaymentRunPayment f WHERE f.created = :created"),
    @NamedQuery(name = "FinPaymentRunPayment.findByCreatedby", query = "SELECT f FROM FinPaymentRunPayment f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinPaymentRunPayment.findByUpdated", query = "SELECT f FROM FinPaymentRunPayment f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinPaymentRunPayment.findByUpdatedby", query = "SELECT f FROM FinPaymentRunPayment f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinPaymentRunPayment.findByIsactive", query = "SELECT f FROM FinPaymentRunPayment f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinPaymentRunPayment.findByResult", query = "SELECT f FROM FinPaymentRunPayment f WHERE f.result = :result"),
    @NamedQuery(name = "FinPaymentRunPayment.findByMessage", query = "SELECT f FROM FinPaymentRunPayment f WHERE f.message = :message")})
public class FinPaymentRunPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_payment_run_payment_id")
    private String finPaymentRunPaymentId;
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
    @Column(name = "isactive")
    private Character isactive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "result")
    private String result;
    @Size(max = 2000)
    @Column(name = "message")
    private String message;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "fin_payment_id", referencedColumnName = "fin_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinPayment finPaymentId;
    @JoinColumn(name = "fin_payment_run_id", referencedColumnName = "fin_payment_run_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private FinPaymentRun finPaymentRunId;

    public FinPaymentRunPayment() {
    }

    public FinPaymentRunPayment(String finPaymentRunPaymentId) {
        this.finPaymentRunPaymentId = finPaymentRunPaymentId;
    }

    public FinPaymentRunPayment(String finPaymentRunPaymentId, Date created, String createdby, Date updated, String updatedby, Character isactive, String result) {
        this.finPaymentRunPaymentId = finPaymentRunPaymentId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isactive = isactive;
        this.result = result;
    }

    public String getFinPaymentRunPaymentId() {
        return finPaymentRunPaymentId;
    }

    public void setFinPaymentRunPaymentId(String finPaymentRunPaymentId) {
        this.finPaymentRunPaymentId = finPaymentRunPaymentId;
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

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public FinPayment getFinPaymentId() {
        return finPaymentId;
    }

    public void setFinPaymentId(FinPayment finPaymentId) {
        this.finPaymentId = finPaymentId;
    }

    public FinPaymentRun getFinPaymentRunId() {
        return finPaymentRunId;
    }

    public void setFinPaymentRunId(FinPaymentRun finPaymentRunId) {
        this.finPaymentRunId = finPaymentRunId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finPaymentRunPaymentId != null ? finPaymentRunPaymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinPaymentRunPayment)) {
            return false;
        }
        FinPaymentRunPayment other = (FinPaymentRunPayment) object;
        if ((this.finPaymentRunPaymentId == null && other.finPaymentRunPaymentId != null) || (this.finPaymentRunPaymentId != null && !this.finPaymentRunPaymentId.equals(other.finPaymentRunPaymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinPaymentRunPayment[ finPaymentRunPaymentId=" + finPaymentRunPaymentId + " ]";
    }
    
}
