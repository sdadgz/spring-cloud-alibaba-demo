package cn.sdadgz.mapper;

import cn.sdadgz.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sdadgz
 * @since 2023-02-23
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
