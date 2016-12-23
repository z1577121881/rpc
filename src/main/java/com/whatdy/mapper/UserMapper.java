package com.whatdy.mapper;

import com.whatdy.model.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Dao层
 */
//UserMapper.xml  中的mybatis 会自动向方法里面添加方法体逻辑.
@Repository
public interface UserMapper {

    /**
     * 添加新用户
     * @param user 用户数据
     * @return 用户id
     */
    public int insertUser(User user);

    /**
     * 根据id查询用户
     * @param id 用户id
     * @return 用户信息
     */
    public User selectUserById(int id);

    /**
     * 查询出所有的用户
     * @return 用户集合
     */
    public List<User> selectAllUser();

    /**
     * 用户信息更新
     * @param user 更新用户的的信息
     * @return 是否更新信息成功
     */
    public int updateUser(User user);

    /**
     * 删除用户
     * @param id 需要删除用户的id
     * @return  数据是否删除成功
     */
    public int deleteUser(int id);

    /**
     * 分页操作
     * @param map 分页条件
     * @return 分页结果
     */
    public List<User> pageUser(Map<String,Object> map);

    /**
     * 符合条件的数据条数
     * @param map 搜索条件
     * @return 符合条件的数据条数
     */
    public int countUser(Map<String,Object> map);


}