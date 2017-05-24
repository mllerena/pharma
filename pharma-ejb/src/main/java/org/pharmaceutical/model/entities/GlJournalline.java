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
@Table(name = "gl_journalline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlJournalline.findAll", query = "SELECT g FROM GlJournalline g"),
    @NamedQuery(name = "GlJournalline.findByGlJournallineId", query = "SELECT g FROM GlJournalline g WHERE g.glJournallineId = :glJournallineId"),
    @NamedQuery(name = "GlJournalline.findByIsactive", query = "SELECT g FROM GlJournalline g WHERE g.isactive = :isactive"),
    @NamedQuery(name = "GlJournalline.findByCreated", query = "SELECT g FROM GlJournalline g WHERE g.created = :created"),
    @NamedQuery(name = "GlJournalline.findByCreatedby", query = "SELECT g FROM GlJournalline g WHERE g.createdby = :createdby"),
    @NamedQuery(name = "GlJournalline.findByUpdated", query = "SELECT g FROM GlJournalline g WHERE g.updated = :updated"),
    @NamedQuery(name = "GlJournalline.findByUpdatedby", query = "SELECT g FROM GlJournalline g WHERE g.updatedby = :updatedby"),
    @NamedQuery(name = "GlJournalline.findByLine", query = "SELECT g FROM GlJournalline g WHERE g.line = :line"),
    @NamedQuery(name = "GlJournalline.findByIsgenerated", query = "SELECT g FROM GlJournalline g WHERE g.isgenerated = :isgenerated"),
    @NamedQuery(name = "GlJournalline.findByDescription", query = "SELECT g FROM GlJournalline g WHERE g.description = :description"),
    @NamedQuery(name = "GlJournalline.findByAmtsourcedr", query = "SELECT g FROM GlJournalline g WHERE g.amtsourcedr = :amtsourcedr"),
    @NamedQuery(name = "GlJournalline.findByAmtsourcecr", query = "SELECT g FROM GlJournalline g WHERE g.amtsourcecr = :amtsourcecr"),
    @NamedQuery(name = "GlJournalline.findByCurrencyratetype", query = "SELECT g FROM GlJournalline g WHERE g.currencyratetype = :currencyratetype"),
    @NamedQuery(name = "GlJournalline.findByCurrencyrate", query = "SELECT g FROM GlJournalline g WHERE g.currencyrate = :currencyrate"),
    @NamedQuery(name = "GlJournalline.findByDateacct", query = "SELECT g FROM GlJournalline g WHERE g.dateacct = :dateacct"),
    @NamedQuery(name = "GlJournalline.findByAmtacctdr", query = "SELECT g FROM GlJournalline g WHERE g.amtacctdr = :amtacctdr"),
    @NamedQuery(name = "GlJournalline.findByAmtacctcr", query = "SELECT g FROM GlJournalline g WHERE g.amtacctcr = :amtacctcr"),
    @NamedQuery(name = "GlJournalline.findByQty", query = "SELECT g FROM GlJournalline g WHERE g.qty = :qty"),
    @NamedQuery(name = "GlJournalline.findByUser1Id", query = "SELECT g FROM GlJournalline g WHERE g.user1Id = :user1Id"),
    @NamedQuery(name = "GlJournalline.findByUser2Id", query = "SELECT g FROM GlJournalline g WHERE g.user2Id = :user2Id")})
public class GlJournalline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "gl_journalline_id")
    private String glJournallineId;
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
    @Column(name = "isgenerated")
    private Character isgenerated;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amtsourcedr")
    private BigInteger amtsourcedr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amtsourcecr")
    private BigInteger amtsourcecr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "currencyratetype")
    private String currencyratetype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currencyrate")
    private BigInteger currencyrate;
    @Column(name = "dateacct")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateacct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amtacctdr")
    private BigInteger amtacctdr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amtacctcr")
    private BigInteger amtacctcr;
    @Column(name = "qty")
    private BigInteger qty;
    @Size(max = 32)
    @Column(name = "user1_id")
    private String user1Id;
    @Size(max = 32)
    @Column(name = "user2_id")
    private String user2Id;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "glJournallineId")
    private List<IGljournal> iGljournalList;
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
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_validcombination_id", referencedColumnName = "c_validcombination_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CValidcombination cValidcombinationId;
    @JoinColumn(name = "gl_journal_id", referencedColumnName = "gl_journal_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private GlJournal glJournalId;
    @JoinColumn(name = "c_debt_payment_id", referencedColumnName = "c_debt_payment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDebtPayment cDebtPaymentId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "c_salesregion_id", referencedColumnName = "c_salesregion_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CSalesregion cSalesregionId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "c_withholding_id", referencedColumnName = "c_withholding_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CWithholding cWithholdingId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax cTaxId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomId;

    public GlJournalline() {
    }

    public GlJournalline(String glJournallineId) {
        this.glJournallineId = glJournallineId;
    }

    public GlJournalline(String glJournallineId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, Character isgenerated, BigInteger amtsourcedr, BigInteger amtsourcecr, String currencyratetype, BigInteger currencyrate, BigInteger amtacctdr, BigInteger amtacctcr) {
        this.glJournallineId = glJournallineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.isgenerated = isgenerated;
        this.amtsourcedr = amtsourcedr;
        this.amtsourcecr = amtsourcecr;
        this.currencyratetype = currencyratetype;
        this.currencyrate = currencyrate;
        this.amtacctdr = amtacctdr;
        this.amtacctcr = amtacctcr;
    }

    public String getGlJournallineId() {
        return glJournallineId;
    }

    public void setGlJournallineId(String glJournallineId) {
        this.glJournallineId = glJournallineId;
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

    public Character getIsgenerated() {
        return isgenerated;
    }

    public void setIsgenerated(Character isgenerated) {
        this.isgenerated = isgenerated;
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

    public BigInteger getAmtsourcecr() {
        return amtsourcecr;
    }

    public void setAmtsourcecr(BigInteger amtsourcecr) {
        this.amtsourcecr = amtsourcecr;
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

    public Date getDateacct() {
        return dateacct;
    }

    public void setDateacct(Date dateacct) {
        this.dateacct = dateacct;
    }

    public BigInteger getAmtacctdr() {
        return amtacctdr;
    }

    public void setAmtacctdr(BigInteger amtacctdr) {
        this.amtacctdr = amtacctdr;
    }

    public BigInteger getAmtacctcr() {
        return amtacctcr;
    }

    public void setAmtacctcr(BigInteger amtacctcr) {
        this.amtacctcr = amtacctcr;
    }

    public BigInteger getQty() {
        return qty;
    }

    public void setQty(BigInteger qty) {
        this.qty = qty;
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
    public List<IGljournal> getIGljournalList() {
        return iGljournalList;
    }

    public void setIGljournalList(List<IGljournal> iGljournalList) {
        this.iGljournalList = iGljournalList;
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

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CValidcombination getCValidcombinationId() {
        return cValidcombinationId;
    }

    public void setCValidcombinationId(CValidcombination cValidcombinationId) {
        this.cValidcombinationId = cValidcombinationId;
    }

    public GlJournal getGlJournalId() {
        return glJournalId;
    }

    public void setGlJournalId(GlJournal glJournalId) {
        this.glJournalId = glJournalId;
    }

    public CDebtPayment getCDebtPaymentId() {
        return cDebtPaymentId;
    }

    public void setCDebtPaymentId(CDebtPayment cDebtPaymentId) {
        this.cDebtPaymentId = cDebtPaymentId;
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

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public CWithholding getCWithholdingId() {
        return cWithholdingId;
    }

    public void setCWithholdingId(CWithholding cWithholdingId) {
        this.cWithholdingId = cWithholdingId;
    }

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    public CUom getCUomId() {
        return cUomId;
    }

    public void setCUomId(CUom cUomId) {
        this.cUomId = cUomId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (glJournallineId != null ? glJournallineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlJournalline)) {
            return false;
        }
        GlJournalline other = (GlJournalline) object;
        if ((this.glJournallineId == null && other.glJournallineId != null) || (this.glJournallineId != null && !this.glJournallineId.equals(other.glJournallineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.GlJournalline[ glJournallineId=" + glJournallineId + " ]";
    }
    
}
