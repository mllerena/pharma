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
@Table(name = "c_task")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTask.findAll", query = "SELECT c FROM CTask c"),
    @NamedQuery(name = "CTask.findByCTaskId", query = "SELECT c FROM CTask c WHERE c.cTaskId = :cTaskId"),
    @NamedQuery(name = "CTask.findByIsactive", query = "SELECT c FROM CTask c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CTask.findByCreated", query = "SELECT c FROM CTask c WHERE c.created = :created"),
    @NamedQuery(name = "CTask.findByCreatedby", query = "SELECT c FROM CTask c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CTask.findByUpdated", query = "SELECT c FROM CTask c WHERE c.updated = :updated"),
    @NamedQuery(name = "CTask.findByUpdatedby", query = "SELECT c FROM CTask c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CTask.findBySeqno", query = "SELECT c FROM CTask c WHERE c.seqno = :seqno"),
    @NamedQuery(name = "CTask.findByName", query = "SELECT c FROM CTask c WHERE c.name = :name"),
    @NamedQuery(name = "CTask.findByDescription", query = "SELECT c FROM CTask c WHERE c.description = :description"),
    @NamedQuery(name = "CTask.findByHelp", query = "SELECT c FROM CTask c WHERE c.help = :help"),
    @NamedQuery(name = "CTask.findByStandardqty", query = "SELECT c FROM CTask c WHERE c.standardqty = :standardqty"),
    @NamedQuery(name = "CTask.findByStdduration", query = "SELECT c FROM CTask c WHERE c.stdduration = :stdduration")})
public class CTask implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_task_id")
    private String cTaskId;
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
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Basic(optional = false)
    @NotNull
    @Column(name = "standardqty")
    private BigInteger standardqty;
    @Column(name = "stdduration")
    private Long stdduration;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_phase_id", referencedColumnName = "c_phase_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CPhase cPhaseId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaskId")
    private List<CProjecttask> cProjecttaskList;

    public CTask() {
    }

    public CTask(String cTaskId) {
        this.cTaskId = cTaskId;
    }

    public CTask(String cTaskId, Character isactive, Date created, String createdby, Date updated, String updatedby, long seqno, String name, BigInteger standardqty) {
        this.cTaskId = cTaskId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.seqno = seqno;
        this.name = name;
        this.standardqty = standardqty;
    }

    public String getCTaskId() {
        return cTaskId;
    }

    public void setCTaskId(String cTaskId) {
        this.cTaskId = cTaskId;
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

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public BigInteger getStandardqty() {
        return standardqty;
    }

    public void setStandardqty(BigInteger standardqty) {
        this.standardqty = standardqty;
    }

    public Long getStdduration() {
        return stdduration;
    }

    public void setStdduration(Long stdduration) {
        this.stdduration = stdduration;
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

    public CPhase getCPhaseId() {
        return cPhaseId;
    }

    public void setCPhaseId(CPhase cPhaseId) {
        this.cPhaseId = cPhaseId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @XmlTransient
    public List<CProjecttask> getCProjecttaskList() {
        return cProjecttaskList;
    }

    public void setCProjecttaskList(List<CProjecttask> cProjecttaskList) {
        this.cProjecttaskList = cProjecttaskList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTaskId != null ? cTaskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTask)) {
            return false;
        }
        CTask other = (CTask) object;
        if ((this.cTaskId == null && other.cTaskId != null) || (this.cTaskId != null && !this.cTaskId.equals(other.cTaskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CTask[ cTaskId=" + cTaskId + " ]";
    }
    
}
