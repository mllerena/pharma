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
@Table(name = "c_dp_managementline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CDpManagementline.findAll", query = "SELECT c FROM CDpManagementline c"),
    @NamedQuery(name = "CDpManagementline.findByCDpManagementlineId", query = "SELECT c FROM CDpManagementline c WHERE c.cDpManagementlineId = :cDpManagementlineId"),
    @NamedQuery(name = "CDpManagementline.findByIsactive", query = "SELECT c FROM CDpManagementline c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CDpManagementline.findByCreated", query = "SELECT c FROM CDpManagementline c WHERE c.created = :created"),
    @NamedQuery(name = "CDpManagementline.findByCreatedby", query = "SELECT c FROM CDpManagementline c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CDpManagementline.findByUpdated", query = "SELECT c FROM CDpManagementline c WHERE c.updated = :updated"),
    @NamedQuery(name = "CDpManagementline.findByUpdatedby", query = "SELECT c FROM CDpManagementline c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CDpManagementline.findByStatusFrom", query = "SELECT c FROM CDpManagementline c WHERE c.statusFrom = :statusFrom"),
    @NamedQuery(name = "CDpManagementline.findByStatusTo", query = "SELECT c FROM CDpManagementline c WHERE c.statusTo = :statusTo"),
    @NamedQuery(name = "CDpManagementline.findByLine", query = "SELECT c FROM CDpManagementline c WHERE c.line = :line")})
public class CDpManagementline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_dp_managementline_id")
    private String cDpManagementlineId;
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
    @Column(name = "status_from")
    private String statusFrom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "status_to")
    private String statusTo;
    @Column(name = "line")
    private BigInteger line;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_debt_payment_id", referencedColumnName = "c_debt_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDebtPayment cDebtPaymentId;
    @JoinColumn(name = "c_dp_management_id", referencedColumnName = "c_dp_management_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDpManagement cDpManagementId;

    public CDpManagementline() {
    }

    public CDpManagementline(String cDpManagementlineId) {
        this.cDpManagementlineId = cDpManagementlineId;
    }

    public CDpManagementline(String cDpManagementlineId, Character isactive, Date created, String createdby, Date updated, String updatedby, String statusFrom, String statusTo) {
        this.cDpManagementlineId = cDpManagementlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.statusFrom = statusFrom;
        this.statusTo = statusTo;
    }

    public String getCDpManagementlineId() {
        return cDpManagementlineId;
    }

    public void setCDpManagementlineId(String cDpManagementlineId) {
        this.cDpManagementlineId = cDpManagementlineId;
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

    public String getStatusFrom() {
        return statusFrom;
    }

    public void setStatusFrom(String statusFrom) {
        this.statusFrom = statusFrom;
    }

    public String getStatusTo() {
        return statusTo;
    }

    public void setStatusTo(String statusTo) {
        this.statusTo = statusTo;
    }

    public BigInteger getLine() {
        return line;
    }

    public void setLine(BigInteger line) {
        this.line = line;
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

    public CDpManagement getCDpManagementId() {
        return cDpManagementId;
    }

    public void setCDpManagementId(CDpManagement cDpManagementId) {
        this.cDpManagementId = cDpManagementId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cDpManagementlineId != null ? cDpManagementlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CDpManagementline)) {
            return false;
        }
        CDpManagementline other = (CDpManagementline) object;
        if ((this.cDpManagementlineId == null && other.cDpManagementlineId != null) || (this.cDpManagementlineId != null && !this.cDpManagementlineId.equals(other.cDpManagementlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CDpManagementline[ cDpManagementlineId=" + cDpManagementlineId + " ]";
    }
    
}
