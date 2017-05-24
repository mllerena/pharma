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
@Table(name = "c_externalpos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CExternalpos.findAll", query = "SELECT c FROM CExternalpos c"),
    @NamedQuery(name = "CExternalpos.findByCExternalposId", query = "SELECT c FROM CExternalpos c WHERE c.cExternalposId = :cExternalposId"),
    @NamedQuery(name = "CExternalpos.findByIsactive", query = "SELECT c FROM CExternalpos c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CExternalpos.findByCreated", query = "SELECT c FROM CExternalpos c WHERE c.created = :created"),
    @NamedQuery(name = "CExternalpos.findByCreatedby", query = "SELECT c FROM CExternalpos c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CExternalpos.findByUpdated", query = "SELECT c FROM CExternalpos c WHERE c.updated = :updated"),
    @NamedQuery(name = "CExternalpos.findByUpdatedby", query = "SELECT c FROM CExternalpos c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CExternalpos.findByValue", query = "SELECT c FROM CExternalpos c WHERE c.value = :value"),
    @NamedQuery(name = "CExternalpos.findByName", query = "SELECT c FROM CExternalpos c WHERE c.name = :name"),
    @NamedQuery(name = "CExternalpos.findByDescription", query = "SELECT c FROM CExternalpos c WHERE c.description = :description"),
    @NamedQuery(name = "CExternalpos.findByIncludeProduct", query = "SELECT c FROM CExternalpos c WHERE c.includeProduct = :includeProduct"),
    @NamedQuery(name = "CExternalpos.findByIncludeProductCategory", query = "SELECT c FROM CExternalpos c WHERE c.includeProductCategory = :includeProductCategory"),
    @NamedQuery(name = "CExternalpos.findByPerformPost", query = "SELECT c FROM CExternalpos c WHERE c.performPost = :performPost")})
public class CExternalpos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_externalpos_id")
    private String cExternalposId;
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
    @Size(max = 60)
    @Column(name = "include_product")
    private String includeProduct;
    @Size(max = 60)
    @Column(name = "include_product_category")
    private String includeProductCategory;
    @Column(name = "perform_post")
    private Character performPost;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cExternalposId")
    private List<CExternalposCategory> cExternalposCategoryList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "salesrep_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdUser salesrepId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CDoctype cDoctypeId;
    @JoinColumn(name = "m_pricelist_id", referencedColumnName = "m_pricelist_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MPricelist mPricelistId;
    @JoinColumn(name = "m_shipper_id", referencedColumnName = "m_shipper_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MShipper mShipperId;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MWarehouse mWarehouseId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cExternalposId")
    private List<CExternalposProduct> cExternalposProductList;

    public CExternalpos() {
    }

    public CExternalpos(String cExternalposId) {
        this.cExternalposId = cExternalposId;
    }

    public CExternalpos(String cExternalposId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name) {
        this.cExternalposId = cExternalposId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
    }

    public String getCExternalposId() {
        return cExternalposId;
    }

    public void setCExternalposId(String cExternalposId) {
        this.cExternalposId = cExternalposId;
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

    public String getIncludeProduct() {
        return includeProduct;
    }

    public void setIncludeProduct(String includeProduct) {
        this.includeProduct = includeProduct;
    }

    public String getIncludeProductCategory() {
        return includeProductCategory;
    }

    public void setIncludeProductCategory(String includeProductCategory) {
        this.includeProductCategory = includeProductCategory;
    }

    public Character getPerformPost() {
        return performPost;
    }

    public void setPerformPost(Character performPost) {
        this.performPost = performPost;
    }

    @XmlTransient
    public List<CExternalposCategory> getCExternalposCategoryList() {
        return cExternalposCategoryList;
    }

    public void setCExternalposCategoryList(List<CExternalposCategory> cExternalposCategoryList) {
        this.cExternalposCategoryList = cExternalposCategoryList;
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

    public AdUser getSalesrepId() {
        return salesrepId;
    }

    public void setSalesrepId(AdUser salesrepId) {
        this.salesrepId = salesrepId;
    }

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CDoctype getCDoctypeId() {
        return cDoctypeId;
    }

    public void setCDoctypeId(CDoctype cDoctypeId) {
        this.cDoctypeId = cDoctypeId;
    }

    public MPricelist getMPricelistId() {
        return mPricelistId;
    }

    public void setMPricelistId(MPricelist mPricelistId) {
        this.mPricelistId = mPricelistId;
    }

    public MShipper getMShipperId() {
        return mShipperId;
    }

    public void setMShipperId(MShipper mShipperId) {
        this.mShipperId = mShipperId;
    }

    public MWarehouse getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(MWarehouse mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
    }

    @XmlTransient
    public List<CExternalposProduct> getCExternalposProductList() {
        return cExternalposProductList;
    }

    public void setCExternalposProductList(List<CExternalposProduct> cExternalposProductList) {
        this.cExternalposProductList = cExternalposProductList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cExternalposId != null ? cExternalposId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CExternalpos)) {
            return false;
        }
        CExternalpos other = (CExternalpos) object;
        if ((this.cExternalposId == null && other.cExternalposId != null) || (this.cExternalposId != null && !this.cExternalposId.equals(other.cExternalposId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CExternalpos[ cExternalposId=" + cExternalposId + " ]";
    }
    
}
