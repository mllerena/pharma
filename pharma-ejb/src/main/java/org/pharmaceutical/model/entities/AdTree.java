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
@Table(name = "ad_tree")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdTree.findAll", query = "SELECT a FROM AdTree a"),
    @NamedQuery(name = "AdTree.findByAdTreeId", query = "SELECT a FROM AdTree a WHERE a.adTreeId = :adTreeId"),
    @NamedQuery(name = "AdTree.findByCreated", query = "SELECT a FROM AdTree a WHERE a.created = :created"),
    @NamedQuery(name = "AdTree.findByCreatedby", query = "SELECT a FROM AdTree a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdTree.findByUpdated", query = "SELECT a FROM AdTree a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdTree.findByUpdatedby", query = "SELECT a FROM AdTree a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdTree.findByIsactive", query = "SELECT a FROM AdTree a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdTree.findByName", query = "SELECT a FROM AdTree a WHERE a.name = :name"),
    @NamedQuery(name = "AdTree.findByDescription", query = "SELECT a FROM AdTree a WHERE a.description = :description"),
    @NamedQuery(name = "AdTree.findByTreetype", query = "SELECT a FROM AdTree a WHERE a.treetype = :treetype"),
    @NamedQuery(name = "AdTree.findByIsallnodes", query = "SELECT a FROM AdTree a WHERE a.isallnodes = :isallnodes")})
public class AdTree implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_tree_id")
    private String adTreeId;
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
    @Column(name = "isactive")
    private Character isactive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "treetype")
    private String treetype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isallnodes")
    private Character isallnodes;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTreeId")
    private List<AdTreebar> adTreebarList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTreeMenuId")
    private List<AdRole> adRoleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTreeId")
    private List<AdTreenode> adTreenodeList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTreeId")
    private List<AdTreenodepr> adTreenodeprList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "add2treeId")
    private List<CElement> cElementList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "add1treeId")
    private List<CElement> cElementList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTreeId")
    private List<CElement> cElementList2;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTreeId")
    private List<AdTreenodebp> adTreenodebpList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTreeMenuId")
    private List<AdClientinfo> adClientinfoList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTreeBpartnerId")
    private List<AdClientinfo> adClientinfoList1;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTreeProductId")
    private List<AdClientinfo> adClientinfoList2;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTreeProjectId")
    private List<AdClientinfo> adClientinfoList3;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTreeOrgId")
    private List<AdClientinfo> adClientinfoList4;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTreeSalesregionId")
    private List<AdClientinfo> adClientinfoList5;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTreeCampaignId")
    private List<AdClientinfo> adClientinfoList6;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTreeId")
    private List<AdTreenodemm> adTreenodemmList;

    public AdTree() {
    }

    public AdTree(String adTreeId) {
        this.adTreeId = adTreeId;
    }

    public AdTree(String adTreeId, Date created, String createdby, Date updated, String updatedby, Character isactive, String name, String treetype, Character isallnodes) {
        this.adTreeId = adTreeId;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.isactive = isactive;
        this.name = name;
        this.treetype = treetype;
        this.isallnodes = isallnodes;
    }

    public String getAdTreeId() {
        return adTreeId;
    }

    public void setAdTreeId(String adTreeId) {
        this.adTreeId = adTreeId;
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

    public Character getIsactive() {
        return isactive;
    }

    public void setIsactive(Character isactive) {
        this.isactive = isactive;
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

    public String getTreetype() {
        return treetype;
    }

    public void setTreetype(String treetype) {
        this.treetype = treetype;
    }

    public Character getIsallnodes() {
        return isallnodes;
    }

    public void setIsallnodes(Character isallnodes) {
        this.isallnodes = isallnodes;
    }

    @XmlTransient
    public List<AdTreebar> getAdTreebarList() {
        return adTreebarList;
    }

    public void setAdTreebarList(List<AdTreebar> adTreebarList) {
        this.adTreebarList = adTreebarList;
    }

    @XmlTransient
    public List<AdRole> getAdRoleList() {
        return adRoleList;
    }

    public void setAdRoleList(List<AdRole> adRoleList) {
        this.adRoleList = adRoleList;
    }

    @XmlTransient
    public List<AdTreenode> getAdTreenodeList() {
        return adTreenodeList;
    }

    public void setAdTreenodeList(List<AdTreenode> adTreenodeList) {
        this.adTreenodeList = adTreenodeList;
    }

    @XmlTransient
    public List<AdTreenodepr> getAdTreenodeprList() {
        return adTreenodeprList;
    }

    public void setAdTreenodeprList(List<AdTreenodepr> adTreenodeprList) {
        this.adTreenodeprList = adTreenodeprList;
    }

    @XmlTransient
    public List<CElement> getCElementList() {
        return cElementList;
    }

    public void setCElementList(List<CElement> cElementList) {
        this.cElementList = cElementList;
    }

    @XmlTransient
    public List<CElement> getCElementList1() {
        return cElementList1;
    }

    public void setCElementList1(List<CElement> cElementList1) {
        this.cElementList1 = cElementList1;
    }

    @XmlTransient
    public List<CElement> getCElementList2() {
        return cElementList2;
    }

    public void setCElementList2(List<CElement> cElementList2) {
        this.cElementList2 = cElementList2;
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

    @XmlTransient
    public List<AdTreenodebp> getAdTreenodebpList() {
        return adTreenodebpList;
    }

    public void setAdTreenodebpList(List<AdTreenodebp> adTreenodebpList) {
        this.adTreenodebpList = adTreenodebpList;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList() {
        return adClientinfoList;
    }

    public void setAdClientinfoList(List<AdClientinfo> adClientinfoList) {
        this.adClientinfoList = adClientinfoList;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList1() {
        return adClientinfoList1;
    }

    public void setAdClientinfoList1(List<AdClientinfo> adClientinfoList1) {
        this.adClientinfoList1 = adClientinfoList1;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList2() {
        return adClientinfoList2;
    }

    public void setAdClientinfoList2(List<AdClientinfo> adClientinfoList2) {
        this.adClientinfoList2 = adClientinfoList2;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList3() {
        return adClientinfoList3;
    }

    public void setAdClientinfoList3(List<AdClientinfo> adClientinfoList3) {
        this.adClientinfoList3 = adClientinfoList3;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList4() {
        return adClientinfoList4;
    }

    public void setAdClientinfoList4(List<AdClientinfo> adClientinfoList4) {
        this.adClientinfoList4 = adClientinfoList4;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList5() {
        return adClientinfoList5;
    }

    public void setAdClientinfoList5(List<AdClientinfo> adClientinfoList5) {
        this.adClientinfoList5 = adClientinfoList5;
    }

    @XmlTransient
    public List<AdClientinfo> getAdClientinfoList6() {
        return adClientinfoList6;
    }

    public void setAdClientinfoList6(List<AdClientinfo> adClientinfoList6) {
        this.adClientinfoList6 = adClientinfoList6;
    }

    @XmlTransient
    public List<AdTreenodemm> getAdTreenodemmList() {
        return adTreenodemmList;
    }

    public void setAdTreenodemmList(List<AdTreenodemm> adTreenodemmList) {
        this.adTreenodemmList = adTreenodemmList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adTreeId != null ? adTreeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdTree)) {
            return false;
        }
        AdTree other = (AdTree) object;
        if ((this.adTreeId == null && other.adTreeId != null) || (this.adTreeId != null && !this.adTreeId.equals(other.adTreeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdTree[ adTreeId=" + adTreeId + " ]";
    }
    
}
