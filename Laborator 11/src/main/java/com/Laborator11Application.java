package com;

import com.springexamples.ClientComponent;
import com.springexamples.SingletonComponent;
import com.springexamples.TransientComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com")
public class Laborator11Application {

    public static void main(String[] args) {
          //SpringApplication.run(Laborator10Application.class, args);
        ApplicationContext context = SpringApplication.run(Laborator11Application.class, args);
        TransientComponent transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();

        transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();


        SingletonComponent singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();

        ClientComponent c = context.getBean(ClientComponent.class);

        c.operation();
        c = (ClientComponent) context.getBean("clientComponent");
        c.operation();
    }

}
