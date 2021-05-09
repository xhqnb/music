package com.xhq.music.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    /*
    * 验证密码是否正确
    * */
    public int verifyPassword(String username,String password);
}

