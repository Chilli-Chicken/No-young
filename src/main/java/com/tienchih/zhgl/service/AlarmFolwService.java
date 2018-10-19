package com.tienchih.zhgl.service;

import com.tienchih.zhgl.entity.AlarmFolwRecord;
import com.tienchih.zhgl.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shin on 26/12/2017.
 */
public interface AlarmFolwService {

    Integer save(AlarmFolwRecord alarmFolwRecord);

    Page<AlarmFolwRecord> queryListByPage(Pageable pageable);

    void delete(Integer id);

    AlarmFolwRecord findById(Integer id);


}
