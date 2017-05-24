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
@Table(name = "m_matchpo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MMatchpo.findAll", query = "SELECT m FROM MMatchpo m"),
    @NamedQuery(name = "MMatchpo.findByMMatchpoId", query = "SELECT m FROM MMatchpo m WHERE m.mMatchpoId = :mMatchpoId"),
    @NamedQuery(name = "MMatchpo.findByIsactive", query = "SELECT m FROM MMatchpo m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MMatchpo.findByCreated", query = "SELECT m FROM MMatchpo m WHERE m.created = :created"),
    @NamedQuery(name = "MMatchpo.findByCreatedby", query = "SELECT m FROM MMatchpo m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MMatchpo.findByUpdated", query = "SELECT m FROM MMatchpo m WHERE m.updated = :updated"),
    @NamedQuery(name = "MMatchpo.findByUpdatedby", query = "SELECT m FROM MMatchpo m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MMatchpo.findByDatetrx", query = "SELECT m FROM MMatchpo m WHERE m.datetrx = :datetrx"),
    @NamedQuery(name = "MMatchpo.findByQty", query = "SELECT m FROM MMatchpo m WHERE m.qty = :qty"),
    @NamedQuery(name = "MMatchpo.findByProcessing", query = "SELECT m FROM MMatchpo m WHERE m.processing = :processing"),
    @NamedQuery(name = "MMatchpo.findByProcessed", query = "SELECT m FROM MMatchpo m WHERE m.processed = :processed"),
    @NamedQuery(name = "MMatchpo.findByPosted", query = "SELECT m FROM MMatchpo m WHERE m.posted = :posted")})
public class MMatchpo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_matchpo_id")
    private String mMatchpoId;
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
    @Column(name = "datetrx")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetrx;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private BigInteger qty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processing")
    private Character processing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "posted")
    private String posted;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_invoiceline_id", referencedColumnName = "c_invoiceline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoiceline cInvoicelineId;
    @JoinColumn(name = "c_orderline_id", referencedColumnName = "c_orderline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private COrderline cOrderlineId;
    @JoinColumn(name = "m_inoutline_id", referencedColumnName = "m_inoutline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MInoutline mInoutlineId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;

    public MMatchpo() {
    }

    public MMatchpo(String mMatchpoId) {
        this.mMatchpoId = mMatchpoId;
    }

    public MMatchpo(String mMatchpoId, Character isactive, Date created, String createdby, Date updated, String updatedby, Date datetrx, BigInteger qty, Character processing, Character processed, String posted) {
        this.mMatchpoId = mMatchpoId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.datetrx = datetrx;
        this.qty = qty;
        this.processing = processing;
        this.processed = processed;
        this.posted = posted;
    }

    public String getMMatchpoId() {
        return mMatchpoId;
    }

    public void setMMatchpoId(String mMatchpoId) {
        this.mMatchpoId = mMatchpoId;
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

    public Date getDatetrx() {
        return datetrx;
    }

    public void setDatetrx(Date datetrx) {
        this.datetrx = datetrx;
    }

    public BigInteger getQty() {
        return qty;
    }

    public void setQty(BigInteger qty) {
        this.qty = qty;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
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

    public CInvoiceline getCInvoicelineId() {
        return cInvoicelineId;
    }

    public void setCInvoicelineId(CInvoiceline cInvoicelineId) {
        this.cInvoicelineId = cInvoicelineId;
    }

    public COrderline getCOrderlineId() {
        return cOrderlineId;
    }

    public void setCOrderlineId(COrderline cOrderlineId) {
        this.cOrderlineId = cOrderlineId;
    }

    public MInoutline getMInoutlineId() {
        return mInoutlineId;
    }

    public void setMInoutlineId(MInoutline mInoutlineId) {
        this.mInoutlineId = mInoutlineId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mMatchpoId != null ? mMatchpoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MMatchpo)) {
            return false;
        }
        MMatchpo other = (MMatchpo) object;
        if ((this.mMatchpoId == null && other.mMatchpoId != null) || (this.mMatchpoId != null && !this.mMatchpoId.equals(other.mMatchpoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MMatchpo[ mMatchpoId=" + mMatchpoId + " ]";
    }
    
}
