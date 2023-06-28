package com.azimao.heartbeat.common.account;

/**
 * @Author: 张隆
 * @Date: 2023/6/28 14:40
 * @Version: 1.0
 */
public final class AccountThreadLocal {

    private static final ThreadLocal<Account> LOCAL = new ThreadLocal();

    private AccountThreadLocal() {
    }

    public static void set(Account account) {
        if (account == null) {
            remove();
        } else {
            LOCAL.set(account);
        }

    }

    public static Account get() {
        return (Account) LOCAL.get();
    }

    public static void remove() {
        LOCAL.remove();
    }

}
