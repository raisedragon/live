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
		var consignmentForm = $("#consignmentForm");
		consignmentForm.on("click", "#addProduct", function(e) {
			e.preventDefault();
			if ($(this).hasClass("disabled")) {
				return;
			}
			;
			addProduct();
		}).on("click", "[name='save']", function(e) {
			e.preventDefault();
			if ($(this).hasClass("disabled")) {
				return;
			}
			;
			postConsignment();
		});
	};
	/**
	 * 添加产品
	 */
	var addProduct = function() {
		var _this = $("#addProduct");
		var productFormGroup = $("#template-product-form-group .form-group")
				.clone();
		_this.closest("div.form-group").before(productFormGroup);
	};
	/**
	 * 提交数据到后台，生成面单
	 */
	var postConsignment = function() {
		if (!consignmentValidate.form()) {
			return;
		}

		var url = "getLabel.do";
		var data = getData();
		$.ajax({
			contentType : 'application/json',
			dataType : "json",
			type : "POST",
			url : url,
			data : JSON.stringify(data)
		}).done(function(data) {
			if (data.statusCode == 0) {
				bootbox.alert("操作成功！", function() {
				});
			} else {
				bootbox.alert(data.message, function() {
				});
			}
		});
	};

	/**
	 * 获取要Post到后台的数据
	 */
	var getData = function() {
		var documentNo = $("#documentNo").val();
		var logisticsCode = $("#logisticsCode").val();
		var length = $("#length").val();
		var width = $("#width").val();
		var height = $("#height").val();
		var weight = $("#weight").val();

		var address1 = $("#address1").val();
		var address2 = $("#address2").val();
		var city = $("#city").val();
		var countryCode = $("#countryCode").val();
		var email = $("#email").val();
		var houseNo = $("#houseNo").val();
		var name = $("#name").val();
		var phone = $("#phone").val();
		var postcode = $("#postcode").val();
		var state = $("#state").val();

		var products = [];
		$("form .self-product-info").each(function() {
			var _this = $(this);
			var name = $("[name=productName]", _this).val();
			var length = $("[name=productLength]", _this).val();
			var width = $("[name=productWidth]", _this).val();
			var height = $("[name=productHeight]", _this).val();
			var weight = $("[name=productWeight]", _this).val();
			var sku = $("[name=productSku]", _this).val();
			var qty = $("[name=productQuantity]", _this).val();

			var priceImports = $("[name=productValue]", _this).val();

			var product = {
				"name" : name,
				"length" : length,
				"width" : width,
				"height" : height,
				"weight" : weight,
				"sku" : sku,
				"qty" : qty,
				"classifyProducts" : [ {
					"countryCode" : countryCode,
					"priceImports" : priceImports
				} ]
			};
			products.push(product);
		});

		var data = {
			"documentNo" : documentNo,
			"length" : length,
			"width" : width,
			"height" : height,
			"weight" : weight,
			"logisticsCode" : logisticsCode,
			"consignee" : {
				"address1" : address1,
				"address2" : address2,
				"city" : city,
				"countryCode" : countryCode,
				"email" : email,
				"houseNo" : houseNo,
				"name" : name,
				"phone" : phone,
				"postcode" : postcode,
				"state" : state
			},
			"products" : products,
			"requiredNew" : false,
		};

		return data;

	};

	// 校验
	var initConsignmentValidateValidate = function() {
		consignmentValidate = $("#consignmentForm").validate({
			rules : {
				documentNo : {
					required : true,
					maxlength : 10
				},
				logisticsCode : {
					required : true,
					maxlength : 32
				},
				length : {
					required : true,
					digits : true
				},
				width : {
					required : true,
					digits : true
				},
				height : {
					required : true,
					digits : true
				},
				weight : {
					required : true,
					digits : true
				},
				name : {
					required : true,
					maxlength : 60
				},
				state : {
					required : true,
					maxlength : 60
				},
				city : {
					required : true,
					maxlength : 60
				},
				countryCode : {
					required : true,
					maxlength : 2
				},
				address1 : {
					required : true,
					maxlength : 60
				},
				postcode : {
					required : true,
					maxlength : 10
				}

			},
			messages : {
				documentNo : {
					required : "出库单号不能为空",
					maxlength : "长度不能超过10"
				},
				logisticsCode : {
					required : "派送方式编码不能为空",
					maxlength : "长度不能超过32"
				},
				length : {
					required : "包裹长度不能为空",
					digits : "包裹长度必须为数字"
				},
				width : {
					required : "包裹宽度不能为空",
					digits : "包裹宽度必须为数字"
				},
				height : {
					required : "包裹高度不能为空",
					digits : "包裹高度必须为数字"
				},
				weight : {
					required : "包裹重量不能为空",
					digits : "包裹重量必须为数字"
				},
				name : {
					required : "收件人姓名不能为空",
					maxlength : "收件人姓名长度不能超过60"
				},
				countryCode : {
					required : "收件人国家不能为空",
					maxlength : "收件人国家长度不能超过2"
				},
				state : {
					required : "收件人州不能为空",
					maxlength : "收件人州长度不能超过60"
				},
				city : {
					required : "收件人城市不能为空",
					maxlength : "收件人城市长度不能超过60"
				},
				address1 : {
					required : "收件人地址不能为空",
					maxlength : "收件人地址长度不能超过60"
				},
				postcode : {
					required : "收件人邮编不能为空",
					maxlength : "收件人邮编长度不能超过10"
				}
			}
		});
	};

	return {
		// main function to initiate the module
		init : function() {
			initCompoment();
			// 验证数据
			initConsignmentValidateValidate();
		}

	};
}();