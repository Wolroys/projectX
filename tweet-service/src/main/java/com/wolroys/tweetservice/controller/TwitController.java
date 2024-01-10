package com.wolroys.tweetservice.controller;

import com.wolroys.entitymodule.dto.PostDto;
import com.wolroys.entitymodule.request.HashtagRequest;
import com.wolroys.tweetservice.service.TwitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/twitter")
public class TwitController {

    private final TwitService twitService;

    @GetMapping
    public List<PostDto> getAll(){
        return twitService.findAll();
    }

    @PostMapping("/twit")
    public PostDto findTwit(@RequestBody Long id){
        return twitService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/newTwit")
    public PostDto postTwit(@RequestBody PostDto postDto){
        return twitService.create(postDto);
    }

    @PatchMapping("/edit/{id}")
    public PostDto updateTwit(@PathVariable Long id, @RequestBody PostDto updatedPost){
        return twitService.update(id, updatedPost)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping
    public void deleteTwit(@RequestBody Long id){
        if (!twitService.delete(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/twitsByHashtags")
    public List<PostDto> getPostsByHashtags(@RequestBody HashtagRequest hashtags) {
        List<String> list = hashtags.getHashtags();
        return twitService.findByHashtags(list);
                                                                                                                                                                                                                                                                                                                                         }
}
