/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
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
@Table(name = "ma_indirect_cost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaIndirectCost.findAll", query = "SELECT m FROM MaIndirectCost m"),
    @NamedQuery(name = "MaIndirectCost.findByMaIndirectCostId", query = "SELECT m FROM MaIndirectCost m WHERE m.maIndirectCostId = :maIndirectCostId"),
    @NamedQuery(name = "MaIndirectCost.findByIsactive", query = "SELECT m FROM MaIndirectCost m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaIndirectCost.findByCreated", query = "SELECT m FROM MaIndirectCost m WHERE m.created = :created"),
    @NamedQuery(name = "MaIndirectCost.findByCreatedby", query = "SELECT m FROM MaIndirectCost m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaIndirectCost.findByUpdated", query = "SELECT m FROM MaIndirectCost m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaIndirectCost.findByUpdatedby", query = "SELECT m FROM MaIndirectCost m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaIndirectCost.findByName", query = "SELECT m FROM MaIndirectCost m WHERE m.name = :name"),
    @NamedQuery(name = "MaIndirectCost.findByDescription", query = "SELECT m FROM MaIndirectCost m WHERE m.description = :description"),
    @NamedQuery(name = "MaIndirectCost.findByCostType", query = "SELECT m FROM MaIndirectCost m WHERE m.costType = :costType")})
public class MaIndirectCost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_indirect_cost_id")
    private String maIndirectCostId;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "cost_type")
    private String costType;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maIndirectCostId")
    private List<MaCostcenterIc> maCostcenterIcList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maIndirectCostId")
    private List<MaIndirectCostValue> maIndirectCostValueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maIndirectCostId")
    private List<MaPlIc> maPlIcList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maIndirectCostId")
    private List<MaSequenceIc> maSequenceIcList;

    public MaIndirectCost() {
    }

    public MaIndirectCost(String maIndirectCostId) {
        this.maIndirectCostId = maIndirectCostId;
    }

    public MaIndirectCost(String maIndirectCostId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String costType) {
        this.maIndirectCostId = maIndirectCostId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.costType = costType;
    }

    public String getMaIndirectCostId() {
        return maIndirectCostId;
    }

    public void setMaIndirectCostId(String maIndirectCostId) {
        this.maIndirectCostId = maIndirectCostId;
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

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
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

    @XmlTransient
    public List<MaCostcenterIc> getMaCostcenterIcList() {
        return maCostcenterIcList;
    }

    public void setMaCostcenterIcList(List<MaCostcenterIc> maCostcenterIcList) {
        this.maCostcenterIcList = maCostcenterIcList;
    }

    @XmlTransient
    public List<MaIndirectCostValue> getMaIndirectCostValueList() {
        return maIndirectCostValueList;
    }

    public void setMaIndirectCostValueList(List<MaIndirectCostValue> maIndirectCostValueList) {
        this.maIndirectCostValueList = maIndirectCostValueList;
    }

    @XmlTransient
    public List<MaPlIc> getMaPlIcList() {
        return maPlIcList;
    }

    public void setMaPlIcList(List<MaPlIc> maPlIcList) {
        this.maPlIcList = maPlIcList;
    }

    @XmlTransient
    public List<MaSequenceIc> getMaSequenceIcList() {
        return maSequenceIcList;
    }

    public void setMaSequenceIcList(List<MaSequenceIc> maSequenceIcList) {
        this.maSequenceIcList = maSequenceIcList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maIndirectCostId != null ? maIndirectCostId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaIndirectCost)) {
            return false;
        }
        MaIndirectCost other = (MaIndirectCost) object;
        if ((this.maIndirectCostId == null && other.maIndirectCostId != null) || (this.maIndirectCostId != null && !this.maIndirectCostId.equals(other.maIndirectCostId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaIndirectCost[ maIndirectCostId=" + maIndirectCostId + " ]";
    }
    
}
