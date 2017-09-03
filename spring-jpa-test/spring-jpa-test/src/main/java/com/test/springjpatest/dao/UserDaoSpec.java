package com.test.springjpatest.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.test.springjpatest.entity.User;
import com.test.springjpatest.entity.User_;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 17-3-30
 * Time: 下午8:05
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoSpec {
    public static Specification<User> getSpec(final String name,final int age,final String address) {
        return new Specification<User>() {

            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate p1 = null;
                if(name!=null) {
                    Predicate p2 = cb.equal(root.get(User_.name),name);
                    if(p1 != null) {
                        p1 = cb.and(p1,p2);
                    } else {
                        p1 = p2;
                    }
                }

                if(age!=0) {
                    Predicate p2 = cb.equal(root.get(User_.age), age);
                    if(p1 != null) {
                        p1 = cb.and(p1,p2);
                    } else {
                        p1 = p2;
                    }
                }

                if(!StringUtils.isEmpty(address)) {
                    Predicate p2 = cb.equal(root.get(User_.address), address);
                    if(p1 != null) {
                        p1 = cb.and(p1,p2);
                    } else {
                        p1 = p2;
                    }
                }

                return p1;
            }
        };
    }
}
