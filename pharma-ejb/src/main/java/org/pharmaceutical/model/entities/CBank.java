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
@Table(name = "c_bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CBank.findAll", query = "SELECT c FROM CBank c"),
    @NamedQuery(name = "CBank.findByCBankId", query = "SELECT c FROM CBank c WHERE c.cBankId = :cBankId"),
    @NamedQuery(name = "CBank.findByIsactive", query = "SELECT c FROM CBank c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CBank.findByCreated", query = "SELECT c FROM CBank c WHERE c.created = :created"),
    @NamedQuery(name = "CBank.findByCreatedby", query = "SELECT c FROM CBank c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CBank.findByUpdated", query = "SELECT c FROM CBank c WHERE c.updated = :updated"),
    @NamedQuery(name = "CBank.findByUpdatedby", query = "SELECT c FROM CBank c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CBank.findByName", query = "SELECT c FROM CBank c WHERE c.name = :name"),
    @NamedQuery(name = "CBank.findByRoutingno", query = "SELECT c FROM CBank c WHERE c.routingno = :routingno"),
    @NamedQuery(name = "CBank.findBySwiftcode", query = "SELECT c FROM CBank c WHERE c.swiftcode = :swiftcode"),
    @NamedQuery(name = "CBank.findByIsownbank", query = "SELECT c FROM CBank c WHERE c.isownbank = :isownbank"),
    @NamedQuery(name = "CBank.findByCodebank", query = "SELECT c FROM CBank c WHERE c.codebank = :codebank"),
    @NamedQuery(name = "CBank.findByCodebranch", query = "SELECT c FROM CBank c WHERE c.codebranch = :codebranch"),
    @NamedQuery(name = "CBank.findByDigitcontrol", query = "SELECT c FROM CBank c WHERE c.digitcontrol = :digitcontrol"),
    @NamedQuery(name = "CBank.findByIneNumber", query = "SELECT c FROM CBank c WHERE c.ineNumber = :ineNumber")})
public class CBank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_bank_id")
    private String cBankId;
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
    @Size(max = 20)
    @Column(name = "routingno")
    private String routingno;
    @Size(max = 20)
    @Column(name = "swiftcode")
    private String swiftcode;
    @Column(name = "isownbank")
    private Character isownbank;
    @Size(max = 4)
    @Column(name = "codebank")
    private String codebank;
    @Size(max = 4)
    @Column(name = "codebranch")
    private String codebranch;
    @Size(max = 1)
    @Column(name = "digitcontrol")
    private String digitcontrol;
    @Size(max = 9)
    @Column(name = "ine_number")
    private String ineNumber;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "c_bpartner_id", referencedColumnName = "c_bpartner_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CBpartner cBpartnerId;
    @JoinColumn(name = "c_country_id", referencedColumnName = "c_country_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CCountry cCountryId;
    @JoinColumn(name = "c_location_id", referencedColumnName = "c_location_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private CLocation cLocationId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cBankId")
    private List<CBankaccount> cBankaccountList;

    public CBank() {
    }

    public CBank(String cBankId) {
        this.cBankId = cBankId;
    }

    public CBank(String cBankId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name) {
        this.cBankId = cBankId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
    }

    public String getCBankId() {
        return cBankId;
    }

    public void setCBankId(String cBankId) {
        this.cBankId = cBankId;
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

    public String getRoutingno() {
        return routingno;
    }

    public void setRoutingno(String routingno) {
        this.routingno = routingno;
    }

    public String getSwiftcode() {
        return swiftcode;
    }

    public void setSwiftcode(String swiftcode) {
        this.swiftcode = swiftcode;
    }

    public Character getIsownbank() {
        return isownbank;
    }

    public void setIsownbank(Character isownbank) {
        this.isownbank = isownbank;
    }

    public String getCodebank() {
        return codebank;
    }

    public void setCodebank(String codebank) {
        this.codebank = codebank;
    }

    public String getCodebranch() {
        return codebranch;
    }

    public void setCodebranch(String codebranch) {
        this.codebranch = codebranch;
    }

    public String getDigitcontrol() {
        return digitcontrol;
    }

    public void setDigitcontrol(String digitcontrol) {
        this.digitcontrol = digitcontrol;
    }

    public String getIneNumber() {
        return ineNumber;
    }

    public void setIneNumber(String ineNumber) {
        this.ineNumber = ineNumber;
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

    public CBpartner getCBpartnerId() {
        return cBpartnerId;
    }

    public void setCBpartnerId(CBpartner cBpartnerId) {
        this.cBpartnerId = cBpartnerId;
    }

    public CCountry getCCountryId() {
        return cCountryId;
    }

    public void setCCountryId(CCountry cCountryId) {
        this.cCountryId = cCountryId;
    }

    public CLocation getCLocationId() {
        return cLocationId;
    }

    public void setCLocationId(CLocation cLocationId) {
        this.cLocationId = cLocationId;
    }

    @XmlTransient
    public List<CBankaccount> getCBankaccountList() {
        return cBankaccountList;
    }

    public void setCBankaccountList(List<CBankaccount> cBankaccountList) {
        this.cBankaccountList = cBankaccountList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cBankId != null ? cBankId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CBank)) {
            return false;
        }
        CBank other = (CBank) object;
        if ((this.cBankId == null && other.cBankId != null) || (this.cBankId != null && !this.cBankId.equals(other.cBankId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CBank[ cBankId=" + cBankId + " ]";
    }
    
}
