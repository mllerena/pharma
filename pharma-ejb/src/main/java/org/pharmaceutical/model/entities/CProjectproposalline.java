/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "c_projectproposalline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CProjectproposalline.findAll", query = "SELECT c FROM CProjectproposalline c"),
    @NamedQuery(name = "CProjectproposalline.findByCProjectproposallineId", query = "SELECT c FROM CProjectproposalline c WHERE c.cProjectproposallineId = :cProjectproposallineId"),
    @NamedQuery(name = "CProjectproposalline.findByIsactive", query = "SELECT c FROM CProjectproposalline c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CProjectproposalline.findByCreated", query = "SELECT c FROM CProjectproposalline c WHERE c.created = :created"),
    @NamedQuery(name = "CProjectproposalline.findByCreatedby", query = "SELECT c FROM CProjectproposalline c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CProjectproposalline.findByUpdated", query = "SELECT c FROM CProjectproposalline c WHERE c.updated = :updated"),
    @NamedQuery(name = "CProjectproposalline.findByUpdatedby", query = "SELECT c FROM CProjectproposalline c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CProjectproposalline.findByLineno", query = "SELECT c FROM CProjectproposalline c WHERE c.lineno = :lineno"),
    @NamedQuery(name = "CProjectproposalline.findByQty", query = "SELECT c FROM CProjectproposalline c WHERE c.qty = :qty"),
    @NamedQuery(name = "CProjectproposalline.findByPrice", query = "SELECT c FROM CProjectproposalline c WHERE c.price = :price"),
    @NamedQuery(name = "CProjectproposalline.findByDescription", query = "SELECT c FROM CProjectproposalline c WHERE c.description = :description"),
    @NamedQuery(name = "CProjectproposalline.findByProductDescription", query = "SELECT c FROM CProjectproposalline c WHERE c.productDescription = :productDescription"),
    @NamedQuery(name = "CProjectproposalline.findByProductName", query = "SELECT c FROM CProjectproposalline c WHERE c.productName = :productName"),
    @NamedQuery(name = "CProjectproposalline.findByProductValue", query = "SELECT c FROM CProjectproposalline c WHERE c.productValue = :productValue")})
public class CProjectproposalline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_projectproposalline_id")
    private String cProjectproposallineId;
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
    @Column(name = "lineno")
    private long lineno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private BigInteger qty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigInteger price;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 2000)
    @Column(name = "product_description")
    private String productDescription;
    @Size(max = 60)
    @Column(name = "product_name")
    private String productName;
    @Size(max = 40)
    @Column(name = "product_value")
    private String productValue;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_projectproposal_id", referencedColumnName = "c_projectproposal_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CProjectproposal cProjectproposalId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;

    public CProjectproposalline() {
    }

    public CProjectproposalline(String cProjectproposallineId) {
        this.cProjectproposallineId = cProjectproposallineId;
    }

    public CProjectproposalline(String cProjectproposallineId, Character isactive, Date created, String createdby, Date updated, String updatedby, long lineno, BigInteger qty, BigInteger price) {
        this.cProjectproposallineId = cProjectproposallineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.lineno = lineno;
        this.qty = qty;
        this.price = price;
    }

    public String getCProjectproposallineId() {
        return cProjectproposallineId;
    }

    public void setCProjectproposallineId(String cProjectproposallineId) {
        this.cProjectproposallineId = cProjectproposallineId;
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

    public long getLineno() {
        return lineno;
    }

    public void setLineno(long lineno) {
        this.lineno = lineno;
    }

    public BigInteger getQty() {
        return qty;
    }

    public void setQty(BigInteger qty) {
        this.qty = qty;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductValue() {
        return productValue;
    }

    public void setProductValue(String productValue) {
        this.productValue = productValue;
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

    public CProjectproposal getCProjectproposalId() {
        return cProjectproposalId;
    }

    public void setCProjectproposalId(CProjectproposal cProjectproposalId) {
        this.cProjectproposalId = cProjectproposalId;
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
        hash += (cProjectproposallineId != null ? cProjectproposallineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProjectproposalline)) {
            return false;
        }
        CProjectproposalline other = (CProjectproposalline) object;
        if ((this.cProjectproposallineId == null && other.cProjectproposallineId != null) || (this.cProjectproposallineId != null && !this.cProjectproposallineId.equals(other.cProjectproposallineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CProjectproposalline[ cProjectproposallineId=" + cProjectproposallineId + " ]";
    }
    
}
