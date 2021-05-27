package com.tododemo.portlet;

import com.tododemo.constants.ToDoPortletKeys;
import com.todoservices.model.Todo;
import com.todoservices.service.TodoLocalService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Juliano
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ToDo",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ToDoPortletKeys.TODO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ToDoPortlet extends MVCPortlet {
	
	public List<Todo> todos = null;
	
	@Reference
	private TodoLocalService todoLocalService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		User user = (User) renderRequest.getAttribute(WebKeys.USER);
		
		if (user != null) {
			this.todos = todoLocalService.findByUser(user.getUserId());
		}
		renderRequest.setAttribute("user-todos", this.todos);
		super.doView(renderRequest, renderResponse);
	}
	
	public void addTodo(
			ActionRequest actionRequest,
            ActionResponse actionResponse) {
		 try {
		     String name = ParamUtil.getString(actionRequest, "name");
		     String date = ParamUtil.getString(actionRequest, "date");
		     User user = (User) actionRequest.getAttribute(WebKeys.USER);
		     
		     Date dueDate = date == null || date.isEmpty() ? null : new SimpleDateFormat("MM/dd/yyyy").parse(date);  
		     
		     addTodo(name, dueDate, user.getUserId());
		     actionResponse.sendRedirect(this.getRequestAddress(actionRequest));
		 } catch(Exception e){
		        e.printStackTrace();
		 }
	}
	
	public void markAsDone(			
			ActionRequest actionRequest,
            ActionResponse actionResponse) {
		try {
			Long todoCode = ParamUtil.getLong(actionRequest, "todo");
			Todo todo = todoLocalService.getTodo(todoCode);

			markAsDone(todo);
		    actionResponse.sendRedirect(this.getRequestAddress(actionRequest));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(
			ActionRequest actionRequest,
			ActionResponse actionResponse) {
		try {
			Long todoCode = ParamUtil.getLong(actionRequest, "todo");
			
			deleteTodo(todoCode);
		    actionResponse.sendRedirect(this.getRequestAddress(actionRequest));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getRequestAddress(ActionRequest request) {
		return "http://" + request.getServerName() + ":" + request.getServerPort() + "/";
	}
	
	private void addTodo(String name, Date dueDate, long userId) {
		Todo newTodo = todoLocalService.createTodo(CounterLocalServiceUtil.increment());
		
		newTodo.setName(name);
		newTodo.setDone(false);
		newTodo.setDueDate(dueDate);
		newTodo.setUser(userId);
		
		todoLocalService.addTodo(newTodo);
	}
	
	private void markAsDone(Todo todo) {
		todo.setDone(true);
		todoLocalService.updateTodo(todo);
	}
	
	private void deleteTodo(long todoCode) throws PortalException {
		todoLocalService.deleteTodo(todoCode);
	}
}


