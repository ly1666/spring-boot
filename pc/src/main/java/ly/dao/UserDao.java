package ly.dao;

import ly.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    Integer insert(UserEntity userEntity);

}
