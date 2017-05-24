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
@Table(name = "c_incoterms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CIncoterms.findAll", query = "SELECT c FROM CIncoterms c"),
    @NamedQuery(name = "CIncoterms.findByCIncotermsId", query = "SELECT c FROM CIncoterms c WHERE c.cIncotermsId = :cIncotermsId"),
    @NamedQuery(name = "CIncoterms.findByIsactive", query = "SELECT c FROM CIncoterms c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CIncoterms.findByCreated", query = "SELECT c FROM CIncoterms c WHERE c.created = :created"),
    @NamedQuery(name = "CIncoterms.findByCreatedby", query = "SELECT c FROM CIncoterms c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CIncoterms.findByUpdated", query = "SELECT c FROM CIncoterms c WHERE c.updated = :updated"),
    @NamedQuery(name = "CIncoterms.findByUpdatedby", query = "SELECT c FROM CIncoterms c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CIncoterms.findByName", query = "SELECT c FROM CIncoterms c WHERE c.name = :name"),
    @NamedQuery(name = "CIncoterms.findByDescription", query = "SELECT c FROM CIncoterms c WHERE c.description = :description"),
    @NamedQuery(name = "CIncoterms.findByRequiresdescription", query = "SELECT c FROM CIncoterms c WHERE c.requiresdescription = :requiresdescription"),
    @NamedQuery(name = "CIncoterms.findByIsdelivery", query = "SELECT c FROM CIncoterms c WHERE c.isdelivery = :isdelivery")})
public class CIncoterms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_incoterms_id")
    private String cIncotermsId;
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
    @Column(name = "requiresdescription")
    private Character requiresdescription;
    @Column(name = "isdelivery")
    private Character isdelivery;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "soCIncotermsId")
    private List<CBpartner> cBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "poCIncotermsId")
    private List<CBpartner> cBpartnerList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cIncotermsId")
    private List<COrder> cOrderList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cIncotermsId")
    private List<CProjectVendor> cProjectVendorList;

    public CIncoterms() {
    }

    public CIncoterms(String cIncotermsId) {
        this.cIncotermsId = cIncotermsId;
    }

    public CIncoterms(String cIncotermsId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.cIncotermsId = cIncotermsId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getCIncotermsId() {
        return cIncotermsId;
    }

    public void setCIncotermsId(String cIncotermsId) {
        this.cIncotermsId = cIncotermsId;
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

    public Character getRequiresdescription() {
        return requiresdescription;
    }

    public void setRequiresdescription(Character requiresdescription) {
        this.requiresdescription = requiresdescription;
    }

    public Character getIsdelivery() {
        return isdelivery;
    }

    public void setIsdelivery(Character isdelivery) {
        this.isdelivery = isdelivery;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList() {
        return cBpartnerList;
    }

    public void setCBpartnerList(List<CBpartner> cBpartnerList) {
        this.cBpartnerList = cBpartnerList;
    }

    @XmlTransient
    public List<CBpartner> getCBpartnerList1() {
        return cBpartnerList1;
    }

    public void setCBpartnerList1(List<CBpartner> cBpartnerList1) {
        this.cBpartnerList1 = cBpartnerList1;
    }

    @XmlTransient
    public List<COrder> getCOrderList() {
        return cOrderList;
    }

    public void setCOrderList(List<COrder> cOrderList) {
        this.cOrderList = cOrderList;
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
    public List<CProjectVendor> getCProjectVendorList() {
        return cProjectVendorList;
    }

    public void setCProjectVendorList(List<CProjectVendor> cProjectVendorList) {
        this.cProjectVendorList = cProjectVendorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cIncotermsId != null ? cIncotermsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CIncoterms)) {
            return false;
        }
        CIncoterms other = (CIncoterms) object;
        if ((this.cIncotermsId == null && other.cIncotermsId != null) || (this.cIncotermsId != null && !this.cIncotermsId.equals(other.cIncotermsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CIncoterms[ cIncotermsId=" + cIncotermsId + " ]";
    }
    
}
