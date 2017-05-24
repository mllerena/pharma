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
@Table(name = "c_poc_emaildefinition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CPocEmaildefinition.findAll", query = "SELECT c FROM CPocEmaildefinition c"),
    @NamedQuery(name = "CPocEmaildefinition.findByCPocEmaildefinitionId", query = "SELECT c FROM CPocEmaildefinition c WHERE c.cPocEmaildefinitionId = :cPocEmaildefinitionId"),
    @NamedQuery(name = "CPocEmaildefinition.findByIsactive", query = "SELECT c FROM CPocEmaildefinition c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CPocEmaildefinition.findByCreated", query = "SELECT c FROM CPocEmaildefinition c WHERE c.created = :created"),
    @NamedQuery(name = "CPocEmaildefinition.findByCreatedby", query = "SELECT c FROM CPocEmaildefinition c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CPocEmaildefinition.findByUpdated", query = "SELECT c FROM CPocEmaildefinition c WHERE c.updated = :updated"),
    @NamedQuery(name = "CPocEmaildefinition.findByUpdatedby", query = "SELECT c FROM CPocEmaildefinition c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CPocEmaildefinition.findBySubject", query = "SELECT c FROM CPocEmaildefinition c WHERE c.subject = :subject"),
    @NamedQuery(name = "CPocEmaildefinition.findByBody", query = "SELECT c FROM CPocEmaildefinition c WHERE c.body = :body"),
    @NamedQuery(name = "CPocEmaildefinition.findByIsdefault", query = "SELECT c FROM CPocEmaildefinition c WHERE c.isdefault = :isdefault")})
public class CPocEmaildefinition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_poc_emaildefinition_id")
    private String cPocEmaildefinitionId;
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
    @Size(max = 500)
    @Column(name = "subject")
    private String subject;
    @Size(max = 4000)
    @Column(name = "body")
    private String body;
    @Column(name = "isdefault")
    private Character isdefault;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_language", referencedColumnName = "ad_language")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdLanguage adLanguage;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_poc_doctype_template_id", referencedColumnName = "c_poc_doctype_template_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CPocDoctypeTemplate cPocDoctypeTemplateId;

    public CPocEmaildefinition() {
    }

    public CPocEmaildefinition(String cPocEmaildefinitionId) {
        this.cPocEmaildefinitionId = cPocEmaildefinitionId;
    }

    public CPocEmaildefinition(String cPocEmaildefinitionId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cPocEmaildefinitionId = cPocEmaildefinitionId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCPocEmaildefinitionId() {
        return cPocEmaildefinitionId;
    }

    public void setCPocEmaildefinitionId(String cPocEmaildefinitionId) {
        this.cPocEmaildefinitionId = cPocEmaildefinitionId;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Character getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Character isdefault) {
        this.isdefault = isdefault;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdLanguage getAdLanguage() {
        return adLanguage;
    }

    public void setAdLanguage(AdLanguage adLanguage) {
        this.adLanguage = adLanguage;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public CPocDoctypeTemplate getCPocDoctypeTemplateId() {
        return cPocDoctypeTemplateId;
    }

    public void setCPocDoctypeTemplateId(CPocDoctypeTemplate cPocDoctypeTemplateId) {
        this.cPocDoctypeTemplateId = cPocDoctypeTemplateId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cPocEmaildefinitionId != null ? cPocEmaildefinitionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CPocEmaildefinition)) {
            return false;
        }
        CPocEmaildefinition other = (CPocEmaildefinition) object;
        if ((this.cPocEmaildefinitionId == null && other.cPocEmaildefinitionId != null) || (this.cPocEmaildefinitionId != null && !this.cPocEmaildefinitionId.equals(other.cPocEmaildefinitionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CPocEmaildefinition[ cPocEmaildefinitionId=" + cPocEmaildefinitionId + " ]";
    }
    
}
