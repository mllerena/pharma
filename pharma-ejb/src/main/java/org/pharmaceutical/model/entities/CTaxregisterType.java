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
@Table(name = "c_taxregister_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTaxregisterType.findAll", query = "SELECT c FROM CTaxregisterType c"),
    @NamedQuery(name = "CTaxregisterType.findByIsactive", query = "SELECT c FROM CTaxregisterType c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CTaxregisterType.findByCreated", query = "SELECT c FROM CTaxregisterType c WHERE c.created = :created"),
    @NamedQuery(name = "CTaxregisterType.findByCreatedby", query = "SELECT c FROM CTaxregisterType c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CTaxregisterType.findByUpdated", query = "SELECT c FROM CTaxregisterType c WHERE c.updated = :updated"),
    @NamedQuery(name = "CTaxregisterType.findByUpdatedby", query = "SELECT c FROM CTaxregisterType c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CTaxregisterType.findByCTaxregisterTypeId", query = "SELECT c FROM CTaxregisterType c WHERE c.cTaxregisterTypeId = :cTaxregisterTypeId"),
    @NamedQuery(name = "CTaxregisterType.findByRegistername", query = "SELECT c FROM CTaxregisterType c WHERE c.registername = :registername"),
    @NamedQuery(name = "CTaxregisterType.findByReportname", query = "SELECT c FROM CTaxregisterType c WHERE c.reportname = :reportname"),
    @NamedQuery(name = "CTaxregisterType.findByDescription", query = "SELECT c FROM CTaxregisterType c WHERE c.description = :description"),
    @NamedQuery(name = "CTaxregisterType.findByHelp", query = "SELECT c FROM CTaxregisterType c WHERE c.help = :help"),
    @NamedQuery(name = "CTaxregisterType.findByIssotrx", query = "SELECT c FROM CTaxregisterType c WHERE c.issotrx = :issotrx")})
public class CTaxregisterType implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_taxregister_type_id")
    private String cTaxregisterTypeId;
    @Size(max = 50)
    @Column(name = "registername")
    private String registername;
    @Size(max = 50)
    @Column(name = "reportname")
    private String reportname;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "help")
    private String help;
    @Column(name = "issotrx")
    private Character issotrx;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxregisterTypeId")
    private List<CTaxregister> cTaxregisterList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxregisterTypeId")
    private List<CTaxregisterTypeLines> cTaxregisterTypeLinesList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_sequence_id", referencedColumnName = "ad_sequence_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdSequence adSequenceId;
    @JoinColumn(name = "c_glitem_id", referencedColumnName = "c_glitem_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CGlitem cGlitemId;

    public CTaxregisterType() {
    }

    public CTaxregisterType(String cTaxregisterTypeId) {
        this.cTaxregisterTypeId = cTaxregisterTypeId;
    }

    public CTaxregisterType(String cTaxregisterTypeId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cTaxregisterTypeId = cTaxregisterTypeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
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

    public String getCTaxregisterTypeId() {
        return cTaxregisterTypeId;
    }

    public void setCTaxregisterTypeId(String cTaxregisterTypeId) {
        this.cTaxregisterTypeId = cTaxregisterTypeId;
    }

    public String getRegistername() {
        return registername;
    }

    public void setRegistername(String registername) {
        this.registername = registername;
    }

    public String getReportname() {
        return reportname;
    }

    public void setReportname(String reportname) {
        this.reportname = reportname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public Character getIssotrx() {
        return issotrx;
    }

    public void setIssotrx(Character issotrx) {
        this.issotrx = issotrx;
    }

    @XmlTransient
    public List<CTaxregister> getCTaxregisterList() {
        return cTaxregisterList;
    }

    public void setCTaxregisterList(List<CTaxregister> cTaxregisterList) {
        this.cTaxregisterList = cTaxregisterList;
    }

    @XmlTransient
    public List<CTaxregisterTypeLines> getCTaxregisterTypeLinesList() {
        return cTaxregisterTypeLinesList;
    }

    public void setCTaxregisterTypeLinesList(List<CTaxregisterTypeLines> cTaxregisterTypeLinesList) {
        this.cTaxregisterTypeLinesList = cTaxregisterTypeLinesList;
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

    public AdSequence getAdSequenceId() {
        return adSequenceId;
    }

    public void setAdSequenceId(AdSequence adSequenceId) {
        this.adSequenceId = adSequenceId;
    }

    public CGlitem getCGlitemId() {
        return cGlitemId;
    }

    public void setCGlitemId(CGlitem cGlitemId) {
        this.cGlitemId = cGlitemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTaxregisterTypeId != null ? cTaxregisterTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTaxregisterType)) {
            return false;
        }
        CTaxregisterType other = (CTaxregisterType) object;
        if ((this.cTaxregisterTypeId == null && other.cTaxregisterTypeId != null) || (this.cTaxregisterTypeId != null && !this.cTaxregisterTypeId.equals(other.cTaxregisterTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CTaxregisterType[ cTaxregisterTypeId=" + cTaxregisterTypeId + " ]";
    }
    
}
