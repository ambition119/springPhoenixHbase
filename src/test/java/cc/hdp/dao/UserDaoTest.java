package cc.hdp.dao;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cc.hdp.entity.User;
import cc.hdp.service.UserService;


//@RunWith(SpringJUnit4ClassRunner.class) 
//@ContextConfiguration(locations="/applicationContext.xml") 
//@Transactional 
public class UserDaoTest {
//	@Autowired
	private static UserService userService;
	
	@BeforeClass 
	 public static void init() { 
		 ApplicationContext 
		 context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		 userService = (UserService)context.getBean("userServiceImpl"); 
	 } 

//	@Test
//	public void testAdd(){
//		User user = new User();
//		user.setId("1008");
//		user.setUserName("zhaoliu");
//		user.setPassword("zl1008");
//		
//		userService.addUser(user);
//	}
	
	@Test
	public void find(){
		List<User> findAll = userService.findAll();
		for (User user : findAll) {
			System.out.println(user);
		}
	}
}
