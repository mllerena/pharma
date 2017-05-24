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
@Table(name = "r_mailtext")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RMailtext.findAll", query = "SELECT r FROM RMailtext r"),
    @NamedQuery(name = "RMailtext.findByRMailtextId", query = "SELECT r FROM RMailtext r WHERE r.rMailtextId = :rMailtextId"),
    @NamedQuery(name = "RMailtext.findByIsactive", query = "SELECT r FROM RMailtext r WHERE r.isactive = :isactive"),
    @NamedQuery(name = "RMailtext.findByCreated", query = "SELECT r FROM RMailtext r WHERE r.created = :created"),
    @NamedQuery(name = "RMailtext.findByCreatedby", query = "SELECT r FROM RMailtext r WHERE r.createdby = :createdby"),
    @NamedQuery(name = "RMailtext.findByUpdated", query = "SELECT r FROM RMailtext r WHERE r.updated = :updated"),
    @NamedQuery(name = "RMailtext.findByUpdatedby", query = "SELECT r FROM RMailtext r WHERE r.updatedby = :updatedby"),
    @NamedQuery(name = "RMailtext.findByName", query = "SELECT r FROM RMailtext r WHERE r.name = :name"),
    @NamedQuery(name = "RMailtext.findByIshtml", query = "SELECT r FROM RMailtext r WHERE r.ishtml = :ishtml"),
    @NamedQuery(name = "RMailtext.findByMailheader", query = "SELECT r FROM RMailtext r WHERE r.mailheader = :mailheader"),
    @NamedQuery(name = "RMailtext.findByMailtext", query = "SELECT r FROM RMailtext r WHERE r.mailtext = :mailtext")})
public class RMailtext implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "r_mailtext_id")
    private String rMailtextId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "ishtml")
    private Character ishtml;
    @Size(max = 2000)
    @Column(name = "mailheader")
    private String mailheader;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "mailtext")
    private String mailtext;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "rMailtextId")
    private List<RRequest> rRequestList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "rMailtextId")
    private List<RRequestaction> rRequestactionList;

    public RMailtext() {
    }

    public RMailtext(String rMailtextId) {
        this.rMailtextId = rMailtextId;
    }

    public RMailtext(String rMailtextId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, Character ishtml, String mailtext) {
        this.rMailtextId = rMailtextId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.ishtml = ishtml;
        this.mailtext = mailtext;
    }

    public String getRMailtextId() {
        return rMailtextId;
    }

    public void setRMailtextId(String rMailtextId) {
        this.rMailtextId = rMailtextId;
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

    public Character getIshtml() {
        return ishtml;
    }

    public void setIshtml(Character ishtml) {
        this.ishtml = ishtml;
    }

    public String getMailheader() {
        return mailheader;
    }

    public void setMailheader(String mailheader) {
        this.mailheader = mailheader;
    }

    public String getMailtext() {
        return mailtext;
    }

    public void setMailtext(String mailtext) {
        this.mailtext = mailtext;
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

    @XmlTransient
    public List<RRequest> getRRequestList() {
        return rRequestList;
    }

    public void setRRequestList(List<RRequest> rRequestList) {
        this.rRequestList = rRequestList;
    }

    @XmlTransient
    public List<RRequestaction> getRRequestactionList() {
        return rRequestactionList;
    }

    public void setRRequestactionList(List<RRequestaction> rRequestactionList) {
        this.rRequestactionList = rRequestactionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rMailtextId != null ? rMailtextId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RMailtext)) {
            return false;
        }
        RMailtext other = (RMailtext) object;
        if ((this.rMailtextId == null && other.rMailtextId != null) || (this.rMailtextId != null && !this.rMailtextId.equals(other.rMailtextId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.RMailtext[ rMailtextId=" + rMailtextId + " ]";
    }
    
}
