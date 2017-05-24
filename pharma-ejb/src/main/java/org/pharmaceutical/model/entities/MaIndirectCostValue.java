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
@Table(name = "ma_indirect_cost_value")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaIndirectCostValue.findAll", query = "SELECT m FROM MaIndirectCostValue m"),
    @NamedQuery(name = "MaIndirectCostValue.findByMaIndirectCostValueId", query = "SELECT m FROM MaIndirectCostValue m WHERE m.maIndirectCostValueId = :maIndirectCostValueId"),
    @NamedQuery(name = "MaIndirectCostValue.findByIsactive", query = "SELECT m FROM MaIndirectCostValue m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaIndirectCostValue.findByCreated", query = "SELECT m FROM MaIndirectCostValue m WHERE m.created = :created"),
    @NamedQuery(name = "MaIndirectCostValue.findByCreatedby", query = "SELECT m FROM MaIndirectCostValue m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaIndirectCostValue.findByUpdated", query = "SELECT m FROM MaIndirectCostValue m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaIndirectCostValue.findByUpdatedby", query = "SELECT m FROM MaIndirectCostValue m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaIndirectCostValue.findByDatefrom", query = "SELECT m FROM MaIndirectCostValue m WHERE m.datefrom = :datefrom"),
    @NamedQuery(name = "MaIndirectCostValue.findByDateto", query = "SELECT m FROM MaIndirectCostValue m WHERE m.dateto = :dateto"),
    @NamedQuery(name = "MaIndirectCostValue.findByTotal", query = "SELECT m FROM MaIndirectCostValue m WHERE m.total = :total"),
    @NamedQuery(name = "MaIndirectCostValue.findByCost", query = "SELECT m FROM MaIndirectCostValue m WHERE m.cost = :cost"),
    @NamedQuery(name = "MaIndirectCostValue.findByCalculate", query = "SELECT m FROM MaIndirectCostValue m WHERE m.calculate = :calculate"),
    @NamedQuery(name = "MaIndirectCostValue.findByCostUom", query = "SELECT m FROM MaIndirectCostValue m WHERE m.costUom = :costUom"),
    @NamedQuery(name = "MaIndirectCostValue.findByCalculated", query = "SELECT m FROM MaIndirectCostValue m WHERE m.calculated = :calculated")})
public class MaIndirectCostValue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_indirect_cost_value_id")
    private String maIndirectCostValueId;
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
    @Column(name = "datefrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateto;
    @Column(name = "total")
    private BigInteger total;
    @Column(name = "cost")
    private BigInteger cost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calculate")
    private Character calculate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "cost_uom")
    private String costUom;
    @Column(name = "calculated")
    private Character calculated;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_indirect_cost_id", referencedColumnName = "ma_indirect_cost_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaIndirectCost maIndirectCostId;

    public MaIndirectCostValue() {
    }

    public MaIndirectCostValue(String maIndirectCostValueId) {
        this.maIndirectCostValueId = maIndirectCostValueId;
    }

    public MaIndirectCostValue(String maIndirectCostValueId, Character isactive, Date created, String createdby, Date updated, String updatedby, Date datefrom, Date dateto, Character calculate, String costUom) {
        this.maIndirectCostValueId = maIndirectCostValueId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.datefrom = datefrom;
        this.dateto = dateto;
        this.calculate = calculate;
        this.costUom = costUom;
    }

    public String getMaIndirectCostValueId() {
        return maIndirectCostValueId;
    }

    public void setMaIndirectCostValueId(String maIndirectCostValueId) {
        this.maIndirectCostValueId = maIndirectCostValueId;
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

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public BigInteger getCost() {
        return cost;
    }

    public void setCost(BigInteger cost) {
        this.cost = cost;
    }

    public Character getCalculate() {
        return calculate;
    }

    public void setCalculate(Character calculate) {
        this.calculate = calculate;
    }

    public String getCostUom() {
        return costUom;
    }

    public void setCostUom(String costUom) {
        this.costUom = costUom;
    }

    public Character getCalculated() {
        return calculated;
    }

    public void setCalculated(Character calculated) {
        this.calculated = calculated;
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

    public MaIndirectCost getMaIndirectCostId() {
        return maIndirectCostId;
    }

    public void setMaIndirectCostId(MaIndirectCost maIndirectCostId) {
        this.maIndirectCostId = maIndirectCostId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maIndirectCostValueId != null ? maIndirectCostValueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaIndirectCostValue)) {
            return false;
        }
        MaIndirectCostValue other = (MaIndirectCostValue) object;
        if ((this.maIndirectCostValueId == null && other.maIndirectCostValueId != null) || (this.maIndirectCostValueId != null && !this.maIndirectCostValueId.equals(other.maIndirectCostValueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaIndirectCostValue[ maIndirectCostValueId=" + maIndirectCostValueId + " ]";
    }
    
}
