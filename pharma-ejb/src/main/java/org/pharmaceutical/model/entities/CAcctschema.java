/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
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
@Table(name = "c_acctschema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CAcctschema.findAll", query = "SELECT c FROM CAcctschema c"),
    @NamedQuery(name = "CAcctschema.findByCAcctschemaId", query = "SELECT c FROM CAcctschema c WHERE c.cAcctschemaId = :cAcctschemaId"),
    @NamedQuery(name = "CAcctschema.findByIsactive", query = "SELECT c FROM CAcctschema c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CAcctschema.findByCreated", query = "SELECT c FROM CAcctschema c WHERE c.created = :created"),
    @NamedQuery(name = "CAcctschema.findByCreatedby", query = "SELECT c FROM CAcctschema c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CAcctschema.findByUpdated", query = "SELECT c FROM CAcctschema c WHERE c.updated = :updated"),
    @NamedQuery(name = "CAcctschema.findByUpdatedby", query = "SELECT c FROM CAcctschema c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CAcctschema.findByName", query = "SELECT c FROM CAcctschema c WHERE c.name = :name"),
    @NamedQuery(name = "CAcctschema.findByDescription", query = "SELECT c FROM CAcctschema c WHERE c.description = :description"),
    @NamedQuery(name = "CAcctschema.findByGaap", query = "SELECT c FROM CAcctschema c WHERE c.gaap = :gaap"),
    @NamedQuery(name = "CAcctschema.findByIsaccrual", query = "SELECT c FROM CAcctschema c WHERE c.isaccrual = :isaccrual"),
    @NamedQuery(name = "CAcctschema.findByCostingmethod", query = "SELECT c FROM CAcctschema c WHERE c.costingmethod = :costingmethod"),
    @NamedQuery(name = "CAcctschema.findByAutoperiodcontrol", query = "SELECT c FROM CAcctschema c WHERE c.autoperiodcontrol = :autoperiodcontrol"),
    @NamedQuery(name = "CAcctschema.findByPeriodOpenhistory", query = "SELECT c FROM CAcctschema c WHERE c.periodOpenhistory = :periodOpenhistory"),
    @NamedQuery(name = "CAcctschema.findByPeriodOpenfuture", query = "SELECT c FROM CAcctschema c WHERE c.periodOpenfuture = :periodOpenfuture"),
    @NamedQuery(name = "CAcctschema.findBySeparator", query = "SELECT c FROM CAcctschema c WHERE c.separator = :separator"),
    @NamedQuery(name = "CAcctschema.findByHasalias", query = "SELECT c FROM CAcctschema c WHERE c.hasalias = :hasalias"),
    @NamedQuery(name = "CAcctschema.findByHascombination", query = "SELECT c FROM CAcctschema c WHERE c.hascombination = :hascombination"),
    @NamedQuery(name = "CAcctschema.findByIstradediscountposted", query = "SELECT c FROM CAcctschema c WHERE c.istradediscountposted = :istradediscountposted"),
    @NamedQuery(name = "CAcctschema.findByIsdiscountcorrectstax", query = "SELECT c FROM CAcctschema c WHERE c.isdiscountcorrectstax = :isdiscountcorrectstax"),
    @NamedQuery(name = "CAcctschema.findByAllownegative", query = "SELECT c FROM CAcctschema c WHERE c.allownegative = :allownegative")})
public class CAcctschema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_acctschema_id")
    private String cAcctschemaId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "gaap")
    private String gaap;
    @Column(name = "isaccrual")
    private Character isaccrual;
    @Size(max = 60)
    @Column(name = "costingmethod")
    private String costingmethod;
    @Column(name = "autoperiodcontrol")
    private Character autoperiodcontrol;
    @Column(name = "period_openhistory")
    private Long periodOpenhistory;
    @Column(name = "period_openfuture")
    private Long periodOpenfuture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "separator")
    private Character separator;
    @Column(name = "hasalias")
    private Character hasalias;
    @Column(name = "hascombination")
    private Character hascombination;
    @Column(name = "istradediscountposted")
    private Character istradediscountposted;
    @Column(name = "isdiscountcorrectstax")
    private Character isdiscountcorrectstax;
    @Column(name = "allownegative")
    private Character allownegative;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<RResourceplancost> rResourceplancostList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CBpEmployeeAcct> cBpEmployeeAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CProjectAcct> cProjectAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CChargeAcct> cChargeAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<AAssetGroupAcct> aAssetGroupAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cAcctschemaId")
    private List<CAcctschemaProcess> cAcctschemaProcessList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cAcctschemaId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<FinFinancialAccountAcct> finFinancialAccountAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<AAssetAcct> aAssetAcctList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private CAcctschemaDefault cAcctschemaDefault;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<MWarehouseAcct> mWarehouseAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cAcctschemaId")
    private List<CTaxpayment> cTaxpaymentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CValidcombination> cValidcombinationList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<MProductAcct> mProductAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CAcctschemaGl> cAcctschemaGlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CTaxAcct> cTaxAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CBpGroupAcct> cBpGroupAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cAcctschemaId")
    private List<IBudgetline> iBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CInterorgAcct> cInterorgAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CRevenuerecognitionPlan> cRevenuerecognitionPlanList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CGlitemAcct> cGlitemAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<AdOrgAcctschema> adOrgAcctschemaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cAcctschemaId")
    private List<CAcctRpt> cAcctRptList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<MProductCategoryAcct> mProductCategoryAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cAcctschemaId")
    private List<AdAccountingrptElement> adAccountingrptElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CAcctschemaTable> cAcctschemaTableList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CBpVendorAcct> cBpVendorAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cAcctschema3Id")
    private List<AdClientinfo> adClientinfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cAcctschema1Id")
    private List<AdClientinfo> adClientinfoList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cAcctschema2Id")
    private List<AdClientinfo> adClientinfoList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CBpCustomerAcct> cBpCustomerAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CWithholdingAcct> cWithholdingAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cAcctschemaId")
    private List<CBudgetline> cBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CAcctschemaElement> cAcctschemaElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<GlJournal> glJournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CCashbookAcct> cCashbookAcctList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_currency_id", referencedColumnName = "c_currency_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCurrency cCurrencyId;
    @JoinColumn(name = "c_period_id", referencedColumnName = "c_period_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPeriod cPeriodId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cAcctschemaId")
    private List<CBankaccountAcct> cBankaccountAcctList;

    public CAcctschema() {
    }

    public CAcctschema(String cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
    }

    public CAcctschema(String cAcctschemaId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String gaap, Character separator) {
        this.cAcctschemaId = cAcctschemaId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.gaap = gaap;
        this.separator = separator;
    }

    public String getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(String cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
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

    public String getGaap() {
        return gaap;
    }

    public void setGaap(String gaap) {
        this.gaap = gaap;
    }

    public Character getIsaccrual() {
        return isaccrual;
    }

    public void setIsaccrual(Character isaccrual) {
        this.isaccrual = isaccrual;
    }

    public String getCostingmethod() {
        return costingmethod;
    }

    public void setCostingmethod(String costingmethod) {
        this.costingmethod = costingmethod;
    }

    public Character getAutoperiodcontrol() {
        return autoperiodcontrol;
    }

    public void setAutoperiodcontrol(Character autoperiodcontrol) {
        this.autoperiodcontrol = autoperiodcontrol;
    }

    public Long getPeriodOpenhistory() {
        return periodOpenhistory;
    }

    public void setPeriodOpenhistory(Long periodOpenhistory) {
        this.periodOpenhistory = periodOpenhistory;
    }

    public Long getPeriodOpenfuture() {
        return periodOpenfuture;
    }

    public void setPeriodOpenfuture(Long periodOpenfuture) {
        this.periodOpenfuture = periodOpenfuture;
    }

    public Character getSeparator() {
        return separator;
    }

    public void setSeparator(Character separator) {
        this.separator = separator;
    }

    public Character getHasalias() {
        return hasalias;
    }

    public void setHasalias(Character hasalias) {
        this.hasalias = hasalias;
    }

    public Character getHascombination() {
        return hascombination;
    }

    public void setHascombination(Character hascombination) {
        this.hascombination = hascombination;
    }

    public Character getIstradediscountposted() {
        return istradediscountposted;
    }

    public void setIstradediscountposted(Character istradediscountposted) {
        this.istradediscountposted = istradediscountposted;
    }

    public Character getIsdiscountcorrectstax() {
        return isdiscountcorrectstax;
    }

    public void setIsdiscountcorrectstax(Character isdiscountcorrectstax) {
        this.isdiscountcorrectstax = isdiscountcorrectstax;
    }

    public Character getAllownegative() {
        return allownegative;
    }

    public void setAllownegative(Character allownegative) {
        this.allownegative = allownegative;
    }

    @XmlTransient
    public List<RResourceplancost> getRResourceplancostList() {
        return rResourceplancostList;
    }

    public void setRResourceplancostList(List<RResourceplancost> rResourceplancostList) {
        this.rResourceplancostList = rResourceplancostList;
    }

    @XmlTransient
    public List<CBpEmployeeAcct> getCBpEmployeeAcctList() {
        return cBpEmployeeAcctList;
    }

    public void setCBpEmployeeAcctList(List<CBpEmployeeAcct> cBpEmployeeAcctList) {
        this.cBpEmployeeAcctList = cBpEmployeeAcctList;
    }

    @XmlTransient
    public List<CProjectAcct> getCProjectAcctList() {
        return cProjectAcctList;
    }

    public void setCProjectAcctList(List<CProjectAcct> cProjectAcctList) {
        this.cProjectAcctList = cProjectAcctList;
    }

    @XmlTransient
    public List<CChargeAcct> getCChargeAcctList() {
        return cChargeAcctList;
    }

    public void setCChargeAcctList(List<CChargeAcct> cChargeAcctList) {
        this.cChargeAcctList = cChargeAcctList;
    }

    @XmlTransient
    public List<AAssetGroupAcct> getAAssetGroupAcctList() {
        return aAssetGroupAcctList;
    }

    public void setAAssetGroupAcctList(List<AAssetGroupAcct> aAssetGroupAcctList) {
        this.aAssetGroupAcctList = aAssetGroupAcctList;
    }

    @XmlTransient
    public List<CAcctschemaProcess> getCAcctschemaProcessList() {
        return cAcctschemaProcessList;
    }

    public void setCAcctschemaProcessList(List<CAcctschemaProcess> cAcctschemaProcessList) {
        this.cAcctschemaProcessList = cAcctschemaProcessList;
    }

    @XmlTransient
    public List<IGljournal> getIGljournalList() {
        return iGljournalList;
    }

    public void setIGljournalList(List<IGljournal> iGljournalList) {
        this.iGljournalList = iGljournalList;
    }

    @XmlTransient
    public List<FinFinancialAccountAcct> getFinFinancialAccountAcctList() {
        return finFinancialAccountAcctList;
    }

    public void setFinFinancialAccountAcctList(List<FinFinancialAccountAcct> finFinancialAccountAcctList) {
        this.finFinancialAccountAcctList = finFinancialAccountAcctList;
    }

    @XmlTransient
    public List<AAssetAcct> getAAssetAcctList() {
        return aAssetAcctList;
    }

    public void setAAssetAcctList(List<AAssetAcct> aAssetAcctList) {
        this.aAssetAcctList = aAssetAcctList;
    }

    public CAcctschemaDefault getCAcctschemaDefault() {
        return cAcctschemaDefault;
    }

    public void setCAcctschemaDefault(CAcctschemaDefault cAcctschemaDefault) {
        this.cAcctschemaDefault = cAcctschemaDefault;
    }

    @XmlTransient
    public List<MWarehouseAcct> getMWarehouseAcctList() {
        return mWarehouseAcctList;
    }

    public void setMWarehouseAcctList(List<MWarehouseAcct> mWarehouseAcctList) {
        this.mWarehouseAcctList = mWarehouseAcctList;
    }

    @XmlTransient
    public List<CTaxpayment> getCTaxpaymentList() {
        return cTaxpaymentList;
    }

    public void setCTaxpaymentList(List<CTaxpayment> cTaxpaymentList) {
        this.cTaxpaymentList = cTaxpaymentList;
    }

    @XmlTransient
    public List<CValidcombination> getCValidcombinationList() {
        return cValidcombinationList;
    }

    public void setCValidcombinationList(List<CValidcombination> cValidcombinationList) {
        this.cValidcombinationList = cValidcombinationList;
    }

    @XmlTransient
    public List<MProductAcct> getMProductAcctList() {
        return mProductAcctList;
    }

    public void setMProductAcctList(List<MProductAcct> mProductAcctList) {
        this.mProductAcctList = mProductAcctList;
    }

    @XmlTransient
    public List<CAcctschemaGl> getCAcctschemaGlList() {
        return cAcctschemaGlList;
    }

    public void setCAcctschemaGlList(List<CAcctschemaGl> cAcctschemaGlList) {
        this.cAcctschemaGlList = cAcctschemaGlList;
    }

    @XmlTransient
    public List<CTaxAcct> getCTaxAcctList() {
        return cTaxAcctList;
    }

    public void setCTaxAcctList(List<CTaxAcct> cTaxAcctList) {
        this.cTaxAcctList = cTaxAcctList;
    }

    @XmlTransient
    public List<CBpGroupAcct> getCBpGroupAcctList() {
        return cBpGroupAcctList;
    }

    public void setCBpGroupAcctList(List<CBpGroupAcct> cBpGroupAcctList) {
        this.cBpGroupAcctList = cBpGroupAcctList;
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
    public List<CInterorgAcct> getCInterorgAcctList() {
        return cInterorgAcctList;
    }

    public void setCInterorgAcctList(List<CInterorgAcct> cInterorgAcctList) {
        this.cInterorgAcctList = cInterorgAcctList;
    }

    @XmlTransient
    public List<CRevenuerecognitionPlan> getCRevenuerecognitionPlanList() {
        return cRevenuerecognitionPlanList;
    }

    public void setCRevenuerecognitionPlanList(List<CRevenuerecognitionPlan> cRevenuerecognitionPlanList) {
        this.cRevenuerecognitionPlanList = cRevenuerecognitionPlanList;
    }

    @XmlTransient
    public List<CGlitemAcct> getCGlitemAcctList() {
        return cGlitemAcctList;
    }

    public void setCGlitemAcctList(List<CGlitemAcct> cGlitemAcctList) {
        this.cGlitemAcctList = cGlitemAcctList;
    }

    @XmlTransient
    public List<AdOrgAcctschema> getAdOrgAcctschemaList() {
        return adOrgAcctschemaList;
    }

    public void setAdOrgAcctschemaList(List<AdOrgAcctschema> adOrgAcctschemaList) {
        this.adOrgAcctschemaList = adOrgAcctschemaList;
    }

    @XmlTransient
    public List<CAcctRpt> getCAcctRptList() {
        return cAcctRptList;
    }

    public void setCAcctRptList(List<CAcctRpt> cAcctRptList) {
        this.cAcctRptList = cAcctRptList;
    }

    @XmlTransient
    public List<MProductCategoryAcct> getMProductCategoryAcctList() {
        return mProductCategoryAcctList;
    }

    public void setMProductCategoryAcctList(List<MProductCategoryAcct> mProductCategoryAcctList) {
        this.mProductCategoryAcctList = mProductCategoryAcctList;
    }

    @XmlTransient
    public List<AdAccountingrptElement> getAdAccountingrptElementList() {
        return adAccountingrptElementList;
    }

    public void setAdAccountingrptElementList(List<AdAccountingrptElement> adAccountingrptElementList) {
        this.adAccountingrptElementList = adAccountingrptElementList;
    }

    @XmlTransient
    public List<CAcctschemaTable> getCAcctschemaTableList() {
        return cAcctschemaTableList;
    }

    public void setCAcctschemaTableList(List<CAcctschemaTable> cAcctschemaTableList) {
        this.cAcctschemaTableList = cAcctschemaTableList;
    }

    @XmlTransient
    public List<CBpVendorAcct> getCBpVendorAcctList() {
        return cBpVendorAcctList;
    }

    public void setCBpVendorAcctList(List<CBpVendorAcct> cBpVendorAcctList) {
        this.cBpVendorAcctList = cBpVendorAcctList;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList() {
        return adClientinfoList;
    }

    public void setAdClientinfoList(List<AdClientinfo> adClientinfoList) {
        this.adClientinfoList = adClientinfoList;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList1() {
        return adClientinfoList1;
    }

    public void setAdClientinfoList1(List<AdClientinfo> adClientinfoList1) {
        this.adClientinfoList1 = adClientinfoList1;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList2() {
        return adClientinfoList2;
    }

    public void setAdClientinfoList2(List<AdClientinfo> adClientinfoList2) {
        this.adClientinfoList2 = adClientinfoList2;
    }

    @XmlTransient
    public List<CBpCustomerAcct> getCBpCustomerAcctList() {
        return cBpCustomerAcctList;
    }

    public void setCBpCustomerAcctList(List<CBpCustomerAcct> cBpCustomerAcctList) {
        this.cBpCustomerAcctList = cBpCustomerAcctList;
    }

    @XmlTransient
    public List<CWithholdingAcct> getCWithholdingAcctList() {
        return cWithholdingAcctList;
    }

    public void setCWithholdingAcctList(List<CWithholdingAcct> cWithholdingAcctList) {
        this.cWithholdingAcctList = cWithholdingAcctList;
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
    public List<CCashbookAcct> getCCashbookAcctList() {
        return cCashbookAcctList;
    }

    public void setCCashbookAcctList(List<CCashbookAcct> cCashbookAcctList) {
        this.cCashbookAcctList = cCashbookAcctList;
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

    public CCurrency getCCurrencyId() {
        return cCurrencyId;
    }

    public void setCCurrencyId(CCurrency cCurrencyId) {
        this.cCurrencyId = cCurrencyId;
    }

    public CPeriod getCPeriodId() {
        return cPeriodId;
    }

    public void setCPeriodId(CPeriod cPeriodId) {
        this.cPeriodId = cPeriodId;
    }

    @XmlTransient
    public List<CBankaccountAcct> getCBankaccountAcctList() {
        return cBankaccountAcctList;
    }

    public void setCBankaccountAcctList(List<CBankaccountAcct> cBankaccountAcctList) {
        this.cBankaccountAcctList = cBankaccountAcctList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cAcctschemaId != null ? cAcctschemaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CAcctschema)) {
            return false;
        }
        CAcctschema other = (CAcctschema) object;
        if ((this.cAcctschemaId == null && other.cAcctschemaId != null) || (this.cAcctschemaId != null && !this.cAcctschemaId.equals(other.cAcctschemaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CAcctschema[ cAcctschemaId=" + cAcctschemaId + " ]";
    }
    
}
