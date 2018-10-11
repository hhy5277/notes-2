------------------------
String					|
------------------------
	# 字符串

------------------------
静态方法				|
------------------------
	String format(String format, Object... args) 
		# 格式化指定的字符串
	

------------------------
实例方法				|
------------------------
	native String intern();
		* 返回常量池中的某字符串,如果常量池中已经存在该字符串,则直接返回常量池中该对象的引用
		* 否则,在常量池中加入该对象,然后 返回引用
		
			//  1.1在堆中创建"1"字符串对象
			//  1.2字符串常量池引用"1"字符串对象
			//  1.3s引用指向堆中"1"字符串对象
			String s = new String("1");

			// 2. 发现字符串常量池中已经存在"1"字符串对象，直接返回字符串常量池中对堆的引用(但没有接收)-->s引用还是指向着堆中的对象
			s.intern();

			// 3. 发现字符串常量池已经保存了该对象的引用了，直接返回字符串常量池对堆中字符串的引用
			String s2 = "1";

			// 4. s指向的是堆中对象的引用，s2指向的是在字符串常量池对堆中对象的引用
			System.out.println(s == s2);// false	

			---------------------------------------------
			 // 1. 在堆中首先创建了两个“1”对象
			// 1.1 +号运算符解析成stringBuilder，最后toString()，最终在堆中创建出"11"对象
			// 1.2 注意：此时"11"对象并没有在字符串常量池中保存引用
			String s3 = new String("1") + new String("1");

			// 2. 发现"11"对象并没有在字符串常量池中存在，于是将"11"对象在字符串常量池中保存当前字符串的引用，并返回当前字符串的引用
			s3.intern();

			// 3. 发现字符串常量池已经存在引用了，直接返回(拿到的也是与s3相同指向的引用)
			String s4 = "11";
			System.out.println(s3 == s4); // true