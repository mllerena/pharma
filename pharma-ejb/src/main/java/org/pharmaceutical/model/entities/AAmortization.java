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
import javax.persistence.FetchType;
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
@Table(name = "a_amortization")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AAmortization.findAll", query = "SELECT a FROM AAmortization a"),
    @NamedQuery(name = "AAmortization.findByAAmortizationId", query = "SELECT a FROM AAmortization a WHERE a.aAmortizationId = :aAmortizationId"),
    @NamedQuery(name = "AAmortization.findByIsactive", query = "SELECT a FROM AAmortization a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AAmortization.findByCreated", query = "SELECT a FROM AAmortization a WHERE a.created = :created"),
    @NamedQuery(name = "AAmortization.findByCreatedby", query = "SELECT a FROM AAmortization a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AAmortization.findByUpdated", query = "SELECT a FROM AAmortization a WHERE a.updated = :updated"),
    @NamedQuery(name = "AAmortization.findByUpdatedby", query = "SELECT a FROM AAmortization a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AAmortization.findByName", query = "SELECT a FROM AAmortization a WHERE a.name = :name"),
    @NamedQuery(name = "AAmortization.findByDescription", query = "SELECT a FROM AAmortization a WHERE a.description = :description"),
    @NamedQuery(name = "AAmortization.findByStartdate", query = "SELECT a FROM AAmortization a WHERE a.startdate = :startdate"),
    @NamedQuery(name = "AAmortization.findByEnddate", query = "SELECT a FROM AAmortization a WHERE a.enddate = :enddate"),
    @NamedQuery(name = "AAmortization.findByProcessing", query = "SELECT a FROM AAmortization a WHERE a.processing = :processing"),
    @NamedQuery(name = "AAmortization.findByProcessed", query = "SELECT a FROM AAmortization a WHERE a.processed = :processed"),
    @NamedQuery(name = "AAmortization.findByPosted", query = "SELECT a FROM AAmortization a WHERE a.posted = :posted"),
    @NamedQuery(name = "AAmortization.findByUser1Id", query = "SELECT a FROM AAmortization a WHERE a.user1Id = :user1Id"),
    @NamedQuery(name = "AAmortization.findByUser2Id", query = "SELECT a FROM AAmortization a WHERE a.user2Id = :user2Id"),
    @NamedQuery(name = "AAmortization.findByDateacct", query = "SELECT a FROM AAmortization a WHERE a.dateacct = :dateacct"),
    @NamedQuery(name = "AAmortization.findByTotalamortization", query = "SELECT a FROM AAmortization a WHERE a.totalamortization = :totalamortization")})
public class AAmortization implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "a_amortization_id")
    private String aAmortizationId;
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
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Column(name = "processing")
    private Character processing;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "processed")
    private String processed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "posted")
    private String posted;
    @Size(max = 32)
    @Column(name = "user1_id")
    private String user1Id;
    @Size(max = 32)
    @Column(name = "user2_id")
    private String user2Id;
    @Column(name = "dateacct")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateacct;
    @Column(name = "totalamortization")
    private BigInteger totalamortization;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "aAmortizationId")
    private List<AAmortizationline> aAmortizationlineList;

    public AAmortization() {
    }

    public AAmortization(String aAmortizationId) {
        this.aAmortizationId = aAmortizationId;
    }

    public AAmortization(String aAmortizationId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String processed, String posted) {
        this.aAmortizationId = aAmortizationId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.processed = processed;
        this.posted = posted;
    }

    public String getAAmortizationId() {
        return aAmortizationId;
    }

    public void setAAmortizationId(String aAmortizationId) {
        this.aAmortizationId = aAmortizationId;
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

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public String getProcessed() {
        return processed;
    }

    public void setProcessed(String processed) {
        this.processed = processed;
    }

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public String getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(String user1Id) {
        this.user1Id = user1Id;
    }

    public String getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(String user2Id) {
        this.user2Id = user2Id;
    }

    public Date getDateacct() {
        return dateacct;
    }

    public void setDateacct(Date dateacct) {
        this.dateacct = dateacct;
    }

    public BigInteger getTotalamortization() {
        return totalamortization;
    }

    public void setTotalamortization(BigInteger totalamortization) {
        this.totalamortization = totalamortization;
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

    public CActivity getCActivityId() {
        return cActivityId;
    }

    public void setCActivityId(CActivity cActivityId) {
        this.cActivityId = cActivityId;
    }

    public CCampaign getCCampaignId() {
        return cCampaignId;
    }

    public void setCCampaignId(CCampaign cCampaignId) {
        this.cCampaignId = cCampaignId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    @XmlTransient
    public List<AAmortizationline> getAAmortizationlineList() {
        return aAmortizationlineList;
    }

    public void setAAmortizationlineList(List<AAmortizationline> aAmortizationlineList) {
        this.aAmortizationlineList = aAmortizationlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aAmortizationId != null ? aAmortizationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AAmortization)) {
            return false;
        }
        AAmortization other = (AAmortization) object;
        if ((this.aAmortizationId == null && other.aAmortizationId != null) || (this.aAmortizationId != null && !this.aAmortizationId.equals(other.aAmortizationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AAmortization[ aAmortizationId=" + aAmortizationId + " ]";
    }
    
}
