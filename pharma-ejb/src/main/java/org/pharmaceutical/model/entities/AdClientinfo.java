/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "ad_clientinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdClientinfo.findAll", query = "SELECT a FROM AdClientinfo a"),
    @NamedQuery(name = "AdClientinfo.findByAdClientId", query = "SELECT a FROM AdClientinfo a WHERE a.adClientId = :adClientId"),
    @NamedQuery(name = "AdClientinfo.findByIsactive", query = "SELECT a FROM AdClientinfo a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdClientinfo.findByCreated", query = "SELECT a FROM AdClientinfo a WHERE a.created = :created"),
    @NamedQuery(name = "AdClientinfo.findByCreatedby", query = "SELECT a FROM AdClientinfo a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdClientinfo.findByUpdated", query = "SELECT a FROM AdClientinfo a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdClientinfo.findByUpdatedby", query = "SELECT a FROM AdClientinfo a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdClientinfo.findByIsdiscountlineamt", query = "SELECT a FROM AdClientinfo a WHERE a.isdiscountlineamt = :isdiscountlineamt"),
    @NamedQuery(name = "AdClientinfo.findByAcct2Active", query = "SELECT a FROM AdClientinfo a WHERE a.acct2Active = :acct2Active"),
    @NamedQuery(name = "AdClientinfo.findByAcct3Active", query = "SELECT a FROM AdClientinfo a WHERE a.acct3Active = :acct3Active"),
    @NamedQuery(name = "AdClientinfo.findByAllownegativestock", query = "SELECT a FROM AdClientinfo a WHERE a.allownegativestock = :allownegativestock"),
    @NamedQuery(name = "AdClientinfo.findByCheckorderorg", query = "SELECT a FROM AdClientinfo a WHERE a.checkorderorg = :checkorderorg"),
    @NamedQuery(name = "AdClientinfo.findByCheckinoutorg", query = "SELECT a FROM AdClientinfo a WHERE a.checkinoutorg = :checkinoutorg"),
    @NamedQuery(name = "AdClientinfo.findByGroupacctinvlines", query = "SELECT a FROM AdClientinfo a WHERE a.groupacctinvlines = :groupacctinvlines")})
public class AdClientinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_client_id")
    private String adClientId;
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
    @Column(name = "isdiscountlineamt")
    private Character isdiscountlineamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acct2_active")
    private Character acct2Active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acct3_active")
    private Character acct3Active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "allownegativestock")
    private Character allownegativestock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "checkorderorg")
    private Character checkorderorg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "checkinoutorg")
    private Character checkinoutorg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "groupacctinvlines")
    private Character groupacctinvlines;
    @JoinColumn(name = "your_company_big_image", referencedColumnName = "ad_image_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdImage yourCompanyBigImage;
    @JoinColumn(name = "your_company_menu_image", referencedColumnName = "ad_image_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdImage yourCompanyMenuImage;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private AdClient adClient;
    @JoinColumn(name = "your_company_document_image", referencedColumnName = "ad_image_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdImage yourCompanyDocumentImage;
    @JoinColumn(name = "c_uom_volume_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomVolumeId;
    @JoinColumn(name = "c_acctschema3_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CAcctschema cAcctschema3Id;
    @JoinColumn(name = "c_uom_weight_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomWeightId;
    @JoinColumn(name = "c_acctschema1_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CAcctschema cAcctschema1Id;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_tree_menu_id", referencedColumnName = "ad_tree_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTree adTreeMenuId;
    @JoinColumn(name = "m_productfreight_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductfreightId;
    @JoinColumn(name = "ad_tree_bpartner_id", referencedColumnName = "ad_tree_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTree adTreeBpartnerId;
    @JoinColumn(name = "c_uom_time_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomTimeId;
    @JoinColumn(name = "m_pricelist_id", referencedColumnName = "m_pricelist_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MPricelist mPricelistId;
    @JoinColumn(name = "c_acctschema2_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CAcctschema cAcctschema2Id;
    @JoinColumn(name = "ad_tree_product_id", referencedColumnName = "ad_tree_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTree adTreeProductId;
    @JoinColumn(name = "ad_tree_project_id", referencedColumnName = "ad_tree_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTree adTreeProjectId;
    @JoinColumn(name = "c_bpartnercashtrx_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnercashtrxId;
    @JoinColumn(name = "ad_tree_org_id", referencedColumnName = "ad_tree_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTree adTreeOrgId;
    @JoinColumn(name = "ad_tree_salesregion_id", referencedColumnName = "ad_tree_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTree adTreeSalesregionId;
    @JoinColumn(name = "c_calendar_id", referencedColumnName = "c_calendar_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCalendar cCalendarId;
    @JoinColumn(name = "c_uom_length_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomLengthId;
    @JoinColumn(name = "ad_tree_campaign_id", referencedColumnName = "ad_tree_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTree adTreeCampaignId;

    public AdClientinfo() {
    }

    public AdClientinfo(String adClientId) {
        this.adClientId = adClientId;
    }

    public AdClientinfo(String adClientId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character isdiscountlineamt, Character acct2Active, Character acct3Active, Character allownegativestock, Character checkorderorg, Character checkinoutorg, Character groupacctinvlines) {
        this.adClientId = adClientId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isdiscountlineamt = isdiscountlineamt;
        this.acct2Active = acct2Active;
        this.acct3Active = acct3Active;
        this.allownegativestock = allownegativestock;
        this.checkorderorg = checkorderorg;
        this.checkinoutorg = checkinoutorg;
        this.groupacctinvlines = groupacctinvlines;
    }

    public String getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(String adClientId) {
        this.adClientId = adClientId;
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

    public Character getIsdiscountlineamt() {
        return isdiscountlineamt;
    }

    public void setIsdiscountlineamt(Character isdiscountlineamt) {
        this.isdiscountlineamt = isdiscountlineamt;
    }

    public Character getAcct2Active() {
        return acct2Active;
    }

    public void setAcct2Active(Character acct2Active) {
        this.acct2Active = acct2Active;
    }

    public Character getAcct3Active() {
        return acct3Active;
    }

    public void setAcct3Active(Character acct3Active) {
        this.acct3Active = acct3Active;
    }

    public Character getAllownegativestock() {
        return allownegativestock;
    }

    public void setAllownegativestock(Character allownegativestock) {
        this.allownegativestock = allownegativestock;
    }

    public Character getCheckorderorg() {
        return checkorderorg;
    }

    public void setCheckorderorg(Character checkorderorg) {
        this.checkorderorg = checkorderorg;
    }

    public Character getCheckinoutorg() {
        return checkinoutorg;
    }

    public void setCheckinoutorg(Character checkinoutorg) {
        this.checkinoutorg = checkinoutorg;
    }

    public Character getGroupacctinvlines() {
        return groupacctinvlines;
    }

    public void setGroupacctinvlines(Character groupacctinvlines) {
        this.groupacctinvlines = groupacctinvlines;
    }

    public AdImage getYourCompanyBigImage() {
        return yourCompanyBigImage;
    }

    public void setYourCompanyBigImage(AdImage yourCompanyBigImage) {
        this.yourCompanyBigImage = yourCompanyBigImage;
    }

    public AdImage getYourCompanyMenuImage() {
        return yourCompanyMenuImage;
    }

    public void setYourCompanyMenuImage(AdImage yourCompanyMenuImage) {
        this.yourCompanyMenuImage = yourCompanyMenuImage;
    }

    public AdClient getAdClient() {
        return adClient;
    }

    public void setAdClient(AdClient adClient) {
        this.adClient = adClient;
    }

    public AdImage getYourCompanyDocumentImage() {
        return yourCompanyDocumentImage;
    }

    public void setYourCompanyDocumentImage(AdImage yourCompanyDocumentImage) {
        this.yourCompanyDocumentImage = yourCompanyDocumentImage;
    }

    public CUom getCUomVolumeId() {
        return cUomVolumeId;
    }

    public void setCUomVolumeId(CUom cUomVolumeId) {
        this.cUomVolumeId = cUomVolumeId;
    }

    public CAcctschema getCAcctschema3Id() {
        return cAcctschema3Id;
    }

    public void setCAcctschema3Id(CAcctschema cAcctschema3Id) {
        this.cAcctschema3Id = cAcctschema3Id;
    }

    public CUom getCUomWeightId() {
        return cUomWeightId;
    }

    public void setCUomWeightId(CUom cUomWeightId) {
        this.cUomWeightId = cUomWeightId;
    }

    public CAcctschema getCAcctschema1Id() {
        return cAcctschema1Id;
    }

    public void setCAcctschema1Id(CAcctschema cAcctschema1Id) {
        this.cAcctschema1Id = cAcctschema1Id;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdTree getAdTreeMenuId() {
        return adTreeMenuId;
    }

    public void setAdTreeMenuId(AdTree adTreeMenuId) {
        this.adTreeMenuId = adTreeMenuId;
    }

    public MProduct getMProductfreightId() {
        return mProductfreightId;
    }

    public void setMProductfreightId(MProduct mProductfreightId) {
        this.mProductfreightId = mProductfreightId;
    }

    public AdTree getAdTreeBpartnerId() {
        return adTreeBpartnerId;
    }

    public void setAdTreeBpartnerId(AdTree adTreeBpartnerId) {
        this.adTreeBpartnerId = adTreeBpartnerId;
    }

    public CUom getCUomTimeId() {
        return cUomTimeId;
    }

    public void setCUomTimeId(CUom cUomTimeId) {
        this.cUomTimeId = cUomTimeId;
    }

    public MPricelist getMPricelistId() {
        return mPricelistId;
    }

    public void setMPricelistId(MPricelist mPricelistId) {
        this.mPricelistId = mPricelistId;
    }

    public CAcctschema getCAcctschema2Id() {
        return cAcctschema2Id;
    }

    public void setCAcctschema2Id(CAcctschema cAcctschema2Id) {
        this.cAcctschema2Id = cAcctschema2Id;
    }

    public AdTree getAdTreeProductId() {
        return adTreeProductId;
    }

    public void setAdTreeProductId(AdTree adTreeProductId) {
        this.adTreeProductId = adTreeProductId;
    }

    public AdTree getAdTreeProjectId() {
        return adTreeProjectId;
    }

    public void setAdTreeProjectId(AdTree adTreeProjectId) {
        this.adTreeProjectId = adTreeProjectId;
    }

    public CBpartner getCBpartnercashtrxId() {
        return cBpartnercashtrxId;
    }

    public void setCBpartnercashtrxId(CBpartner cBpartnercashtrxId) {
        this.cBpartnercashtrxId = cBpartnercashtrxId;
    }

    public AdTree getAdTreeOrgId() {
        return adTreeOrgId;
    }

    public void setAdTreeOrgId(AdTree adTreeOrgId) {
        this.adTreeOrgId = adTreeOrgId;
    }

    public AdTree getAdTreeSalesregionId() {
        return adTreeSalesregionId;
    }

    public void setAdTreeSalesregionId(AdTree adTreeSalesregionId) {
        this.adTreeSalesregionId = adTreeSalesregionId;
    }

    public CCalendar getCCalendarId() {
        return cCalendarId;
    }

    public void setCCalendarId(CCalendar cCalendarId) {
        this.cCalendarId = cCalendarId;
    }

    public CUom getCUomLengthId() {
        return cUomLengthId;
    }

    public void setCUomLengthId(CUom cUomLengthId) {
        this.cUomLengthId = cUomLengthId;
    }

    public AdTree getAdTreeCampaignId() {
        return adTreeCampaignId;
    }

    public void setAdTreeCampaignId(AdTree adTreeCampaignId) {
        this.adTreeCampaignId = adTreeCampaignId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adClientId != null ? adClientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdClientinfo)) {
            return false;
        }
        AdClientinfo other = (AdClientinfo) object;
        if ((this.adClientId == null && other.adClientId != null) || (this.adClientId != null && !this.adClientId.equals(other.adClientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdClientinfo[ adClientId=" + adClientId + " ]";
    }
    
}
