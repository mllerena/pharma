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
@Table(name = "m_product_bom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MProductBom.findAll", query = "SELECT m FROM MProductBom m"),
    @NamedQuery(name = "MProductBom.findByMProductBomId", query = "SELECT m FROM MProductBom m WHERE m.mProductBomId = :mProductBomId"),
    @NamedQuery(name = "MProductBom.findByIsactive", query = "SELECT m FROM MProductBom m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MProductBom.findByCreated", query = "SELECT m FROM MProductBom m WHERE m.created = :created"),
    @NamedQuery(name = "MProductBom.findByCreatedby", query = "SELECT m FROM MProductBom m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MProductBom.findByUpdated", query = "SELECT m FROM MProductBom m WHERE m.updated = :updated"),
    @NamedQuery(name = "MProductBom.findByUpdatedby", query = "SELECT m FROM MProductBom m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MProductBom.findByLine", query = "SELECT m FROM MProductBom m WHERE m.line = :line"),
    @NamedQuery(name = "MProductBom.findByBomqty", query = "SELECT m FROM MProductBom m WHERE m.bomqty = :bomqty"),
    @NamedQuery(name = "MProductBom.findByDescription", query = "SELECT m FROM MProductBom m WHERE m.description = :description"),
    @NamedQuery(name = "MProductBom.findByBomtype", query = "SELECT m FROM MProductBom m WHERE m.bomtype = :bomtype")})
public class MProductBom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_product_bom_id")
    private String mProductBomId;
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
    @Column(name = "line")
    private long line;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bomqty")
    private BigInteger bomqty;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 60)
    @Column(name = "bomtype")
    private String bomtype;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_productbom_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductbomId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;

    public MProductBom() {
    }

    public MProductBom(String mProductBomId) {
        this.mProductBomId = mProductBomId;
    }

    public MProductBom(String mProductBomId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, BigInteger bomqty) {
        this.mProductBomId = mProductBomId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.bomqty = bomqty;
    }

    public String getMProductBomId() {
        return mProductBomId;
    }

    public void setMProductBomId(String mProductBomId) {
        this.mProductBomId = mProductBomId;
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

    public long getLine() {
        return line;
    }

    public void setLine(long line) {
        this.line = line;
    }

    public BigInteger getBomqty() {
        return bomqty;
    }

    public void setBomqty(BigInteger bomqty) {
        this.bomqty = bomqty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBomtype() {
        return bomtype;
    }

    public void setBomtype(String bomtype) {
        this.bomtype = bomtype;
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

    public MProduct getMProductbomId() {
        return mProductbomId;
    }

    public void setMProductbomId(MProduct mProductbomId) {
        this.mProductbomId = mProductbomId;
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
        hash += (mProductBomId != null ? mProductBomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MProductBom)) {
            return false;
        }
        MProductBom other = (MProductBom) object;
        if ((this.mProductBomId == null && other.mProductBomId != null) || (this.mProductBomId != null && !this.mProductBomId.equals(other.mProductBomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MProductBom[ mProductBomId=" + mProductBomId + " ]";
    }
    
}
