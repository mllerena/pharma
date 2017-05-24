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
@Table(name = "c_poc_doctype_template")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CPocDoctypeTemplate.findAll", query = "SELECT c FROM CPocDoctypeTemplate c"),
    @NamedQuery(name = "CPocDoctypeTemplate.findByCPocDoctypeTemplateId", query = "SELECT c FROM CPocDoctypeTemplate c WHERE c.cPocDoctypeTemplateId = :cPocDoctypeTemplateId"),
    @NamedQuery(name = "CPocDoctypeTemplate.findByIsactive", query = "SELECT c FROM CPocDoctypeTemplate c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CPocDoctypeTemplate.findByCreated", query = "SELECT c FROM CPocDoctypeTemplate c WHERE c.created = :created"),
    @NamedQuery(name = "CPocDoctypeTemplate.findByCreatedby", query = "SELECT c FROM CPocDoctypeTemplate c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CPocDoctypeTemplate.findByUpdated", query = "SELECT c FROM CPocDoctypeTemplate c WHERE c.updated = :updated"),
    @NamedQuery(name = "CPocDoctypeTemplate.findByUpdatedby", query = "SELECT c FROM CPocDoctypeTemplate c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CPocDoctypeTemplate.findByName", query = "SELECT c FROM CPocDoctypeTemplate c WHERE c.name = :name"),
    @NamedQuery(name = "CPocDoctypeTemplate.findByTemplatelocation", query = "SELECT c FROM CPocDoctypeTemplate c WHERE c.templatelocation = :templatelocation"),
    @NamedQuery(name = "CPocDoctypeTemplate.findByReportfilename", query = "SELECT c FROM CPocDoctypeTemplate c WHERE c.reportfilename = :reportfilename"),
    @NamedQuery(name = "CPocDoctypeTemplate.findByTemplatefilename", query = "SELECT c FROM CPocDoctypeTemplate c WHERE c.templatefilename = :templatefilename"),
    @NamedQuery(name = "CPocDoctypeTemplate.findByShowcompanydata", query = "SELECT c FROM CPocDoctypeTemplate c WHERE c.showcompanydata = :showcompanydata"),
    @NamedQuery(name = "CPocDoctypeTemplate.findByShowlogo", query = "SELECT c FROM CPocDoctypeTemplate c WHERE c.showlogo = :showlogo"),
    @NamedQuery(name = "CPocDoctypeTemplate.findByHeadermargin", query = "SELECT c FROM CPocDoctypeTemplate c WHERE c.headermargin = :headermargin")})
public class CPocDoctypeTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_poc_doctype_template_id")
    private String cPocDoctypeTemplateId;
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
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "templatelocation")
    private String templatelocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "reportfilename")
    private String reportfilename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "templatefilename")
    private String templatefilename;
    @Basic(optional = false)
    @NotNull
    @Column(name = "showcompanydata")
    private Character showcompanydata;
    @Basic(optional = false)
    @NotNull
    @Column(name = "showlogo")
    private Character showlogo;
    @Size(max = 60)
    @Column(name = "headermargin")
    private String headermargin;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cPocDoctypeTemplateId")
    private List<CPocEmaildefinition> cPocEmaildefinitionList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_doctype_id", referencedColumnName = "c_doctype_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CDoctype cDoctypeId;

    public CPocDoctypeTemplate() {
    }

    public CPocDoctypeTemplate(String cPocDoctypeTemplateId) {
        this.cPocDoctypeTemplateId = cPocDoctypeTemplateId;
    }

    public CPocDoctypeTemplate(String cPocDoctypeTemplateId, Character isactive, Date created, String createdby, Date updated, String updatedby, String templatelocation, String reportfilename, String templatefilename, Character showcompanydata, Character showlogo) {
        this.cPocDoctypeTemplateId = cPocDoctypeTemplateId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.templatelocation = templatelocation;
        this.reportfilename = reportfilename;
        this.templatefilename = templatefilename;
        this.showcompanydata = showcompanydata;
        this.showlogo = showlogo;
    }

    public String getCPocDoctypeTemplateId() {
        return cPocDoctypeTemplateId;
    }

    public void setCPocDoctypeTemplateId(String cPocDoctypeTemplateId) {
        this.cPocDoctypeTemplateId = cPocDoctypeTemplateId;
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

    public String getTemplatelocation() {
        return templatelocation;
    }

    public void setTemplatelocation(String templatelocation) {
        this.templatelocation = templatelocation;
    }

    public String getReportfilename() {
        return reportfilename;
    }

    public void setReportfilename(String reportfilename) {
        this.reportfilename = reportfilename;
    }

    public String getTemplatefilename() {
        return templatefilename;
    }

    public void setTemplatefilename(String templatefilename) {
        this.templatefilename = templatefilename;
    }

    public Character getShowcompanydata() {
        return showcompanydata;
    }

    public void setShowcompanydata(Character showcompanydata) {
        this.showcompanydata = showcompanydata;
    }

    public Character getShowlogo() {
        return showlogo;
    }

    public void setShowlogo(Character showlogo) {
        this.showlogo = showlogo;
    }

    public String getHeadermargin() {
        return headermargin;
    }

    public void setHeadermargin(String headermargin) {
        this.headermargin = headermargin;
    }

    @XmlTransient
    public List<CPocEmaildefinition> getCPocEmaildefinitionList() {
        return cPocEmaildefinitionList;
    }

    public void setCPocEmaildefinitionList(List<CPocEmaildefinition> cPocEmaildefinitionList) {
        this.cPocEmaildefinitionList = cPocEmaildefinitionList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cPocDoctypeTemplateId != null ? cPocDoctypeTemplateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CPocDoctypeTemplate)) {
            return false;
        }
        CPocDoctypeTemplate other = (CPocDoctypeTemplate) object;
        if ((this.cPocDoctypeTemplateId == null && other.cPocDoctypeTemplateId != null) || (this.cPocDoctypeTemplateId != null && !this.cPocDoctypeTemplateId.equals(other.cPocDoctypeTemplateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CPocDoctypeTemplate[ cPocDoctypeTemplateId=" + cPocDoctypeTemplateId + " ]";
    }
    
}
