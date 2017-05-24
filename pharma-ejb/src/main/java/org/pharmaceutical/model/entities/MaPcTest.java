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
@Table(name = "ma_pc_test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaPcTest.findAll", query = "SELECT m FROM MaPcTest m"),
    @NamedQuery(name = "MaPcTest.findByMaPcTestId", query = "SELECT m FROM MaPcTest m WHERE m.maPcTestId = :maPcTestId"),
    @NamedQuery(name = "MaPcTest.findByIsactive", query = "SELECT m FROM MaPcTest m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaPcTest.findByCreated", query = "SELECT m FROM MaPcTest m WHERE m.created = :created"),
    @NamedQuery(name = "MaPcTest.findByCreatedby", query = "SELECT m FROM MaPcTest m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaPcTest.findByUpdated", query = "SELECT m FROM MaPcTest m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaPcTest.findByUpdatedby", query = "SELECT m FROM MaPcTest m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaPcTest.findByName", query = "SELECT m FROM MaPcTest m WHERE m.name = :name"),
    @NamedQuery(name = "MaPcTest.findByDescription", query = "SELECT m FROM MaPcTest m WHERE m.description = :description"),
    @NamedQuery(name = "MaPcTest.findByDays", query = "SELECT m FROM MaPcTest m WHERE m.days = :days"),
    @NamedQuery(name = "MaPcTest.findByMaPeriodicControlId", query = "SELECT m FROM MaPcTest m WHERE m.maPeriodicControlId = :maPeriodicControlId and m.isactive = :isactive")
        
})
public class MaPcTest extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ma_pc_test_id")
    private String maPcTestId;
    
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
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Basic(optional = false)
    @Column(name = "days")
    private BigInteger days;
    
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maPcTestId")
    private List<MaPcValue> maPcValueList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_periodic_control_id", referencedColumnName = "ma_periodic_control_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaPeriodicControl maPeriodicControlId;

    public MaPcTest() {
    }

    public MaPcTest(String maPcTestId) {
        this.maPcTestId = maPcTestId;
    }

    public String getMaPcTestId() {
        return maPcTestId;
    }

    public void setMaPcTestId(String maPcTestId) {
        this.maPcTestId = maPcTestId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getDays() {
        return days;
    }

    public void setDays(BigInteger days) {
        this.days = days;
    }

    @XmlTransient
    public List<MaPcValue> getMaPcValueList() {
        return maPcValueList;
    }

    public void setMaPcValueList(List<MaPcValue> maPcValueList) {
        this.maPcValueList = maPcValueList;
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

    public MaPeriodicControl getMaPeriodicControlId() {
        return maPeriodicControlId;
    }

    public void setMaPeriodicControlId(MaPeriodicControl maPeriodicControlId) {
        this.maPeriodicControlId = maPeriodicControlId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maPcTestId != null ? maPcTestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaPcTest)) {
            return false;
        }
        MaPcTest other = (MaPcTest) object;
        if ((this.maPcTestId == null && other.maPcTestId != null) || (this.maPcTestId != null && !this.maPcTestId.equals(other.maPcTestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaPcTest[ maPcTestId=" + maPcTestId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return maPcTestId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		maPcTestId = id;
	}
    
}
