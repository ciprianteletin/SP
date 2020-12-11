package com.springexamples;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component
@Scope(value = SCOPE_PROTOTYPE)
public class TransientComponent {
    public TransientComponent() {
        System.out.println("TransientComponent::TransientComponent = " +
                this);
    }

    public void operation() {
        System.out.println("Invoked TransientComponent::operation() on " +
                this);
    }
}
