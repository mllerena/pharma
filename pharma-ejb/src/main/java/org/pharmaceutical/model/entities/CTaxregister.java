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
@Table(name = "c_taxregister")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTaxregister.findAll", query = "SELECT c FROM CTaxregister c"),
    @NamedQuery(name = "CTaxregister.findByIsactive", query = "SELECT c FROM CTaxregister c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CTaxregister.findByCreated", query = "SELECT c FROM CTaxregister c WHERE c.created = :created"),
    @NamedQuery(name = "CTaxregister.findByCreatedby", query = "SELECT c FROM CTaxregister c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CTaxregister.findByUpdated", query = "SELECT c FROM CTaxregister c WHERE c.updated = :updated"),
    @NamedQuery(name = "CTaxregister.findByUpdatedby", query = "SELECT c FROM CTaxregister c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CTaxregister.findByCTaxregisterId", query = "SELECT c FROM CTaxregister c WHERE c.cTaxregisterId = :cTaxregisterId"),
    @NamedQuery(name = "CTaxregister.findByLastregaccumamt", query = "SELECT c FROM CTaxregister c WHERE c.lastregaccumamt = :lastregaccumamt"),
    @NamedQuery(name = "CTaxregister.findByTaxtotalamt", query = "SELECT c FROM CTaxregister c WHERE c.taxtotalamt = :taxtotalamt"),
    @NamedQuery(name = "CTaxregister.findByName", query = "SELECT c FROM CTaxregister c WHERE c.name = :name"),
    @NamedQuery(name = "CTaxregister.findByPageno", query = "SELECT c FROM CTaxregister c WHERE c.pageno = :pageno")})
public class CTaxregister implements Serializable {
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
    @Column(name = "c_taxregister_id")
    private String cTaxregisterId;
    @Column(name = "lastregaccumamt")
    private BigInteger lastregaccumamt;
    @Column(name = "taxtotalamt")
    private BigInteger taxtotalamt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Column(name = "pageno")
    private Long pageno;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_taxpayment_id", referencedColumnName = "c_taxpayment_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTaxpayment cTaxpaymentId;
    @JoinColumn(name = "c_taxregister_type_id", referencedColumnName = "c_taxregister_type_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CTaxregisterType cTaxregisterTypeId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cTaxregisterId")
    private List<CTaxregisterline> cTaxregisterlineList;

    public CTaxregister() {
    }

    public CTaxregister(String cTaxregisterId) {
        this.cTaxregisterId = cTaxregisterId;
    }

    public CTaxregister(String cTaxregisterId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.cTaxregisterId = cTaxregisterId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
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

    public String getCTaxregisterId() {
        return cTaxregisterId;
    }

    public void setCTaxregisterId(String cTaxregisterId) {
        this.cTaxregisterId = cTaxregisterId;
    }

    public BigInteger getLastregaccumamt() {
        return lastregaccumamt;
    }

    public void setLastregaccumamt(BigInteger lastregaccumamt) {
        this.lastregaccumamt = lastregaccumamt;
    }

    public BigInteger getTaxtotalamt() {
        return taxtotalamt;
    }

    public void setTaxtotalamt(BigInteger taxtotalamt) {
        this.taxtotalamt = taxtotalamt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPageno() {
        return pageno;
    }

    public void setPageno(Long pageno) {
        this.pageno = pageno;
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

    public CTaxpayment getCTaxpaymentId() {
        return cTaxpaymentId;
    }

    public void setCTaxpaymentId(CTaxpayment cTaxpaymentId) {
        this.cTaxpaymentId = cTaxpaymentId;
    }

    public CTaxregisterType getCTaxregisterTypeId() {
        return cTaxregisterTypeId;
    }

    public void setCTaxregisterTypeId(CTaxregisterType cTaxregisterTypeId) {
        this.cTaxregisterTypeId = cTaxregisterTypeId;
    }

    @XmlTransient
    public List<CTaxregisterline> getCTaxregisterlineList() {
        return cTaxregisterlineList;
    }

    public void setCTaxregisterlineList(List<CTaxregisterline> cTaxregisterlineList) {
        this.cTaxregisterlineList = cTaxregisterlineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cTaxregisterId != null ? cTaxregisterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CTaxregister)) {
            return false;
        }
        CTaxregister other = (CTaxregister) object;
        if ((this.cTaxregisterId == null && other.cTaxregisterId != null) || (this.cTaxregisterId != null && !this.cTaxregisterId.equals(other.cTaxregisterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CTaxregister[ cTaxregisterId=" + cTaxregisterId + " ]";
    }
    
}
