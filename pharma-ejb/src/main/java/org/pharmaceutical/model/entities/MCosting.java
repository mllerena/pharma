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
@Table(name = "m_costing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MCosting.findAll", query = "SELECT m FROM MCosting m"),
    @NamedQuery(name = "MCosting.findByMCostingId", query = "SELECT m FROM MCosting m WHERE m.mCostingId = :mCostingId"),
    @NamedQuery(name = "MCosting.findByCreated", query = "SELECT m FROM MCosting m WHERE m.created = :created"),
    @NamedQuery(name = "MCosting.findByCreatedby", query = "SELECT m FROM MCosting m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MCosting.findByUpdated", query = "SELECT m FROM MCosting m WHERE m.updated = :updated"),
    @NamedQuery(name = "MCosting.findByUpdatedby", query = "SELECT m FROM MCosting m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MCosting.findByDatefrom", query = "SELECT m FROM MCosting m WHERE m.datefrom = :datefrom"),
    @NamedQuery(name = "MCosting.findByDateto", query = "SELECT m FROM MCosting m WHERE m.dateto = :dateto"),
    @NamedQuery(name = "MCosting.findByIsmanual", query = "SELECT m FROM MCosting m WHERE m.ismanual = :ismanual"),
    @NamedQuery(name = "MCosting.findByQty", query = "SELECT m FROM MCosting m WHERE m.qty = :qty"),
    @NamedQuery(name = "MCosting.findByPrice", query = "SELECT m FROM MCosting m WHERE m.price = :price"),
    @NamedQuery(name = "MCosting.findByCumqty", query = "SELECT m FROM MCosting m WHERE m.cumqty = :cumqty"),
    @NamedQuery(name = "MCosting.findByCosttype", query = "SELECT m FROM MCosting m WHERE m.costtype = :costtype"),
    @NamedQuery(name = "MCosting.findByIspermanent", query = "SELECT m FROM MCosting m WHERE m.ispermanent = :ispermanent"),
    @NamedQuery(name = "MCosting.findByCost", query = "SELECT m FROM MCosting m WHERE m.cost = :cost"),
    @NamedQuery(name = "MCosting.findByIsproduction", query = "SELECT m FROM MCosting m WHERE m.isproduction = :isproduction"),
    @NamedQuery(name = "MCosting.findByIsactive", query = "SELECT m FROM MCosting m WHERE m.isactive = :isactive")})
public class MCosting implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_costing_id")
    private String mCostingId;
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
    @Column(name = "datefrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefrom;
    @Column(name = "dateto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ismanual")
    private Character ismanual;
    @Column(name = "qty")
    private BigInteger qty;
    @Column(name = "price")
    private BigInteger price;
    @Column(name = "cumqty")
    private BigInteger cumqty;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "costtype")
    private String costtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ispermanent")
    private Character ispermanent;
    @Column(name = "cost")
    private BigInteger cost;
    @Column(name = "isproduction")
    private Character isproduction;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isactive")
    private Character isactive;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_invoiceline_id", referencedColumnName = "c_invoiceline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoiceline cInvoicelineId;
    @JoinColumn(name = "m_inoutline_id", referencedColumnName = "m_inoutline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MInoutline mInoutlineId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "m_productionline_id", referencedColumnName = "m_productionline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProductionline mProductionlineId;

    public MCosting() {
    }

    public MCosting(String mCostingId) {
        this.mCostingId = mCostingId;
    }

    public MCosting(String mCostingId, Date created, String createdby, Date updated, String updatedby, Character ismanual, String costtype, Character ispermanent, Character isactive) {
        this.mCostingId = mCostingId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.ismanual = ismanual;
        this.costtype = costtype;
        this.ispermanent = ispermanent;
        this.isactive = isactive;
    }

    public String getMCostingId() {
        return mCostingId;
    }

    public void setMCostingId(String mCostingId) {
        this.mCostingId = mCostingId;
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

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }

    public Character getIsmanual() {
        return ismanual;
    }

    public void setIsmanual(Character ismanual) {
        this.ismanual = ismanual;
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

    public BigInteger getCumqty() {
        return cumqty;
    }

    public void setCumqty(BigInteger cumqty) {
        this.cumqty = cumqty;
    }

    public String getCosttype() {
        return costtype;
    }

    public void setCosttype(String costtype) {
        this.costtype = costtype;
    }

    public Character getIspermanent() {
        return ispermanent;
    }

    public void setIspermanent(Character ispermanent) {
        this.ispermanent = ispermanent;
    }

    public BigInteger getCost() {
        return cost;
    }

    public void setCost(BigInteger cost) {
        this.cost = cost;
    }

    public Character getIsproduction() {
        return isproduction;
    }

    public void setIsproduction(Character isproduction) {
        this.isproduction = isproduction;
    }

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
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

    public CInvoiceline getCInvoicelineId() {
        return cInvoicelineId;
    }

    public void setCInvoicelineId(CInvoiceline cInvoicelineId) {
        this.cInvoicelineId = cInvoicelineId;
    }

    public MInoutline getMInoutlineId() {
        return mInoutlineId;
    }

    public void setMInoutlineId(MInoutline mInoutlineId) {
        this.mInoutlineId = mInoutlineId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    public MProductionline getMProductionlineId() {
        return mProductionlineId;
    }

    public void setMProductionlineId(MProductionline mProductionlineId) {
        this.mProductionlineId = mProductionlineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mCostingId != null ? mCostingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MCosting)) {
            return false;
        }
        MCosting other = (MCosting) object;
        if ((this.mCostingId == null && other.mCostingId != null) || (this.mCostingId != null && !this.mCostingId.equals(other.mCostingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MCosting[ mCostingId=" + mCostingId + " ]";
    }
    
}
