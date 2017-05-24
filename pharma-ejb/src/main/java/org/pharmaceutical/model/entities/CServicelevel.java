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
@Table(name = "c_servicelevel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CServicelevel.findAll", query = "SELECT c FROM CServicelevel c"),
    @NamedQuery(name = "CServicelevel.findByCServicelevelId", query = "SELECT c FROM CServicelevel c WHERE c.cServicelevelId = :cServicelevelId"),
    @NamedQuery(name = "CServicelevel.findByIsactive", query = "SELECT c FROM CServicelevel c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CServicelevel.findByCreated", query = "SELECT c FROM CServicelevel c WHERE c.created = :created"),
    @NamedQuery(name = "CServicelevel.findByCreatedby", query = "SELECT c FROM CServicelevel c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CServicelevel.findByUpdated", query = "SELECT c FROM CServicelevel c WHERE c.updated = :updated"),
    @NamedQuery(name = "CServicelevel.findByUpdatedby", query = "SELECT c FROM CServicelevel c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CServicelevel.findByDescription", query = "SELECT c FROM CServicelevel c WHERE c.description = :description"),
    @NamedQuery(name = "CServicelevel.findByServicelevelprovided", query = "SELECT c FROM CServicelevel c WHERE c.servicelevelprovided = :servicelevelprovided"),
    @NamedQuery(name = "CServicelevel.findByServicelevelinvoiced", query = "SELECT c FROM CServicelevel c WHERE c.servicelevelinvoiced = :servicelevelinvoiced"),
    @NamedQuery(name = "CServicelevel.findByProcessing", query = "SELECT c FROM CServicelevel c WHERE c.processing = :processing"),
    @NamedQuery(name = "CServicelevel.findByProcessed", query = "SELECT c FROM CServicelevel c WHERE c.processed = :processed")})
public class CServicelevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_servicelevel_id")
    private String cServicelevelId;
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
    @Column(name = "servicelevelprovided")
    private BigInteger servicelevelprovided;
    @Basic(optional = false)
    @NotNull
    @Column(name = "servicelevelinvoiced")
    private BigInteger servicelevelinvoiced;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "processed")
    private Character processed;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_revenuerecognition_plan_id", referencedColumnName = "c_revenuerecognition_plan_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CRevenuerecognitionPlan cRevenuerecognitionPlanId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cServicelevelId")
    private List<CServicelevelline> cServicelevellineList;

    public CServicelevel() {
    }

    public CServicelevel(String cServicelevelId) {
        this.cServicelevelId = cServicelevelId;
    }

    public CServicelevel(String cServicelevelId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger servicelevelprovided, BigInteger servicelevelinvoiced) {
        this.cServicelevelId = cServicelevelId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.servicelevelprovided = servicelevelprovided;
        this.servicelevelinvoiced = servicelevelinvoiced;
    }

    public String getCServicelevelId() {
        return cServicelevelId;
    }

    public void setCServicelevelId(String cServicelevelId) {
        this.cServicelevelId = cServicelevelId;
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

    public BigInteger getServicelevelprovided() {
        return servicelevelprovided;
    }

    public void setServicelevelprovided(BigInteger servicelevelprovided) {
        this.servicelevelprovided = servicelevelprovided;
    }

    public BigInteger getServicelevelinvoiced() {
        return servicelevelinvoiced;
    }

    public void setServicelevelinvoiced(BigInteger servicelevelinvoiced) {
        this.servicelevelinvoiced = servicelevelinvoiced;
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

    public CRevenuerecognitionPlan getCRevenuerecognitionPlanId() {
        return cRevenuerecognitionPlanId;
    }

    public void setCRevenuerecognitionPlanId(CRevenuerecognitionPlan cRevenuerecognitionPlanId) {
        this.cRevenuerecognitionPlanId = cRevenuerecognitionPlanId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @XmlTransient
    public List<CServicelevelline> getCServicelevellineList() {
        return cServicelevellineList;
    }

    public void setCServicelevellineList(List<CServicelevelline> cServicelevellineList) {
        this.cServicelevellineList = cServicelevellineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cServicelevelId != null ? cServicelevelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CServicelevel)) {
            return false;
        }
        CServicelevel other = (CServicelevel) object;
        if ((this.cServicelevelId == null && other.cServicelevelId != null) || (this.cServicelevelId != null && !this.cServicelevelId.equals(other.cServicelevelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CServicelevel[ cServicelevelId=" + cServicelevelId + " ]";
    }
    
}
