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
@Table(name = "c_commissionamt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CCommissionamt.findAll", query = "SELECT c FROM CCommissionamt c"),
    @NamedQuery(name = "CCommissionamt.findByCCommissionamtId", query = "SELECT c FROM CCommissionamt c WHERE c.cCommissionamtId = :cCommissionamtId"),
    @NamedQuery(name = "CCommissionamt.findByIsactive", query = "SELECT c FROM CCommissionamt c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CCommissionamt.findByCreated", query = "SELECT c FROM CCommissionamt c WHERE c.created = :created"),
    @NamedQuery(name = "CCommissionamt.findByCreatedby", query = "SELECT c FROM CCommissionamt c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CCommissionamt.findByUpdated", query = "SELECT c FROM CCommissionamt c WHERE c.updated = :updated"),
    @NamedQuery(name = "CCommissionamt.findByUpdatedby", query = "SELECT c FROM CCommissionamt c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CCommissionamt.findByConvertedamt", query = "SELECT c FROM CCommissionamt c WHERE c.convertedamt = :convertedamt"),
    @NamedQuery(name = "CCommissionamt.findByActualqty", query = "SELECT c FROM CCommissionamt c WHERE c.actualqty = :actualqty"),
    @NamedQuery(name = "CCommissionamt.findByCommissionamt", query = "SELECT c FROM CCommissionamt c WHERE c.commissionamt = :commissionamt")})
public class CCommissionamt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_commissionamt_id")
    private String cCommissionamtId;
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
    @Column(name = "convertedamt")
    private BigInteger convertedamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actualqty")
    private BigInteger actualqty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "commissionamt")
    private BigInteger commissionamt;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_commissionline_id", referencedColumnName = "c_commissionline_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCommissionline cCommissionlineId;
    @JoinColumn(name = "c_commissionrun_id", referencedColumnName = "c_commissionrun_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CCommissionrun cCommissionrunId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cCommissionamtId")
    private List<CCommissiondetail> cCommissiondetailList;

    public CCommissionamt() {
    }

    public CCommissionamt(String cCommissionamtId) {
        this.cCommissionamtId = cCommissionamtId;
    }

    public CCommissionamt(String cCommissionamtId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger convertedamt, BigInteger actualqty, BigInteger commissionamt) {
        this.cCommissionamtId = cCommissionamtId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.convertedamt = convertedamt;
        this.actualqty = actualqty;
        this.commissionamt = commissionamt;
    }

    public String getCCommissionamtId() {
        return cCommissionamtId;
    }

    public void setCCommissionamtId(String cCommissionamtId) {
        this.cCommissionamtId = cCommissionamtId;
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

    public BigInteger getConvertedamt() {
        return convertedamt;
    }

    public void setConvertedamt(BigInteger convertedamt) {
        this.convertedamt = convertedamt;
    }

    public BigInteger getActualqty() {
        return actualqty;
    }

    public void setActualqty(BigInteger actualqty) {
        this.actualqty = actualqty;
    }

    public BigInteger getCommissionamt() {
        return commissionamt;
    }

    public void setCommissionamt(BigInteger commissionamt) {
        this.commissionamt = commissionamt;
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

    public CCommissionline getCCommissionlineId() {
        return cCommissionlineId;
    }

    public void setCCommissionlineId(CCommissionline cCommissionlineId) {
        this.cCommissionlineId = cCommissionlineId;
    }

    public CCommissionrun getCCommissionrunId() {
        return cCommissionrunId;
    }

    public void setCCommissionrunId(CCommissionrun cCommissionrunId) {
        this.cCommissionrunId = cCommissionrunId;
    }

    @XmlTransient
    public List<CCommissiondetail> getCCommissiondetailList() {
        return cCommissiondetailList;
    }

    public void setCCommissiondetailList(List<CCommissiondetail> cCommissiondetailList) {
        this.cCommissiondetailList = cCommissiondetailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cCommissionamtId != null ? cCommissionamtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCommissionamt)) {
            return false;
        }
        CCommissionamt other = (CCommissionamt) object;
        if ((this.cCommissionamtId == null && other.cCommissionamtId != null) || (this.cCommissionamtId != null && !this.cCommissionamtId.equals(other.cCommissionamtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CCommissionamt[ cCommissionamtId=" + cCommissionamtId + " ]";
    }
    
}
