<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.todoservices.model.Todo"%>
<%@ include file="/init.jsp" %>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js" integrity="sha512-uto9mlQzrs59VwILcLiRYeLKPPbS/bT71da/OEBYEwcdNUk8jYIy+D176RYoop1Da+f9mvkYrmj5MCLZWEtQuA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Zebra_datepicker/1.9.18/zebra_datepicker.min.js" integrity="sha512-+jF6u7aOmduPkX9JBkvp1B5XgGqvfc3fPGWJG43Ci18tZ4hR1jgHMrlWrM8ai73KzuMc6hvp+9S2k9ggGKYTiw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/zebra_datepicker@latest/dist/css/bootstrap/zebra_datepicker.min.css">

<portlet:defineObjects />
<%
	List<Todo> userTodos = (List<Todo>) renderRequest.getAttribute("user-todos");
%>

 <%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

<div class="container">
	<div class=row>
		<div class="col-3"></div>
		<div class="col-6">
			<div class="row">
				<% if (userTodos != null) { %>
					<table class = 'table'>
						<thead>
							<tr>
								<th scope="col">
									<div align="center">
										Done
									</div>
								</th>			
								<th scope="col">Task</th>
								<th scope="col">Due Date</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
						<% for (Todo todo : userTodos) { 
							DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
						%>
							<tr>
								<td>
									<div align="center">
										<% if (todo.getDone()) { %>
											<i class="fas fa-check"></i>
										<% } else { %>
											<portlet:actionURL name="markAsDone" var="markAsDoneURL">
												<portlet:param name="todo" value = "<%= String.valueOf(todo.getId()) %>"/>
											</portlet:actionURL>
										
											<a class="far fa-check-square" href="<%= markAsDoneURL.toString() %>"/>							
										<% } %>
									</div>
								</td> 
								<td class="<%= todo.getDone() ? "todo-done" : "" %>"><%= todo.getName() %></td>
								<td><%= todo.getDueDate() == null ? "" : dateFormat.format(todo.getDueDate()) %></td>
								<td>
									<portlet:actionURL name="delete" var="deleteURL">
										<portlet:param name="todo" value = "<%= String.valueOf(todo.getId()) %>"/>
									</portlet:actionURL>
									<a class="fas fa-trash-alt" href="<%= deleteURL.toString() %>"/>
								</td>
						    </tr>	
				  		<% }  %>
				  		</tbody>
					</table>
				<% } %>
			</div>
			<div class="row">
				<form class="mx-auto my-4">
					<input type="button" class="btn btn-primary" value="Add new" id="loader"/>
				</form>
			</div>
		</div>
		<div class="col-3"></div>
	</div>
</div>


<div id="newTodoModal" class="hidden">
	<portlet:actionURL var="addTodoActionURL" windowState="normal" name="addTodo">
	</portlet:actionURL>
				
	<form id="addTodoForm" action="<%=addTodoActionURL%>" name="todoForm"  method="POST">
		<div class="container">
			<div class="row my-4">
				<div class="col-1"></div>
				<div class="col-10">
					<div class="row">
						<label for="name">Task</label>
						<input maxlength="75" type="text" class="form-control" name="<portlet:namespace/>name" id="<portlet:namespace/>name" placeholder="" value="" required="">
						<div class="invalid-feedback">
							Todo is required.
						</div>
					</div>
					<div class="row my-4">
						<label for="name">Due Date</label>					
		                <input type="text" class="datepicker form-control" name="<portlet:namespace/>date" id="<portlet:namespace/>date">					
					</div>
					<div class="row my-4 d-flex flex-row-reverse">
						<input class="btn btn-primary mx-2" type="submit" value="Confirm" name="addTodo" id="addTodo"/>
						<input class="btn btn-link text-danger" type="button" value="Cancel" name="cancel" id="cancelNewTodo"/>						
					</div>
				</div>
				<div class="col-1"></div>					
			</div>
		</div>
	</form>	
</div>

<script>
$(document).ready(
	function() {
	    $("#loader").click(function(){
			$("#newTodoModal").dialog(
        		{ 
        			title: 'New Todo',
        			modal: true,
        			height: window.screen.height * 0.4,
        			width: window.screen.width * 0.5
       			}
       		);
	    });

	    $("#cancelNewTodo").click(function (){
	    	closeDialog();
	    });
	    $(".datepicker").Zebra_DatePicker({
	    	format: "m/d/Y",
	        direction: 1
	    });
	}
);

function closeDialog() {
	if ($('#newTodoModal').dialog('isOpen')) {
		$("#newTodoModal").dialog('close');
	}
}
</script>

