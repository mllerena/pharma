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
@Table(name = "c_acctschema_process")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CAcctschemaProcess.findAll", query = "SELECT c FROM CAcctschemaProcess c"),
    @NamedQuery(name = "CAcctschemaProcess.findByCAcctschemaProcessId", query = "SELECT c FROM CAcctschemaProcess c WHERE c.cAcctschemaProcessId = :cAcctschemaProcessId"),
    @NamedQuery(name = "CAcctschemaProcess.findByIsactive", query = "SELECT c FROM CAcctschemaProcess c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CAcctschemaProcess.findByCreated", query = "SELECT c FROM CAcctschemaProcess c WHERE c.created = :created"),
    @NamedQuery(name = "CAcctschemaProcess.findByCreatedby", query = "SELECT c FROM CAcctschemaProcess c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CAcctschemaProcess.findByUpdated", query = "SELECT c FROM CAcctschemaProcess c WHERE c.updated = :updated"),
    @NamedQuery(name = "CAcctschemaProcess.findByUpdatedby", query = "SELECT c FROM CAcctschemaProcess c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CAcctschemaProcess.findBySeqno", query = "SELECT c FROM CAcctschemaProcess c WHERE c.seqno = :seqno"),
    @NamedQuery(name = "CAcctschemaProcess.findByIsdataset", query = "SELECT c FROM CAcctschemaProcess c WHERE c.isdataset = :isdataset")})
public class CAcctschemaProcess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_acctschema_process_id")
    private String cAcctschemaProcessId;
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
    @Column(name = "seqno")
    private long seqno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isdataset")
    private Character isdataset;
    @JoinColumn(name = "ad_acctprocess_id", referencedColumnName = "ad_acctprocess_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdAcctprocess adAcctprocessId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CAcctschema cAcctschemaId;

    public CAcctschemaProcess() {
    }

    public CAcctschemaProcess(String cAcctschemaProcessId) {
        this.cAcctschemaProcessId = cAcctschemaProcessId;
    }

    public CAcctschemaProcess(String cAcctschemaProcessId, Character isactive, Date created, String createdby, Date updated, String updatedby, long seqno, Character isdataset) {
        this.cAcctschemaProcessId = cAcctschemaProcessId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.seqno = seqno;
        this.isdataset = isdataset;
    }

    public String getCAcctschemaProcessId() {
        return cAcctschemaProcessId;
    }

    public void setCAcctschemaProcessId(String cAcctschemaProcessId) {
        this.cAcctschemaProcessId = cAcctschemaProcessId;
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

    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
    }

    public Character getIsdataset() {
        return isdataset;
    }

    public void setIsdataset(Character isdataset) {
        this.isdataset = isdataset;
    }

    public AdAcctprocess getAdAcctprocessId() {
        return adAcctprocessId;
    }

    public void setAdAcctprocessId(AdAcctprocess adAcctprocessId) {
        this.adAcctprocessId = adAcctprocessId;
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

    public CAcctschema getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(CAcctschema cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cAcctschemaProcessId != null ? cAcctschemaProcessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CAcctschemaProcess)) {
            return false;
        }
        CAcctschemaProcess other = (CAcctschemaProcess) object;
        if ((this.cAcctschemaProcessId == null && other.cAcctschemaProcessId != null) || (this.cAcctschemaProcessId != null && !this.cAcctschemaProcessId.equals(other.cAcctschemaProcessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CAcctschemaProcess[ cAcctschemaProcessId=" + cAcctschemaProcessId + " ]";
    }
    
}
