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
@Table(name = "ad_process_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdProcessRequest.findAll", query = "SELECT a FROM AdProcessRequest a"),
    @NamedQuery(name = "AdProcessRequest.findByAdProcessRequestId", query = "SELECT a FROM AdProcessRequest a WHERE a.adProcessRequestId = :adProcessRequestId"),
    @NamedQuery(name = "AdProcessRequest.findByIsactive", query = "SELECT a FROM AdProcessRequest a WHERE a.isactive = :isactive"),
    @NamedQuery(name = "AdProcessRequest.findByCreated", query = "SELECT a FROM AdProcessRequest a WHERE a.created = :created"),
    @NamedQuery(name = "AdProcessRequest.findByCreatedby", query = "SELECT a FROM AdProcessRequest a WHERE a.createdby = :createdby"),
    @NamedQuery(name = "AdProcessRequest.findByUpdated", query = "SELECT a FROM AdProcessRequest a WHERE a.updated = :updated"),
    @NamedQuery(name = "AdProcessRequest.findByUpdatedby", query = "SELECT a FROM AdProcessRequest a WHERE a.updatedby = :updatedby"),
    @NamedQuery(name = "AdProcessRequest.findByDescription", query = "SELECT a FROM AdProcessRequest a WHERE a.description = :description"),
    @NamedQuery(name = "AdProcessRequest.findByIsrolesecurity", query = "SELECT a FROM AdProcessRequest a WHERE a.isrolesecurity = :isrolesecurity"),
    @NamedQuery(name = "AdProcessRequest.findByObContext", query = "SELECT a FROM AdProcessRequest a WHERE a.obContext = :obContext"),
    @NamedQuery(name = "AdProcessRequest.findByStatus", query = "SELECT a FROM AdProcessRequest a WHERE a.status = :status"),
    @NamedQuery(name = "AdProcessRequest.findByNextFireTime", query = "SELECT a FROM AdProcessRequest a WHERE a.nextFireTime = :nextFireTime"),
    @NamedQuery(name = "AdProcessRequest.findByPreviousFireTime", query = "SELECT a FROM AdProcessRequest a WHERE a.previousFireTime = :previousFireTime"),
    @NamedQuery(name = "AdProcessRequest.findByScheduledFinish", query = "SELECT a FROM AdProcessRequest a WHERE a.scheduledFinish = :scheduledFinish"),
    @NamedQuery(name = "AdProcessRequest.findByChannel", query = "SELECT a FROM AdProcessRequest a WHERE a.channel = :channel"),
    @NamedQuery(name = "AdProcessRequest.findByTimingOption", query = "SELECT a FROM AdProcessRequest a WHERE a.timingOption = :timingOption"),
    @NamedQuery(name = "AdProcessRequest.findByStartTime", query = "SELECT a FROM AdProcessRequest a WHERE a.startTime = :startTime"),
    @NamedQuery(name = "AdProcessRequest.findByStartDate", query = "SELECT a FROM AdProcessRequest a WHERE a.startDate = :startDate"),
    @NamedQuery(name = "AdProcessRequest.findByFrequency", query = "SELECT a FROM AdProcessRequest a WHERE a.frequency = :frequency"),
    @NamedQuery(name = "AdProcessRequest.findBySecondlyInterval", query = "SELECT a FROM AdProcessRequest a WHERE a.secondlyInterval = :secondlyInterval"),
    @NamedQuery(name = "AdProcessRequest.findByMinutelyInterval", query = "SELECT a FROM AdProcessRequest a WHERE a.minutelyInterval = :minutelyInterval"),
    @NamedQuery(name = "AdProcessRequest.findByHourlyInterval", query = "SELECT a FROM AdProcessRequest a WHERE a.hourlyInterval = :hourlyInterval"),
    @NamedQuery(name = "AdProcessRequest.findByDailyInterval", query = "SELECT a FROM AdProcessRequest a WHERE a.dailyInterval = :dailyInterval"),
    @NamedQuery(name = "AdProcessRequest.findBySecondlyRepetitions", query = "SELECT a FROM AdProcessRequest a WHERE a.secondlyRepetitions = :secondlyRepetitions"),
    @NamedQuery(name = "AdProcessRequest.findByMinutelyRepetitions", query = "SELECT a FROM AdProcessRequest a WHERE a.minutelyRepetitions = :minutelyRepetitions"),
    @NamedQuery(name = "AdProcessRequest.findByHourlyRepetitions", query = "SELECT a FROM AdProcessRequest a WHERE a.hourlyRepetitions = :hourlyRepetitions"),
    @NamedQuery(name = "AdProcessRequest.findByDayMon", query = "SELECT a FROM AdProcessRequest a WHERE a.dayMon = :dayMon"),
    @NamedQuery(name = "AdProcessRequest.findByDayTue", query = "SELECT a FROM AdProcessRequest a WHERE a.dayTue = :dayTue"),
    @NamedQuery(name = "AdProcessRequest.findByDayWed", query = "SELECT a FROM AdProcessRequest a WHERE a.dayWed = :dayWed"),
    @NamedQuery(name = "AdProcessRequest.findByDayThu", query = "SELECT a FROM AdProcessRequest a WHERE a.dayThu = :dayThu"),
    @NamedQuery(name = "AdProcessRequest.findByDayFri", query = "SELECT a FROM AdProcessRequest a WHERE a.dayFri = :dayFri"),
    @NamedQuery(name = "AdProcessRequest.findByDaySat", query = "SELECT a FROM AdProcessRequest a WHERE a.daySat = :daySat"),
    @NamedQuery(name = "AdProcessRequest.findByDaySun", query = "SELECT a FROM AdProcessRequest a WHERE a.daySun = :daySun"),
    @NamedQuery(name = "AdProcessRequest.findByMonthlyOption", query = "SELECT a FROM AdProcessRequest a WHERE a.monthlyOption = :monthlyOption"),
    @NamedQuery(name = "AdProcessRequest.findByMonthlySpecificDay", query = "SELECT a FROM AdProcessRequest a WHERE a.monthlySpecificDay = :monthlySpecificDay"),
    @NamedQuery(name = "AdProcessRequest.findByMonthlyDayOfWeek", query = "SELECT a FROM AdProcessRequest a WHERE a.monthlyDayOfWeek = :monthlyDayOfWeek"),
    @NamedQuery(name = "AdProcessRequest.findByFinishes", query = "SELECT a FROM AdProcessRequest a WHERE a.finishes = :finishes"),
    @NamedQuery(name = "AdProcessRequest.findByFinishesTime", query = "SELECT a FROM AdProcessRequest a WHERE a.finishesTime = :finishesTime"),
    @NamedQuery(name = "AdProcessRequest.findByFinishesDate", query = "SELECT a FROM AdProcessRequest a WHERE a.finishesDate = :finishesDate"),
    @NamedQuery(name = "AdProcessRequest.findByDailyOption", query = "SELECT a FROM AdProcessRequest a WHERE a.dailyOption = :dailyOption"),
    @NamedQuery(name = "AdProcessRequest.findByCron", query = "SELECT a FROM AdProcessRequest a WHERE a.cron = :cron"),
    @NamedQuery(name = "AdProcessRequest.findByAdProcessSetId", query = "SELECT a FROM AdProcessRequest a WHERE a.adProcessSetId = :adProcessSetId"),
    @NamedQuery(name = "AdProcessRequest.findBySchedule", query = "SELECT a FROM AdProcessRequest a WHERE a.schedule = :schedule"),
    @NamedQuery(name = "AdProcessRequest.findByReschedule", query = "SELECT a FROM AdProcessRequest a WHERE a.reschedule = :reschedule"),
    @NamedQuery(name = "AdProcessRequest.findByUnschedule", query = "SELECT a FROM AdProcessRequest a WHERE a.unschedule = :unschedule"),
    @NamedQuery(name = "AdProcessRequest.findByParams", query = "SELECT a FROM AdProcessRequest a WHERE a.params = :params")})
public class AdProcessRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "ad_process_request_id")
    private String adProcessRequestId;
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
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "isrolesecurity")
    private Character isrolesecurity;
    @Size(max = 2147483647)
    @Column(name = "ob_context")
    private String obContext;
    @Size(max = 60)
    @Column(name = "status")
    private String status;
    @Column(name = "next_fire_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nextFireTime;
    @Column(name = "previous_fire_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date previousFireTime;
    @Column(name = "scheduled_finish")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scheduledFinish;
    @Size(max = 20)
    @Column(name = "channel")
    private String channel;
    @Size(max = 60)
    @Column(name = "timing_option")
    private String timingOption;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Size(max = 60)
    @Column(name = "frequency")
    private String frequency;
    @Column(name = "secondly_interval")
    private Long secondlyInterval;
    @Column(name = "minutely_interval")
    private Long minutelyInterval;
    @Column(name = "hourly_interval")
    private Long hourlyInterval;
    @Column(name = "daily_interval")
    private Long dailyInterval;
    @Column(name = "secondly_repetitions")
    private Long secondlyRepetitions;
    @Column(name = "minutely_repetitions")
    private Long minutelyRepetitions;
    @Column(name = "hourly_repetitions")
    private Long hourlyRepetitions;
    @Column(name = "day_mon")
    private Character dayMon;
    @Column(name = "day_tue")
    private Character dayTue;
    @Column(name = "day_wed")
    private Character dayWed;
    @Column(name = "day_thu")
    private Character dayThu;
    @Column(name = "day_fri")
    private Character dayFri;
    @Column(name = "day_sat")
    private Character daySat;
    @Column(name = "day_sun")
    private Character daySun;
    @Size(max = 60)
    @Column(name = "monthly_option")
    private String monthlyOption;
    @Column(name = "monthly_specific_day")
    private BigInteger monthlySpecificDay;
    @Size(max = 60)
    @Column(name = "monthly_day_of_week")
    private String monthlyDayOfWeek;
    @Column(name = "finishes")
    private Character finishes;
    @Column(name = "finishes_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishesTime;
    @Column(name = "finishes_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishesDate;
    @Size(max = 60)
    @Column(name = "daily_option")
    private String dailyOption;
    @Size(max = 60)
    @Column(name = "cron")
    private String cron;
    @Size(max = 32)
    @Column(name = "ad_process_set_id")
    private String adProcessSetId;
    @Column(name = "schedule")
    private Character schedule;
    @Column(name = "reschedule")
    private Character reschedule;
    @Column(name = "unschedule")
    private Character unschedule;
    @Size(max = 4000)
    @Column(name = "params")
    private String params;
    @OneToMany(fetch=javax.persistence.FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "adProcessRequestId")
    private List<AdProcessRun> adProcessRunList;
    @JoinColumn(name = "ad_client_id", referencedColumnName = "ad_client_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdClient adClientId;
    @JoinColumn(name = "ad_org_id", referencedColumnName = "ad_org_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdOrg adOrgId;
    @JoinColumn(name = "ad_process_id", referencedColumnName = "ad_process_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY,optional = false)
    private AdProcess adProcessId;
    @JoinColumn(name = "ad_user_id", referencedColumnName = "ad_user_id")
    @ManyToOne(fetch=javax.persistence.FetchType.LAZY)
    private AdUser adUserId;

    public AdProcessRequest() {
    }

    public AdProcessRequest(String adProcessRequestId) {
        this.adProcessRequestId = adProcessRequestId;
    }

    public AdProcessRequest(String adProcessRequestId, Character isactive, Date created, String createdby, Date updated, String updatedby) {
        this.adProcessRequestId = adProcessRequestId;
        this.isactive = isactive;
        this.created = created;
        this.createdby = createdby;
        this.updated = updated;
        this.updatedby = updatedby;
    }

    public String getAdProcessRequestId() {
        return adProcessRequestId;
    }

    public void setAdProcessRequestId(String adProcessRequestId) {
        this.adProcessRequestId = adProcessRequestId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getIsrolesecurity() {
        return isrolesecurity;
    }

    public void setIsrolesecurity(Character isrolesecurity) {
        this.isrolesecurity = isrolesecurity;
    }

    public String getObContext() {
        return obContext;
    }

    public void setObContext(String obContext) {
        this.obContext = obContext;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(Date nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public Date getPreviousFireTime() {
        return previousFireTime;
    }

    public void setPreviousFireTime(Date previousFireTime) {
        this.previousFireTime = previousFireTime;
    }

    public Date getScheduledFinish() {
        return scheduledFinish;
    }

    public void setScheduledFinish(Date scheduledFinish) {
        this.scheduledFinish = scheduledFinish;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTimingOption() {
        return timingOption;
    }

    public void setTimingOption(String timingOption) {
        this.timingOption = timingOption;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Long getSecondlyInterval() {
        return secondlyInterval;
    }

    public void setSecondlyInterval(Long secondlyInterval) {
        this.secondlyInterval = secondlyInterval;
    }

    public Long getMinutelyInterval() {
        return minutelyInterval;
    }

    public void setMinutelyInterval(Long minutelyInterval) {
        this.minutelyInterval = minutelyInterval;
    }

    public Long getHourlyInterval() {
        return hourlyInterval;
    }

    public void setHourlyInterval(Long hourlyInterval) {
        this.hourlyInterval = hourlyInterval;
    }

    public Long getDailyInterval() {
        return dailyInterval;
    }

    public void setDailyInterval(Long dailyInterval) {
        this.dailyInterval = dailyInterval;
    }

    public Long getSecondlyRepetitions() {
        return secondlyRepetitions;
    }

    public void setSecondlyRepetitions(Long secondlyRepetitions) {
        this.secondlyRepetitions = secondlyRepetitions;
    }

    public Long getMinutelyRepetitions() {
        return minutelyRepetitions;
    }

    public void setMinutelyRepetitions(Long minutelyRepetitions) {
        this.minutelyRepetitions = minutelyRepetitions;
    }

    public Long getHourlyRepetitions() {
        return hourlyRepetitions;
    }

    public void setHourlyRepetitions(Long hourlyRepetitions) {
        this.hourlyRepetitions = hourlyRepetitions;
    }

    public Character getDayMon() {
        return dayMon;
    }

    public void setDayMon(Character dayMon) {
        this.dayMon = dayMon;
    }

    public Character getDayTue() {
        return dayTue;
    }

    public void setDayTue(Character dayTue) {
        this.dayTue = dayTue;
    }

    public Character getDayWed() {
        return dayWed;
    }

    public void setDayWed(Character dayWed) {
        this.dayWed = dayWed;
    }

    public Character getDayThu() {
        return dayThu;
    }

    public void setDayThu(Character dayThu) {
        this.dayThu = dayThu;
    }

    public Character getDayFri() {
        return dayFri;
    }

    public void setDayFri(Character dayFri) {
        this.dayFri = dayFri;
    }

    public Character getDaySat() {
        return daySat;
    }

    public void setDaySat(Character daySat) {
        this.daySat = daySat;
    }

    public Character getDaySun() {
        return daySun;
    }

    public void setDaySun(Character daySun) {
        this.daySun = daySun;
    }

    public String getMonthlyOption() {
        return monthlyOption;
    }

    public void setMonthlyOption(String monthlyOption) {
        this.monthlyOption = monthlyOption;
    }

    public BigInteger getMonthlySpecificDay() {
        return monthlySpecificDay;
    }

    public void setMonthlySpecificDay(BigInteger monthlySpecificDay) {
        this.monthlySpecificDay = monthlySpecificDay;
    }

    public String getMonthlyDayOfWeek() {
        return monthlyDayOfWeek;
    }

    public void setMonthlyDayOfWeek(String monthlyDayOfWeek) {
        this.monthlyDayOfWeek = monthlyDayOfWeek;
    }

    public Character getFinishes() {
        return finishes;
    }

    public void setFinishes(Character finishes) {
        this.finishes = finishes;
    }

    public Date getFinishesTime() {
        return finishesTime;
    }

    public void setFinishesTime(Date finishesTime) {
        this.finishesTime = finishesTime;
    }

    public Date getFinishesDate() {
        return finishesDate;
    }

    public void setFinishesDate(Date finishesDate) {
        this.finishesDate = finishesDate;
    }

    public String getDailyOption() {
        return dailyOption;
    }

    public void setDailyOption(String dailyOption) {
        this.dailyOption = dailyOption;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getAdProcessSetId() {
        return adProcessSetId;
    }

    public void setAdProcessSetId(String adProcessSetId) {
        this.adProcessSetId = adProcessSetId;
    }

    public Character getSchedule() {
        return schedule;
    }

    public void setSchedule(Character schedule) {
        this.schedule = schedule;
    }

    public Character getReschedule() {
        return reschedule;
    }

    public void setReschedule(Character reschedule) {
        this.reschedule = reschedule;
    }

    public Character getUnschedule() {
        return unschedule;
    }

    public void setUnschedule(Character unschedule) {
        this.unschedule = unschedule;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @XmlTransient
    public List<AdProcessRun> getAdProcessRunList() {
        return adProcessRunList;
    }

    public void setAdProcessRunList(List<AdProcessRun> adProcessRunList) {
        this.adProcessRunList = adProcessRunList;
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

    public AdProcess getAdProcessId() {
        return adProcessId;
    }

    public void setAdProcessId(AdProcess adProcessId) {
        this.adProcessId = adProcessId;
    }

    public AdUser getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(AdUser adUserId) {
        this.adUserId = adUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adProcessRequestId != null ? adProcessRequestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdProcessRequest)) {
            return false;
        }
        AdProcessRequest other = (AdProcessRequest) object;
        if ((this.adProcessRequestId == null && other.adProcessRequestId != null) || (this.adProcessRequestId != null && !this.adProcessRequestId.equals(other.adProcessRequestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.pharmaceutical.model.entities.AdProcessRequest[ adProcessRequestId=" + adProcessRequestId + " ]";
    }
    
}
