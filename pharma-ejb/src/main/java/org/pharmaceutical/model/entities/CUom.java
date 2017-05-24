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
@Table(name = "c_uom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CUom.findAll", query = "SELECT c FROM CUom c"),
    @NamedQuery(name = "CUom.findByCUomId", query = "SELECT c FROM CUom c WHERE c.cUomId = :cUomId"),
    @NamedQuery(name = "CUom.findByIsactive", query = "SELECT c FROM CUom c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CUom.findByCreated", query = "SELECT c FROM CUom c WHERE c.created = :created"),
    @NamedQuery(name = "CUom.findByUpdated", query = "SELECT c FROM CUom c WHERE c.updated = :updated"),
    @NamedQuery(name = "CUom.findByCreatedby", query = "SELECT c FROM CUom c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CUom.findByUpdatedby", query = "SELECT c FROM CUom c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CUom.findByX12de355", query = "SELECT c FROM CUom c WHERE c.x12de355 = :x12de355"),
    @NamedQuery(name = "CUom.findByUomsymbol", query = "SELECT c FROM CUom c WHERE c.uomsymbol = :uomsymbol"),
    @NamedQuery(name = "CUom.findByName", query = "SELECT c FROM CUom c WHERE c.name = :name"),
    @NamedQuery(name = "CUom.findByDescription", query = "SELECT c FROM CUom c WHERE c.description = :description"),
    @NamedQuery(name = "CUom.findByStdprecision", query = "SELECT c FROM CUom c WHERE c.stdprecision = :stdprecision"),
    @NamedQuery(name = "CUom.findByCostingprecision", query = "SELECT c FROM CUom c WHERE c.costingprecision = :costingprecision"),
    @NamedQuery(name = "CUom.findByIsdefault", query = "SELECT c FROM CUom c WHERE c.isdefault = :isdefault"),
    @NamedQuery(name = "CUom.findByBreakdown", query = "SELECT c FROM CUom c WHERE c.breakdown = :breakdown")})
public class CUom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_uom_id")
    private String cUomId;
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
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "x12de355")
    private String x12de355;
    @Size(max = 3)
    @Column(name = "uomsymbol")
    private String uomsymbol;
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
    @Column(name = "stdprecision")
    private long stdprecision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costingprecision")
    private long costingprecision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdefault")
    private Character isdefault;
    @Column(name = "breakdown")
    private Character breakdown;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cUomId")
    private List<MProductionline> mProductionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cUomId")
    private List<MProduct> mProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<AdTest> adTestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<STimeexpenseline> sTimeexpenselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<IGljournal> iGljournalList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<IProduct> iProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cUomToId")
    private List<CUomConversion> cUomConversionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cUomId")
    private List<CUomConversion> cUomConversionList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<MProductPo> mProductPoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<MInternalConsumptionline> mInternalConsumptionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cUomId")
    private List<MaGlobaluse> maGlobaluseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<IBudgetline> iBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<FactAcct> factAcctList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<MRequisitionline> mRequisitionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<MInventoryline> mInventorylineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cUomId")
    private List<MaSequenceproduct> maSequenceproductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<GlJournalline> glJournallineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cUomId")
    private List<MTransaction> mTransactionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<CInvoiceline> cInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cUomId")
    private List<MStoragePending> mStoragePendingList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cUomId")
    private List<MStorageDetail> mStorageDetailList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<SExpensetype> sExpensetypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cUomId")
    private List<SResourcetype> sResourcetypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cUomId")
    private List<MMovementline> mMovementlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cUomId")
    private List<COrderline> cOrderlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cUomId")
    private List<MProductUom> mProductUomList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomVolumeId")
    private List<AdClientinfo> adClientinfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomWeightId")
    private List<AdClientinfo> adClientinfoList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomTimeId")
    private List<AdClientinfo> adClientinfoList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomLengthId")
    private List<AdClientinfo> adClientinfoList3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<CBudgetline> cBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cUomId")
    private List<CUomTrl> cUomTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cUomId")
    private List<MaWrphaseproduct> maWrphaseproductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cUomId")
    private List<MInoutline> mInoutlineList;

    public CUom() {
    }

    public CUom(String cUomId) {
        this.cUomId = cUomId;
    }

    public CUom(String cUomId, Character isactive, Date created, Date updated, String createdby, String updatedby, String x12de355, String name, long stdprecision, long costingprecision, Character isdefault) {
        this.cUomId = cUomId;
        this.isactive = isactive;
        this.created = created;
        this.updated = updated;
        this.createdby = createdby;
        this.updatedby = updatedby;
        this.x12de355 = x12de355;
        this.name = name;
        this.stdprecision = stdprecision;
        this.costingprecision = costingprecision;
        this.isdefault = isdefault;
    }

    public String getCUomId() {
        return cUomId;
    }

    public void setCUomId(String cUomId) {
        this.cUomId = cUomId;
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

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public String getX12de355() {
        return x12de355;
    }

    public void setX12de355(String x12de355) {
        this.x12de355 = x12de355;
    }

    public String getUomsymbol() {
        return uomsymbol;
    }

    public void setUomsymbol(String uomsymbol) {
        this.uomsymbol = uomsymbol;
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

    public long getStdprecision() {
        return stdprecision;
    }

    public void setStdprecision(long stdprecision) {
        this.stdprecision = stdprecision;
    }

    public long getCostingprecision() {
        return costingprecision;
    }

    public void setCostingprecision(long costingprecision) {
        this.costingprecision = costingprecision;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    public Character getBreakdown() {
        return breakdown;
    }

    public void setBreakdown(Character breakdown) {
        this.breakdown = breakdown;
    }

    @XmlTransient
    public List<MProductionline> getMProductionlineList() {
        return mProductionlineList;
    }

    public void setMProductionlineList(List<MProductionline> mProductionlineList) {
        this.mProductionlineList = mProductionlineList;
    }

    @XmlTransient
    public List<MProduct> getMProductList() {
        return mProductList;
    }

    public void setMProductList(List<MProduct> mProductList) {
        this.mProductList = mProductList;
    }

    @XmlTransient
    public List<AdTest> getAdTestList() {
        return adTestList;
    }

    public void setAdTestList(List<AdTest> adTestList) {
        this.adTestList = adTestList;
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
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<IProduct> getIProductList() {
        return iProductList;
    }

    public void setIProductList(List<IProduct> iProductList) {
        this.iProductList = iProductList;
    }

    @XmlTransient
    public List<CUomConversion> getCUomConversionList() {
        return cUomConversionList;
    }

    public void setCUomConversionList(List<CUomConversion> cUomConversionList) {
        this.cUomConversionList = cUomConversionList;
    }

    @XmlTransient
    public List<CUomConversion> getCUomConversionList1() {
        return cUomConversionList1;
    }

    public void setCUomConversionList1(List<CUomConversion> cUomConversionList1) {
        this.cUomConversionList1 = cUomConversionList1;
    }

    @XmlTransient
    public List<MProductPo> getMProductPoList() {
        return mProductPoList;
    }

    public void setMProductPoList(List<MProductPo> mProductPoList) {
        this.mProductPoList = mProductPoList;
    }

    @XmlTransient
    public List<MInternalConsumptionline> getMInternalConsumptionlineList() {
        return mInternalConsumptionlineList;
    }

    public void setMInternalConsumptionlineList(List<MInternalConsumptionline> mInternalConsumptionlineList) {
        this.mInternalConsumptionlineList = mInternalConsumptionlineList;
    }

    @XmlTransient
    public List<MaGlobaluse> getMaGlobaluseList() {
        return maGlobaluseList;
    }

    public void setMaGlobaluseList(List<MaGlobaluse> maGlobaluseList) {
        this.maGlobaluseList = maGlobaluseList;
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
    public List<MRequisitionline> getMRequisitionlineList() {
        return mRequisitionlineList;
    }

    public void setMRequisitionlineList(List<MRequisitionline> mRequisitionlineList) {
        this.mRequisitionlineList = mRequisitionlineList;
    }

    @XmlTransient
    public List<MInventoryline> getMInventorylineList() {
        return mInventorylineList;
    }

    public void setMInventorylineList(List<MInventoryline> mInventorylineList) {
        this.mInventorylineList = mInventorylineList;
    }

    @XmlTransient
    public List<MaSequenceproduct> getMaSequenceproductList() {
        return maSequenceproductList;
    }

    public void setMaSequenceproductList(List<MaSequenceproduct> maSequenceproductList) {
        this.maSequenceproductList = maSequenceproductList;
    }

    @XmlTransient
    public List<GlJournalline> getGlJournallineList() {
        return glJournallineList;
    }

    public void setGlJournallineList(List<GlJournalline> glJournallineList) {
        this.glJournallineList = glJournallineList;
    }

    @XmlTransient
    public List<MTransaction> getMTransactionList() {
        return mTransactionList;
    }

    public void setMTransactionList(List<MTransaction> mTransactionList) {
        this.mTransactionList = mTransactionList;
    }

    @XmlTransient
    public List<CInvoiceline> getCInvoicelineList() {
        return cInvoicelineList;
    }

    public void setCInvoicelineList(List<CInvoiceline> cInvoicelineList) {
        this.cInvoicelineList = cInvoicelineList;
    }

    @XmlTransient
    public List<MStoragePending> getMStoragePendingList() {
        return mStoragePendingList;
    }

    public void setMStoragePendingList(List<MStoragePending> mStoragePendingList) {
        this.mStoragePendingList = mStoragePendingList;
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

    @XmlTransient
    public List<MStorageDetail> getMStorageDetailList() {
        return mStorageDetailList;
    }

    public void setMStorageDetailList(List<MStorageDetail> mStorageDetailList) {
        this.mStorageDetailList = mStorageDetailList;
    }

    @XmlTransient
    public List<SExpensetype> getSExpensetypeList() {
        return sExpensetypeList;
    }

    public void setSExpensetypeList(List<SExpensetype> sExpensetypeList) {
        this.sExpensetypeList = sExpensetypeList;
    }

    @XmlTransient
    public List<SResourcetype> getSResourcetypeList() {
        return sResourcetypeList;
    }

    public void setSResourcetypeList(List<SResourcetype> sResourcetypeList) {
        this.sResourcetypeList = sResourcetypeList;
    }

    @XmlTransient
    public List<MMovementline> getMMovementlineList() {
        return mMovementlineList;
    }

    public void setMMovementlineList(List<MMovementline> mMovementlineList) {
        this.mMovementlineList = mMovementlineList;
    }

    @XmlTransient
    public List<COrderline> getCOrderlineList() {
        return cOrderlineList;
    }

    public void setCOrderlineList(List<COrderline> cOrderlineList) {
        this.cOrderlineList = cOrderlineList;
    }

    @XmlTransient
    public List<MProductUom> getMProductUomList() {
        return mProductUomList;
    }

    public void setMProductUomList(List<MProductUom> mProductUomList) {
        this.mProductUomList = mProductUomList;
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
    public List<AdClientinfo> getAdClientinfoList3() {
        return adClientinfoList3;
    }

    public void setAdClientinfoList3(List<AdClientinfo> adClientinfoList3) {
        this.adClientinfoList3 = adClientinfoList3;
    }

    @XmlTransient
    public List<CBudgetline> getCBudgetlineList() {
        return cBudgetlineList;
    }

    public void setCBudgetlineList(List<CBudgetline> cBudgetlineList) {
        this.cBudgetlineList = cBudgetlineList;
    }

    @XmlTransient
    public List<CUomTrl> getCUomTrlList() {
        return cUomTrlList;
    }

    public void setCUomTrlList(List<CUomTrl> cUomTrlList) {
        this.cUomTrlList = cUomTrlList;
    }

    @XmlTransient
    public List<MaWrphaseproduct> getMaWrphaseproductList() {
        return maWrphaseproductList;
    }

    public void setMaWrphaseproductList(List<MaWrphaseproduct> maWrphaseproductList) {
        this.maWrphaseproductList = maWrphaseproductList;
    }

    @XmlTransient
    public List<MInoutline> getMInoutlineList() {
        return mInoutlineList;
    }

    public void setMInoutlineList(List<MInoutline> mInoutlineList) {
        this.mInoutlineList = mInoutlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cUomId != null ? cUomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CUom)) {
            return false;
        }
        CUom other = (CUom) object;
        if ((this.cUomId == null && other.cUomId != null) || (this.cUomId != null && !this.cUomId.equals(other.cUomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CUom[ cUomId=" + cUomId + " ]";
    }
    
}
