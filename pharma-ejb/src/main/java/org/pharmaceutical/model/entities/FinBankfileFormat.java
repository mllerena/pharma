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
@Table(name = "fin_bankfile_format")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinBankfileFormat.findAll", query = "SELECT f FROM FinBankfileFormat f"),
    @NamedQuery(name = "FinBankfileFormat.findByFinBankfileFormatId", query = "SELECT f FROM FinBankfileFormat f WHERE f.finBankfileFormatId = :finBankfileFormatId"),
    @NamedQuery(name = "FinBankfileFormat.findByCreated", query = "SELECT f FROM FinBankfileFormat f WHERE f.created = :created"),
    @NamedQuery(name = "FinBankfileFormat.findByCreatedby", query = "SELECT f FROM FinBankfileFormat f WHERE f.createdby = :createdby"),
    @NamedQuery(name = "FinBankfileFormat.findByUpdated", query = "SELECT f FROM FinBankfileFormat f WHERE f.updated = :updated"),
    @NamedQuery(name = "FinBankfileFormat.findByUpdatedby", query = "SELECT f FROM FinBankfileFormat f WHERE f.updatedby = :updatedby"),
    @NamedQuery(name = "FinBankfileFormat.findByIsactive", query = "SELECT f FROM FinBankfileFormat f WHERE f.isactive = :isactive"),
    @NamedQuery(name = "FinBankfileFormat.findByName", query = "SELECT f FROM FinBankfileFormat f WHERE f.name = :name"),
    @NamedQuery(name = "FinBankfileFormat.findByDescription", query = "SELECT f FROM FinBankfileFormat f WHERE f.description = :description"),
    @NamedQuery(name = "FinBankfileFormat.findByClassname", query = "SELECT f FROM FinBankfileFormat f WHERE f.classname = :classname")})
public class FinBankfileFormat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fin_bankfile_format_id")
    private String finBankfileFormatId;
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
    @Column(name = "isactive")
    private Character isactive;
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
    @Size(min = 1, max = 1000)
    @Column(name = "classname")
    private String classname;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public FinBankfileFormat() {
    }

    public FinBankfileFormat(String finBankfileFormatId) {
        this.finBankfileFormatId = finBankfileFormatId;
    }

    public FinBankfileFormat(String finBankfileFormatId, Date created, String createdby, Date updated, String updatedby, Character isactive, String name, String classname) {
        this.finBankfileFormatId = finBankfileFormatId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isactive = isactive;
        this.name = name;
        this.classname = classname;
    }

    public String getFinBankfileFormatId() {
        return finBankfileFormatId;
    }

    public void setFinBankfileFormatId(String finBankfileFormatId) {
        this.finBankfileFormatId = finBankfileFormatId;
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

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (finBankfileFormatId != null ? finBankfileFormatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinBankfileFormat)) {
            return false;
        }
        FinBankfileFormat other = (FinBankfileFormat) object;
        if ((this.finBankfileFormatId == null && other.finBankfileFormatId != null) || (this.finBankfileFormatId != null && !this.finBankfileFormatId.equals(other.finBankfileFormatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.FinBankfileFormat[ finBankfileFormatId=" + finBankfileFormatId + " ]";
    }
    
}
