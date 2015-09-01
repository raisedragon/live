package com.raise.core.query;


public class Criterion {

    private String           propertyName;    // 实体属性
    private CriteriaOperator criteriaOperator; // 何种比较方式
    private Object           value;           // 进行比较的值


    public Criterion(String propertyName, CriteriaOperator criteriaOperator, Object value){
        this.propertyName = propertyName;
        this.value = value;
        this.criteriaOperator = criteriaOperator;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public CriteriaOperator getCriteriaOperator() {
        return criteriaOperator;
    }

    public void setCriteriaOperator(CriteriaOperator criteriaOperator) {
        this.criteriaOperator = criteriaOperator;
    }

    public boolean isNoValue() {
        int size = valueSize(this.criteriaOperator);
        return 0 == size;
    }

    public boolean isSingleValue() {
        int size = valueSize(this.criteriaOperator);
        return 1 == size;
    }

    public boolean isDoubleValue() {
        int size = valueSize(this.criteriaOperator);
        return 2 == size;
    }

    public boolean isListValue() {
        int size = valueSize(this.criteriaOperator);
        return -1 == size;
    }

    private int valueSize(CriteriaOperator criteriaOperator) {
        int size = 1;
        switch (criteriaOperator) {
            case IsNull:
            case IsNotNull:
                size = 0;
                break;
            case Equal:
            case LessThanOrEqual:
            case GreaterThanOrEqual:
            case NotEqual:
            case Like:
            case FirstLike:
            case LastLike:
            case NotLike:
            case NotFirstLike:
            case NotLastLike:
                size = 1;
                break;
            case In:
            case NotIn:
                size = -1;
                break;
            case Between:
            case NotBetween:
                size = 2;
                break;
        }
        return size;
    }
}
