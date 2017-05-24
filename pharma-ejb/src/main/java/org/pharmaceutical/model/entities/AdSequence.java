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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "ad_sequence")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdSequence.findAll", query = "SELECT a FROM AdSequence a"),
    @NamedQuery(name = "AdSequence.findByAdSequenceId", query = "SELECT a FROM AdSequence a WHERE a.adSequenceId = :adSequenceId"),
    @NamedQuery(name = "AdSequence.findByIsactive", query = "SELECT a FROM AdSequence a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdSequence.findByCreated", query = "SELECT a FROM AdSequence a WHERE a.created = :created"),
    @NamedQuery(name = "AdSequence.findByCreatedby", query = "SELECT a FROM AdSequence a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdSequence.findByUpdated", query = "SELECT a FROM AdSequence a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdSequence.findByUpdatedby", query = "SELECT a FROM AdSequence a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdSequence.findByName", query = "SELECT a FROM AdSequence a WHERE a.name = :name"),
    @NamedQuery(name = "AdSequence.findByDescription", query = "SELECT a FROM AdSequence a WHERE a.description = :description"),
    @NamedQuery(name = "AdSequence.findByVformat", query = "SELECT a FROM AdSequence a WHERE a.vformat = :vformat"),
    @NamedQuery(name = "AdSequence.findByIsautosequence", query = "SELECT a FROM AdSequence a WHERE a.isautosequence = :isautosequence"),
    @NamedQuery(name = "AdSequence.findByIncrementno", query = "SELECT a FROM AdSequence a WHERE a.incrementno = :incrementno"),
    @NamedQuery(name = "AdSequence.findByStartno", query = "SELECT a FROM AdSequence a WHERE a.startno = :startno"),
    @NamedQuery(name = "AdSequence.findByCurrentnext", query = "SELECT a FROM AdSequence a WHERE a.currentnext = :currentnext"),
    @NamedQuery(name = "AdSequence.findByCurrentnextsys", query = "SELECT a FROM AdSequence a WHERE a.currentnextsys = :currentnextsys"),
    @NamedQuery(name = "AdSequence.findByIstableid", query = "SELECT a FROM AdSequence a WHERE a.istableid = :istableid"),
    @NamedQuery(name = "AdSequence.findByPrefix", query = "SELECT a FROM AdSequence a WHERE a.prefix = :prefix"),
    @NamedQuery(name = "AdSequence.findBySuffix", query = "SELECT a FROM AdSequence a WHERE a.suffix = :suffix"),
    @NamedQuery(name = "AdSequence.findByStartnewyear", query = "SELECT a FROM AdSequence a WHERE a.startnewyear = :startnewyear")})
public class AdSequence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_sequence_id")
    private String adSequenceId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 40)
    @Column(name = "vformat")
    private String vformat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isautosequence")
    private Character isautosequence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "incrementno")
    private long incrementno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startno")
    private long startno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currentnext")
    private long currentnext;
    @Basic(optional = false)
    @NotNull
    @Column(name = "currentnextsys")
    private long currentnextsys;
    @Column(name = "istableid")
    private Character istableid;
    @Size(max = 10)
    @Column(name = "prefix")
    private String prefix;
    @Size(max = 10)
    @Column(name = "suffix")
    private String suffix;
    @Column(name = "startnewyear")
    private Character startnewyear;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "docnosequenceId")
    private List<CDoctype> cDoctypeList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adSequencePrId")
    private List<AdOrgAcctschema> adOrgAcctschemaList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adSequenceBpId")
    private List<AdOrgAcctschema> adOrgAcctschemaList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adSequenceId")
    private List<CTaxregisterType> cTaxregisterTypeList;

    public AdSequence() {
    }

    public AdSequence(String adSequenceId) {
        this.adSequenceId = adSequenceId;
    }

    public AdSequence(String adSequenceId, Date created, String createdby, Date updated, String updatedby, String name, Character isautosequence, long incrementno, long startno, long currentnext, long currentnextsys) {
        this.adSequenceId = adSequenceId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.isautosequence = isautosequence;
        this.incrementno = incrementno;
        this.startno = startno;
        this.currentnext = currentnext;
        this.currentnextsys = currentnextsys;
    }

    public String getAdSequenceId() {
        return adSequenceId;
    }

    public void setAdSequenceId(String adSequenceId) {
        this.adSequenceId = adSequenceId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVformat() {
        return vformat;
    }

    public void setVformat(String vformat) {
        this.vformat = vformat;
    }

    public Character getIsautosequence() {
        return isautosequence;
    }

    public void setIsautosequence(Character isautosequence) {
        this.isautosequence = isautosequence;
    }

    public long getIncrementno() {
        return incrementno;
    }

    public void setIncrementno(long incrementno) {
        this.incrementno = incrementno;
    }

    public long getStartno() {
        return startno;
    }

    public void setStartno(long startno) {
        this.startno = startno;
    }

    public long getCurrentnext() {
        return currentnext;
    }

    public void setCurrentnext(long currentnext) {
        this.currentnext = currentnext;
    }

    public long getCurrentnextsys() {
        return currentnextsys;
    }

    public void setCurrentnextsys(long currentnextsys) {
        this.currentnextsys = currentnextsys;
    }

    public Character getIstableid() {
        return istableid;
    }

    public void setIstableid(Character istableid) {
        this.istableid = istableid;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Character getStartnewyear() {
        return startnewyear;
    }

    public void setStartnewyear(Character startnewyear) {
        this.startnewyear = startnewyear;
    }

    @XmlTransient
    public List<CDoctype> getCDoctypeList() {
        return cDoctypeList;
    }

    public void setCDoctypeList(List<CDoctype> cDoctypeList) {
        this.cDoctypeList = cDoctypeList;
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
    public List<AdOrgAcctschema> getAdOrgAcctschemaList() {
        return adOrgAcctschemaList;
    }

    public void setAdOrgAcctschemaList(List<AdOrgAcctschema> adOrgAcctschemaList) {
        this.adOrgAcctschemaList = adOrgAcctschemaList;
    }

    @XmlTransient
    public List<AdOrgAcctschema> getAdOrgAcctschemaList1() {
        return adOrgAcctschemaList1;
    }

    public void setAdOrgAcctschemaList1(List<AdOrgAcctschema> adOrgAcctschemaList1) {
        this.adOrgAcctschemaList1 = adOrgAcctschemaList1;
    }

    @XmlTransient
    public List<CTaxregisterType> getCTaxregisterTypeList() {
        return cTaxregisterTypeList;
    }

    public void setCTaxregisterTypeList(List<CTaxregisterType> cTaxregisterTypeList) {
        this.cTaxregisterTypeList = cTaxregisterTypeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adSequenceId != null ? adSequenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdSequence)) {
            return false;
        }
        AdSequence other = (AdSequence) object;
        if ((this.adSequenceId == null && other.adSequenceId != null) || (this.adSequenceId != null && !this.adSequenceId.equals(other.adSequenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdSequence[ adSequenceId=" + adSequenceId + " ]";
    }
    
}
