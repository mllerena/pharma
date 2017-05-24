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
@Table(name = "c_discount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CDiscount.findAll", query = "SELECT c FROM CDiscount c"),
    @NamedQuery(name = "CDiscount.findByCDiscountId", query = "SELECT c FROM CDiscount c WHERE c.cDiscountId = :cDiscountId"),
    @NamedQuery(name = "CDiscount.findByIsactive", query = "SELECT c FROM CDiscount c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CDiscount.findByCreated", query = "SELECT c FROM CDiscount c WHERE c.created = :created"),
    @NamedQuery(name = "CDiscount.findByCreatedby", query = "SELECT c FROM CDiscount c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CDiscount.findByUpdated", query = "SELECT c FROM CDiscount c WHERE c.updated = :updated"),
    @NamedQuery(name = "CDiscount.findByUpdatedby", query = "SELECT c FROM CDiscount c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CDiscount.findByName", query = "SELECT c FROM CDiscount c WHERE c.name = :name"),
    @NamedQuery(name = "CDiscount.findByDescription", query = "SELECT c FROM CDiscount c WHERE c.description = :description"),
    @NamedQuery(name = "CDiscount.findByDiscount", query = "SELECT c FROM CDiscount c WHERE c.discount = :discount")})
public class CDiscount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_discount_id")
    private String cDiscountId;
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
    @Size(max = 120)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private BigInteger discount;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDiscountId")
    private List<CInvoiceDiscount> cInvoiceDiscountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDiscountId")
    private List<COrderDiscount> cOrderDiscountList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cDiscountId")
    private List<CBpartnerDiscount> cBpartnerDiscountList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;

    public CDiscount() {
    }

    public CDiscount(String cDiscountId) {
        this.cDiscountId = cDiscountId;
    }

    public CDiscount(String cDiscountId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, BigInteger discount) {
        this.cDiscountId = cDiscountId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.discount = discount;
    }

    public String getCDiscountId() {
        return cDiscountId;
    }

    public void setCDiscountId(String cDiscountId) {
        this.cDiscountId = cDiscountId;
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

    public BigInteger getDiscount() {
        return discount;
    }

    public void setDiscount(BigInteger discount) {
        this.discount = discount;
    }

    @XmlTransient
    public List<CInvoiceDiscount> getCInvoiceDiscountList() {
        return cInvoiceDiscountList;
    }

    public void setCInvoiceDiscountList(List<CInvoiceDiscount> cInvoiceDiscountList) {
        this.cInvoiceDiscountList = cInvoiceDiscountList;
    }

    @XmlTransient
    public List<COrderDiscount> getCOrderDiscountList() {
        return cOrderDiscountList;
    }

    public void setCOrderDiscountList(List<COrderDiscount> cOrderDiscountList) {
        this.cOrderDiscountList = cOrderDiscountList;
    }

    @XmlTransient
    public List<CBpartnerDiscount> getCBpartnerDiscountList() {
        return cBpartnerDiscountList;
    }

    public void setCBpartnerDiscountList(List<CBpartnerDiscount> cBpartnerDiscountList) {
        this.cBpartnerDiscountList = cBpartnerDiscountList;
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

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cDiscountId != null ? cDiscountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CDiscount)) {
            return false;
        }
        CDiscount other = (CDiscount) object;
        if ((this.cDiscountId == null && other.cDiscountId != null) || (this.cDiscountId != null && !this.cDiscountId.equals(other.cDiscountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CDiscount[ cDiscountId=" + cDiscountId + " ]";
    }
    
}
