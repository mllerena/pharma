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
@Table(name = "m_rappel_invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MRappelInvoice.findAll", query = "SELECT m FROM MRappelInvoice m"),
    @NamedQuery(name = "MRappelInvoice.findByMRappelInvoiceId", query = "SELECT m FROM MRappelInvoice m WHERE m.mRappelInvoiceId = :mRappelInvoiceId"),
    @NamedQuery(name = "MRappelInvoice.findByIsactive", query = "SELECT m FROM MRappelInvoice m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MRappelInvoice.findByCreated", query = "SELECT m FROM MRappelInvoice m WHERE m.created = :created"),
    @NamedQuery(name = "MRappelInvoice.findByCreatedby", query = "SELECT m FROM MRappelInvoice m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MRappelInvoice.findByUpdated", query = "SELECT m FROM MRappelInvoice m WHERE m.updated = :updated"),
    @NamedQuery(name = "MRappelInvoice.findByUpdatedby", query = "SELECT m FROM MRappelInvoice m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MRappelInvoice.findBySeqno", query = "SELECT m FROM MRappelInvoice m WHERE m.seqno = :seqno")})
public class MRappelInvoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_rappel_invoice_id")
    private String mRappelInvoiceId;
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
    @Column(name = "seqno")
    private Long seqno;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_invoice_id", referencedColumnName = "c_invoice_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoice cInvoiceId;
    @JoinColumn(name = "m_rappel_bpartner_id", referencedColumnName = "m_rappel_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MRappelBpartner mRappelBpartnerId;

    public MRappelInvoice() {
    }

    public MRappelInvoice(String mRappelInvoiceId) {
        this.mRappelInvoiceId = mRappelInvoiceId;
    }

    public MRappelInvoice(String mRappelInvoiceId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mRappelInvoiceId = mRappelInvoiceId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMRappelInvoiceId() {
        return mRappelInvoiceId;
    }

    public void setMRappelInvoiceId(String mRappelInvoiceId) {
        this.mRappelInvoiceId = mRappelInvoiceId;
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

    public Long getSeqno() {
        return seqno;
    }

    public void setSeqno(Long seqno) {
        this.seqno = seqno;
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

    public CInvoice getCInvoiceId() {
        return cInvoiceId;
    }

    public void setCInvoiceId(CInvoice cInvoiceId) {
        this.cInvoiceId = cInvoiceId;
    }

    public MRappelBpartner getMRappelBpartnerId() {
        return mRappelBpartnerId;
    }

    public void setMRappelBpartnerId(MRappelBpartner mRappelBpartnerId) {
        this.mRappelBpartnerId = mRappelBpartnerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mRappelInvoiceId != null ? mRappelInvoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MRappelInvoice)) {
            return false;
        }
        MRappelInvoice other = (MRappelInvoice) object;
        if ((this.mRappelInvoiceId == null && other.mRappelInvoiceId != null) || (this.mRappelInvoiceId != null && !this.mRappelInvoiceId.equals(other.mRappelInvoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MRappelInvoice[ mRappelInvoiceId=" + mRappelInvoiceId + " ]";
    }
    
}
