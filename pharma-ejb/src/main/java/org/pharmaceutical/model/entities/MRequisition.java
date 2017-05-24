/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "m_requisition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MRequisition.findAll", query = "SELECT m FROM MRequisition m"),
    @NamedQuery(name = "MRequisition.findByMRequisitionId", query = "SELECT m FROM MRequisition m WHERE m.mRequisitionId = :mRequisitionId"),
    @NamedQuery(name = "MRequisition.findByIsactive", query = "SELECT m FROM MRequisition m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MRequisition.findByCreated", query = "SELECT m FROM MRequisition m WHERE m.created = :created"),
    @NamedQuery(name = "MRequisition.findByCreatedby", query = "SELECT m FROM MRequisition m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MRequisition.findByUpdated", query = "SELECT m FROM MRequisition m WHERE m.updated = :updated"),
    @NamedQuery(name = "MRequisition.findByUpdatedby", query = "SELECT m FROM MRequisition m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MRequisition.findByDescription", query = "SELECT m FROM MRequisition m WHERE m.description = :description"),
    @NamedQuery(name = "MRequisition.findByDocumentno", query = "SELECT m FROM MRequisition m WHERE m.documentno = :documentno"),
    @NamedQuery(name = "MRequisition.findByCreatepo", query = "SELECT m FROM MRequisition m WHERE m.createpo = :createpo"),
    @NamedQuery(name = "MRequisition.findByDocstatus", query = "SELECT m FROM MRequisition m WHERE m.docstatus = :docstatus"),
    @NamedQuery(name = "MRequisition.findByDocaction", query = "SELECT m FROM MRequisition m WHERE m.docaction = :docaction"),
    @NamedQuery(name = "MRequisition.findByProcessed", query = "SELECT m FROM MRequisition m WHERE m.processed = :processed"),
    @NamedQuery(name = "MRequisition.findByProcessing", query = "SELECT m FROM MRequisition m WHERE m.processing = :processing")})
public class MRequisition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_requisition_id")
    private String mRequisitionId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "documentno")
    private String documentno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createpo")
    private Character createpo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "docstatus")
    private String docstatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "docaction")
    private String docaction;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processing")
    private Character processing;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mRequisitionId")
    private List<MRequisitionline> mRequisitionlineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdUser adUserId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "m_pricelist_id", referencedColumnName = "m_pricelist_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MPricelist mPricelistId;

    public MRequisition() {
    }

    public MRequisition(String mRequisitionId) {
        this.mRequisitionId = mRequisitionId;
    }

    public MRequisition(String mRequisitionId, Character isactive, Date created, String createdby, Date updated, String updatedby, String documentno, Character createpo, String docstatus, String docaction, Character processed, Character processing) {
        this.mRequisitionId = mRequisitionId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.documentno = documentno;
        this.createpo = createpo;
        this.docstatus = docstatus;
        this.docaction = docaction;
        this.processed = processed;
        this.processing = processing;
    }

    public String getMRequisitionId() {
        return mRequisitionId;
    }

    public void setMRequisitionId(String mRequisitionId) {
        this.mRequisitionId = mRequisitionId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public Character getCreatepo() {
        return createpo;
    }

    public void setCreatepo(Character createpo) {
        this.createpo = createpo;
    }

    public String getDocstatus() {
        return docstatus;
    }

    public void setDocstatus(String docstatus) {
        this.docstatus = docstatus;
    }

    public String getDocaction() {
        return docaction;
    }

    public void setDocaction(String docaction) {
        this.docaction = docaction;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    @XmlTransient
    public List<MRequisitionline> getMRequisitionlineList() {
        return mRequisitionlineList;
    }

    public void setMRequisitionlineList(List<MRequisitionline> mRequisitionlineList) {
        this.mRequisitionlineList = mRequisitionlineList;
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

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public MPricelist getMPricelistId() {
        return mPricelistId;
    }

    public void setMPricelistId(MPricelist mPricelistId) {
        this.mPricelistId = mPricelistId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mRequisitionId != null ? mRequisitionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MRequisition)) {
            return false;
        }
        MRequisition other = (MRequisition) object;
        if ((this.mRequisitionId == null && other.mRequisitionId != null) || (this.mRequisitionId != null && !this.mRequisitionId.equals(other.mRequisitionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MRequisition[ mRequisitionId=" + mRequisitionId + " ]";
    }
    
}
