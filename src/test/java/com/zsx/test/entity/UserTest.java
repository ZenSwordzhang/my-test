package com.zsx.test.entity;

import com.zsx.action.ISing;
import com.zsx.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.Serializable;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserTest {

    @Test
    void testSerializable() {
        Assertions.assertTrue(Serializable.class.isAssignableFrom(User.class));
    }

    @Test
    void testISing() {
        Assertions.assertTrue(ISing.class.isAssignableFrom(User.class));
        User user = new User();
        user.singer = true;
        Assertions.assertTrue(((ISing) user).isSinger());
        User user1 = new User();
        user1.singer = false;
        Assertions.assertFalse(((ISing) user1).isSinger());
    }

}
