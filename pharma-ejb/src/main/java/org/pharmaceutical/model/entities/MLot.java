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
@Table(name = "m_lot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MLot.findAll", query = "SELECT m FROM MLot m"),
    @NamedQuery(name = "MLot.findByMLotId", query = "SELECT m FROM MLot m WHERE m.mLotId = :mLotId"),
    @NamedQuery(name = "MLot.findByIsactive", query = "SELECT m FROM MLot m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MLot.findByCreated", query = "SELECT m FROM MLot m WHERE m.created = :created"),
    @NamedQuery(name = "MLot.findByCreatedby", query = "SELECT m FROM MLot m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MLot.findByUpdated", query = "SELECT m FROM MLot m WHERE m.updated = :updated"),
    @NamedQuery(name = "MLot.findByUpdatedby", query = "SELECT m FROM MLot m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MLot.findByName", query = "SELECT m FROM MLot m WHERE m.name = :name"),
    @NamedQuery(name = "MLot.findByDescription", query = "SELECT m FROM MLot m WHERE m.description = :description"),
    @NamedQuery(name = "MLot.findByHelp", query = "SELECT m FROM MLot m WHERE m.help = :help"),
    @NamedQuery(name = "MLot.findByDatefrom", query = "SELECT m FROM MLot m WHERE m.datefrom = :datefrom"),
    @NamedQuery(name = "MLot.findByDateto", query = "SELECT m FROM MLot m WHERE m.dateto = :dateto")})
public class MLot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_lot_id")
    private String mLotId;
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
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Column(name = "datefrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefrom;
    @Column(name = "dateto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateto;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "m_product_id", referencedColumnName = "m_product_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MProduct mProductId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mLotId")
    private List<MAttributesetinstance> mAttributesetinstanceList;

    public MLot() {
    }

    public MLot(String mLotId) {
        this.mLotId = mLotId;
    }

    public MLot(String mLotId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.mLotId = mLotId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getMLotId() {
        return mLotId;
    }

    public void setMLotId(String mLotId) {
        this.mLotId = mLotId;
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

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
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

    public MProduct getMProductId() {
        return mProductId;
    }

    public void setMProductId(MProduct mProductId) {
        this.mProductId = mProductId;
    }

    @XmlTransient
    public List<MAttributesetinstance> getMAttributesetinstanceList() {
        return mAttributesetinstanceList;
    }

    public void setMAttributesetinstanceList(List<MAttributesetinstance> mAttributesetinstanceList) {
        this.mAttributesetinstanceList = mAttributesetinstanceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mLotId != null ? mLotId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MLot)) {
            return false;
        }
        MLot other = (MLot) object;
        if ((this.mLotId == null && other.mLotId != null) || (this.mLotId != null && !this.mLotId.equals(other.mLotId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MLot[ mLotId=" + mLotId + " ]";
    }
    
}
