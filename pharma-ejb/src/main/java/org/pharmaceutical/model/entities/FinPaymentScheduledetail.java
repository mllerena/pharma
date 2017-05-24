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
@Table(name = "fin_payment_scheduledetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinPaymentScheduledetail.findAll", query = "SELECT f FROM FinPaymentScheduledetail f"),
    @NamedQuery(name = "FinPaymentScheduledetail.findByFinPaymentScheduledetailId", query = "SELECT f FROM FinPaymentScheduledetail f WHERE f.finPaymentScheduledetailId = :finPaymentScheduledetailId"),
    @NamedQuery(name = "FinPaymentScheduledetail.findByCreated", query = "SELECT f FROM FinPaymentScheduledetail f WHERE f.created = :created"),
    @NamedQuery(name = "FinPaymentScheduledetail.findByCreatedby", query = "SELECT f FROM FinPaymentScheduledetail f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinPaymentScheduledetail.findByUpdated", query = "SELECT f FROM FinPaymentScheduledetail f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinPaymentScheduledetail.findByUpdatedby", query = "SELECT f FROM FinPaymentScheduledetail f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinPaymentScheduledetail.findByAmount", query = "SELECT f FROM FinPaymentScheduledetail f WHERE f.amount = :amount"),
    @NamedQuery(name = "FinPaymentScheduledetail.findByIsactive", query = "SELECT f FROM FinPaymentScheduledetail f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinPaymentScheduledetail.findByWriteoffamt", query = "SELECT f FROM FinPaymentScheduledetail f WHERE f.writeoffamt = :writeoffamt"),
    @NamedQuery(name = "FinPaymentScheduledetail.findByIscanceled", query = "SELECT f FROM FinPaymentScheduledetail f WHERE f.iscanceled = :iscanceled")})
public class FinPaymentScheduledetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_payment_scheduledetail_id")
    private String finPaymentScheduledetailId;
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
    @Column(name = "amount")
    private BigInteger amount;
    @Column(name = "isactive")
    private Character isactive;
    @Column(name = "writeoffamt")
    private BigInteger writeoffamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iscanceled")
    private Character iscanceled;
    @JoinColumn(name = "fin_payment_schedule_invoice", referencedColumnName = "fin_payment_schedule_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPaymentSchedule finPaymentScheduleInvoice;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "c_salesregion_id", referencedColumnName = "c_salesregion_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CSalesregion cSalesregionId;
    @JoinColumn(name = "fin_payment_detail_id", referencedColumnName = "fin_payment_detail_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPaymentDetail finPaymentDetailId;
    @JoinColumn(name = "fin_payment_schedule_order", referencedColumnName = "fin_payment_schedule_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private FinPaymentSchedule finPaymentScheduleOrder;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "finPaymentScheduledetailId")
    private List<FinReclineTemp> finReclineTempList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "finPaymentScheduledetailId")
    private List<FinPaymentPropDetail> finPaymentPropDetailList;

    public FinPaymentScheduledetail() {
    }

    public FinPaymentScheduledetail(String finPaymentScheduledetailId) {
        this.finPaymentScheduledetailId = finPaymentScheduledetailId;
    }

    public FinPaymentScheduledetail(String finPaymentScheduledetailId, Date created, String createdby, Date updated, String updatedby, BigInteger amount, Character iscanceled) {
        this.finPaymentScheduledetailId = finPaymentScheduledetailId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.amount = amount;
        this.iscanceled = iscanceled;
    }

    public String getFinPaymentScheduledetailId() {
        return finPaymentScheduledetailId;
    }

    public void setFinPaymentScheduledetailId(String finPaymentScheduledetailId) {
        this.finPaymentScheduledetailId = finPaymentScheduledetailId;
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

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }

    public BigInteger getWriteoffamt() {
        return writeoffamt;
    }

    public void setWriteoffamt(BigInteger writeoffamt) {
        this.writeoffamt = writeoffamt;
    }

    public Character getIscanceled() {
        return iscanceled;
    }

    public void setIscanceled(Character iscanceled) {
        this.iscanceled = iscanceled;
    }

    public FinPaymentSchedule getFinPaymentScheduleInvoice() {
        return finPaymentScheduleInvoice;
    }

    public void setFinPaymentScheduleInvoice(FinPaymentSchedule finPaymentScheduleInvoice) {
        this.finPaymentScheduleInvoice = finPaymentScheduleInvoice;
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

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public CSalesregion getCSalesregionId() {
        return cSalesregionId;
    }

    public void setCSalesregionId(CSalesregion cSalesregionId) {
        this.cSalesregionId = cSalesregionId;
    }

    public FinPaymentDetail getFinPaymentDetailId() {
        return finPaymentDetailId;
    }

    public void setFinPaymentDetailId(FinPaymentDetail finPaymentDetailId) {
        this.finPaymentDetailId = finPaymentDetailId;
    }

    public FinPaymentSchedule getFinPaymentScheduleOrder() {
        return finPaymentScheduleOrder;
    }

    public void setFinPaymentScheduleOrder(FinPaymentSchedule finPaymentScheduleOrder) {
        this.finPaymentScheduleOrder = finPaymentScheduleOrder;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @XmlTransient
    public List<FinReclineTemp> getFinReclineTempList() {
        return finReclineTempList;
    }

    public void setFinReclineTempList(List<FinReclineTemp> finReclineTempList) {
        this.finReclineTempList = finReclineTempList;
    }

    @XmlTransient
    public List<FinPaymentPropDetail> getFinPaymentPropDetailList() {
        return finPaymentPropDetailList;
    }

    public void setFinPaymentPropDetailList(List<FinPaymentPropDetail> finPaymentPropDetailList) {
        this.finPaymentPropDetailList = finPaymentPropDetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finPaymentScheduledetailId != null ? finPaymentScheduledetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinPaymentScheduledetail)) {
            return false;
        }
        FinPaymentScheduledetail other = (FinPaymentScheduledetail) object;
        if ((this.finPaymentScheduledetailId == null && other.finPaymentScheduledetailId != null) || (this.finPaymentScheduledetailId != null && !this.finPaymentScheduledetailId.equals(other.finPaymentScheduledetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinPaymentScheduledetail[ finPaymentScheduledetailId=" + finPaymentScheduledetailId + " ]";
    }
    
}
