package org.pharmaceutical.bpm.entities;

import java.util.Date;
import java.util.List;

import org.jbpm.services.api.model.ProcessInstanceDesc;
import org.jbpm.services.api.model.UserTaskInstanceDesc;

public class ProcessInstanceDescFilter {

	private Long id;
    private String processId;
    private String processName;
    private String processVersion;
    private Integer state;
    private String deploymentId;    
    private String initiator;
    
    private Date dataTimeStamp;

    private String processInstanceDescription;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getProcessVersion() {
		return processVersion;
	}

	public void setProcessVersion(String processVersion) {
		this.processVersion = processVersion;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	public String getInitiator() {
		return initiator;
	}

	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}

	public Date getDataTimeStamp() {
		return dataTimeStamp;
	}

	public void setDataTimeStamp(Date dataTimeStamp) {
		this.dataTimeStamp = dataTimeStamp;
	}

	public String getProcessInstanceDescription() {
		return processInstanceDescription;
	}

	public void setProcessInstanceDescription(String processInstanceDescription) {
		this.processInstanceDescription = processInstanceDescription;
	}

}
