<ul class="nav nav-list well">
	<#list menus as menu>
		<li class="nav-header">
			${menu.name}
		</li>
		<#list menu.items as item>
			<li>
				<a href="${item.href}">${item.name}</a>
			</li>
		</#list>
	</#list>
</ul>