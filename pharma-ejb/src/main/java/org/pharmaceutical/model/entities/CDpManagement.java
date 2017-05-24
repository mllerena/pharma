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
@Table(name = "c_dp_management")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CDpManagement.findAll", query = "SELECT c FROM CDpManagement c"),
    @NamedQuery(name = "CDpManagement.findByCDpManagementId", query = "SELECT c FROM CDpManagement c WHERE c.cDpManagementId = :cDpManagementId"),
    @NamedQuery(name = "CDpManagement.findByIsactive", query = "SELECT c FROM CDpManagement c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CDpManagement.findByCreated", query = "SELECT c FROM CDpManagement c WHERE c.created = :created"),
    @NamedQuery(name = "CDpManagement.findByCreatedby", query = "SELECT c FROM CDpManagement c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CDpManagement.findByUpdated", query = "SELECT c FROM CDpManagement c WHERE c.updated = :updated"),
    @NamedQuery(name = "CDpManagement.findByUpdatedby", query = "SELECT c FROM CDpManagement c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CDpManagement.findByDocumentno", query = "SELECT c FROM CDpManagement c WHERE c.documentno = :documentno"),
    @NamedQuery(name = "CDpManagement.findByDatetrx", query = "SELECT c FROM CDpManagement c WHERE c.datetrx = :datetrx"),
    @NamedQuery(name = "CDpManagement.findByProcessing", query = "SELECT c FROM CDpManagement c WHERE c.processing = :processing"),
    @NamedQuery(name = "CDpManagement.findByProcessed", query = "SELECT c FROM CDpManagement c WHERE c.processed = :processed"),
    @NamedQuery(name = "CDpManagement.findByPosted", query = "SELECT c FROM CDpManagement c WHERE c.posted = :posted"),
    @NamedQuery(name = "CDpManagement.findByUser1Id", query = "SELECT c FROM CDpManagement c WHERE c.user1Id = :user1Id"),
    @NamedQuery(name = "CDpManagement.findByUser2Id", query = "SELECT c FROM CDpManagement c WHERE c.user2Id = :user2Id"),
    @NamedQuery(name = "CDpManagement.findByCreatefrom", query = "SELECT c FROM CDpManagement c WHERE c.createfrom = :createfrom"),
    @NamedQuery(name = "CDpManagement.findByDescription", query = "SELECT c FROM CDpManagement c WHERE c.description = :description"),
    @NamedQuery(name = "CDpManagement.findByDateacct", query = "SELECT c FROM CDpManagement c WHERE c.dateacct = :dateacct")})
public class CDpManagement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_dp_management_id")
    private String cDpManagementId;
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
    @Column(name = "datetrx")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetrx;
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
    @Column(name = "createfrom")
    private Character createfrom;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "dateacct")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateacct;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDpManagementId")
    private List<CBankstatementline> cBankstatementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cDpManagementId")
    private List<CRemittance> cRemittanceList;
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
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDoctype cDoctypeId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDpManagementId")
    private List<CDpManagementline> cDpManagementlineList;

    public CDpManagement() {
    }

    public CDpManagement(String cDpManagementId) {
        this.cDpManagementId = cDpManagementId;
    }

    public CDpManagement(String cDpManagementId, Character isactive, Date created, String createdby, Date updated, String updatedby, String documentno, Date datetrx, String processed, String posted) {
        this.cDpManagementId = cDpManagementId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.documentno = documentno;
        this.datetrx = datetrx;
        this.processed = processed;
        this.posted = posted;
    }

    public String getCDpManagementId() {
        return cDpManagementId;
    }

    public void setCDpManagementId(String cDpManagementId) {
        this.cDpManagementId = cDpManagementId;
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

    public Date getDatetrx() {
        return datetrx;
    }

    public void setDatetrx(Date datetrx) {
        this.datetrx = datetrx;
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

    public Character getCreatefrom() {
        return createfrom;
    }

    public void setCreatefrom(Character createfrom) {
        this.createfrom = createfrom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateacct() {
        return dateacct;
    }

    public void setDateacct(Date dateacct) {
        this.dateacct = dateacct;
    }

    @XmlTransient
    public List<CBankstatementline> getCBankstatementlineList() {
        return cBankstatementlineList;
    }

    public void setCBankstatementlineList(List<CBankstatementline> cBankstatementlineList) {
        this.cBankstatementlineList = cBankstatementlineList;
    }

    @XmlTransient
    public List<CRemittance> getCRemittanceList() {
        return cRemittanceList;
    }

    public void setCRemittanceList(List<CRemittance> cRemittanceList) {
        this.cRemittanceList = cRemittanceList;
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

    public CDoctype getCDoctypeId() {
        return cDoctypeId;
    }

    public void setCDoctypeId(CDoctype cDoctypeId) {
        this.cDoctypeId = cDoctypeId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    @XmlTransient
    public List<CDpManagementline> getCDpManagementlineList() {
        return cDpManagementlineList;
    }

    public void setCDpManagementlineList(List<CDpManagementline> cDpManagementlineList) {
        this.cDpManagementlineList = cDpManagementlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cDpManagementId != null ? cDpManagementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CDpManagement)) {
            return false;
        }
        CDpManagement other = (CDpManagement) object;
        if ((this.cDpManagementId == null && other.cDpManagementId != null) || (this.cDpManagementId != null && !this.cDpManagementId.equals(other.cDpManagementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CDpManagement[ cDpManagementId=" + cDpManagementId + " ]";
    }
    
}
