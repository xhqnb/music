package com.xhq.music.dao;

import com.xhq.music.domain.Singer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerMapper {
    /*
    * 验证密码是否正确
    * */
    public int insertSinger(Singer singer);
    public int update(Singer singer);
    public int delete(Integer id);
    public Singer selectById(Integer id);
    public List<Singer> allSinger();
    public List<Singer> singerOfName(String name);
    public List<Singer> singerOfSex(Integer sex);
}

