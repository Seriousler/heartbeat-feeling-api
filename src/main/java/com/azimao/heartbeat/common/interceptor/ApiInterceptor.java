package com.azimao.heartbeat.common.interceptor;

import com.azimao.heartbeat.common.account.Account;
import com.azimao.heartbeat.common.account.AccountThreadLocal;
import com.azimao.heartbeat.common.util.JwtUtils;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ApiInterceptor implements HandlerInterceptor {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostConstruct
    public void init() {
        logger.info("---------------------拦截器初始化-----------------------------------ApiInterceptor");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        try {
            logger.info("ApiInterceptor....");
            String jwtToken = request.getHeader("jwtToken");
            if (StringUtils.isBlank(jwtToken)) {
                return false;
            }
            String openid = JwtUtils.getOpenidByJwtToken(jwtToken);
            Account account = new Account();
            account.setOpenid(openid);
            AccountThreadLocal.set(account);
            if (logger.isDebugEnabled()) {
                logger.debug("获取的登录信息:用户openid[{}]", account.getOpenid());
            }
            return true;
        } catch (Exception e) {
            Account account = new Account();
            account.setOpenid("develop");
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