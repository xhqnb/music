package com.xhq.music.service;

import com.xhq.music.domain.Singer;
import org.springframework.stereotype.Service;

import java.util.List;

//歌手service接口
@Service
public interface SingerService {

    public boolean insertSinger(Singer singer);
    public boolean update(Singer singer);
    public boolean delete(Integer id);
    public Singer selectById(Integer id);
    public List<Singer> allSinger();
    public List<Singer> singerOfName(String name);
    public List<Singer> singerOfSex(Integer sex);
}
