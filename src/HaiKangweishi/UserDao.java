package HaiKangweishi;

interface Proxy{
    void save();
}
//目标对象
public class UserDao implements Proxy{
    @Override
    public void save() {
        System.out.println("保存逻辑");
    }

    public static void main(String[] args) {
        UserDaoProxy userDaoProxy=new UserDaoProxy(new UserDao());
        userDaoProxy.save();
    }
}
//代理对象
class UserDaoProxy implements Proxy{
    private Proxy userDao;

    public UserDaoProxy(Proxy userDao){
        this.userDao=userDao;
    }

    @Override
    public void save() {
        System.out.println("开启事务");
        userDao.save();
        System.out.println("关闭事务");

    }
}


