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
@Table(name = "at_testdocumentline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtTestdocumentline.findAll", query = "SELECT a FROM AtTestdocumentline a"),
    @NamedQuery(name = "AtTestdocumentline.findByAtTestdocumentlineId", query = "SELECT a FROM AtTestdocumentline a WHERE a.atTestdocumentlineId = :atTestdocumentlineId"),
    @NamedQuery(name = "AtTestdocumentline.findByIsactive", query = "SELECT a FROM AtTestdocumentline a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AtTestdocumentline.findByCreated", query = "SELECT a FROM AtTestdocumentline a WHERE a.created = :created"),
    @NamedQuery(name = "AtTestdocumentline.findByCreatedby", query = "SELECT a FROM AtTestdocumentline a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AtTestdocumentline.findByUpdated", query = "SELECT a FROM AtTestdocumentline a WHERE a.updated = :updated"),
    @NamedQuery(name = "AtTestdocumentline.findByUpdatedby", query = "SELECT a FROM AtTestdocumentline a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AtTestdocumentline.findByText1", query = "SELECT a FROM AtTestdocumentline a WHERE a.text1 = :text1"),
    @NamedQuery(name = "AtTestdocumentline.findByArg1", query = "SELECT a FROM AtTestdocumentline a WHERE a.arg1 = :arg1"),
    @NamedQuery(name = "AtTestdocumentline.findByText2", query = "SELECT a FROM AtTestdocumentline a WHERE a.text2 = :text2"),
    @NamedQuery(name = "AtTestdocumentline.findByArg2", query = "SELECT a FROM AtTestdocumentline a WHERE a.arg2 = :arg2"),
    @NamedQuery(name = "AtTestdocumentline.findByText3", query = "SELECT a FROM AtTestdocumentline a WHERE a.text3 = :text3"),
    @NamedQuery(name = "AtTestdocumentline.findByArg3", query = "SELECT a FROM AtTestdocumentline a WHERE a.arg3 = :arg3"),
    @NamedQuery(name = "AtTestdocumentline.findByText4", query = "SELECT a FROM AtTestdocumentline a WHERE a.text4 = :text4"),
    @NamedQuery(name = "AtTestdocumentline.findByArgtype3", query = "SELECT a FROM AtTestdocumentline a WHERE a.argtype3 = :argtype3"),
    @NamedQuery(name = "AtTestdocumentline.findByArgtype2", query = "SELECT a FROM AtTestdocumentline a WHERE a.argtype2 = :argtype2"),
    @NamedQuery(name = "AtTestdocumentline.findByArgtype1", query = "SELECT a FROM AtTestdocumentline a WHERE a.argtype1 = :argtype1"),
    @NamedQuery(name = "AtTestdocumentline.findByAssertprefix", query = "SELECT a FROM AtTestdocumentline a WHERE a.assertprefix = :assertprefix")})
public class AtTestdocumentline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "at_testdocumentline_id")
    private String atTestdocumentlineId;
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
    @Size(max = 2000)
    @Column(name = "text1")
    private String text1;
    @Size(max = 60)
    @Column(name = "arg1")
    private String arg1;
    @Size(max = 2000)
    @Column(name = "text2")
    private String text2;
    @Size(max = 60)
    @Column(name = "arg2")
    private String arg2;
    @Size(max = 2000)
    @Column(name = "text3")
    private String text3;
    @Size(max = 60)
    @Column(name = "arg3")
    private String arg3;
    @Size(max = 2000)
    @Column(name = "text4")
    private String text4;
    @Size(max = 60)
    @Column(name = "argtype3")
    private String argtype3;
    @Size(max = 60)
    @Column(name = "argtype2")
    private String argtype2;
    @Size(max = 60)
    @Column(name = "argtype1")
    private String argtype1;
    @Size(max = 60)
    @Column(name = "assertprefix")
    private String assertprefix;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "at_command_id", referencedColumnName = "at_command_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AtCommand atCommandId;
    @JoinColumn(name = "at_testdocument_id", referencedColumnName = "at_testdocument_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AtTestdocument atTestdocumentId;

    public AtTestdocumentline() {
    }

    public AtTestdocumentline(String atTestdocumentlineId) {
        this.atTestdocumentlineId = atTestdocumentlineId;
    }

    public AtTestdocumentline(String atTestdocumentlineId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.atTestdocumentlineId = atTestdocumentlineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAtTestdocumentlineId() {
        return atTestdocumentlineId;
    }

    public void setAtTestdocumentlineId(String atTestdocumentlineId) {
        this.atTestdocumentlineId = atTestdocumentlineId;
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

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getArg3() {
        return arg3;
    }

    public void setArg3(String arg3) {
        this.arg3 = arg3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getArgtype3() {
        return argtype3;
    }

    public void setArgtype3(String argtype3) {
        this.argtype3 = argtype3;
    }

    public String getArgtype2() {
        return argtype2;
    }

    public void setArgtype2(String argtype2) {
        this.argtype2 = argtype2;
    }

    public String getArgtype1() {
        return argtype1;
    }

    public void setArgtype1(String argtype1) {
        this.argtype1 = argtype1;
    }

    public String getAssertprefix() {
        return assertprefix;
    }

    public void setAssertprefix(String assertprefix) {
        this.assertprefix = assertprefix;
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

    public AtCommand getAtCommandId() {
        return atCommandId;
    }

    public void setAtCommandId(AtCommand atCommandId) {
        this.atCommandId = atCommandId;
    }

    public AtTestdocument getAtTestdocumentId() {
        return atTestdocumentId;
    }

    public void setAtTestdocumentId(AtTestdocument atTestdocumentId) {
        this.atTestdocumentId = atTestdocumentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atTestdocumentlineId != null ? atTestdocumentlineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtTestdocumentline)) {
            return false;
        }
        AtTestdocumentline other = (AtTestdocumentline) object;
        if ((this.atTestdocumentlineId == null && other.atTestdocumentlineId != null) || (this.atTestdocumentlineId != null && !this.atTestdocumentlineId.equals(other.atTestdocumentlineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AtTestdocumentline[ atTestdocumentlineId=" + atTestdocumentlineId + " ]";
    }
    
}
