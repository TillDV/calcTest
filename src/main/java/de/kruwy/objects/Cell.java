package de.kruwy.objects;


public class Cell {

    private String content;
    private String value;
    boolean calcMode = false;


    void refreshCalcMode() {
        if (content.startsWith("=")) {
            calcMode = false;
        } else calcMode = true;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void updateValue() {
        value = content;
        refreshCalcMode();
        if (calcMode = false) {
            return;
        }
        value = value.substring(1);
    }

    public String getValue() {
        return value;
    }
}
