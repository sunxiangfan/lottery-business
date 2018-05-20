package com.lottery;

import com.lottery.common.UUIDUtils;
import com.lottery.dto.BankCardDTO;
import com.lottery.service.BankCardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BankCardTest {
    @Autowired
    //private BankCardService bankCardService;
    @Test
    public void insertSelective(){
        /*BankCardDTO bankCardDTO = new BankCardDTO();
        bankCardDTO.setId(UUIDUtils.getUUID());
        bankCardDTO.setCardHolder("1111111111");
        bankCardDTO.setCardNum("22222222");
        bankCardDTO.setUserId("222222");
        System.out.println(bankCardService.insertSelective(bankCardDTO));*/
    }
}
