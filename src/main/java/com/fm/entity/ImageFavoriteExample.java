package com.fm.entity;

import java.util.ArrayList;
import java.util.List;

public class ImageFavoriteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ImageFavoriteExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFavoriteIdIsNull() {
            addCriterion("favorite_id is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdIsNotNull() {
            addCriterion("favorite_id is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdEqualTo(Integer value) {
            addCriterion("favorite_id =", value, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdNotEqualTo(Integer value) {
            addCriterion("favorite_id <>", value, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdGreaterThan(Integer value) {
            addCriterion("favorite_id >", value, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("favorite_id >=", value, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdLessThan(Integer value) {
            addCriterion("favorite_id <", value, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdLessThanOrEqualTo(Integer value) {
            addCriterion("favorite_id <=", value, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdIn(List<Integer> values) {
            addCriterion("favorite_id in", values, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdNotIn(List<Integer> values) {
            addCriterion("favorite_id not in", values, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdBetween(Integer value1, Integer value2) {
            addCriterion("favorite_id between", value1, value2, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andFavoriteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("favorite_id not between", value1, value2, "favoriteId");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("cust_id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(Integer value) {
            addCriterion("cust_id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(Integer value) {
            addCriterion("cust_id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(Integer value) {
            addCriterion("cust_id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cust_id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(Integer value) {
            addCriterion("cust_id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(Integer value) {
            addCriterion("cust_id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<Integer> values) {
            addCriterion("cust_id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<Integer> values) {
            addCriterion("cust_id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(Integer value1, Integer value2) {
            addCriterion("cust_id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cust_id not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNull() {
            addCriterion("image_id is null");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNotNull() {
            addCriterion("image_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageIdEqualTo(Integer value) {
            addCriterion("image_id =", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotEqualTo(Integer value) {
            addCriterion("image_id <>", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThan(Integer value) {
            addCriterion("image_id >", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("image_id >=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThan(Integer value) {
            addCriterion("image_id <", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThanOrEqualTo(Integer value) {
            addCriterion("image_id <=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdIn(List<Integer> values) {
            addCriterion("image_id in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotIn(List<Integer> values) {
            addCriterion("image_id not in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdBetween(Integer value1, Integer value2) {
            addCriterion("image_id between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("image_id not between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andFavoriteStatusIsNull() {
            addCriterion("favorite_status is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteStatusIsNotNull() {
            addCriterion("favorite_status is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteStatusEqualTo(Integer value) {
            addCriterion("favorite_status =", value, "favoriteStatus");
            return (Criteria) this;
        }

        public Criteria andFavoriteStatusNotEqualTo(Integer value) {
            addCriterion("favorite_status <>", value, "favoriteStatus");
            return (Criteria) this;
        }

        public Criteria andFavoriteStatusGreaterThan(Integer value) {
            addCriterion("favorite_status >", value, "favoriteStatus");
            return (Criteria) this;
        }

        public Criteria andFavoriteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("favorite_status >=", value, "favoriteStatus");
            return (Criteria) this;
        }

        public Criteria andFavoriteStatusLessThan(Integer value) {
            addCriterion("favorite_status <", value, "favoriteStatus");
            return (Criteria) this;
        }

        public Criteria andFavoriteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("favorite_status <=", value, "favoriteStatus");
            return (Criteria) this;
        }

        public Criteria andFavoriteStatusIn(List<Integer> values) {
            addCriterion("favorite_status in", values, "favoriteStatus");
            return (Criteria) this;
        }

        public Criteria andFavoriteStatusNotIn(List<Integer> values) {
            addCriterion("favorite_status not in", values, "favoriteStatus");
            return (Criteria) this;
        }

        public Criteria andFavoriteStatusBetween(Integer value1, Integer value2) {
            addCriterion("favorite_status between", value1, value2, "favoriteStatus");
            return (Criteria) this;
        }

        public Criteria andFavoriteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("favorite_status not between", value1, value2, "favoriteStatus");
            return (Criteria) this;
        }

        public Criteria andBlank1IsNull() {
            addCriterion("blank1 is null");
            return (Criteria) this;
        }

        public Criteria andBlank1IsNotNull() {
            addCriterion("blank1 is not null");
            return (Criteria) this;
        }

        public Criteria andBlank1EqualTo(String value) {
            addCriterion("blank1 =", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1NotEqualTo(String value) {
            addCriterion("blank1 <>", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1GreaterThan(String value) {
            addCriterion("blank1 >", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1GreaterThanOrEqualTo(String value) {
            addCriterion("blank1 >=", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1LessThan(String value) {
            addCriterion("blank1 <", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1LessThanOrEqualTo(String value) {
            addCriterion("blank1 <=", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1Like(String value) {
            addCriterion("blank1 like", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1NotLike(String value) {
            addCriterion("blank1 not like", value, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1In(List<String> values) {
            addCriterion("blank1 in", values, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1NotIn(List<String> values) {
            addCriterion("blank1 not in", values, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1Between(String value1, String value2) {
            addCriterion("blank1 between", value1, value2, "blank1");
            return (Criteria) this;
        }

        public Criteria andBlank1NotBetween(String value1, String value2) {
            addCriterion("blank1 not between", value1, value2, "blank1");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}