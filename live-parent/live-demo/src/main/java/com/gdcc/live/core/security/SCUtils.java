package com.gdcc.live.core.security;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.winit.common.spi.context.CommandContext;

public class SCUtils {

    private static ThreadLocal<CommandContext> commandContextLocal = new ThreadLocal<CommandContext>();

    public static void setCommandContextLocal(CommandContext ctx) {
        commandContextLocal.set(ctx);
    }

    public static CommandContext getCommandContextLocal() {
        return commandContextLocal.get();
    }

    public static void removeCommandContextLocal() {
        commandContextLocal.remove();
    }

    public static Date currentDate() {
        return new Date();
    }

    public static String currentUserId() {
        if (StringUtils.isNotEmpty(CommandContext.getContext().getUserId())) {
            return CommandContext.getContext().getUserId();
        }
        return "0";
    }

    public static Long currentOrgId() {
        if (CommandContext.getContext().getOrgId() != null) {
            return CommandContext.getContext().getOrgId();
        }
        return 0L;
    }
}
