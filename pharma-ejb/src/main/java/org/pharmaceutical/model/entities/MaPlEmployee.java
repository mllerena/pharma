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

import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ma_pl_employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaPlEmployee.findAll", query = "SELECT m FROM MaPlEmployee m"),
    @NamedQuery(name = "MaPlEmployee.findByMaPlEmployeeId", query = "SELECT m FROM MaPlEmployee m WHERE m.maPlEmployeeId = :maPlEmployeeId"),
    @NamedQuery(name = "MaPlEmployee.findByCreated", query = "SELECT m FROM MaPlEmployee m WHERE m.created = :created"),
    @NamedQuery(name = "MaPlEmployee.findByCreatedby", query = "SELECT m FROM MaPlEmployee m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaPlEmployee.findByUpdated", query = "SELECT m FROM MaPlEmployee m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaPlEmployee.findByUpdatedby", query = "SELECT m FROM MaPlEmployee m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaPlEmployee.findByQuantity", query = "SELECT m FROM MaPlEmployee m WHERE m.quantity = :quantity"),
    @NamedQuery(name = "MaPlEmployee.findByIsactive", query = "SELECT m FROM MaPlEmployee m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaPlEmployee.findByCalccost", query = "SELECT m FROM MaPlEmployee m WHERE m.calccost = :calccost"),
    @NamedQuery(name = "MaPlEmployee.findByMProductionplanId", query = "SELECT m FROM MaPlEmployee m WHERE m.mProductionplanId = :mProductionplanId and m.isactive = :isactive")
})
public class MaPlEmployee extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_pl_employee_id")
    private String maPlEmployeeId;
    
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
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class) 
    private YesNo isactive; 
    
    @Column(name = "calccost")
    private BigDecimal calccost;
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_salary_category_id", referencedColumnName = "c_salary_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CSalaryCategory cSalaryCategoryId;
    @JoinColumn(name = "m_productionplan_id", referencedColumnName = "m_productionplan_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProductionplan mProductionplanId;

    public MaPlEmployee() {
    }

    public MaPlEmployee(String maPlEmployeeId) {
        this.maPlEmployeeId = maPlEmployeeId;
    }

    public String getMaPlEmployeeId() {
        return maPlEmployeeId;
    }

    public void setMaPlEmployeeId(String maPlEmployeeId) {
        this.maPlEmployeeId = maPlEmployeeId;
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

    public YesNo getIsactive() {
        return isactive;
    }

    public void setIsactive(YesNo isactive) {
        this.isactive = isactive;
    }

    public BigDecimal getCalccost() {
        return calccost;
    }

    public void setCalccost(BigDecimal calccost) {
        this.calccost = calccost;
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

    public MProductionplan getMProductionplanId() {
        return mProductionplanId;
    }

    public void setMProductionplanId(MProductionplan mProductionplanId) {
        this.mProductionplanId = mProductionplanId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maPlEmployeeId != null ? maPlEmployeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaPlEmployee)) {
            return false;
        }
        MaPlEmployee other = (MaPlEmployee) object;
        if ((this.maPlEmployeeId == null && other.maPlEmployeeId != null) || (this.maPlEmployeeId != null && !this.maPlEmployeeId.equals(other.maPlEmployeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaPlEmployee[ maPlEmployeeId=" + maPlEmployeeId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maPlEmployeeId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maPlEmployeeId = id;
	}
    
}
