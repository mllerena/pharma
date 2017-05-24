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
@Table(name = "i_budgetline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IBudgetline.findAll", query = "SELECT i FROM IBudgetline i"),
    @NamedQuery(name = "IBudgetline.findByIBudgetlineId", query = "SELECT i FROM IBudgetline i WHERE i.iBudgetlineId = :iBudgetlineId"),
    @NamedQuery(name = "IBudgetline.findByIsactive", query = "SELECT i FROM IBudgetline i WHERE i.isactive = :isactive"),
    @NamedQuery(name = "IBudgetline.findByCreated", query = "SELECT i FROM IBudgetline i WHERE i.created = :created"),
    @NamedQuery(name = "IBudgetline.findByCreatedby", query = "SELECT i FROM IBudgetline i WHERE i.createdby = :createdby"),
    @NamedQuery(name = "IBudgetline.findByUpdated", query = "SELECT i FROM IBudgetline i WHERE i.updated = :updated"),
    @NamedQuery(name = "IBudgetline.findByUpdatedby", query = "SELECT i FROM IBudgetline i WHERE i.updatedby = :updatedby"),
    @NamedQuery(name = "IBudgetline.findByElementvalueident", query = "SELECT i FROM IBudgetline i WHERE i.elementvalueident = :elementvalueident"),
    @NamedQuery(name = "IBudgetline.findByPeriodident", query = "SELECT i FROM IBudgetline i WHERE i.periodident = :periodident"),
    @NamedQuery(name = "IBudgetline.findByProductident", query = "SELECT i FROM IBudgetline i WHERE i.productident = :productident"),
    @NamedQuery(name = "IBudgetline.findByPartnerident", query = "SELECT i FROM IBudgetline i WHERE i.partnerident = :partnerident"),
    @NamedQuery(name = "IBudgetline.findByOrgtrxident", query = "SELECT i FROM IBudgetline i WHERE i.orgtrxident = :orgtrxident"),
    @NamedQuery(name = "IBudgetline.findBySalesregionident", query = "SELECT i FROM IBudgetline i WHERE i.salesregionident = :salesregionident"),
    @NamedQuery(name = "IBudgetline.findByProjectident", query = "SELECT i FROM IBudgetline i WHERE i.projectident = :projectident"),
    @NamedQuery(name = "IBudgetline.findByCampaignident", query = "SELECT i FROM IBudgetline i WHERE i.campaignident = :campaignident"),
    @NamedQuery(name = "IBudgetline.findByActivityident", query = "SELECT i FROM IBudgetline i WHERE i.activityident = :activityident"),
    @NamedQuery(name = "IBudgetline.findByDescription", query = "SELECT i FROM IBudgetline i WHERE i.description = :description"),
    @NamedQuery(name = "IBudgetline.findBySeqno", query = "SELECT i FROM IBudgetline i WHERE i.seqno = :seqno"),
    @NamedQuery(name = "IBudgetline.findByBpgroupident", query = "SELECT i FROM IBudgetline i WHERE i.bpgroupident = :bpgroupident"),
    @NamedQuery(name = "IBudgetline.findByProdcategoryident", query = "SELECT i FROM IBudgetline i WHERE i.prodcategoryident = :prodcategoryident"),
    @NamedQuery(name = "IBudgetline.findByQty", query = "SELECT i FROM IBudgetline i WHERE i.qty = :qty"),
    @NamedQuery(name = "IBudgetline.findByPrice", query = "SELECT i FROM IBudgetline i WHERE i.price = :price"),
    @NamedQuery(name = "IBudgetline.findByAmount", query = "SELECT i FROM IBudgetline i WHERE i.amount = :amount"),
    @NamedQuery(name = "IBudgetline.findByProcessing", query = "SELECT i FROM IBudgetline i WHERE i.processing = :processing"),
    @NamedQuery(name = "IBudgetline.findByProcessed", query = "SELECT i FROM IBudgetline i WHERE i.processed = :processed"),
    @NamedQuery(name = "IBudgetline.findByIErrormsg", query = "SELECT i FROM IBudgetline i WHERE i.iErrormsg = :iErrormsg"),
    @NamedQuery(name = "IBudgetline.findByIIsimported", query = "SELECT i FROM IBudgetline i WHERE i.iIsimported = :iIsimported"),
    @NamedQuery(name = "IBudgetline.findByCurrencyident", query = "SELECT i FROM IBudgetline i WHERE i.currencyident = :currencyident"),
    @NamedQuery(name = "IBudgetline.findByAcctschemaident", query = "SELECT i FROM IBudgetline i WHERE i.acctschemaident = :acctschemaident")})
public class IBudgetline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "i_budgetline_id")
    private String iBudgetlineId;
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
    @Size(max = 100)
    @Column(name = "elementvalueident")
    private String elementvalueident;
    @Size(max = 100)
    @Column(name = "periodident")
    private String periodident;
    @Size(max = 100)
    @Column(name = "productident")
    private String productident;
    @Size(max = 100)
    @Column(name = "partnerident")
    private String partnerident;
    @Size(max = 100)
    @Column(name = "orgtrxident")
    private String orgtrxident;
    @Size(max = 100)
    @Column(name = "salesregionident")
    private String salesregionident;
    @Size(max = 100)
    @Column(name = "projectident")
    private String projectident;
    @Size(max = 100)
    @Column(name = "campaignident")
    private String campaignident;
    @Size(max = 100)
    @Column(name = "activityident")
    private String activityident;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "seqno")
    private Long seqno;
    @Size(max = 100)
    @Column(name = "bpgroupident")
    private String bpgroupident;
    @Size(max = 100)
    @Column(name = "prodcategoryident")
    private String prodcategoryident;
    @Column(name = "qty")
    private BigInteger qty;
    @Column(name = "price")
    private BigInteger price;
    @Column(name = "amount")
    private BigInteger amount;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "processed")
    private Character processed;
    @Size(max = 2000)
    @Column(name = "i_errormsg")
    private String iErrormsg;
    @Column(name = "i_isimported")
    private Character iIsimported;
    @Size(max = 10)
    @Column(name = "currencyident")
    private String currencyident;
    @Size(max = 100)
    @Column(name = "acctschemaident")
    private String acctschemaident;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_orgtrx_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgtrxId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "c_salesregion_id", referencedColumnName = "c_salesregion_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CSalesregion cSalesregionId;
    @JoinColumn(name = "c_bp_group_id", referencedColumnName = "c_bp_group_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpGroup cBpGroupId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_period_id", referencedColumnName = "c_period_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPeriod cPeriodId;
    @JoinColumn(name = "c_budget_id", referencedColumnName = "c_budget_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBudget cBudgetId;
    @JoinColumn(name = "m_product_category_id", referencedColumnName = "m_product_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductCategory mProductCategoryId;
    @JoinColumn(name = "c_elementvalue_id", referencedColumnName = "c_elementvalue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CElementvalue cElementvalueId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "c_budgetline_id", referencedColumnName = "c_budgetline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBudgetline cBudgetlineId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;

    public IBudgetline() {
    }

    public IBudgetline(String iBudgetlineId) {
        this.iBudgetlineId = iBudgetlineId;
    }

    public String getIBudgetlineId() {
        return iBudgetlineId;
    }

    public void setIBudgetlineId(String iBudgetlineId) {
        this.iBudgetlineId = iBudgetlineId;
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

    public String getElementvalueident() {
        return elementvalueident;
    }

    public void setElementvalueident(String elementvalueident) {
        this.elementvalueident = elementvalueident;
    }

    public String getPeriodident() {
        return periodident;
    }

    public void setPeriodident(String periodident) {
        this.periodident = periodident;
    }

    public String getProductident() {
        return productident;
    }

    public void setProductident(String productident) {
        this.productident = productident;
    }

    public String getPartnerident() {
        return partnerident;
    }

    public void setPartnerident(String partnerident) {
        this.partnerident = partnerident;
    }

    public String getOrgtrxident() {
        return orgtrxident;
    }

    public void setOrgtrxident(String orgtrxident) {
        this.orgtrxident = orgtrxident;
    }

    public String getSalesregionident() {
        return salesregionident;
    }

    public void setSalesregionident(String salesregionident) {
        this.salesregionident = salesregionident;
    }

    public String getProjectident() {
        return projectident;
    }

    public void setProjectident(String projectident) {
        this.projectident = projectident;
    }

    public String getCampaignident() {
        return campaignident;
    }

    public void setCampaignident(String campaignident) {
        this.campaignident = campaignident;
    }

    public String getActivityident() {
        return activityident;
    }

    public void setActivityident(String activityident) {
        this.activityident = activityident;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSeqno() {
        return seqno;
    }

    public void setSeqno(Long seqno) {
        this.seqno = seqno;
    }

    public String getBpgroupident() {
        return bpgroupident;
    }

    public void setBpgroupident(String bpgroupident) {
        this.bpgroupident = bpgroupident;
    }

    public String getProdcategoryident() {
        return prodcategoryident;
    }

    public void setProdcategoryident(String prodcategoryident) {
        this.prodcategoryident = prodcategoryident;
    }

    public BigInteger getQty() {
        return qty;
    }

    public void setQty(BigInteger qty) {
        this.qty = qty;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
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

    public String getIErrormsg() {
        return iErrormsg;
    }

    public void setIErrormsg(String iErrormsg) {
        this.iErrormsg = iErrormsg;
    }

    public Character getIIsimported() {
        return iIsimported;
    }

    public void setIIsimported(Character iIsimported) {
        this.iIsimported = iIsimported;
    }

    public String getCurrencyident() {
        return currencyident;
    }

    public void setCurrencyident(String currencyident) {
        this.currencyident = currencyident;
    }

    public String getAcctschemaident() {
        return acctschemaident;
    }

    public void setAcctschemaident(String acctschemaident) {
        this.acctschemaident = acctschemaident;
    }

    public CAcctschema getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(CAcctschema cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
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

    public AdOrg getAdOrgtrxId() {
        return adOrgtrxId;
    }

    public void setAdOrgtrxId(AdOrg adOrgtrxId) {
        this.adOrgtrxId = adOrgtrxId;
    }

    public CActivity getCActivityId() {
        return cActivityId;
    }

    public void setCActivityId(CActivity cActivityId) {
        this.cActivityId = cActivityId;
    }

    public CSalesregion getCSalesregionId() {
        return cSalesregionId;
    }

    public void setCSalesregionId(CSalesregion cSalesregionId) {
        this.cSalesregionId = cSalesregionId;
    }

    public CBpGroup getCBpGroupId() {
        return cBpGroupId;
    }

    public void setCBpGroupId(CBpGroup cBpGroupId) {
        this.cBpGroupId = cBpGroupId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CPeriod getCPeriodId() {
        return cPeriodId;
    }

    public void setCPeriodId(CPeriod cPeriodId) {
        this.cPeriodId = cPeriodId;
    }

    public CBudget getCBudgetId() {
        return cBudgetId;
    }

    public void setCBudgetId(CBudget cBudgetId) {
        this.cBudgetId = cBudgetId;
    }

    public MProductCategory getMProductCategoryId() {
        return mProductCategoryId;
    }

    public void setMProductCategoryId(MProductCategory mProductCategoryId) {
        this.mProductCategoryId = mProductCategoryId;
    }

    public CElementvalue getCElementvalueId() {
        return cElementvalueId;
    }

    public void setCElementvalueId(CElementvalue cElementvalueId) {
        this.cElementvalueId = cElementvalueId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
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

    public CBudgetline getCBudgetlineId() {
        return cBudgetlineId;
    }

    public void setCBudgetlineId(CBudgetline cBudgetlineId) {
        this.cBudgetlineId = cBudgetlineId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iBudgetlineId != null ? iBudgetlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IBudgetline)) {
            return false;
        }
        IBudgetline other = (IBudgetline) object;
        if ((this.iBudgetlineId == null && other.iBudgetlineId != null) || (this.iBudgetlineId != null && !this.iBudgetlineId.equals(other.iBudgetlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.IBudgetline[ iBudgetlineId=" + iBudgetlineId + " ]";
    }
    
}
