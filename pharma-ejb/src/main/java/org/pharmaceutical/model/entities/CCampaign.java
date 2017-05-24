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
@Table(name = "c_campaign")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCampaign.findAll", query = "SELECT c FROM CCampaign c"),
    @NamedQuery(name = "CCampaign.findByCCampaignId", query = "SELECT c FROM CCampaign c WHERE c.cCampaignId = :cCampaignId"),
    @NamedQuery(name = "CCampaign.findByIsactive", query = "SELECT c FROM CCampaign c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCampaign.findByCreated", query = "SELECT c FROM CCampaign c WHERE c.created = :created"),
    @NamedQuery(name = "CCampaign.findByCreatedby", query = "SELECT c FROM CCampaign c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCampaign.findByUpdated", query = "SELECT c FROM CCampaign c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCampaign.findByUpdatedby", query = "SELECT c FROM CCampaign c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCampaign.findByValue", query = "SELECT c FROM CCampaign c WHERE c.value = :value"),
    @NamedQuery(name = "CCampaign.findByName", query = "SELECT c FROM CCampaign c WHERE c.name = :name"),
    @NamedQuery(name = "CCampaign.findByDescription", query = "SELECT c FROM CCampaign c WHERE c.description = :description"),
    @NamedQuery(name = "CCampaign.findByStartdate", query = "SELECT c FROM CCampaign c WHERE c.startdate = :startdate"),
    @NamedQuery(name = "CCampaign.findByEnddate", query = "SELECT c FROM CCampaign c WHERE c.enddate = :enddate"),
    @NamedQuery(name = "CCampaign.findByCosts", query = "SELECT c FROM CCampaign c WHERE c.costs = :costs"),
    @NamedQuery(name = "CCampaign.findByIssummary", query = "SELECT c FROM CCampaign c WHERE c.issummary = :issummary")})
public class CCampaign implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_campaign_id")
    private String cCampaignId;
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
    @Size(min = 1, max = 40)
    @Column(name = "value")
    private String value;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "costs")
    private BigInteger costs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issummary")
    private Character issummary;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_channel_id", referencedColumnName = "c_channel_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CChannel cChannelId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<IInvoice> iInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<MProduction> mProductionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<MInventory> mInventoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<FinPaymentScheduledetail> finPaymentScheduledetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<CSettlement> cSettlementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<CInvoice> cInvoiceList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<STimeexpenseline> sTimeexpenselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<CInvoicelineAcctdimension> cInvoicelineAcctdimensionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<CDpManagement> cDpManagementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<CValidcombination> cValidcombinationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<FinPayment> finPaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<IBudgetline> iBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<MMovement> mMovementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<GlJournalline> glJournallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<FinFinaccTransaction> finFinaccTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<AAmortization> aAmortizationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<CBudgetline> cBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<CAcctschemaElement> cAcctschemaElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<GlJournal> glJournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<RRequest> rRequestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<MInout> mInoutList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<CProject> cProjectList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cCampaignId")
    private List<CCash> cCashList;

    public CCampaign() {
    }

    public CCampaign(String cCampaignId) {
        this.cCampaignId = cCampaignId;
    }

    public CCampaign(String cCampaignId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name, BigInteger costs, Character issummary) {
        this.cCampaignId = cCampaignId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
        this.costs = costs;
        this.issummary = issummary;
    }

    public String getCCampaignId() {
        return cCampaignId;
    }

    public void setCCampaignId(String cCampaignId) {
        this.cCampaignId = cCampaignId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public BigInteger getCosts() {
        return costs;
    }

    public void setCosts(BigInteger costs) {
        this.costs = costs;
    }

    public Character getIssummary() {
        return issummary;
    }

    public void setIssummary(Character issummary) {
        this.issummary = issummary;
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

    public CChannel getCChannelId() {
        return cChannelId;
    }

    public void setCChannelId(CChannel cChannelId) {
        this.cChannelId = cChannelId;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
    }

    @XmlTransient
    public List<MProduction> getMProductionList() {
        return mProductionList;
    }

    public void setMProductionList(List<MProduction> mProductionList) {
        this.mProductionList = mProductionList;
    }

    @XmlTransient
    public List<MInventory> getMInventoryList() {
        return mInventoryList;
    }

    public void setMInventoryList(List<MInventory> mInventoryList) {
        this.mInventoryList = mInventoryList;
    }

    @XmlTransient
    public List<FinPaymentScheduledetail> getFinPaymentScheduledetailList() {
        return finPaymentScheduledetailList;
    }

    public void setFinPaymentScheduledetailList(List<FinPaymentScheduledetail> finPaymentScheduledetailList) {
        this.finPaymentScheduledetailList = finPaymentScheduledetailList;
    }

    @XmlTransient
    public List<CSettlement> getCSettlementList() {
        return cSettlementList;
    }

    public void setCSettlementList(List<CSettlement> cSettlementList) {
        this.cSettlementList = cSettlementList;
    }

    @XmlTransient
    public List<CInvoice> getCInvoiceList() {
        return cInvoiceList;
    }

    public void setCInvoiceList(List<CInvoice> cInvoiceList) {
        this.cInvoiceList = cInvoiceList;
    }

    @XmlTransient
    public List<STimeexpenseline> getSTimeexpenselineList() {
        return sTimeexpenselineList;
    }

    public void setSTimeexpenselineList(List<STimeexpenseline> sTimeexpenselineList) {
        this.sTimeexpenselineList = sTimeexpenselineList;
    }

    @XmlTransient
    public List<IGljournal> getIGljournalList() {
        return iGljournalList;
    }

    public void setIGljournalList(List<IGljournal> iGljournalList) {
        this.iGljournalList = iGljournalList;
    }

    @XmlTransient
    public List<CInvoicelineAcctdimension> getCInvoicelineAcctdimensionList() {
        return cInvoicelineAcctdimensionList;
    }

    public void setCInvoicelineAcctdimensionList(List<CInvoicelineAcctdimension> cInvoicelineAcctdimensionList) {
        this.cInvoicelineAcctdimensionList = cInvoicelineAcctdimensionList;
    }

    @XmlTransient
    public List<COrder> getCOrderList() {
        return cOrderList;
    }

    public void setCOrderList(List<COrder> cOrderList) {
        this.cOrderList = cOrderList;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<CDpManagement> getCDpManagementList() {
        return cDpManagementList;
    }

    public void setCDpManagementList(List<CDpManagement> cDpManagementList) {
        this.cDpManagementList = cDpManagementList;
    }

    @XmlTransient
    public List<CValidcombination> getCValidcombinationList() {
        return cValidcombinationList;
    }

    public void setCValidcombinationList(List<CValidcombination> cValidcombinationList) {
        this.cValidcombinationList = cValidcombinationList;
    }

    @XmlTransient
    public List<FinPayment> getFinPaymentList() {
        return finPaymentList;
    }

    public void setFinPaymentList(List<FinPayment> finPaymentList) {
        this.finPaymentList = finPaymentList;
    }

    @XmlTransient
    public List<IBudgetline> getIBudgetlineList() {
        return iBudgetlineList;
    }

    public void setIBudgetlineList(List<IBudgetline> iBudgetlineList) {
        this.iBudgetlineList = iBudgetlineList;
    }

    @XmlTransient
    public List<FactAcct> getFactAcctList() {
        return factAcctList;
    }

    public void setFactAcctList(List<FactAcct> factAcctList) {
        this.factAcctList = factAcctList;
    }

    @XmlTransient
    public List<MMovement> getMMovementList() {
        return mMovementList;
    }

    public void setMMovementList(List<MMovement> mMovementList) {
        this.mMovementList = mMovementList;
    }

    @XmlTransient
    public List<GlJournalline> getGlJournallineList() {
        return glJournallineList;
    }

    public void setGlJournallineList(List<GlJournalline> glJournallineList) {
        this.glJournallineList = glJournallineList;
    }

    @XmlTransient
    public List<FinFinaccTransaction> getFinFinaccTransactionList() {
        return finFinaccTransactionList;
    }

    public void setFinFinaccTransactionList(List<FinFinaccTransaction> finFinaccTransactionList) {
        this.finFinaccTransactionList = finFinaccTransactionList;
    }

    @XmlTransient
    public List<AAmortization> getAAmortizationList() {
        return aAmortizationList;
    }

    public void setAAmortizationList(List<AAmortization> aAmortizationList) {
        this.aAmortizationList = aAmortizationList;
    }

    @XmlTransient
    public List<CBudgetline> getCBudgetlineList() {
        return cBudgetlineList;
    }

    public void setCBudgetlineList(List<CBudgetline> cBudgetlineList) {
        this.cBudgetlineList = cBudgetlineList;
    }

    @XmlTransient
    public List<CAcctschemaElement> getCAcctschemaElementList() {
        return cAcctschemaElementList;
    }

    public void setCAcctschemaElementList(List<CAcctschemaElement> cAcctschemaElementList) {
        this.cAcctschemaElementList = cAcctschemaElementList;
    }

    @XmlTransient
    public List<GlJournal> getGlJournalList() {
        return glJournalList;
    }

    public void setGlJournalList(List<GlJournal> glJournalList) {
        this.glJournalList = glJournalList;
    }

    @XmlTransient
    public List<RRequest> getRRequestList() {
        return rRequestList;
    }

    public void setRRequestList(List<RRequest> rRequestList) {
        this.rRequestList = rRequestList;
    }

    @XmlTransient
    public List<MInout> getMInoutList() {
        return mInoutList;
    }

    public void setMInoutList(List<MInout> mInoutList) {
        this.mInoutList = mInoutList;
    }

    @XmlTransient
    public List<CProject> getCProjectList() {
        return cProjectList;
    }

    public void setCProjectList(List<CProject> cProjectList) {
        this.cProjectList = cProjectList;
    }

    @XmlTransient
    public List<CCash> getCCashList() {
        return cCashList;
    }

    public void setCCashList(List<CCash> cCashList) {
        this.cCashList = cCashList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCampaignId != null ? cCampaignId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCampaign)) {
            return false;
        }
        CCampaign other = (CCampaign) object;
        if ((this.cCampaignId == null && other.cCampaignId != null) || (this.cCampaignId != null && !this.cCampaignId.equals(other.cCampaignId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCampaign[ cCampaignId=" + cCampaignId + " ]";
    }
    
}
