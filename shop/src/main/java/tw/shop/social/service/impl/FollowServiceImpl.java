package tw.shop.social.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.shop.social.dto.FollowDto;
import tw.shop.social.model.Follow;
import tw.shop.social.repository.FollowRepository;
import tw.shop.social.service.FollowService;

@Service
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FollowServiceImpl(FollowRepository followRepository, ModelMapper modelMapper) {
        this.followRepository = followRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FollowDto createFollow(FollowDto followDto) {
        Follow follow = modelMapper.map(followDto, Follow.class);
        follow = followRepository.save(follow);
        return modelMapper.map(follow, FollowDto.class);
    }

    @Override
    public void removeFollow(Long id) {
        followRepository.deleteById(id);
    }
}
