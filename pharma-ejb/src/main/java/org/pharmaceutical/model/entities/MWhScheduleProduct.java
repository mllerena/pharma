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
@Table(name = "m_wh_schedule_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MWhScheduleProduct.findAll", query = "SELECT m FROM MWhScheduleProduct m"),
    @NamedQuery(name = "MWhScheduleProduct.findByMWhScheduleProductId", query = "SELECT m FROM MWhScheduleProduct m WHERE m.mWhScheduleProductId = :mWhScheduleProductId"),
    @NamedQuery(name = "MWhScheduleProduct.findByIsactive", query = "SELECT m FROM MWhScheduleProduct m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MWhScheduleProduct.findByCreated", query = "SELECT m FROM MWhScheduleProduct m WHERE m.created = :created"),
    @NamedQuery(name = "MWhScheduleProduct.findByCreatedby", query = "SELECT m FROM MWhScheduleProduct m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MWhScheduleProduct.findByUpdated", query = "SELECT m FROM MWhScheduleProduct m WHERE m.updated = :updated"),
    @NamedQuery(name = "MWhScheduleProduct.findByUpdatedby", query = "SELECT m FROM MWhScheduleProduct m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MWhScheduleProduct.findByInvoicingtype", query = "SELECT m FROM MWhScheduleProduct m WHERE m.invoicingtype = :invoicingtype")})
public class MWhScheduleProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_wh_schedule_product_id")
    private String mWhScheduleProductId;
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
    @Size(max = 60)
    @Column(name = "invoicingtype")
    private String invoicingtype;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "m_wh_schedule_id", referencedColumnName = "m_wh_schedule_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MWhSchedule mWhScheduleId;

    public MWhScheduleProduct() {
    }

    public MWhScheduleProduct(String mWhScheduleProductId) {
        this.mWhScheduleProductId = mWhScheduleProductId;
    }

    public MWhScheduleProduct(String mWhScheduleProductId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mWhScheduleProductId = mWhScheduleProductId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMWhScheduleProductId() {
        return mWhScheduleProductId;
    }

    public void setMWhScheduleProductId(String mWhScheduleProductId) {
        this.mWhScheduleProductId = mWhScheduleProductId;
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

    public String getInvoicingtype() {
        return invoicingtype;
    }

    public void setInvoicingtype(String invoicingtype) {
        this.invoicingtype = invoicingtype;
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

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public MWhSchedule getMWhScheduleId() {
        return mWhScheduleId;
    }

    public void setMWhScheduleId(MWhSchedule mWhScheduleId) {
        this.mWhScheduleId = mWhScheduleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mWhScheduleProductId != null ? mWhScheduleProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MWhScheduleProduct)) {
            return false;
        }
        MWhScheduleProduct other = (MWhScheduleProduct) object;
        if ((this.mWhScheduleProductId == null && other.mWhScheduleProductId != null) || (this.mWhScheduleProductId != null && !this.mWhScheduleProductId.equals(other.mWhScheduleProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MWhScheduleProduct[ mWhScheduleProductId=" + mWhScheduleProductId + " ]";
    }
    
}
