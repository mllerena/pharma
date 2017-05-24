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
@Table(name = "at_line")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AtLine.findAll", query = "SELECT a FROM AtLine a"),
    @NamedQuery(name = "AtLine.findByAtLineId", query = "SELECT a FROM AtLine a WHERE a.atLineId = :atLineId"),
    @NamedQuery(name = "AtLine.findByIsactive", query = "SELECT a FROM AtLine a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AtLine.findByCreated", query = "SELECT a FROM AtLine a WHERE a.created = :created"),
    @NamedQuery(name = "AtLine.findByCreatedby", query = "SELECT a FROM AtLine a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AtLine.findByUpdated", query = "SELECT a FROM AtLine a WHERE a.updated = :updated"),
    @NamedQuery(name = "AtLine.findByUpdatedby", query = "SELECT a FROM AtLine a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AtLine.findBySeqno", query = "SELECT a FROM AtLine a WHERE a.seqno = :seqno"),
    @NamedQuery(name = "AtLine.findByArg1", query = "SELECT a FROM AtLine a WHERE a.arg1 = :arg1"),
    @NamedQuery(name = "AtLine.findByArg2", query = "SELECT a FROM AtLine a WHERE a.arg2 = :arg2"),
    @NamedQuery(name = "AtLine.findByArg3", query = "SELECT a FROM AtLine a WHERE a.arg3 = :arg3"),
    @NamedQuery(name = "AtLine.findByType", query = "SELECT a FROM AtLine a WHERE a.type = :type"),
    @NamedQuery(name = "AtLine.findByArgno", query = "SELECT a FROM AtLine a WHERE a.argno = :argno"),
    @NamedQuery(name = "AtLine.findByArghelp1", query = "SELECT a FROM AtLine a WHERE a.arghelp1 = :arghelp1"),
    @NamedQuery(name = "AtLine.findByArghelp2", query = "SELECT a FROM AtLine a WHERE a.arghelp2 = :arghelp2"),
    @NamedQuery(name = "AtLine.findByArghelp3", query = "SELECT a FROM AtLine a WHERE a.arghelp3 = :arghelp3")})
public class AtLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "at_line_id")
    private String atLineId;
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
    @Size(max = 2000)
    @Column(name = "arg1")
    private String arg1;
    @Size(max = 2000)
    @Column(name = "arg2")
    private String arg2;
    @Size(max = 2000)
    @Column(name = "arg3")
    private String arg3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "type")
    private String type;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "at_command_id", referencedColumnName = "at_command_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AtCommand atCommandId;
    @JoinColumn(name = "at_test_id", referencedColumnName = "at_test_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AtTest atTestId;
    @JoinColumn(name = "child_test", referencedColumnName = "at_test_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AtTest childTest;

    public AtLine() {
    }

    public AtLine(String atLineId) {
        this.atLineId = atLineId;
    }

    public AtLine(String atLineId, Character isactive, Date created, String createdby, Date updated, String updatedby, long seqno, String type) {
        this.atLineId = atLineId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.seqno = seqno;
        this.type = type;
    }

    public String getAtLineId() {
        return atLineId;
    }

    public void setAtLineId(String atLineId) {
        this.atLineId = atLineId;
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

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public String getArg3() {
        return arg3;
    }

    public void setArg3(String arg3) {
        this.arg3 = arg3;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public AtTest getAtTestId() {
        return atTestId;
    }

    public void setAtTestId(AtTest atTestId) {
        this.atTestId = atTestId;
    }

    public AtTest getChildTest() {
        return childTest;
    }

    public void setChildTest(AtTest childTest) {
        this.childTest = childTest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atLineId != null ? atLineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtLine)) {
            return false;
        }
        AtLine other = (AtLine) object;
        if ((this.atLineId == null && other.atLineId != null) || (this.atLineId != null && !this.atLineId.equals(other.atLineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AtLine[ atLineId=" + atLineId + " ]";
    }
    
}
