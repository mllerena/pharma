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
@Table(name = "i_tax")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ITax.findAll", query = "SELECT i FROM ITax i"),
    @NamedQuery(name = "ITax.findByITaxId", query = "SELECT i FROM ITax i WHERE i.iTaxId = :iTaxId"),
    @NamedQuery(name = "ITax.findByIsactive", query = "SELECT i FROM ITax i WHERE i.isactive = :isactive"),
    @NamedQuery(name = "ITax.findByCreated", query = "SELECT i FROM ITax i WHERE i.created = :created"),
    @NamedQuery(name = "ITax.findByCreatedby", query = "SELECT i FROM ITax i WHERE i.createdby = :createdby"),
    @NamedQuery(name = "ITax.findByUpdated", query = "SELECT i FROM ITax i WHERE i.updated = :updated"),
    @NamedQuery(name = "ITax.findByUpdatedby", query = "SELECT i FROM ITax i WHERE i.updatedby = :updatedby"),
    @NamedQuery(name = "ITax.findByTName", query = "SELECT i FROM ITax i WHERE i.tName = :tName"),
    @NamedQuery(name = "ITax.findByTDescription", query = "SELECT i FROM ITax i WHERE i.tDescription = :tDescription"),
    @NamedQuery(name = "ITax.findByTaxindicator", query = "SELECT i FROM ITax i WHERE i.taxindicator = :taxindicator"),
    @NamedQuery(name = "ITax.findByValidfrom", query = "SELECT i FROM ITax i WHERE i.validfrom = :validfrom"),
    @NamedQuery(name = "ITax.findByIssummary", query = "SELECT i FROM ITax i WHERE i.issummary = :issummary"),
    @NamedQuery(name = "ITax.findByRate", query = "SELECT i FROM ITax i WHERE i.rate = :rate"),
    @NamedQuery(name = "ITax.findByIstaxexempt", query = "SELECT i FROM ITax i WHERE i.istaxexempt = :istaxexempt"),
    @NamedQuery(name = "ITax.findBySopotype", query = "SELECT i FROM ITax i WHERE i.sopotype = :sopotype"),
    @NamedQuery(name = "ITax.findByLine", query = "SELECT i FROM ITax i WHERE i.line = :line"),
    @NamedQuery(name = "ITax.findByCascade", query = "SELECT i FROM ITax i WHERE i.cascade = :cascade"),
    @NamedQuery(name = "ITax.findByTcName", query = "SELECT i FROM ITax i WHERE i.tcName = :tcName"),
    @NamedQuery(name = "ITax.findByTcDescription", query = "SELECT i FROM ITax i WHERE i.tcDescription = :tcDescription"),
    @NamedQuery(name = "ITax.findByTcCommoditycode", query = "SELECT i FROM ITax i WHERE i.tcCommoditycode = :tcCommoditycode"),
    @NamedQuery(name = "ITax.findByBptcName", query = "SELECT i FROM ITax i WHERE i.bptcName = :bptcName"),
    @NamedQuery(name = "ITax.findByBptcDescription", query = "SELECT i FROM ITax i WHERE i.bptcDescription = :bptcDescription"),
    @NamedQuery(name = "ITax.findByProcessing", query = "SELECT i FROM ITax i WHERE i.processing = :processing"),
    @NamedQuery(name = "ITax.findByProcessed", query = "SELECT i FROM ITax i WHERE i.processed = :processed"),
    @NamedQuery(name = "ITax.findByIErrormsg", query = "SELECT i FROM ITax i WHERE i.iErrormsg = :iErrormsg"),
    @NamedQuery(name = "ITax.findByIIsimported", query = "SELECT i FROM ITax i WHERE i.iIsimported = :iIsimported"),
    @NamedQuery(name = "ITax.findByParentName", query = "SELECT i FROM ITax i WHERE i.parentName = :parentName"),
    @NamedQuery(name = "ITax.findByFromCodeCountry", query = "SELECT i FROM ITax i WHERE i.fromCodeCountry = :fromCodeCountry"),
    @NamedQuery(name = "ITax.findByToCodeCountry", query = "SELECT i FROM ITax i WHERE i.toCodeCountry = :toCodeCountry"),
    @NamedQuery(name = "ITax.findByFromCodeRegion", query = "SELECT i FROM ITax i WHERE i.fromCodeRegion = :fromCodeRegion"),
    @NamedQuery(name = "ITax.findByToCodeRegion", query = "SELECT i FROM ITax i WHERE i.toCodeRegion = :toCodeRegion")})
public class ITax implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "i_tax_id")
    private String iTaxId;
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
    @Size(max = 60)
    @Column(name = "t_name")
    private String tName;
    @Size(max = 255)
    @Column(name = "t_description")
    private String tDescription;
    @Size(max = 5)
    @Column(name = "taxindicator")
    private String taxindicator;
    @Column(name = "validfrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validfrom;
    @Column(name = "issummary")
    private Character issummary;
    @Column(name = "rate")
    private BigInteger rate;
    @Column(name = "istaxexempt")
    private Character istaxexempt;
    @Size(max = 60)
    @Column(name = "sopotype")
    private String sopotype;
    @Column(name = "line")
    private BigInteger line;
    @Column(name = "cascade")
    private Character cascade;
    @Size(max = 60)
    @Column(name = "tc_name")
    private String tcName;
    @Size(max = 255)
    @Column(name = "tc_description")
    private String tcDescription;
    @Size(max = 20)
    @Column(name = "tc_commoditycode")
    private String tcCommoditycode;
    @Size(max = 60)
    @Column(name = "bptc_name")
    private String bptcName;
    @Size(max = 255)
    @Column(name = "bptc_description")
    private String bptcDescription;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "processed")
    private Character processed;
    @Size(max = 2000)
    @Column(name = "i_errormsg")
    private String iErrormsg;
    @Column(name = "i_isimported")
    private Character iIsimported;
    @Size(max = 255)
    @Column(name = "parent_name")
    private String parentName;
    @Size(max = 60)
    @Column(name = "from_code_country")
    private String fromCodeCountry;
    @Size(max = 60)
    @Column(name = "to_code_country")
    private String toCodeCountry;
    @Size(max = 60)
    @Column(name = "from_code_region")
    private String fromCodeRegion;
    @Size(max = 60)
    @Column(name = "to_code_region")
    private String toCodeRegion;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bp_taxcategory_id", referencedColumnName = "c_bp_taxcategory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpTaxcategory cBpTaxcategoryId;
    @JoinColumn(name = "to_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCountry toCountryId;
    @JoinColumn(name = "c_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCountry cCountryId;
    @JoinColumn(name = "c_region_id", referencedColumnName = "c_region_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CRegion cRegionId;
    @JoinColumn(name = "to_region_id", referencedColumnName = "c_region_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CRegion toRegionId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax cTaxId;
    @JoinColumn(name = "parent_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax parentTaxId;
    @JoinColumn(name = "c_taxcategory_id", referencedColumnName = "c_taxcategory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTaxcategory cTaxcategoryId;

    public ITax() {
    }

    public ITax(String iTaxId) {
        this.iTaxId = iTaxId;
    }

    public String getITaxId() {
        return iTaxId;
    }

    public void setITaxId(String iTaxId) {
        this.iTaxId = iTaxId;
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

    public String getTName() {
        return tName;
    }

    public void setTName(String tName) {
        this.tName = tName;
    }

    public String getTDescription() {
        return tDescription;
    }

    public void setTDescription(String tDescription) {
        this.tDescription = tDescription;
    }

    public String getTaxindicator() {
        return taxindicator;
    }

    public void setTaxindicator(String taxindicator) {
        this.taxindicator = taxindicator;
    }

    public Date getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(Date validfrom) {
        this.validfrom = validfrom;
    }

    public Character getIssummary() {
        return issummary;
    }

    public void setIssummary(Character issummary) {
        this.issummary = issummary;
    }

    public BigInteger getRate() {
        return rate;
    }

    public void setRate(BigInteger rate) {
        this.rate = rate;
    }

    public Character getIstaxexempt() {
        return istaxexempt;
    }

    public void setIstaxexempt(Character istaxexempt) {
        this.istaxexempt = istaxexempt;
    }

    public String getSopotype() {
        return sopotype;
    }

    public void setSopotype(String sopotype) {
        this.sopotype = sopotype;
    }

    public BigInteger getLine() {
        return line;
    }

    public void setLine(BigInteger line) {
        this.line = line;
    }

    public Character getCascade() {
        return cascade;
    }

    public void setCascade(Character cascade) {
        this.cascade = cascade;
    }

    public String getTcName() {
        return tcName;
    }

    public void setTcName(String tcName) {
        this.tcName = tcName;
    }

    public String getTcDescription() {
        return tcDescription;
    }

    public void setTcDescription(String tcDescription) {
        this.tcDescription = tcDescription;
    }

    public String getTcCommoditycode() {
        return tcCommoditycode;
    }

    public void setTcCommoditycode(String tcCommoditycode) {
        this.tcCommoditycode = tcCommoditycode;
    }

    public String getBptcName() {
        return bptcName;
    }

    public void setBptcName(String bptcName) {
        this.bptcName = bptcName;
    }

    public String getBptcDescription() {
        return bptcDescription;
    }

    public void setBptcDescription(String bptcDescription) {
        this.bptcDescription = bptcDescription;
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getFromCodeCountry() {
        return fromCodeCountry;
    }

    public void setFromCodeCountry(String fromCodeCountry) {
        this.fromCodeCountry = fromCodeCountry;
    }

    public String getToCodeCountry() {
        return toCodeCountry;
    }

    public void setToCodeCountry(String toCodeCountry) {
        this.toCodeCountry = toCodeCountry;
    }

    public String getFromCodeRegion() {
        return fromCodeRegion;
    }

    public void setFromCodeRegion(String fromCodeRegion) {
        this.fromCodeRegion = fromCodeRegion;
    }

    public String getToCodeRegion() {
        return toCodeRegion;
    }

    public void setToCodeRegion(String toCodeRegion) {
        this.toCodeRegion = toCodeRegion;
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

    public CBpTaxcategory getCBpTaxcategoryId() {
        return cBpTaxcategoryId;
    }

    public void setCBpTaxcategoryId(CBpTaxcategory cBpTaxcategoryId) {
        this.cBpTaxcategoryId = cBpTaxcategoryId;
    }

    public CCountry getToCountryId() {
        return toCountryId;
    }

    public void setToCountryId(CCountry toCountryId) {
        this.toCountryId = toCountryId;
    }

    public CCountry getCCountryId() {
        return cCountryId;
    }

    public void setCCountryId(CCountry cCountryId) {
        this.cCountryId = cCountryId;
    }

    public CRegion getCRegionId() {
        return cRegionId;
    }

    public void setCRegionId(CRegion cRegionId) {
        this.cRegionId = cRegionId;
    }

    public CRegion getToRegionId() {
        return toRegionId;
    }

    public void setToRegionId(CRegion toRegionId) {
        this.toRegionId = toRegionId;
    }

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    public CTax getParentTaxId() {
        return parentTaxId;
    }

    public void setParentTaxId(CTax parentTaxId) {
        this.parentTaxId = parentTaxId;
    }

    public CTaxcategory getCTaxcategoryId() {
        return cTaxcategoryId;
    }

    public void setCTaxcategoryId(CTaxcategory cTaxcategoryId) {
        this.cTaxcategoryId = cTaxcategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iTaxId != null ? iTaxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ITax)) {
            return false;
        }
        ITax other = (ITax) object;
        if ((this.iTaxId == null && other.iTaxId != null) || (this.iTaxId != null && !this.iTaxId.equals(other.iTaxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.ITax[ iTaxId=" + iTaxId + " ]";
    }
    
}
