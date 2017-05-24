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
@Table(name = "s_timeexpense")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "STimeexpense.findAll", query = "SELECT s FROM STimeexpense s"),
    @NamedQuery(name = "STimeexpense.findBySTimeexpenseId", query = "SELECT s FROM STimeexpense s WHERE s.sTimeexpenseId = :sTimeexpenseId"),
    @NamedQuery(name = "STimeexpense.findByIsactive", query = "SELECT s FROM STimeexpense s WHERE s.isactive = :isactive"),
    @NamedQuery(name = "STimeexpense.findByCreated", query = "SELECT s FROM STimeexpense s WHERE s.created = :created"),
    @NamedQuery(name = "STimeexpense.findByCreatedby", query = "SELECT s FROM STimeexpense s WHERE s.createdby = :createdby"),
    @NamedQuery(name = "STimeexpense.findByUpdated", query = "SELECT s FROM STimeexpense s WHERE s.updated = :updated"),
    @NamedQuery(name = "STimeexpense.findByUpdatedby", query = "SELECT s FROM STimeexpense s WHERE s.updatedby = :updatedby"),
    @NamedQuery(name = "STimeexpense.findByDocumentno", query = "SELECT s FROM STimeexpense s WHERE s.documentno = :documentno"),
    @NamedQuery(name = "STimeexpense.findByDatereport", query = "SELECT s FROM STimeexpense s WHERE s.datereport = :datereport"),
    @NamedQuery(name = "STimeexpense.findByDescription", query = "SELECT s FROM STimeexpense s WHERE s.description = :description"),
    @NamedQuery(name = "STimeexpense.findByProcessing", query = "SELECT s FROM STimeexpense s WHERE s.processing = :processing"),
    @NamedQuery(name = "STimeexpense.findByProcessed", query = "SELECT s FROM STimeexpense s WHERE s.processed = :processed")})
public class STimeexpense implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "s_timeexpense_id")
    private String sTimeexpenseId;
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
    @Size(min = 1, max = 30)
    @Column(name = "documentno")
    private String documentno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datereport")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datereport;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 60)
    @Column(name = "processing")
    private String processing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "sTimeexpenseId")
    private List<STimeexpenseline> sTimeexpenselineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "m_pricelist_id", referencedColumnName = "m_pricelist_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MPricelist mPricelistId;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MWarehouse mWarehouseId;

    public STimeexpense() {
    }

    public STimeexpense(String sTimeexpenseId) {
        this.sTimeexpenseId = sTimeexpenseId;
    }

    public STimeexpense(String sTimeexpenseId, Character isactive, Date created, String createdby, Date updated, String updatedby, String documentno, Date datereport, Character processed) {
        this.sTimeexpenseId = sTimeexpenseId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.documentno = documentno;
        this.datereport = datereport;
        this.processed = processed;
    }

    public String getSTimeexpenseId() {
        return sTimeexpenseId;
    }

    public void setSTimeexpenseId(String sTimeexpenseId) {
        this.sTimeexpenseId = sTimeexpenseId;
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

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public Date getDatereport() {
        return datereport;
    }

    public void setDatereport(Date datereport) {
        this.datereport = datereport;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    @XmlTransient
    public List<STimeexpenseline> getSTimeexpenselineList() {
        return sTimeexpenselineList;
    }

    public void setSTimeexpenselineList(List<STimeexpenseline> sTimeexpenselineList) {
        this.sTimeexpenselineList = sTimeexpenselineList;
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

    public MPricelist getMPricelistId() {
        return mPricelistId;
    }

    public void setMPricelistId(MPricelist mPricelistId) {
        this.mPricelistId = mPricelistId;
    }

    public MWarehouse getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(MWarehouse mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sTimeexpenseId != null ? sTimeexpenseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof STimeexpense)) {
            return false;
        }
        STimeexpense other = (STimeexpense) object;
        if ((this.sTimeexpenseId == null && other.sTimeexpenseId != null) || (this.sTimeexpenseId != null && !this.sTimeexpenseId.equals(other.sTimeexpenseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.STimeexpense[ sTimeexpenseId=" + sTimeexpenseId + " ]";
    }
    
}
