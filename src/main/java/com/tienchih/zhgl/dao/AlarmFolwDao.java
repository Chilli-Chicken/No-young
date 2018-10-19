package com.tienchih.zhgl.dao;

import com.tienchih.zhgl.entity.AlarmFolwRecord;
import com.tienchih.zhgl.entity.UserInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


/**
 * Created by Shin on Sep 29, 2017.
 */
public interface AlarmFolwDao extends PagingAndSortingRepository<AlarmFolwRecord, Integer> {

}
