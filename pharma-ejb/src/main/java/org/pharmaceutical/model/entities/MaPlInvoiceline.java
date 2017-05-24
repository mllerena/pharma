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
@Table(name = "ma_pl_invoiceline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaPlInvoiceline.findAll", query = "SELECT m FROM MaPlInvoiceline m"),
    @NamedQuery(name = "MaPlInvoiceline.findByMaPlInvoicelineId", query = "SELECT m FROM MaPlInvoiceline m WHERE m.maPlInvoicelineId = :maPlInvoicelineId"),
    @NamedQuery(name = "MaPlInvoiceline.findByIsactive", query = "SELECT m FROM MaPlInvoiceline m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaPlInvoiceline.findByCreated", query = "SELECT m FROM MaPlInvoiceline m WHERE m.created = :created"),
    @NamedQuery(name = "MaPlInvoiceline.findByCreatedby", query = "SELECT m FROM MaPlInvoiceline m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaPlInvoiceline.findByUpdated", query = "SELECT m FROM MaPlInvoiceline m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaPlInvoiceline.findByUpdatedby", query = "SELECT m FROM MaPlInvoiceline m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaPlInvoiceline.findByCost", query = "SELECT m FROM MaPlInvoiceline m WHERE m.cost = :cost")})
public class MaPlInvoiceline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_pl_invoiceline_id")
    private String maPlInvoicelineId;
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
    @Column(name = "cost")
    private BigInteger cost;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_invoiceline_id", referencedColumnName = "c_invoiceline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CInvoiceline cInvoicelineId;
    @JoinColumn(name = "m_productionplan_id", referencedColumnName = "m_productionplan_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProductionplan mProductionplanId;

    public MaPlInvoiceline() {
    }

    public MaPlInvoiceline(String maPlInvoicelineId) {
        this.maPlInvoicelineId = maPlInvoicelineId;
    }

    public MaPlInvoiceline(String maPlInvoicelineId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger cost) {
        this.maPlInvoicelineId = maPlInvoicelineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.cost = cost;
    }

    public String getMaPlInvoicelineId() {
        return maPlInvoicelineId;
    }

    public void setMaPlInvoicelineId(String maPlInvoicelineId) {
        this.maPlInvoicelineId = maPlInvoicelineId;
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

    public BigInteger getCost() {
        return cost;
    }

    public void setCost(BigInteger cost) {
        this.cost = cost;
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

    public MProductionplan getMProductionplanId() {
        return mProductionplanId;
    }

    public void setMProductionplanId(MProductionplan mProductionplanId) {
        this.mProductionplanId = mProductionplanId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maPlInvoicelineId != null ? maPlInvoicelineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaPlInvoiceline)) {
            return false;
        }
        MaPlInvoiceline other = (MaPlInvoiceline) object;
        if ((this.maPlInvoicelineId == null && other.maPlInvoicelineId != null) || (this.maPlInvoicelineId != null && !this.maPlInvoicelineId.equals(other.maPlInvoicelineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaPlInvoiceline[ maPlInvoicelineId=" + maPlInvoicelineId + " ]";
    }
    
}
