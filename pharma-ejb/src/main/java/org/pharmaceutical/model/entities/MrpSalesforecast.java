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
@Table(name = "mrp_salesforecast")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MrpSalesforecast.findAll", query = "SELECT m FROM MrpSalesforecast m"),
    @NamedQuery(name = "MrpSalesforecast.findByMrpSalesforecastId", query = "SELECT m FROM MrpSalesforecast m WHERE m.mrpSalesforecastId = :mrpSalesforecastId"),
    @NamedQuery(name = "MrpSalesforecast.findByIsactive", query = "SELECT m FROM MrpSalesforecast m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MrpSalesforecast.findByCreated", query = "SELECT m FROM MrpSalesforecast m WHERE m.created = :created"),
    @NamedQuery(name = "MrpSalesforecast.findByCreatedby", query = "SELECT m FROM MrpSalesforecast m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MrpSalesforecast.findByUpdated", query = "SELECT m FROM MrpSalesforecast m WHERE m.updated = :updated"),
    @NamedQuery(name = "MrpSalesforecast.findByUpdatedby", query = "SELECT m FROM MrpSalesforecast m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MrpSalesforecast.findByDescription", query = "SELECT m FROM MrpSalesforecast m WHERE m.description = :description"),
    @NamedQuery(name = "MrpSalesforecast.findByDatedoc", query = "SELECT m FROM MrpSalesforecast m WHERE m.datedoc = :datedoc")})
public class MrpSalesforecast implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "mrp_salesforecast_id")
    private String mrpSalesforecastId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "datedoc")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedoc;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CBpartner cBpartnerId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "mrpSalesforecastId")
    private List<MrpSalesforecastline> mrpSalesforecastlineList;

    public MrpSalesforecast() {
    }

    public MrpSalesforecast(String mrpSalesforecastId) {
        this.mrpSalesforecastId = mrpSalesforecastId;
    }

    public MrpSalesforecast(String mrpSalesforecastId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.mrpSalesforecastId = mrpSalesforecastId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getMrpSalesforecastId() {
        return mrpSalesforecastId;
    }

    public void setMrpSalesforecastId(String mrpSalesforecastId) {
        this.mrpSalesforecastId = mrpSalesforecastId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatedoc() {
        return datedoc;
    }

    public void setDatedoc(Date datedoc) {
        this.datedoc = datedoc;
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
    public List<MrpSalesforecastline> getMrpSalesforecastlineList() {
        return mrpSalesforecastlineList;
    }

    public void setMrpSalesforecastlineList(List<MrpSalesforecastline> mrpSalesforecastlineList) {
        this.mrpSalesforecastlineList = mrpSalesforecastlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mrpSalesforecastId != null ? mrpSalesforecastId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MrpSalesforecast)) {
            return false;
        }
        MrpSalesforecast other = (MrpSalesforecast) object;
        if ((this.mrpSalesforecastId == null && other.mrpSalesforecastId != null) || (this.mrpSalesforecastId != null && !this.mrpSalesforecastId.equals(other.mrpSalesforecastId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MrpSalesforecast[ mrpSalesforecastId=" + mrpSalesforecastId + " ]";
    }
    
}
