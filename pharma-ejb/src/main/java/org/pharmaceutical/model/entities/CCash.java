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
@Table(name = "c_cash")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCash.findAll", query = "SELECT c FROM CCash c"),
    @NamedQuery(name = "CCash.findByCCashId", query = "SELECT c FROM CCash c WHERE c.cCashId = :cCashId"),
    @NamedQuery(name = "CCash.findByIsactive", query = "SELECT c FROM CCash c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCash.findByCreated", query = "SELECT c FROM CCash c WHERE c.created = :created"),
    @NamedQuery(name = "CCash.findByCreatedby", query = "SELECT c FROM CCash c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCash.findByUpdated", query = "SELECT c FROM CCash c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCash.findByUpdatedby", query = "SELECT c FROM CCash c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCash.findByName", query = "SELECT c FROM CCash c WHERE c.name = :name"),
    @NamedQuery(name = "CCash.findByDescription", query = "SELECT c FROM CCash c WHERE c.description = :description"),
    @NamedQuery(name = "CCash.findByStatementdate", query = "SELECT c FROM CCash c WHERE c.statementdate = :statementdate"),
    @NamedQuery(name = "CCash.findByDateacct", query = "SELECT c FROM CCash c WHERE c.dateacct = :dateacct"),
    @NamedQuery(name = "CCash.findByBeginningbalance", query = "SELECT c FROM CCash c WHERE c.beginningbalance = :beginningbalance"),
    @NamedQuery(name = "CCash.findByEndingbalance", query = "SELECT c FROM CCash c WHERE c.endingbalance = :endingbalance"),
    @NamedQuery(name = "CCash.findByStatementdifference", query = "SELECT c FROM CCash c WHERE c.statementdifference = :statementdifference"),
    @NamedQuery(name = "CCash.findByProcessing", query = "SELECT c FROM CCash c WHERE c.processing = :processing"),
    @NamedQuery(name = "CCash.findByProcessed", query = "SELECT c FROM CCash c WHERE c.processed = :processed"),
    @NamedQuery(name = "CCash.findByPosted", query = "SELECT c FROM CCash c WHERE c.posted = :posted"),
    @NamedQuery(name = "CCash.findByUser1Id", query = "SELECT c FROM CCash c WHERE c.user1Id = :user1Id"),
    @NamedQuery(name = "CCash.findByUser2Id", query = "SELECT c FROM CCash c WHERE c.user2Id = :user2Id")})
public class CCash implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_cash_id")
    private String cCashId;
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
    @Column(name = "statementdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statementdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateacct")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateacct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "beginningbalance")
    private BigInteger beginningbalance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endingbalance")
    private BigInteger endingbalance;
    @Column(name = "statementdifference")
    private BigInteger statementdifference;
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
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCashId")
    private List<CCashline> cCashlineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_orgtrx_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgtrxId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_cashbook_id", referencedColumnName = "c_cashbook_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCashbook cCashbookId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;

    public CCash() {
    }

    public CCash(String cCashId) {
        this.cCashId = cCashId;
    }

    public CCash(String cCashId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Date statementdate, Date dateacct, BigInteger beginningbalance, BigInteger endingbalance, String processed, String posted) {
        this.cCashId = cCashId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.statementdate = statementdate;
        this.dateacct = dateacct;
        this.beginningbalance = beginningbalance;
        this.endingbalance = endingbalance;
        this.processed = processed;
        this.posted = posted;
    }

    public String getCCashId() {
        return cCashId;
    }

    public void setCCashId(String cCashId) {
        this.cCashId = cCashId;
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

    public Date getStatementdate() {
        return statementdate;
    }

    public void setStatementdate(Date statementdate) {
        this.statementdate = statementdate;
    }

    public Date getDateacct() {
        return dateacct;
    }

    public void setDateacct(Date dateacct) {
        this.dateacct = dateacct;
    }

    public BigInteger getBeginningbalance() {
        return beginningbalance;
    }

    public void setBeginningbalance(BigInteger beginningbalance) {
        this.beginningbalance = beginningbalance;
    }

    public BigInteger getEndingbalance() {
        return endingbalance;
    }

    public void setEndingbalance(BigInteger endingbalance) {
        this.endingbalance = endingbalance;
    }

    public BigInteger getStatementdifference() {
        return statementdifference;
    }

    public void setStatementdifference(BigInteger statementdifference) {
        this.statementdifference = statementdifference;
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

    @XmlTransient
    public List<CCashline> getCCashlineList() {
        return cCashlineList;
    }

    public void setCCashlineList(List<CCashline> cCashlineList) {
        this.cCashlineList = cCashlineList;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdOrg getAdOrgtrxId() {
        return adOrgtrxId;
    }

    public void setAdOrgtrxId(AdOrg adOrgtrxId) {
        this.adOrgtrxId = adOrgtrxId;
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

    public CCashbook getCCashbookId() {
        return cCashbookId;
    }

    public void setCCashbookId(CCashbook cCashbookId) {
        this.cCashbookId = cCashbookId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCashId != null ? cCashId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCash)) {
            return false;
        }
        CCash other = (CCash) object;
        if ((this.cCashId == null && other.cCashId != null) || (this.cCashId != null && !this.cCashId.equals(other.cCashId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCash[ cCashId=" + cCashId + " ]";
    }
    
}
