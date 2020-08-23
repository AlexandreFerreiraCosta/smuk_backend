package br.com.costa03.smuk.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;

public class HeaderUtil {
    private static final Logger log = LoggerFactory.getLogger(HeaderUtil.class);
    @Value("${spring.application.name}")
    private String applicationName;

    public HeaderUtil() {
    }

    public HttpHeaders createAlert(String message, String param) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-" + this.applicationName + "-alert", message);
        headers.add("X-" + this.applicationName + "-params", param);
        return headers;
    }

    public HttpHeaders createEntityCreationAlert(String entityName, String param) {
        return this.createAlert("A new " + entityName + " is created with identifier " + param, param);
    }

    public HttpHeaders createEntityUpdateAlert(String entityName, String param) {
        return this.createAlert("A " + entityName + " is updated with identifier " + param, param);
    }

    public HttpHeaders createEntityDeletionAlert(String entityName, String param) {
        return this.createAlert("A " + entityName + " is deleted with identifier " + param, param);
    }

    public HttpHeaders createFailureAlert(String entityName, String defaultMessage) {
        log.error("Falha ao processar entidade, {}", defaultMessage);
        HttpHeaders headers = new HttpHeaders();
        headers.add(this.getErrorHeaderName(), defaultMessage);
        headers.add("X-" + this.applicationName + "-params", entityName);
        return headers;
    }

    public HttpHeaders createErrorMessageAlert(String defaultMessage) {
        log.error("Erro ao processar entidade, {}", defaultMessage);
        HttpHeaders headers = new HttpHeaders();
        headers.add(this.getErrorHeaderName(), defaultMessage);
        return headers;
    }

    public String getErrorHeaderName() {
        return "X-" + this.applicationName + "-error";
    }
}
