//package com.neu.api.service.impl;
//
//import com.neu.api.mapper.SchoolMapper;
//import com.neu.api.service.SchoolService;
//import com.neu.api.vo.SchoolVO;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.util.DigestUtils;
//
//import javax.annotation.Resource;
//
//@Service
//public class SchoolServiceImpl implements SchoolService {
//
//    @Value("${neu.password}")
//    private String password;
//
//    @Resource
//    SchoolMapper schoolMapper;
//
//    @Override
//    public SchoolVO login(String name, String password) {
//        password = DigestUtils.md5DigestAsHex((password).getBytes()); //MD5
//        return schoolMapper.login(name,password);
//    }
//}