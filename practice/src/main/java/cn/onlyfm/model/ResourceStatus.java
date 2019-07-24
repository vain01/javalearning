package cn.onlyfm.model;

/**
 * Created by root on 2015/12/16 0016.
 */
public enum ResourceStatus {
    DISPLAY("显示"),
    INVISIBLE("隐藏"),
    ;

    private String type;
    private ResourceStatus(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return type;
    }
}
