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
@Table(name = "ad_org_acctschema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdOrgAcctschema.findAll", query = "SELECT a FROM AdOrgAcctschema a"),
    @NamedQuery(name = "AdOrgAcctschema.findByAdOrgAcctschemaId", query = "SELECT a FROM AdOrgAcctschema a WHERE a.adOrgAcctschemaId = :adOrgAcctschemaId"),
    @NamedQuery(name = "AdOrgAcctschema.findByIsactive", query = "SELECT a FROM AdOrgAcctschema a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdOrgAcctschema.findByCreated", query = "SELECT a FROM AdOrgAcctschema a WHERE a.created = :created"),
    @NamedQuery(name = "AdOrgAcctschema.findByCreatedby", query = "SELECT a FROM AdOrgAcctschema a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdOrgAcctschema.findByUpdated", query = "SELECT a FROM AdOrgAcctschema a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdOrgAcctschema.findByUpdatedby", query = "SELECT a FROM AdOrgAcctschema a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdOrgAcctschema.findByIsbpnewaccount", query = "SELECT a FROM AdOrgAcctschema a WHERE a.isbpnewaccount = :isbpnewaccount"),
    @NamedQuery(name = "AdOrgAcctschema.findByIsprnewaccount", query = "SELECT a FROM AdOrgAcctschema a WHERE a.isprnewaccount = :isprnewaccount"),
    @NamedQuery(name = "AdOrgAcctschema.findByAcctLength", query = "SELECT a FROM AdOrgAcctschema a WHERE a.acctLength = :acctLength"),
    @NamedQuery(name = "AdOrgAcctschema.findBySubacctLength", query = "SELECT a FROM AdOrgAcctschema a WHERE a.subacctLength = :subacctLength")})
public class AdOrgAcctschema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_org_acctschema_id")
    private String adOrgAcctschemaId;
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
    @Column(name = "isbpnewaccount")
    private Character isbpnewaccount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isprnewaccount")
    private Character isprnewaccount;
    @Column(name = "acct_length")
    private Long acctLength;
    @Column(name = "subacct_length")
    private Long subacctLength;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_sequence_pr_id", referencedColumnName = "ad_sequence_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdSequence adSequencePrId;
    @JoinColumn(name = "ad_sequence_bp_id", referencedColumnName = "ad_sequence_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdSequence adSequenceBpId;
    @JoinColumn(name = "c_acctschema_id", referencedColumnName = "c_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschema cAcctschemaId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adOrgAcctschemaId")
    private List<AdOrgClosing> adOrgClosingList;

    public AdOrgAcctschema() {
    }

    public AdOrgAcctschema(String adOrgAcctschemaId) {
        this.adOrgAcctschemaId = adOrgAcctschemaId;
    }

    public AdOrgAcctschema(String adOrgAcctschemaId, Character isactive, Date created, String createdby, Date updated, String updatedby, Character isbpnewaccount, Character isprnewaccount) {
        this.adOrgAcctschemaId = adOrgAcctschemaId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isbpnewaccount = isbpnewaccount;
        this.isprnewaccount = isprnewaccount;
    }

    public String getAdOrgAcctschemaId() {
        return adOrgAcctschemaId;
    }

    public void setAdOrgAcctschemaId(String adOrgAcctschemaId) {
        this.adOrgAcctschemaId = adOrgAcctschemaId;
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

    public Character getIsbpnewaccount() {
        return isbpnewaccount;
    }

    public void setIsbpnewaccount(Character isbpnewaccount) {
        this.isbpnewaccount = isbpnewaccount;
    }

    public Character getIsprnewaccount() {
        return isprnewaccount;
    }

    public void setIsprnewaccount(Character isprnewaccount) {
        this.isprnewaccount = isprnewaccount;
    }

    public Long getAcctLength() {
        return acctLength;
    }

    public void setAcctLength(Long acctLength) {
        this.acctLength = acctLength;
    }

    public Long getSubacctLength() {
        return subacctLength;
    }

    public void setSubacctLength(Long subacctLength) {
        this.subacctLength = subacctLength;
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

    public AdSequence getAdSequencePrId() {
        return adSequencePrId;
    }

    public void setAdSequencePrId(AdSequence adSequencePrId) {
        this.adSequencePrId = adSequencePrId;
    }

    public AdSequence getAdSequenceBpId() {
        return adSequenceBpId;
    }

    public void setAdSequenceBpId(AdSequence adSequenceBpId) {
        this.adSequenceBpId = adSequenceBpId;
    }

    public CAcctschema getCAcctschemaId() {
        return cAcctschemaId;
    }

    public void setCAcctschemaId(CAcctschema cAcctschemaId) {
        this.cAcctschemaId = cAcctschemaId;
    }

    @XmlTransient
    public List<AdOrgClosing> getAdOrgClosingList() {
        return adOrgClosingList;
    }

    public void setAdOrgClosingList(List<AdOrgClosing> adOrgClosingList) {
        this.adOrgClosingList = adOrgClosingList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adOrgAcctschemaId != null ? adOrgAcctschemaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdOrgAcctschema)) {
            return false;
        }
        AdOrgAcctschema other = (AdOrgAcctschema) object;
        if ((this.adOrgAcctschemaId == null && other.adOrgAcctschemaId != null) || (this.adOrgAcctschemaId != null && !this.adOrgAcctschemaId.equals(other.adOrgAcctschemaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdOrgAcctschema[ adOrgAcctschemaId=" + adOrgAcctschemaId + " ]";
    }
    
}
