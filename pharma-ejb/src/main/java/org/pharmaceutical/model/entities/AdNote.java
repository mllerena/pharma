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
@Table(name = "ad_note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdNote.findAll", query = "SELECT a FROM AdNote a"),
    @NamedQuery(name = "AdNote.findByAdNoteId", query = "SELECT a FROM AdNote a WHERE a.adNoteId = :adNoteId"),
    @NamedQuery(name = "AdNote.findByIsactive", query = "SELECT a FROM AdNote a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdNote.findByCreated", query = "SELECT a FROM AdNote a WHERE a.created = :created"),
    @NamedQuery(name = "AdNote.findByCreatedby", query = "SELECT a FROM AdNote a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdNote.findByUpdated", query = "SELECT a FROM AdNote a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdNote.findByUpdatedby", query = "SELECT a FROM AdNote a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdNote.findByReference", query = "SELECT a FROM AdNote a WHERE a.reference = :reference"),
    @NamedQuery(name = "AdNote.findByRecordId", query = "SELECT a FROM AdNote a WHERE a.recordId = :recordId"),
    @NamedQuery(name = "AdNote.findByText", query = "SELECT a FROM AdNote a WHERE a.text = :text"),
    @NamedQuery(name = "AdNote.findByProcessed", query = "SELECT a FROM AdNote a WHERE a.processed = :processed")})
public class AdNote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_note_id")
    private String adNoteId;
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
    @Column(name = "reference")
    private String reference;
    @Size(max = 32)
    @Column(name = "record_id")
    private String recordId;
    @Size(max = 2000)
    @Column(name = "text")
    private String text;
    @Column(name = "processed")
    private Character processed;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_message_id", referencedColumnName = "ad_message_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdMessage adMessageId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTable adTableId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;

    public AdNote() {
    }

    public AdNote(String adNoteId) {
        this.adNoteId = adNoteId;
    }

    public AdNote(String adNoteId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.adNoteId = adNoteId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAdNoteId() {
        return adNoteId;
    }

    public void setAdNoteId(String adNoteId) {
        this.adNoteId = adNoteId;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Character getProcessed() {
        return processed;
    }

    public void setProcessed(Character processed) {
        this.processed = processed;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdMessage getAdMessageId() {
        return adMessageId;
    }

    public void setAdMessageId(AdMessage adMessageId) {
        this.adMessageId = adMessageId;
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

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adNoteId != null ? adNoteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdNote)) {
            return false;
        }
        AdNote other = (AdNote) object;
        if ((this.adNoteId == null && other.adNoteId != null) || (this.adNoteId != null && !this.adNoteId.equals(other.adNoteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdNote[ adNoteId=" + adNoteId + " ]";
    }
    
}
