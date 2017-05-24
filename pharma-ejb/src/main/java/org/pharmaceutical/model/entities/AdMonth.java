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
import javax.persistence.CascadeType;
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
@Table(name = "ad_month")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdMonth.findAll", query = "SELECT a FROM AdMonth a"),
    @NamedQuery(name = "AdMonth.findByAdMonthId", query = "SELECT a FROM AdMonth a WHERE a.adMonthId = :adMonthId"),
    @NamedQuery(name = "AdMonth.findByIsactive", query = "SELECT a FROM AdMonth a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdMonth.findByCreated", query = "SELECT a FROM AdMonth a WHERE a.created = :created"),
    @NamedQuery(name = "AdMonth.findByCreatedby", query = "SELECT a FROM AdMonth a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdMonth.findByUpdated", query = "SELECT a FROM AdMonth a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdMonth.findByUpdatedby", query = "SELECT a FROM AdMonth a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdMonth.findByValue", query = "SELECT a FROM AdMonth a WHERE a.value = :value"),
    @NamedQuery(name = "AdMonth.findByName", query = "SELECT a FROM AdMonth a WHERE a.name = :name"),
    @NamedQuery(name = "AdMonth.findByQuarter", query = "SELECT a FROM AdMonth a WHERE a.quarter = :quarter")})
public class AdMonth implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_month_id")
    private String adMonthId;
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
    @Size(min = 1, max = 40)
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "quarter")
    private String quarter;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adMonthId")
    private List<AdMonthTrl> adMonthTrlList;

    public AdMonth() {
    }

    public AdMonth(String adMonthId) {
        this.adMonthId = adMonthId;
    }

    public AdMonth(String adMonthId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name, String quarter) {
        this.adMonthId = adMonthId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
        this.quarter = quarter;
    }

    public String getAdMonthId() {
        return adMonthId;
    }

    public void setAdMonthId(String adMonthId) {
        this.adMonthId = adMonthId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
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
    public List<AdMonthTrl> getAdMonthTrlList() {
        return adMonthTrlList;
    }

    public void setAdMonthTrlList(List<AdMonthTrl> adMonthTrlList) {
        this.adMonthTrlList = adMonthTrlList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adMonthId != null ? adMonthId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdMonth)) {
            return false;
        }
        AdMonth other = (AdMonth) object;
        if ((this.adMonthId == null && other.adMonthId != null) || (this.adMonthId != null && !this.adMonthId.equals(other.adMonthId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdMonth[ adMonthId=" + adMonthId + " ]";
    }
    
}
