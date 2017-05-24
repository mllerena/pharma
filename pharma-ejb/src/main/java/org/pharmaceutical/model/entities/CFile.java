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
@Table(name = "c_file")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CFile.findAll", query = "SELECT c FROM CFile c"),
    @NamedQuery(name = "CFile.findByCFileId", query = "SELECT c FROM CFile c WHERE c.cFileId = :cFileId"),
    @NamedQuery(name = "CFile.findByIsactive", query = "SELECT c FROM CFile c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CFile.findByCreated", query = "SELECT c FROM CFile c WHERE c.created = :created"),
    @NamedQuery(name = "CFile.findByCreatedby", query = "SELECT c FROM CFile c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CFile.findByUpdated", query = "SELECT c FROM CFile c WHERE c.updated = :updated"),
    @NamedQuery(name = "CFile.findByUpdatedby", query = "SELECT c FROM CFile c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CFile.findByName", query = "SELECT c FROM CFile c WHERE c.name = :name"),
    @NamedQuery(name = "CFile.findByCDatatypeId", query = "SELECT c FROM CFile c WHERE c.cDatatypeId = :cDatatypeId"),
    @NamedQuery(name = "CFile.findBySeqno", query = "SELECT c FROM CFile c WHERE c.seqno = :seqno"),
    @NamedQuery(name = "CFile.findByText", query = "SELECT c FROM CFile c WHERE c.text = :text"),
    @NamedQuery(name = "CFile.findByAdRecordId", query = "SELECT c FROM CFile c WHERE c.adRecordId = :adRecordId")})
public class CFile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_file_id")
    private String cFileId;
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
    @Size(min = 1, max = 1000)
    @Column(name = "name")
    private String name;
    @Size(max = 32)
    @Column(name = "c_datatype_id")
    private String cDatatypeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqno")
    private long seqno;
    @Size(max = 2000)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_record_id")
    private String adRecordId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTable adTableId;

    public CFile() {
    }

    public CFile(String cFileId) {
        this.cFileId = cFileId;
    }

    public CFile(String cFileId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, long seqno, String adRecordId) {
        this.cFileId = cFileId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.seqno = seqno;
        this.adRecordId = adRecordId;
    }

    public String getCFileId() {
        return cFileId;
    }

    public void setCFileId(String cFileId) {
        this.cFileId = cFileId;
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

    public String getCDatatypeId() {
        return cDatatypeId;
    }

    public void setCDatatypeId(String cDatatypeId) {
        this.cDatatypeId = cDatatypeId;
    }

    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAdRecordId() {
        return adRecordId;
    }

    public void setAdRecordId(String adRecordId) {
        this.adRecordId = adRecordId;
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

    public AdTable getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(AdTable adTableId) {
        this.adTableId = adTableId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cFileId != null ? cFileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CFile)) {
            return false;
        }
        CFile other = (CFile) object;
        if ((this.cFileId == null && other.cFileId != null) || (this.cFileId != null && !this.cFileId.equals(other.cFileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CFile[ cFileId=" + cFileId + " ]";
    }
    
}
