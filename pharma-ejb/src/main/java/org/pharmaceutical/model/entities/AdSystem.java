/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "ad_system")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdSystem.findAll", query = "SELECT a FROM AdSystem a"),
    @NamedQuery(name = "AdSystem.findByAdSystemId", query = "SELECT a FROM AdSystem a WHERE a.adSystemId = :adSystemId"),
    @NamedQuery(name = "AdSystem.findByIsactive", query = "SELECT a FROM AdSystem a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdSystem.findByCreated", query = "SELECT a FROM AdSystem a WHERE a.created = :created"),
    @NamedQuery(name = "AdSystem.findByCreatedby", query = "SELECT a FROM AdSystem a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdSystem.findByUpdated", query = "SELECT a FROM AdSystem a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdSystem.findByUpdatedby", query = "SELECT a FROM AdSystem a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdSystem.findByName", query = "SELECT a FROM AdSystem a WHERE a.name = :name"),
    @NamedQuery(name = "AdSystem.findByInfo", query = "SELECT a FROM AdSystem a WHERE a.info = :info"),
    @NamedQuery(name = "AdSystem.findByVersion", query = "SELECT a FROM AdSystem a WHERE a.version = :version"),
    @NamedQuery(name = "AdSystem.findByReleaseno", query = "SELECT a FROM AdSystem a WHERE a.releaseno = :releaseno"),
    @NamedQuery(name = "AdSystem.findByTadRecordrange", query = "SELECT a FROM AdSystem a WHERE a.tadRecordrange = :tadRecordrange"),
    @NamedQuery(name = "AdSystem.findByTadRecordrangeInfo", query = "SELECT a FROM AdSystem a WHERE a.tadRecordrangeInfo = :tadRecordrangeInfo"),
    @NamedQuery(name = "AdSystem.findByTadTransactionalrange", query = "SELECT a FROM AdSystem a WHERE a.tadTransactionalrange = :tadTransactionalrange"),
    @NamedQuery(name = "AdSystem.findByTadTheme", query = "SELECT a FROM AdSystem a WHERE a.tadTheme = :tadTheme"),
    @NamedQuery(name = "AdSystem.findByInstanceKey", query = "SELECT a FROM AdSystem a WHERE a.instanceKey = :instanceKey"),
    @NamedQuery(name = "AdSystem.findByActivationKey", query = "SELECT a FROM AdSystem a WHERE a.activationKey = :activationKey")})
public class AdSystem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_system_id")
    private String adSystemId;
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
    @Size(max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "info")
    private String info;
    @Size(max = 20)
    @Column(name = "version")
    private String version;
    @Size(max = 3)
    @Column(name = "releaseno")
    private String releaseno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tad_recordrange")
    private BigInteger tadRecordrange;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tad_recordrange_info")
    private BigInteger tadRecordrangeInfo;
    @Column(name = "tad_transactionalrange")
    private BigInteger tadTransactionalrange;
    @Size(max = 255)
    @Column(name = "tad_theme")
    private String tadTheme;
    @Size(max = 2000)
    @Column(name = "instance_key")
    private String instanceKey;
    @Size(max = 2147483647)
    @Column(name = "activation_key")
    private String activationKey;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdSystem() {
    }

    public AdSystem(String adSystemId) {
        this.adSystemId = adSystemId;
    }

    public AdSystem(String adSystemId, Character isactive, Date created, String createdby, Date updated, String updatedby, BigInteger tadRecordrange, BigInteger tadRecordrangeInfo) {
        this.adSystemId = adSystemId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.tadRecordrange = tadRecordrange;
        this.tadRecordrangeInfo = tadRecordrangeInfo;
    }

    public String getAdSystemId() {
        return adSystemId;
    }

    public void setAdSystemId(String adSystemId) {
        this.adSystemId = adSystemId;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReleaseno() {
        return releaseno;
    }

    public void setReleaseno(String releaseno) {
        this.releaseno = releaseno;
    }

    public BigInteger getTadRecordrange() {
        return tadRecordrange;
    }

    public void setTadRecordrange(BigInteger tadRecordrange) {
        this.tadRecordrange = tadRecordrange;
    }

    public BigInteger getTadRecordrangeInfo() {
        return tadRecordrangeInfo;
    }

    public void setTadRecordrangeInfo(BigInteger tadRecordrangeInfo) {
        this.tadRecordrangeInfo = tadRecordrangeInfo;
    }

    public BigInteger getTadTransactionalrange() {
        return tadTransactionalrange;
    }

    public void setTadTransactionalrange(BigInteger tadTransactionalrange) {
        this.tadTransactionalrange = tadTransactionalrange;
    }

    public String getTadTheme() {
        return tadTheme;
    }

    public void setTadTheme(String tadTheme) {
        this.tadTheme = tadTheme;
    }

    public String getInstanceKey() {
        return instanceKey;
    }

    public void setInstanceKey(String instanceKey) {
        this.instanceKey = instanceKey;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
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
        hash += (adSystemId != null ? adSystemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdSystem)) {
            return false;
        }
        AdSystem other = (AdSystem) object;
        if ((this.adSystemId == null && other.adSystemId != null) || (this.adSystemId != null && !this.adSystemId.equals(other.adSystemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdSystem[ adSystemId=" + adSystemId + " ]";
    }
    
}
