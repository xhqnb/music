package com.xhq.music.service.impl;

import com.xhq.music.dao.SingerMapper;
import com.xhq.music.domain.Singer;
import com.xhq.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//歌手service实现类
@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerMapper singerMapper;

    @Override
    public boolean insertSinger(Singer singer) {
        return false;
    }

    @Override
    public boolean update(Singer singer) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Singer selectById(Integer id) {
        return null;
    }

    @Override
    public List<Singer> allSinger() {
        return null;
    }

    @Override
    public List<Singer> singerOfName(String name) {
        return null;
    }

    @Override
    public List<Singer> singerOfSex(Integer sex) {
        return null;
    }
}
