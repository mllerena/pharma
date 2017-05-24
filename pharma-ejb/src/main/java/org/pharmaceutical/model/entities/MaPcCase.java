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
@Table(name = "ma_pc_case")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaPcCase.findAll", query = "SELECT m FROM MaPcCase m"),
    @NamedQuery(name = "MaPcCase.findByMaPcCaseId", query = "SELECT m FROM MaPcCase m WHERE m.maPcCaseId = :maPcCaseId"),
    @NamedQuery(name = "MaPcCase.findByIsactive", query = "SELECT m FROM MaPcCase m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaPcCase.findByCreated", query = "SELECT m FROM MaPcCase m WHERE m.created = :created"),
    @NamedQuery(name = "MaPcCase.findByCreatedby", query = "SELECT m FROM MaPcCase m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaPcCase.findByUpdated", query = "SELECT m FROM MaPcCase m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaPcCase.findByUpdatedby", query = "SELECT m FROM MaPcCase m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaPcCase.findByName", query = "SELECT m FROM MaPcCase m WHERE m.name = :name"),
    @NamedQuery(name = "MaPcCase.findByStartdate", query = "SELECT m FROM MaPcCase m WHERE m.startdate = :startdate"),
    @NamedQuery(name = "MaPcCase.findByEnddate", query = "SELECT m FROM MaPcCase m WHERE m.enddate = :enddate"),
    @NamedQuery(name = "MaPcCase.findByLaunched", query = "SELECT m FROM MaPcCase m WHERE m.launched = :launched")})
public class MaPcCase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_pc_case_id")
    private String maPcCaseId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "launched")
    private Character launched;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maPcCaseId")
    private List<MaPcValue> maPcValueList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_attributesetinstance_id", referencedColumnName = "m_attributesetinstance_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MAttributesetinstance mAttributesetinstanceId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @JoinColumn(name = "ma_periodic_control_id", referencedColumnName = "ma_periodic_control_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaPeriodicControl maPeriodicControlId;

    public MaPcCase() {
    }

    public MaPcCase(String maPcCaseId) {
        this.maPcCaseId = maPcCaseId;
    }

    public MaPcCase(String maPcCaseId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Date startdate, Character launched) {
        this.maPcCaseId = maPcCaseId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.startdate = startdate;
        this.launched = launched;
    }

    public String getMaPcCaseId() {
        return maPcCaseId;
    }

    public void setMaPcCaseId(String maPcCaseId) {
        this.maPcCaseId = maPcCaseId;
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

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Character getLaunched() {
        return launched;
    }

    public void setLaunched(Character launched) {
        this.launched = launched;
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

    public MAttributesetinstance getMAttributesetinstanceId() {
        return mAttributesetinstanceId;
    }

    public void setMAttributesetinstanceId(MAttributesetinstance mAttributesetinstanceId) {
        this.mAttributesetinstanceId = mAttributesetinstanceId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
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
        hash += (maPcCaseId != null ? maPcCaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaPcCase)) {
            return false;
        }
        MaPcCase other = (MaPcCase) object;
        if ((this.maPcCaseId == null && other.maPcCaseId != null) || (this.maPcCaseId != null && !this.maPcCaseId.equals(other.maPcCaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaPcCase[ maPcCaseId=" + maPcCaseId + " ]";
    }
    
}
