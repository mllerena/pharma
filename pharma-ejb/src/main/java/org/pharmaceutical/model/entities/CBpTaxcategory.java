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
@Table(name = "c_bp_taxcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBpTaxcategory.findAll", query = "SELECT c FROM CBpTaxcategory c"),
    @NamedQuery(name = "CBpTaxcategory.findByCBpTaxcategoryId", query = "SELECT c FROM CBpTaxcategory c WHERE c.cBpTaxcategoryId = :cBpTaxcategoryId"),
    @NamedQuery(name = "CBpTaxcategory.findByIsactive", query = "SELECT c FROM CBpTaxcategory c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBpTaxcategory.findByCreated", query = "SELECT c FROM CBpTaxcategory c WHERE c.created = :created"),
    @NamedQuery(name = "CBpTaxcategory.findByCreatedby", query = "SELECT c FROM CBpTaxcategory c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBpTaxcategory.findByUpdated", query = "SELECT c FROM CBpTaxcategory c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBpTaxcategory.findByUpdatedby", query = "SELECT c FROM CBpTaxcategory c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBpTaxcategory.findByName", query = "SELECT c FROM CBpTaxcategory c WHERE c.name = :name"),
    @NamedQuery(name = "CBpTaxcategory.findByDescription", query = "SELECT c FROM CBpTaxcategory c WHERE c.description = :description")})
public class CBpTaxcategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_bp_taxcategory_id")
    private String cBpTaxcategoryId;
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
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "soBpTaxcategoryId")
    private List<CBpartner> cBpartnerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "poBpTaxcategoryId")
    private List<CBpartner> cBpartnerList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpTaxcategoryId")
    private List<CTax> cTaxList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cBpTaxcategoryId")
    private List<ITax> iTaxList;

    public CBpTaxcategory() {
    }

    public CBpTaxcategory(String cBpTaxcategoryId) {
        this.cBpTaxcategoryId = cBpTaxcategoryId;
    }

    public CBpTaxcategory(String cBpTaxcategoryId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.cBpTaxcategoryId = cBpTaxcategoryId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getCBpTaxcategoryId() {
        return cBpTaxcategoryId;
    }

    public void setCBpTaxcategoryId(String cBpTaxcategoryId) {
        this.cBpTaxcategoryId = cBpTaxcategoryId;
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
    public List<CTax> getCTaxList() {
        return cTaxList;
    }

    public void setCTaxList(List<CTax> cTaxList) {
        this.cTaxList = cTaxList;
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
    public List<ITax> getITaxList() {
        return iTaxList;
    }

    public void setITaxList(List<ITax> iTaxList) {
        this.iTaxList = iTaxList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBpTaxcategoryId != null ? cBpTaxcategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBpTaxcategory)) {
            return false;
        }
        CBpTaxcategory other = (CBpTaxcategory) object;
        if ((this.cBpTaxcategoryId == null && other.cBpTaxcategoryId != null) || (this.cBpTaxcategoryId != null && !this.cBpTaxcategoryId.equals(other.cBpTaxcategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBpTaxcategory[ cBpTaxcategoryId=" + cBpTaxcategoryId + " ]";
    }
    
}
