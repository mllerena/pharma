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
import javax.persistence.FetchType;
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
@Table(name = "ad_ref_list")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdRefList.findAll", query = "SELECT a FROM AdRefList a"),
    @NamedQuery(name = "AdRefList.findByAdRefListId", query = "SELECT a FROM AdRefList a WHERE a.adRefListId = :adRefListId"),
    @NamedQuery(name = "AdRefList.findByIsactive", query = "SELECT a FROM AdRefList a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdRefList.findByCreated", query = "SELECT a FROM AdRefList a WHERE a.created = :created"),
    @NamedQuery(name = "AdRefList.findByCreatedby", query = "SELECT a FROM AdRefList a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdRefList.findByUpdated", query = "SELECT a FROM AdRefList a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdRefList.findByUpdatedby", query = "SELECT a FROM AdRefList a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdRefList.findByValue", query = "SELECT a FROM AdRefList a WHERE a.value = :value"),
    @NamedQuery(name = "AdRefList.findByName", query = "SELECT a FROM AdRefList a WHERE a.name = :name"),
    @NamedQuery(name = "AdRefList.findByDescription", query = "SELECT a FROM AdRefList a WHERE a.description = :description"),
    @NamedQuery(name = "AdRefList.findByValidfrom", query = "SELECT a FROM AdRefList a WHERE a.validfrom = :validfrom"),
    @NamedQuery(name = "AdRefList.findByValidto", query = "SELECT a FROM AdRefList a WHERE a.validto = :validto"),
    @NamedQuery(name = "AdRefList.findBySeqno", query = "SELECT a FROM AdRefList a WHERE a.seqno = :seqno")})
public class AdRefList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_ref_list_id")
    private String adRefListId;
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
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "validfrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validfrom;
    @Column(name = "validto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validto;
    @Column(name = "seqno")
    private Long seqno;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_reference_id", referencedColumnName = "ad_reference_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdReference adReferenceId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adRefListId")
    private List<AdRefListTrl> adRefListTrlList;

    public AdRefList() {
    }

    public AdRefList(String adRefListId) {
        this.adRefListId = adRefListId;
    }

    public AdRefList(String adRefListId, Character isactive, Date created, String createdby, Date updated, String updatedby, String value, String name) {
        this.adRefListId = adRefListId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.value = value;
        this.name = name;
    }

    public String getAdRefListId() {
        return adRefListId;
    }

    public void setAdRefListId(String adRefListId) {
        this.adRefListId = adRefListId;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public Date getValidfrom() {
        return validfrom;
    }

    public void setValidfrom(Date validfrom) {
        this.validfrom = validfrom;
    }

    public Date getValidto() {
        return validto;
    }

    public void setValidto(Date validto) {
        this.validto = validto;
    }

    public Long getSeqno() {
        return seqno;
    }

    public void setSeqno(Long seqno) {
        this.seqno = seqno;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdModule getAdModuleId() {
        return adModuleId;
    }

    public void setAdModuleId(AdModule adModuleId) {
        this.adModuleId = adModuleId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdReference getAdReferenceId() {
        return adReferenceId;
    }

    public void setAdReferenceId(AdReference adReferenceId) {
        this.adReferenceId = adReferenceId;
    }

    @XmlTransient
    public List<AdRefListTrl> getAdRefListTrlList() {
        return adRefListTrlList;
    }

    public void setAdRefListTrlList(List<AdRefListTrl> adRefListTrlList) {
        this.adRefListTrlList = adRefListTrlList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adRefListId != null ? adRefListId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdRefList)) {
            return false;
        }
        AdRefList other = (AdRefList) object;
        if ((this.adRefListId == null && other.adRefListId != null) || (this.adRefListId != null && !this.adRefListId.equals(other.adRefListId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdRefList[ adRefListId=" + adRefListId + " ]";
    }
    
}
