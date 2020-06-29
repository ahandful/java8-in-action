package lambdasinaction.owl;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String str="int";
        str=str.toUpperCase();
        System.out.println(DataType.valueOf(str).getValue());
    }
}
enum DataType {
    INT(1,"Int"),
    LONG(2,"Long"),
    DOUBLE(3,"Double"),
    STRING(4, "String"),
    BOOLEAN(5, "Boolean"),
    DATE(6, "Date"),
    DATETIME(7,"DateTime"),
    GEO(8, "Geo");

    /**
     * 枚举值
     */
    private Integer value;
    /**
     * jdbc类型
     */
    private String jdbcType;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    DataType(Integer value, String jdbcType) {
        this.value = value;
        this.jdbcType = jdbcType;
    }

    /**
     * 根据枚举值获取对应的jdbc类型
     *
     * @param value
     * @return
     */
    public static String getJdbcTypeByValue(Integer value) {
        if (value == null) {
            return null;
        }
        for (DataType type : Arrays.asList(DataType.values())) {
            if (type.getValue().equals(value)) {
                return type.getJdbcType();
            }
        }
        return null;
    }

    /**
     * 根据jdbc类型获取对应的枚举值
     *
     * @param jdbcType jdbc类型
     * @return
     */
    public static Integer geValueByValueByType(String jdbcType) {
        if (jdbcType == null) {
            return null;
        }
        for (DataType type : Arrays.asList(DataType.values())) {
            if (type.getJdbcType().equals(jdbcType)) {
                return type.getValue();
            }
        }
        return null;
    }
}
