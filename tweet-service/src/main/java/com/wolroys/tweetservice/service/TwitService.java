package com.wolroys.tweetservice.service;

import com.wolroys.entitymodule.dto.PostDto;
import com.wolroys.entitymodule.entity.Post;
import com.wolroys.entitymodule.mapper.TwitMapper;
import com.wolroys.tweetservice.repository.TwitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TwitService {

    private final TwitRepository twitRepository;
    private final TwitMapper mapper;

    public List<PostDto> findAll(){
        return twitRepository.findAll()
                .stream().map(twit ->
                        mapper.mapToDtoOrEntity(twit, PostDto.class))
                .toList();
    }

    public Optional<PostDto> findById(Long id){
        return twitRepository.findById(id)
                .map(twit -> mapper.mapToDtoOrEntity(twit, PostDto.class));
    }

    @Transactional
    public PostDto create(PostDto postDto){
        Post post = mapper.mapToDtoOrEntity(postDto, Post.class);

        twitRepository.save(post);

        return mapper.mapToDtoOrEntity(post, PostDto.class);
    }

    @Transactional
    public Optional<PostDto> update(Long id, PostDto updatedPost){
        return twitRepository.findById(id)
                .map(twit -> {
                    mapper.update(updatedPost, twit);
                    twitRepository.saveAndFlush(twit);
                    return mapper.mapToDtoOrEntity(twit, PostDto.class);
                });
    }

    @Transactional
    public boolean delete(Long id){
        return twitRepository.findById(id)
                .map(twit -> {
                    twitRepository.delete(twit);
                    twitRepository.flush();
                    return true;
                }).orElse(false);
    }
}
