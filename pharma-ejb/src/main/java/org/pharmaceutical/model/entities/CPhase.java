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
@Table(name = "c_phase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CPhase.findAll", query = "SELECT c FROM CPhase c"),
    @NamedQuery(name = "CPhase.findByIsactive", query = "SELECT c FROM CPhase c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CPhase.findByCreated", query = "SELECT c FROM CPhase c WHERE c.created = :created"),
    @NamedQuery(name = "CPhase.findByCreatedby", query = "SELECT c FROM CPhase c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CPhase.findByUpdated", query = "SELECT c FROM CPhase c WHERE c.updated = :updated"),
    @NamedQuery(name = "CPhase.findByUpdatedby", query = "SELECT c FROM CPhase c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CPhase.findBySeqno", query = "SELECT c FROM CPhase c WHERE c.seqno = :seqno"),
    @NamedQuery(name = "CPhase.findByName", query = "SELECT c FROM CPhase c WHERE c.name = :name"),
    @NamedQuery(name = "CPhase.findByDescription", query = "SELECT c FROM CPhase c WHERE c.description = :description"),
    @NamedQuery(name = "CPhase.findByHelp", query = "SELECT c FROM CPhase c WHERE c.help = :help"),
    @NamedQuery(name = "CPhase.findByStandardqty", query = "SELECT c FROM CPhase c WHERE c.standardqty = :standardqty"),
    @NamedQuery(name = "CPhase.findByCPhaseId", query = "SELECT c FROM CPhase c WHERE c.cPhaseId = :cPhaseId"),
    @NamedQuery(name = "CPhase.findByStdduration", query = "SELECT c FROM CPhase c WHERE c.stdduration = :stdduration")})
public class CPhase implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_phase_id")
    private String cPhaseId;
    @Column(name = "stdduration")
    private Long stdduration;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPhaseId")
    private List<CProjectphase> cProjectphaseList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cPhaseId")
    private List<CTask> cTaskList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_projecttype_id", referencedColumnName = "c_projecttype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CProjecttype cProjecttypeId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPhaseId")
    private List<CProject> cProjectList;

    public CPhase() {
    }

    public CPhase(String cPhaseId) {
        this.cPhaseId = cPhaseId;
    }

    public CPhase(String cPhaseId, Character isactive, Date created, String createdby, Date updated, String updatedby, long seqno, String name, BigInteger standardqty) {
        this.cPhaseId = cPhaseId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.seqno = seqno;
        this.name = name;
        this.standardqty = standardqty;
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

    public String getCPhaseId() {
        return cPhaseId;
    }

    public void setCPhaseId(String cPhaseId) {
        this.cPhaseId = cPhaseId;
    }

    public Long getStdduration() {
        return stdduration;
    }

    public void setStdduration(Long stdduration) {
        this.stdduration = stdduration;
    }

    @XmlTransient
    public List<CProjectphase> getCProjectphaseList() {
        return cProjectphaseList;
    }

    public void setCProjectphaseList(List<CProjectphase> cProjectphaseList) {
        this.cProjectphaseList = cProjectphaseList;
    }

    @XmlTransient
    public List<CTask> getCTaskList() {
        return cTaskList;
    }

    public void setCTaskList(List<CTask> cTaskList) {
        this.cTaskList = cTaskList;
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

    public CProjecttype getCProjecttypeId() {
        return cProjecttypeId;
    }

    public void setCProjecttypeId(CProjecttype cProjecttypeId) {
        this.cProjecttypeId = cProjecttypeId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @XmlTransient
    public List<CProject> getCProjectList() {
        return cProjectList;
    }

    public void setCProjectList(List<CProject> cProjectList) {
        this.cProjectList = cProjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cPhaseId != null ? cPhaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CPhase)) {
            return false;
        }
        CPhase other = (CPhase) object;
        if ((this.cPhaseId == null && other.cPhaseId != null) || (this.cPhaseId != null && !this.cPhaseId.equals(other.cPhaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CPhase[ cPhaseId=" + cPhaseId + " ]";
    }
    
}
