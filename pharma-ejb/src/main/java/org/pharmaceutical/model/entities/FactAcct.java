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
@Table(name = "fact_acct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactAcct.findAll", query = "SELECT f FROM FactAcct f"),
    @NamedQuery(name = "FactAcct.findByFactAcctId", query = "SELECT f FROM FactAcct f WHERE f.factAcctId = :factAcctId"),
    @NamedQuery(name = "FactAcct.findByIsactive", query = "SELECT f FROM FactAcct f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FactAcct.findByCreated", query = "SELECT f FROM FactAcct f WHERE f.created = :created"),
    @NamedQuery(name = "FactAcct.findByCreatedby", query = "SELECT f FROM FactAcct f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FactAcct.findByUpdated", query = "SELECT f FROM FactAcct f WHERE f.updated = :updated"),
    @NamedQuery(name = "FactAcct.findByUpdatedby", query = "SELECT f FROM FactAcct f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FactAcct.findByDatetrx", query = "SELECT f FROM FactAcct f WHERE f.datetrx = :datetrx"),
    @NamedQuery(name = "FactAcct.findByDateacct", query = "SELECT f FROM FactAcct f WHERE f.dateacct = :dateacct"),
    @NamedQuery(name = "FactAcct.findByRecordId", query = "SELECT f FROM FactAcct f WHERE f.recordId = :recordId"),
    @NamedQuery(name = "FactAcct.findByLineId", query = "SELECT f FROM FactAcct f WHERE f.lineId = :lineId"),
    @NamedQuery(name = "FactAcct.findByPostingtype", query = "SELECT f FROM FactAcct f WHERE f.postingtype = :postingtype"),
    @NamedQuery(name = "FactAcct.findByAmtsourcedr", query = "SELECT f FROM FactAcct f WHERE f.amtsourcedr = :amtsourcedr"),
    @NamedQuery(name = "FactAcct.findByAmtsourcecr", query = "SELECT f FROM FactAcct f WHERE f.amtsourcecr = :amtsourcecr"),
    @NamedQuery(name = "FactAcct.findByAmtacctdr", query = "SELECT f FROM FactAcct f WHERE f.amtacctdr = :amtacctdr"),
    @NamedQuery(name = "FactAcct.findByAmtacctcr", query = "SELECT f FROM FactAcct f WHERE f.amtacctcr = :amtacctcr"),
    @NamedQuery(name = "FactAcct.findByQty", query = "SELECT f FROM FactAcct f WHERE f.qty = :qty"),
    @NamedQuery(name = "FactAcct.findByUser1Id", query = "SELECT f FROM FactAcct f WHERE f.user1Id = :user1Id"),
    @NamedQuery(name = "FactAcct.findByUser2Id", query = "SELECT f FROM FactAcct f WHERE f.user2Id = :user2Id"),
    @NamedQuery(name = "FactAcct.findByDescription", query = "SELECT f FROM FactAcct f WHERE f.description = :description"),
    @NamedQuery(name = "FactAcct.findByFactAcctGroupId", query = "SELECT f FROM FactAcct f WHERE f.factAcctGroupId = :factAcctGroupId"),
    @NamedQuery(name = "FactAcct.findBySeqno", query = "SELECT f FROM FactAcct f WHERE f.seqno = :seqno"),
    @NamedQuery(name = "FactAcct.findByFactaccttype", query = "SELECT f FROM FactAcct f WHERE f.factaccttype = :factaccttype"),
    @NamedQuery(name = "FactAcct.findByDocbasetype", query = "SELECT f FROM FactAcct f WHERE f.docbasetype = :docbasetype"),
    @NamedQuery(name = "FactAcct.findByAcctvalue", query = "SELECT f FROM FactAcct f WHERE f.acctvalue = :acctvalue"),
    @NamedQuery(name = "FactAcct.findByAcctdescription", query = "SELECT f FROM FactAcct f WHERE f.acctdescription = :acctdescription"),
    @NamedQuery(name = "FactAcct.findByRecordId2", query = "SELECT f FROM FactAcct f WHERE f.recordId2 = :recordId2")})
public class FactAcct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fact_acct_id")
    private String factAcctId;
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
    @Column(name = "datetrx")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetrx;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateacct")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateacct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "record_id")
    private String recordId;
    @Size(max = 32)
    @Column(name = "line_id")
    private String lineId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "postingtype")
    private String postingtype;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fact_acct_group_id")
    private String factAcctGroupId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqno")
    private long seqno;
    @Column(name = "factaccttype")
    private Character factaccttype;
    @Size(max = 40)
    @Column(name = "docbasetype")
    private String docbasetype;
    @Size(max = 40)
    @Column(name = "acctvalue")
    private String acctvalue;
    @Size(max = 255)
    @Column(name = "acctdescription")
    private String acctdescription;
    @Size(max = 32)
    @Column(name = "record_id2")
    private String recordId2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "factAcctId")
    private List<FactAcctCfs> factAcctCfsList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "factAcctRefId")
    private List<FactAcctCfs> factAcctCfsList1;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "a_asset_id", referencedColumnName = "a_asset_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AAsset aAssetId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "c_period_id", referencedColumnName = "c_period_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPeriod cPeriodId;
    @JoinColumn(name = "account_id", referencedColumnName = "c_elementvalue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CElementvalue accountId;
    @JoinColumn(name = "c_salesregion_id", referencedColumnName = "c_salesregion_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CSalesregion cSalesregionId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @JoinColumn(name = "ad_orgtrx_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgtrxId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTable adTableId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @JoinColumn(name = "c_activity_id", referencedColumnName = "c_activity_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CActivity cActivityId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_campaign_id", referencedColumnName = "c_campaign_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCampaign cCampaignId;
    @JoinColumn(name = "c_locfrom_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLocfromId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CProject cProjectId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomId;
    @JoinColumn(name = "c_locto_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLoctoId;
    @JoinColumn(name = "gl_category_id", referencedColumnName = "gl_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private GlCategory glCategoryId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDoctype cDoctypeId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax cTaxId;
    @JoinColumn(name = "c_withholding_id", referencedColumnName = "c_withholding_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CWithholding cWithholdingId;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MLocator mLocatorId;

    public FactAcct() {
    }

    public FactAcct(String factAcctId) {
        this.factAcctId = factAcctId;
    }

    public FactAcct(String factAcctId, Character isactive, Date created, String createdby, Date updated, String updatedby, Date datetrx, Date dateacct, String recordId, String postingtype, BigInteger amtsourcedr, BigInteger amtsourcecr, BigInteger amtacctdr, BigInteger amtacctcr, String factAcctGroupId, long seqno) {
        this.factAcctId = factAcctId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.datetrx = datetrx;
        this.dateacct = dateacct;
        this.recordId = recordId;
        this.postingtype = postingtype;
        this.amtsourcedr = amtsourcedr;
        this.amtsourcecr = amtsourcecr;
        this.amtacctdr = amtacctdr;
        this.amtacctcr = amtacctcr;
        this.factAcctGroupId = factAcctGroupId;
        this.seqno = seqno;
    }

    public String getFactAcctId() {
        return factAcctId;
    }

    public void setFactAcctId(String factAcctId) {
        this.factAcctId = factAcctId;
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

    public Date getDatetrx() {
        return datetrx;
    }

    public void setDatetrx(Date datetrx) {
        this.datetrx = datetrx;
    }

    public Date getDateacct() {
        return dateacct;
    }

    public void setDateacct(Date dateacct) {
        this.dateacct = dateacct;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getPostingtype() {
        return postingtype;
    }

    public void setPostingtype(String postingtype) {
        this.postingtype = postingtype;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFactAcctGroupId() {
        return factAcctGroupId;
    }

    public void setFactAcctGroupId(String factAcctGroupId) {
        this.factAcctGroupId = factAcctGroupId;
    }

    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
    }

    public Character getFactaccttype() {
        return factaccttype;
    }

    public void setFactaccttype(Character factaccttype) {
        this.factaccttype = factaccttype;
    }

    public String getDocbasetype() {
        return docbasetype;
    }

    public void setDocbasetype(String docbasetype) {
        this.docbasetype = docbasetype;
    }

    public String getAcctvalue() {
        return acctvalue;
    }

    public void setAcctvalue(String acctvalue) {
        this.acctvalue = acctvalue;
    }

    public String getAcctdescription() {
        return acctdescription;
    }

    public void setAcctdescription(String acctdescription) {
        this.acctdescription = acctdescription;
    }

    public String getRecordId2() {
        return recordId2;
    }

    public void setRecordId2(String recordId2) {
        this.recordId2 = recordId2;
    }

    @XmlTransient
    public List<FactAcctCfs> getFactAcctCfsList() {
        return factAcctCfsList;
    }

    public void setFactAcctCfsList(List<FactAcctCfs> factAcctCfsList) {
        this.factAcctCfsList = factAcctCfsList;
    }

    @XmlTransient
    public List<FactAcctCfs> getFactAcctCfsList1() {
        return factAcctCfsList1;
    }

    public void setFactAcctCfsList1(List<FactAcctCfs> factAcctCfsList1) {
        this.factAcctCfsList1 = factAcctCfsList1;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AAsset getAAssetId() {
        return aAssetId;
    }

    public void setAAssetId(AAsset aAssetId) {
        this.aAssetId = aAssetId;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public CPeriod getCPeriodId() {
        return cPeriodId;
    }

    public void setCPeriodId(CPeriod cPeriodId) {
        this.cPeriodId = cPeriodId;
    }

    public CElementvalue getAccountId() {
        return accountId;
    }

    public void setAccountId(CElementvalue accountId) {
        this.accountId = accountId;
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

    public AdOrg getAdOrgtrxId() {
        return adOrgtrxId;
    }

    public void setAdOrgtrxId(AdOrg adOrgtrxId) {
        this.adOrgtrxId = adOrgtrxId;
    }

    public AdTable getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(AdTable adTableId) {
        this.adTableId = adTableId;
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

    public CLocation getCLocfromId() {
        return cLocfromId;
    }

    public void setCLocfromId(CLocation cLocfromId) {
        this.cLocfromId = cLocfromId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CUom getCUomId() {
        return cUomId;
    }

    public void setCUomId(CUom cUomId) {
        this.cUomId = cUomId;
    }

    public CLocation getCLoctoId() {
        return cLoctoId;
    }

    public void setCLoctoId(CLocation cLoctoId) {
        this.cLoctoId = cLoctoId;
    }

    public GlCategory getGlCategoryId() {
        return glCategoryId;
    }

    public void setGlCategoryId(GlCategory glCategoryId) {
        this.glCategoryId = glCategoryId;
    }

    public CDoctype getCDoctypeId() {
        return cDoctypeId;
    }

    public void setCDoctypeId(CDoctype cDoctypeId) {
        this.cDoctypeId = cDoctypeId;
    }

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    public CWithholding getCWithholdingId() {
        return cWithholdingId;
    }

    public void setCWithholdingId(CWithholding cWithholdingId) {
        this.cWithholdingId = cWithholdingId;
    }

    public MLocator getMLocatorId() {
        return mLocatorId;
    }

    public void setMLocatorId(MLocator mLocatorId) {
        this.mLocatorId = mLocatorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (factAcctId != null ? factAcctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactAcct)) {
            return false;
        }
        FactAcct other = (FactAcct) object;
        if ((this.factAcctId == null && other.factAcctId != null) || (this.factAcctId != null && !this.factAcctId.equals(other.factAcctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FactAcct[ factAcctId=" + factAcctId + " ]";
    }
    
}
