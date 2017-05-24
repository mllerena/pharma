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
@Table(name = "m_wh_period_invoiced")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MWhPeriodInvoiced.findAll", query = "SELECT m FROM MWhPeriodInvoiced m"),
    @NamedQuery(name = "MWhPeriodInvoiced.findByMWhPeriodInvoicedId", query = "SELECT m FROM MWhPeriodInvoiced m WHERE m.mWhPeriodInvoicedId = :mWhPeriodInvoicedId"),
    @NamedQuery(name = "MWhPeriodInvoiced.findByIsactive", query = "SELECT m FROM MWhPeriodInvoiced m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MWhPeriodInvoiced.findByCreated", query = "SELECT m FROM MWhPeriodInvoiced m WHERE m.created = :created"),
    @NamedQuery(name = "MWhPeriodInvoiced.findByCreatedby", query = "SELECT m FROM MWhPeriodInvoiced m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MWhPeriodInvoiced.findByUpdated", query = "SELECT m FROM MWhPeriodInvoiced m WHERE m.updated = :updated"),
    @NamedQuery(name = "MWhPeriodInvoiced.findByUpdatedby", query = "SELECT m FROM MWhPeriodInvoiced m WHERE m.updatedby = :updatedby")})
public class MWhPeriodInvoiced implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_wh_period_invoiced_id")
    private String mWhPeriodInvoicedId;
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
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_order_id", referencedColumnName = "c_order_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrder cOrderId;
    @JoinColumn(name = "m_wh_period_id", referencedColumnName = "m_wh_period_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MWhPeriod mWhPeriodId;

    public MWhPeriodInvoiced() {
    }

    public MWhPeriodInvoiced(String mWhPeriodInvoicedId) {
        this.mWhPeriodInvoicedId = mWhPeriodInvoicedId;
    }

    public MWhPeriodInvoiced(String mWhPeriodInvoicedId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mWhPeriodInvoicedId = mWhPeriodInvoicedId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMWhPeriodInvoicedId() {
        return mWhPeriodInvoicedId;
    }

    public void setMWhPeriodInvoicedId(String mWhPeriodInvoicedId) {
        this.mWhPeriodInvoicedId = mWhPeriodInvoicedId;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public COrder getCOrderId() {
        return cOrderId;
    }

    public void setCOrderId(COrder cOrderId) {
        this.cOrderId = cOrderId;
    }

    public MWhPeriod getMWhPeriodId() {
        return mWhPeriodId;
    }

    public void setMWhPeriodId(MWhPeriod mWhPeriodId) {
        this.mWhPeriodId = mWhPeriodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mWhPeriodInvoicedId != null ? mWhPeriodInvoicedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MWhPeriodInvoiced)) {
            return false;
        }
        MWhPeriodInvoiced other = (MWhPeriodInvoiced) object;
        if ((this.mWhPeriodInvoicedId == null && other.mWhPeriodInvoicedId != null) || (this.mWhPeriodInvoicedId != null && !this.mWhPeriodInvoicedId.equals(other.mWhPeriodInvoicedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MWhPeriodInvoiced[ mWhPeriodInvoicedId=" + mWhPeriodInvoicedId + " ]";
    }
    
}
