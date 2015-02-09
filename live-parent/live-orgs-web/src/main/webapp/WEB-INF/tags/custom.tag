<%@tag import="com.raise.orgs.jsp.tag.MenuItem"%>
<%@tag import="com.raise.orgs.jsp.tag.Menu"%>
<%@tag import="java.util.Map"%>
<%@tag import="java.util.HashMap"%>
<%@tag import="com.raise.orgs.identity.User"%>
<%@tag import="com.raise.orgs.impl.context.Context"%>
<%@tag language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
User user = Context.getUser();
Map<String,Object> dataModel = new HashMap<String,Object>();

Menu menu = new Menu();
//TODO
for(int i=0;i<5;i++){
	MenuItem item = new MenuItem();
	item.setName("ITEM"+i);
	item.setHref("#");
	menu.getItems().add(item);
}
%>

<ul class="nav nav-collapse">
	<c:forEach items="">
	<li><a href="${menuItem.href}"><span class="arrow"></span>${menuItem.name}</a></li>
	</c:forEach>
</ul>