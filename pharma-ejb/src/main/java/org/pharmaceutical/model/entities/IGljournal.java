/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "i_gljournal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IGljournal.findAll", query = "SELECT i FROM IGljournal i"),
    @NamedQuery(name = "IGljournal.findByIGljournalId", query = "SELECT i FROM IGljournal i WHERE i.iGljournalId = :iGljournalId"),
    @NamedQuery(name = "IGljournal.findByClientvalue", query = "SELECT i FROM IGljournal i WHERE i.clientvalue = :clientvalue"),
    @NamedQuery(name = "IGljournal.findByIsactive", query = "SELECT i FROM IGljournal i WHERE i.isactive = :isactive"),
    @NamedQuery(name = "IGljournal.findByCreated", query = "SELECT i FROM IGljournal i WHERE i.created = :created"),
    @NamedQuery(name = "IGljournal.findByCreatedby", query = "SELECT i FROM IGljournal i WHERE i.createdby = :createdby"),
    @NamedQuery(name = "IGljournal.findByUpdated", query = "SELECT i FROM IGljournal i WHERE i.updated = :updated"),
    @NamedQuery(name = "IGljournal.findByUpdatedby", query = "SELECT i FROM IGljournal i WHERE i.updatedby = :updatedby"),
    @NamedQuery(name = "IGljournal.findByIIsimported", query = "SELECT i FROM IGljournal i WHERE i.iIsimported = :iIsimported"),
    @NamedQuery(name = "IGljournal.findByIErrormsg", query = "SELECT i FROM IGljournal i WHERE i.iErrormsg = :iErrormsg"),
    @NamedQuery(name = "IGljournal.findByProcessing", query = "SELECT i FROM IGljournal i WHERE i.processing = :processing"),
    @NamedQuery(name = "IGljournal.findByProcessed", query = "SELECT i FROM IGljournal i WHERE i.processed = :processed"),
    @NamedQuery(name = "IGljournal.findByBatchdocumentno", query = "SELECT i FROM IGljournal i WHERE i.batchdocumentno = :batchdocumentno"),
    @NamedQuery(name = "IGljournal.findByBatchdescription", query = "SELECT i FROM IGljournal i WHERE i.batchdescription = :batchdescription"),
    @NamedQuery(name = "IGljournal.findByJournaldocumentno", query = "SELECT i FROM IGljournal i WHERE i.journaldocumentno = :journaldocumentno"),
    @NamedQuery(name = "IGljournal.findByPostingtype", query = "SELECT i FROM IGljournal i WHERE i.postingtype = :postingtype"),
    @NamedQuery(name = "IGljournal.findByAcctschemaname", query = "SELECT i FROM IGljournal i WHERE i.acctschemaname = :acctschemaname"),
    @NamedQuery(name = "IGljournal.findByDoctypename", query = "SELECT i FROM IGljournal i WHERE i.doctypename = :doctypename"),
    @NamedQuery(name = "IGljournal.findByCategoryname", query = "SELECT i FROM IGljournal i WHERE i.categoryname = :categoryname"),
    @NamedQuery(name = "IGljournal.findByGlBudgetId", query = "SELECT i FROM IGljournal i WHERE i.glBudgetId = :glBudgetId"),
    @NamedQuery(name = "IGljournal.findByLine", query = "SELECT i FROM IGljournal i WHERE i.line = :line"),
    @NamedQuery(name = "IGljournal.findByDateacct", query = "SELECT i FROM IGljournal i WHERE i.dateacct = :dateacct"),
    @NamedQuery(name = "IGljournal.findByDescription", query = "SELECT i FROM IGljournal i WHERE i.description = :description"),
    @NamedQuery(name = "IGljournal.findByAmtsourcedr", query = "SELECT i FROM IGljournal i WHERE i.amtsourcedr = :amtsourcedr"),
    @NamedQuery(name = "IGljournal.findByAmtacctdr", query = "SELECT i FROM IGljournal i WHERE i.amtacctdr = :amtacctdr"),
    @NamedQuery(name = "IGljournal.findByAmtsourcecr", query = "SELECT i FROM IGljournal i WHERE i.amtsourcecr = :amtsourcecr"),
    @NamedQuery(name = "IGljournal.findByAmtacctcr", query = "SELECT i FROM IGljournal i WHERE i.amtacctcr = :amtacctcr"),
    @NamedQuery(name = "IGljournal.findByIsoCode", query = "SELECT i FROM IGljournal i WHERE i.isoCode = :isoCode"),
    @NamedQuery(name = "IGljournal.findByCurrencyratetype", query = "SELECT i FROM IGljournal i WHERE i.currencyratetype = :currencyratetype"),
    @NamedQuery(name = "IGljournal.findByCurrencyrate", query = "SELECT i FROM IGljournal i WHERE i.currencyrate = :currencyrate"),
    @NamedQuery(name = "IGljournal.findByQty", query = "SELECT i FROM IGljournal i WHERE i.qty = :qty"),
    @NamedQuery(name = "IGljournal.findByOrgvalue", query = "SELECT i FROM IGljournal i WHERE i.orgvalue = :orgvalue"),
    @NamedQuery(name = "IGljournal.findByAccountvalue", query = "SELECT i FROM IGljournal i WHERE i.accountvalue = :accountvalue"),
    @NamedQuery(name = "IGljournal.findByOrgtrxvalue", query = "SELECT i FROM IGljournal i WHERE i.orgtrxvalue = :orgtrxvalue"),
    @NamedQuery(name = "IGljournal.findByProductvalue", query = "SELECT i FROM IGljournal i WHERE i.productvalue = :productvalue"),
    @NamedQuery(name = "IGljournal.findByUpc", query = "SELECT i FROM IGljournal i WHERE i.upc = :upc"),
    @NamedQuery(name = "IGljournal.findBySku", query = "SELECT i FROM IGljournal i WHERE i.sku = :sku"),
    @NamedQuery(name = "IGljournal.findByBpartnervalue", query = "SELECT i FROM IGljournal i WHERE i.bpartnervalue = :bpartnervalue"),
    @NamedQuery(name = "IGljournal.findByProjectvalue", query = "SELECT i FROM IGljournal i WHERE i.projectvalue = :projectvalue"),
    @NamedQuery(name = "IGljournal.findByUser1Id", query = "SELECT i FROM IGljournal i WHERE i.user1Id = :user1Id"),
    @NamedQuery(name = "IGljournal.findByUser2Id", query = "SELECT i FROM IGljournal i WHERE i.user2Id = :user2Id")})
public class IGljournal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "i_gljournal_id")
    private String iGljournalId;
    @Size(max = 40)
    @Column(name = "clientvalue")
    private String clientvalue;
    @Column(name = "isactive")
    private Character isactive;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Size(max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Column(name = "i_isimported")
    private Character iIsimported;
    @Size(max = 2000)
    @Column(name = "i_errormsg")
    private String iErrormsg;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "processed")
    private Character processed;
    @Size(max = 30)
    @Column(name = "batchdocumentno")
    private String batchdocumentno;
    @Size(max = 255)
    @Column(name = "batchdescription")
    private String batchdescription;
    @Size(max = 30)
    @Column(name = "journaldocumentno")
    private String journaldocumentno;
    @Size(max = 60)
    @Column(name = "postingtype")
    private String postingtype;
    @Size(max = 60)
    @Column(name = "acctschemaname")
    private String acctschemaname;
    @Size(max = 60)
    @Column(name = "doctypename")
    private String doctypename;
    @Size(max = 60)
    @Column(name = "categoryname")
    private String categoryname;
    @Size(max = 32)
    @Column(name = "gl_budget_id")
    private String glBudgetId;
    @Column(name = "line")
    private Long line;
    @Column(name = "dateacct")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateacct;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "amtsourcedr")
    private BigInteger amtsourcedr;
    @Column(name = "amtacctdr")
    private BigInteger amtacctdr;
    @Column(name = "amtsourcecr")
    private BigInteger amtsourcecr;
    @Column(name = "amtacctcr")
    private BigInteger amtacctcr;
    @Size(max = 3)
    @Column(name = "iso_code")
    private String isoCode;
    @Size(max = 60)
    @Column(name = "currencyratetype")
    private String currencyratetype;
    @Column(name = "currencyrate")
    private BigInteger currencyrate;
    @Column(name = "qty")
    private BigInteger qty;
    @Size(max = 40)
    @Column(name = "orgvalue")
    private String orgvalue;
    @Size(max = 40)
    @Column(name = "accountvalue")
    private String accountvalue;
    @Size(max = 40)
    @Column(name = "orgtrxvalue")
    private String orgtrxvalue;
    @Size(max = 40)
    @Column(name = "productvalue")
    private String productvalue;
    @Size(max = 30)
    @Column(name = "upc")
    private String upc;
    @Size(max = 30)
    @Column(name = "sku")
    private String sku;
    @Size(max = 40)
    @Column(name = "bpartnervalue")
    private String bpartnervalue;
    @Size(max = 40)
    @Column(name = "projectvalue")
    private String projectvalue;
    @Size(max = 32)
    @Column(name = "user1_id")
    private String user1Id;
    @Size(max = 32)
    @Column(name = "user2_id")
    private String user2Id;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "c_locfrom_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLocfromId;
    @JoinColumn(name = "ad_orgtrx_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgtrxId;
    @JoinColumn(name = "gl_journal_id", referencedColumnName = "gl_journal_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private GlJournal glJournalId;
    @JoinColumn(name = "gl_journalline_id", referencedColumnName = "gl_journalline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private GlJournalline glJournallineId;
    @JoinColumn(name = "ad_orgdoc_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgdocId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "c_validcombination_id", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CValidcombination cValidcombinationId;
    @JoinColumn(name = "c_locto_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLoctoId;
    @JoinColumn(name = "c_period_id", referencedColumnName = "c_period_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPeriod cPeriodId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_salesregion_id", referencedColumnName = "c_salesregion_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CSalesregion cSalesregionId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "gl_category_id", referencedColumnName = "gl_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private GlCategory glCategoryId;
    @JoinColumn(name = "gl_journalbatch_id", referencedColumnName = "gl_journalbatch_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private GlJournalbatch glJournalbatchId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDoctype cDoctypeId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "account_id", referencedColumnName = "c_elementvalue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CElementvalue accountId;

    public IGljournal() {
    }

    public IGljournal(String iGljournalId) {
        this.iGljournalId = iGljournalId;
    }

    public String getIGljournalId() {
        return iGljournalId;
    }

    public void setIGljournalId(String iGljournalId) {
        this.iGljournalId = iGljournalId;
    }

    public String getClientvalue() {
        return clientvalue;
    }

    public void setClientvalue(String clientvalue) {
        this.clientvalue = clientvalue;
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

    public Character getIIsimported() {
        return iIsimported;
    }

    public void setIIsimported(Character iIsimported) {
        this.iIsimported = iIsimported;
    }

    public String getIErrormsg() {
        return iErrormsg;
    }

    public void setIErrormsg(String iErrormsg) {
        this.iErrormsg = iErrormsg;
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

    public String getBatchdocumentno() {
        return batchdocumentno;
    }

    public void setBatchdocumentno(String batchdocumentno) {
        this.batchdocumentno = batchdocumentno;
    }

    public String getBatchdescription() {
        return batchdescription;
    }

    public void setBatchdescription(String batchdescription) {
        this.batchdescription = batchdescription;
    }

    public String getJournaldocumentno() {
        return journaldocumentno;
    }

    public void setJournaldocumentno(String journaldocumentno) {
        this.journaldocumentno = journaldocumentno;
    }

    public String getPostingtype() {
        return postingtype;
    }

    public void setPostingtype(String postingtype) {
        this.postingtype = postingtype;
    }

    public String getAcctschemaname() {
        return acctschemaname;
    }

    public void setAcctschemaname(String acctschemaname) {
        this.acctschemaname = acctschemaname;
    }

    public String getDoctypename() {
        return doctypename;
    }

    public void setDoctypename(String doctypename) {
        this.doctypename = doctypename;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getGlBudgetId() {
        return glBudgetId;
    }

    public void setGlBudgetId(String glBudgetId) {
        this.glBudgetId = glBudgetId;
    }

    public Long getLine() {
        return line;
    }

    public void setLine(Long line) {
        this.line = line;
    }

    public Date getDateacct() {
        return dateacct;
    }

    public void setDateacct(Date dateacct) {
        this.dateacct = dateacct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getAmtsourcedr() {
        return amtsourcedr;
    }

    public void setAmtsourcedr(BigInteger amtsourcedr) {
        this.amtsourcedr = amtsourcedr;
    }

    public BigInteger getAmtacctdr() {
        return amtacctdr;
    }

    public void setAmtacctdr(BigInteger amtacctdr) {
        this.amtacctdr = amtacctdr;
    }

    public BigInteger getAmtsourcecr() {
        return amtsourcecr;
    }

    public void setAmtsourcecr(BigInteger amtsourcecr) {
        this.amtsourcecr = amtsourcecr;
    }

    public BigInteger getAmtacctcr() {
        return amtacctcr;
    }

    public void setAmtacctcr(BigInteger amtacctcr) {
        this.amtacctcr = amtacctcr;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
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

    public BigInteger getQty() {
        return qty;
    }

    public void setQty(BigInteger qty) {
        this.qty = qty;
    }

    public String getOrgvalue() {
        return orgvalue;
    }

    public void setOrgvalue(String orgvalue) {
        this.orgvalue = orgvalue;
    }

    public String getAccountvalue() {
        return accountvalue;
    }

    public void setAccountvalue(String accountvalue) {
        this.accountvalue = accountvalue;
    }

    public String getOrgtrxvalue() {
        return orgtrxvalue;
    }

    public void setOrgtrxvalue(String orgtrxvalue) {
        this.orgtrxvalue = orgtrxvalue;
    }

    public String getProductvalue() {
        return productvalue;
    }

    public void setProductvalue(String productvalue) {
        this.productvalue = productvalue;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBpartnervalue() {
        return bpartnervalue;
    }

    public void setBpartnervalue(String bpartnervalue) {
        this.bpartnervalue = bpartnervalue;
    }

    public String getProjectvalue() {
        return projectvalue;
    }

    public void setProjectvalue(String projectvalue) {
        this.projectvalue = projectvalue;
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

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public CLocation getCLocfromId() {
        return cLocfromId;
    }

    public void setCLocfromId(CLocation cLocfromId) {
        this.cLocfromId = cLocfromId;
    }

    public AdOrg getAdOrgtrxId() {
        return adOrgtrxId;
    }

    public void setAdOrgtrxId(AdOrg adOrgtrxId) {
        this.adOrgtrxId = adOrgtrxId;
    }

    public GlJournal getGlJournalId() {
        return glJournalId;
    }

    public void setGlJournalId(GlJournal glJournalId) {
        this.glJournalId = glJournalId;
    }

    public GlJournalline getGlJournallineId() {
        return glJournallineId;
    }

    public void setGlJournallineId(GlJournalline glJournallineId) {
        this.glJournallineId = glJournallineId;
    }

    public AdOrg getAdOrgdocId() {
        return adOrgdocId;
    }

    public void setAdOrgdocId(AdOrg adOrgdocId) {
        this.adOrgdocId = adOrgdocId;
    }

    public CAcctschema getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(CAcctschema cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
    }

    public CActivity getCActivityId() {
        return cActivityId;
    }

    public void setCActivityId(CActivity cActivityId) {
        this.cActivityId = cActivityId;
    }

    public CValidcombination getCValidcombinationId() {
        return cValidcombinationId;
    }

    public void setCValidcombinationId(CValidcombination cValidcombinationId) {
        this.cValidcombinationId = cValidcombinationId;
    }

    public CLocation getCLoctoId() {
        return cLoctoId;
    }

    public void setCLoctoId(CLocation cLoctoId) {
        this.cLoctoId = cLoctoId;
    }

    public CPeriod getCPeriodId() {
        return cPeriodId;
    }

    public void setCPeriodId(CPeriod cPeriodId) {
        this.cPeriodId = cPeriodId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CSalesregion getCSalesregionId() {
        return cSalesregionId;
    }

    public void setCSalesregionId(CSalesregion cSalesregionId) {
        this.cSalesregionId = cSalesregionId;
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

    public CDoctype getCDoctypeId() {
        return cDoctypeId;
    }

    public void setCDoctypeId(CDoctype cDoctypeId) {
        this.cDoctypeId = cDoctypeId;
    }

    public CUom getCUomId() {
        return cUomId;
    }

    public void setCUomId(CUom cUomId) {
        this.cUomId = cUomId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public CElementvalue getAccountId() {
        return accountId;
    }

    public void setAccountId(CElementvalue accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iGljournalId != null ? iGljournalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IGljournal)) {
            return false;
        }
        IGljournal other = (IGljournal) object;
        if ((this.iGljournalId == null && other.iGljournalId != null) || (this.iGljournalId != null && !this.iGljournalId.equals(other.iGljournalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.IGljournal[ iGljournalId=" + iGljournalId + " ]";
    }
    
}
