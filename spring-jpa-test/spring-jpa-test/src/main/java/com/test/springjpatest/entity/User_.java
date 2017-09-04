package com.test.springjpatest.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * 属性与数据类型对应，为 了动态条件做准备
 * @author Administrator
 *
 */
@StaticMetamodel(User.class)
public class User_ {
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Integer> age;
    public static volatile SingularAttribute<User, String> address;
}


