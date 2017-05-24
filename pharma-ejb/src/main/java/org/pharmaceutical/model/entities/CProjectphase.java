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
@Table(name = "c_projectphase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CProjectphase.findAll", query = "SELECT c FROM CProjectphase c"),
    @NamedQuery(name = "CProjectphase.findByIsactive", query = "SELECT c FROM CProjectphase c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CProjectphase.findByCreated", query = "SELECT c FROM CProjectphase c WHERE c.created = :created"),
    @NamedQuery(name = "CProjectphase.findByCreatedby", query = "SELECT c FROM CProjectphase c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CProjectphase.findByUpdated", query = "SELECT c FROM CProjectphase c WHERE c.updated = :updated"),
    @NamedQuery(name = "CProjectphase.findByUpdatedby", query = "SELECT c FROM CProjectphase c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CProjectphase.findByDescription", query = "SELECT c FROM CProjectphase c WHERE c.description = :description"),
    @NamedQuery(name = "CProjectphase.findByStartdate", query = "SELECT c FROM CProjectphase c WHERE c.startdate = :startdate"),
    @NamedQuery(name = "CProjectphase.findByEnddate", query = "SELECT c FROM CProjectphase c WHERE c.enddate = :enddate"),
    @NamedQuery(name = "CProjectphase.findByIscomplete", query = "SELECT c FROM CProjectphase c WHERE c.iscomplete = :iscomplete"),
    @NamedQuery(name = "CProjectphase.findByPriceactual", query = "SELECT c FROM CProjectphase c WHERE c.priceactual = :priceactual"),
    @NamedQuery(name = "CProjectphase.findByGenerateorder", query = "SELECT c FROM CProjectphase c WHERE c.generateorder = :generateorder"),
    @NamedQuery(name = "CProjectphase.findByCProjectphaseId", query = "SELECT c FROM CProjectphase c WHERE c.cProjectphaseId = :cProjectphaseId"),
    @NamedQuery(name = "CProjectphase.findByHelp", query = "SELECT c FROM CProjectphase c WHERE c.help = :help"),
    @NamedQuery(name = "CProjectphase.findByName", query = "SELECT c FROM CProjectphase c WHERE c.name = :name"),
    @NamedQuery(name = "CProjectphase.findByQty", query = "SELECT c FROM CProjectphase c WHERE c.qty = :qty"),
    @NamedQuery(name = "CProjectphase.findBySeqno", query = "SELECT c FROM CProjectphase c WHERE c.seqno = :seqno"),
    @NamedQuery(name = "CProjectphase.findByCommittedamt", query = "SELECT c FROM CProjectphase c WHERE c.committedamt = :committedamt"),
    @NamedQuery(name = "CProjectphase.findByIscommitceiling", query = "SELECT c FROM CProjectphase c WHERE c.iscommitceiling = :iscommitceiling"),
    @NamedQuery(name = "CProjectphase.findByDatecontract", query = "SELECT c FROM CProjectphase c WHERE c.datecontract = :datecontract")})
public class CProjectphase implements Serializable {
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
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
    @Column(name = "generateorder")
    private Character generateorder;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_projectphase_id")
    private String cProjectphaseId;
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Column(name = "qty")
    private BigInteger qty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqno")
    private long seqno;
    @Column(name = "committedamt")
    private BigInteger committedamt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iscommitceiling")
    private Character iscommitceiling;
    @Column(name = "datecontract")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecontract;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_order_id", referencedColumnName = "c_order_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private COrder cOrderId;
    @JoinColumn(name = "c_phase_id", referencedColumnName = "c_phase_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPhase cPhaseId;
    @JoinColumn(name = "c_project_id", referencedColumnName = "c_project_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CProject cProjectId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private MProduct mProductId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectphaseId")
    private List<STimeexpenseline> sTimeexpenselineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cProjectphaseId")
    private List<CProjecttask> cProjecttaskList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cProjectphaseId")
    private List<CProject> cProjectList;

    public CProjectphase() {
    }

    public CProjectphase(String cProjectphaseId) {
        this.cProjectphaseId = cProjectphaseId;
    }

    public CProjectphase(String cProjectphaseId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character iscomplete, String name, long seqno, Character iscommitceiling) {
        this.cProjectphaseId = cProjectphaseId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.iscomplete = iscomplete;
        this.name = name;
        this.seqno = seqno;
        this.iscommitceiling = iscommitceiling;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Character getGenerateorder() {
        return generateorder;
    }

    public void setGenerateorder(Character generateorder) {
        this.generateorder = generateorder;
    }

    public String getCProjectphaseId() {
        return cProjectphaseId;
    }

    public void setCProjectphaseId(String cProjectphaseId) {
        this.cProjectphaseId = cProjectphaseId;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getQty() {
        return qty;
    }

    public void setQty(BigInteger qty) {
        this.qty = qty;
    }

    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
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

    public COrder getCOrderId() {
        return cOrderId;
    }

    public void setCOrderId(COrder cOrderId) {
        this.cOrderId = cOrderId;
    }

    public CPhase getCPhaseId() {
        return cPhaseId;
    }

    public void setCPhaseId(CPhase cPhaseId) {
        this.cPhaseId = cPhaseId;
    }

    public CProject getCProjectId() {
        return cProjectId;
    }

    public void setCProjectId(CProject cProjectId) {
        this.cProjectId = cProjectId;
    }

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @XmlTransient
    public List<STimeexpenseline> getSTimeexpenselineList() {
        return sTimeexpenselineList;
    }

    public void setSTimeexpenselineList(List<STimeexpenseline> sTimeexpenselineList) {
        this.sTimeexpenselineList = sTimeexpenselineList;
    }

    @XmlTransient
    public List<CProjecttask> getCProjecttaskList() {
        return cProjecttaskList;
    }

    public void setCProjecttaskList(List<CProjecttask> cProjecttaskList) {
        this.cProjecttaskList = cProjecttaskList;
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
        hash += (cProjectphaseId != null ? cProjectphaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CProjectphase)) {
            return false;
        }
        CProjectphase other = (CProjectphase) object;
        if ((this.cProjectphaseId == null && other.cProjectphaseId != null) || (this.cProjectphaseId != null && !this.cProjectphaseId.equals(other.cProjectphaseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CProjectphase[ cProjectphaseId=" + cProjectphaseId + " ]";
    }
    
}
