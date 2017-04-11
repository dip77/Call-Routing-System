<%@page import="java.util.HashMap"%>
<%@page import="main.OperatorList"%>
<%@page import="org.eclipse.jdt.internal.compiler.ast.OperatorIds"%>
<%@page import="java.util.Iterator"%>
<%@page import="main.User"%>
<%@page import="java.util.Queue"%>
<%@page import="main.CallQueue"%>
<%@page import="main.Operator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="main.Dial"%>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<%!

    ArrayList<Operator> freeOperators;
	Dial dialer;
	Queue<User> waitingQueue;
	CallQueue callQueue;
	OperatorList operatorList;
	%>
<%

	dialer = (Dial) application.getAttribute("dialer");
	
if(dialer!=null){

freeOperators=dialer.getFreeOperators();
callQueue=dialer.getIncomingCallQueue();
waitingQueue=callQueue.getqueueOfUser();
operatorList=dialer.getListOfAllOperators();




}
%>
<body>
	<div class="container">
		<div class="row">
			<div class="offset-s3 col s8">

				<form class="center-align" action="FrontController" method="post">
					<div class="row">
						<h3 class="center-align col s6">Call routing System</h3>
					</div>



					<div class="row">
						<div class="col s6">
							<font color="red">${msg}</font>
							<br>
							<input id="textbox" type="text" name="mobile">
						</div>
					</div>

					<div class="row">
						<div class="col s2">
							<a class="waves-effect waves-light btn dialer" value="1">1</a>
						</div>

						<div class="col s2">
							<a class="waves-effect waves-light btn dialer" value="2">2</a>
						</div>

						<div class="col s2">
							<a class="waves-effect waves-light btn dialer" value="3">3</a>
						</div>
					</div>

					<div class="row">
						<div class="col s2">
							<a class="waves-effect waves-light btn dialer" value="4">4</a>
						</div>

						<div class="col s2">
							<a class="waves-effect waves-light btn dialer" value="5">5</a>
						</div>

						<div class="col s2">
							<a class="waves-effect waves-light btn dialer" value="6">6</a>
						</div>
					</div>


					<div class="row">
						<div class="col s2">
							<a class="waves-effect waves-light btn dialer" value="7">7</a>
						</div>

						<div class="col s2">
							<a class="waves-effect waves-light btn dialer" value="8">8</a>
						</div>

						<div class="col s2">
							<a class="waves-effect waves-light btn dialer" value="9">9</a>
						</div>
					</div>

					<div class="row">
						<div class="col s2">
							<p>
					      <input name="group1" value="English" type="radio" id="test1" checked="checked" />
					      <label for="test1">English</label>
					    </p>
					    <p>
					      <input name="group1" type="radio" value="Hindi" id="test2" />
					      <label for="test2">Hindi</label>
					    </p>
						</div>
						<div class="col s1">
							<input type="submit" class="waves-effect waves-light btn"
								value="call">
						</div>
					</div>
				</form>

			</div>
		</div>
		<div class="row">

			<div class="col s4">
				<h3>Calls in progress</h3>
				<table>
					<thead>
						<tr>
							<th>Phone</th>
							<th>Language</th>
							<th>Disconnect</th>
						</tr>
					</thead>

					<tbody>
					<%
					ArrayList<User> listOfBusyUser=User.busyUser;
				if(listOfBusyUser!=null)
				{
					for(int i=0;i<listOfBusyUser.size();i++)
					{
						User user=listOfBusyUser.get(i);
					
					%>
						<tr>
							<td><%= user.getPhone() %></td>
							<td><%=user.getLanguage() %></td>
							<td><a href="DisconnectController?mobile=<%=user.getPhone()%>"
								class="waves-effect waves-light btn red">Disconnect</a></td>
						</tr>
					</tbody>
					<%
					}}
					%>
				</table>
			</div>

			<div class="col s4">
				<h3>Calls in Queue</h3>
				<table>
					<thead>
						<tr>
							<th>Phone</th>
							<th>Language</th>
						</tr>
					</thead>

					<tbody>
						<%
						if(waitingQueue!=null){
							Iterator<User> iterator = waitingQueue.iterator();
							while (iterator.hasNext()) {
								User user = iterator.next();
						%>


						<tr>
							<td><%=user.getPhone()%></td>
							<td><%=user.getLanguage()	%></td>
						</tr>
						<%
							}
						}
						%>
					</tbody>
				</table>

			</div>


			<div class="col s4">
				<h3>Operator Status</h3>
				<table>
					<thead>
						<tr>
							<th>Operator</th>
							<th>Status</th>
							<th>Language</th>
							<th>Connected User</th>
						</tr>
					</thead>
	<%
		if(operatorList!=null)
		{
	HashMap<Operator,User> operators=operatorList.getHash();
	int i=0;
	
			for(Operator temp:operators.keySet())
			{
				i++;
				User user=operators.get(temp);					
	%>
					<tbody>
						<tr>
							<td> <%=temp.getName() %></td>
							<td><% if(user==null){ %>
								<%="free"%>
								<%}else {%>
								<%= "busy"%>
								<%} %>	
								</td>
							<td><%=temp.getLanguage() %></td>
						<td><% if(user==null){ %>
								<%="-"%>
								<%}else {%>
								<%= user.getPhone()%>
								<%} %>	
								</td>
						</tr>
					</tbody>
					<%}} %>
				</table>

			</div>

		</div>
	</div>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
	<script src="./app.js"></script>
</body>
</html>
