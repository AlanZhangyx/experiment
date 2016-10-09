package com.ddup.java.packages;


/**
 * 类为什么不能被protected修饰呢？
 * 
 * <ul>
 * <li>protected意为受保护的</li>
 * <li>首先：除非在同一个package下，否则被protected修饰则意味着本成员被保护，只有其子类才可访问</li>
 * <li>继而：如果一个class能被声明为protected，你会发现在任何地方都没道理能够引用到此class</li>
 * <li>因为：你必须首先继承此class才能引用到此class，可是你引用不到又怎么能去写extends（继承）呢？</li>
 * </ul>
 * <strong>Copyright</strong> ©2013-2016 ddupa.com LLC. All Rights Reserved.<br>
 *
 * @version 1.0.0
 * @author 
 * <ul>
 * <li>alanzhang 2016年10月9日<br></li>
 * </ul>
 */
class ParentPackage {
    
}
