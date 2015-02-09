<ul class="nav nav-collapse">
	<#list menu.items as menuItem>
	<li><a href="${menuItem.href}"><span class="arrow"></span>${menuItem.name}</a></li>
	</#list>
</ul>