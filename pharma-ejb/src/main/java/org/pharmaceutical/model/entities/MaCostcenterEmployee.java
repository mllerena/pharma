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
import javax.persistence.Convert;
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

import org.pharmaceutical.model.converters.CostUOMConverter;
import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.CostUOM;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ma_costcenter_employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaCostcenterEmployee.findAll", query = "SELECT m FROM MaCostcenterEmployee m"),
    @NamedQuery(name = "MaCostcenterEmployee.findByMaCostcenterEmployeeId", query = "SELECT m FROM MaCostcenterEmployee m WHERE m.maCostcenterEmployeeId = :maCostcenterEmployeeId"),
    @NamedQuery(name = "MaCostcenterEmployee.findByCreated", query = "SELECT m FROM MaCostcenterEmployee m WHERE m.created = :created"),
    @NamedQuery(name = "MaCostcenterEmployee.findByCreatedby", query = "SELECT m FROM MaCostcenterEmployee m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaCostcenterEmployee.findByUpdated", query = "SELECT m FROM MaCostcenterEmployee m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaCostcenterEmployee.findByUpdatedby", query = "SELECT m FROM MaCostcenterEmployee m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaCostcenterEmployee.findByQuantity", query = "SELECT m FROM MaCostcenterEmployee m WHERE m.quantity = :quantity"),
    @NamedQuery(name = "MaCostcenterEmployee.findByCostuom", query = "SELECT m FROM MaCostcenterEmployee m WHERE m.costuom = :costuom"),
    @NamedQuery(name = "MaCostcenterEmployee.findByIsactive", query = "SELECT m FROM MaCostcenterEmployee m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaCostcenterEmployee.findByMaCostcenterVersionId", query = "SELECT m FROM MaCostcenterEmployee m WHERE m.maCostcenterVersionId = :maCostcenterVersionId and m.isactive = :isactive")
        
})
public class MaCostcenterEmployee extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ma_costcenter_employee_id")
    private String maCostcenterEmployeeId;
    
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
    @NotNull
    @Column(name = "quantity")
    private BigInteger quantity;
    
    @Basic(optional = false)
    @Column(name = "costuom")
    @Convert(converter=CostUOMConverter.class) 
    private CostUOM costuom;
    
    @Basic(optional = false)
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class) 
    private YesNo isactive;
    
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_salary_category_id", referencedColumnName = "c_salary_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CSalaryCategory cSalaryCategoryId;
    @JoinColumn(name = "ma_costcenter_version_id", referencedColumnName = "ma_costcenter_version_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaCostcenterVersion maCostcenterVersionId;

    public MaCostcenterEmployee() {
    }

    public MaCostcenterEmployee(String maCostcenterEmployeeId) {
        this.maCostcenterEmployeeId = maCostcenterEmployeeId;
    }

    public String getMaCostcenterEmployeeId() {
        return maCostcenterEmployeeId;
    }

    public void setMaCostcenterEmployeeId(String maCostcenterEmployeeId) {
        this.maCostcenterEmployeeId = maCostcenterEmployeeId;
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

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public CostUOM getCostuom() {
        return costuom;
    }

    public void setCostuom(CostUOM costuom) {
        this.costuom = costuom;
    }

    public YesNo getIsactive() {
        return isactive;
    }

    public void setIsactive(YesNo isactive) {
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

    public CSalaryCategory getCSalaryCategoryId() {
        return cSalaryCategoryId;
    }

    public void setCSalaryCategoryId(CSalaryCategory cSalaryCategoryId) {
        this.cSalaryCategoryId = cSalaryCategoryId;
    }

    public MaCostcenterVersion getMaCostcenterVersionId() {
        return maCostcenterVersionId;
    }

    public void setMaCostcenterVersionId(MaCostcenterVersion maCostcenterVersionId) {
        this.maCostcenterVersionId = maCostcenterVersionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCostcenterEmployeeId != null ? maCostcenterEmployeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaCostcenterEmployee)) {
            return false;
        }
        MaCostcenterEmployee other = (MaCostcenterEmployee) object;
        if ((this.maCostcenterEmployeeId == null && other.maCostcenterEmployeeId != null) || (this.maCostcenterEmployeeId != null && !this.maCostcenterEmployeeId.equals(other.maCostcenterEmployeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaCostcenterEmployee[ maCostcenterEmployeeId=" + maCostcenterEmployeeId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maCostcenterEmployeeId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maCostcenterEmployeeId = id;
	}
    
}
