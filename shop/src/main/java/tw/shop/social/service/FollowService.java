package tw.shop.social.service;

import tw.shop.social.dto.FollowDto;

public interface FollowService {
    FollowDto createFollow(FollowDto followDto);
    void removeFollow(Long id); // 可以根据需要添加更多方法
}
