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
@Table(name = "ad_impformat_row")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdImpformatRow.findAll", query = "SELECT a FROM AdImpformatRow a"),
    @NamedQuery(name = "AdImpformatRow.findByAdImpformatRowId", query = "SELECT a FROM AdImpformatRow a WHERE a.adImpformatRowId = :adImpformatRowId"),
    @NamedQuery(name = "AdImpformatRow.findByIsactive", query = "SELECT a FROM AdImpformatRow a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdImpformatRow.findByCreated", query = "SELECT a FROM AdImpformatRow a WHERE a.created = :created"),
    @NamedQuery(name = "AdImpformatRow.findByCreatedby", query = "SELECT a FROM AdImpformatRow a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdImpformatRow.findByUpdated", query = "SELECT a FROM AdImpformatRow a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdImpformatRow.findByUpdatedby", query = "SELECT a FROM AdImpformatRow a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdImpformatRow.findBySeqno", query = "SELECT a FROM AdImpformatRow a WHERE a.seqno = :seqno"),
    @NamedQuery(name = "AdImpformatRow.findByName", query = "SELECT a FROM AdImpformatRow a WHERE a.name = :name"),
    @NamedQuery(name = "AdImpformatRow.findByStartno", query = "SELECT a FROM AdImpformatRow a WHERE a.startno = :startno"),
    @NamedQuery(name = "AdImpformatRow.findByEndno", query = "SELECT a FROM AdImpformatRow a WHERE a.endno = :endno"),
    @NamedQuery(name = "AdImpformatRow.findByDatatype", query = "SELECT a FROM AdImpformatRow a WHERE a.datatype = :datatype"),
    @NamedQuery(name = "AdImpformatRow.findByDataformat", query = "SELECT a FROM AdImpformatRow a WHERE a.dataformat = :dataformat"),
    @NamedQuery(name = "AdImpformatRow.findByDecimalpoint", query = "SELECT a FROM AdImpformatRow a WHERE a.decimalpoint = :decimalpoint"),
    @NamedQuery(name = "AdImpformatRow.findByDivideby100", query = "SELECT a FROM AdImpformatRow a WHERE a.divideby100 = :divideby100"),
    @NamedQuery(name = "AdImpformatRow.findByConstantvalue", query = "SELECT a FROM AdImpformatRow a WHERE a.constantvalue = :constantvalue"),
    @NamedQuery(name = "AdImpformatRow.findByCallout", query = "SELECT a FROM AdImpformatRow a WHERE a.callout = :callout"),
    @NamedQuery(name = "AdImpformatRow.findByScript", query = "SELECT a FROM AdImpformatRow a WHERE a.script = :script")})
public class AdImpformatRow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_impformat_row_id")
    private String adImpformatRowId;
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
    @Column(name = "seqno")
    private long seqno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Column(name = "startno")
    private Long startno;
    @Column(name = "endno")
    private Long endno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "datatype")
    private String datatype;
    @Size(max = 20)
    @Column(name = "dataformat")
    private String dataformat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "decimalpoint")
    private Character decimalpoint;
    @Basic(optional = false)
    @NotNull
    @Column(name = "divideby100")
    private Character divideby100;
    @Size(max = 60)
    @Column(name = "constantvalue")
    private String constantvalue;
    @Size(max = 60)
    @Column(name = "callout")
    private String callout;
    @Size(max = 2000)
    @Column(name = "script")
    private String script;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_column_id", referencedColumnName = "ad_column_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdColumn adColumnId;
    @JoinColumn(name = "ad_impformat_id", referencedColumnName = "ad_impformat_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdImpformat adImpformatId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AdImpformatRow() {
    }

    public AdImpformatRow(String adImpformatRowId) {
        this.adImpformatRowId = adImpformatRowId;
    }

    public AdImpformatRow(String adImpformatRowId, Character isactive, Date created, String createdby, Date updated, String updatedby, long seqno, String name, String datatype, Character decimalpoint, Character divideby100) {
        this.adImpformatRowId = adImpformatRowId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.seqno = seqno;
        this.name = name;
        this.datatype = datatype;
        this.decimalpoint = decimalpoint;
        this.divideby100 = divideby100;
    }

    public String getAdImpformatRowId() {
        return adImpformatRowId;
    }

    public void setAdImpformatRowId(String adImpformatRowId) {
        this.adImpformatRowId = adImpformatRowId;
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

    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStartno() {
        return startno;
    }

    public void setStartno(Long startno) {
        this.startno = startno;
    }

    public Long getEndno() {
        return endno;
    }

    public void setEndno(Long endno) {
        this.endno = endno;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getDataformat() {
        return dataformat;
    }

    public void setDataformat(String dataformat) {
        this.dataformat = dataformat;
    }

    public Character getDecimalpoint() {
        return decimalpoint;
    }

    public void setDecimalpoint(Character decimalpoint) {
        this.decimalpoint = decimalpoint;
    }

    public Character getDivideby100() {
        return divideby100;
    }

    public void setDivideby100(Character divideby100) {
        this.divideby100 = divideby100;
    }

    public String getConstantvalue() {
        return constantvalue;
    }

    public void setConstantvalue(String constantvalue) {
        this.constantvalue = constantvalue;
    }

    public String getCallout() {
        return callout;
    }

    public void setCallout(String callout) {
        this.callout = callout;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdColumn getAdColumnId() {
        return adColumnId;
    }

    public void setAdColumnId(AdColumn adColumnId) {
        this.adColumnId = adColumnId;
    }

    public AdImpformat getAdImpformatId() {
        return adImpformatId;
    }

    public void setAdImpformatId(AdImpformat adImpformatId) {
        this.adImpformatId = adImpformatId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adImpformatRowId != null ? adImpformatRowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdImpformatRow)) {
            return false;
        }
        AdImpformatRow other = (AdImpformatRow) object;
        if ((this.adImpformatRowId == null && other.adImpformatRowId != null) || (this.adImpformatRowId != null && !this.adImpformatRowId.equals(other.adImpformatRowId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdImpformatRow[ adImpformatRowId=" + adImpformatRowId + " ]";
    }
    
}
