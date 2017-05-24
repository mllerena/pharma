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
@Table(name = "ma_measure_values")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaMeasureValues.findAll", query = "SELECT m FROM MaMeasureValues m"),
    @NamedQuery(name = "MaMeasureValues.findByMaMeasureValuesId", query = "SELECT m FROM MaMeasureValues m WHERE m.maMeasureValuesId = :maMeasureValuesId"),
    @NamedQuery(name = "MaMeasureValues.findByIsactive", query = "SELECT m FROM MaMeasureValues m WHERE m.isactive = :isactive"),
    @NamedQuery(name = "MaMeasureValues.findByCreated", query = "SELECT m FROM MaMeasureValues m WHERE m.created = :created"),
    @NamedQuery(name = "MaMeasureValues.findByCreatedby", query = "SELECT m FROM MaMeasureValues m WHERE m.createdby = :createdby"),
    @NamedQuery(name = "MaMeasureValues.findByUpdated", query = "SELECT m FROM MaMeasureValues m WHERE m.updated = :updated"),
    @NamedQuery(name = "MaMeasureValues.findByUpdatedby", query = "SELECT m FROM MaMeasureValues m WHERE m.updatedby = :updatedby"),
    @NamedQuery(name = "MaMeasureValues.findByValuetype", query = "SELECT m FROM MaMeasureValues m WHERE m.valuetype = :valuetype"),
    @NamedQuery(name = "MaMeasureValues.findByVString", query = "SELECT m FROM MaMeasureValues m WHERE m.vString = :vString"),
    @NamedQuery(name = "MaMeasureValues.findByVNumber", query = "SELECT m FROM MaMeasureValues m WHERE m.vNumber = :vNumber"),
    @NamedQuery(name = "MaMeasureValues.findByVChar", query = "SELECT m FROM MaMeasureValues m WHERE m.vChar = :vChar"),
    @NamedQuery(name = "MaMeasureValues.findBySeqno", query = "SELECT m FROM MaMeasureValues m WHERE m.seqno = :seqno")})
public class MaMeasureValues implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ma_measure_values_id")
    private String maMeasureValuesId;
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
    @Column(name = "valuetype")
    private String valuetype;
    @Size(max = 60)
    @Column(name = "v_string")
    private String vString;
    @Column(name = "v_number")
    private BigInteger vNumber;
    @Column(name = "v_char")
    private Character vChar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqno")
    private BigInteger seqno;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ma_ccp_id", referencedColumnName = "ma_ccp_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaCcp maCcpId;
    @JoinColumn(name = "ma_measure_time_id", referencedColumnName = "ma_measure_time_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private MaMeasureTime maMeasureTimeId;

    public MaMeasureValues() {
    }

    public MaMeasureValues(String maMeasureValuesId) {
        this.maMeasureValuesId = maMeasureValuesId;
    }

    public MaMeasureValues(String maMeasureValuesId, Character isactive, Date created, String createdby, Date updated, String updatedby, String valuetype, BigInteger seqno) {
        this.maMeasureValuesId = maMeasureValuesId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.valuetype = valuetype;
        this.seqno = seqno;
    }

    public String getMaMeasureValuesId() {
        return maMeasureValuesId;
    }

    public void setMaMeasureValuesId(String maMeasureValuesId) {
        this.maMeasureValuesId = maMeasureValuesId;
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

    public String getValuetype() {
        return valuetype;
    }

    public void setValuetype(String valuetype) {
        this.valuetype = valuetype;
    }

    public String getVString() {
        return vString;
    }

    public void setVString(String vString) {
        this.vString = vString;
    }

    public BigInteger getVNumber() {
        return vNumber;
    }

    public void setVNumber(BigInteger vNumber) {
        this.vNumber = vNumber;
    }

    public Character getVChar() {
        return vChar;
    }

    public void setVChar(Character vChar) {
        this.vChar = vChar;
    }

    public BigInteger getSeqno() {
        return seqno;
    }

    public void setSeqno(BigInteger seqno) {
        this.seqno = seqno;
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

    public MaCcp getMaCcpId() {
        return maCcpId;
    }

    public void setMaCcpId(MaCcp maCcpId) {
        this.maCcpId = maCcpId;
    }

    public MaMeasureTime getMaMeasureTimeId() {
        return maMeasureTimeId;
    }

    public void setMaMeasureTimeId(MaMeasureTime maMeasureTimeId) {
        this.maMeasureTimeId = maMeasureTimeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maMeasureValuesId != null ? maMeasureValuesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaMeasureValues)) {
            return false;
        }
        MaMeasureValues other = (MaMeasureValues) object;
        if ((this.maMeasureValuesId == null && other.maMeasureValuesId != null) || (this.maMeasureValuesId != null && !this.maMeasureValuesId.equals(other.maMeasureValuesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.MaMeasureValues[ maMeasureValuesId=" + maMeasureValuesId + " ]";
    }
    
}
