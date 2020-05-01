package chess;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class BeanLoggingBeans implements ApplicationContextAware, InitializingBean {
    private ApplicationContext ctx;
    private Logger logger;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        String[] beansNames = ctx.getBeanDefinitionNames();
        logger = LogManager.getLogger();
        for (String beansName : beansNames) {
            logger.info(beansName);
        }
    }
}
