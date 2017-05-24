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
@Table(name = "c_projecttask")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CProjecttask.findAll", query = "SELECT c FROM CProjecttask c"),
    @NamedQuery(name = "CProjecttask.findByCProjecttaskId", query = "SELECT c FROM CProjecttask c WHERE c.cProjecttaskId = :cProjecttaskId"),
    @NamedQuery(name = "CProjecttask.findByIsactive", query = "SELECT c FROM CProjecttask c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CProjecttask.findByCreated", query = "SELECT c FROM CProjecttask c WHERE c.created = :created"),
    @NamedQuery(name = "CProjecttask.findByCreatedby", query = "SELECT c FROM CProjecttask c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CProjecttask.findByUpdated", query = "SELECT c FROM CProjecttask c WHERE c.updated = :updated"),
    @NamedQuery(name = "CProjecttask.findByUpdatedby", query = "SELECT c FROM CProjecttask c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CProjecttask.findBySeqno", query = "SELECT c FROM CProjecttask c WHERE c.seqno = :seqno"),
    @NamedQuery(name = "CProjecttask.findByName", query = "SELECT c FROM CProjecttask c WHERE c.name = :name"),
    @NamedQuery(name = "CProjecttask.findByDescription", query = "SELECT c FROM CProjecttask c WHERE c.description = :description"),
    @NamedQuery(name = "CProjecttask.findByHelp", query = "SELECT c FROM CProjecttask c WHERE c.help = :help"),
    @NamedQuery(name = "CProjecttask.findByQty", query = "SELECT c FROM CProjecttask c WHERE c.qty = :qty"),
    @NamedQuery(name = "CProjecttask.findByStartdate", query = "SELECT c FROM CProjecttask c WHERE c.startdate = :startdate"),
    @NamedQuery(name = "CProjecttask.findByEnddate", query = "SELECT c FROM CProjecttask c WHERE c.enddate = :enddate"),
    @NamedQuery(name = "CProjecttask.findByIscomplete", query = "SELECT c FROM CProjecttask c WHERE c.iscomplete = :iscomplete"),
    @NamedQuery(name = "CProjecttask.findByPriceactual", query = "SELECT c FROM CProjecttask c WHERE c.priceactual = :priceactual"),
    @NamedQuery(name = "CProjecttask.findByCommittedamt", query = "SELECT c FROM CProjecttask c WHERE c.committedamt = :committedamt"),
    @NamedQuery(name = "CProjecttask.findByIscommitceiling", query = "SELECT c FROM CProjecttask c WHERE c.iscommitceiling = :iscommitceiling"),
    @NamedQuery(name = "CProjecttask.findByDatecontract", query = "SELECT c FROM CProjecttask c WHERE c.datecontract = :datecontract")})
public class CProjecttask implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_projecttask_id")
    private String cProjecttaskId;
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
    @Column(name = "qty")
    private BigInteger qty;
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iscomplete")
    private Character iscomplete;
    @Column(name = "priceactual")
    private BigInteger priceactual;
    @Column(name = "committedamt")
    private BigInteger committedamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iscommitceiling")
    private Character iscommitceiling;
    @Column(name = "datecontract")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecontract;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjecttaskId")
    private List<STimeexpenseline> sTimeexpenselineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_projectphase_id", referencedColumnName = "c_projectphase_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CProjectphase cProjectphaseId;
    @JoinColumn(name = "c_task_id", referencedColumnName = "c_task_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTask cTaskId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;

    public CProjecttask() {
    }

    public CProjecttask(String cProjecttaskId) {
        this.cProjecttaskId = cProjecttaskId;
    }

    public CProjecttask(String cProjecttaskId, Character isactive, Date created, String createdby, Date updated, String updatedby, long seqno, String name, Character iscomplete, Character iscommitceiling) {
        this.cProjecttaskId = cProjecttaskId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.seqno = seqno;
        this.name = name;
        this.iscomplete = iscomplete;
        this.iscommitceiling = iscommitceiling;
    }

    public String getCProjecttaskId() {
        return cProjecttaskId;
    }

    public void setCProjecttaskId(String cProjecttaskId) {
        this.cProjecttaskId = cProjecttaskId;
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

    public BigInteger getQty() {
        return qty;
    }

    public void setQty(BigInteger qty) {
        this.qty = qty;
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

    public Character getIscomplete() {
        return iscomplete;
    }

    public void setIscomplete(Character iscomplete) {
        this.iscomplete = iscomplete;
    }

    public BigInteger getPriceactual() {
        return priceactual;
    }

    public void setPriceactual(BigInteger priceactual) {
        this.priceactual = priceactual;
    }

    public BigInteger getCommittedamt() {
        return committedamt;
    }

    public void setCommittedamt(BigInteger committedamt) {
        this.committedamt = committedamt;
    }

    public Character getIscommitceiling() {
        return iscommitceiling;
    }

    public void setIscommitceiling(Character iscommitceiling) {
        this.iscommitceiling = iscommitceiling;
    }

    public Date getDatecontract() {
        return datecontract;
    }

    public void setDatecontract(Date datecontract) {
        this.datecontract = datecontract;
    }

    @XmlTransient
    public List<STimeexpenseline> getSTimeexpenselineList() {
        return sTimeexpenselineList;
    }

    public void setSTimeexpenselineList(List<STimeexpenseline> sTimeexpenselineList) {
        this.sTimeexpenselineList = sTimeexpenselineList;
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

    public CProjectphase getCProjectphaseId() {
        return cProjectphaseId;
    }

    public void setCProjectphaseId(CProjectphase cProjectphaseId) {
        this.cProjectphaseId = cProjectphaseId;
    }

    public CTask getCTaskId() {
        return cTaskId;
    }

    public void setCTaskId(CTask cTaskId) {
        this.cTaskId = cTaskId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cProjecttaskId != null ? cProjecttaskId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProjecttask)) {
            return false;
        }
        CProjecttask other = (CProjecttask) object;
        if ((this.cProjecttaskId == null && other.cProjecttaskId != null) || (this.cProjecttaskId != null && !this.cProjecttaskId.equals(other.cProjecttaskId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CProjecttask[ cProjecttaskId=" + cProjecttaskId + " ]";
    }
    
}
