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
@Table(name = "gl_journal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlJournal.findAll", query = "SELECT g FROM GlJournal g"),
    @NamedQuery(name = "GlJournal.findByGlJournalId", query = "SELECT g FROM GlJournal g WHERE g.glJournalId = :glJournalId"),
    @NamedQuery(name = "GlJournal.findByIsactive", query = "SELECT g FROM GlJournal g WHERE g.isactive = :isactive"),
    @NamedQuery(name = "GlJournal.findByCreated", query = "SELECT g FROM GlJournal g WHERE g.created = :created"),
    @NamedQuery(name = "GlJournal.findByCreatedby", query = "SELECT g FROM GlJournal g WHERE g.createdby = :createdby"),
    @NamedQuery(name = "GlJournal.findByUpdated", query = "SELECT g FROM GlJournal g WHERE g.updated = :updated"),
    @NamedQuery(name = "GlJournal.findByUpdatedby", query = "SELECT g FROM GlJournal g WHERE g.updatedby = :updatedby"),
    @NamedQuery(name = "GlJournal.findByUser1Id", query = "SELECT g FROM GlJournal g WHERE g.user1Id = :user1Id"),
    @NamedQuery(name = "GlJournal.findByUser2Id", query = "SELECT g FROM GlJournal g WHERE g.user2Id = :user2Id"),
    @NamedQuery(name = "GlJournal.findByDocumentno", query = "SELECT g FROM GlJournal g WHERE g.documentno = :documentno"),
    @NamedQuery(name = "GlJournal.findByDocstatus", query = "SELECT g FROM GlJournal g WHERE g.docstatus = :docstatus"),
    @NamedQuery(name = "GlJournal.findByDocaction", query = "SELECT g FROM GlJournal g WHERE g.docaction = :docaction"),
    @NamedQuery(name = "GlJournal.findByIsapproved", query = "SELECT g FROM GlJournal g WHERE g.isapproved = :isapproved"),
    @NamedQuery(name = "GlJournal.findByIsprinted", query = "SELECT g FROM GlJournal g WHERE g.isprinted = :isprinted"),
    @NamedQuery(name = "GlJournal.findByDescription", query = "SELECT g FROM GlJournal g WHERE g.description = :description"),
    @NamedQuery(name = "GlJournal.findByPostingtype", query = "SELECT g FROM GlJournal g WHERE g.postingtype = :postingtype"),
    @NamedQuery(name = "GlJournal.findByDatedoc", query = "SELECT g FROM GlJournal g WHERE g.datedoc = :datedoc"),
    @NamedQuery(name = "GlJournal.findByDateacct", query = "SELECT g FROM GlJournal g WHERE g.dateacct = :dateacct"),
    @NamedQuery(name = "GlJournal.findByCurrencyratetype", query = "SELECT g FROM GlJournal g WHERE g.currencyratetype = :currencyratetype"),
    @NamedQuery(name = "GlJournal.findByCurrencyrate", query = "SELECT g FROM GlJournal g WHERE g.currencyrate = :currencyrate"),
    @NamedQuery(name = "GlJournal.findByTotaldr", query = "SELECT g FROM GlJournal g WHERE g.totaldr = :totaldr"),
    @NamedQuery(name = "GlJournal.findByTotalcr", query = "SELECT g FROM GlJournal g WHERE g.totalcr = :totalcr"),
    @NamedQuery(name = "GlJournal.findByControlamt", query = "SELECT g FROM GlJournal g WHERE g.controlamt = :controlamt"),
    @NamedQuery(name = "GlJournal.findByProcessing", query = "SELECT g FROM GlJournal g WHERE g.processing = :processing"),
    @NamedQuery(name = "GlJournal.findByProcessed", query = "SELECT g FROM GlJournal g WHERE g.processed = :processed"),
    @NamedQuery(name = "GlJournal.findByPosted", query = "SELECT g FROM GlJournal g WHERE g.posted = :posted"),
    @NamedQuery(name = "GlJournal.findByIsopening", query = "SELECT g FROM GlJournal g WHERE g.isopening = :isopening")})
public class GlJournal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "gl_journal_id")
    private String glJournalId;
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
    @Size(max = 32)
    @Column(name = "user1_id")
    private String user1Id;
    @Size(max = 32)
    @Column(name = "user2_id")
    private String user2Id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "documentno")
    private String documentno;
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
    @Column(name = "isapproved")
    private Character isapproved;
    @Column(name = "isprinted")
    private Character isprinted;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "postingtype")
    private String postingtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datedoc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateacct")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateacct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "currencyratetype")
    private String currencyratetype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currencyrate")
    private BigInteger currencyrate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totaldr")
    private BigInteger totaldr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalcr")
    private BigInteger totalcr;
    @Column(name = "controlamt")
    private BigInteger controlamt;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "processed")
    private Character processed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "posted")
    private String posted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isopening")
    private Character isopening;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "glJournalId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "glJournalId")
    private List<CTaxpayment> cTaxpaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "glJournalId")
    private List<GlJournalline> glJournallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "glJournalId")
    private List<CRevenuerecognitionRun> cRevenuerecognitionRunList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDoctype cDoctypeId;
    @JoinColumn(name = "c_period_id", referencedColumnName = "c_period_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CPeriod cPeriodId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "gl_category_id", referencedColumnName = "gl_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private GlCategory glCategoryId;
    @JoinColumn(name = "gl_journalbatch_id", referencedColumnName = "gl_journalbatch_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private GlJournalbatch glJournalbatchId;

    public GlJournal() {
    }

    public GlJournal(String glJournalId) {
        this.glJournalId = glJournalId;
    }

    public GlJournal(String glJournalId, Character isactive, Date created, String createdby, Date updated, String updatedby, String documentno, String docstatus, String docaction, Character isapproved, String description, String postingtype, Date datedoc, Date dateacct, String currencyratetype, BigInteger currencyrate, BigInteger totaldr, BigInteger totalcr, String posted, Character isopening) {
        this.glJournalId = glJournalId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.documentno = documentno;
        this.docstatus = docstatus;
        this.docaction = docaction;
        this.isapproved = isapproved;
        this.description = description;
        this.postingtype = postingtype;
        this.datedoc = datedoc;
        this.dateacct = dateacct;
        this.currencyratetype = currencyratetype;
        this.currencyrate = currencyrate;
        this.totaldr = totaldr;
        this.totalcr = totalcr;
        this.posted = posted;
        this.isopening = isopening;
    }

    public String getGlJournalId() {
        return glJournalId;
    }

    public void setGlJournalId(String glJournalId) {
        this.glJournalId = glJournalId;
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

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
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

    public Character getIsapproved() {
        return isapproved;
    }

    public void setIsapproved(Character isapproved) {
        this.isapproved = isapproved;
    }

    public Character getIsprinted() {
        return isprinted;
    }

    public void setIsprinted(Character isprinted) {
        this.isprinted = isprinted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPostingtype() {
        return postingtype;
    }

    public void setPostingtype(String postingtype) {
        this.postingtype = postingtype;
    }

    public Date getDatedoc() {
        return datedoc;
    }

    public void setDatedoc(Date datedoc) {
        this.datedoc = datedoc;
    }

    public Date getDateacct() {
        return dateacct;
    }

    public void setDateacct(Date dateacct) {
        this.dateacct = dateacct;
    }

    public String getCurrencyratetype() {
        return currencyratetype;
    }

    public void setCurrencyratetype(String currencyratetype) {
        this.currencyratetype = currencyratetype;
    }

    public BigInteger getCurrencyrate() {
        return currencyrate;
    }

    public void setCurrencyrate(BigInteger currencyrate) {
        this.currencyrate = currencyrate;
    }

    public BigInteger getTotaldr() {
        return totaldr;
    }

    public void setTotaldr(BigInteger totaldr) {
        this.totaldr = totaldr;
    }

    public BigInteger getTotalcr() {
        return totalcr;
    }

    public void setTotalcr(BigInteger totalcr) {
        this.totalcr = totalcr;
    }

    public BigInteger getControlamt() {
        return controlamt;
    }

    public void setControlamt(BigInteger controlamt) {
        this.controlamt = controlamt;
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

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public Character getIsopening() {
        return isopening;
    }

    public void setIsopening(Character isopening) {
        this.isopening = isopening;
    }

    @XmlTransient
    public List<IGljournal> getIGljournalList() {
        return iGljournalList;
    }

    public void setIGljournalList(List<IGljournal> iGljournalList) {
        this.iGljournalList = iGljournalList;
    }

    @XmlTransient
    public List<CTaxpayment> getCTaxpaymentList() {
        return cTaxpaymentList;
    }

    public void setCTaxpaymentList(List<CTaxpayment> cTaxpaymentList) {
        this.cTaxpaymentList = cTaxpaymentList;
    }

    @XmlTransient
    public List<GlJournalline> getGlJournallineList() {
        return glJournallineList;
    }

    public void setGlJournallineList(List<GlJournalline> glJournallineList) {
        this.glJournallineList = glJournallineList;
    }

    @XmlTransient
    public List<CRevenuerecognitionRun> getCRevenuerecognitionRunList() {
        return cRevenuerecognitionRunList;
    }

    public void setCRevenuerecognitionRunList(List<CRevenuerecognitionRun> cRevenuerecognitionRunList) {
        this.cRevenuerecognitionRunList = cRevenuerecognitionRunList;
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

    public CAcctschema getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(CAcctschema cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
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

    public CPeriod getCPeriodId() {
        return cPeriodId;
    }

    public void setCPeriodId(CPeriod cPeriodId) {
        this.cPeriodId = cPeriodId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public GlCategory getGlCategoryId() {
        return glCategoryId;
    }

    public void setGlCategoryId(GlCategory glCategoryId) {
        this.glCategoryId = glCategoryId;
    }

    public GlJournalbatch getGlJournalbatchId() {
        return glJournalbatchId;
    }

    public void setGlJournalbatchId(GlJournalbatch glJournalbatchId) {
        this.glJournalbatchId = glJournalbatchId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (glJournalId != null ? glJournalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlJournal)) {
            return false;
        }
        GlJournal other = (GlJournal) object;
        if ((this.glJournalId == null && other.glJournalId != null) || (this.glJournalId != null && !this.glJournalId.equals(other.glJournalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.GlJournal[ glJournalId=" + glJournalId + " ]";
    }
    
}
