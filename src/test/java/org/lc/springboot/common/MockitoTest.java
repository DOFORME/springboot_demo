package org.lc.springboot.common;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

//这两个注解不加则不会加载IOC容器
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MockitoTest {

    @Before
    public void setUp() {
        // 初始化测试用例类中由Mockito的注解标注的所有模拟对象
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mockTest() {
//        Teacher teacher = new Teacher();
//        teacher.setId(1);
//        teacher.setName("mock");
//        TeacherJpaDao dao = mock(TeacherJpaDao.class);
//        when(dao.getById(0)).thenReturn(teacher);
//        System.out.println(new Gson().toJson(dao.getById(0)));
    }
}