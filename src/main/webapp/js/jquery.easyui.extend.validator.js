(function($) {

	/**
	 * 
	 * 扩展easyui的validator插件rules，支持更多类型验证(重写验证方法)
	 * 
	 */
	String.prototype.replaceAll = function(s1, s2) {
		return this.replace(new RegExp(s1, "gm"), s2);
	};

	String.prototype.Trim = function() {
		return this.replace(/(^\s*)|(\s*$)/g, "");
	};

	$.extend(
			$.fn.validatebox.defaults.rules,
			{
				v_length_min : {// 判断最小长度
					validator : function(value, param) {
						return value.length >= param[0];
					},
					message : '最少输入 {0} 个字符'
				},
				v_length_min_trim : {// 判断最小长度(去掉字符串头尾的空格)
					validator : function(value, param) {
						var len = $.trim(value).length;
						return len >= param[0];
					},
					message : '最少输入 {0} 个字符'
				},
				v_length : {// 验证长度
					validator : function(value, param) {
						return value.length >= param[0]
								&& value.length <= param[1];
					},
					message : "输入内容长度必须介于{0}和{1}之间"
				},
				v_length_replace_space : {
					validator : function(value, param) {
						$("#" + param[2])
								.val(value.replaceAll(' ', ''));
						var len = value.replaceAll(' ', '').length;
						return len >= param[0] && len <= param[1];
					},
					message : "输入内容长度必须介于{0}和{1}之间"
				},
				v_phone : {// 验证电话号码
					validator : function(value) {
						return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i
								.test(value);
					},
					message : '格式不正确,请使用下面格式:020-88888888'
				},
				v_mobile : {// 验证手机号码
					validator : function(value) {
						return /^(13|15|18)\d{9}$/i.test(value);
					},
					message : '手机号码格式不正确'
				},
				v_idcard : {// 验证身份证
					validator : function(value) {
						return /^\d{15}(\d{2}[A-Za-z0-9])?$/i
								.test(value);
					},
					message : '身份证号码格式不正确'
				},
				v_int_or_float : {// 验证整数或小数
					validator : function(value) {
						return /^\d+(\.\d+)?$/i.test(value);
					},
					message : '请输入数字，并确保格式正确'
				},
				v_currency : {// 验证货币
					validator : function(value) {
						return /^\d+(\.\d+)?$/i.test(value);
					},
					message : '货币格式不正确'
				},
				v_date : {// 验证姓名，可以是中文或英文
					validator : function(value) {
						// 格式yyyy-MM-dd或yyyy-M-d
						return /^(?:(?!0000)[0-9]{4}([-]?)(?:(?:0?[1-9]|1[0-2])\1(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])\1(?:29|30)|(?:0?[13578]|1[02])\1(?:31))|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)([-]?)0?2\2(?:29))$/i
								.test(value);
					},
					message : '清输入合适的日期格式'
				},
				v_qq : {// 验证QQ,从10000开始
					validator : function(value) {
						return /^[1-9]\d{4,9}$/i.test(value);
					},
					message : 'QQ号码格式不正确'
				},
				v_integer : {// 验证整数
					validator : function(value) {
						return /^[+]?[1-9]+\d*$/i.test(value);
					},
					message : '请输入整数'
				},
				v_chinese : {// 验证中文
					validator : function(value) {
						return /^[\u0391-\uFFE5]+$/i.test(value);
					},
					message : '请输入中文'
				},
				v_english : {// 验证英语
					validator : function(value) {
						return /^[A-Za-z]+$/i.test(value);
					},
					message : '请输入英文'
				},
				// unnormal:{// 验证是否包含空格和非法字符
				// validator:function(value) {
				// return /.+/i.test(value);
				// },
				// message:'输入值不能为空和包含其他非法字符'
				// },
				v_username : {// 验证用户名
					validator : function(value) {
						return /^[a-zA-Z][a-zA-Z0-9_]{5,15}$/i
								.test(value);
					},
					message : '用户名不合法（字母开头，允许6-16字节，允许字母数字下划线）'
				},
				v_faxno : {// 验证传真
					validator : function(value) {
						// return /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[
						// ]){1,12})+$/i.test(value);
						return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i
								.test(value);
					},
					message : '传真号码不正确'
				},
				v_zip : {// 验证邮政编码
					validator : function(value) {
						return /^[1-9]\d{5}$/i.test(value);
					},
					message : '邮政编码格式不正确'
				},
				v_ip : {// 验证IP地址
					validator : function(value) {
						return /d+.d+.d+.d+/i.test(value);
					},
					message : 'IP地址格式不正确'
				},
				v_name : {// 验证姓名，可以是中文或英文
					validator : function(value) {
						return /^[\u0391-\uFFE5]+$/i.test(value)
								| /^\w+[\w\s]+\w+$/i.test(value);
					},
					message : '请输入姓名'
				},
				v_carNo : {
					validator : function(value) {
						return /^[\u4E00-\u9FA5][\da-zA-Z]{6}$/
								.test(value);
					},
					message : '车牌号码无效（例：粤J12350）'
				},
				v_carenergin : {
					validator : function(value) {
						return /^[a-zA-Z0-9]{16}$/.test(value);
					},
					message : '发动机型号无效(例：FG6H012345654584)'
				},
				v_email : {
					validator : function(value) {
						return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
								.test(value);
					},
					message : '请输入有效的电子邮件账号(例：abc@126.com)'
				},
				v_msn : {
					validator : function(value) {
						return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
								.test(value);
					},
					message : '请输入有效的msn账号(例：abc@hotnail(msn/live).com)'
				},
				v_equal : {
					validator : function(value, param) {
						return $("#" + param[0]).val() == value;
					},
					message : '两次输入密码不匹配'
				},
				v_multi_valid : {
					validator : function(_2fca, _2fda) {
						var opts = $.fn.validatebox.defaults;
						var returnFlag = true;
//						if(!$.fn.validatebox.defaults.rules.multipleValidType.msgs){
//							$.fn.validatebox.defaults.rules.multipleValidType.msgs;
//						}
//						var msgs = $.fn.validatebox.defaults.rules.multipleValidType.msgs;
						var count = _2fda.length/2;
						for ( var i = 0; i < count; i++) {

							var _2f31 = /([a-zA-Z_]+)(.*)/
									.exec(_2fda[i]);
							var rule = opts.rules[_2f31[1]];
							if (_2fca && rule) {
								var _2f41 = eval(_2f31[2]);
								if (!rule["validator"](_2fca, _2f41)) {
									returnFlag = false;
									$.fn.validatebox.defaults.rules.v_multi_valid.message = _2fda[count+i];
									break;
								}
							}

						}
						return returnFlag;
					},
					message : {}
				}
			});

})(jQuery);
