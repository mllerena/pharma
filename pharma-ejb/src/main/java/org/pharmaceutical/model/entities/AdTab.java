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
import javax.persistence.FetchType;
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
@Table(name = "ad_tab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdTab.findAll", query = "SELECT a FROM AdTab a"),
    @NamedQuery(name = "AdTab.findByAdTabId", query = "SELECT a FROM AdTab a WHERE a.adTabId = :adTabId"),
    @NamedQuery(name = "AdTab.findByIsactive", query = "SELECT a FROM AdTab a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdTab.findByCreated", query = "SELECT a FROM AdTab a WHERE a.created = :created"),
    @NamedQuery(name = "AdTab.findByCreatedby", query = "SELECT a FROM AdTab a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdTab.findByUpdated", query = "SELECT a FROM AdTab a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdTab.findByUpdatedby", query = "SELECT a FROM AdTab a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdTab.findByName", query = "SELECT a FROM AdTab a WHERE a.name = :name"),
    @NamedQuery(name = "AdTab.findByDescription", query = "SELECT a FROM AdTab a WHERE a.description = :description"),
    @NamedQuery(name = "AdTab.findByHelp", query = "SELECT a FROM AdTab a WHERE a.help = :help"),
    @NamedQuery(name = "AdTab.findBySeqno", query = "SELECT a FROM AdTab a WHERE a.seqno = :seqno"),
    @NamedQuery(name = "AdTab.findByTablevel", query = "SELECT a FROM AdTab a WHERE a.tablevel = :tablevel"),
    @NamedQuery(name = "AdTab.findByIssinglerow", query = "SELECT a FROM AdTab a WHERE a.issinglerow = :issinglerow"),
    @NamedQuery(name = "AdTab.findByIsinfotab", query = "SELECT a FROM AdTab a WHERE a.isinfotab = :isinfotab"),
    @NamedQuery(name = "AdTab.findByIstranslationtab", query = "SELECT a FROM AdTab a WHERE a.istranslationtab = :istranslationtab"),
    @NamedQuery(name = "AdTab.findByIsreadonly", query = "SELECT a FROM AdTab a WHERE a.isreadonly = :isreadonly"),
    @NamedQuery(name = "AdTab.findByHastree", query = "SELECT a FROM AdTab a WHERE a.hastree = :hastree"),
    @NamedQuery(name = "AdTab.findByWhereclause", query = "SELECT a FROM AdTab a WHERE a.whereclause = :whereclause"),
    @NamedQuery(name = "AdTab.findByOrderbyclause", query = "SELECT a FROM AdTab a WHERE a.orderbyclause = :orderbyclause"),
    @NamedQuery(name = "AdTab.findByCommitwarning", query = "SELECT a FROM AdTab a WHERE a.commitwarning = :commitwarning"),
    @NamedQuery(name = "AdTab.findByProcessing", query = "SELECT a FROM AdTab a WHERE a.processing = :processing"),
    @NamedQuery(name = "AdTab.findByImportfields", query = "SELECT a FROM AdTab a WHERE a.importfields = :importfields"),
    @NamedQuery(name = "AdTab.findByIssorttab", query = "SELECT a FROM AdTab a WHERE a.issorttab = :issorttab"),
    @NamedQuery(name = "AdTab.findByFilterclause", query = "SELECT a FROM AdTab a WHERE a.filterclause = :filterclause"),
    @NamedQuery(name = "AdTab.findByUipattern", query = "SELECT a FROM AdTab a WHERE a.uipattern = :uipattern"),
    @NamedQuery(name = "AdTab.findByHqlwhereclause", query = "SELECT a FROM AdTab a WHERE a.hqlwhereclause = :hqlwhereclause"),
    @NamedQuery(name = "AdTab.findByHqlorderbyclause", query = "SELECT a FROM AdTab a WHERE a.hqlorderbyclause = :hqlorderbyclause"),
    @NamedQuery(name = "AdTab.findByHqlfilterclause", query = "SELECT a FROM AdTab a WHERE a.hqlfilterclause = :hqlfilterclause")})
public class AdTab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_tab_id")
    private String adTabId;
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
    @Size(max = 2000)
    @Column(name = "help")
    private String help;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seqno")
    private long seqno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tablevel")
    private long tablevel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issinglerow")
    private Character issinglerow;
    @Column(name = "isinfotab")
    private Character isinfotab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "istranslationtab")
    private Character istranslationtab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isreadonly")
    private Character isreadonly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hastree")
    private Character hastree;
    @Size(max = 2000)
    @Column(name = "whereclause")
    private String whereclause;
    @Size(max = 2000)
    @Column(name = "orderbyclause")
    private String orderbyclause;
    @Size(max = 2000)
    @Column(name = "commitwarning")
    private String commitwarning;
    @Column(name = "processing")
    private Character processing;
    @Column(name = "importfields")
    private Character importfields;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issorttab")
    private Character issorttab;
    @Size(max = 2000)
    @Column(name = "filterclause")
    private String filterclause;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "uipattern")
    private String uipattern;
    @Size(max = 2000)
    @Column(name = "hqlwhereclause")
    private String hqlwhereclause;
    @Size(max = 2000)
    @Column(name = "hqlorderbyclause")
    private String hqlorderbyclause;
    @Size(max = 2000)
    @Column(name = "hqlfilterclause")
    private String hqlfilterclause;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTabId")
    private List<AdModelObject> adModelObjectList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTabId")
    private List<AdAuxiliarinput> adAuxiliarinputList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_column_id", referencedColumnName = "ad_column_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdColumn adColumnId;
    @JoinColumn(name = "ad_columnsortorder_id", referencedColumnName = "ad_column_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdColumn adColumnsortorderId;
    @JoinColumn(name = "ad_columnsortyesno_id", referencedColumnName = "ad_column_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdColumn adColumnsortyesnoId;
    @JoinColumn(name = "editreference", referencedColumnName = "ad_form_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdForm editreference;
    @JoinColumn(name = "ad_image_id", referencedColumnName = "ad_image_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdImage adImageId;
    @JoinColumn(name = "ad_module_id", referencedColumnName = "ad_module_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdModule adModuleId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_process_id", referencedColumnName = "ad_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdProcess adProcessId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "includedTabId")
    private List<AdTab> adTabList;
    @JoinColumn(name = "included_tab_id", referencedColumnName = "ad_tab_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdTab includedTabId;
    @JoinColumn(name = "ad_window_id", referencedColumnName = "ad_window_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdWindow adWindowId;
    @JoinColumn(name = "ad_table_id", referencedColumnName = "ad_table_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdTable adTableId;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,mappedBy = "adTabId")
    private List<AdAlertrule> adAlertruleList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTabId")
    private List<AdTabTrl> adTabTrlList;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adTabId")
    private List<AdField> adFieldList;

    public AdTab() {
    }

    public AdTab(String adTabId) {
        this.adTabId = adTabId;
    }

    public AdTab(String adTabId, Character isactive, Date created, String createdby, Date updated, String updatedby, String name, long seqno, long tablevel, Character issinglerow, Character istranslationtab, Character isreadonly, Character hastree, Character issorttab, String uipattern) {
        this.adTabId = adTabId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
        this.name = name;
        this.seqno = seqno;
        this.tablevel = tablevel;
        this.issinglerow = issinglerow;
        this.istranslationtab = istranslationtab;
        this.isreadonly = isreadonly;
        this.hastree = hastree;
        this.issorttab = issorttab;
        this.uipattern = uipattern;
    }

    public String getAdTabId() {
        return adTabId;
    }

    public void setAdTabId(String adTabId) {
        this.adTabId = adTabId;
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

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
    }

    public long getTablevel() {
        return tablevel;
    }

    public void setTablevel(long tablevel) {
        this.tablevel = tablevel;
    }

    public Character getIssinglerow() {
        return issinglerow;
    }

    public void setIssinglerow(Character issinglerow) {
        this.issinglerow = issinglerow;
    }

    public Character getIsinfotab() {
        return isinfotab;
    }

    public void setIsinfotab(Character isinfotab) {
        this.isinfotab = isinfotab;
    }

    public Character getIstranslationtab() {
        return istranslationtab;
    }

    public void setIstranslationtab(Character istranslationtab) {
        this.istranslationtab = istranslationtab;
    }

    public Character getIsreadonly() {
        return isreadonly;
    }

    public void setIsreadonly(Character isreadonly) {
        this.isreadonly = isreadonly;
    }

    public Character getHastree() {
        return hastree;
    }

    public void setHastree(Character hastree) {
        this.hastree = hastree;
    }

    public String getWhereclause() {
        return whereclause;
    }

    public void setWhereclause(String whereclause) {
        this.whereclause = whereclause;
    }

    public String getOrderbyclause() {
        return orderbyclause;
    }

    public void setOrderbyclause(String orderbyclause) {
        this.orderbyclause = orderbyclause;
    }

    public String getCommitwarning() {
        return commitwarning;
    }

    public void setCommitwarning(String commitwarning) {
        this.commitwarning = commitwarning;
    }

    public Character getProcessing() {
        return processing;
    }

    public void setProcessing(Character processing) {
        this.processing = processing;
    }

    public Character getImportfields() {
        return importfields;
    }

    public void setImportfields(Character importfields) {
        this.importfields = importfields;
    }

    public Character getIssorttab() {
        return issorttab;
    }

    public void setIssorttab(Character issorttab) {
        this.issorttab = issorttab;
    }

    public String getFilterclause() {
        return filterclause;
    }

    public void setFilterclause(String filterclause) {
        this.filterclause = filterclause;
    }

    public String getUipattern() {
        return uipattern;
    }

    public void setUipattern(String uipattern) {
        this.uipattern = uipattern;
    }

    public String getHqlwhereclause() {
        return hqlwhereclause;
    }

    public void setHqlwhereclause(String hqlwhereclause) {
        this.hqlwhereclause = hqlwhereclause;
    }

    public String getHqlorderbyclause() {
        return hqlorderbyclause;
    }

    public void setHqlorderbyclause(String hqlorderbyclause) {
        this.hqlorderbyclause = hqlorderbyclause;
    }

    public String getHqlfilterclause() {
        return hqlfilterclause;
    }

    public void setHqlfilterclause(String hqlfilterclause) {
        this.hqlfilterclause = hqlfilterclause;
    }

    @XmlTransient
    public List<AdModelObject> getAdModelObjectList() {
        return adModelObjectList;
    }

    public void setAdModelObjectList(List<AdModelObject> adModelObjectList) {
        this.adModelObjectList = adModelObjectList;
    }

    @XmlTransient
    public List<AdAuxiliarinput> getAdAuxiliarinputList() {
        return adAuxiliarinputList;
    }

    public void setAdAuxiliarinputList(List<AdAuxiliarinput> adAuxiliarinputList) {
        this.adAuxiliarinputList = adAuxiliarinputList;
    }

    public AdClient getAdClientId() {
        return adClientId;
    }

    public void setAdClientId(AdClient adClientId) {
        this.adClientId = adClientId;
    }

    public AdColumn getAdColumnId() {
        return adColumnId;
    }

    public void setAdColumnId(AdColumn adColumnId) {
        this.adColumnId = adColumnId;
    }

    public AdColumn getAdColumnsortorderId() {
        return adColumnsortorderId;
    }

    public void setAdColumnsortorderId(AdColumn adColumnsortorderId) {
        this.adColumnsortorderId = adColumnsortorderId;
    }

    public AdColumn getAdColumnsortyesnoId() {
        return adColumnsortyesnoId;
    }

    public void setAdColumnsortyesnoId(AdColumn adColumnsortyesnoId) {
        this.adColumnsortyesnoId = adColumnsortyesnoId;
    }

    public AdForm getEditreference() {
        return editreference;
    }

    public void setEditreference(AdForm editreference) {
        this.editreference = editreference;
    }

    public AdImage getAdImageId() {
        return adImageId;
    }

    public void setAdImageId(AdImage adImageId) {
        this.adImageId = adImageId;
    }

    public AdModule getAdModuleId() {
        return adModuleId;
    }

    public void setAdModuleId(AdModule adModuleId) {
        this.adModuleId = adModuleId;
    }

    public AdOrg getAdOrgId() {
        return adOrgId;
    }

    public void setAdOrgId(AdOrg adOrgId) {
        this.adOrgId = adOrgId;
    }

    public AdProcess getAdProcessId() {
        return adProcessId;
    }

    public void setAdProcessId(AdProcess adProcessId) {
        this.adProcessId = adProcessId;
    }

    @XmlTransient
    public List<AdTab> getAdTabList() {
        return adTabList;
    }

    public void setAdTabList(List<AdTab> adTabList) {
        this.adTabList = adTabList;
    }

    public AdTab getIncludedTabId() {
        return includedTabId;
    }

    public void setIncludedTabId(AdTab includedTabId) {
        this.includedTabId = includedTabId;
    }

    public AdWindow getAdWindowId() {
        return adWindowId;
    }

    public void setAdWindowId(AdWindow adWindowId) {
        this.adWindowId = adWindowId;
    }

    public AdTable getAdTableId() {
        return adTableId;
    }

    public void setAdTableId(AdTable adTableId) {
        this.adTableId = adTableId;
    }

    @XmlTransient
    public List<AdAlertrule> getAdAlertruleList() {
        return adAlertruleList;
    }

    public void setAdAlertruleList(List<AdAlertrule> adAlertruleList) {
        this.adAlertruleList = adAlertruleList;
    }

    @XmlTransient
    public List<AdTabTrl> getAdTabTrlList() {
        return adTabTrlList;
    }

    public void setAdTabTrlList(List<AdTabTrl> adTabTrlList) {
        this.adTabTrlList = adTabTrlList;
    }

    @XmlTransient
    public List<AdField> getAdFieldList() {
        return adFieldList;
    }

    public void setAdFieldList(List<AdField> adFieldList) {
        this.adFieldList = adFieldList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adTabId != null ? adTabId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdTab)) {
            return false;
        }
        AdTab other = (AdTab) object;
        if ((this.adTabId == null && other.adTabId != null) || (this.adTabId != null && !this.adTabId.equals(other.adTabId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdTab[ adTabId=" + adTabId + " ]";
    }
    
}
