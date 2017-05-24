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
@Table(name = "s_timetype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "STimetype.findAll", query = "SELECT s FROM STimetype s"),
    @NamedQuery(name = "STimetype.findBySTimetypeId", query = "SELECT s FROM STimetype s WHERE s.sTimetypeId = :sTimetypeId"),
    @NamedQuery(name = "STimetype.findByIsactive", query = "SELECT s FROM STimetype s WHERE s.isactive = :isactive"),
    @NamedQuery(name = "STimetype.findByCreated", query = "SELECT s FROM STimetype s WHERE s.created = :created"),
    @NamedQuery(name = "STimetype.findByCreatedby", query = "SELECT s FROM STimetype s WHERE s.createdby = :createdby"),
    @NamedQuery(name = "STimetype.findByUpdated", query = "SELECT s FROM STimetype s WHERE s.updated = :updated"),
    @NamedQuery(name = "STimetype.findByUpdatedby", query = "SELECT s FROM STimetype s WHERE s.updatedby = :updatedby"),
    @NamedQuery(name = "STimetype.findByName", query = "SELECT s FROM STimetype s WHERE s.name = :name"),
    @NamedQuery(name = "STimetype.findByDescription", query = "SELECT s FROM STimetype s WHERE s.description = :description"),
    @NamedQuery(name = "STimetype.findByHelp", query = "SELECT s FROM STimetype s WHERE s.help = :help")})
public class STimetype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "s_timetype_id")
    private String sTimetypeId;
    @Column(name = "isactive")
    private Character isactive;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Size(max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Size(max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "sTimetypeId")
    private List<STimeexpenseline> sTimeexpenselineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;

    public STimetype() {
    }

    public STimetype(String sTimetypeId) {
        this.sTimetypeId = sTimetypeId;
    }

    public String getSTimetypeId() {
        return sTimetypeId;
    }

    public void setSTimetypeId(String sTimetypeId) {
        this.sTimetypeId = sTimetypeId;
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

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sTimetypeId != null ? sTimetypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof STimetype)) {
            return false;
        }
        STimetype other = (STimetype) object;
        if ((this.sTimetypeId == null && other.sTimetypeId != null) || (this.sTimetypeId != null && !this.sTimetypeId.equals(other.sTimetypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.STimetype[ sTimetypeId=" + sTimetypeId + " ]";
    }
    
}
