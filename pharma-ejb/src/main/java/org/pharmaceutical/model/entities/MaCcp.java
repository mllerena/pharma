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
@Table(name = "ma_ccp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaCcp.findAll", query = "SELECT m FROM MaCcp m"),
    @NamedQuery(name = "MaCcp.findByMaCcpId", query = "SELECT m FROM MaCcp m WHERE m.maCcpId = :maCcpId"),
    @NamedQuery(name = "MaCcp.findByIsactive", query = "SELECT m FROM MaCcp m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaCcp.findByCreated", query = "SELECT m FROM MaCcp m WHERE m.created = :created"),
    @NamedQuery(name = "MaCcp.findByCreatedby", query = "SELECT m FROM MaCcp m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaCcp.findByUpdated", query = "SELECT m FROM MaCcp m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaCcp.findByUpdatedby", query = "SELECT m FROM MaCcp m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaCcp.findByName", query = "SELECT m FROM MaCcp m WHERE m.name = :name"),
    @NamedQuery(name = "MaCcp.findByDescription", query = "SELECT m FROM MaCcp m WHERE m.description = :description"),
    @NamedQuery(name = "MaCcp.findByCritical", query = "SELECT m FROM MaCcp m WHERE m.critical = :critical"),
    @NamedQuery(name = "MaCcp.findByValuetype", query = "SELECT m FROM MaCcp m WHERE m.valuetype = :valuetype"),
    @NamedQuery(name = "MaCcp.findByValuenumber", query = "SELECT m FROM MaCcp m WHERE m.valuenumber = :valuenumber"),
    @NamedQuery(name = "MaCcp.findBySeqno", query = "SELECT m FROM MaCcp m WHERE m.seqno = :seqno")})
public class MaCcp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_ccp_id")
    private String maCcpId;
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
    @Column(name = "critical")
    private Character critical;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "valuetype")
    private String valuetype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valuenumber")
    private BigInteger valuenumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqno")
    private BigInteger seqno;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_ccp_group_id", referencedColumnName = "ma_ccp_group_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaCcpGroup maCcpGroupId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maCcpId")
    private List<MaMeasureValues> maMeasureValuesList;

    public MaCcp() {
    }

    public MaCcp(String maCcpId) {
        this.maCcpId = maCcpId;
    }

    public MaCcp(String maCcpId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character critical, String valuetype, BigInteger valuenumber, BigInteger seqno) {
        this.maCcpId = maCcpId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.critical = critical;
        this.valuetype = valuetype;
        this.valuenumber = valuenumber;
        this.seqno = seqno;
    }

    public String getMaCcpId() {
        return maCcpId;
    }

    public void setMaCcpId(String maCcpId) {
        this.maCcpId = maCcpId;
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

    public Character getCritical() {
        return critical;
    }

    public void setCritical(Character critical) {
        this.critical = critical;
    }

    public String getValuetype() {
        return valuetype;
    }

    public void setValuetype(String valuetype) {
        this.valuetype = valuetype;
    }

    public BigInteger getValuenumber() {
        return valuenumber;
    }

    public void setValuenumber(BigInteger valuenumber) {
        this.valuenumber = valuenumber;
    }

    public BigInteger getSeqno() {
        return seqno;
    }

    public void setSeqno(BigInteger seqno) {
        this.seqno = seqno;
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

    public MaCcpGroup getMaCcpGroupId() {
        return maCcpGroupId;
    }

    public void setMaCcpGroupId(MaCcpGroup maCcpGroupId) {
        this.maCcpGroupId = maCcpGroupId;
    }

    @XmlTransient
    public List<MaMeasureValues> getMaMeasureValuesList() {
        return maMeasureValuesList;
    }

    public void setMaMeasureValuesList(List<MaMeasureValues> maMeasureValuesList) {
        this.maMeasureValuesList = maMeasureValuesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCcpId != null ? maCcpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaCcp)) {
            return false;
        }
        MaCcp other = (MaCcp) object;
        if ((this.maCcpId == null && other.maCcpId != null) || (this.maCcpId != null && !this.maCcpId.equals(other.maCcpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaCcp[ maCcpId=" + maCcpId + " ]";
    }
    
}
