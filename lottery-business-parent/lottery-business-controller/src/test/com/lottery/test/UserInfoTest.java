package com.lottery.test;


import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoTest {
//    @Autowired
//    RegisteredService registeredService;
//    @Test
//    public void insertUserInfo() throws Exception {
//        UserInfoDTO userInfoDTO = new UserInfoDTO();
//        userInfoDTO.setLoginName("18581505760");
//        userInfoDTO.setLoginPswd("000000");
//        userInfoDTO.setIsLock("N");
//        userInfoDTO.setPUserId("0");
//        System.out.println("--------------------"+registeredService.insertUserInfo(userInfoDTO));
//    }
//    @Test
//    public void createValidateCode(){
//        ValidateCodeDTO v = new ValidateCodeDTO();
//        v.setWidth(160);
//        v.setHeight(40);
//        v.setCodeCount(5);
//        v.setLineCount(150);
//        ValidateCode vCode = registeredService.createValidateCode(v);
//        try {
//            String path="D:/"+new Date().getTime()+".png";
//            System.out.println(vCode.getCode()+" >"+path);
//            vCode.write(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void verifyUserNameRepeat(){
//        System.out.println("-------------"+registeredService.verifyUserNameRepeat("18581505760"));
//    }
}
