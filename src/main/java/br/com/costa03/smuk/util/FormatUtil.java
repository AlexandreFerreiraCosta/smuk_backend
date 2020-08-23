package br.com.costa03.smuk.util;

import lombok.NoArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public final class FormatUtil {
    private static final Logger log = LoggerFactory.getLogger(FormatUtil.class);

    public static String formatSituacao(Boolean situacao) {
        if (BooleanUtils.isTrue(situacao)) {
            return "true";
        } else {
            return "false";
        }
    }

    public static String formatData(LocalDateTime data) {
        if (data == null) {
            return "";
        }
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
