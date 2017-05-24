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
import javax.persistence.Lob;
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
@Table(name = "ad_attachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdAttachment.findAll", query = "SELECT a FROM AdAttachment a"),
    @NamedQuery(name = "AdAttachment.findByAdAttachmentId", query = "SELECT a FROM AdAttachment a WHERE a.adAttachmentId = :adAttachmentId"),
    @NamedQuery(name = "AdAttachment.findByIsactive", query = "SELECT a FROM AdAttachment a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdAttachment.findByCreated", query = "SELECT a FROM AdAttachment a WHERE a.created = :created"),
    @NamedQuery(name = "AdAttachment.findByCreatedby", query = "SELECT a FROM AdAttachment a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdAttachment.findByUpdated", query = "SELECT a FROM AdAttachment a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdAttachment.findByUpdatedby", query = "SELECT a FROM AdAttachment a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdAttachment.findByRecordId", query = "SELECT a FROM AdAttachment a WHERE a.recordId = :recordId"),
    @NamedQuery(name = "AdAttachment.findByTitle", query = "SELECT a FROM AdAttachment a WHERE a.title = :title"),
    @NamedQuery(name = "AdAttachment.findByText", query = "SELECT a FROM AdAttachment a WHERE a.text = :text")})
public class AdAttachment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_attachment_id")
    private String adAttachmentId;
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
    @Size(min = 1, max = 32)
    @Column(name = "record_id")
    private String recordId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "title")
    private String title;
    @Size(max = 2000)
    @Column(name = "text")
    private String text;
    @Lob
    @Column(name = "binarydata")
    private byte[] binarydata;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_datatype_id", referencedColumnName = "ad_datatype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdDatatype adDatatypeId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTable adTableId;

    public AdAttachment() {
    }

    public AdAttachment(String adAttachmentId) {
        this.adAttachmentId = adAttachmentId;
    }

    public AdAttachment(String adAttachmentId, Character isactive, Date created, String createdby, Date updated, String updatedby, String recordId, String title) {
        this.adAttachmentId = adAttachmentId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.recordId = recordId;
        this.title = title;
    }

    public String getAdAttachmentId() {
        return adAttachmentId;
    }

    public void setAdAttachmentId(String adAttachmentId) {
        this.adAttachmentId = adAttachmentId;
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

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getBinarydata() {
        return binarydata;
    }

    public void setBinarydata(byte[] binarydata) {
        this.binarydata = binarydata;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdDatatype getAdDatatypeId() {
        return adDatatypeId;
    }

    public void setAdDatatypeId(AdDatatype adDatatypeId) {
        this.adDatatypeId = adDatatypeId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdTable getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(AdTable adTableId) {
        this.adTableId = adTableId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adAttachmentId != null ? adAttachmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdAttachment)) {
            return false;
        }
        AdAttachment other = (AdAttachment) object;
        if ((this.adAttachmentId == null && other.adAttachmentId != null) || (this.adAttachmentId != null && !this.adAttachmentId.equals(other.adAttachmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdAttachment[ adAttachmentId=" + adAttachmentId + " ]";
    }
    
}
