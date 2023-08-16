package com.azimao.heartbeat.common.interceptor;

import com.azimao.heartbeat.common.account.Account;
import com.azimao.heartbeat.common.account.AccountThreadLocal;
import com.azimao.heartbeat.common.account.AccountUtils;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.AccountNotFoundException;
import java.io.IOException;

@Component
public class BaseInterceptor2 implements HandlerInterceptor {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${sys.dev}")
    String devModel;

    @PostConstruct
    public void init() {
        logger.info("---------------------拦截器初始化-----------------------------------BaseInterceptor");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        try {
            Account account = AccountUtils.getByHeader(request);
            AccountThreadLocal.set(account);
            if (logger.isDebugEnabled()) {
                logger.debug("从网关获取的登录信息:用户编码[{}],是否管理员[{}],角色ID[{}],角色编码[{}],角色名称[{}]", account.getUserCode(),
                        account.getIsManager(), account.getRoleIds(), account.getRoleCodes(), account.getRoleNames());
            }
            return true;
        } catch (IOException | AccountNotFoundException e) {
            // 暂时设置默认的登录信息,用于controller获取登录信息的开发需求
            if ("true".equals(devModel)) {
                Account account = new Account();
                // 标签业务员创建申请
                account.setUserId(1017);
                account.setUserCode("develop");
                account.setUserName("开发者");
                account.setRoleIds("1,2,3");
                account.setRoleCodes("001,002,003");
                account.setRoleNames("角色1,角色2,角色3");
                account.setOrgId(3);
                account.setOrgCode("bdp");
                account.setOrgName("大数据");
                account.setIsManager(1);
                AccountThreadLocal.set(account);
                return true;
            }
            throw e;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
        // 必须及时删除当前线程的用户信息
        AccountThreadLocal.remove();
        if (modelAndView != null) {
            // 返回当前版本号
            request.setAttribute("VERSION", "1.0.0");
        }
    }

}