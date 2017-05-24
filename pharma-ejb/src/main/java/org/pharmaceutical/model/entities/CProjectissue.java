/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "c_projectissue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CProjectissue.findAll", query = "SELECT c FROM CProjectissue c"),
    @NamedQuery(name = "CProjectissue.findByCProjectissueId", query = "SELECT c FROM CProjectissue c WHERE c.cProjectissueId = :cProjectissueId"),
    @NamedQuery(name = "CProjectissue.findByIsactive", query = "SELECT c FROM CProjectissue c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CProjectissue.findByCreated", query = "SELECT c FROM CProjectissue c WHERE c.created = :created"),
    @NamedQuery(name = "CProjectissue.findByCreatedby", query = "SELECT c FROM CProjectissue c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CProjectissue.findByUpdated", query = "SELECT c FROM CProjectissue c WHERE c.updated = :updated"),
    @NamedQuery(name = "CProjectissue.findByUpdatedby", query = "SELECT c FROM CProjectissue c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CProjectissue.findByLine", query = "SELECT c FROM CProjectissue c WHERE c.line = :line"),
    @NamedQuery(name = "CProjectissue.findByMovementqty", query = "SELECT c FROM CProjectissue c WHERE c.movementqty = :movementqty"),
    @NamedQuery(name = "CProjectissue.findByDescription", query = "SELECT c FROM CProjectissue c WHERE c.description = :description"),
    @NamedQuery(name = "CProjectissue.findByProcessed", query = "SELECT c FROM CProjectissue c WHERE c.processed = :processed"),
    @NamedQuery(name = "CProjectissue.findByPosted", query = "SELECT c FROM CProjectissue c WHERE c.posted = :posted"),
    @NamedQuery(name = "CProjectissue.findByMovementdate", query = "SELECT c FROM CProjectissue c WHERE c.movementdate = :movementdate")})
public class CProjectissue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_projectissue_id")
    private String cProjectissueId;
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
    @Column(name = "line")
    private long line;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movementqty")
    private BigInteger movementqty;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "posted")
    private String posted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movementdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movementdate;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CProject cProjectId;
    @JoinColumn(name = "m_attributesetinstance_id", referencedColumnName = "m_attributesetinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MAttributesetinstance mAttributesetinstanceId;
    @JoinColumn(name = "m_inoutline_id", referencedColumnName = "m_inoutline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MInoutline mInoutlineId;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MLocator mLocatorId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "s_timeexpenseline_id", referencedColumnName = "s_timeexpenseline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private STimeexpenseline sTimeexpenselineId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectissueId")
    private List<MTransaction> mTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectissueId")
    private List<CProjectline> cProjectlineList;

    public CProjectissue() {
    }

    public CProjectissue(String cProjectissueId) {
        this.cProjectissueId = cProjectissueId;
    }

    public CProjectissue(String cProjectissueId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, BigInteger movementqty, Character processed, String posted, Date movementdate) {
        this.cProjectissueId = cProjectissueId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.movementqty = movementqty;
        this.processed = processed;
        this.posted = posted;
        this.movementdate = movementdate;
    }

    public String getCProjectissueId() {
        return cProjectissueId;
    }

    public void setCProjectissueId(String cProjectissueId) {
        this.cProjectissueId = cProjectissueId;
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

    public long getLine() {
        return line;
    }

    public void setLine(long line) {
        this.line = line;
    }

    public BigInteger getMovementqty() {
        return movementqty;
    }

    public void setMovementqty(BigInteger movementqty) {
        this.movementqty = movementqty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getMovementdate() {
        return movementdate;
    }

    public void setMovementdate(Date movementdate) {
        this.movementdate = movementdate;
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

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public MAttributesetinstance getMAttributesetinstanceId() {
        return mAttributesetinstanceId;
    }

    public void setMAttributesetinstanceId(MAttributesetinstance mAttributesetinstanceId) {
        this.mAttributesetinstanceId = mAttributesetinstanceId;
    }

    public MInoutline getMInoutlineId() {
        return mInoutlineId;
    }

    public void setMInoutlineId(MInoutline mInoutlineId) {
        this.mInoutlineId = mInoutlineId;
    }

    public MLocator getMLocatorId() {
        return mLocatorId;
    }

    public void setMLocatorId(MLocator mLocatorId) {
        this.mLocatorId = mLocatorId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public STimeexpenseline getSTimeexpenselineId() {
        return sTimeexpenselineId;
    }

    public void setSTimeexpenselineId(STimeexpenseline sTimeexpenselineId) {
        this.sTimeexpenselineId = sTimeexpenselineId;
    }

    @XmlTransient
    public List<MTransaction> getMTransactionList() {
        return mTransactionList;
    }

    public void setMTransactionList(List<MTransaction> mTransactionList) {
        this.mTransactionList = mTransactionList;
    }

    @XmlTransient
    public List<CProjectline> getCProjectlineList() {
        return cProjectlineList;
    }

    public void setCProjectlineList(List<CProjectline> cProjectlineList) {
        this.cProjectlineList = cProjectlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cProjectissueId != null ? cProjectissueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProjectissue)) {
            return false;
        }
        CProjectissue other = (CProjectissue) object;
        if ((this.cProjectissueId == null && other.cProjectissueId != null) || (this.cProjectissueId != null && !this.cProjectissueId.equals(other.cProjectissueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CProjectissue[ cProjectissueId=" + cProjectissueId + " ]";
    }
    
}
