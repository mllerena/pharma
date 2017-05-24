/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
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
@Table(name = "ma_pc_value")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaPcValue.findAll", query = "SELECT m FROM MaPcValue m"),
    @NamedQuery(name = "MaPcValue.findByMaPcValueId", query = "SELECT m FROM MaPcValue m WHERE m.maPcValueId = :maPcValueId"),
    @NamedQuery(name = "MaPcValue.findByIsactive", query = "SELECT m FROM MaPcValue m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaPcValue.findByCreated", query = "SELECT m FROM MaPcValue m WHERE m.created = :created"),
    @NamedQuery(name = "MaPcValue.findByCreatedby", query = "SELECT m FROM MaPcValue m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaPcValue.findByUpdated", query = "SELECT m FROM MaPcValue m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaPcValue.findByUpdatedby", query = "SELECT m FROM MaPcValue m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaPcValue.findByDatadate", query = "SELECT m FROM MaPcValue m WHERE m.datadate = :datadate"),
    @NamedQuery(name = "MaPcValue.findByTestresult", query = "SELECT m FROM MaPcValue m WHERE m.testresult = :testresult")})
public class MaPcValue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_pc_value_id")
    private String maPcValueId;
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
    @Column(name = "datadate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datadate;
    @Size(max = 255)
    @Column(name = "testresult")
    private String testresult;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_pc_case_id", referencedColumnName = "ma_pc_case_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaPcCase maPcCaseId;
    @JoinColumn(name = "ma_pc_test_id", referencedColumnName = "ma_pc_test_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaPcTest maPcTestId;

    public MaPcValue() {
    }

    public MaPcValue(String maPcValueId) {
        this.maPcValueId = maPcValueId;
    }

    public MaPcValue(String maPcValueId, Character isactive, Date created, String createdby, Date updated, String updatedby, Date datadate) {
        this.maPcValueId = maPcValueId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.datadate = datadate;
    }

    public String getMaPcValueId() {
        return maPcValueId;
    }

    public void setMaPcValueId(String maPcValueId) {
        this.maPcValueId = maPcValueId;
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

    public Date getDatadate() {
        return datadate;
    }

    public void setDatadate(Date datadate) {
        this.datadate = datadate;
    }

    public String getTestresult() {
        return testresult;
    }

    public void setTestresult(String testresult) {
        this.testresult = testresult;
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

    public MaPcCase getMaPcCaseId() {
        return maPcCaseId;
    }

    public void setMaPcCaseId(MaPcCase maPcCaseId) {
        this.maPcCaseId = maPcCaseId;
    }

    public MaPcTest getMaPcTestId() {
        return maPcTestId;
    }

    public void setMaPcTestId(MaPcTest maPcTestId) {
        this.maPcTestId = maPcTestId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maPcValueId != null ? maPcValueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaPcValue)) {
            return false;
        }
        MaPcValue other = (MaPcValue) object;
        if ((this.maPcValueId == null && other.maPcValueId != null) || (this.maPcValueId != null && !this.maPcValueId.equals(other.maPcValueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaPcValue[ maPcValueId=" + maPcValueId + " ]";
    }
    
}
