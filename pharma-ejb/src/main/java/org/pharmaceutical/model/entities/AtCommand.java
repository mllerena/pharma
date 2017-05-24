/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "at_command")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtCommand.findAll", query = "SELECT a FROM AtCommand a"),
    @NamedQuery(name = "AtCommand.findByAtCommandId", query = "SELECT a FROM AtCommand a WHERE a.atCommandId = :atCommandId"),
    @NamedQuery(name = "AtCommand.findByIsactive", query = "SELECT a FROM AtCommand a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AtCommand.findByCreated", query = "SELECT a FROM AtCommand a WHERE a.created = :created"),
    @NamedQuery(name = "AtCommand.findByCreatedby", query = "SELECT a FROM AtCommand a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AtCommand.findByUpdated", query = "SELECT a FROM AtCommand a WHERE a.updated = :updated"),
    @NamedQuery(name = "AtCommand.findByUpdatedby", query = "SELECT a FROM AtCommand a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AtCommand.findByName", query = "SELECT a FROM AtCommand a WHERE a.name = :name"),
    @NamedQuery(name = "AtCommand.findByArgno", query = "SELECT a FROM AtCommand a WHERE a.argno = :argno"),
    @NamedQuery(name = "AtCommand.findByArghelp1", query = "SELECT a FROM AtCommand a WHERE a.arghelp1 = :arghelp1"),
    @NamedQuery(name = "AtCommand.findByArghelp2", query = "SELECT a FROM AtCommand a WHERE a.arghelp2 = :arghelp2"),
    @NamedQuery(name = "AtCommand.findByArghelp3", query = "SELECT a FROM AtCommand a WHERE a.arghelp3 = :arghelp3"),
    @NamedQuery(name = "AtCommand.findByDescription", query = "SELECT a FROM AtCommand a WHERE a.description = :description"),
    @NamedQuery(name = "AtCommand.findByLineInterchange", query = "SELECT a FROM AtCommand a WHERE a.lineInterchange = :lineInterchange"),
    @NamedQuery(name = "AtCommand.findByHasPrefix", query = "SELECT a FROM AtCommand a WHERE a.hasPrefix = :hasPrefix"),
    @NamedQuery(name = "AtCommand.findByRememberWindow", query = "SELECT a FROM AtCommand a WHERE a.rememberWindow = :rememberWindow"),
    @NamedQuery(name = "AtCommand.findByRememberFrame", query = "SELECT a FROM AtCommand a WHERE a.rememberFrame = :rememberFrame"),
    @NamedQuery(name = "AtCommand.findByRememberTab", query = "SELECT a FROM AtCommand a WHERE a.rememberTab = :rememberTab"),
    @NamedQuery(name = "AtCommand.findByCheckWriteable", query = "SELECT a FROM AtCommand a WHERE a.checkWriteable = :checkWriteable"),
    @NamedQuery(name = "AtCommand.findByAssertion", query = "SELECT a FROM AtCommand a WHERE a.assertion = :assertion")})
public class AtCommand implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "at_command_id")
    private String atCommandId;
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
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "argno")
    private BigInteger argno;
    @Size(max = 60)
    @Column(name = "arghelp1")
    private String arghelp1;
    @Size(max = 60)
    @Column(name = "arghelp2")
    private String arghelp2;
    @Size(max = 60)
    @Column(name = "arghelp3")
    private String arghelp3;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "line_interchange")
    private Character lineInterchange;
    @Basic(optional = false)
    @NotNull
    @Column(name = "has_prefix")
    private Character hasPrefix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "remember_window")
    private Character rememberWindow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "remember_frame")
    private Character rememberFrame;
    @Basic(optional = false)
    @NotNull
    @Column(name = "remember_tab")
    private Character rememberTab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "check_writeable")
    private Character checkWriteable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "assertion")
    private Character assertion;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "atCommandId")
    private List<AtCommandTrl> atCommandTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "atCommandId")
    private List<AtTestdocumentline> atTestdocumentlineList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "atCommandId")
    private List<AtLine> atLineList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;

    public AtCommand() {
    }

    public AtCommand(String atCommandId) {
        this.atCommandId = atCommandId;
    }

    public AtCommand(String atCommandId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, BigInteger argno, Character lineInterchange, Character hasPrefix, Character rememberWindow, Character rememberFrame, Character rememberTab, Character checkWriteable, Character assertion) {
        this.atCommandId = atCommandId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.argno = argno;
        this.lineInterchange = lineInterchange;
        this.hasPrefix = hasPrefix;
        this.rememberWindow = rememberWindow;
        this.rememberFrame = rememberFrame;
        this.rememberTab = rememberTab;
        this.checkWriteable = checkWriteable;
        this.assertion = assertion;
    }

    public String getAtCommandId() {
        return atCommandId;
    }

    public void setAtCommandId(String atCommandId) {
        this.atCommandId = atCommandId;
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

    public BigInteger getArgno() {
        return argno;
    }

    public void setArgno(BigInteger argno) {
        this.argno = argno;
    }

    public String getArghelp1() {
        return arghelp1;
    }

    public void setArghelp1(String arghelp1) {
        this.arghelp1 = arghelp1;
    }

    public String getArghelp2() {
        return arghelp2;
    }

    public void setArghelp2(String arghelp2) {
        this.arghelp2 = arghelp2;
    }

    public String getArghelp3() {
        return arghelp3;
    }

    public void setArghelp3(String arghelp3) {
        this.arghelp3 = arghelp3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getLineInterchange() {
        return lineInterchange;
    }

    public void setLineInterchange(Character lineInterchange) {
        this.lineInterchange = lineInterchange;
    }

    public Character getHasPrefix() {
        return hasPrefix;
    }

    public void setHasPrefix(Character hasPrefix) {
        this.hasPrefix = hasPrefix;
    }

    public Character getRememberWindow() {
        return rememberWindow;
    }

    public void setRememberWindow(Character rememberWindow) {
        this.rememberWindow = rememberWindow;
    }

    public Character getRememberFrame() {
        return rememberFrame;
    }

    public void setRememberFrame(Character rememberFrame) {
        this.rememberFrame = rememberFrame;
    }

    public Character getRememberTab() {
        return rememberTab;
    }

    public void setRememberTab(Character rememberTab) {
        this.rememberTab = rememberTab;
    }

    public Character getCheckWriteable() {
        return checkWriteable;
    }

    public void setCheckWriteable(Character checkWriteable) {
        this.checkWriteable = checkWriteable;
    }

    public Character getAssertion() {
        return assertion;
    }

    public void setAssertion(Character assertion) {
        this.assertion = assertion;
    }

    @XmlTransient
    public List<AtCommandTrl> getAtCommandTrlList() {
        return atCommandTrlList;
    }

    public void setAtCommandTrlList(List<AtCommandTrl> atCommandTrlList) {
        this.atCommandTrlList = atCommandTrlList;
    }

    @XmlTransient
    public List<AtTestdocumentline> getAtTestdocumentlineList() {
        return atTestdocumentlineList;
    }

    public void setAtTestdocumentlineList(List<AtTestdocumentline> atTestdocumentlineList) {
        this.atTestdocumentlineList = atTestdocumentlineList;
    }

    @XmlTransient
    public List<AtLine> getAtLineList() {
        return atLineList;
    }

    public void setAtLineList(List<AtLine> atLineList) {
        this.atLineList = atLineList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atCommandId != null ? atCommandId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtCommand)) {
            return false;
        }
        AtCommand other = (AtCommand) object;
        if ((this.atCommandId == null && other.atCommandId != null) || (this.atCommandId != null && !this.atCommandId.equals(other.atCommandId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AtCommand[ atCommandId=" + atCommandId + " ]";
    }
    
}
