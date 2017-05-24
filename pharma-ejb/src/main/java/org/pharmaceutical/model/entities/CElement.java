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
@Table(name = "c_element")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CElement.findAll", query = "SELECT c FROM CElement c"),
    @NamedQuery(name = "CElement.findByCElementId", query = "SELECT c FROM CElement c WHERE c.cElementId = :cElementId"),
    @NamedQuery(name = "CElement.findByIsactive", query = "SELECT c FROM CElement c WHERE c.isactive = :isactive"),
    @NamedQuery(name = "CElement.findByCreated", query = "SELECT c FROM CElement c WHERE c.created = :created"),
    @NamedQuery(name = "CElement.findByCreatedby", query = "SELECT c FROM CElement c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "CElement.findByUpdated", query = "SELECT c FROM CElement c WHERE c.updated = :updated"),
    @NamedQuery(name = "CElement.findByUpdatedby", query = "SELECT c FROM CElement c WHERE c.updatedby = :updatedby"),
    @NamedQuery(name = "CElement.findByName", query = "SELECT c FROM CElement c WHERE c.name = :name"),
    @NamedQuery(name = "CElement.findByDescription", query = "SELECT c FROM CElement c WHERE c.description = :description"),
    @NamedQuery(name = "CElement.findByVformat", query = "SELECT c FROM CElement c WHERE c.vformat = :vformat"),
    @NamedQuery(name = "CElement.findByElementtype", query = "SELECT c FROM CElement c WHERE c.elementtype = :elementtype"),
    @NamedQuery(name = "CElement.findByIsbalancing", query = "SELECT c FROM CElement c WHERE c.isbalancing = :isbalancing"),
    @NamedQuery(name = "CElement.findByIsnaturalaccount", query = "SELECT c FROM CElement c WHERE c.isnaturalaccount = :isnaturalaccount")})
public class CElement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "c_element_id")
    private String cElementId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 40)
    @Column(name = "vformat")
    private String vformat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "elementtype")
    private String elementtype;
    @Column(name = "isbalancing")
    private Character isbalancing;
    @Column(name = "isnaturalaccount")
    private Character isnaturalaccount;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "cElementId")
    private List<CElementvalue> cElementvalueList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "add2tree_id", referencedColumnName = "ad_tree_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTree add2treeId;
    @JoinColumn(name = "add1tree_id", referencedColumnName = "ad_tree_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTree add1treeId;
    @JoinColumn(name = "ad_tree_id", referencedColumnName = "ad_tree_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTree adTreeId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cElementId")
    private List<IElementvalue> iElementvalueList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "cElementId")
    private List<CAcctschemaElement> cAcctschemaElementList;

    public CElement() {
    }

    public CElement(String cElementId) {
        this.cElementId = cElementId;
    }

    public CElement(String cElementId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, String elementtype) {
        this.cElementId = cElementId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.elementtype = elementtype;
    }

    public String getCElementId() {
        return cElementId;
    }

    public void setCElementId(String cElementId) {
        this.cElementId = cElementId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVformat() {
        return vformat;
    }

    public void setVformat(String vformat) {
        this.vformat = vformat;
    }

    public String getElementtype() {
        return elementtype;
    }

    public void setElementtype(String elementtype) {
        this.elementtype = elementtype;
    }

    public Character getIsbalancing() {
        return isbalancing;
    }

    public void setIsbalancing(Character isbalancing) {
        this.isbalancing = isbalancing;
    }

    public Character getIsnaturalaccount() {
        return isnaturalaccount;
    }

    public void setIsnaturalaccount(Character isnaturalaccount) {
        this.isnaturalaccount = isnaturalaccount;
    }

    @XmlTransient
    public List<CElementvalue> getCElementvalueList() {
        return cElementvalueList;
    }

    public void setCElementvalueList(List<CElementvalue> cElementvalueList) {
        this.cElementvalueList = cElementvalueList;
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

    public AdTree getAdd2treeId() {
        return add2treeId;
    }

    public void setAdd2treeId(AdTree add2treeId) {
        this.add2treeId = add2treeId;
    }

    public AdTree getAdd1treeId() {
        return add1treeId;
    }

    public void setAdd1treeId(AdTree add1treeId) {
        this.add1treeId = add1treeId;
    }

    public AdTree getAdTreeId() {
        return adTreeId;
    }

    public void setAdTreeId(AdTree adTreeId) {
        this.adTreeId = adTreeId;
    }

    @XmlTransient
    public List<IElementvalue> getIElementvalueList() {
        return iElementvalueList;
    }

    public void setIElementvalueList(List<IElementvalue> iElementvalueList) {
        this.iElementvalueList = iElementvalueList;
    }

    @XmlTransient
    public List<CAcctschemaElement> getCAcctschemaElementList() {
        return cAcctschemaElementList;
    }

    public void setCAcctschemaElementList(List<CAcctschemaElement> cAcctschemaElementList) {
        this.cAcctschemaElementList = cAcctschemaElementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cElementId != null ? cElementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CElement)) {
            return false;
        }
        CElement other = (CElement) object;
        if ((this.cElementId == null && other.cElementId != null) || (this.cElementId != null && !this.cElementId.equals(other.cElementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.CElement[ cElementId=" + cElementId + " ]";
    }
    
}
