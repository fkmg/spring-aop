package com.sxt.transcantion;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

import java.util.Date;

@Component
public class SelfTransactionManager {

    private TransactionStatus transactionStatus;

    private static Log log = LogFactory.getLog(SelfTransactionManager.class);

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    /**
     * 手动开启事务
     * @return
     */
    public TransactionStatus begin(String qualifier){
        Date now = new Date();
        DefaultTransactionAttribute attribute = new DefaultTransactionAttribute();
        attribute.setQualifier(qualifier);
        transactionStatus = dataSourceTransactionManager.getTransaction(attribute);
        log.debug(DateFormatUtils.format(now,"yyyy/MM/dd HH:mm:ss")+"开启了事务");
        return transactionStatus;
    }

    /**
     * 提交事务
     * @param transactionStatus
     */
    public void commit(TransactionStatus transactionStatus){
        Date now = new Date();
        dataSourceTransactionManager.commit(transactionStatus);
        log.debug(DateFormatUtils.format(now,"yyyy/MM/dd HH:mm:ss")+"提交了事务");

    }

    /**
     * 回滚事务
     */
    public void rollBack(){
        Date now = new Date();
        dataSourceTransactionManager.rollback(transactionStatus);
        log.debug(DateFormatUtils.format(now,"yyyy/MM/dd HH:mm:ss")+"回滚了事务");
    }
}
