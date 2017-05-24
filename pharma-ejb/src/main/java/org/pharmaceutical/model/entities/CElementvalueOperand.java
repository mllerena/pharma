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
@Table(name = "c_elementvalue_operand")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CElementvalueOperand.findAll", query = "SELECT c FROM CElementvalueOperand c"),
    @NamedQuery(name = "CElementvalueOperand.findByCElementvalueOperandId", query = "SELECT c FROM CElementvalueOperand c WHERE c.cElementvalueOperandId = :cElementvalueOperandId"),
    @NamedQuery(name = "CElementvalueOperand.findBySign", query = "SELECT c FROM CElementvalueOperand c WHERE c.sign = :sign"),
    @NamedQuery(name = "CElementvalueOperand.findBySeqno", query = "SELECT c FROM CElementvalueOperand c WHERE c.seqno = :seqno"),
    @NamedQuery(name = "CElementvalueOperand.findByIsactive", query = "SELECT c FROM CElementvalueOperand c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CElementvalueOperand.findByCreated", query = "SELECT c FROM CElementvalueOperand c WHERE c.created = :created"),
    @NamedQuery(name = "CElementvalueOperand.findByCreatedby", query = "SELECT c FROM CElementvalueOperand c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CElementvalueOperand.findByUpdated", query = "SELECT c FROM CElementvalueOperand c WHERE c.updated = :updated"),
    @NamedQuery(name = "CElementvalueOperand.findByUpdatedby", query = "SELECT c FROM CElementvalueOperand c WHERE c.updatedby = :updatedby")})
public class CElementvalueOperand implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_elementvalue_operand_id")
    private String cElementvalueOperandId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sign")
    private BigInteger sign;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqno")
    private BigInteger seqno;
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
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_elementvalue_id", referencedColumnName = "c_elementvalue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CElementvalue cElementvalueId;
    @JoinColumn(name = "account_id", referencedColumnName = "c_elementvalue_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private CElementvalue accountId;

    public CElementvalueOperand() {
    }

    public CElementvalueOperand(String cElementvalueOperandId) {
        this.cElementvalueOperandId = cElementvalueOperandId;
    }

    public CElementvalueOperand(String cElementvalueOperandId, BigInteger sign, BigInteger seqno, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.cElementvalueOperandId = cElementvalueOperandId;
        this.sign = sign;
        this.seqno = seqno;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getCElementvalueOperandId() {
        return cElementvalueOperandId;
    }

    public void setCElementvalueOperandId(String cElementvalueOperandId) {
        this.cElementvalueOperandId = cElementvalueOperandId;
    }

    public BigInteger getSign() {
        return sign;
    }

    public void setSign(BigInteger sign) {
        this.sign = sign;
    }

    public BigInteger getSeqno() {
        return seqno;
    }

    public void setSeqno(BigInteger seqno) {
        this.seqno = seqno;
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

    public CElementvalue getCElementvalueId() {
        return cElementvalueId;
    }

    public void setCElementvalueId(CElementvalue cElementvalueId) {
        this.cElementvalueId = cElementvalueId;
    }

    public CElementvalue getAccountId() {
        return accountId;
    }

    public void setAccountId(CElementvalue accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cElementvalueOperandId != null ? cElementvalueOperandId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CElementvalueOperand)) {
            return false;
        }
        CElementvalueOperand other = (CElementvalueOperand) object;
        if ((this.cElementvalueOperandId == null && other.cElementvalueOperandId != null) || (this.cElementvalueOperandId != null && !this.cElementvalueOperandId.equals(other.cElementvalueOperandId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CElementvalueOperand[ cElementvalueOperandId=" + cElementvalueOperandId + " ]";
    }
    
}
