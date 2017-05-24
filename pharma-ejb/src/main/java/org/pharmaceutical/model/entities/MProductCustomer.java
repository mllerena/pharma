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
@Table(name = "m_product_customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MProductCustomer.findAll", query = "SELECT m FROM MProductCustomer m"),
    @NamedQuery(name = "MProductCustomer.findByMProductCustomerId", query = "SELECT m FROM MProductCustomer m WHERE m.mProductCustomerId = :mProductCustomerId"),
    @NamedQuery(name = "MProductCustomer.findByIsactive", query = "SELECT m FROM MProductCustomer m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MProductCustomer.findByCreated", query = "SELECT m FROM MProductCustomer m WHERE m.created = :created"),
    @NamedQuery(name = "MProductCustomer.findByCreatedby", query = "SELECT m FROM MProductCustomer m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MProductCustomer.findByUpdated", query = "SELECT m FROM MProductCustomer m WHERE m.updated = :updated"),
    @NamedQuery(name = "MProductCustomer.findByUpdatedby", query = "SELECT m FROM MProductCustomer m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MProductCustomer.findByName", query = "SELECT m FROM MProductCustomer m WHERE m.name = :name"),
    @NamedQuery(name = "MProductCustomer.findByDescription", query = "SELECT m FROM MProductCustomer m WHERE m.description = :description"),
    @NamedQuery(name = "MProductCustomer.findByUpc", query = "SELECT m FROM MProductCustomer m WHERE m.upc = :upc")})
public class MProductCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_product_customer_id")
    private String mProductCustomerId;
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
    @Size(max = 30)
    @Column(name = "upc")
    private String upc;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;

    public MProductCustomer() {
    }

    public MProductCustomer(String mProductCustomerId) {
        this.mProductCustomerId = mProductCustomerId;
    }

    public MProductCustomer(String mProductCustomerId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.mProductCustomerId = mProductCustomerId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getMProductCustomerId() {
        return mProductCustomerId;
    }

    public void setMProductCustomerId(String mProductCustomerId) {
        this.mProductCustomerId = mProductCustomerId;
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

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
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
        hash += (mProductCustomerId != null ? mProductCustomerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MProductCustomer)) {
            return false;
        }
        MProductCustomer other = (MProductCustomer) object;
        if ((this.mProductCustomerId == null && other.mProductCustomerId != null) || (this.mProductCustomerId != null && !this.mProductCustomerId.equals(other.mProductCustomerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MProductCustomer[ mProductCustomerId=" + mProductCustomerId + " ]";
    }
    
}
