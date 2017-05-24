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
@Table(name = "s_resource")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SResource.findAll", query = "SELECT s FROM SResource s"),
    @NamedQuery(name = "SResource.findBySResourceId", query = "SELECT s FROM SResource s WHERE s.sResourceId = :sResourceId"),
    @NamedQuery(name = "SResource.findByIsactive", query = "SELECT s FROM SResource s WHERE s.isactive = :isactive"),
    @NamedQuery(name = "SResource.findByCreated", query = "SELECT s FROM SResource s WHERE s.created = :created"),
    @NamedQuery(name = "SResource.findByCreatedby", query = "SELECT s FROM SResource s WHERE s.createdby = :createdby"),
    @NamedQuery(name = "SResource.findByUpdated", query = "SELECT s FROM SResource s WHERE s.updated = :updated"),
    @NamedQuery(name = "SResource.findByUpdatedby", query = "SELECT s FROM SResource s WHERE s.updatedby = :updatedby"),
    @NamedQuery(name = "SResource.findByValue", query = "SELECT s FROM SResource s WHERE s.value = :value"),
    @NamedQuery(name = "SResource.findByName", query = "SELECT s FROM SResource s WHERE s.name = :name"),
    @NamedQuery(name = "SResource.findByDescription", query = "SELECT s FROM SResource s WHERE s.description = :description"),
    @NamedQuery(name = "SResource.findByIsavailable", query = "SELECT s FROM SResource s WHERE s.isavailable = :isavailable"),
    @NamedQuery(name = "SResource.findByChargeableqty", query = "SELECT s FROM SResource s WHERE s.chargeableqty = :chargeableqty")})
public class SResource implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "s_resource_id")
    private String sResourceId;
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
    @Column(name = "isavailable")
    private Character isavailable;
    @Column(name = "chargeableqty")
    private BigInteger chargeableqty;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @JoinColumn(name = "m_warehouse_id", referencedColumnName = "m_warehouse_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MWarehouse mWarehouseId;
    @JoinColumn(name = "s_resourcetype_id", referencedColumnName = "s_resourcetype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private SResourcetype sResourcetypeId;
    @OneToOne(mappedBy = "sResourceId")
    private MProduct mProduct;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "sResourceId")
    private List<RResourceplancost> rResourceplancostList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "sResourceId")
    private List<SResourceassignment> sResourceassignmentList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "sResourceId")
    private List<SResourceunavailable> sResourceunavailableList;

    public SResource() {
    }

    public SResource(String sResourceId) {
        this.sResourceId = sResourceId;
    }

    public SResource(String sResourceId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name, Character isavailable) {
        this.sResourceId = sResourceId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
        this.isavailable = isavailable;
    }

    public String getSResourceId() {
        return sResourceId;
    }

    public void setSResourceId(String sResourceId) {
        this.sResourceId = sResourceId;
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

    public Character getIsavailable() {
        return isavailable;
    }

    public void setIsavailable(Character isavailable) {
        this.isavailable = isavailable;
    }

    public BigInteger getChargeableqty() {
        return chargeableqty;
    }

    public void setChargeableqty(BigInteger chargeableqty) {
        this.chargeableqty = chargeableqty;
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

    public MWarehouse getMWarehouseId() {
        return mWarehouseId;
    }

    public void setMWarehouseId(MWarehouse mWarehouseId) {
        this.mWarehouseId = mWarehouseId;
    }

    public SResourcetype getSResourcetypeId() {
        return sResourcetypeId;
    }

    public void setSResourcetypeId(SResourcetype sResourcetypeId) {
        this.sResourcetypeId = sResourcetypeId;
    }

    public MProduct getMProduct() {
        return mProduct;
    }

    public void setMProduct(MProduct mProduct) {
        this.mProduct = mProduct;
    }

    @XmlTransient
    public List<RResourceplancost> getRResourceplancostList() {
        return rResourceplancostList;
    }

    public void setRResourceplancostList(List<RResourceplancost> rResourceplancostList) {
        this.rResourceplancostList = rResourceplancostList;
    }

    @XmlTransient
    public List<SResourceassignment> getSResourceassignmentList() {
        return sResourceassignmentList;
    }

    public void setSResourceassignmentList(List<SResourceassignment> sResourceassignmentList) {
        this.sResourceassignmentList = sResourceassignmentList;
    }

    @XmlTransient
    public List<SResourceunavailable> getSResourceunavailableList() {
        return sResourceunavailableList;
    }

    public void setSResourceunavailableList(List<SResourceunavailable> sResourceunavailableList) {
        this.sResourceunavailableList = sResourceunavailableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sResourceId != null ? sResourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SResource)) {
            return false;
        }
        SResource other = (SResource) object;
        if ((this.sResourceId == null && other.sResourceId != null) || (this.sResourceId != null && !this.sResourceId.equals(other.sResourceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.SResource[ sResourceId=" + sResourceId + " ]";
    }
    
}
