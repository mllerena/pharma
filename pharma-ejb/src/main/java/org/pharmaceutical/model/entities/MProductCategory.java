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
@Table(name = "m_product_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MProductCategory.findAll", query = "SELECT m FROM MProductCategory m"),
    @NamedQuery(name = "MProductCategory.findByMProductCategoryId", query = "SELECT m FROM MProductCategory m WHERE m.mProductCategoryId = :mProductCategoryId"),
    @NamedQuery(name = "MProductCategory.findByIsactive", query = "SELECT m FROM MProductCategory m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MProductCategory.findByCreated", query = "SELECT m FROM MProductCategory m WHERE m.created = :created"),
    @NamedQuery(name = "MProductCategory.findByCreatedby", query = "SELECT m FROM MProductCategory m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MProductCategory.findByUpdated", query = "SELECT m FROM MProductCategory m WHERE m.updated = :updated"),
    @NamedQuery(name = "MProductCategory.findByUpdatedby", query = "SELECT m FROM MProductCategory m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MProductCategory.findByValue", query = "SELECT m FROM MProductCategory m WHERE m.value = :value"),
    @NamedQuery(name = "MProductCategory.findByName", query = "SELECT m FROM MProductCategory m WHERE m.name = :name"),
    @NamedQuery(name = "MProductCategory.findByDescription", query = "SELECT m FROM MProductCategory m WHERE m.description = :description"),
    @NamedQuery(name = "MProductCategory.findByIsdefault", query = "SELECT m FROM MProductCategory m WHERE m.isdefault = :isdefault"),
    @NamedQuery(name = "MProductCategory.findByPlannedmargin", query = "SELECT m FROM MProductCategory m WHERE m.plannedmargin = :plannedmargin")})
public class MProductCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_product_category_id")
    private String mProductCategoryId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdefault")
    private Character isdefault;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plannedmargin")
    private BigInteger plannedmargin;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductCategoryId")
    private List<CExternalposCategory> cExternalposCategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductCategoryId")
    private List<MRappelProductcategory> mRappelProductcategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductCategoryId")
    private List<MProduct> mProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductCategoryId")
    private List<MrpRunPurchase> mrpRunPurchaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductCategoryId")
    private List<IProduct> iProductList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductCategoryId")
    private List<IBudgetline> iBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductCategoryId")
    private List<MrpRunProduction> mrpRunProductionList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductCategoryId")
    private List<CCommissionline> cCommissionlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductCategoryId")
    private List<MPerpetualinv> mPerpetualinvList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductCategoryId")
    private List<MProductCategoryAcct> mProductCategoryAcctList;
    @JoinColumn(name = "a_asset_group_id", referencedColumnName = "a_asset_group_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AAssetGroup aAssetGroupId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductCategoryId")
    private List<SExpensetype> sExpensetypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductCategoryId")
    private List<SResourcetype> sResourcetypeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductCategoryId")
    private List<CProjectline> cProjectlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductCategoryId")
    private List<MDiscountschemaline> mDiscountschemalineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mProductCategoryId")
    private List<CBudgetline> cBudgetlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mProductCategoryId")
    private List<MOfferProdCat> mOfferProdCatList;

    public MProductCategory() {
    }

    public MProductCategory(String mProductCategoryId) {
        this.mProductCategoryId = mProductCategoryId;
    }

    public MProductCategory(String mProductCategoryId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name, Character isdefault, BigInteger plannedmargin) {
        this.mProductCategoryId = mProductCategoryId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
        this.isdefault = isdefault;
        this.plannedmargin = plannedmargin;
    }

    public String getMProductCategoryId() {
        return mProductCategoryId;
    }

    public void setMProductCategoryId(String mProductCategoryId) {
        this.mProductCategoryId = mProductCategoryId;
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

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    public BigInteger getPlannedmargin() {
        return plannedmargin;
    }

    public void setPlannedmargin(BigInteger plannedmargin) {
        this.plannedmargin = plannedmargin;
    }

    @XmlTransient
    public List<CExternalposCategory> getCExternalposCategoryList() {
        return cExternalposCategoryList;
    }

    public void setCExternalposCategoryList(List<CExternalposCategory> cExternalposCategoryList) {
        this.cExternalposCategoryList = cExternalposCategoryList;
    }

    @XmlTransient
    public List<MRappelProductcategory> getMRappelProductcategoryList() {
        return mRappelProductcategoryList;
    }

    public void setMRappelProductcategoryList(List<MRappelProductcategory> mRappelProductcategoryList) {
        this.mRappelProductcategoryList = mRappelProductcategoryList;
    }

    @XmlTransient
    public List<MProduct> getMProductList() {
        return mProductList;
    }

    public void setMProductList(List<MProduct> mProductList) {
        this.mProductList = mProductList;
    }

    @XmlTransient
    public List<MrpRunPurchase> getMrpRunPurchaseList() {
        return mrpRunPurchaseList;
    }

    public void setMrpRunPurchaseList(List<MrpRunPurchase> mrpRunPurchaseList) {
        this.mrpRunPurchaseList = mrpRunPurchaseList;
    }

    @XmlTransient
    public List<IProduct> getIProductList() {
        return iProductList;
    }

    public void setIProductList(List<IProduct> iProductList) {
        this.iProductList = iProductList;
    }

    @XmlTransient
    public List<IBudgetline> getIBudgetlineList() {
        return iBudgetlineList;
    }

    public void setIBudgetlineList(List<IBudgetline> iBudgetlineList) {
        this.iBudgetlineList = iBudgetlineList;
    }

    @XmlTransient
    public List<MrpRunProduction> getMrpRunProductionList() {
        return mrpRunProductionList;
    }

    public void setMrpRunProductionList(List<MrpRunProduction> mrpRunProductionList) {
        this.mrpRunProductionList = mrpRunProductionList;
    }

    @XmlTransient
    public List<CCommissionline> getCCommissionlineList() {
        return cCommissionlineList;
    }

    public void setCCommissionlineList(List<CCommissionline> cCommissionlineList) {
        this.cCommissionlineList = cCommissionlineList;
    }

    @XmlTransient
    public List<MPerpetualinv> getMPerpetualinvList() {
        return mPerpetualinvList;
    }

    public void setMPerpetualinvList(List<MPerpetualinv> mPerpetualinvList) {
        this.mPerpetualinvList = mPerpetualinvList;
    }

    @XmlTransient
    public List<MProductCategoryAcct> getMProductCategoryAcctList() {
        return mProductCategoryAcctList;
    }

    public void setMProductCategoryAcctList(List<MProductCategoryAcct> mProductCategoryAcctList) {
        this.mProductCategoryAcctList = mProductCategoryAcctList;
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
    public List<CProjectline> getCProjectlineList() {
        return cProjectlineList;
    }

    public void setCProjectlineList(List<CProjectline> cProjectlineList) {
        this.cProjectlineList = cProjectlineList;
    }

    @XmlTransient
    public List<MDiscountschemaline> getMDiscountschemalineList() {
        return mDiscountschemalineList;
    }

    public void setMDiscountschemalineList(List<MDiscountschemaline> mDiscountschemalineList) {
        this.mDiscountschemalineList = mDiscountschemalineList;
    }

    @XmlTransient
    public List<CBudgetline> getCBudgetlineList() {
        return cBudgetlineList;
    }

    public void setCBudgetlineList(List<CBudgetline> cBudgetlineList) {
        this.cBudgetlineList = cBudgetlineList;
    }

    @XmlTransient
    public List<MOfferProdCat> getMOfferProdCatList() {
        return mOfferProdCatList;
    }

    public void setMOfferProdCatList(List<MOfferProdCat> mOfferProdCatList) {
        this.mOfferProdCatList = mOfferProdCatList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mProductCategoryId != null ? mProductCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MProductCategory)) {
            return false;
        }
        MProductCategory other = (MProductCategory) object;
        if ((this.mProductCategoryId == null && other.mProductCategoryId != null) || (this.mProductCategoryId != null && !this.mProductCategoryId.equals(other.mProductCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MProductCategory[ mProductCategoryId=" + mProductCategoryId + " ]";
    }
    
}
