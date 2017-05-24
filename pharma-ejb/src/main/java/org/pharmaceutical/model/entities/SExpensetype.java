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
@Table(name = "s_expensetype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SExpensetype.findAll", query = "SELECT s FROM SExpensetype s"),
    @NamedQuery(name = "SExpensetype.findBySExpensetypeId", query = "SELECT s FROM SExpensetype s WHERE s.sExpensetypeId = :sExpensetypeId"),
    @NamedQuery(name = "SExpensetype.findByIsactive", query = "SELECT s FROM SExpensetype s WHERE s.isactive = :isactive"),
    @NamedQuery(name = "SExpensetype.findByCreated", query = "SELECT s FROM SExpensetype s WHERE s.created = :created"),
    @NamedQuery(name = "SExpensetype.findByCreatedby", query = "SELECT s FROM SExpensetype s WHERE s.createdby = :createdby"),
    @NamedQuery(name = "SExpensetype.findByUpdated", query = "SELECT s FROM SExpensetype s WHERE s.updated = :updated"),
    @NamedQuery(name = "SExpensetype.findByUpdatedby", query = "SELECT s FROM SExpensetype s WHERE s.updatedby = :updatedby"),
    @NamedQuery(name = "SExpensetype.findByValue", query = "SELECT s FROM SExpensetype s WHERE s.value = :value"),
    @NamedQuery(name = "SExpensetype.findByName", query = "SELECT s FROM SExpensetype s WHERE s.name = :name"),
    @NamedQuery(name = "SExpensetype.findByDescription", query = "SELECT s FROM SExpensetype s WHERE s.description = :description"),
    @NamedQuery(name = "SExpensetype.findByIsinvoiced", query = "SELECT s FROM SExpensetype s WHERE s.isinvoiced = :isinvoiced")})
public class SExpensetype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "s_expensetype_id")
    private String sExpensetypeId;
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
    @Size(max = 40)
    @Column(name = "value")
    private String value;
    @Size(max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "isinvoiced")
    private Character isinvoiced;
    @OneToOne(mappedBy = "sExpensetypeId")
    private MProduct mProduct;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_taxcategory_id", referencedColumnName = "c_taxcategory_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTaxcategory cTaxcategoryId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CUom cUomId;
    @JoinColumn(name = "m_product_category_id", referencedColumnName = "m_product_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductCategory mProductCategoryId;

    public SExpensetype() {
    }

    public SExpensetype(String sExpensetypeId) {
        this.sExpensetypeId = sExpensetypeId;
    }

    public String getSExpensetypeId() {
        return sExpensetypeId;
    }

    public void setSExpensetypeId(String sExpensetypeId) {
        this.sExpensetypeId = sExpensetypeId;
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

    public Character getIsinvoiced() {
        return isinvoiced;
    }

    public void setIsinvoiced(Character isinvoiced) {
        this.isinvoiced = isinvoiced;
    }

    public MProduct getMProduct() {
        return mProduct;
    }

    public void setMProduct(MProduct mProduct) {
        this.mProduct = mProduct;
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

    public CTaxcategory getCTaxcategoryId() {
        return cTaxcategoryId;
    }

    public void setCTaxcategoryId(CTaxcategory cTaxcategoryId) {
        this.cTaxcategoryId = cTaxcategoryId;
    }

    public CUom getCUomId() {
        return cUomId;
    }

    public void setCUomId(CUom cUomId) {
        this.cUomId = cUomId;
    }

    public MProductCategory getMProductCategoryId() {
        return mProductCategoryId;
    }

    public void setMProductCategoryId(MProductCategory mProductCategoryId) {
        this.mProductCategoryId = mProductCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sExpensetypeId != null ? sExpensetypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SExpensetype)) {
            return false;
        }
        SExpensetype other = (SExpensetype) object;
        if ((this.sExpensetypeId == null && other.sExpensetypeId != null) || (this.sExpensetypeId != null && !this.sExpensetypeId.equals(other.sExpensetypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.SExpensetype[ sExpensetypeId=" + sExpensetypeId + " ]";
    }
    
}
