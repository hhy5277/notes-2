
# ipv4
	^((2[0-4]\d|25[0-5]|[01]?\d\d?)\.){3}(2[0-4]\d|25[0-5]|[01]?\d\d?)$

# 移动电话号码
	^1[3-9]\d{9}$


# 用户名
	/^(?!\d+$)(?!_+$)\w{1,14}$/.test(name.replace(/[\u4e00-\u9fa5]/g,"aa"));
	name.replaceAll("[\\u4e00-\\u9fa5]", "aa").matches("^(?!\\d+$)(?!_+$)\\w{1,14}$");