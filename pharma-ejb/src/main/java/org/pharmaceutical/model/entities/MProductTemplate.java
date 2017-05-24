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
@Table(name = "m_product_template")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MProductTemplate.findAll", query = "SELECT m FROM MProductTemplate m"),
    @NamedQuery(name = "MProductTemplate.findByMProductTemplateId", query = "SELECT m FROM MProductTemplate m WHERE m.mProductTemplateId = :mProductTemplateId"),
    @NamedQuery(name = "MProductTemplate.findByIsactive", query = "SELECT m FROM MProductTemplate m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MProductTemplate.findByCreated", query = "SELECT m FROM MProductTemplate m WHERE m.created = :created"),
    @NamedQuery(name = "MProductTemplate.findByCreatedby", query = "SELECT m FROM MProductTemplate m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MProductTemplate.findByUpdated", query = "SELECT m FROM MProductTemplate m WHERE m.updated = :updated"),
    @NamedQuery(name = "MProductTemplate.findByUpdatedby", query = "SELECT m FROM MProductTemplate m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MProductTemplate.findByQty", query = "SELECT m FROM MProductTemplate m WHERE m.qty = :qty"),
    @NamedQuery(name = "MProductTemplate.findByTypeTemplate", query = "SELECT m FROM MProductTemplate m WHERE m.typeTemplate = :typeTemplate")})
public class MProductTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_product_template_id")
    private String mProductTemplateId;
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
    @Column(name = "qty")
    private BigInteger qty;
    @Size(max = 60)
    @Column(name = "type_template")
    private String typeTemplate;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;

    public MProductTemplate() {
    }

    public MProductTemplate(String mProductTemplateId) {
        this.mProductTemplateId = mProductTemplateId;
    }

    public MProductTemplate(String mProductTemplateId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger qty) {
        this.mProductTemplateId = mProductTemplateId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.qty = qty;
    }

    public String getMProductTemplateId() {
        return mProductTemplateId;
    }

    public void setMProductTemplateId(String mProductTemplateId) {
        this.mProductTemplateId = mProductTemplateId;
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

    public BigInteger getQty() {
        return qty;
    }

    public void setQty(BigInteger qty) {
        this.qty = qty;
    }

    public String getTypeTemplate() {
        return typeTemplate;
    }

    public void setTypeTemplate(String typeTemplate) {
        this.typeTemplate = typeTemplate;
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
        hash += (mProductTemplateId != null ? mProductTemplateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MProductTemplate)) {
            return false;
        }
        MProductTemplate other = (MProductTemplate) object;
        if ((this.mProductTemplateId == null && other.mProductTemplateId != null) || (this.mProductTemplateId != null && !this.mProductTemplateId.equals(other.mProductTemplateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MProductTemplate[ mProductTemplateId=" + mProductTemplateId + " ]";
    }
    
}
