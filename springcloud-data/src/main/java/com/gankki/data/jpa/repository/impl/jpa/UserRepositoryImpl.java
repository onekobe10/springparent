package com.gankki.data.jpa.repository.impl.jpa;


import com.gankki.data.jpa.entity.User4Jpa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/22
 */
@Repository
public class UserRepositoryImpl {
//public class UserRepositoryImpl extends SimpleJpaRepository implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	/**
	 * JPA使用EntityManagerFactory开闭session，而Hibernate使用SessionFactory开闭session。两者区别：
	 *
	 * EntityManagerFactory是JPA的标准API，如果使用EntityManagerFactory，在更换实现JPA的ORM框架时，需要改动的代码很少。
	 * 如果使用SessionFactory，因为SessionFactory是Hibernate的，无法直接更换ORM框架，更换ORM的话，需要修改所有的代码。
	 * 如果想使用Hibernate的某些高级特性，只能使用SessionFactory，使用EntityManagerFactory无法享受Hibernate的高级用法。
	 *
	 * EntityManagerFactory	创建的session的session即使不手动关闭，自己也会在方法执行返回后关闭
	 * SessionFactory Hibernate创建的session必须手动关闭，如果不关，就会一致持有这个连接。
	 *
	 * Spring DATA JPA 使用的是JPA的API接口访问数据，默认使用的是Hibernate的实现
	 * 如果只使用JPA API访问数据，我们可以在不改变代码的情况下，切换持久层实现的框架，比如Hibernate和TopLink等
	 * 类似于log4j logback的关系
	 * @return
	 */

	/**
	 * Hibernate的session来获取数据
	 * @return
	 */
	public List<User4Jpa> testCustomMethod1(){
		String sql = " from User4Jpa ";
		Session session = entityManager.unwrap(Session.class);
		/**
		 * Hibernate 5.2版本下，session中只有HQL语句的Query，SQLQuery对象已经移除,session.createSQLQuery()方法已经过时
		 */
		Query query = session.createQuery(sql);

		return query.list();
	}

	/**
	 * 从EntityManagerFactory中获取SessionFactory再创建session会话来获取数据
	 * @return
	 */
	public List<User4Jpa> testCustomMethod2(){
		String sql = "from User4Jpa where id = 1";
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		/**
		 * SessionFactory继承了EntityManagerFactory sessionFactory也可以创建entityManager对象
 		 */
		EntityManager entityManager = sessionFactory.createEntityManager();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		return query.list();
	}

	/**
	 * 从JPA 中的会话EntityManager来获取数据
	 * @return
	 */
	public List<User4Jpa> testCustomMethod3(){
		return entityManager.createNativeQuery("select * from j_user t where t.user_id =1", User4Jpa.class).getResultList();
	}
}
