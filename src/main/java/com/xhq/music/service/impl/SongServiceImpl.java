package com.xhq.music.service.impl;

import com.xhq.music.dao.SongMapper;
import com.xhq.music.domain.Song;
import com.xhq.music.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private SongMapper songMapper;


    @Override
    public boolean insert(Song song) {
        return songMapper.insert(song)>0;
    }

    @Override
    public boolean update(Song song) {
        return songMapper.update(song)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return songMapper.delete(id)>0;
    }

    @Override
    public Song selectByPrimaryKey(Integer id) {
        return songMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Song> allSong() {
        return songMapper.allSong();
    }

    @Override
    public List<Song> songOfName(String name) {
        return songMapper.songOfName(name);
    }

    @Override
    public List<Song> likeSongOfName(String name) {
        return songMapper.likeSongOfName(name);
    }

    @Override
    public List<Song> songOfSingerId(Integer singerId) {
        return songMapper.songOfSingerId(singerId);
    }
}
