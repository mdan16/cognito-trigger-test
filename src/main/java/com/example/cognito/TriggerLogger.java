package com.example.cognito;

import com.amazonaws.services.lambda.runtime.Context;

import java.util.Map;

public class TriggerLogger {

    @SuppressWarnings("unchecked")
    public static void logEvent(Context context, Map<String, Object> event) {
        String triggerSource = (String) event.get("triggerSource");
        String userName = (String) event.get("userName");
        String userPoolId = (String) event.get("userPoolId");

        Map<String, Object> callerContext = (Map<String, Object>) event.get("callerContext");
        String clientId = callerContext != null ? (String) callerContext.get("clientId") : null;

        Map<String, Object> request = (Map<String, Object>) event.get("request");
        Map<String, Object> userAttributes = request != null ? (Map<String, Object>) request.get("userAttributes") : null;
        String sub = userAttributes != null ? (String) userAttributes.get("sub") : null;
        String email = userAttributes != null ? (String) userAttributes.get("email") : null;

        String message = String.format(
                "[%s] userName=%s sub=%s email=%s userPoolId=%s clientId=%s",
                triggerSource, userName, sub, email, userPoolId, clientId
        );

        if (context != null) {
            context.getLogger().log(message);
        } else {
            System.out.println(message);
        }
    }
}
