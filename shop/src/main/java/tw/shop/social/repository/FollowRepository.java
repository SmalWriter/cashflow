package tw.shop.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.shop.social.model.Follow;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    // 这里可以添加查找特定用户的关注者或被关注者的方法
}
