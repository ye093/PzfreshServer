package cn.yejy;

import cn.yejy.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    MemberService service;

    @Test
    public void test() {
        System.out.println(service.findUserByMobile("13630159257"));
    }
}
