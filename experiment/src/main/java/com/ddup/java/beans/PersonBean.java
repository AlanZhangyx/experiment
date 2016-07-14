package com.ddup.java.beans;

import java.io.Serializable;

/**
 * PersonBean。
 * 
 * <p>要成为JavaBean类，必须遵循关于命名、构造器、方法的特定规范。有了这些规范，才能有可以使用、复用、替代和连接JavaBeans的工具。</p>
 * <ul>
 * <li>有一个public的无参数建构子。</li>
 * <li>属性可以通过get、set、is（可以替代get，用在布尔型属性上）方法或遵循特定命名规范的其他方法访问。</li>
 * <li>可序列化。</li>
 * </ul>
 * <br>
 * <strong>Time</strong>&nbsp;&nbsp;&nbsp;&nbsp;${2016年6月7日 上午11:20:06}<br>
 *
 * @version  1.0.0
 * @author   alanzhang
 */
public class PersonBean implements Serializable{

    /**  */
    private static final long serialVersionUID = 1L;
    
    private int id;
    
    private String name;
    
    private boolean vip;
    
    private PersonBean father;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 注意：对于boolean（不包括Boolean）来说，默认没有get而是is
     * @return
     * @Author alanzhang
     * @Date 2016年6月7日 上午11:27:37 
     */
    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public PersonBean getFather() {
        if (father == null) {
            father = new PersonBean();
            father.setName("我是father");
        }
        return father;
    }

    public void setFather(PersonBean father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return "PersonBean [id=" + id + ", name=" + name + ", vip=" + vip + ", father=" + father + "]";
    }
}
