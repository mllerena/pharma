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
@Table(name = "m_shipper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MShipper.findAll", query = "SELECT m FROM MShipper m"),
    @NamedQuery(name = "MShipper.findByMShipperId", query = "SELECT m FROM MShipper m WHERE m.mShipperId = :mShipperId"),
    @NamedQuery(name = "MShipper.findByIsactive", query = "SELECT m FROM MShipper m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MShipper.findByCreated", query = "SELECT m FROM MShipper m WHERE m.created = :created"),
    @NamedQuery(name = "MShipper.findByCreatedby", query = "SELECT m FROM MShipper m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MShipper.findByUpdated", query = "SELECT m FROM MShipper m WHERE m.updated = :updated"),
    @NamedQuery(name = "MShipper.findByUpdatedby", query = "SELECT m FROM MShipper m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MShipper.findByName", query = "SELECT m FROM MShipper m WHERE m.name = :name"),
    @NamedQuery(name = "MShipper.findByDescription", query = "SELECT m FROM MShipper m WHERE m.description = :description")})
public class MShipper implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "m_shipper_id")
    private String mShipperId;
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
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mShipperId")
    private List<MFreight> mFreightList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mShipperId")
    private List<COrder> cOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mShipperId")
    private List<IOrder> iOrderList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mShipperId")
    private List<CExternalpos> cExternalposList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mShipperId")
    private List<COrderline> cOrderlineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "mShipperId")
    private List<MInout> mInoutList;

    public MShipper() {
    }

    public MShipper(String mShipperId) {
        this.mShipperId = mShipperId;
    }

    public MShipper(String mShipperId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.mShipperId = mShipperId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getMShipperId() {
        return mShipperId;
    }

    public void setMShipperId(String mShipperId) {
        this.mShipperId = mShipperId;
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
    public List<MFreight> getMFreightList() {
        return mFreightList;
    }

    public void setMFreightList(List<MFreight> mFreightList) {
        this.mFreightList = mFreightList;
    }

    @XmlTransient
    public List<COrder> getCOrderList() {
        return cOrderList;
    }

    public void setCOrderList(List<COrder> cOrderList) {
        this.cOrderList = cOrderList;
    }

    @XmlTransient
    public List<IOrder> getIOrderList() {
        return iOrderList;
    }

    public void setIOrderList(List<IOrder> iOrderList) {
        this.iOrderList = iOrderList;
    }

    @XmlTransient
    public List<CExternalpos> getCExternalposList() {
        return cExternalposList;
    }

    public void setCExternalposList(List<CExternalpos> cExternalposList) {
        this.cExternalposList = cExternalposList;
    }

    @XmlTransient
    public List<COrderline> getCOrderlineList() {
        return cOrderlineList;
    }

    public void setCOrderlineList(List<COrderline> cOrderlineList) {
        this.cOrderlineList = cOrderlineList;
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

    @XmlTransient
    public List<MInout> getMInoutList() {
        return mInoutList;
    }

    public void setMInoutList(List<MInout> mInoutList) {
        this.mInoutList = mInoutList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mShipperId != null ? mShipperId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MShipper)) {
            return false;
        }
        MShipper other = (MShipper) object;
        if ((this.mShipperId == null && other.mShipperId != null) || (this.mShipperId != null && !this.mShipperId.equals(other.mShipperId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MShipper[ mShipperId=" + mShipperId + " ]";
    }
    
}
