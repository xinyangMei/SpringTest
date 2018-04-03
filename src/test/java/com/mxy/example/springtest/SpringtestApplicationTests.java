package com.mxy.example.springtest;

import com.mxy.example.SpringtestApplication;
import com.mxy.example.event.TestEvent;
import com.mxy.example.listerer.AnnotationListener;
import com.mxy.example.publish.InterfaceTest;
import com.mxy.example.publish.TestPublish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringtestApplication.class)
public class SpringtestApplicationTests {

    @Autowired
    private TestPublish testPublish;
    @Autowired
    private AnnotationListener annotationListener;

    @Test
    public void testEvent() {
        Map map = new HashMap();

        TestEvent testEvent = new TestEvent("tag");
        testPublish.publish(testEvent);
    }

    @Test
    public void testAsync() throws InterruptedException {
        TestEvent testEvent = new TestEvent("tag");
        annotationListener.dealTestEvent(testEvent);
        System.out.println("sjdka");
    }

    @Test
    public void testProxy() {
        Class<InterfaceTest> interfaceTestClass = InterfaceTest.class;
        Object proxy = Proxy.newProxyInstance(interfaceTestClass.getClassLoader(), new Class[]{interfaceTestClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxy");
//                method.invoke(proxy, args);
                return null;
            }
        });
        if (proxy instanceof InterfaceTest) {
            ((InterfaceTest) proxy).sayHello();
        }
    }

}
