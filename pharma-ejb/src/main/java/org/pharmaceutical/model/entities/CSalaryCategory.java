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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "c_salary_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CSalaryCategory.findAll", query = "SELECT c FROM CSalaryCategory c"),
    @NamedQuery(name = "CSalaryCategory.findByCSalaryCategoryId", query = "SELECT c FROM CSalaryCategory c WHERE c.cSalaryCategoryId = :cSalaryCategoryId"),
    @NamedQuery(name = "CSalaryCategory.findByCreated", query = "SELECT c FROM CSalaryCategory c WHERE c.created = :created"),
    @NamedQuery(name = "CSalaryCategory.findByCreatedby", query = "SELECT c FROM CSalaryCategory c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CSalaryCategory.findByUpdated", query = "SELECT c FROM CSalaryCategory c WHERE c.updated = :updated"),
    @NamedQuery(name = "CSalaryCategory.findByUpdatedby", query = "SELECT c FROM CSalaryCategory c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CSalaryCategory.findByName", query = "SELECT c FROM CSalaryCategory c WHERE c.name = :name"),
    @NamedQuery(name = "CSalaryCategory.findByDescription", query = "SELECT c FROM CSalaryCategory c WHERE c.description = :description"),
    @NamedQuery(name = "CSalaryCategory.findByIsactive", query = "SELECT c FROM CSalaryCategory c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CSalaryCategory.findByIscostapplied", query = "SELECT c FROM CSalaryCategory c WHERE c.iscostapplied = :iscostapplied")})
public class CSalaryCategory extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_salary_category_id")
    private String cSalaryCategoryId;
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
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class) 
    private YesNo isactive; 
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "iscostapplied")
    private Character iscostapplied;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cSalaryCategoryId")
    private List<CBpartner> cBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cSalaryCategoryId")
    private List<MaCostcenterEmployee> maCostcenterEmployeeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cSalaryCategoryId")
    private List<CBpSalcategory> cBpSalcategoryList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cSalaryCategoryId")
    private List<MaPlEmployee> maPlEmployeeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cSalaryCategoryId")
    private List<MaSequenceEmployee> maSequenceEmployeeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cSalaryCategoryId")
    private List<CSalaryCategoryCost> cSalaryCategoryCostList;

    public CSalaryCategory() {
    }

    public CSalaryCategory(String cSalaryCategoryId) {
        this.cSalaryCategoryId = cSalaryCategoryId;
    }
    
    public String getCSalaryCategoryId() {
        return cSalaryCategoryId;
    }

    public void setCSalaryCategoryId(String cSalaryCategoryId) {
        this.cSalaryCategoryId = cSalaryCategoryId;
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

    public YesNo getIsactive() {
        return isactive;
    }

    public void setIsactive(YesNo isactive) {
        this.isactive = isactive;
    }

    public Character getIscostapplied() {
        return iscostapplied;
    }

    public void setIscostapplied(Character iscostapplied) {
        this.iscostapplied = iscostapplied;
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
    public List<CBpartner> getCBpartnerList() {
        return cBpartnerList;
    }

    public void setCBpartnerList(List<CBpartner> cBpartnerList) {
        this.cBpartnerList = cBpartnerList;
    }

    @XmlTransient
    public List<MaCostcenterEmployee> getMaCostcenterEmployeeList() {
        return maCostcenterEmployeeList;
    }

    public void setMaCostcenterEmployeeList(List<MaCostcenterEmployee> maCostcenterEmployeeList) {
        this.maCostcenterEmployeeList = maCostcenterEmployeeList;
    }

    @XmlTransient
    public List<CBpSalcategory> getCBpSalcategoryList() {
        return cBpSalcategoryList;
    }

    public void setCBpSalcategoryList(List<CBpSalcategory> cBpSalcategoryList) {
        this.cBpSalcategoryList = cBpSalcategoryList;
    }

    @XmlTransient
    public List<MaPlEmployee> getMaPlEmployeeList() {
        return maPlEmployeeList;
    }

    public void setMaPlEmployeeList(List<MaPlEmployee> maPlEmployeeList) {
        this.maPlEmployeeList = maPlEmployeeList;
    }

    @XmlTransient
    public List<MaSequenceEmployee> getMaSequenceEmployeeList() {
        return maSequenceEmployeeList;
    }

    public void setMaSequenceEmployeeList(List<MaSequenceEmployee> maSequenceEmployeeList) {
        this.maSequenceEmployeeList = maSequenceEmployeeList;
    }

    @XmlTransient
    public List<CSalaryCategoryCost> getCSalaryCategoryCostList() {
        return cSalaryCategoryCostList;
    }

    public void setCSalaryCategoryCostList(List<CSalaryCategoryCost> cSalaryCategoryCostList) {
        this.cSalaryCategoryCostList = cSalaryCategoryCostList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cSalaryCategoryId != null ? cSalaryCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CSalaryCategory)) {
            return false;
        }
        CSalaryCategory other = (CSalaryCategory) object;
        if ((this.cSalaryCategoryId == null && other.cSalaryCategoryId != null) || (this.cSalaryCategoryId != null && !this.cSalaryCategoryId.equals(other.cSalaryCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CSalaryCategory[ cSalaryCategoryId=" + cSalaryCategoryId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return cSalaryCategoryId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		cSalaryCategoryId = id;
	}
    
}
