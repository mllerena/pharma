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
@Table(name = "s_resourceassignment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SResourceassignment.findAll", query = "SELECT s FROM SResourceassignment s"),
    @NamedQuery(name = "SResourceassignment.findBySResourceassignmentId", query = "SELECT s FROM SResourceassignment s WHERE s.sResourceassignmentId = :sResourceassignmentId"),
    @NamedQuery(name = "SResourceassignment.findByIsactive", query = "SELECT s FROM SResourceassignment s WHERE s.isactive = :isactive"),
    @NamedQuery(name = "SResourceassignment.findByCreated", query = "SELECT s FROM SResourceassignment s WHERE s.created = :created"),
    @NamedQuery(name = "SResourceassignment.findByCreatedby", query = "SELECT s FROM SResourceassignment s WHERE s.createdby = :createdby"),
    @NamedQuery(name = "SResourceassignment.findByUpdated", query = "SELECT s FROM SResourceassignment s WHERE s.updated = :updated"),
    @NamedQuery(name = "SResourceassignment.findByUpdatedby", query = "SELECT s FROM SResourceassignment s WHERE s.updatedby = :updatedby"),
    @NamedQuery(name = "SResourceassignment.findByName", query = "SELECT s FROM SResourceassignment s WHERE s.name = :name"),
    @NamedQuery(name = "SResourceassignment.findByDescription", query = "SELECT s FROM SResourceassignment s WHERE s.description = :description"),
    @NamedQuery(name = "SResourceassignment.findByAssigndatefrom", query = "SELECT s FROM SResourceassignment s WHERE s.assigndatefrom = :assigndatefrom"),
    @NamedQuery(name = "SResourceassignment.findByAssigndateto", query = "SELECT s FROM SResourceassignment s WHERE s.assigndateto = :assigndateto"),
    @NamedQuery(name = "SResourceassignment.findByQty", query = "SELECT s FROM SResourceassignment s WHERE s.qty = :qty"),
    @NamedQuery(name = "SResourceassignment.findByIsconfirmed", query = "SELECT s FROM SResourceassignment s WHERE s.isconfirmed = :isconfirmed")})
public class SResourceassignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "s_resourceassignment_id")
    private String sResourceassignmentId;
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
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "assigndatefrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assigndatefrom;
    @Column(name = "assigndateto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assigndateto;
    @Column(name = "qty")
    private BigInteger qty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isconfirmed")
    private Character isconfirmed;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "sResourceassignmentId")
    private List<STimeexpenseline> sTimeexpenselineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "s_resource_id", referencedColumnName = "s_resource_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private SResource sResourceId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "sResourceassignmentId")
    private List<CInvoiceline> cInvoicelineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "sResourceassignmentId")
    private List<COrderline> cOrderlineList;

    public SResourceassignment() {
    }

    public SResourceassignment(String sResourceassignmentId) {
        this.sResourceassignmentId = sResourceassignmentId;
    }

    public SResourceassignment(String sResourceassignmentId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Date assigndatefrom, Character isconfirmed) {
        this.sResourceassignmentId = sResourceassignmentId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.assigndatefrom = assigndatefrom;
        this.isconfirmed = isconfirmed;
    }

    public String getSResourceassignmentId() {
        return sResourceassignmentId;
    }

    public void setSResourceassignmentId(String sResourceassignmentId) {
        this.sResourceassignmentId = sResourceassignmentId;
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

    public Date getAssigndatefrom() {
        return assigndatefrom;
    }

    public void setAssigndatefrom(Date assigndatefrom) {
        this.assigndatefrom = assigndatefrom;
    }

    public Date getAssigndateto() {
        return assigndateto;
    }

    public void setAssigndateto(Date assigndateto) {
        this.assigndateto = assigndateto;
    }

    public BigInteger getQty() {
        return qty;
    }

    public void setQty(BigInteger qty) {
        this.qty = qty;
    }

    public Character getIsconfirmed() {
        return isconfirmed;
    }

    public void setIsconfirmed(Character isconfirmed) {
        this.isconfirmed = isconfirmed;
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

    public SResource getSResourceId() {
        return sResourceId;
    }

    public void setSResourceId(SResource sResourceId) {
        this.sResourceId = sResourceId;
    }

    @XmlTransient
    public List<CInvoiceline> getCInvoicelineList() {
        return cInvoicelineList;
    }

    public void setCInvoicelineList(List<CInvoiceline> cInvoicelineList) {
        this.cInvoicelineList = cInvoicelineList;
    }

    @XmlTransient
    public List<COrderline> getCOrderlineList() {
        return cOrderlineList;
    }

    public void setCOrderlineList(List<COrderline> cOrderlineList) {
        this.cOrderlineList = cOrderlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sResourceassignmentId != null ? sResourceassignmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SResourceassignment)) {
            return false;
        }
        SResourceassignment other = (SResourceassignment) object;
        if ((this.sResourceassignmentId == null && other.sResourceassignmentId != null) || (this.sResourceassignmentId != null && !this.sResourceassignmentId.equals(other.sResourceassignmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.SResourceassignment[ sResourceassignmentId=" + sResourceassignmentId + " ]";
    }
    
}
