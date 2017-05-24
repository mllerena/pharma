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
@Table(name = "c_periodcontrol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CPeriodcontrol.findAll", query = "SELECT c FROM CPeriodcontrol c"),
    @NamedQuery(name = "CPeriodcontrol.findByCPeriodcontrolId", query = "SELECT c FROM CPeriodcontrol c WHERE c.cPeriodcontrolId = :cPeriodcontrolId"),
    @NamedQuery(name = "CPeriodcontrol.findByIsactive", query = "SELECT c FROM CPeriodcontrol c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CPeriodcontrol.findByCreated", query = "SELECT c FROM CPeriodcontrol c WHERE c.created = :created"),
    @NamedQuery(name = "CPeriodcontrol.findByCreatedby", query = "SELECT c FROM CPeriodcontrol c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CPeriodcontrol.findByUpdated", query = "SELECT c FROM CPeriodcontrol c WHERE c.updated = :updated"),
    @NamedQuery(name = "CPeriodcontrol.findByUpdatedby", query = "SELECT c FROM CPeriodcontrol c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CPeriodcontrol.findByDocbasetype", query = "SELECT c FROM CPeriodcontrol c WHERE c.docbasetype = :docbasetype"),
    @NamedQuery(name = "CPeriodcontrol.findByPeriodstatus", query = "SELECT c FROM CPeriodcontrol c WHERE c.periodstatus = :periodstatus"),
    @NamedQuery(name = "CPeriodcontrol.findByPeriodaction", query = "SELECT c FROM CPeriodcontrol c WHERE c.periodaction = :periodaction"),
    @NamedQuery(name = "CPeriodcontrol.findByProcessing", query = "SELECT c FROM CPeriodcontrol c WHERE c.processing = :processing")})
public class CPeriodcontrol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_periodcontrol_id")
    private String cPeriodcontrolId;
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
    @Column(name = "docbasetype")
    private String docbasetype;
    @Size(max = 60)
    @Column(name = "periodstatus")
    private String periodstatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "periodaction")
    private String periodaction;
    @Column(name = "processing")
    private Character processing;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_period_id", referencedColumnName = "c_period_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CPeriod cPeriodId;

    public CPeriodcontrol() {
    }

    public CPeriodcontrol(String cPeriodcontrolId) {
        this.cPeriodcontrolId = cPeriodcontrolId;
    }

    public CPeriodcontrol(String cPeriodcontrolId, Character isactive, Date created, String createdby, Date updated, String updatedby, String docbasetype, String periodaction) {
        this.cPeriodcontrolId = cPeriodcontrolId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.docbasetype = docbasetype;
        this.periodaction = periodaction;
    }

    public String getCPeriodcontrolId() {
        return cPeriodcontrolId;
    }

    public void setCPeriodcontrolId(String cPeriodcontrolId) {
        this.cPeriodcontrolId = cPeriodcontrolId;
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

    public String getDocbasetype() {
        return docbasetype;
    }

    public void setDocbasetype(String docbasetype) {
        this.docbasetype = docbasetype;
    }

    public String getPeriodstatus() {
        return periodstatus;
    }

    public void setPeriodstatus(String periodstatus) {
        this.periodstatus = periodstatus;
    }

    public String getPeriodaction() {
        return periodaction;
    }

    public void setPeriodaction(String periodaction) {
        this.periodaction = periodaction;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
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

    public CPeriod getCPeriodId() {
        return cPeriodId;
    }

    public void setCPeriodId(CPeriod cPeriodId) {
        this.cPeriodId = cPeriodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cPeriodcontrolId != null ? cPeriodcontrolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CPeriodcontrol)) {
            return false;
        }
        CPeriodcontrol other = (CPeriodcontrol) object;
        if ((this.cPeriodcontrolId == null && other.cPeriodcontrolId != null) || (this.cPeriodcontrolId != null && !this.cPeriodcontrolId.equals(other.cPeriodcontrolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CPeriodcontrol[ cPeriodcontrolId=" + cPeriodcontrolId + " ]";
    }
    
}
