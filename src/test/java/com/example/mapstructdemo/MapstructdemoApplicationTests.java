package com.example.mapstructdemo;

import com.example.mapstructdemo.dto.UserRoleDto;
import com.example.mapstructdemo.entity.Role;
import com.example.mapstructdemo.entity.User;
import com.example.mapstructdemo.mapper.UserRoleMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapstructdemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    User user = null;

    /**
     * 模拟从数据库中查出user对象
     */
    @Before
    public void before() {
        Role role = new Role(2L, "administrator", "超级管理员");
        user = new User(1L, "张三", "123456", "18858745333", "123@qq.com", role);
    }

    /**
     * 模拟把user对象转成UserRoleDto对象
     */
    @Test
    public void test1() {
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setUserId(user.getId());
        userRoleDto.setName(user.getUsername());
        userRoleDto.setRoleName(user.getRole().getRoleName());
        System.out.println(userRoleDto);
    }

    @Test
    public void test2() {
        UserRoleDto userRoleDto = UserRoleMapper.INSTANCES.toUserRoleDto(user);
        System.out.println(userRoleDto);
    }

}
