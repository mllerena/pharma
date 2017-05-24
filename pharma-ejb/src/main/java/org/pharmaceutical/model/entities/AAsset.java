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
import javax.persistence.FetchType;
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
@Table(name = "a_asset")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AAsset.findAll", query = "SELECT a FROM AAsset a"),
    @NamedQuery(name = "AAsset.findByAAssetId", query = "SELECT a FROM AAsset a WHERE a.aAssetId = :aAssetId"),
    @NamedQuery(name = "AAsset.findByIsactive", query = "SELECT a FROM AAsset a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AAsset.findByCreated", query = "SELECT a FROM AAsset a WHERE a.created = :created"),
    @NamedQuery(name = "AAsset.findByCreatedby", query = "SELECT a FROM AAsset a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AAsset.findByUpdated", query = "SELECT a FROM AAsset a WHERE a.updated = :updated"),
    @NamedQuery(name = "AAsset.findByUpdatedby", query = "SELECT a FROM AAsset a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AAsset.findByValue", query = "SELECT a FROM AAsset a WHERE a.value = :value"),
    @NamedQuery(name = "AAsset.findByName", query = "SELECT a FROM AAsset a WHERE a.name = :name"),
    @NamedQuery(name = "AAsset.findByDescription", query = "SELECT a FROM AAsset a WHERE a.description = :description"),
    @NamedQuery(name = "AAsset.findByHelp", query = "SELECT a FROM AAsset a WHERE a.help = :help"),
    @NamedQuery(name = "AAsset.findBySerno", query = "SELECT a FROM AAsset a WHERE a.serno = :serno"),
    @NamedQuery(name = "AAsset.findByLot", query = "SELECT a FROM AAsset a WHERE a.lot = :lot"),
    @NamedQuery(name = "AAsset.findByVersionno", query = "SELECT a FROM AAsset a WHERE a.versionno = :versionno"),
    @NamedQuery(name = "AAsset.findByGuaranteedate", query = "SELECT a FROM AAsset a WHERE a.guaranteedate = :guaranteedate"),
    @NamedQuery(name = "AAsset.findByAssetservicedate", query = "SELECT a FROM AAsset a WHERE a.assetservicedate = :assetservicedate"),
    @NamedQuery(name = "AAsset.findByIsowned", query = "SELECT a FROM AAsset a WHERE a.isowned = :isowned"),
    @NamedQuery(name = "AAsset.findByAssetdepreciationdate", query = "SELECT a FROM AAsset a WHERE a.assetdepreciationdate = :assetdepreciationdate"),
    @NamedQuery(name = "AAsset.findByUselifeyears", query = "SELECT a FROM AAsset a WHERE a.uselifeyears = :uselifeyears"),
    @NamedQuery(name = "AAsset.findByUselifemonths", query = "SELECT a FROM AAsset a WHERE a.uselifemonths = :uselifemonths"),
    @NamedQuery(name = "AAsset.findByLifeuseunits", query = "SELECT a FROM AAsset a WHERE a.lifeuseunits = :lifeuseunits"),
    @NamedQuery(name = "AAsset.findByUseunits", query = "SELECT a FROM AAsset a WHERE a.useunits = :useunits"),
    @NamedQuery(name = "AAsset.findByIsdisposed", query = "SELECT a FROM AAsset a WHERE a.isdisposed = :isdisposed"),
    @NamedQuery(name = "AAsset.findByAssetdisposaldate", query = "SELECT a FROM AAsset a WHERE a.assetdisposaldate = :assetdisposaldate"),
    @NamedQuery(name = "AAsset.findByIsinposession", query = "SELECT a FROM AAsset a WHERE a.isinposession = :isinposession"),
    @NamedQuery(name = "AAsset.findByLocationcomment", query = "SELECT a FROM AAsset a WHERE a.locationcomment = :locationcomment"),
    @NamedQuery(name = "AAsset.findByProcessing", query = "SELECT a FROM AAsset a WHERE a.processing = :processing"),
    @NamedQuery(name = "AAsset.findByIsdepreciated", query = "SELECT a FROM AAsset a WHERE a.isdepreciated = :isdepreciated"),
    @NamedQuery(name = "AAsset.findByIsfullydepreciated", query = "SELECT a FROM AAsset a WHERE a.isfullydepreciated = :isfullydepreciated"),
    @NamedQuery(name = "AAsset.findByAmortizationenddate", query = "SELECT a FROM AAsset a WHERE a.amortizationenddate = :amortizationenddate"),
    @NamedQuery(name = "AAsset.findByAmortizationstartdate", query = "SELECT a FROM AAsset a WHERE a.amortizationstartdate = :amortizationstartdate"),
    @NamedQuery(name = "AAsset.findByAnnualamortizationpercentage", query = "SELECT a FROM AAsset a WHERE a.annualamortizationpercentage = :annualamortizationpercentage"),
    @NamedQuery(name = "AAsset.findByAssetvalueamt", query = "SELECT a FROM AAsset a WHERE a.assetvalueamt = :assetvalueamt"),
    @NamedQuery(name = "AAsset.findByDatecancelled", query = "SELECT a FROM AAsset a WHERE a.datecancelled = :datecancelled"),
    @NamedQuery(name = "AAsset.findByDatepurchased", query = "SELECT a FROM AAsset a WHERE a.datepurchased = :datepurchased"),
    @NamedQuery(name = "AAsset.findByResidualassetvalueamt", query = "SELECT a FROM AAsset a WHERE a.residualassetvalueamt = :residualassetvalueamt"),
    @NamedQuery(name = "AAsset.findByAcctvalueamt", query = "SELECT a FROM AAsset a WHERE a.acctvalueamt = :acctvalueamt"),
    @NamedQuery(name = "AAsset.findByAmortizationtype", query = "SELECT a FROM AAsset a WHERE a.amortizationtype = :amortizationtype"),
    @NamedQuery(name = "AAsset.findByAmortizationvalueamt", query = "SELECT a FROM AAsset a WHERE a.amortizationvalueamt = :amortizationvalueamt"),
    @NamedQuery(name = "AAsset.findByAssetschedule", query = "SELECT a FROM AAsset a WHERE a.assetschedule = :assetschedule"),
    @NamedQuery(name = "AAsset.findByDocumentno", query = "SELECT a FROM AAsset a WHERE a.documentno = :documentno"),
    @NamedQuery(name = "AAsset.findByProcessed", query = "SELECT a FROM AAsset a WHERE a.processed = :processed"),
    @NamedQuery(name = "AAsset.findByProfit", query = "SELECT a FROM AAsset a WHERE a.profit = :profit"),
    @NamedQuery(name = "AAsset.findByQty", query = "SELECT a FROM AAsset a WHERE a.qty = :qty"),
    @NamedQuery(name = "AAsset.findByAmortizationcalctype", query = "SELECT a FROM AAsset a WHERE a.amortizationcalctype = :amortizationcalctype"),
    @NamedQuery(name = "AAsset.findByDepreciatedplan", query = "SELECT a FROM AAsset a WHERE a.depreciatedplan = :depreciatedplan"),
    @NamedQuery(name = "AAsset.findByDepreciatedpreviousamt", query = "SELECT a FROM AAsset a WHERE a.depreciatedpreviousamt = :depreciatedpreviousamt"),
    @NamedQuery(name = "AAsset.findByDepreciatedvalue", query = "SELECT a FROM AAsset a WHERE a.depreciatedvalue = :depreciatedvalue")})
public class AAsset implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "a_asset_id")
    private String aAssetId;
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
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Size(max = 20)
    @Column(name = "serno")
    private String serno;
    @Size(max = 20)
    @Column(name = "lot")
    private String lot;
    @Size(max = 20)
    @Column(name = "versionno")
    private String versionno;
    @Column(name = "guaranteedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date guaranteedate;
    @Column(name = "assetservicedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assetservicedate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isowned")
    private Character isowned;
    @Column(name = "assetdepreciationdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assetdepreciationdate;
    @Column(name = "uselifeyears")
    private Long uselifeyears;
    @Column(name = "uselifemonths")
    private Long uselifemonths;
    @Column(name = "lifeuseunits")
    private BigInteger lifeuseunits;
    @Column(name = "useunits")
    private BigInteger useunits;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdisposed")
    private Character isdisposed;
    @Column(name = "assetdisposaldate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assetdisposaldate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isinposession")
    private Character isinposession;
    @Size(max = 255)
    @Column(name = "locationcomment")
    private String locationcomment;
    @Column(name = "processing")
    private Character processing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdepreciated")
    private Character isdepreciated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isfullydepreciated")
    private Character isfullydepreciated;
    @Column(name = "amortizationenddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date amortizationenddate;
    @Column(name = "amortizationstartdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date amortizationstartdate;
    @Column(name = "annualamortizationpercentage")
    private BigInteger annualamortizationpercentage;
    @Column(name = "assetvalueamt")
    private BigInteger assetvalueamt;
    @Column(name = "datecancelled")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecancelled;
    @Column(name = "datepurchased")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datepurchased;
    @Column(name = "residualassetvalueamt")
    private BigInteger residualassetvalueamt;
    @Column(name = "acctvalueamt")
    private BigInteger acctvalueamt;
    @Size(max = 60)
    @Column(name = "amortizationtype")
    private String amortizationtype;
    @Column(name = "amortizationvalueamt")
    private BigInteger amortizationvalueamt;
    @Size(max = 60)
    @Column(name = "assetschedule")
    private String assetschedule;
    @Size(max = 30)
    @Column(name = "documentno")
    private String documentno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "processed")
    private String processed;
    @Column(name = "profit")
    private BigInteger profit;
    @Column(name = "qty")
    private BigInteger qty;
    @Size(max = 60)
    @Column(name = "amortizationcalctype")
    private String amortizationcalctype;
    @Column(name = "depreciatedplan")
    private BigInteger depreciatedplan;
    @Column(name = "depreciatedpreviousamt")
    private BigInteger depreciatedpreviousamt;
    @Column(name = "depreciatedvalue")
    private BigInteger depreciatedvalue;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "aAssetId")
    private List<AAssetAcct> aAssetAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "aAssetId")
    private List<FactAcct> factAcctList;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "a_asset_group_id", referencedColumnName = "a_asset_group_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AAssetGroup aAssetGroupId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "c_bpartner_location_id", referencedColumnName = "c_bpartner_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartnerLocation cBpartnerLocationId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_location_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLocationId;
    @JoinColumn(name = "m_attributesetinstance_id", referencedColumnName = "m_attributesetinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MAttributesetinstance mAttributesetinstanceId;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MLocator mLocatorId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "aAssetId")
    private List<AAmortizationline> aAmortizationlineList;

    public AAsset() {
    }

    public AAsset(String aAssetId) {
        this.aAssetId = aAssetId;
    }

    public AAsset(String aAssetId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name, Character isowned, Character isdisposed, Character isinposession, Character isdepreciated, Character isfullydepreciated, String processed) {
        this.aAssetId = aAssetId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
        this.isowned = isowned;
        this.isdisposed = isdisposed;
        this.isinposession = isinposession;
        this.isdepreciated = isdepreciated;
        this.isfullydepreciated = isfullydepreciated;
        this.processed = processed;
    }

    public String getAAssetId() {
        return aAssetId;
    }

    public void setAAssetId(String aAssetId) {
        this.aAssetId = aAssetId;
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

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getSerno() {
        return serno;
    }

    public void setSerno(String serno) {
        this.serno = serno;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getVersionno() {
        return versionno;
    }

    public void setVersionno(String versionno) {
        this.versionno = versionno;
    }

    public Date getGuaranteedate() {
        return guaranteedate;
    }

    public void setGuaranteedate(Date guaranteedate) {
        this.guaranteedate = guaranteedate;
    }

    public Date getAssetservicedate() {
        return assetservicedate;
    }

    public void setAssetservicedate(Date assetservicedate) {
        this.assetservicedate = assetservicedate;
    }

    public Character getIsowned() {
        return isowned;
    }

    public void setIsowned(Character isowned) {
        this.isowned = isowned;
    }

    public Date getAssetdepreciationdate() {
        return assetdepreciationdate;
    }

    public void setAssetdepreciationdate(Date assetdepreciationdate) {
        this.assetdepreciationdate = assetdepreciationdate;
    }

    public Long getUselifeyears() {
        return uselifeyears;
    }

    public void setUselifeyears(Long uselifeyears) {
        this.uselifeyears = uselifeyears;
    }

    public Long getUselifemonths() {
        return uselifemonths;
    }

    public void setUselifemonths(Long uselifemonths) {
        this.uselifemonths = uselifemonths;
    }

    public BigInteger getLifeuseunits() {
        return lifeuseunits;
    }

    public void setLifeuseunits(BigInteger lifeuseunits) {
        this.lifeuseunits = lifeuseunits;
    }

    public BigInteger getUseunits() {
        return useunits;
    }

    public void setUseunits(BigInteger useunits) {
        this.useunits = useunits;
    }

    public Character getIsdisposed() {
        return isdisposed;
    }

    public void setIsdisposed(Character isdisposed) {
        this.isdisposed = isdisposed;
    }

    public Date getAssetdisposaldate() {
        return assetdisposaldate;
    }

    public void setAssetdisposaldate(Date assetdisposaldate) {
        this.assetdisposaldate = assetdisposaldate;
    }

    public Character getIsinposession() {
        return isinposession;
    }

    public void setIsinposession(Character isinposession) {
        this.isinposession = isinposession;
    }

    public String getLocationcomment() {
        return locationcomment;
    }

    public void setLocationcomment(String locationcomment) {
        this.locationcomment = locationcomment;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getIsdepreciated() {
        return isdepreciated;
    }

    public void setIsdepreciated(Character isdepreciated) {
        this.isdepreciated = isdepreciated;
    }

    public Character getIsfullydepreciated() {
        return isfullydepreciated;
    }

    public void setIsfullydepreciated(Character isfullydepreciated) {
        this.isfullydepreciated = isfullydepreciated;
    }

    public Date getAmortizationenddate() {
        return amortizationenddate;
    }

    public void setAmortizationenddate(Date amortizationenddate) {
        this.amortizationenddate = amortizationenddate;
    }

    public Date getAmortizationstartdate() {
        return amortizationstartdate;
    }

    public void setAmortizationstartdate(Date amortizationstartdate) {
        this.amortizationstartdate = amortizationstartdate;
    }

    public BigInteger getAnnualamortizationpercentage() {
        return annualamortizationpercentage;
    }

    public void setAnnualamortizationpercentage(BigInteger annualamortizationpercentage) {
        this.annualamortizationpercentage = annualamortizationpercentage;
    }

    public BigInteger getAssetvalueamt() {
        return assetvalueamt;
    }

    public void setAssetvalueamt(BigInteger assetvalueamt) {
        this.assetvalueamt = assetvalueamt;
    }

    public Date getDatecancelled() {
        return datecancelled;
    }

    public void setDatecancelled(Date datecancelled) {
        this.datecancelled = datecancelled;
    }

    public Date getDatepurchased() {
        return datepurchased;
    }

    public void setDatepurchased(Date datepurchased) {
        this.datepurchased = datepurchased;
    }

    public BigInteger getResidualassetvalueamt() {
        return residualassetvalueamt;
    }

    public void setResidualassetvalueamt(BigInteger residualassetvalueamt) {
        this.residualassetvalueamt = residualassetvalueamt;
    }

    public BigInteger getAcctvalueamt() {
        return acctvalueamt;
    }

    public void setAcctvalueamt(BigInteger acctvalueamt) {
        this.acctvalueamt = acctvalueamt;
    }

    public String getAmortizationtype() {
        return amortizationtype;
    }

    public void setAmortizationtype(String amortizationtype) {
        this.amortizationtype = amortizationtype;
    }

    public BigInteger getAmortizationvalueamt() {
        return amortizationvalueamt;
    }

    public void setAmortizationvalueamt(BigInteger amortizationvalueamt) {
        this.amortizationvalueamt = amortizationvalueamt;
    }

    public String getAssetschedule() {
        return assetschedule;
    }

    public void setAssetschedule(String assetschedule) {
        this.assetschedule = assetschedule;
    }

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public String getProcessed() {
        return processed;
    }

    public void setProcessed(String processed) {
        this.processed = processed;
    }

    public BigInteger getProfit() {
        return profit;
    }

    public void setProfit(BigInteger profit) {
        this.profit = profit;
    }

    public BigInteger getQty() {
        return qty;
    }

    public void setQty(BigInteger qty) {
        this.qty = qty;
    }

    public String getAmortizationcalctype() {
        return amortizationcalctype;
    }

    public void setAmortizationcalctype(String amortizationcalctype) {
        this.amortizationcalctype = amortizationcalctype;
    }

    public BigInteger getDepreciatedplan() {
        return depreciatedplan;
    }

    public void setDepreciatedplan(BigInteger depreciatedplan) {
        this.depreciatedplan = depreciatedplan;
    }

    public BigInteger getDepreciatedpreviousamt() {
        return depreciatedpreviousamt;
    }

    public void setDepreciatedpreviousamt(BigInteger depreciatedpreviousamt) {
        this.depreciatedpreviousamt = depreciatedpreviousamt;
    }

    public BigInteger getDepreciatedvalue() {
        return depreciatedvalue;
    }

    public void setDepreciatedvalue(BigInteger depreciatedvalue) {
        this.depreciatedvalue = depreciatedvalue;
    }

    @XmlTransient
    public List<AAssetAcct> getAAssetAcctList() {
        return aAssetAcctList;
    }

    public void setAAssetAcctList(List<AAssetAcct> aAssetAcctList) {
        this.aAssetAcctList = aAssetAcctList;
    }

    @XmlTransient
    public List<FactAcct> getFactAcctList() {
        return factAcctList;
    }

    public void setFactAcctList(List<FactAcct> factAcctList) {
        this.factAcctList = factAcctList;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public AAssetGroup getAAssetGroupId() {
        return aAssetGroupId;
    }

    public void setAAssetGroupId(AAssetGroup aAssetGroupId) {
        this.aAssetGroupId = aAssetGroupId;
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

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    public CBpartnerLocation getCBpartnerLocationId() {
        return cBpartnerLocationId;
    }

    public void setCBpartnerLocationId(CBpartnerLocation cBpartnerLocationId) {
        this.cBpartnerLocationId = cBpartnerLocationId;
    }

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CLocation getCLocationId() {
        return cLocationId;
    }

    public void setCLocationId(CLocation cLocationId) {
        this.cLocationId = cLocationId;
    }

    public MAttributesetinstance getMAttributesetinstanceId() {
        return mAttributesetinstanceId;
    }

    public void setMAttributesetinstanceId(MAttributesetinstance mAttributesetinstanceId) {
        this.mAttributesetinstanceId = mAttributesetinstanceId;
    }

    public MLocator getMLocatorId() {
        return mLocatorId;
    }

    public void setMLocatorId(MLocator mLocatorId) {
        this.mLocatorId = mLocatorId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @XmlTransient
    public List<AAmortizationline> getAAmortizationlineList() {
        return aAmortizationlineList;
    }

    public void setAAmortizationlineList(List<AAmortizationline> aAmortizationlineList) {
        this.aAmortizationlineList = aAmortizationlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aAssetId != null ? aAssetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AAsset)) {
            return false;
        }
        AAsset other = (AAsset) object;
        if ((this.aAssetId == null && other.aAssetId != null) || (this.aAssetId != null && !this.aAssetId.equals(other.aAssetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AAsset[ aAssetId=" + aAssetId + " ]";
    }
    
}
