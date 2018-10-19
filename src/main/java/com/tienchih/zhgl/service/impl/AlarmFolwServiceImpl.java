package com.tienchih.zhgl.service.impl;

import com.tienchih.zhgl.dao.AlarmFolwDao;
import com.tienchih.zhgl.dao.UserInfoDao;
import com.tienchih.zhgl.entity.AlarmFolwRecord;
import com.tienchih.zhgl.entity.UserInfo;
import com.tienchih.zhgl.service.AlarmFolwService;
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
public class AlarmFolwServiceImpl implements AlarmFolwService {

    @Autowired
    private AlarmFolwDao alarmFolwDao;

    @Override
    public Integer save(AlarmFolwRecord alarmFolwRecord) {
        alarmFolwRecord.setCreateDate(DateUtil.getTime());
        AlarmFolwRecord save = alarmFolwDao.save(alarmFolwRecord);
        return save.getId();
    }

    @Override
    public Page<AlarmFolwRecord> queryListByPage(Pageable pageable) {
        return alarmFolwDao.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        alarmFolwDao.delete(id);
    }

    @Override
    public AlarmFolwRecord findById(Integer id) {
        return alarmFolwDao.findOne(id);
    }


}
