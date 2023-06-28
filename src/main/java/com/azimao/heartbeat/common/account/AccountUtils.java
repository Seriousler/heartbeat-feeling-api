package com.azimao.heartbeat.common.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.AccountNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @Author: 张隆
 * @Date: 2023/6/28 14:38
 * @Version: 1.0
 */
public final class AccountUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(AccountUtils.class);

    private AccountUtils() {
    }

    public static Account getByHeader(HttpServletRequest request) throws IOException, AccountNotFoundException {
        String json = request.getHeader("HF-ACCOUNT");
        if (json == null) {
            throw new AccountNotFoundException("在head中找不到account信息");
        } else {
            json = URLDecoder.decode(json, "UTF-8");
            Account account = (Account) OBJECT_MAPPER.readValue(json, Account.class);
            if (account != null && account.getUserCode() != null) {
                return account;
            } else {
                logger.error("获取header中账号的信息:{}", json);
                throw new AccountNotFoundException("head中的信息无效");
            }
        }
    }

}
