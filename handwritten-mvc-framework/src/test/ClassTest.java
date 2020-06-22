import com.tison.framework.util.ClassUtil;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.Enumeration;
import java.util.Set;

public class ClassTest {

    @Test
    public void test() throws Exception{
        Enumeration<URL> urls = ClassUtil.getClassLoader().getResources("com/tison/framework");
        while (urls.hasMoreElements()){
            URL url = urls.nextElement();
            System.out.println(url.getProtocol());
        }


        Set<Class<?>> clzSet = ClassUtil.getClassSet("com.tyshawn.framework");
        for (Class clazz : clzSet){
            System.out.println(clazz.toString());
        }
    }
}
