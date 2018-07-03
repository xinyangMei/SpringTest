package com.mxy.example.springtest;

import com.mxy.example.SpringtestApplication;
import com.mxy.example.event.AnnotationEvent;
import com.mxy.example.event.MsgAEvent;
import com.mxy.example.event.MsgASubEvent;
import com.mxy.example.publish.AnnotationPublish;
import com.mxy.example.publish.InterfaceTest;
import com.mxy.example.publish.PublishSubEvent;
import com.mxy.example.publish.TestPublish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@RunWith(SpringRunner.class)
@EnableAsync
@SpringBootTest(classes = SpringtestApplication.class)
public class SpringtestApplicationTests {

    @Autowired
    private TestPublish testPublish;
    @Autowired
    private PublishSubEvent publishSubEvent;
    @Autowired
    private AnnotationPublish annotationPublish;
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Test
    public void testEvent() {
        MsgAEvent msgAEvent = new MsgAEvent("tag");
        testPublish.publish(msgAEvent);
        logger.info("# publish end ");
    }

    @Test
    public void testSubEvent() {
        MsgASubEvent msgAEvent = new MsgASubEvent("submsg");
        publishSubEvent.publish(msgAEvent);
        logger.info("# publish end ");
    }

    @Test
    public void testAnnotationListener() throws InterruptedException {
        AnnotationEvent typeA = new AnnotationEvent("source", "typeA", "msg of type_A");
        annotationPublish.publish(typeA);
        AnnotationEvent typeB = new AnnotationEvent("source", "typeB", "msg of type_B");
        annotationPublish.publish(typeB);
        Thread.sleep(10*1000);
    }

    @Test
    public void testProxy() {
        Class<InterfaceTest> interfaceTestClass = InterfaceTest.class;
        Object proxy = Proxy.newProxyInstance(interfaceTestClass.getClassLoader(),
                new Class[]{interfaceTestClass}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
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
