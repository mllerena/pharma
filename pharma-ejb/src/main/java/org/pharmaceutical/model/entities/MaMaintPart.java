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
@Table(name = "ma_maint_part")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaMaintPart.findAll", query = "SELECT m FROM MaMaintPart m"),
    @NamedQuery(name = "MaMaintPart.findByMaMaintPartId", query = "SELECT m FROM MaMaintPart m WHERE m.maMaintPartId = :maMaintPartId"),
    @NamedQuery(name = "MaMaintPart.findByIsactive", query = "SELECT m FROM MaMaintPart m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaMaintPart.findByCreated", query = "SELECT m FROM MaMaintPart m WHERE m.created = :created"),
    @NamedQuery(name = "MaMaintPart.findByCreatedby", query = "SELECT m FROM MaMaintPart m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaMaintPart.findByUpdated", query = "SELECT m FROM MaMaintPart m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaMaintPart.findByUpdatedby", query = "SELECT m FROM MaMaintPart m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaMaintPart.findByDocumentno", query = "SELECT m FROM MaMaintPart m WHERE m.documentno = :documentno"),
    @NamedQuery(name = "MaMaintPart.findByPartdate", query = "SELECT m FROM MaMaintPart m WHERE m.partdate = :partdate"),
    @NamedQuery(name = "MaMaintPart.findByShift", query = "SELECT m FROM MaMaintPart m WHERE m.shift = :shift"),
    @NamedQuery(name = "MaMaintPart.findByCreatemaint", query = "SELECT m FROM MaMaintPart m WHERE m.createmaint = :createmaint")})
public class MaMaintPart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_maint_part_id")
    private String maMaintPartId;
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
    @Size(min = 1, max = 30)
    @Column(name = "documentno")
    private String documentno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "partdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date partdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "shift")
    private String shift;
    @Column(name = "createmaint")
    private Character createmaint;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "maMaintPartId")
    private List<MaMaintWorker> maMaintWorkerList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "maMaintPartId")
    private List<MaMaintScheduled> maMaintScheduledList;

    public MaMaintPart() {
    }

    public MaMaintPart(String maMaintPartId) {
        this.maMaintPartId = maMaintPartId;
    }

    public MaMaintPart(String maMaintPartId, Character isactive, Date created, String createdby, Date updated, String updatedby, String documentno, Date partdate, String shift) {
        this.maMaintPartId = maMaintPartId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.documentno = documentno;
        this.partdate = partdate;
        this.shift = shift;
    }

    public String getMaMaintPartId() {
        return maMaintPartId;
    }

    public void setMaMaintPartId(String maMaintPartId) {
        this.maMaintPartId = maMaintPartId;
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

    public String getDocumentno() {
        return documentno;
    }

    public void setDocumentno(String documentno) {
        this.documentno = documentno;
    }

    public Date getPartdate() {
        return partdate;
    }

    public void setPartdate(Date partdate) {
        this.partdate = partdate;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Character getCreatemaint() {
        return createmaint;
    }

    public void setCreatemaint(Character createmaint) {
        this.createmaint = createmaint;
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
    public List<MaMaintWorker> getMaMaintWorkerList() {
        return maMaintWorkerList;
    }

    public void setMaMaintWorkerList(List<MaMaintWorker> maMaintWorkerList) {
        this.maMaintWorkerList = maMaintWorkerList;
    }

    @XmlTransient
    public List<MaMaintScheduled> getMaMaintScheduledList() {
        return maMaintScheduledList;
    }

    public void setMaMaintScheduledList(List<MaMaintScheduled> maMaintScheduledList) {
        this.maMaintScheduledList = maMaintScheduledList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMaintPartId != null ? maMaintPartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaMaintPart)) {
            return false;
        }
        MaMaintPart other = (MaMaintPart) object;
        if ((this.maMaintPartId == null && other.maMaintPartId != null) || (this.maMaintPartId != null && !this.maMaintPartId.equals(other.maMaintPartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaMaintPart[ maMaintPartId=" + maMaintPartId + " ]";
    }
    
}
