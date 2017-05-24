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
@Table(name = "c_tax")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTax.findAll", query = "SELECT c FROM CTax c"),
    @NamedQuery(name = "CTax.findByCTaxId", query = "SELECT c FROM CTax c WHERE c.cTaxId = :cTaxId"),
    @NamedQuery(name = "CTax.findByIsactive", query = "SELECT c FROM CTax c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CTax.findByCreated", query = "SELECT c FROM CTax c WHERE c.created = :created"),
    @NamedQuery(name = "CTax.findByCreatedby", query = "SELECT c FROM CTax c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CTax.findByUpdated", query = "SELECT c FROM CTax c WHERE c.updated = :updated"),
    @NamedQuery(name = "CTax.findByName", query = "SELECT c FROM CTax c WHERE c.name = :name"),
    @NamedQuery(name = "CTax.findByUpdatedby", query = "SELECT c FROM CTax c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CTax.findByDescription", query = "SELECT c FROM CTax c WHERE c.description = :description"),
    @NamedQuery(name = "CTax.findByTaxindicator", query = "SELECT c FROM CTax c WHERE c.taxindicator = :taxindicator"),
    @NamedQuery(name = "CTax.findByValidfrom", query = "SELECT c FROM CTax c WHERE c.validfrom = :validfrom"),
    @NamedQuery(name = "CTax.findByIssummary", query = "SELECT c FROM CTax c WHERE c.issummary = :issummary"),
    @NamedQuery(name = "CTax.findByRate", query = "SELECT c FROM CTax c WHERE c.rate = :rate"),
    @NamedQuery(name = "CTax.findByIsdefault", query = "SELECT c FROM CTax c WHERE c.isdefault = :isdefault"),
    @NamedQuery(name = "CTax.findByIstaxexempt", query = "SELECT c FROM CTax c WHERE c.istaxexempt = :istaxexempt"),
    @NamedQuery(name = "CTax.findBySopotype", query = "SELECT c FROM CTax c WHERE c.sopotype = :sopotype"),
    @NamedQuery(name = "CTax.findByCascade", query = "SELECT c FROM CTax c WHERE c.cascade = :cascade"),
    @NamedQuery(name = "CTax.findByLine", query = "SELECT c FROM CTax c WHERE c.line = :line"),
    @NamedQuery(name = "CTax.findByIswithholdingtax", query = "SELECT c FROM CTax c WHERE c.iswithholdingtax = :iswithholdingtax"),
    @NamedQuery(name = "CTax.findByIsnotaxable", query = "SELECT c FROM CTax c WHERE c.isnotaxable = :isnotaxable"),
    @NamedQuery(name = "CTax.findByDeducpercent", query = "SELECT c FROM CTax c WHERE c.deducpercent = :deducpercent"),
    @NamedQuery(name = "CTax.findByOriginalrate", query = "SELECT c FROM CTax c WHERE c.originalrate = :originalrate"),
    @NamedQuery(name = "CTax.findByIstaxundeductable", query = "SELECT c FROM CTax c WHERE c.istaxundeductable = :istaxundeductable"),
    @NamedQuery(name = "CTax.findByIstaxdeductable", query = "SELECT c FROM CTax c WHERE c.istaxdeductable = :istaxdeductable"),
    @NamedQuery(name = "CTax.findByIsnovat", query = "SELECT c FROM CTax c WHERE c.isnovat = :isnovat"),
    @NamedQuery(name = "CTax.findByBaseamount", query = "SELECT c FROM CTax c WHERE c.baseamount = :baseamount"),
    @NamedQuery(name = "CTax.findByDoctaxamount", query = "SELECT c FROM CTax c WHERE c.doctaxamount = :doctaxamount"),
    @NamedQuery(name = "CTax.findByIscashvat", query = "SELECT c FROM CTax c WHERE c.iscashvat = :iscashvat")})
public class CTax implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_tax_id")
    private String cTaxId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 5)
    @Column(name = "taxindicator")
    private String taxindicator;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validfrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validfrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issummary")
    private Character issummary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate")
    private BigInteger rate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdefault")
    private Character isdefault;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istaxexempt")
    private Character istaxexempt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "sopotype")
    private String sopotype;
    @Column(name = "cascade")
    private Character cascade;
    @Column(name = "line")
    private BigInteger line;
    @Column(name = "iswithholdingtax")
    private Character iswithholdingtax;
    @Column(name = "isnotaxable")
    private Character isnotaxable;
    @Column(name = "deducpercent")
    private Long deducpercent;
    @Column(name = "originalrate")
    private Long originalrate;
    @Column(name = "istaxundeductable")
    private Character istaxundeductable;
    @Column(name = "istaxdeductable")
    private Character istaxdeductable;
    @Column(name = "isnovat")
    private Character isnovat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "baseamount")
    private String baseamount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "doctaxamount")
    private String doctaxamount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iscashvat")
    private Character iscashvat;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxId")
    private List<IInvoice> iInvoiceList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bp_taxcategory_id", referencedColumnName = "c_bp_taxcategory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpTaxcategory cBpTaxcategoryId;
    @JoinColumn(name = "c_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCountry cCountryId;
    @JoinColumn(name = "to_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCountry toCountryId;
    @JoinColumn(name = "to_region_id", referencedColumnName = "c_region_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CRegion toRegionId;
    @JoinColumn(name = "c_region_id", referencedColumnName = "c_region_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CRegion cRegionId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "parentTaxId")
    private List<CTax> cTaxList;
    @JoinColumn(name = "parent_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax parentTaxId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxbaseId")
    private List<CTax> cTaxList1;
    @JoinColumn(name = "c_taxbase_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax cTaxbaseId;
    @JoinColumn(name = "c_taxcategory_id", referencedColumnName = "c_taxcategory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CTaxcategory cTaxcategoryId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cTaxId")
    private List<CTaxTrl> cTaxTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxId")
    private List<CTaxReport> cTaxReportList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cTaxId")
    private List<CInvoicelinetax> cInvoicelinetaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cTaxId")
    private List<COrderlinetax> cOrderlinetaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxId")
    private List<CTaxZone> cTaxZoneList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cTaxId")
    private List<CTaxAcct> cTaxAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxId")
    private List<AdOrginfo> adOrginfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cTaxId")
    private List<CInvoicetax> cInvoicetaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxId")
    private List<GlJournalline> glJournallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxId")
    private List<CTaxregisterTypeLines> cTaxregisterTypeLinesList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxId")
    private List<CInvoiceline> cInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxId")
    private List<CTaxregisterline> cTaxregisterlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cTaxId")
    private List<COrdertax> cOrdertaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cTaxId")
    private List<CBpWithholding> cBpWithholdingList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cTaxId")
    private List<COrderline> cOrderlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxId")
    private List<ITax> iTaxList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "parentTaxId")
    private List<ITax> iTaxList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxId")
    private List<CProjectline> cProjectlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxId")
    private List<CGlitem> cGlitemList;

    public CTax() {
    }

    public CTax(String cTaxId) {
        this.cTaxId = cTaxId;
    }

    public CTax(String cTaxId, Character isactive, Date created, String createdby, Date updated, String name, String updatedby, Date validfrom, Character issummary, BigInteger rate, Character isdefault, Character istaxexempt, String sopotype, String baseamount, String doctaxamount, Character iscashvat) {
        this.cTaxId = cTaxId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.name = name;
        this.updatedby = updatedby;
        this.validfrom = validfrom;
        this.issummary = issummary;
        this.rate = rate;
        this.isdefault = isdefault;
        this.istaxexempt = istaxexempt;
        this.sopotype = sopotype;
        this.baseamount = baseamount;
        this.doctaxamount = doctaxamount;
        this.iscashvat = iscashvat;
    }

    public String getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(String cTaxId) {
        this.cTaxId = cTaxId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
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

    public Character getCascade() {
        return cascade;
    }

    public void setCascade(Character cascade) {
        this.cascade = cascade;
    }

    public BigInteger getLine() {
        return line;
    }

    public void setLine(BigInteger line) {
        this.line = line;
    }

    public Character getIswithholdingtax() {
        return iswithholdingtax;
    }

    public void setIswithholdingtax(Character iswithholdingtax) {
        this.iswithholdingtax = iswithholdingtax;
    }

    public Character getIsnotaxable() {
        return isnotaxable;
    }

    public void setIsnotaxable(Character isnotaxable) {
        this.isnotaxable = isnotaxable;
    }

    public Long getDeducpercent() {
        return deducpercent;
    }

    public void setDeducpercent(Long deducpercent) {
        this.deducpercent = deducpercent;
    }

    public Long getOriginalrate() {
        return originalrate;
    }

    public void setOriginalrate(Long originalrate) {
        this.originalrate = originalrate;
    }

    public Character getIstaxundeductable() {
        return istaxundeductable;
    }

    public void setIstaxundeductable(Character istaxundeductable) {
        this.istaxundeductable = istaxundeductable;
    }

    public Character getIstaxdeductable() {
        return istaxdeductable;
    }

    public void setIstaxdeductable(Character istaxdeductable) {
        this.istaxdeductable = istaxdeductable;
    }

    public Character getIsnovat() {
        return isnovat;
    }

    public void setIsnovat(Character isnovat) {
        this.isnovat = isnovat;
    }

    public String getBaseamount() {
        return baseamount;
    }

    public void setBaseamount(String baseamount) {
        this.baseamount = baseamount;
    }

    public String getDoctaxamount() {
        return doctaxamount;
    }

    public void setDoctaxamount(String doctaxamount) {
        this.doctaxamount = doctaxamount;
    }

    public Character getIscashvat() {
        return iscashvat;
    }

    public void setIscashvat(Character iscashvat) {
        this.iscashvat = iscashvat;
    }

    @XmlTransient
    public List<IInvoice> getIInvoiceList() {
        return iInvoiceList;
    }

    public void setIInvoiceList(List<IInvoice> iInvoiceList) {
        this.iInvoiceList = iInvoiceList;
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

    public CCountry getCCountryId() {
        return cCountryId;
    }

    public void setCCountryId(CCountry cCountryId) {
        this.cCountryId = cCountryId;
    }

    public CCountry getToCountryId() {
        return toCountryId;
    }

    public void setToCountryId(CCountry toCountryId) {
        this.toCountryId = toCountryId;
    }

    public CRegion getToRegionId() {
        return toRegionId;
    }

    public void setToRegionId(CRegion toRegionId) {
        this.toRegionId = toRegionId;
    }

    public CRegion getCRegionId() {
        return cRegionId;
    }

    public void setCRegionId(CRegion cRegionId) {
        this.cRegionId = cRegionId;
    }

    @XmlTransient
    public List<CTax> getCTaxList() {
        return cTaxList;
    }

    public void setCTaxList(List<CTax> cTaxList) {
        this.cTaxList = cTaxList;
    }

    public CTax getParentTaxId() {
        return parentTaxId;
    }

    public void setParentTaxId(CTax parentTaxId) {
        this.parentTaxId = parentTaxId;
    }

    @XmlTransient
    public List<CTax> getCTaxList1() {
        return cTaxList1;
    }

    public void setCTaxList1(List<CTax> cTaxList1) {
        this.cTaxList1 = cTaxList1;
    }

    public CTax getCTaxbaseId() {
        return cTaxbaseId;
    }

    public void setCTaxbaseId(CTax cTaxbaseId) {
        this.cTaxbaseId = cTaxbaseId;
    }

    public CTaxcategory getCTaxcategoryId() {
        return cTaxcategoryId;
    }

    public void setCTaxcategoryId(CTaxcategory cTaxcategoryId) {
        this.cTaxcategoryId = cTaxcategoryId;
    }

    @XmlTransient
    public List<CTaxTrl> getCTaxTrlList() {
        return cTaxTrlList;
    }

    public void setCTaxTrlList(List<CTaxTrl> cTaxTrlList) {
        this.cTaxTrlList = cTaxTrlList;
    }

    @XmlTransient
    public List<CTaxReport> getCTaxReportList() {
        return cTaxReportList;
    }

    public void setCTaxReportList(List<CTaxReport> cTaxReportList) {
        this.cTaxReportList = cTaxReportList;
    }

    @XmlTransient
    public List<CInvoicelinetax> getCInvoicelinetaxList() {
        return cInvoicelinetaxList;
    }

    public void setCInvoicelinetaxList(List<CInvoicelinetax> cInvoicelinetaxList) {
        this.cInvoicelinetaxList = cInvoicelinetaxList;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<COrderlinetax> getCOrderlinetaxList() {
        return cOrderlinetaxList;
    }

    public void setCOrderlinetaxList(List<COrderlinetax> cOrderlinetaxList) {
        this.cOrderlinetaxList = cOrderlinetaxList;
    }

    @XmlTransient
    public List<CTaxZone> getCTaxZoneList() {
        return cTaxZoneList;
    }

    public void setCTaxZoneList(List<CTaxZone> cTaxZoneList) {
        this.cTaxZoneList = cTaxZoneList;
    }

    @XmlTransient
    public List<CTaxAcct> getCTaxAcctList() {
        return cTaxAcctList;
    }

    public void setCTaxAcctList(List<CTaxAcct> cTaxAcctList) {
        this.cTaxAcctList = cTaxAcctList;
    }

    @XmlTransient
    public List<FactAcct> getFactAcctList() {
        return factAcctList;
    }

    public void setFactAcctList(List<FactAcct> factAcctList) {
        this.factAcctList = factAcctList;
    }

    @XmlTransient
    public List<AdOrginfo> getAdOrginfoList() {
        return adOrginfoList;
    }

    public void setAdOrginfoList(List<AdOrginfo> adOrginfoList) {
        this.adOrginfoList = adOrginfoList;
    }

    @XmlTransient
    public List<CInvoicetax> getCInvoicetaxList() {
        return cInvoicetaxList;
    }

    public void setCInvoicetaxList(List<CInvoicetax> cInvoicetaxList) {
        this.cInvoicetaxList = cInvoicetaxList;
    }

    @XmlTransient
    public List<GlJournalline> getGlJournallineList() {
        return glJournallineList;
    }

    public void setGlJournallineList(List<GlJournalline> glJournallineList) {
        this.glJournallineList = glJournallineList;
    }

    @XmlTransient
    public List<CTaxregisterTypeLines> getCTaxregisterTypeLinesList() {
        return cTaxregisterTypeLinesList;
    }

    public void setCTaxregisterTypeLinesList(List<CTaxregisterTypeLines> cTaxregisterTypeLinesList) {
        this.cTaxregisterTypeLinesList = cTaxregisterTypeLinesList;
    }

    @XmlTransient
    public List<CInvoiceline> getCInvoicelineList() {
        return cInvoicelineList;
    }

    public void setCInvoicelineList(List<CInvoiceline> cInvoicelineList) {
        this.cInvoicelineList = cInvoicelineList;
    }

    @XmlTransient
    public List<CTaxregisterline> getCTaxregisterlineList() {
        return cTaxregisterlineList;
    }

    public void setCTaxregisterlineList(List<CTaxregisterline> cTaxregisterlineList) {
        this.cTaxregisterlineList = cTaxregisterlineList;
    }

    @XmlTransient
    public List<COrdertax> getCOrdertaxList() {
        return cOrdertaxList;
    }

    public void setCOrdertaxList(List<COrdertax> cOrdertaxList) {
        this.cOrdertaxList = cOrdertaxList;
    }

    @XmlTransient
    public List<CBpWithholding> getCBpWithholdingList() {
        return cBpWithholdingList;
    }

    public void setCBpWithholdingList(List<CBpWithholding> cBpWithholdingList) {
        this.cBpWithholdingList = cBpWithholdingList;
    }

    @XmlTransient
    public List<COrderline> getCOrderlineList() {
        return cOrderlineList;
    }

    public void setCOrderlineList(List<COrderline> cOrderlineList) {
        this.cOrderlineList = cOrderlineList;
    }

    @XmlTransient
    public List<ITax> getITaxList() {
        return iTaxList;
    }

    public void setITaxList(List<ITax> iTaxList) {
        this.iTaxList = iTaxList;
    }

    @XmlTransient
    public List<ITax> getITaxList1() {
        return iTaxList1;
    }

    public void setITaxList1(List<ITax> iTaxList1) {
        this.iTaxList1 = iTaxList1;
    }

    @XmlTransient
    public List<CProjectline> getCProjectlineList() {
        return cProjectlineList;
    }

    public void setCProjectlineList(List<CProjectline> cProjectlineList) {
        this.cProjectlineList = cProjectlineList;
    }

    @XmlTransient
    public List<CGlitem> getCGlitemList() {
        return cGlitemList;
    }

    public void setCGlitemList(List<CGlitem> cGlitemList) {
        this.cGlitemList = cGlitemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTaxId != null ? cTaxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTax)) {
            return false;
        }
        CTax other = (CTax) object;
        if ((this.cTaxId == null && other.cTaxId != null) || (this.cTaxId != null && !this.cTaxId.equals(other.cTaxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CTax[ cTaxId=" + cTaxId + " ]";
    }
    
}
