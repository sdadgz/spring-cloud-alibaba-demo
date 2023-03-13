package cn.sdadgz.service.impl;

import cn.sdadgz.entity.User;
import cn.sdadgz.mapper.UserMapper;
import cn.sdadgz.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sdadgz
 * @since 2023-02-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
