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
@Table(name = "m_movementline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MMovementline.findAll", query = "SELECT m FROM MMovementline m"),
    @NamedQuery(name = "MMovementline.findByMMovementlineId", query = "SELECT m FROM MMovementline m WHERE m.mMovementlineId = :mMovementlineId"),
    @NamedQuery(name = "MMovementline.findByIsactive", query = "SELECT m FROM MMovementline m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MMovementline.findByCreated", query = "SELECT m FROM MMovementline m WHERE m.created = :created"),
    @NamedQuery(name = "MMovementline.findByCreatedby", query = "SELECT m FROM MMovementline m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MMovementline.findByUpdated", query = "SELECT m FROM MMovementline m WHERE m.updated = :updated"),
    @NamedQuery(name = "MMovementline.findByUpdatedby", query = "SELECT m FROM MMovementline m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MMovementline.findByLine", query = "SELECT m FROM MMovementline m WHERE m.line = :line"),
    @NamedQuery(name = "MMovementline.findByMovementqty", query = "SELECT m FROM MMovementline m WHERE m.movementqty = :movementqty"),
    @NamedQuery(name = "MMovementline.findByDescription", query = "SELECT m FROM MMovementline m WHERE m.description = :description"),
    @NamedQuery(name = "MMovementline.findByQuantityorder", query = "SELECT m FROM MMovementline m WHERE m.quantityorder = :quantityorder")})
public class MMovementline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_movementline_id")
    private String mMovementlineId;
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
    @Column(name = "line")
    private Long line;
    @Basic(optional = false)
    @NotNull
    @Column(name = "movementqty")
    private BigInteger movementqty;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "quantityorder")
    private BigInteger quantityorder;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mMovementlineId")
    private List<MTransaction> mTransactionList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_uom_id", referencedColumnName = "c_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CUom cUomId;
    @JoinColumn(name = "m_attributesetinstance_id", referencedColumnName = "m_attributesetinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MAttributesetinstance mAttributesetinstanceId;
    @JoinColumn(name = "m_locator_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MLocator mLocatorId;
    @JoinColumn(name = "m_locatorto_id", referencedColumnName = "m_locator_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MLocator mLocatortoId;
    @JoinColumn(name = "m_movement_id", referencedColumnName = "m_movement_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MMovement mMovementId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "m_product_uom_id", referencedColumnName = "m_product_uom_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductUom mProductUomId;

    public MMovementline() {
    }

    public MMovementline(String mMovementlineId) {
        this.mMovementlineId = mMovementlineId;
    }

    public MMovementline(String mMovementlineId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger movementqty) {
        this.mMovementlineId = mMovementlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.movementqty = movementqty;
    }

    public String getMMovementlineId() {
        return mMovementlineId;
    }

    public void setMMovementlineId(String mMovementlineId) {
        this.mMovementlineId = mMovementlineId;
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

    public Long getLine() {
        return line;
    }

    public void setLine(Long line) {
        this.line = line;
    }

    public BigInteger getMovementqty() {
        return movementqty;
    }

    public void setMovementqty(BigInteger movementqty) {
        this.movementqty = movementqty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getQuantityorder() {
        return quantityorder;
    }

    public void setQuantityorder(BigInteger quantityorder) {
        this.quantityorder = quantityorder;
    }

    @XmlTransient
    public List<MTransaction> getMTransactionList() {
        return mTransactionList;
    }

    public void setMTransactionList(List<MTransaction> mTransactionList) {
        this.mTransactionList = mTransactionList;
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

    public CUom getCUomId() {
        return cUomId;
    }

    public void setCUomId(CUom cUomId) {
        this.cUomId = cUomId;
    }

    public MAttributesetinstance getMAttributesetinstanceId() {
        return mAttributesetinstanceId;
    }

    public void setMAttributesetinstanceId(MAttributesetinstance mAttributesetinstanceId) {
        this.mAttributesetinstanceId = mAttributesetinstanceId;
    }

    public MLocator getMLocatorId() {
        return mLocatorId;
    }

    public void setMLocatorId(MLocator mLocatorId) {
        this.mLocatorId = mLocatorId;
    }

    public MLocator getMLocatortoId() {
        return mLocatortoId;
    }

    public void setMLocatortoId(MLocator mLocatortoId) {
        this.mLocatortoId = mLocatortoId;
    }

    public MMovement getMMovementId() {
        return mMovementId;
    }

    public void setMMovementId(MMovement mMovementId) {
        this.mMovementId = mMovementId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public MProductUom getMProductUomId() {
        return mProductUomId;
    }

    public void setMProductUomId(MProductUom mProductUomId) {
        this.mProductUomId = mProductUomId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mMovementlineId != null ? mMovementlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MMovementline)) {
            return false;
        }
        MMovementline other = (MMovementline) object;
        if ((this.mMovementlineId == null && other.mMovementlineId != null) || (this.mMovementlineId != null && !this.mMovementlineId.equals(other.mMovementlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MMovementline[ mMovementlineId=" + mMovementlineId + " ]";
    }
    
}
