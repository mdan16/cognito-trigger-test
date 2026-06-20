package com.example.cognito.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.cognito.TriggerLogger;

import java.util.Map;

/**
 * Lambda設定:
 *   ハンドラー: com.example.cognito.handler.CognitoTriggerHandler::handleRequest
 *   ランタイム: java21
 *
 * PostConfirmation・PreTokenGeneration の両トリガーにこの関数を指定してください。
 */
public class CognitoTriggerHandler implements RequestHandler<Map<String, Object>, Map<String, Object>> {

    @Override
    public Map<String, Object> handleRequest(Map<String, Object> event, Context context) {
        TriggerLogger.logEvent(context, event);
        return event;
    }
}
