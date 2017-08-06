package dao;

import entity.UserInfo;

public class UserInfoDao extends AbsDao {
    private UserInfo userInfo;

    public UserInfoDao() {
        userInfo = new UserInfo();
    }

    public UserInfo request() {
        String json = makeRequest("user_info");
//        System.out.println("=================================UserInfo==============================\n" + json);
        return userInfo.jsonParce(json);
    }
}
