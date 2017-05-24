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
@Table(name = "c_acctschema_table_doctype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CAcctschemaTableDoctype.findAll", query = "SELECT c FROM CAcctschemaTableDoctype c"),
    @NamedQuery(name = "CAcctschemaTableDoctype.findByCAcctschemaTableDoctypeId", query = "SELECT c FROM CAcctschemaTableDoctype c WHERE c.cAcctschemaTableDoctypeId = :cAcctschemaTableDoctypeId"),
    @NamedQuery(name = "CAcctschemaTableDoctype.findByIsactive", query = "SELECT c FROM CAcctschemaTableDoctype c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CAcctschemaTableDoctype.findByCreated", query = "SELECT c FROM CAcctschemaTableDoctype c WHERE c.created = :created"),
    @NamedQuery(name = "CAcctschemaTableDoctype.findByCreatedby", query = "SELECT c FROM CAcctschemaTableDoctype c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CAcctschemaTableDoctype.findByUpdated", query = "SELECT c FROM CAcctschemaTableDoctype c WHERE c.updated = :updated"),
    @NamedQuery(name = "CAcctschemaTableDoctype.findByUpdatedby", query = "SELECT c FROM CAcctschemaTableDoctype c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CAcctschemaTableDoctype.findByAllownegative", query = "SELECT c FROM CAcctschemaTableDoctype c WHERE c.allownegative = :allownegative"),
    @NamedQuery(name = "CAcctschemaTableDoctype.findByDocbasetype", query = "SELECT c FROM CAcctschemaTableDoctype c WHERE c.docbasetype = :docbasetype")})
public class CAcctschemaTableDoctype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_acctschema_table_doctype_id")
    private String cAcctschemaTableDoctypeId;
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
    @Column(name = "allownegative")
    private Character allownegative;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "docbasetype")
    private String docbasetype;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_createfact_template_id", referencedColumnName = "ad_createfact_template_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdCreatefactTemplate adCreatefactTemplateId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_acctschema_table_id", referencedColumnName = "c_acctschema_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CAcctschemaTable cAcctschemaTableId;

    public CAcctschemaTableDoctype() {
    }

    public CAcctschemaTableDoctype(String cAcctschemaTableDoctypeId) {
        this.cAcctschemaTableDoctypeId = cAcctschemaTableDoctypeId;
    }

    public CAcctschemaTableDoctype(String cAcctschemaTableDoctypeId, Character isactive, Date created, String createdby, Date updated, String updatedby, String docbasetype) {
        this.cAcctschemaTableDoctypeId = cAcctschemaTableDoctypeId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.docbasetype = docbasetype;
    }

    public String getCAcctschemaTableDoctypeId() {
        return cAcctschemaTableDoctypeId;
    }

    public void setCAcctschemaTableDoctypeId(String cAcctschemaTableDoctypeId) {
        this.cAcctschemaTableDoctypeId = cAcctschemaTableDoctypeId;
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

    public Character getAllownegative() {
        return allownegative;
    }

    public void setAllownegative(Character allownegative) {
        this.allownegative = allownegative;
    }

    public String getDocbasetype() {
        return docbasetype;
    }

    public void setDocbasetype(String docbasetype) {
        this.docbasetype = docbasetype;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdCreatefactTemplate getAdCreatefactTemplateId() {
        return adCreatefactTemplateId;
    }

    public void setAdCreatefactTemplateId(AdCreatefactTemplate adCreatefactTemplateId) {
        this.adCreatefactTemplateId = adCreatefactTemplateId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public CAcctschemaTable getCAcctschemaTableId() {
        return cAcctschemaTableId;
    }

    public void setCAcctschemaTableId(CAcctschemaTable cAcctschemaTableId) {
        this.cAcctschemaTableId = cAcctschemaTableId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cAcctschemaTableDoctypeId != null ? cAcctschemaTableDoctypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CAcctschemaTableDoctype)) {
            return false;
        }
        CAcctschemaTableDoctype other = (CAcctschemaTableDoctype) object;
        if ((this.cAcctschemaTableDoctypeId == null && other.cAcctschemaTableDoctypeId != null) || (this.cAcctschemaTableDoctypeId != null && !this.cAcctschemaTableDoctypeId.equals(other.cAcctschemaTableDoctypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CAcctschemaTableDoctype[ cAcctschemaTableDoctypeId=" + cAcctschemaTableDoctypeId + " ]";
    }
    
}
