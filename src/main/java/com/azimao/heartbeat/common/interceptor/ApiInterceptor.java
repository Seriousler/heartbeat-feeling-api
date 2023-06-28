package com.azimao.heartbeat.common.interceptor;

import com.azimao.heartbeat.common.account.AccountThreadLocal;
import com.azimao.heartbeat.common.account.Account;
import com.azimao.heartbeat.common.account.AccountUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.AccountNotFoundException;
import java.io.IOException;

@Component
public class ApiInterceptor implements HandlerInterceptor {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        try {
            Account account = AccountUtils.getByHeader(request);
            AccountThreadLocal.set(account);
            if (logger.isDebugEnabled()) {
                logger.debug("获取的登录信息:用户编码[{}],是否管理员[{}],角色ID[{}],角色编码[{}],角色名称[{}]", account.getUserCode(),
                        account.getIsManager(), account.getRoleIds(), account.getRoleCodes(), account.getRoleNames());
            }
            return true;
        } catch (IOException | AccountNotFoundException e) {
            Account account = new Account();
            account.setOpenid("0");
            account.setUserId(0);
            account.setUserCode("develop");
            account.setUserName("开发");
            account.setNickName("阿兹猫");
            account.setOrgId(0);
            account.setOrgCode("development");
            account.setOrgName("研发部");
            account.setRoleIds("0");
            account.setRoleCodes("000");
            account.setRoleNames("角色0");
            account.setIsManager(0);
            AccountThreadLocal.set(account);
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
        // 必须及时删除当前线程的用户信息
        AccountThreadLocal.remove();
    }

}