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
@Table(name = "c_project_vendor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CProjectVendor.findAll", query = "SELECT c FROM CProjectVendor c"),
    @NamedQuery(name = "CProjectVendor.findByCProjectVendorId", query = "SELECT c FROM CProjectVendor c WHERE c.cProjectVendorId = :cProjectVendorId"),
    @NamedQuery(name = "CProjectVendor.findByIsactive", query = "SELECT c FROM CProjectVendor c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CProjectVendor.findByCreated", query = "SELECT c FROM CProjectVendor c WHERE c.created = :created"),
    @NamedQuery(name = "CProjectVendor.findByCreatedby", query = "SELECT c FROM CProjectVendor c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CProjectVendor.findByUpdated", query = "SELECT c FROM CProjectVendor c WHERE c.updated = :updated"),
    @NamedQuery(name = "CProjectVendor.findByUpdatedby", query = "SELECT c FROM CProjectVendor c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CProjectVendor.findByNote", query = "SELECT c FROM CProjectVendor c WHERE c.note = :note"),
    @NamedQuery(name = "CProjectVendor.findByIncotermsDescription", query = "SELECT c FROM CProjectVendor c WHERE c.incotermsDescription = :incotermsDescription"),
    @NamedQuery(name = "CProjectVendor.findByGenerateorder", query = "SELECT c FROM CProjectVendor c WHERE c.generateorder = :generateorder")})
public class CProjectVendor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_project_vendor_id")
    private String cProjectVendorId;
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
    @Size(max = 2000)
    @Column(name = "note")
    private String note;
    @Size(max = 60)
    @Column(name = "incoterms_description")
    private String incotermsDescription;
    @Column(name = "generateorder")
    private Character generateorder;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_incoterms_id", referencedColumnName = "c_incoterms_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CIncoterms cIncotermsId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CProject cProjectId;
    @JoinColumn(name = "m_pricelist_id", referencedColumnName = "m_pricelist_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MPricelist mPricelistId;
    @JoinColumn(name = "m_pricelist_version_id", referencedColumnName = "m_pricelist_version_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MPricelistVersion mPricelistVersionId;

    public CProjectVendor() {
    }

    public CProjectVendor(String cProjectVendorId) {
        this.cProjectVendorId = cProjectVendorId;
    }

    public CProjectVendor(String cProjectVendorId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cProjectVendorId = cProjectVendorId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCProjectVendorId() {
        return cProjectVendorId;
    }

    public void setCProjectVendorId(String cProjectVendorId) {
        this.cProjectVendorId = cProjectVendorId;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getIncotermsDescription() {
        return incotermsDescription;
    }

    public void setIncotermsDescription(String incotermsDescription) {
        this.incotermsDescription = incotermsDescription;
    }

    public Character getGenerateorder() {
        return generateorder;
    }

    public void setGenerateorder(Character generateorder) {
        this.generateorder = generateorder;
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

    public CIncoterms getCIncotermsId() {
        return cIncotermsId;
    }

    public void setCIncotermsId(CIncoterms cIncotermsId) {
        this.cIncotermsId = cIncotermsId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public MPricelist getMPricelistId() {
        return mPricelistId;
    }

    public void setMPricelistId(MPricelist mPricelistId) {
        this.mPricelistId = mPricelistId;
    }

    public MPricelistVersion getMPricelistVersionId() {
        return mPricelistVersionId;
    }

    public void setMPricelistVersionId(MPricelistVersion mPricelistVersionId) {
        this.mPricelistVersionId = mPricelistVersionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cProjectVendorId != null ? cProjectVendorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProjectVendor)) {
            return false;
        }
        CProjectVendor other = (CProjectVendor) object;
        if ((this.cProjectVendorId == null && other.cProjectVendorId != null) || (this.cProjectVendorId != null && !this.cProjectVendorId.equals(other.cProjectVendorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CProjectVendor[ cProjectVendorId=" + cProjectVendorId + " ]";
    }
    
}
