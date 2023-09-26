package com.fyers.fyers.enums;

public enum HistoryDataParams {
    SYMBOL("symbol"),
    RESOLUTION("resolution"),
    DATE_FORMAT("date_format"),
    RANGE_FROM("range_from"),
    RANGE_TO("range_to"),
    CONT_FLAG("cont_flag");

    private final  String value;
    HistoryDataParams(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
