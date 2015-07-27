var App = /**
			 * @returns {___anonymous4224_4418}
			 */
function() {
	/**
	 * jquery validator
	 */
	var consignmentValidate = null;
	/**
	 * 初始化页面
	 */
	var initCompoment = function() {
		var labelTablelist = $('#labelTablelist').dataTable( {
			"aoColumnDefs":[
				        	{ "aTargets": [ 0 ]},
				        	{ "aTargets": [ 1 ]},
				        	{ "aTargets": [ 3 ], "bSortable":false,"sWidth":"120px"}
				        ],
				        "aaSorting": [],
		    "dataSrc":"aoData",
	        "aaSorting": [],
	        "ajax":{
	        	"url": "getAllLabel.do",
	        	"type": "post",
	        	"dataSrc":"aoData"
	        },
	        "aoColumns": [
	            { "mData": "documentNo" },
	            { "mData": "trackingNo" },
	            { "mData": "status" },
	            { "mData": function(data){
	            	var str = '<a class="edit view-label" href="#" lid="'+data["id"]+'">View</a>'
	                return str;
	            }}
	        ]
        }).on("click",".view-label",function(){
        	var labelId = $(this).attr("lid");
        	viewLabel(labelId);
        });
	};
	
	var viewLabel = function(id){
		window.open('viewLabel.do?id='+id);
//		$.ajax({
//			url:"viewLabel.do",
//			data:{
//				"id":id
//			}
//		}).done(function(data){
//			if (data.statusCode == 0) {
//				bootbox.alert("操作成功！", function() {
//				});
//			} else {
//				bootbox.alert(data.message, function() {
//				});
//			}
//		});
	}
	

	return {
		// main function to initiate the module
		init : function() {
			initCompoment();
			// 验证数据
		}

	};
}();