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
@Table(name = "ad_org_closing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdOrgClosing.findAll", query = "SELECT a FROM AdOrgClosing a"),
    @NamedQuery(name = "AdOrgClosing.findByAdOrgClosingId", query = "SELECT a FROM AdOrgClosing a WHERE a.adOrgClosingId = :adOrgClosingId"),
    @NamedQuery(name = "AdOrgClosing.findByIsactive", query = "SELECT a FROM AdOrgClosing a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdOrgClosing.findByCreated", query = "SELECT a FROM AdOrgClosing a WHERE a.created = :created"),
    @NamedQuery(name = "AdOrgClosing.findByCreatedby", query = "SELECT a FROM AdOrgClosing a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdOrgClosing.findByUpdated", query = "SELECT a FROM AdOrgClosing a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdOrgClosing.findByUpdatedby", query = "SELECT a FROM AdOrgClosing a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdOrgClosing.findByRegFactAcctGroupId", query = "SELECT a FROM AdOrgClosing a WHERE a.regFactAcctGroupId = :regFactAcctGroupId"),
    @NamedQuery(name = "AdOrgClosing.findByCloseFactAcctGroupId", query = "SELECT a FROM AdOrgClosing a WHERE a.closeFactAcctGroupId = :closeFactAcctGroupId"),
    @NamedQuery(name = "AdOrgClosing.findByDivideupFactAcctGroupId", query = "SELECT a FROM AdOrgClosing a WHERE a.divideupFactAcctGroupId = :divideupFactAcctGroupId"),
    @NamedQuery(name = "AdOrgClosing.findByOpenFactAcctGroupId", query = "SELECT a FROM AdOrgClosing a WHERE a.openFactAcctGroupId = :openFactAcctGroupId")})
public class AdOrgClosing implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_org_closing_id")
    private String adOrgClosingId;
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
    @Size(max = 32)
    @Column(name = "reg_fact_acct_group_id")
    private String regFactAcctGroupId;
    @Size(max = 32)
    @Column(name = "close_fact_acct_group_id")
    private String closeFactAcctGroupId;
    @Size(max = 32)
    @Column(name = "divideup_fact_acct_group_id")
    private String divideupFactAcctGroupId;
    @Size(max = 32)
    @Column(name = "open_fact_acct_group_id")
    private String openFactAcctGroupId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_org_acctschema_id", referencedColumnName = "ad_org_acctschema_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrgAcctschema adOrgAcctschemaId;
    @JoinColumn(name = "c_year_id", referencedColumnName = "c_year_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CYear cYearId;

    public AdOrgClosing() {
    }

    public AdOrgClosing(String adOrgClosingId) {
        this.adOrgClosingId = adOrgClosingId;
    }

    public AdOrgClosing(String adOrgClosingId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.adOrgClosingId = adOrgClosingId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAdOrgClosingId() {
        return adOrgClosingId;
    }

    public void setAdOrgClosingId(String adOrgClosingId) {
        this.adOrgClosingId = adOrgClosingId;
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

    public String getRegFactAcctGroupId() {
        return regFactAcctGroupId;
    }

    public void setRegFactAcctGroupId(String regFactAcctGroupId) {
        this.regFactAcctGroupId = regFactAcctGroupId;
    }

    public String getCloseFactAcctGroupId() {
        return closeFactAcctGroupId;
    }

    public void setCloseFactAcctGroupId(String closeFactAcctGroupId) {
        this.closeFactAcctGroupId = closeFactAcctGroupId;
    }

    public String getDivideupFactAcctGroupId() {
        return divideupFactAcctGroupId;
    }

    public void setDivideupFactAcctGroupId(String divideupFactAcctGroupId) {
        this.divideupFactAcctGroupId = divideupFactAcctGroupId;
    }

    public String getOpenFactAcctGroupId() {
        return openFactAcctGroupId;
    }

    public void setOpenFactAcctGroupId(String openFactAcctGroupId) {
        this.openFactAcctGroupId = openFactAcctGroupId;
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

    public AdOrgAcctschema getAdOrgAcctschemaId() {
        return adOrgAcctschemaId;
    }

    public void setAdOrgAcctschemaId(AdOrgAcctschema adOrgAcctschemaId) {
        this.adOrgAcctschemaId = adOrgAcctschemaId;
    }

    public CYear getCYearId() {
        return cYearId;
    }

    public void setCYearId(CYear cYearId) {
        this.cYearId = cYearId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adOrgClosingId != null ? adOrgClosingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdOrgClosing)) {
            return false;
        }
        AdOrgClosing other = (AdOrgClosing) object;
        if ((this.adOrgClosingId == null && other.adOrgClosingId != null) || (this.adOrgClosingId != null && !this.adOrgClosingId.equals(other.adOrgClosingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdOrgClosing[ adOrgClosingId=" + adOrgClosingId + " ]";
    }
    
}
