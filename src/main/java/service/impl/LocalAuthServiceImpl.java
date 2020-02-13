package service.impl;

import dao.LocalAuthDao;
import dao.PersonInfoDao;
import entity.LocalAuth;
import entity.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.LocalAuthService;

import java.util.Date;

@Service
public class LocalAuthServiceImpl implements LocalAuthService {

    @Autowired
    private LocalAuthDao localAuthDao;

    @Override
    public LocalAuth getLocalAuthByUsernameAndPwd(String username, String password) {
//        return localAuthDao.queryLocalByUserNameAndPwd(username, MD5.getMd5(password));

        return localAuthDao.queryLocalByUserNameAndPwd(username, password);
    }

    @Override
    public LocalAuth getLocalAuthByUserId(long userId) {
        return localAuthDao.queryLocalByUserId(userId);
    }

    @Override
    public LocalAuth getLocalAuthByUserName(String userName) {
        return localAuthDao.queryLocalByUserName(userName);
    }


    @Override
    public int insertLocalAuth(LocalAuth localAuth ) {


        return localAuthDao.insertLocalAuth(localAuth);
    }

    @Override
    public int updatePassword(String username, String password, String newPassword) {
        return localAuthDao.updatePassword(username,password,newPassword,new Date());
    }

    @Override
    public int insertLocalAuth(int userId, String userName, String password) {
        //设置上用户名和密码
        LocalAuth localAuth = new LocalAuth();
        localAuth.setUserId(userId);
        localAuth.setUsername(userName);
        localAuth.setPassword(password);
        localAuth.setCreateTime(new Date());
        return localAuthDao.insertLocalAuth(localAuth);
    }

}
