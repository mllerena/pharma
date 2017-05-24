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
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import org.pharmaceutical.model.converters.YesNoConverter;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Entity
@Table(name = "ad_pinstance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdPinstance.findAll", query = "SELECT a FROM AdPinstance a"),
    @NamedQuery(name = "AdPinstance.findByAdPinstanceId", query = "SELECT a FROM AdPinstance a WHERE a.adPinstanceId = :adPinstanceId"),
    @NamedQuery(name = "AdPinstance.findByRecordId", query = "SELECT a FROM AdPinstance a WHERE a.recordId = :recordId"),
    @NamedQuery(name = "AdPinstance.findByIsprocessing", query = "SELECT a FROM AdPinstance a WHERE a.isprocessing = :isprocessing"),
    @NamedQuery(name = "AdPinstance.findByCreated", query = "SELECT a FROM AdPinstance a WHERE a.created = :created"),
    @NamedQuery(name = "AdPinstance.findByUpdated", query = "SELECT a FROM AdPinstance a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdPinstance.findByResult", query = "SELECT a FROM AdPinstance a WHERE a.result = :result"),
    @NamedQuery(name = "AdPinstance.findByErrormsg", query = "SELECT a FROM AdPinstance a WHERE a.errormsg = :errormsg"),
    @NamedQuery(name = "AdPinstance.findByCreatedby", query = "SELECT a FROM AdPinstance a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdPinstance.findByUpdatedby", query = "SELECT a FROM AdPinstance a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdPinstance.findByIsactive", query = "SELECT a FROM AdPinstance a WHERE a.isactive = :isactive")})
public class AdPinstance extends AbstractEntityModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_pinstance_id")
    private String adPinstanceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "record_id")
    private String recordId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isprocessing")
    private Character isprocessing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Column(name = "result")
    private Long result;
    @Size(max = 2000)
    @Column(name = "errormsg")
    private String errormsg;
    @Size(max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    
    @Basic(optional = false)
    @Column(name = "isactive")
    @Convert(converter=YesNoConverter.class) 
    private YesNo isactive;
    
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_process_id", referencedColumnName = "ad_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdProcess adProcessId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adPinstanceId")
    private List<AdPinstancePara> adPinstanceParaList;

    public AdPinstance() {
    }

    public AdPinstance(String adPinstanceId) {
        this.adPinstanceId = adPinstanceId;
    }

    public AdPinstance(String adPinstanceId, String recordId, Character isprocessing, Date created, String updatedby) {
        this.adPinstanceId = adPinstanceId;
        this.recordId = recordId;
        this.isprocessing = isprocessing;
        this.created = created;
        this.updatedby = updatedby;
    }

    public String getAdPinstanceId() {
        return adPinstanceId;
    }

    public void setAdPinstanceId(String adPinstanceId) {
        this.adPinstanceId = adPinstanceId;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public Character getIsprocessing() {
        return isprocessing;
    }

    public void setIsprocessing(Character isprocessing) {
        this.isprocessing = isprocessing;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public YesNo getIsactive() {
        return isactive;
    }

    public void setIsactive(YesNo isactive) {
        this.isactive = isactive;
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

    public AdProcess getAdProcessId() {
        return adProcessId;
    }

    public void setAdProcessId(AdProcess adProcessId) {
        this.adProcessId = adProcessId;
    }

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    @XmlTransient
    public List<AdPinstancePara> getAdPinstanceParaList() {
        return adPinstanceParaList;
    }

    public void setAdPinstanceParaList(List<AdPinstancePara> adPinstanceParaList) {
        this.adPinstanceParaList = adPinstanceParaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adPinstanceId != null ? adPinstanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdPinstance)) {
            return false;
        }
        AdPinstance other = (AdPinstance) object;
        if ((this.adPinstanceId == null && other.adPinstanceId != null) || (this.adPinstanceId != null && !this.adPinstanceId.equals(other.adPinstanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdPinstance[ adPinstanceId=" + adPinstanceId + " ]";
    }

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return adPinstanceId;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		adPinstanceId = id;
	}
    
}
