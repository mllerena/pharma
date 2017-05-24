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
@Table(name = "c_bp_vendor_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBpVendorAcct.findAll", query = "SELECT c FROM CBpVendorAcct c"),
    @NamedQuery(name = "CBpVendorAcct.findByIsactive", query = "SELECT c FROM CBpVendorAcct c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBpVendorAcct.findByCreated", query = "SELECT c FROM CBpVendorAcct c WHERE c.created = :created"),
    @NamedQuery(name = "CBpVendorAcct.findByCreatedby", query = "SELECT c FROM CBpVendorAcct c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBpVendorAcct.findByUpdated", query = "SELECT c FROM CBpVendorAcct c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBpVendorAcct.findByUpdatedby", query = "SELECT c FROM CBpVendorAcct c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBpVendorAcct.findByCBpVendorAcctId", query = "SELECT c FROM CBpVendorAcct c WHERE c.cBpVendorAcctId = :cBpVendorAcctId"),
    @NamedQuery(name = "CBpVendorAcct.findByStatus", query = "SELECT c FROM CBpVendorAcct c WHERE c.status = :status")})
public class CBpVendorAcct implements Serializable {
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
    @Column(name = "c_bp_vendor_acct_id")
    private String cBpVendorAcctId;
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
    @JoinColumn(name = "v_liability_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination vLiabilityAcct;
    @JoinColumn(name = "v_prepayment_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination vPrepaymentAcct;
    @JoinColumn(name = "v_liability_services_acct", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination vLiabilityServicesAcct;

    public CBpVendorAcct() {
    }

    public CBpVendorAcct(String cBpVendorAcctId) {
        this.cBpVendorAcctId = cBpVendorAcctId;
    }

    public CBpVendorAcct(String cBpVendorAcctId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cBpVendorAcctId = cBpVendorAcctId;
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

    public String getCBpVendorAcctId() {
        return cBpVendorAcctId;
    }

    public void setCBpVendorAcctId(String cBpVendorAcctId) {
        this.cBpVendorAcctId = cBpVendorAcctId;
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

    public CValidcombination getVLiabilityAcct() {
        return vLiabilityAcct;
    }

    public void setVLiabilityAcct(CValidcombination vLiabilityAcct) {
        this.vLiabilityAcct = vLiabilityAcct;
    }

    public CValidcombination getVPrepaymentAcct() {
        return vPrepaymentAcct;
    }

    public void setVPrepaymentAcct(CValidcombination vPrepaymentAcct) {
        this.vPrepaymentAcct = vPrepaymentAcct;
    }

    public CValidcombination getVLiabilityServicesAcct() {
        return vLiabilityServicesAcct;
    }

    public void setVLiabilityServicesAcct(CValidcombination vLiabilityServicesAcct) {
        this.vLiabilityServicesAcct = vLiabilityServicesAcct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBpVendorAcctId != null ? cBpVendorAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBpVendorAcct)) {
            return false;
        }
        CBpVendorAcct other = (CBpVendorAcct) object;
        if ((this.cBpVendorAcctId == null && other.cBpVendorAcctId != null) || (this.cBpVendorAcctId != null && !this.cBpVendorAcctId.equals(other.cBpVendorAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBpVendorAcct[ cBpVendorAcctId=" + cBpVendorAcctId + " ]";
    }
    
}
