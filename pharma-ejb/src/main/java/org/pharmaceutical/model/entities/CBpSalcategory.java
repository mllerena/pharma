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
@Table(name = "c_bp_salcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBpSalcategory.findAll", query = "SELECT c FROM CBpSalcategory c"),
    @NamedQuery(name = "CBpSalcategory.findByCBpSalcategoryId", query = "SELECT c FROM CBpSalcategory c WHERE c.cBpSalcategoryId = :cBpSalcategoryId"),
    @NamedQuery(name = "CBpSalcategory.findByIsactive", query = "SELECT c FROM CBpSalcategory c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBpSalcategory.findByCreated", query = "SELECT c FROM CBpSalcategory c WHERE c.created = :created"),
    @NamedQuery(name = "CBpSalcategory.findByCreatedby", query = "SELECT c FROM CBpSalcategory c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBpSalcategory.findByUpdated", query = "SELECT c FROM CBpSalcategory c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBpSalcategory.findByUpdatedby", query = "SELECT c FROM CBpSalcategory c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBpSalcategory.findByDatefrom", query = "SELECT c FROM CBpSalcategory c WHERE c.datefrom = :datefrom")})
public class CBpSalcategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_bp_salcategory_id")
    private String cBpSalcategoryId;
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
    @Column(name = "datefrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefrom;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_salary_category_id", referencedColumnName = "c_salary_category_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CSalaryCategory cSalaryCategoryId;

    public CBpSalcategory() {
    }

    public CBpSalcategory(String cBpSalcategoryId) {
        this.cBpSalcategoryId = cBpSalcategoryId;
    }

    public CBpSalcategory(String cBpSalcategoryId, Character isactive, Date created, String createdby, Date updated, String updatedby, Date datefrom) {
        this.cBpSalcategoryId = cBpSalcategoryId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.datefrom = datefrom;
    }

    public String getCBpSalcategoryId() {
        return cBpSalcategoryId;
    }

    public void setCBpSalcategoryId(String cBpSalcategoryId) {
        this.cBpSalcategoryId = cBpSalcategoryId;
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

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CSalaryCategory getCSalaryCategoryId() {
        return cSalaryCategoryId;
    }

    public void setCSalaryCategoryId(CSalaryCategory cSalaryCategoryId) {
        this.cSalaryCategoryId = cSalaryCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBpSalcategoryId != null ? cBpSalcategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBpSalcategory)) {
            return false;
        }
        CBpSalcategory other = (CBpSalcategory) object;
        if ((this.cBpSalcategoryId == null && other.cBpSalcategoryId != null) || (this.cBpSalcategoryId != null && !this.cBpSalcategoryId.equals(other.cBpSalcategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBpSalcategory[ cBpSalcategoryId=" + cBpSalcategoryId + " ]";
    }
    
}
