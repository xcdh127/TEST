package zhuowangshuma;

interface Invocation{
    String name="Jack";
    String age="15";
    String getName();
    String getAge();
    String getSex();
}
abstract class AbstractName implements Invocation{
    public String name="Bob";
    @Override
    public String getSex(){
        return "男";
    }
    @Override
    public String getAge(){
        return "10";
    }
    @Override
    public String getName(){
        return name;
    }


}
public class AbstractNameImpl extends AbstractName {
    @Override
    public String getSex(){
        return "女";
    }
    public static void main(String[] args) {
        AbstractName name=new AbstractNameImpl();
        System.out.println(name.getName());
        System.out.println(name.getAge());
        System.out.println(name.getSex());
    }
}
