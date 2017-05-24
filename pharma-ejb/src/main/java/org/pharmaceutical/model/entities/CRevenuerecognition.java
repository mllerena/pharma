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
@Table(name = "c_revenuerecognition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CRevenuerecognition.findAll", query = "SELECT c FROM CRevenuerecognition c"),
    @NamedQuery(name = "CRevenuerecognition.findByCRevenuerecognitionId", query = "SELECT c FROM CRevenuerecognition c WHERE c.cRevenuerecognitionId = :cRevenuerecognitionId"),
    @NamedQuery(name = "CRevenuerecognition.findByIsactive", query = "SELECT c FROM CRevenuerecognition c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CRevenuerecognition.findByCreated", query = "SELECT c FROM CRevenuerecognition c WHERE c.created = :created"),
    @NamedQuery(name = "CRevenuerecognition.findByCreatedby", query = "SELECT c FROM CRevenuerecognition c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CRevenuerecognition.findByUpdated", query = "SELECT c FROM CRevenuerecognition c WHERE c.updated = :updated"),
    @NamedQuery(name = "CRevenuerecognition.findByUpdatedby", query = "SELECT c FROM CRevenuerecognition c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CRevenuerecognition.findByName", query = "SELECT c FROM CRevenuerecognition c WHERE c.name = :name"),
    @NamedQuery(name = "CRevenuerecognition.findByDescription", query = "SELECT c FROM CRevenuerecognition c WHERE c.description = :description"),
    @NamedQuery(name = "CRevenuerecognition.findByIstimebased", query = "SELECT c FROM CRevenuerecognition c WHERE c.istimebased = :istimebased"),
    @NamedQuery(name = "CRevenuerecognition.findByRecognitionfrequency", query = "SELECT c FROM CRevenuerecognition c WHERE c.recognitionfrequency = :recognitionfrequency"),
    @NamedQuery(name = "CRevenuerecognition.findByNomonths", query = "SELECT c FROM CRevenuerecognition c WHERE c.nomonths = :nomonths")})
public class CRevenuerecognition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_revenuerecognition_id")
    private String cRevenuerecognitionId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istimebased")
    private Character istimebased;
    @Size(max = 60)
    @Column(name = "recognitionfrequency")
    private String recognitionfrequency;
    @Column(name = "nomonths")
    private Long nomonths;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cRevenuerecognitionId")
    private List<CRevenuerecognitionPlan> cRevenuerecognitionPlanList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public CRevenuerecognition() {
    }

    public CRevenuerecognition(String cRevenuerecognitionId) {
        this.cRevenuerecognitionId = cRevenuerecognitionId;
    }

    public CRevenuerecognition(String cRevenuerecognitionId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character istimebased) {
        this.cRevenuerecognitionId = cRevenuerecognitionId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.istimebased = istimebased;
    }

    public String getCRevenuerecognitionId() {
        return cRevenuerecognitionId;
    }

    public void setCRevenuerecognitionId(String cRevenuerecognitionId) {
        this.cRevenuerecognitionId = cRevenuerecognitionId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getIstimebased() {
        return istimebased;
    }

    public void setIstimebased(Character istimebased) {
        this.istimebased = istimebased;
    }

    public String getRecognitionfrequency() {
        return recognitionfrequency;
    }

    public void setRecognitionfrequency(String recognitionfrequency) {
        this.recognitionfrequency = recognitionfrequency;
    }

    public Long getNomonths() {
        return nomonths;
    }

    public void setNomonths(Long nomonths) {
        this.nomonths = nomonths;
    }

    @XmlTransient
    public List<CRevenuerecognitionPlan> getCRevenuerecognitionPlanList() {
        return cRevenuerecognitionPlanList;
    }

    public void setCRevenuerecognitionPlanList(List<CRevenuerecognitionPlan> cRevenuerecognitionPlanList) {
        this.cRevenuerecognitionPlanList = cRevenuerecognitionPlanList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cRevenuerecognitionId != null ? cRevenuerecognitionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CRevenuerecognition)) {
            return false;
        }
        CRevenuerecognition other = (CRevenuerecognition) object;
        if ((this.cRevenuerecognitionId == null && other.cRevenuerecognitionId != null) || (this.cRevenuerecognitionId != null && !this.cRevenuerecognitionId.equals(other.cRevenuerecognitionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CRevenuerecognition[ cRevenuerecognitionId=" + cRevenuerecognitionId + " ]";
    }
    
}
