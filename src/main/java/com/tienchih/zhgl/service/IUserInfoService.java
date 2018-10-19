package com.tienchih.zhgl.service;

import com.tienchih.zhgl.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shin on 26/12/2017.
 */
public interface IUserInfoService {

    Integer save(UserInfo userInfo);

    Page<UserInfo> queryListByPage(Pageable pageable);

    void delete(Integer id);

    UserInfo findById(Integer id);

    UserInfo validate(String userName, String password);

}
