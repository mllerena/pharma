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
@Table(name = "ad_audit_trail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdAuditTrail.findAll", query = "SELECT a FROM AdAuditTrail a"),
    @NamedQuery(name = "AdAuditTrail.findByAdAuditTrailId", query = "SELECT a FROM AdAuditTrail a WHERE a.adAuditTrailId = :adAuditTrailId"),
    @NamedQuery(name = "AdAuditTrail.findByAdClientId", query = "SELECT a FROM AdAuditTrail a WHERE a.adClientId = :adClientId"),
    @NamedQuery(name = "AdAuditTrail.findByAdOrgId", query = "SELECT a FROM AdAuditTrail a WHERE a.adOrgId = :adOrgId"),
    @NamedQuery(name = "AdAuditTrail.findByIsactive", query = "SELECT a FROM AdAuditTrail a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdAuditTrail.findByCreated", query = "SELECT a FROM AdAuditTrail a WHERE a.created = :created"),
    @NamedQuery(name = "AdAuditTrail.findByCreatedby", query = "SELECT a FROM AdAuditTrail a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdAuditTrail.findByUpdated", query = "SELECT a FROM AdAuditTrail a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdAuditTrail.findByUpdatedby", query = "SELECT a FROM AdAuditTrail a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdAuditTrail.findByAdTableId", query = "SELECT a FROM AdAuditTrail a WHERE a.adTableId = :adTableId"),
    @NamedQuery(name = "AdAuditTrail.findByRecordId", query = "SELECT a FROM AdAuditTrail a WHERE a.recordId = :recordId"),
    @NamedQuery(name = "AdAuditTrail.findByRecordRevision", query = "SELECT a FROM AdAuditTrail a WHERE a.recordRevision = :recordRevision"),
    @NamedQuery(name = "AdAuditTrail.findByAdUserId", query = "SELECT a FROM AdAuditTrail a WHERE a.adUserId = :adUserId"),
    @NamedQuery(name = "AdAuditTrail.findByEventTime", query = "SELECT a FROM AdAuditTrail a WHERE a.eventTime = :eventTime"),
    @NamedQuery(name = "AdAuditTrail.findByProcesstype", query = "SELECT a FROM AdAuditTrail a WHERE a.processtype = :processtype"),
    @NamedQuery(name = "AdAuditTrail.findByProcessId", query = "SELECT a FROM AdAuditTrail a WHERE a.processId = :processId"),
    @NamedQuery(name = "AdAuditTrail.findByAction", query = "SELECT a FROM AdAuditTrail a WHERE a.action = :action"),
    @NamedQuery(name = "AdAuditTrail.findByAdColumnId", query = "SELECT a FROM AdAuditTrail a WHERE a.adColumnId = :adColumnId"),
    @NamedQuery(name = "AdAuditTrail.findByOldChar", query = "SELECT a FROM AdAuditTrail a WHERE a.oldChar = :oldChar"),
    @NamedQuery(name = "AdAuditTrail.findByNewChar", query = "SELECT a FROM AdAuditTrail a WHERE a.newChar = :newChar"),
    @NamedQuery(name = "AdAuditTrail.findByOldNchar", query = "SELECT a FROM AdAuditTrail a WHERE a.oldNchar = :oldNchar"),
    @NamedQuery(name = "AdAuditTrail.findByNewNchar", query = "SELECT a FROM AdAuditTrail a WHERE a.newNchar = :newNchar"),
    @NamedQuery(name = "AdAuditTrail.findByOldNumber", query = "SELECT a FROM AdAuditTrail a WHERE a.oldNumber = :oldNumber"),
    @NamedQuery(name = "AdAuditTrail.findByNewNumber", query = "SELECT a FROM AdAuditTrail a WHERE a.newNumber = :newNumber"),
    @NamedQuery(name = "AdAuditTrail.findByOldDate", query = "SELECT a FROM AdAuditTrail a WHERE a.oldDate = :oldDate"),
    @NamedQuery(name = "AdAuditTrail.findByNewDate", query = "SELECT a FROM AdAuditTrail a WHERE a.newDate = :newDate")})
public class AdAuditTrail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_audit_trail_id")
    private String adAuditTrailId;
    @Size(max = 32)
    @Column(name = "ad_client_id")
    private String adClientId;
    @Size(max = 32)
    @Column(name = "ad_org_id")
    private String adOrgId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isactive")
    private Character isactive;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 32)
    @Column(name = "createdby")
    private String createdby;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Size(max = 32)
    @Column(name = "updatedby")
    private String updatedby;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_table_id")
    private String adTableId;
    @Size(max = 32)
    @Column(name = "record_id")
    private String recordId;
    @Column(name = "record_revision")
    private BigInteger recordRevision;
    @Size(max = 32)
    @Column(name = "ad_user_id")
    private String adUserId;
    @Column(name = "event_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventTime;
    @Size(max = 60)
    @Column(name = "processtype")
    private String processtype;
    @Size(max = 32)
    @Column(name = "process_id")
    private String processId;
    @Size(max = 60)
    @Column(name = "action")
    private String action;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_column_id")
    private String adColumnId;
    @Size(max = 4000)
    @Column(name = "old_char")
    private String oldChar;
    @Size(max = 4000)
    @Column(name = "new_char")
    private String newChar;
    @Size(max = 2000)
    @Column(name = "old_nchar")
    private String oldNchar;
    @Size(max = 2000)
    @Column(name = "new_nchar")
    private String newNchar;
    @Column(name = "old_number")
    private BigInteger oldNumber;
    @Column(name = "new_number")
    private BigInteger newNumber;
    @Column(name = "old_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oldDate;
    @Column(name = "new_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date newDate;

    public AdAuditTrail() {
    }

    public AdAuditTrail(String adAuditTrailId) {
        this.adAuditTrailId = adAuditTrailId;
    }

    public AdAuditTrail(String adAuditTrailId, Character isactive, String adTableId, String adColumnId) {
        this.adAuditTrailId = adAuditTrailId;
        this.isactive = isactive;
        this.adTableId = adTableId;
        this.adColumnId = adColumnId;
    }

    public String getAdAuditTrailId() {
        return adAuditTrailId;
    }

    public void setAdAuditTrailId(String adAuditTrailId) {
        this.adAuditTrailId = adAuditTrailId;
    }

    public String getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(String adClientId) {
        this.adClientId = adClientId;
    }

    public String getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(String adOrgId) {
        this.adOrgId = adOrgId;
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

    public String getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(String adTableId) {
        this.adTableId = adTableId;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public BigInteger getRecordRevision() {
        return recordRevision;
    }

    public void setRecordRevision(BigInteger recordRevision) {
        this.recordRevision = recordRevision;
    }

    public String getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(String adUserId) {
        this.adUserId = adUserId;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getProcesstype() {
        return processtype;
    }

    public void setProcesstype(String processtype) {
        this.processtype = processtype;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAdColumnId() {
        return adColumnId;
    }

    public void setAdColumnId(String adColumnId) {
        this.adColumnId = adColumnId;
    }

    public String getOldChar() {
        return oldChar;
    }

    public void setOldChar(String oldChar) {
        this.oldChar = oldChar;
    }

    public String getNewChar() {
        return newChar;
    }

    public void setNewChar(String newChar) {
        this.newChar = newChar;
    }

    public String getOldNchar() {
        return oldNchar;
    }

    public void setOldNchar(String oldNchar) {
        this.oldNchar = oldNchar;
    }

    public String getNewNchar() {
        return newNchar;
    }

    public void setNewNchar(String newNchar) {
        this.newNchar = newNchar;
    }

    public BigInteger getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(BigInteger oldNumber) {
        this.oldNumber = oldNumber;
    }

    public BigInteger getNewNumber() {
        return newNumber;
    }

    public void setNewNumber(BigInteger newNumber) {
        this.newNumber = newNumber;
    }

    public Date getOldDate() {
        return oldDate;
    }

    public void setOldDate(Date oldDate) {
        this.oldDate = oldDate;
    }

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adAuditTrailId != null ? adAuditTrailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdAuditTrail)) {
            return false;
        }
        AdAuditTrail other = (AdAuditTrail) object;
        if ((this.adAuditTrailId == null && other.adAuditTrailId != null) || (this.adAuditTrailId != null && !this.adAuditTrailId.equals(other.adAuditTrailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdAuditTrail[ adAuditTrailId=" + adAuditTrailId + " ]";
    }
    
}
