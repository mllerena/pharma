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
@Table(name = "s_timeexpenseline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "STimeexpenseline.findAll", query = "SELECT s FROM STimeexpenseline s"),
    @NamedQuery(name = "STimeexpenseline.findBySTimeexpenselineId", query = "SELECT s FROM STimeexpenseline s WHERE s.sTimeexpenselineId = :sTimeexpenselineId"),
    @NamedQuery(name = "STimeexpenseline.findByIsactive", query = "SELECT s FROM STimeexpenseline s WHERE s.isactive = :isactive"),
    @NamedQuery(name = "STimeexpenseline.findByCreated", query = "SELECT s FROM STimeexpenseline s WHERE s.created = :created"),
    @NamedQuery(name = "STimeexpenseline.findByCreatedby", query = "SELECT s FROM STimeexpenseline s WHERE s.createdby = :createdby"),
    @NamedQuery(name = "STimeexpenseline.findByUpdated", query = "SELECT s FROM STimeexpenseline s WHERE s.updated = :updated"),
    @NamedQuery(name = "STimeexpenseline.findByUpdatedby", query = "SELECT s FROM STimeexpenseline s WHERE s.updatedby = :updatedby"),
    @NamedQuery(name = "STimeexpenseline.findByLine", query = "SELECT s FROM STimeexpenseline s WHERE s.line = :line"),
    @NamedQuery(name = "STimeexpenseline.findByIstimereport", query = "SELECT s FROM STimeexpenseline s WHERE s.istimereport = :istimereport"),
    @NamedQuery(name = "STimeexpenseline.findByDateexpense", query = "SELECT s FROM STimeexpenseline s WHERE s.dateexpense = :dateexpense"),
    @NamedQuery(name = "STimeexpenseline.findByQty", query = "SELECT s FROM STimeexpenseline s WHERE s.qty = :qty"),
    @NamedQuery(name = "STimeexpenseline.findByExpenseamt", query = "SELECT s FROM STimeexpenseline s WHERE s.expenseamt = :expenseamt"),
    @NamedQuery(name = "STimeexpenseline.findByConvertedamt", query = "SELECT s FROM STimeexpenseline s WHERE s.convertedamt = :convertedamt"),
    @NamedQuery(name = "STimeexpenseline.findByDescription", query = "SELECT s FROM STimeexpenseline s WHERE s.description = :description"),
    @NamedQuery(name = "STimeexpenseline.findByNote", query = "SELECT s FROM STimeexpenseline s WHERE s.note = :note"),
    @NamedQuery(name = "STimeexpenseline.findByIsinvoiced", query = "SELECT s FROM STimeexpenseline s WHERE s.isinvoiced = :isinvoiced"),
    @NamedQuery(name = "STimeexpenseline.findByInvoiceprice", query = "SELECT s FROM STimeexpenseline s WHERE s.invoiceprice = :invoiceprice")})
public class STimeexpenseline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "s_timeexpenseline_id")
    private String sTimeexpenselineId;
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
    @Column(name = "line")
    private long line;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istimereport")
    private Character istimereport;
    @Column(name = "dateexpense")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateexpense;
    @Column(name = "qty")
    private BigInteger qty;
    @Column(name = "expenseamt")
    private BigInteger expenseamt;
    @Column(name = "convertedamt")
    private BigInteger convertedamt;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isinvoiced")
    private Character isinvoiced;
    @Column(name = "invoiceprice")
    private BigInteger invoiceprice;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "sTimeexpenselineId")
    private List<CProjectissue> cProjectissueList;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "s_resourceassignment_id", referencedColumnName = "s_resourceassignment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private SResourceassignment sResourceassignmentId;
    @JoinColumn(name = "s_timeexpense_id", referencedColumnName = "s_timeexpense_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private STimeexpense sTimeexpenseId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_invoiceline_id", referencedColumnName = "c_invoiceline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoiceline cInvoicelineId;
    @JoinColumn(name = "s_timetype_id", referencedColumnName = "s_timetype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private STimetype sTimetypeId;
    @JoinColumn(name = "c_orderline_id", referencedColumnName = "c_orderline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrderline cOrderlineId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomId;
    @JoinColumn(name = "c_projectphase_id", referencedColumnName = "c_projectphase_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProjectphase cProjectphaseId;
    @JoinColumn(name = "c_projecttask_id", referencedColumnName = "c_projecttask_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProjecttask cProjecttaskId;

    public STimeexpenseline() {
    }

    public STimeexpenseline(String sTimeexpenselineId) {
        this.sTimeexpenselineId = sTimeexpenselineId;
    }

    public STimeexpenseline(String sTimeexpenselineId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, Character istimereport, Character isinvoiced) {
        this.sTimeexpenselineId = sTimeexpenselineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.istimereport = istimereport;
        this.isinvoiced = isinvoiced;
    }

    public String getSTimeexpenselineId() {
        return sTimeexpenselineId;
    }

    public void setSTimeexpenselineId(String sTimeexpenselineId) {
        this.sTimeexpenselineId = sTimeexpenselineId;
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

    public long getLine() {
        return line;
    }

    public void setLine(long line) {
        this.line = line;
    }

    public Character getIstimereport() {
        return istimereport;
    }

    public void setIstimereport(Character istimereport) {
        this.istimereport = istimereport;
    }

    public Date getDateexpense() {
        return dateexpense;
    }

    public void setDateexpense(Date dateexpense) {
        this.dateexpense = dateexpense;
    }

    public BigInteger getQty() {
        return qty;
    }

    public void setQty(BigInteger qty) {
        this.qty = qty;
    }

    public BigInteger getExpenseamt() {
        return expenseamt;
    }

    public void setExpenseamt(BigInteger expenseamt) {
        this.expenseamt = expenseamt;
    }

    public BigInteger getConvertedamt() {
        return convertedamt;
    }

    public void setConvertedamt(BigInteger convertedamt) {
        this.convertedamt = convertedamt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Character getIsinvoiced() {
        return isinvoiced;
    }

    public void setIsinvoiced(Character isinvoiced) {
        this.isinvoiced = isinvoiced;
    }

    public BigInteger getInvoiceprice() {
        return invoiceprice;
    }

    public void setInvoiceprice(BigInteger invoiceprice) {
        this.invoiceprice = invoiceprice;
    }

    @XmlTransient
    public List<CProjectissue> getCProjectissueList() {
        return cProjectissueList;
    }

    public void setCProjectissueList(List<CProjectissue> cProjectissueList) {
        this.cProjectissueList = cProjectissueList;
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

    public CActivity getCActivityId() {
        return cActivityId;
    }

    public void setCActivityId(CActivity cActivityId) {
        this.cActivityId = cActivityId;
    }

    public SResourceassignment getSResourceassignmentId() {
        return sResourceassignmentId;
    }

    public void setSResourceassignmentId(SResourceassignment sResourceassignmentId) {
        this.sResourceassignmentId = sResourceassignmentId;
    }

    public STimeexpense getSTimeexpenseId() {
        return sTimeexpenseId;
    }

    public void setSTimeexpenseId(STimeexpense sTimeexpenseId) {
        this.sTimeexpenseId = sTimeexpenseId;
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

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CInvoiceline getCInvoicelineId() {
        return cInvoicelineId;
    }

    public void setCInvoicelineId(CInvoiceline cInvoicelineId) {
        this.cInvoicelineId = cInvoicelineId;
    }

    public STimetype getSTimetypeId() {
        return sTimetypeId;
    }

    public void setSTimetypeId(STimetype sTimetypeId) {
        this.sTimetypeId = sTimetypeId;
    }

    public COrderline getCOrderlineId() {
        return cOrderlineId;
    }

    public void setCOrderlineId(COrderline cOrderlineId) {
        this.cOrderlineId = cOrderlineId;
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

    public CProjectphase getCProjectphaseId() {
        return cProjectphaseId;
    }

    public void setCProjectphaseId(CProjectphase cProjectphaseId) {
        this.cProjectphaseId = cProjectphaseId;
    }

    public CProjecttask getCProjecttaskId() {
        return cProjecttaskId;
    }

    public void setCProjecttaskId(CProjecttask cProjecttaskId) {
        this.cProjecttaskId = cProjecttaskId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sTimeexpenselineId != null ? sTimeexpenselineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof STimeexpenseline)) {
            return false;
        }
        STimeexpenseline other = (STimeexpenseline) object;
        if ((this.sTimeexpenselineId == null && other.sTimeexpenselineId != null) || (this.sTimeexpenselineId != null && !this.sTimeexpenselineId.equals(other.sTimeexpenselineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.STimeexpenseline[ sTimeexpenselineId=" + sTimeexpenselineId + " ]";
    }
    
}
