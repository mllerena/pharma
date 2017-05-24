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

package org.pharmaceutical.bpm.utils;

import org.kie.api.task.UserGroupCallback;
import org.pharmaceutical.model.ejb.facades.AdRoleFacade;
import org.pharmaceutical.model.ejb.facades.AdUserFacade;
import org.pharmaceutical.model.ejb.facades.AdUserRolesFacade;
import org.pharmaceutical.model.ejb.services.RolService;
import org.pharmaceutical.model.ejb.services.UsuarioRolService;
import org.pharmaceutical.model.ejb.services.UsuarioService;
import org.pharmaceutical.model.entities.AdRole;
import org.pharmaceutical.model.entities.AdUser;
import org.pharmaceutical.model.entities.AdUserRoles;
import org.pharmaceutical.model.entities.Rol;
import org.pharmaceutical.model.entities.Usuario;
import org.pharmaceutical.model.entities.UsuarioRol;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProcessUserGroupCallback implements UserGroupCallback {
	
	//@Inject private UsuarioService usuarioService;
	
	@Inject private AdUserFacade adUserFacade;
	
	@Inject private AdRoleFacade adRoleFacade;
	
	@Inject private AdUserRolesFacade adUserRolesFacade;

    public boolean existsUser(String userId) {
    	System.out.println("existsUser: "+userId);
    	
    	AdUser usuario = adUserFacade.findByUsername(userId);
    	
    	return usuario != null || userId.equals("Administrator");
    	
        //return userId.equals("jiri") || userId.equals("mary") || userId.equals("Administrator");
    }
    
    

    public boolean existsGroup(String groupId) {
    	System.out.println("existsGroup: "+groupId);
    	
    	AdRole rol =  adRoleFacade.findByName(groupId); 
    	
    	return rol != null;
    	
        //return groupId.equals("PM") || groupId.equals("HR");
    }
    
    

    public List<String> getGroupsForUser(String userId,
                                         List<String> groupIds, List<String> allExistingGroupIds) {
        List<String> groups = new ArrayList<String>();
        
        /*if (userId.equals("jiri"))
            groups.add("PM");
        else if (userId.equals("mary"))
            groups.add("HR");*/
        
        AdUser usuario = adUserFacade.findByUsername(userId);
        
        List<AdUserRoles> roles = adUserRolesFacade.findByAdUser(usuario);
        
        if( roles != null && !roles.isEmpty())
        for (AdUserRoles usuarioRol : roles) {
        	groups.add(usuarioRol.getAdRoleId().getName());    
		}
        		
        		
        
        return groups;
    }
}
