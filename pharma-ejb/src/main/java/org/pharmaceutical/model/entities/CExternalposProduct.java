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
@Table(name = "c_externalpos_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CExternalposProduct.findAll", query = "SELECT c FROM CExternalposProduct c"),
    @NamedQuery(name = "CExternalposProduct.findByCExternalposProductId", query = "SELECT c FROM CExternalposProduct c WHERE c.cExternalposProductId = :cExternalposProductId"),
    @NamedQuery(name = "CExternalposProduct.findByIsactive", query = "SELECT c FROM CExternalposProduct c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CExternalposProduct.findByCreated", query = "SELECT c FROM CExternalposProduct c WHERE c.created = :created"),
    @NamedQuery(name = "CExternalposProduct.findByCreatedby", query = "SELECT c FROM CExternalposProduct c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CExternalposProduct.findByUpdated", query = "SELECT c FROM CExternalposProduct c WHERE c.updated = :updated"),
    @NamedQuery(name = "CExternalposProduct.findByUpdatedby", query = "SELECT c FROM CExternalposProduct c WHERE c.updatedby = :updatedby")})
public class CExternalposProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_externalpos_product_id")
    private String cExternalposProductId;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_externalpos_id", referencedColumnName = "c_externalpos_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CExternalpos cExternalposId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;

    public CExternalposProduct() {
    }

    public CExternalposProduct(String cExternalposProductId) {
        this.cExternalposProductId = cExternalposProductId;
    }

    public CExternalposProduct(String cExternalposProductId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cExternalposProductId = cExternalposProductId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCExternalposProductId() {
        return cExternalposProductId;
    }

    public void setCExternalposProductId(String cExternalposProductId) {
        this.cExternalposProductId = cExternalposProductId;
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

    public CExternalpos getCExternalposId() {
        return cExternalposId;
    }

    public void setCExternalposId(CExternalpos cExternalposId) {
        this.cExternalposId = cExternalposId;
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
        hash += (cExternalposProductId != null ? cExternalposProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CExternalposProduct)) {
            return false;
        }
        CExternalposProduct other = (CExternalposProduct) object;
        if ((this.cExternalposProductId == null && other.cExternalposProductId != null) || (this.cExternalposProductId != null && !this.cExternalposProductId.equals(other.cExternalposProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CExternalposProduct[ cExternalposProductId=" + cExternalposProductId + " ]";
    }
    
}
