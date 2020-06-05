import java.time.ZonedDateTime;

/**
 * created by king on 2020/4/23 3:44 下午
 */
public class T1 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        //输出为 2020-04-23T15:45:46.581+08:00[Asia/Shanghai]
    }
}
