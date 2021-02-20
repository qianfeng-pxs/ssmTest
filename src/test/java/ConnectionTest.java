import org.junit.Test;
import redis.clients.jedis.Jedis;

public class ConnectionTest {


    @Test
    public  void connection(){

        Jedis jedis = new Jedis("192.168.140.128",6379);
        String result = jedis.ping();
        System.out.println(result);
        jedis.set("b","pxs");
        String a = jedis.get("a");
        System.out.println(a);
        jedis.close();

    }




}
