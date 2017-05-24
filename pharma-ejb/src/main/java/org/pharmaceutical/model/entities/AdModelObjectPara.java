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
@Table(name = "ad_model_object_para")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdModelObjectPara.findAll", query = "SELECT a FROM AdModelObjectPara a"),
    @NamedQuery(name = "AdModelObjectPara.findByAdModelObjectParaId", query = "SELECT a FROM AdModelObjectPara a WHERE a.adModelObjectParaId = :adModelObjectParaId"),
    @NamedQuery(name = "AdModelObjectPara.findByIsactive", query = "SELECT a FROM AdModelObjectPara a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdModelObjectPara.findByCreated", query = "SELECT a FROM AdModelObjectPara a WHERE a.created = :created"),
    @NamedQuery(name = "AdModelObjectPara.findByCreatedby", query = "SELECT a FROM AdModelObjectPara a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdModelObjectPara.findByUpdated", query = "SELECT a FROM AdModelObjectPara a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdModelObjectPara.findByUpdatedby", query = "SELECT a FROM AdModelObjectPara a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdModelObjectPara.findByLine", query = "SELECT a FROM AdModelObjectPara a WHERE a.line = :line"),
    @NamedQuery(name = "AdModelObjectPara.findByName", query = "SELECT a FROM AdModelObjectPara a WHERE a.name = :name"),
    @NamedQuery(name = "AdModelObjectPara.findByValue", query = "SELECT a FROM AdModelObjectPara a WHERE a.value = :value")})
public class AdModelObjectPara implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_model_object_para_id")
    private String adModelObjectParaId;
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
    @Column(name = "line")
    private long line;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "name")
    private String name;
    @Size(max = 1000)
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_model_object_id", referencedColumnName = "ad_model_object_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModelObject adModelObjectId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdModelObjectPara() {
    }

    public AdModelObjectPara(String adModelObjectParaId) {
        this.adModelObjectParaId = adModelObjectParaId;
    }

    public AdModelObjectPara(String adModelObjectParaId, Character isactive, Date created, String createdby, Date updated, String updatedby, long line, String name) {
        this.adModelObjectParaId = adModelObjectParaId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.line = line;
        this.name = name;
    }

    public String getAdModelObjectParaId() {
        return adModelObjectParaId;
    }

    public void setAdModelObjectParaId(String adModelObjectParaId) {
        this.adModelObjectParaId = adModelObjectParaId;
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

    public long getLine() {
        return line;
    }

    public void setLine(long line) {
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdModelObject getAdModelObjectId() {
        return adModelObjectId;
    }

    public void setAdModelObjectId(AdModelObject adModelObjectId) {
        this.adModelObjectId = adModelObjectId;
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
        hash += (adModelObjectParaId != null ? adModelObjectParaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdModelObjectPara)) {
            return false;
        }
        AdModelObjectPara other = (AdModelObjectPara) object;
        if ((this.adModelObjectParaId == null && other.adModelObjectParaId != null) || (this.adModelObjectParaId != null && !this.adModelObjectParaId.equals(other.adModelObjectParaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdModelObjectPara[ adModelObjectParaId=" + adModelObjectParaId + " ]";
    }
    
}
