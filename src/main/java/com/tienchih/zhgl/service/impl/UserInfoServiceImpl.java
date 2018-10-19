package com.tienchih.zhgl.service.impl;

import com.tienchih.zhgl.dao.UserInfoDao;
import com.tienchih.zhgl.entity.UserInfo;
import com.tienchih.zhgl.service.IUserInfoService;
import com.tienchih.zhgl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by shin on 26/12/2017.
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public Integer save(UserInfo userInfo) {
        userInfo.setCreateTime(DateUtil.getTime());
        UserInfo save = userInfoDao.save(userInfo);
        return save.getId();
    }

    @Override
    public Page<UserInfo> queryListByPage(Pageable pageable) {
        return userInfoDao.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        userInfoDao.delete(id);
    }

    @Override
    public UserInfo findById(Integer id) {
        return userInfoDao.findOne(id);
    }

    @Override
    public UserInfo validate(String userName, String password) {
        UserInfo userInfo = userInfoDao.findByUserNameAndPassword(userName, password);
        return userInfo;
    }

}
