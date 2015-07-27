<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/pages/commons/public.jsp" %>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <%@ include file="/pages/commons/resource-import.jsp" %>
        <%@ include file="/pages/commons/import-datatables.jsp" %>
        
         <script type="text/javascript">
        	$(function(){
        		$('#configs').dataTable({
        	    	"processing": true,
        	        "serverSide": true,
        	        "ajax":{
        	        	"url": "listData.do",
        	        	"type": "post",
        	        	"dataSrc":function(json){
        	        			var list = json.data.list;
        	        			for(key in list){
        	        				var links = [
													" <a href='edit.do?id="+list[key].id+"' class=\"glyphicon glyphicon-edit\" aria-hidden=\"true\"></a>",
													" <a href='delete.do?id="+list[key].id+"' class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></a>"
        	        				            ];
        	        				list[key].manage = links.join(' ');
        	        			}
        	        			return list;
        	        		}
        	        	},
        	        "columns":[
        	        	{data:"name"},
        	        	{data:"value"},
        	        	{data:"description"},
        	        	{data:"created"},
        	        	{data:"createdBy"},
        	        	{data:"updated"},
        	        	{data:"updatedBy"},
        				{data:"manage"}
        	        ],
        	      	"bSort":false,
        	      	"sDom": '<"top">rt<"bottom"lp><i><"clear">'
        	    } );
        		
        	});
        </script>
        
    </head>
    <body>
        <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	      <div class="container">
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
	            <span class="sr-only">Toggle navigation</span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand" href="#">PRAISE THE LORD</a>
	        </div>
	        
	        <div class="navbar-collapse collapse">
	          <ul class="nav navbar-nav">
		        <li  data-toggle="tab"><a href="#"> 人间  </a></li>
		        <li  data-toggle="tab"><a href="#"> 天堂 </a></li>
		        <li  data-toggle="tab"><a href="#"> 地狱 </a></li>
		      </ul>
		      
	          <form class="navbar-form navbar-right" role="form">
	            <div class="form-group">
	              <input type="text" placeholder="Email" class="form-control">
	            </div>
	            <div class="form-group">
	              <input type="password" placeholder="Password" class="form-control">
	            </div>
	            <button type="submit" class="btn btn-success">Sign in</button>
	          </form>
	        </div><!--/.navbar-collapse -->
	      </div>
	    </nav>
	
	    <!-- Main jumbotron for a primary marketing message or call to action -->
	    <div class="jumbotron">
	      <div class="container">
	      	<table id="configs" class="display" cellspacing="0" width="100%">
			    <thead>
			        <tr>
			            <th>Name</th>
			            <th>Vaue</th>
			            <th>Description</th>
			            <th>Created</th>
			            <th>Created By</th>
			            <th>Updated</th>
			            <th>Updated By</th>
			            <th>Manage</th>
			        </tr>
			    </thead>
			 
			    <tfoot>
			        <tr>
			            <th>Name</th>
			            <th>Vaue</th>
			            <th>Description</th>
			            <th>Created</th>
			            <th>Created By</th>
			            <th>Updated</th>
			            <th>Updated By</th>
			            <th>Manage</th>
			        </tr>
			    </tfoot>
			</table>
	      </div>
	    </div>

    	
		<%@ include file="/pages/commons/footer.jsp" %>
    </body>
</html>
