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
import javax.persistence.Convert;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ma_costcenter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaCostcenter.findAll", query = "SELECT m FROM MaCostcenter m"),
    @NamedQuery(name = "MaCostcenter.findByMaCostcenterId", query = "SELECT m FROM MaCostcenter m WHERE m.maCostcenterId = :maCostcenterId"),
    @NamedQuery(name = "MaCostcenter.findByIsactive", query = "SELECT m FROM MaCostcenter m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaCostcenter.findByCreated", query = "SELECT m FROM MaCostcenter m WHERE m.created = :created"),
    @NamedQuery(name = "MaCostcenter.findByCreatedby", query = "SELECT m FROM MaCostcenter m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaCostcenter.findByUpdated", query = "SELECT m FROM MaCostcenter m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaCostcenter.findByUpdatedby", query = "SELECT m FROM MaCostcenter m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaCostcenter.findByName", query = "SELECT m FROM MaCostcenter m WHERE m.name = :name and m.isactive = :isactive"), 
    @NamedQuery(name = "MaCostcenter.findByCost", query = "SELECT m FROM MaCostcenter m WHERE m.cost = :cost"),
    @NamedQuery(name = "MaCostcenter.findByValue", query = "SELECT m FROM MaCostcenter m WHERE m.value = :value"),
    @NamedQuery(name = "MaCostcenter.findByBydefault", query = "SELECT m FROM MaCostcenter m WHERE m.bydefault = :bydefault"),
    @NamedQuery(name = "MaCostcenter.findByCalculated", query = "SELECT m FROM MaCostcenter m WHERE m.calculated = :calculated"),
    @NamedQuery(name = "MaCostcenter.findByCostuom", query = "SELECT m FROM MaCostcenter m WHERE m.costuom = :costuom")})
public class MaCostcenter extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_costcenter_id")
    private String maCostcenterId;
    
    @Basic(optional = false)
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class)
    private YesNo isactive;  
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @Basic(optional = false)
    @Column(name = "createdby")
    private String createdby;
    
    @Basic(optional = false)
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    
    @Basic(optional = false)
    @Column(name = "updatedby")
    private String updatedby;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    
    @Column(name = "cost")
    private BigInteger cost;
    
    @Basic(optional = false)
    @Column(name = "value")
    private String value;
    
    @Column(name = "bydefault")
    @Convert(converter=YesNoConverter.class)
    private YesNo bydefault;
    
    @Column(name = "calculated")
    @Convert(converter=YesNoConverter.class)
    private YesNo calculated;
    
    @Column(name = "costuom")
    private String costuom;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maCostcenterId")
    private List<MaProcess> maProcessList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maCostcenterId")
    private List<MaMachine> maMachineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maCostcenterId")
    private List<MaCostcenterVersion> maCostcenterVersionList;

    public MaCostcenter() {
    }

    public MaCostcenter(String maCostcenterId) {
        this.maCostcenterId = maCostcenterId;
    }

    public String getMaCostcenterId() {
        return maCostcenterId;
    }

    public void setMaCostcenterId(String maCostcenterId) {
        this.maCostcenterId = maCostcenterId;
    }

    public YesNo getIsactive() {
        return isactive;
    }

    public void setIsactive(YesNo isactive) { 
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

    public BigInteger getCost() {
        return cost;
    }

    public void setCost(BigInteger cost) {
        this.cost = cost;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public YesNo getBydefault() {
        return bydefault;
    }

    public void setBydefault(YesNo bydefault) {
        this.bydefault = bydefault;
    }

    public YesNo getCalculated() {
        return calculated;
    }

    public void setCalculated(YesNo calculated) { 
        this.calculated = calculated;
    }

    public String getCostuom() {
        return costuom;
    }

    public void setCostuom(String costuom) {
        this.costuom = costuom;
    }

    @XmlTransient
    public List<MaProcess> getMaProcessList() {
        return maProcessList;
    }

    public void setMaProcessList(List<MaProcess> maProcessList) {
        this.maProcessList = maProcessList;
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
    public List<MaMachine> getMaMachineList() {
        return maMachineList;
    }

    public void setMaMachineList(List<MaMachine> maMachineList) {
        this.maMachineList = maMachineList;
    }

    @XmlTransient
    public List<MaCostcenterVersion> getMaCostcenterVersionList() {
        return maCostcenterVersionList;
    }

    public void setMaCostcenterVersionList(List<MaCostcenterVersion> maCostcenterVersionList) {
        this.maCostcenterVersionList = maCostcenterVersionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCostcenterId != null ? maCostcenterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaCostcenter)) {
            return false;
        }
        MaCostcenter other = (MaCostcenter) object;
        if ((this.maCostcenterId == null && other.maCostcenterId != null) || (this.maCostcenterId != null && !this.maCostcenterId.equals(other.maCostcenterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaCostcenter[ maCostcenterId=" + maCostcenterId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maCostcenterId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maCostcenterId = id;
	}
    
}
