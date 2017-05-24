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
@Table(name = "r_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RRequest.findAll", query = "SELECT r FROM RRequest r"),
    @NamedQuery(name = "RRequest.findByRRequestId", query = "SELECT r FROM RRequest r WHERE r.rRequestId = :rRequestId"),
    @NamedQuery(name = "RRequest.findByIsactive", query = "SELECT r FROM RRequest r WHERE r.isactive = :isactive"),
    @NamedQuery(name = "RRequest.findByCreated", query = "SELECT r FROM RRequest r WHERE r.created = :created"),
    @NamedQuery(name = "RRequest.findByCreatedby", query = "SELECT r FROM RRequest r WHERE r.createdby = :createdby"),
    @NamedQuery(name = "RRequest.findByUpdated", query = "SELECT r FROM RRequest r WHERE r.updated = :updated"),
    @NamedQuery(name = "RRequest.findByUpdatedby", query = "SELECT r FROM RRequest r WHERE r.updatedby = :updatedby"),
    @NamedQuery(name = "RRequest.findByDocumentno", query = "SELECT r FROM RRequest r WHERE r.documentno = :documentno"),
    @NamedQuery(name = "RRequest.findByRequestamt", query = "SELECT r FROM RRequest r WHERE r.requestamt = :requestamt"),
    @NamedQuery(name = "RRequest.findByPriority", query = "SELECT r FROM RRequest r WHERE r.priority = :priority"),
    @NamedQuery(name = "RRequest.findByDuetype", query = "SELECT r FROM RRequest r WHERE r.duetype = :duetype"),
    @NamedQuery(name = "RRequest.findBySummary", query = "SELECT r FROM RRequest r WHERE r.summary = :summary"),
    @NamedQuery(name = "RRequest.findByIsescalated", query = "SELECT r FROM RRequest r WHERE r.isescalated = :isescalated"),
    @NamedQuery(name = "RRequest.findByDatelastaction", query = "SELECT r FROM RRequest r WHERE r.datelastaction = :datelastaction"),
    @NamedQuery(name = "RRequest.findByLastresult", query = "SELECT r FROM RRequest r WHERE r.lastresult = :lastresult"),
    @NamedQuery(name = "RRequest.findByActiontype", query = "SELECT r FROM RRequest r WHERE r.actiontype = :actiontype"),
    @NamedQuery(name = "RRequest.findByMailsubject", query = "SELECT r FROM RRequest r WHERE r.mailsubject = :mailsubject"),
    @NamedQuery(name = "RRequest.findByMailtext", query = "SELECT r FROM RRequest r WHERE r.mailtext = :mailtext"),
    @NamedQuery(name = "RRequest.findByResult", query = "SELECT r FROM RRequest r WHERE r.result = :result"),
    @NamedQuery(name = "RRequest.findByNextaction", query = "SELECT r FROM RRequest r WHERE r.nextaction = :nextaction"),
    @NamedQuery(name = "RRequest.findByDatenextaction", query = "SELECT r FROM RRequest r WHERE r.datenextaction = :datenextaction"),
    @NamedQuery(name = "RRequest.findByProcessing", query = "SELECT r FROM RRequest r WHERE r.processing = :processing"),
    @NamedQuery(name = "RRequest.findByProcessed", query = "SELECT r FROM RRequest r WHERE r.processed = :processed"),
    @NamedQuery(name = "RRequest.findByIsselfservice", query = "SELECT r FROM RRequest r WHERE r.isselfservice = :isselfservice")})
public class RRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "r_request_id")
    private String rRequestId;
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
    @Column(name = "requestamt")
    private BigInteger requestamt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "priority")
    private String priority;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "duetype")
    private String duetype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "summary")
    private String summary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isescalated")
    private Character isescalated;
    @Column(name = "datelastaction")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datelastaction;
    @Size(max = 2000)
    @Column(name = "lastresult")
    private String lastresult;
    @Size(max = 60)
    @Column(name = "actiontype")
    private String actiontype;
    @Size(max = 60)
    @Column(name = "mailsubject")
    private String mailsubject;
    @Size(max = 2000)
    @Column(name = "mailtext")
    private String mailtext;
    @Size(max = 2000)
    @Column(name = "result")
    private String result;
    @Size(max = 60)
    @Column(name = "nextaction")
    private String nextaction;
    @Column(name = "datenextaction")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datenextaction;
    @Column(name = "processing")
    private Character processing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "processed")
    private Character processed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isselfservice")
    private Character isselfservice;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "salesrep_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdUser salesrepId;
    @JoinColumn(name = "r_mailtext_id", referencedColumnName = "r_mailtext_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private RMailtext rMailtextId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_debt_payment_id", referencedColumnName = "c_debt_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDebtPayment cDebtPaymentId;
    @JoinColumn(name = "c_invoice_id", referencedColumnName = "c_invoice_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoice cInvoiceId;
    @JoinColumn(name = "c_order_id", referencedColumnName = "c_order_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrder cOrderId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "r_requesttype_id", referencedColumnName = "r_requesttype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private RRequesttype rRequesttypeId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "rRequestId")
    private List<RRequestaction> rRequestactionList;

    public RRequest() {
    }

    public RRequest(String rRequestId) {
        this.rRequestId = rRequestId;
    }

    public RRequest(String rRequestId, Character isactive, Date created, String createdby, Date updated, String updatedby, String documentno, BigInteger requestamt, String priority, String duetype, String summary, Character isescalated, Character processed, Character isselfservice) {
        this.rRequestId = rRequestId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.documentno = documentno;
        this.requestamt = requestamt;
        this.priority = priority;
        this.duetype = duetype;
        this.summary = summary;
        this.isescalated = isescalated;
        this.processed = processed;
        this.isselfservice = isselfservice;
    }

    public String getRRequestId() {
        return rRequestId;
    }

    public void setRRequestId(String rRequestId) {
        this.rRequestId = rRequestId;
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

    public BigInteger getRequestamt() {
        return requestamt;
    }

    public void setRequestamt(BigInteger requestamt) {
        this.requestamt = requestamt;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDuetype() {
        return duetype;
    }

    public void setDuetype(String duetype) {
        this.duetype = duetype;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Character getIsescalated() {
        return isescalated;
    }

    public void setIsescalated(Character isescalated) {
        this.isescalated = isescalated;
    }

    public Date getDatelastaction() {
        return datelastaction;
    }

    public void setDatelastaction(Date datelastaction) {
        this.datelastaction = datelastaction;
    }

    public String getLastresult() {
        return lastresult;
    }

    public void setLastresult(String lastresult) {
        this.lastresult = lastresult;
    }

    public String getActiontype() {
        return actiontype;
    }

    public void setActiontype(String actiontype) {
        this.actiontype = actiontype;
    }

    public String getMailsubject() {
        return mailsubject;
    }

    public void setMailsubject(String mailsubject) {
        this.mailsubject = mailsubject;
    }

    public String getMailtext() {
        return mailtext;
    }

    public void setMailtext(String mailtext) {
        this.mailtext = mailtext;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNextaction() {
        return nextaction;
    }

    public void setNextaction(String nextaction) {
        this.nextaction = nextaction;
    }

    public Date getDatenextaction() {
        return datenextaction;
    }

    public void setDatenextaction(Date datenextaction) {
        this.datenextaction = datenextaction;
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

    public Character getIsselfservice() {
        return isselfservice;
    }

    public void setIsselfservice(Character isselfservice) {
        this.isselfservice = isselfservice;
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

    public AdUser getSalesrepId() {
        return salesrepId;
    }

    public void setSalesrepId(AdUser salesrepId) {
        this.salesrepId = salesrepId;
    }

    public RMailtext getRMailtextId() {
        return rMailtextId;
    }

    public void setRMailtextId(RMailtext rMailtextId) {
        this.rMailtextId = rMailtextId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CCampaign getCCampaignId() {
        return cCampaignId;
    }

    public void setCCampaignId(CCampaign cCampaignId) {
        this.cCampaignId = cCampaignId;
    }

    public CDebtPayment getCDebtPaymentId() {
        return cDebtPaymentId;
    }

    public void setCDebtPaymentId(CDebtPayment cDebtPaymentId) {
        this.cDebtPaymentId = cDebtPaymentId;
    }

    public CInvoice getCInvoiceId() {
        return cInvoiceId;
    }

    public void setCInvoiceId(CInvoice cInvoiceId) {
        this.cInvoiceId = cInvoiceId;
    }

    public COrder getCOrderId() {
        return cOrderId;
    }

    public void setCOrderId(COrder cOrderId) {
        this.cOrderId = cOrderId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public RRequesttype getRRequesttypeId() {
        return rRequesttypeId;
    }

    public void setRRequesttypeId(RRequesttype rRequesttypeId) {
        this.rRequesttypeId = rRequesttypeId;
    }

    @XmlTransient
    public List<RRequestaction> getRRequestactionList() {
        return rRequestactionList;
    }

    public void setRRequestactionList(List<RRequestaction> rRequestactionList) {
        this.rRequestactionList = rRequestactionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rRequestId != null ? rRequestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RRequest)) {
            return false;
        }
        RRequest other = (RRequest) object;
        if ((this.rRequestId == null && other.rRequestId != null) || (this.rRequestId != null && !this.rRequestId.equals(other.rRequestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.RRequest[ rRequestId=" + rRequestId + " ]";
    }
    
}
