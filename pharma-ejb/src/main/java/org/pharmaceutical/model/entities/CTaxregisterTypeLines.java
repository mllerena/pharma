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
@Table(name = "c_taxregister_type_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTaxregisterTypeLines.findAll", query = "SELECT c FROM CTaxregisterTypeLines c"),
    @NamedQuery(name = "CTaxregisterTypeLines.findByIsactive", query = "SELECT c FROM CTaxregisterTypeLines c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CTaxregisterTypeLines.findByCreated", query = "SELECT c FROM CTaxregisterTypeLines c WHERE c.created = :created"),
    @NamedQuery(name = "CTaxregisterTypeLines.findByCreatedby", query = "SELECT c FROM CTaxregisterTypeLines c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CTaxregisterTypeLines.findByUpdated", query = "SELECT c FROM CTaxregisterTypeLines c WHERE c.updated = :updated"),
    @NamedQuery(name = "CTaxregisterTypeLines.findByUpdatedby", query = "SELECT c FROM CTaxregisterTypeLines c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CTaxregisterTypeLines.findByCTaxregisterTypeLinesId", query = "SELECT c FROM CTaxregisterTypeLines c WHERE c.cTaxregisterTypeLinesId = :cTaxregisterTypeLinesId")})
public class CTaxregisterTypeLines implements Serializable {
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
    @Column(name = "c_taxregister_type_lines_id")
    private String cTaxregisterTypeLinesId;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDoctype cDoctypeId;
    @JoinColumn(name = "c_tax_id", referencedColumnName = "c_tax_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTax cTaxId;
    @JoinColumn(name = "c_taxregister_type_id", referencedColumnName = "c_taxregister_type_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTaxregisterType cTaxregisterTypeId;

    public CTaxregisterTypeLines() {
    }

    public CTaxregisterTypeLines(String cTaxregisterTypeLinesId) {
        this.cTaxregisterTypeLinesId = cTaxregisterTypeLinesId;
    }

    public CTaxregisterTypeLines(String cTaxregisterTypeLinesId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cTaxregisterTypeLinesId = cTaxregisterTypeLinesId;
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

    public String getCTaxregisterTypeLinesId() {
        return cTaxregisterTypeLinesId;
    }

    public void setCTaxregisterTypeLinesId(String cTaxregisterTypeLinesId) {
        this.cTaxregisterTypeLinesId = cTaxregisterTypeLinesId;
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

    public CDoctype getCDoctypeId() {
        return cDoctypeId;
    }

    public void setCDoctypeId(CDoctype cDoctypeId) {
        this.cDoctypeId = cDoctypeId;
    }

    public CTax getCTaxId() {
        return cTaxId;
    }

    public void setCTaxId(CTax cTaxId) {
        this.cTaxId = cTaxId;
    }

    public CTaxregisterType getCTaxregisterTypeId() {
        return cTaxregisterTypeId;
    }

    public void setCTaxregisterTypeId(CTaxregisterType cTaxregisterTypeId) {
        this.cTaxregisterTypeId = cTaxregisterTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTaxregisterTypeLinesId != null ? cTaxregisterTypeLinesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTaxregisterTypeLines)) {
            return false;
        }
        CTaxregisterTypeLines other = (CTaxregisterTypeLines) object;
        if ((this.cTaxregisterTypeLinesId == null && other.cTaxregisterTypeLinesId != null) || (this.cTaxregisterTypeLinesId != null && !this.cTaxregisterTypeLinesId.equals(other.cTaxregisterTypeLinesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CTaxregisterTypeLines[ cTaxregisterTypeLinesId=" + cTaxregisterTypeLinesId + " ]";
    }
    
}