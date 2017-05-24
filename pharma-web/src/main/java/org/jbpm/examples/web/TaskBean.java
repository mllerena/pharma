/**
 * Copyright 2015, Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.examples.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jbpm.services.api.RuntimeDataService;
import org.jbpm.services.api.UserTaskService;
import org.jbpm.services.task.commands.ClaimTaskCommand;
import org.jbpm.services.task.commands.CompleteTaskCommand;
import org.jbpm.services.task.commands.CompositeCommand;
import org.jbpm.services.task.commands.StartTaskCommand;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.TaskSummary;
import org.pharmaceutical.bpm.utils.StartupBean;
import org.pharmaceutical.view.controllers.AuthenticationController;
import org.pharmaceutical.view.utils.JsfUtils;

@ManagedBean
@ViewScoped
public class TaskBean implements Serializable{

    @Inject
    private UserTaskService userTaskService;

    @Inject
    private RuntimeDataService runtimeDataService;

    //@Inject FacesContext facesContext;

    //@Inject Logger logger;

    private String comment;
    private Map<String,Object> content;
    private Task task;
    private long taskId;
    private String user;
    private List<TaskSummary> tasks;
    

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Map<String, Object> getContent() {
        return content;
    }

    public void setContent(Map<String, Object> content) {
        this.content = content;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Produces
    public List<TaskSummary> getTasks() {
        return tasks;
    }
    
    @Inject
    private AuthenticationController auth;

    @PostConstruct
    public void retrieveTasks () {
        String message;
        try {
        	
        	user = auth.getUsuario().getUsername();
        	
        	System.out.println("retrieveTasks user : "+user);
        	
            tasks = runtimeDataService.getTasksAssignedAsPotentialOwner(user, null);
            
            
            
            message = "Retrieved " + tasks.size() + " task(s) for user " + user + ".";
            //logger.info(message);
            System.out.println(message);
        } catch (Exception e) {
            message = "Cannot retrieve task list for user " + user + ".";
            //logger.log(Level.SEVERE, message, e);
            System.out.println(message);
            //facesContext.getExternalContext().getFlash().put("msg", message);
        }
    }

    public void queryTask(long taskId) {
        String message;
        try {
        		this.taskId = taskId;
        	System.out.println("queryTask: "+taskId);
            task = userTaskService.getTask(taskId);
            content = userTaskService.getTaskInputContentByTaskId(taskId);
            message = "Loaded task " + taskId + ".";
            //logger.info(message);
            System.out.println(message);
            
            JsfUtils.messageInfo(null, message, null);
            
        } catch (Exception e) {
            message = "Unable to query for task with id = " + taskId;
            //logger.log(Level.SEVERE, message, e);
            System.out.println(message);
            //facesContext.getExternalContext().getFlash()      .put("msg", message);
        }
    }
    
    public void startTask() {
        String message;
        try {
        	
        	user = auth.getUsuario().getUsername();
        	
        	Map<String,Object> outputParams = new HashMap<String,Object>();
            outputParams.put("out_comment", comment);
            CompositeCommand compositeCommand = new CompositeCommand(new StartTaskCommand(taskId, user));
            
            userTaskService.execute(StartupBean.DEPLOYMENT_ID, compositeCommand);
            
            taskId = -1;
            task = null;
            content = null;
            
            message = "Start task " + taskId + ".";
            
            //logger.info(message);
            System.out.println(message);
            
            JsfUtils.messageInfo(null, message, null);
            
        } catch (Exception e) {
            message = "Unable to startTask for task with id = " + taskId;
            //logger.log(Level.SEVERE, message, e);
            System.out.println(message);
            //facesContext.getExternalContext().getFlash()      .put("msg", message);
        }
    }

    public void approveTask() {
        String message;
        try {
        	user = auth.getUsuario().getUsername();
        	
            Map<String,Object> outputParams = new HashMap<String,Object>();
            outputParams.put("out_comment", comment);
            CompositeCommand compositeCommand = new CompositeCommand(new CompleteTaskCommand(taskId, user,
                    outputParams));
            
            userTaskService.execute(StartupBean.DEPLOYMENT_ID, compositeCommand);
            message = "Task (id = " + taskId + ") has been completed by " + user;
            
            taskId = -1;
            task = null;
            content = null;
            
            JsfUtils.messageInfo(null, message, null);
            
            System.out.println(message);
            //logger.info(message);
        } catch (Exception e) {
            message = "Unable to approve the task " + taskId + ".";
            //logger.log(Level.SEVERE, message, e);
            System.out.println(message);
        }
        //facesContext.getExternalContext().getFlash().put("msg", message);
        //return "index.xhtml?faces-redirect=true";
    }
}
