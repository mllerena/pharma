/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.pharmaceutical.model.converters.CostUOMConverter;
import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.CostUOM;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ma_costcenter_version")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaCostcenterVersion.findAll", query = "SELECT m FROM MaCostcenterVersion m"),
    @NamedQuery(name = "MaCostcenterVersion.findByMaCostcenterVersionId", query = "SELECT m FROM MaCostcenterVersion m WHERE m.maCostcenterVersionId = :maCostcenterVersionId"),
    @NamedQuery(name = "MaCostcenterVersion.findByIsactive", query = "SELECT m FROM MaCostcenterVersion m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaCostcenterVersion.findByCreated", query = "SELECT m FROM MaCostcenterVersion m WHERE m.created = :created"),
    @NamedQuery(name = "MaCostcenterVersion.findByCreatedby", query = "SELECT m FROM MaCostcenterVersion m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaCostcenterVersion.findByUpdated", query = "SELECT m FROM MaCostcenterVersion m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaCostcenterVersion.findByUpdatedby", query = "SELECT m FROM MaCostcenterVersion m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaCostcenterVersion.findByDocumentno", query = "SELECT m FROM MaCostcenterVersion m WHERE m.documentno = :documentno"),
    @NamedQuery(name = "MaCostcenterVersion.findByCost", query = "SELECT m FROM MaCostcenterVersion m WHERE m.cost = :cost"),
    @NamedQuery(name = "MaCostcenterVersion.findByCostuom", query = "SELECT m FROM MaCostcenterVersion m WHERE m.costuom = :costuom"),
    @NamedQuery(name = "MaCostcenterVersion.findByValidfrom", query = "SELECT m FROM MaCostcenterVersion m WHERE m.validfrom = :validfrom"),
    @NamedQuery(name = "MaCostcenterVersion.findByMaCostcenterId", query = "SELECT m FROM MaCostcenterVersion m WHERE m.maCostcenterId = :maCostcenterId and m.isactive = :isactive"),
})
public class MaCostcenterVersion extends AbstractEntityModel implements Serializable { 
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_costcenter_version_id")
    private String maCostcenterVersionId;
    
    @Basic(optional = false)
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class)
    
    private YesNo isactive;  
    @Basic(optional = false)
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
    @Column(name = "documentno")
    private String documentno;
    
    @Column(name = "cost")
    private BigDecimal cost; 
    
    @Basic(optional = false)
    @Column(name = "costuom")
    @Convert(converter=CostUOMConverter.class) 
    private CostUOM costuom;
    
    @Basic(optional = false)
    @Column(name = "validfrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validfrom;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maCostcenterVersionId")
    private List<MaCostcenterIc> maCostcenterIcList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maCostcenterVersionId")
    private List<MaCostcenterMachine> maCostcenterMachineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maCostcenterVersionId")
    private List<MaCostcenterEmployee> maCostcenterEmployeeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maCostcenterVersionId")
    private List<MProductionplan> mProductionplanList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_costcenter_id", referencedColumnName = "ma_costcenter_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaCostcenter maCostcenterId;

    public MaCostcenterVersion() {
    }

    public MaCostcenterVersion(String maCostcenterVersionId) {
        this.maCostcenterVersionId = maCostcenterVersionId;
    }


    public String getMaCostcenterVersionId() {
        return maCostcenterVersionId;
    }

    public void setMaCostcenterVersionId(String maCostcenterVersionId) {
        this.maCostcenterVersionId = maCostcenterVersionId;
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

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public CostUOM getCostuom() {
        return costuom;
    }

    public void setCostuom(CostUOM costuom) {
        this.costuom = costuom;
    }

    public Date getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(Date validfrom) {
        this.validfrom = validfrom;
    }

    @XmlTransient
    public List<MaCostcenterIc> getMaCostcenterIcList() {
        return maCostcenterIcList;
    }

    public void setMaCostcenterIcList(List<MaCostcenterIc> maCostcenterIcList) {
        this.maCostcenterIcList = maCostcenterIcList;
    }

    @XmlTransient
    public List<MaCostcenterMachine> getMaCostcenterMachineList() {
        return maCostcenterMachineList;
    }

    public void setMaCostcenterMachineList(List<MaCostcenterMachine> maCostcenterMachineList) {
        this.maCostcenterMachineList = maCostcenterMachineList;
    }

    @XmlTransient
    public List<MaCostcenterEmployee> getMaCostcenterEmployeeList() {
        return maCostcenterEmployeeList;
    }

    public void setMaCostcenterEmployeeList(List<MaCostcenterEmployee> maCostcenterEmployeeList) {
        this.maCostcenterEmployeeList = maCostcenterEmployeeList;
    }

    @XmlTransient
    public List<MProductionplan> getMProductionplanList() {
        return mProductionplanList;
    }

    public void setMProductionplanList(List<MProductionplan> mProductionplanList) {
        this.mProductionplanList = mProductionplanList;
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

    public MaCostcenter getMaCostcenterId() {
        return maCostcenterId;
    }

    public void setMaCostcenterId(MaCostcenter maCostcenterId) {
        this.maCostcenterId = maCostcenterId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCostcenterVersionId != null ? maCostcenterVersionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaCostcenterVersion)) {
            return false;
        }
        MaCostcenterVersion other = (MaCostcenterVersion) object;
        if ((this.maCostcenterVersionId == null && other.maCostcenterVersionId != null) || (this.maCostcenterVersionId != null && !this.maCostcenterVersionId.equals(other.maCostcenterVersionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaCostcenterVersion[ maCostcenterVersionId=" + maCostcenterVersionId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maCostcenterVersionId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maCostcenterVersionId = id;
	}
    
}
